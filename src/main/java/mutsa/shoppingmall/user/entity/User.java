package mutsa.shoppingmall.user.entity;

import jakarta.persistence.*;
import lombok.*;
import mutsa.shoppingmall.cartItem.entity.Cart;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;
    private String nickName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;

    private LocalDateTime createAt;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;

    @PrePersist
    protected void onCreate() {
        this.createAt = LocalDateTime.now();
    }
}
