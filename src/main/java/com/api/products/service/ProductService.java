package com.api.products.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.products.model.Product;
import com.api.products.repository.IProductRepository;

@Service
public class ProductService {

    @Autowired
    IProductRepository productRepository;

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product updaProduct(Product product, Long id ){
        Product actualProduct = productRepository.findById(id).get();
        actualProduct.setStock(product.getStock());
        productRepository.save(actualProduct);
        return actualProduct;
    }


    public ArrayList<Product> getProducts(){
        return (ArrayList<Product>)productRepository.findAll();
    }

    public Boolean DeleteProduct(Long id){
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }    
}
