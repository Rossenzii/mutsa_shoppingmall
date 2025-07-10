package mutsa.shoppingmall.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class productDto {
    private Long id;
    private String name;
    private String category;
    private Integer price;
    private String description;
}
