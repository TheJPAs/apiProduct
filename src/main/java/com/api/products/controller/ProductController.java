package com.api.products.controller;

import java.util.ArrayList;
import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.products.model.Product;
import com.api.products.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(path = "/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public Product createProduct (@Valid @RequestBody Product product){
        return productService.createProduct(product);
    }

    @PatchMapping (path = "/{id}")
    public Product patchProduct(@RequestBody Product product, @PathVariable Long id){
        return productService.patchProduct(product, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteProduct (@PathVariable Long id){
        Boolean ok = productService.DeleteProduct(id);
        if(ok){
            return "to posi";
        }else{
            return "no ta posi";
        }
    }

    @GetMapping
    public ArrayList<Product> getAllProducts(){
        return productService.getProducts();
    }

    @GetMapping(path = "/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PutMapping (path = "/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id){
        return productService.updateProduct(product, id);
    }

    @GetMapping ("/filter/{category}")
    public ArrayList<Product> getProductByCategory(@PathVariable String category){
        return productService.getProductsByCategory(category);
    }
}
