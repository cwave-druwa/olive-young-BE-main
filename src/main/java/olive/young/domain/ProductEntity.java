package olive.young.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    @Column(name = "imageurl", length = 2048)
    private String imageURL;

    private String productName;

    private Integer productPrice;

    private Integer sale;

    @ColumnDefault("false")
    private Boolean isLiked;

    @Builder
    public ProductEntity(String imageURL, String productName, Integer productPrice, Integer sale, boolean isLiked) {
        this.imageURL = imageURL;
        this.productName = productName;
        this.productPrice = productPrice;
        this.sale = sale;
        this.isLiked = isLiked;
    }

    public void updateIsLiked() {
        this.isLiked = !this.isLiked;
    }
}
