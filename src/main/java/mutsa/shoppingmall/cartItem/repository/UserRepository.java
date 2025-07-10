package mutsa.shoppingmall.cartItem.repository;

import mutsa.shoppingmall.cartItem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
