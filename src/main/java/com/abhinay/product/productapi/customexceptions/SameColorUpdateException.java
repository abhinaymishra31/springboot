package com.abhinay.product.productapi.customexceptions;

public class SameColorUpdateException extends RuntimeException{

    public SameColorUpdateException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Color is Not Updated Exception";
    }
}
