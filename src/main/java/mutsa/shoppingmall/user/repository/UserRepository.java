package mutsa.shoppingmall.user.repository;

import mutsa.shoppingmall.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
