package olive.young.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = Controller.class)
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductDAO productDAO;

    @Test
    @DisplayName("GET /main should return the product list")
    public void getProductList_returnsProductList() throws Exception {
        // 샘플 데이터 생성
        ProductEntity product = ProductEntity.builder()
                .imageURL("imageURL")
                .productName("Product Name")
                .productPrice(1000)
                .sale(10)
                .isLiked(false)
                .build();

        given(productDAO.findAll()).willReturn(List.of(product));

        // MockMvc를 통해 GET 요청을 보내고 응답을 검증
        mockMvc.perform(get("/main"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].imageURL").value(product.getImageURL()))
                .andExpect(jsonPath("$[0].productName").value(product.getProductName()))
                .andExpect(jsonPath("$[0].productPrice").value(product.getProductPrice()))
                .andExpect(jsonPath("$[0].sale").value(product.getSale()))
                .andExpect(jsonPath("$[0].isLiked").value(product.getIsLiked()));
    }

    @Test
    @DisplayName("POST /main/liked/{imageId} should update the liked status")
    public void like_updatesLikedStatus() throws Exception {
        // 샘플 데이터 생성
        ProductEntity product = ProductEntity.builder()
                .imageURL("imageURL")
                .productName("Product Name")
                .productPrice(1000)
                .sale(10)
                .isLiked(false)
                .build();

        product.setId(1L);

        given(productDAO.findById(anyLong())).willReturn(Optional.of(product));

        // MockMvc를 통해 POST 요청을 보내고 응답을 검증
        mockMvc.perform(post("/main/liked/1"))
                .andExpect(status().isOk());

        // 좋아요 상태가 반전되었는지 확인
        product.updateIsLiked();  // 좋아요 상태 반전
        BDDMockito.verify(productDAO).findById(1L);  // ID로 조회되는지 확인
    }
}
