package OnlineShoping.repository;

import OnlineShoping.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductsRepository extends JpaRepository<Products, Long> , JpaSpecificationExecutor<Products> {
}
