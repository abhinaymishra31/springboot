package com.abhinay.product.productapi.controller;


import com.abhinay.product.productapi.domain.Product;
import com.abhinay.product.productapi.dto.UpdateProductColor;
import com.abhinay.product.productapi.dto.UpdateProductPrice;
import com.abhinay.product.productapi.dto.UpdateProductQuantity;
import com.abhinay.product.productapi.servicesimpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @RequestMapping(method=RequestMethod.POST, value="/products")
    public Product addProduct(@RequestBody Product product)
    {
        return (productServiceImpl.addProduct(product));
    }

    /*@RequestMapping(value = "/user", params="userID", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@RequestParam("userID") int id) {*/

    @RequestMapping(method=RequestMethod.PUT, value="/products/{productId}/price")
    public Product updateProductPrice(@PathVariable Long productId, @RequestBody UpdateProductPrice updateProductPrice)
    {
        return productServiceImpl.updateProductPrice(productId,updateProductPrice);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/products/{productId}/color")
    public Product updateProductColor(@RequestBody UpdateProductColor updateProductColor, @PathVariable Long productId)
    {
        return productServiceImpl.updateProductColor(productId,updateProductColor);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/products/buy/{productId}")
    public Product buyProduct(@PathVariable Long productId) // quantity - 1
    {
        return productServiceImpl.buyProduct(productId);
    }

    @PutMapping(value="/products/{productId}/quantity")
    public Product updateProductQuantity(@PathVariable Long productId, @RequestBody UpdateProductQuantity updateProductQuantity)
    {
        return productServiceImpl.updateProductQuantity(productId,updateProductQuantity);
    }

    @RequestMapping(method = RequestMethod.GET, value="/products/{productId}")
    public Product getProduct(@PathVariable Long productId)
    {
        return productServiceImpl.getProduct(productId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    public List<Product> getProducts()
    {
        return productServiceImpl.getProducts();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/products/{productId}")
    public void  deleteProduct(@PathVariable Long productId)
    {
        productServiceImpl.deleteProduct(productId);
    }



}
