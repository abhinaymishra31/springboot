package com.springboot.product.productapi.customexceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String message) {
        super(message);
    }

    @Override
    public String toString()
    {
        return "Product not found...";
    }
}
