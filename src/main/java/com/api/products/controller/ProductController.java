package com.api.products.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.products.model.Product;
import com.api.products.service.ProductService;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/saveProduct")
    public Product createProduct (@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PatchMapping ("/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id){
        return productService.updaProduct(product, id);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct (@PathVariable Long id){
        Boolean ok = productService.DeleteProduct(id);
        if(ok){
            return "to posi";
        }else{
            return "no ta posi";
        }
    }

    @GetMapping("/products")
    public ArrayList<Product> getAllProducts(){
        return productService.getProducts();
    }


}
