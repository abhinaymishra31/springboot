package com.springboot.product.productapi.repository;

import com.springboot.product.productapi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

//    @Query(value = "insert into product values (5,'dell laptop','white',40000,15)", nativeQuery = true)
//    public Product insertProduct();



}
