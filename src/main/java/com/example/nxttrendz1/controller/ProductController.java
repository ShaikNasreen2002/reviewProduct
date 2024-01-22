/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */
package com.example.nxttrendz1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.nxttrendz1.service.*;
import com.example.nxttrendz1.model.*;
import java.util.*;

// Write your code here
@RestController
public class ProductController {
    @Autowired
    private ProductJpaService ps;

    @GetMapping("/products")
    public ArrayList<Product> getProducts() {
        return ps.getProducts();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return ps.addProduct(product);
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable("productId") int productId) {
        return ps.getProductById(productId);
    }

    @PutMapping("/products/{productId}")
    public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
        return ps.updateProduct(productId, product);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable("productId") int productId) {
        ps.deleteProduct(productId);
    }

}