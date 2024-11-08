package com.api.products.service;

import java.util.ArrayList;
import java.util.Optional;

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

    public Product patchProduct(Product product, Long id ){
        Product actualProduct = productRepository.findById(id).get();
        actualProduct.setStock(product.getStock());
        productRepository.save(actualProduct);
        return actualProduct;
    }


    public ArrayList<Product> getProducts(){
        return (ArrayList<Product>)productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).get();
    }

    public Boolean DeleteProduct(Long id){
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Product updateProduct(Product product, Long id){
        Product actualProduct = productRepository.findById(id).get();
        actualProduct.setName(product.getName());
        actualProduct.setDescription(product.getDescription());
        actualProduct.setPrice(product.getPrice());
        actualProduct.setStock(product.getStock());
        actualProduct.setCategory(product.getCategory());
        productRepository.save(actualProduct);
        return actualProduct;
    }

    public ArrayList<Product> getProductsByCategory(String category){
        return productRepository.findByCategory(category);
    }

}
