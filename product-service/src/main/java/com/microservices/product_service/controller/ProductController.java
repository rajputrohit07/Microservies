package com.microservices.product_service.controller;

import com.microservices.product_service.dto.ProductRequest;
import com.microservices.product_service.dto.ProductResponse;
import com.microservices.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        log.info("ProductController: Created Product Called()!!!!!!");
        productService.createProduct(productRequest);

    }

    @GetMapping
    public List<ProductResponse> getProducts(){
        log.info("ProductController: Get All Products called()!!!!!!");
        return productService.getAllProducts();
    }

}
