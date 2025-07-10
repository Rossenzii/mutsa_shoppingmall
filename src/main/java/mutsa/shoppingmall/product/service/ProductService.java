package mutsa.shoppingmall.product.service;

import lombok.RequiredArgsConstructor;
import mutsa.shoppingmall.product.dto.productDto;
import mutsa.shoppingmall.product.entity.Product;
import mutsa.shoppingmall.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public List<productDto> getProducts(){
        return productRepository.findAll().stream()
                .map(p -> new productDto(p.getProductsId(),
                        p.getProductsName(),
                        p.getCategory(),
                        p.getPrice(),
                        p.getDescription()))
                .collect(Collectors.toList());
    }
    public productDto getProduct(Long id){
        Product product = productRepository.findByProductsId(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 상품 없음"));
        return new productDto(
                product.getProductsId(),
                product.getProductsName(),
                product.getCategory(),
                product.getPrice(),
                product.getDescription()
        );
    }
    public productDto getProductByName(String name){
        Product product = productRepository.findByProductsName(name)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품 없음"));
        return new productDto(
                product.getProductsId(),
                product.getProductsName(),
                product.getCategory(),
                product.getPrice(),
                product.getDescription()
        );
    }

}
