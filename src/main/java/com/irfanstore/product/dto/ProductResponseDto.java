package com.irfanstore.product.dto;


import lombok.Data;

import java.io.Serializable;

@Data   //generates @ToString, @EqualsAndHashCode, @Getter / @Setter  automatically at compile time using lambok
public class ProductResponseDto implements Serializable {
    private Long id;
    private String code;
    private String shortDescription;
    private String longDescription;
    private Float productPrice;

    @Override
    public String toString() {
        return "Product {" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription=" + longDescription + '\'' +
                ", productPrice=" + productPrice.toString() +
                '}';
    }
}
