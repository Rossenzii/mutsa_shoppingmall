package mutsa.shoppingmall.product.controller;
import lombok.RequiredArgsConstructor;
import mutsa.shoppingmall.product.dto.productDto;
import mutsa.shoppingmall.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<productDto> getProducts(){
        return productService.getProducts();
    }
    @GetMapping("/{id}")
    public productDto getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }
    @GetMapping(params = "name")
    public productDto getProductByName(@RequestParam String name){
        return productService.getProductByName(name);
    }
}
