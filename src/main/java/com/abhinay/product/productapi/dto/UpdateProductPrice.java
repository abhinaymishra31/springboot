package com.abhinay.product.productapi.dto;


public class UpdateProductPrice {
    private Double price;

    public UpdateProductPrice(Double price) {
        this.price = price;
    }

    public UpdateProductPrice() {
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
