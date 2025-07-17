package mutsa.shoppingmall.cartItem.repository;


import mutsa.shoppingmall.cartItem.entity.Cart;
import mutsa.shoppingmall.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(User user);
}
