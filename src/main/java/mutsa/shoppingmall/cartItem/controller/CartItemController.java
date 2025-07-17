package mutsa.shoppingmall.cartItem.controller;

import lombok.RequiredArgsConstructor;
import mutsa.shoppingmall.cartItem.dto.AddCartItemRequestDto;
import mutsa.shoppingmall.cartItem.dto.AddCartItemResponseDto;
import mutsa.shoppingmall.cartItem.dto.CartItemResponseDto;
import mutsa.shoppingmall.cartItem.dto.CartResponseDto;
import mutsa.shoppingmall.cartItem.service.CartItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart/items")
public class CartItemController {

    private final CartItemService cartItemService;

    @PostMapping("/{userId}")
    public ResponseEntity<AddCartItemResponseDto> addItem(
            @PathVariable Long userId,
            @RequestBody AddCartItemRequestDto addCartItemRequestDto
    ) {
        AddCartItemResponseDto responseDto = cartItemService.addCartItem(userId, addCartItemRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("{cartItemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long cartItemId) {
        cartItemService.deleteCartItem(cartItemId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<List<CartItemResponseDto>> getCartItems(@PathVariable Long userId) {
        CartResponseDto responseDto = cartItemService.getCartItems(userId);
        return ResponseEntity.ok(responseDto.getCartItems());
    }
}
