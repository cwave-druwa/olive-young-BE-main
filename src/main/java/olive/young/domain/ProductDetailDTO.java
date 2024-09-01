package olive.young.domain;

public record ProductDetailDTO(
        Long id,
        String imageURL,
        String productName,
        Integer productPrice,
        Integer sale,
        boolean isLiked
){
}
