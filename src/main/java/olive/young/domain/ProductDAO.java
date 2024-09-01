package olive.young.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<ProductEntity, Long> {
}
