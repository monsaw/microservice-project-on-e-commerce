package com.hommies.productservice.dto;


import lombok.*;

import java.math.BigDecimal;

@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Builder
public class ProductResponse {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
