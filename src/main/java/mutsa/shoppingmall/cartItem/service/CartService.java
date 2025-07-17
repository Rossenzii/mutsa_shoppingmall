package mutsa.shoppingmall.cartItem.service;
import lombok.RequiredArgsConstructor;
import mutsa.shoppingmall.cartItem.entity.Cart;
import mutsa.shoppingmall.user.entity.User;
import mutsa.shoppingmall.cartItem.repository.CartRepository;
import mutsa.shoppingmall.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final UserService userService;

    public Cart getOrCreateCartByUserId(Long userId) {
        User user = userService.findByUserId(userId);

        return cartRepository.findByUser(user)
                .orElseGet(()->cartRepository.save(Cart.builder().user(user).build()));
    }

    public Cart findCartByUserId(Long userId) {
        User user = userService.findByUserId(userId);
        return cartRepository.findByUser(user)
                .orElseThrow(()->new IllegalArgumentException("Cart not found"));
    }
}
