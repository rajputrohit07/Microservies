package com.microservices.product_service.service;

import com.microservices.product_service.dto.ProductRequest;
import com.microservices.product_service.dto.ProductResponse;
import com.microservices.product_service.model.Product;
import com.microservices.product_service.repository.ProductRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRespository productRespository;

    public void createProduct(ProductRequest productRequest) {
        log.info("ProductService: Product creation initiated!!!!");
        Product product = Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .build();
        productRespository.save(product);
        log.info("ProductService: Produce created {} ", product.getId());
    }


    public List<ProductResponse> getAllProducts() {
        log.info("ProductService: Getting all the Products");
        List<Product> products = productRespository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .build();
    }

}
