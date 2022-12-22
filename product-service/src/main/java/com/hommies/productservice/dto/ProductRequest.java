package com.hommies.productservice.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Setter
@Getter @AllArgsConstructor @NoArgsConstructor
@Builder
public class ProductRequest {

    private String name;
    private String description;
    private BigDecimal price;
}
