package com.irfanstore.product.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Product")
@Data
public class Product implements Serializable {

    public Product() {

    }


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="product_code")
    private String code;

    @Column(name="short_description")
    private String shortDescription;

    @Column(name="long_description")
    private String longDescription;

    @Column(name="product_price")
    private Float productPrice;


    @Override
    public String toString() {
        return "Product {" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription=" + longDescription + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
