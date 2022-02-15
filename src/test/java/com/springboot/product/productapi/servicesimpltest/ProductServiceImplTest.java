package com.springboot.product.productapi.servicesimpltest;


import com.springboot.product.productapi.customexceptions.ColorIsNullException;
import com.springboot.product.productapi.customexceptions.SameColorUpdateException;
import com.springboot.product.productapi.customexceptions.IdIsNullException;
import com.springboot.product.productapi.customexceptions.ProductNotFoundException;
import com.springboot.product.productapi.domain.Product;
import com.springboot.product.productapi.dto.UpdateProductColor;
import com.springboot.product.productapi.dto.UpdateProductPrice;
import com.springboot.product.productapi.dto.UpdateProductQuantity;
import com.springboot.product.productapi.repository.ProductRepository;
import com.springboot.product.productapi.servicesimpl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productServiceImpl;
    @Mock
    private ProductRepository productRepository;

    @Mock
    private UpdateProductQuantity newProductQuantity;



    @BeforeEach
    void setup()
    {
        openMocks(this);
    }



    @Test
    public void updateProductColorTest()
    {
        Product product= new Product(1L,"Mobile","Red",15000.0, 10 );
        Long id=product.getId();
        //assertNotNull(id);
        String productExpectedColor="blue";
        UpdateProductColor newProductColor=new UpdateProductColor(productExpectedColor);
        when(productRepository.findById(id)).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(product);
//        when(newProductColor.getColor()).thenReturn(productExpectedColor);
        Product productActual=productServiceImpl.updateProductColor(product.getId(),newProductColor);
        assertEquals(productExpectedColor,productActual.getColor());
//        verify(productRepository).findById(productExpected.getId()).orElse(null);

    }

    @Test
    public void productNotFoundTest()
    {
        Product product= new Product(1L,"Mobile","Red",15000.0, 10 );
        Long id=product.getId();
        String productExpectedColor="blue";
        UpdateProductColor newProductColor=new UpdateProductColor(productExpectedColor);
        when(productRepository.findById(2L)).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(product);
        assertThrows(ProductNotFoundException.class,()->productServiceImpl.updateProductColor(1l,newProductColor));
    }

    @Test
    public void idIsNullTest()
    {
        Product product= new Product(1L,"Mobile","Red",15000.0, 10 );
        Long id=product.getId();
        String productExpectedColor="blue";
        UpdateProductColor newProductColor=new UpdateProductColor(productExpectedColor);
        when(productRepository.findById(2L)).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(product);
        assertThrows(IdIsNullException.class,()->productServiceImpl.updateProductColor(null,newProductColor));
    }

    @Test
    public void colorIsNullTest()
    {
        Product product= new Product(1L,"Mobile","Red",15000.0, 10 );
        Long id=product.getId();
        String productExpectedColor=null;
        UpdateProductColor newProductColor=new UpdateProductColor(productExpectedColor);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(product);
        assertThrows(ColorIsNullException.class,()->productServiceImpl.updateProductColor(1l,newProductColor));
    }

    @Test
    public void SameColorUpdateTest()
    {
        Product product= new Product(1L,"Mobile","Red",15000.0, 10 );
        Long id=product.getId();
        String productExpectedColor="red";
        UpdateProductColor newProductColor=new UpdateProductColor(productExpectedColor);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(product);
        assertThrows(SameColorUpdateException.class,()->productServiceImpl.updateProductColor(1l,newProductColor));
    }




    @Test
    public void addProductTest()
    {
        Product productExpected= new Product(1L,"Mobile","Red",15000.0, 10 );
        when(productRepository.save(any())).thenReturn(productExpected);
        Product productActual=productServiceImpl.addProduct(productExpected);
        verify(productRepository,times(1)).save(productExpected);
    }

    @Test
    public void updateProductPriceTest()
    {
        Product product= new Product(1L,"Mobile","Red",15000.0, 10 );
        Long id=product.getId();
        Double newPrice= 10000d;
        UpdateProductPrice updateProductPrice=new UpdateProductPrice(newPrice);
        when(productRepository.findById(id)).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(product);
        Product productActual=productServiceImpl.updateProductPrice(product.getId(),updateProductPrice);
        assertEquals(newPrice,productActual.getPrice());
        verify(productRepository, times(1)).findById(product.getId());

    }

    @Test
    public void buyProductTest()
    {
        Product product= new Product(4L,"Mobile","Red",15000.0, 10 );
        Integer expectedQuantity=product.getQuantity()-1;
        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(product);
        Product productActual= productServiceImpl.buyProduct(product.getId());
        assertEquals(expectedQuantity,productActual.getQuantity());

    }

    @Test
    public void getProductTest()
    {
        Product product= new Product(4L,"Mobile","Red",15000.0, 10 );
        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        Product productActual=productServiceImpl.getProduct(product.getId());
        assertEquals(product.getId(),productActual.getId());
        assertThat(productActual).usingRecursiveComparison().isEqualTo(product);
    }

    @Test
    public void getProductsTest()
    {
        List<Product> products=new ArrayList<>(Arrays.asList(
                new Product(1l,"m1","c1",100d,10),
                new Product(2l,"m2","c2",200d,20),
                new Product(3l,"m3","c3",300d,30)
        ));
        when(productRepository.findAll()).thenReturn(products);
        List<Product> productsActual=productServiceImpl.getProducts();
//        productsActual.add(new Product(4L,"m4","c4",400d,40));
        assertTrue(products.equals(productsActual));

    }

    @Test
    public void deleteProductTest()
    {
//        One way of doing mock on void methods
        /*doAnswer(invocation -> invocation.getArgument(0))
                .when(productRepository).deleteById(anyLong());*/

        doReturn(true).when(productRepository).deleteById(anyLong());

        productServiceImpl.deleteProduct(anyLong());

        verify(productRepository,times(1)).deleteById(anyLong());

    }

    @Test
    public void updateProductQuantityTest()
    {
        Product product= new Product(4L,"Mobile","Red",15000.0, 10 );
        UpdateProductQuantity updateProductQuantity=new UpdateProductQuantity(11);
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(product);
        Product productActual=productServiceImpl.updateProductQuantity(product.getId(),updateProductQuantity);
        assertEquals(updateProductQuantity.getQuantity(),productActual.getQuantity());
        verify(productRepository,times(1)).save(any());
    }

//    @Test
//    public void productFoundTest()
//    {
//
//    }

//    hello all this is to check how we can update the things




}
