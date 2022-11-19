package com.irfanstore.product.controller;

import com.irfanstore.product.dto.ProductDto;
import com.irfanstore.product.dto.ProductResponseDto;
import com.irfanstore.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path="/api/product/{id}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Long id) {
        return new ResponseEntity<ProductResponseDto>(productService.getProduct(id), HttpStatus.OK);
    }

    @GetMapping(path="/api/product")
    public ResponseEntity<List<ProductResponseDto>> getProducts() {
        return new ResponseEntity<List<ProductResponseDto>>(productService.getProducts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/product/productcode/{productCode}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponseDto> getByProducCode(@PathVariable String productCode) {
        return new ResponseEntity<ProductResponseDto>(productService.getProduct(productCode.toUpperCase()), HttpStatus.OK);
    }


    @RequestMapping(value = "/api/product",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody ProductDto productDto) throws URISyntaxException
    {

        System.out.println(String.format("REST request to save Product : {%s}",  productDto));
        if (productDto.getId() != null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        ProductResponseDto productCreated = productService.createOrUpdateProduct(productDto);

        return ResponseEntity.created(new URI("/api/product/" + productCreated.getId()))
                .body(productCreated);
    }


    @RequestMapping(value = "/api/product",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponseDto> updateProduct(@Valid @RequestBody ProductDto productDto) throws URISyntaxException
    {
        System.out.println(String.format("REST request to update Product : {%s}", productDto));
        if (productDto.getId() == null)
        {
            return createProduct(productDto);
        }

        ProductResponseDto productUpdatred = productService.createOrUpdateProduct((productDto));
        return ResponseEntity.ok()
                .body(productUpdatred);
    }



    @RequestMapping(value = "/api/product/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id)
    {
        System.out.println(String.format("REST request to delete Product : {%s}", id));
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

}
