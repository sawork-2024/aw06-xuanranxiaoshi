package com.example.webposorderservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description:
 * @author：jimi
 * @date: 2024/5/15
 * @Copyright：
 */

@Controller
public class ProductResource {

    @Autowired
    ProductService productService;

    @GetMapping("/product/pi")
    public ResponseEntity<Long> getPi(){
        return new ResponseEntity<>(productService.getPi(), HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable String productId){
        return new ResponseEntity<>(productService.getProduct(productId), HttpStatus.OK);
    }
}
