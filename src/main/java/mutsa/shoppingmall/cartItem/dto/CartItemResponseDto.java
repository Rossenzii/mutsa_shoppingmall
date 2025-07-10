package mutsa.shoppingmall.cartItem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mutsa.shoppingmall.cartItem.entity.CartItem;

@Getter
@AllArgsConstructor

public class CartItemResponseDto {
    private Long cartItemid;
    private String productName;
    private int quantity;
    private int totalPrice;

    public static CartItemResponseDto fromEntity(CartItem cartItem) {
        return new CartItemResponseDto(
                cartItem.getCartItemId(),
                cartItem.getProduct().getProductsName(),
                cartItem.getQuantity(),
                cartItem.getTotalPrice()
        );
    }
}
