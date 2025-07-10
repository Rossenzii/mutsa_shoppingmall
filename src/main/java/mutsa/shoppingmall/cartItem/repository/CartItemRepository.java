package mutsa.shoppingmall.cartItem.repository;


import mutsa.shoppingmall.cartItem.entity.Cart;
import mutsa.shoppingmall.cartItem.entity.CartItem;
import mutsa.shoppingmall.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByCartAndProduct(Cart cart, Product product);
    List<CartItem> findAllByCart(Cart cart);
}
