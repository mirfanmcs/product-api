package com.irfanstore.product.repository;

import com.irfanstore.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("select p from  Product p where p.code = ?1")
    Product findByProductCode(String productCode);
    @Query("select p from  Product p where p.id = ?1")
    Product findById(long id);


}
