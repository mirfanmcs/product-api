package com.irfanstore.product.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDto implements Serializable {

    public ProductDto() {

    }

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
                ", longDescription=" + longDescription  + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
