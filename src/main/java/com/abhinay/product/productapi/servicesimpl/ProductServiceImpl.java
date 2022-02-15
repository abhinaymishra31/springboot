package com.abhinay.product.productapi.servicesimpl;

import com.abhinay.product.productapi.customexceptions.*;
import com.abhinay.product.productapi.domain.Product;
import com.abhinay.product.productapi.dto.UpdateProductColor;
import com.abhinay.product.productapi.dto.UpdateProductPrice;
import com.abhinay.product.productapi.dto.UpdateProductQuantity;
import com.abhinay.product.productapi.repository.ProductRepository;
import com.abhinay.product.productapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProductPrice(Long productId, UpdateProductPrice updateProductPrice) {
        Product productUpdate=productRepository.findById(productId).orElse(null);
        productUpdate.setPrice(updateProductPrice.getPrice());
        return productRepository.save(productUpdate);
    }

    @Override
    public Product updateProductColor(Long productId,UpdateProductColor updateProductColor) {

        /*if(productId==null)
        {
            throw new IdIsNullException("Id should not be null");
        }*/
        checkIfProductIdNull(productId);
//        Product productUpdate=productRepository.findById(productId).get();
        Product productUpdate = findByProductId(productId);
        if(updateProductColor.getColor()==null)
        {
            throw new ColorIsNullException("Color should not be null");
        }
        if(productUpdate.getColor().equalsIgnoreCase(updateProductColor.getColor()))
        {
            throw new SameColorUpdateException("same color is provided again");
        }
        productUpdate.setColor(updateProductColor.getColor());


        return productRepository.save(productUpdate);
    }

    @Override
    public Product buyProduct(Long productId) {

        Product product=findByProductId(productId);
        product.setQuantity(product.getQuantity()-1);
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(Long productId) {

        Product product=findByProductId(productId);
        return product;
    }

    @Override
    public List<Product> getProducts() {

        List<Product> products= new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public void deleteProduct(Long productId) {

        productRepository.deleteById(productId);

    }

    @Override
    public Product updateProductQuantity(Long productId, UpdateProductQuantity updateProductQuantity) {

        Product product=findByProductId(productId);
        product.setQuantity(updateProductQuantity.getQuantity());
        return productRepository.save(product);
    }

    @Override
    public Product findByProductId(Long productId)
    {
        return productRepository.findById(productId).orElseThrow(()->new ProductNotFoundException("Product not found with givven Id"));
    }

    @Override
    public Boolean checkIfProductIdNull(Long productId)
    {
        if(productId==null)
        {
            throw new IdIsNullException("Id should not be null");
        }
        return false;
    }

    @Override
    public Boolean checkIfProductNull(Product product) {

        if(product==null)
        {
            throw new ProductIsNullException("Product is null");
        }
        return false;
    }


}
