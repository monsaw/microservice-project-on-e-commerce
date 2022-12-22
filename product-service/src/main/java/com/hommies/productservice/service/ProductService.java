package com.hommies.productservice.service;

import com.hommies.productservice.dto.ProductRequest;
import com.hommies.productservice.dto.ProductResponse;
import com.hommies.productservice.model.Product;
import com.hommies.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequest productRequest) {
        Product product = productRepository.save(Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .build());
        log.info("Product with id : {} has been saved ", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> output = new ArrayList<>();
        for(Product product : productRepository.findAll()){
            output.add(mapToProductResponse(product));
        }
        return output;
//        return productRepository.findAll().stream()
//                .map(this::mapToProductResponse).toList();
    }

    public ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .build();
    }
}


