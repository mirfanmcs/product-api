package com.irfanstore.product.service;

import com.irfanstore.product.dto.ProductResponseDto;
import com.irfanstore.product.entity.Product;
import com.irfanstore.product.dto.ProductDto;
import com.irfanstore.product.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public List<ProductResponseDto> getProducts()
    {
        List<Product> products = productRepository.findAll();
        Type listType = new TypeToken<List<ProductResponseDto>>() {}.getType();
        List<ProductResponseDto> productsResponseDto =  modelMapper.map(products, listType);
        return productsResponseDto;
    }

    public ProductResponseDto getProduct(long id) {

        Product product = productRepository.findById(id);

        //Product product = productRepository.findOne(id);

        ProductResponseDto productResponseDto =  modelMapper.map(product, ProductResponseDto.class);
        return productResponseDto;
    }



    public ProductResponseDto getProduct(String productCode) {
        Product product = productRepository.findByProductCode(productCode);
        ProductResponseDto productResponseDto =  modelMapper.map(product, ProductResponseDto.class);
        return productResponseDto;
    }

    public ProductResponseDto createOrUpdateProduct(ProductDto productDto) {
        Product product =  modelMapper.map(productDto, Product.class);
        Product productCreated = productRepository.save(product);
        ProductResponseDto productResponseDto =  modelMapper.map(productCreated, ProductResponseDto.class);
        return productResponseDto;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
        //productRepository.delete(id);

    }

}
