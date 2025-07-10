package mutsa.shoppingmall.cartItem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class AddCartItemResponseDto {
    private Long cartItemId;
    private String productName;
    private int quantity;
    private int totalPrice;
}
