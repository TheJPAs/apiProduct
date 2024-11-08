package com.api.products.repository;

import com.api.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;


@Repository
public interface IProductRepository extends JpaRepository<Product, Long>{
    //@Query ("select p from Product p where p.category = :category")
    //ArrayList<Product> productByCategory(String category);

    ArrayList<Product> findByCategory(String category);
}
