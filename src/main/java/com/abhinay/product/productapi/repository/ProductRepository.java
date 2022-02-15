package com.abhinay.product.productapi.repository;

import com.abhinay.product.productapi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface ProductRepository extends JpaRepository<Product, Long> {

//    @Query(value = "insert into product values (5,'dell laptop','white',40000,15)", nativeQuery = true)
//    public Product insertProduct();



}
