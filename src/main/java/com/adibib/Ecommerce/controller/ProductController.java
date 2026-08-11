package com.adibib.Ecommerce.controller;


import com.adibib.Ecommerce.entity.Product;
import com.adibib.Ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
    final private ProductService service;
    @Autowired
    ProductController(ProductService service){this.service=service;}

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(service.getAllProducts());
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable int id){
        return ResponseEntity.ok(service.getProductById(id));
    }
    @PostMapping ("/products")
    public  ResponseEntity<?>  createProduct(@RequestBody Product product){
        service.updateProduct(product);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/products")
    public  ResponseEntity<?> updateProduct(@RequestBody Product product){
        service.updateProduct(product);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id){
        service.deleteProductById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String name){
        return ResponseEntity.ok(service.searchProducts(name));
    }

}
