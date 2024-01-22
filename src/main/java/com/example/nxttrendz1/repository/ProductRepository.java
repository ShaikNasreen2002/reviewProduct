/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */
package com.example.nxttrendz1.repository;

import java.util.*;
import com.example.nxttrendz1.model.*;

// Write your code here
public interface ProductRepository {
    ArrayList<Product> getProducts();

    Product addProduct(Product product);

    Product getProductById(int productId);

    Product updateProduct(int productId, Product product);

    void deleteProduct(int productId);

}