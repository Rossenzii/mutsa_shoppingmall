package mutsa.shoppingmall.cartItem.entity;

import jakarta.persistence.*;
import lombok.*;
import mutsa.shoppingmall.product.entity.Product;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "cartItem")
@Getter
@AllArgsConstructor
@Builder

public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cartId")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private Product product;

    private int quantity;

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public int getTotalPrice() {
        return product.getPrice()*quantity;
    }

}
