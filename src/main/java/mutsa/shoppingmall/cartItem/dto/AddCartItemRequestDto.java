package mutsa.shoppingmall.cartItem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddCartItemRequestDto {
    private Long productId;
    private int quantity;
}
