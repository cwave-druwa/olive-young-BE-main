package olive.young.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/main")
@Transactional
public class Controller {
    private final ProductDAO productDAO;

    @GetMapping
    public List<ProductDetailDTO> getProductList() {

        return productDAO.findAll().stream()
                .map(productEntity -> new ProductDetailDTO(
                        productEntity.getId(),
                        productEntity.getImageURL(),
                        productEntity.getProductName(),
                        productEntity.getProductPrice(),
                        productEntity.getSale(),
                        productEntity.getIsLiked()))
                .toList();
    }

    @PostMapping("/liked/{imageId}")
    public void like(@PathVariable Long imageId) throws Exception {
        ProductEntity product = productDAO.findById(imageId).orElseThrow(() -> new Exception("ID에 해당하는 제품이 없습니다."));

        product.updateIsLiked();
    }
}
