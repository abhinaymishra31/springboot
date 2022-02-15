package com.abhinay.product.productapi.dto;

public class UpdateProductQuantity {

    private Integer quantity;

    public UpdateProductQuantity() {
    }

    public UpdateProductQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
