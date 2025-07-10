package mutsa.shoppingmall.product.repository;

import mutsa.shoppingmall.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository <Product, Long> {
    Optional<Product> findByProductsId(Long productsId);
    Optional<Product> findByProductsName(String name);
}
