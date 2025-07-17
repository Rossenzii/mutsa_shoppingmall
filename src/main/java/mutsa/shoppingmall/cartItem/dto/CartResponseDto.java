package mutsa.shoppingmall.cartItem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CartResponseDto {
    private List<CartItemResponseDto> cartItems;
    private int cartTotalPrice;
    private int cartTotalItems;

}
