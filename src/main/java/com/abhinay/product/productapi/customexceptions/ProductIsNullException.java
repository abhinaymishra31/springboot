package com.abhinay.product.productapi.customexceptions;

public class ProductIsNullException extends RuntimeException{

    public ProductIsNullException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "ProductIsNullException{}";
    }
}
