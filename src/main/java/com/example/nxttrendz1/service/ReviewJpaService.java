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

// Write your code here
package com.example.nxttrendz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.model.Review;
import com.example.nxttrendz1.repository.ProductJpaRepository;
import com.example.nxttrendz1.repository.ReviewJpaRepository;
import com.example.nxttrendz1.repository.ReviewRepository;
import com.example.nxttrendz1.repository.ProductRepository;

// Write your code here
@Service
public class ReviewJpaService implements ReviewRepository {
    @Autowired
    private ReviewJpaRepository reviewJpaRepository;
    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Override
    public ArrayList<Review> getReviews() {
        List<Review> rList = reviewJpaRepository.findAll();
        ArrayList<Review> reviews = new ArrayList<>(rList);
        return reviews;
    }

    @Override
    public Review addReview(Review review) {
        Product product = review.getProduct();
        int productId = product.getProductId();
        try {
            Product existing = productJpaRepository.findById(productId).get();
            review.setProduct(existing);
            reviewJpaRepository.save(review);
            return review;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Potentially wrong productId");
        }
    }

    @Override
    public Review getReviewById(int reviewId) {
        try {
            Review r = reviewJpaRepository.findById(reviewId).get();
            return r;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Review updateReview(int reviewId, Review review) {
        try {
            Review existing = reviewJpaRepository.findById(reviewId).get();
            if (review.getReviewContent() != null) {
                existing.setReviewContent(review.getReviewContent());
            }
            if (review.getRating() != 0) {
                existing.setRating(review.getRating());
            }
            if (review.getProduct() != null) {
                Product p = review.getProduct();
                int pId = p.getProductId();
                Product newProduct = productJpaRepository.findById(pId).get();
                review.setProduct(newProduct);
            }
            reviewJpaRepository.save(review);
            return review;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteReview(int reviewId) {
        try {
            reviewJpaRepository.deleteById(reviewId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Product getProductReview(int reviewId) {
        try {
            Review review = reviewJpaRepository.findById(reviewId).get();
            Product p = review.getProduct();
            return p;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}