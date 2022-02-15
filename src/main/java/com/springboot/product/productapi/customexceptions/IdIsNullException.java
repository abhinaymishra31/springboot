package com.springboot.product.productapi.customexceptions;

public class IdIsNullException extends RuntimeException{

    public IdIsNullException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "id should not be null";
    }
}
