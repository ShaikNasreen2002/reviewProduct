/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */
package com.example.nxttrendz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.repository.ProductJpaRepository;
import com.example.nxttrendz1.repository.ProductRepository;

// Write your code here
@Service
public class ProductJpaService implements ProductRepository {
    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Override
    public ArrayList<Product> getProducts() {
        List<Product> pList = productJpaRepository.findAll();
        ArrayList<Product> products = new ArrayList<>(pList);
        return products;
    }

    @Override
    public Product addProduct(Product p) {
        productJpaRepository.save(p);
        return p;
    }

    @Override
    public Product getProductById(int productId) {
        try {
            Product p = productJpaRepository.findById(productId).get();
            return p;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Product updateProduct(int productId, Product product) {
        try {
            Product p = productJpaRepository.findById(productId).get();
            if (product.getProductName() != null) {
                p.setProductName(product.getProductName());
            }
            if (product.getPrice() != 0.0) {
                p.setPrice(product.getPrice());
            }
            productJpaRepository.save(p);
            return p;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteProduct(int productId) {
        try {
            productJpaRepository.deleteById(productId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
}