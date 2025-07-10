package mutsa.shoppingmall.cartItem.service;
import lombok.RequiredArgsConstructor;
import mutsa.shoppingmall.cartItem.dto.AddCartItemRequestDto;
import mutsa.shoppingmall.cartItem.dto.AddCartItemResponseDto;
import mutsa.shoppingmall.cartItem.dto.CartItemResponseDto;
import mutsa.shoppingmall.cartItem.dto.CartResponseDto;
import mutsa.shoppingmall.cartItem.entity.Cart;
import mutsa.shoppingmall.cartItem.entity.CartItem;
import mutsa.shoppingmall.cartItem.repository.CartItemRepository;
import mutsa.shoppingmall.product.entity.Product;
import mutsa.shoppingmall.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartItemService {
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final CartService cartService;

    public AddCartItemResponseDto addCartItem(Long userId, AddCartItemRequestDto addCartItemRequestDto) {
        Cart cart = cartService.getOrCreateCartByUserId(userId);

        Product product = productRepository.findById(addCartItemRequestDto.getProductId())
                .orElseThrow(()->new IllegalArgumentException("Product not found"));

        Optional<CartItem> cartItemOptional = cartItemRepository.findByCartAndProduct(cart, product);
        CartItem cartItem;

        if (cartItemOptional.isPresent()) {
            cartItem = cartItemOptional.get();
            cartItem.addQuantity(addCartItemRequestDto.getQuantity());
        } else {
            cartItem = CartItem.builder()
                    .cart(cart)
                    .product(product)
                    .quantity(addCartItemRequestDto.getQuantity())
                    .build();
        }

        CartItem savedCartItem = cartItemRepository.save(cartItem);

        return new AddCartItemResponseDto(
                savedCartItem.getCartItemId(),
                savedCartItem.getProduct().getProductsName(),
                savedCartItem.getQuantity(),
                savedCartItem.getTotalPrice()
        );

    }
    public CartResponseDto getCartItems(Long userId) {
        Cart cart = cartService.findCartByUserId(userId);
        List<CartItem> cartItems = cartItemRepository.findAllByCart(cart);

        List<CartItemResponseDto> cartItemResponseDtos = cartItems.stream()
                .map(CartItemResponseDto::fromEntity)
                .toList();
        int totalItems = cartItemResponseDtos.size();
        int totalPrice = cartItemResponseDtos.stream().mapToInt(CartItemResponseDto::getQuantity).sum();

        return new CartResponseDto(cartItemResponseDtos, totalItems, totalPrice);

    }
    public void deleteCartItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }
}
