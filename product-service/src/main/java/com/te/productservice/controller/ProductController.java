package com.te.productservice.controller;


import com.te.productservice.entity.Product;
import com.te.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {


    @Autowired
    private ProductService productService;


    @GetMapping
    public ResponseEntity<List<Product>> listAllProducts() {
        List<Product> products = productService.listAllProduct();
        if ( products.isEmpty())  {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Product productDB = productService.getProduct(id);
        if ( null == productDB ) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(productDB);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        Product productDB = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDB);
    }
}
