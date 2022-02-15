package com.springboot.product.productapi.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping
    public String sayHello()
    {
        return "Welcome Abhinay...Its the localhost page";
    }

}
