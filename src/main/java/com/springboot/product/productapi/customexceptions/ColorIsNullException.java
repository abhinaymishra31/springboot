package com.springboot.product.productapi.customexceptions;

public class ColorIsNullException extends RuntimeException{

    public ColorIsNullException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Color Is Null Exception";
    }
}
