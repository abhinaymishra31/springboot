package com.abhinay.product.productapi.dto;

public class UpdateProductColor {
    private String color;

    public UpdateProductColor(String color) {
        this.color = color;
    }

    public UpdateProductColor() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
