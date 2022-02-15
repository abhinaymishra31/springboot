package com.springboot.product.productapi.services;

import com.springboot.product.productapi.domain.Product;
import com.springboot.product.productapi.dto.UpdateProductColor;
import com.springboot.product.productapi.dto.UpdateProductPrice;
import com.springboot.product.productapi.dto.UpdateProductQuantity;

import java.util.List;

public interface ProductService {

    Product findByProductId(Long productId);
    Boolean checkIfProductIdNull(Long productId);
    Boolean checkIfProductNull(Product product);
    Product addProduct(Product product);
    Product updateProductPrice(Long productId, UpdateProductPrice updateProductPrice);
    Product updateProductColor(Long productId, UpdateProductColor updateProductColor);
    Product updateProductQuantity(Long productId, UpdateProductQuantity updateProductQuantity);
    Product buyProduct(Long productId); // quantity - 1
    Product getProduct(Long productId);
    List<Product> getProducts();
    void  deleteProduct(Long productId);

}
