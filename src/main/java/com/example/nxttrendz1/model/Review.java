/*
 *
 * You can use the following import statements
 * 
 * import javax.persistence.*;
 * 
 */
package com.example.nxttrendz1.model;

import com.example.nxttrendz1.model.Product;
import javax.persistence.*;

// Write your code here
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewid")
    private int reviewId;
    @Column(name = "reviewcontent")
    private String reviewContent;
    @Column(name = "rating")
    private int rating;
    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;

    // private int productId;
    public Review() {
    }

    public Review(int reviewId, String reviewContent, int rating) {
        this.reviewId = reviewId;
        this.reviewContent = reviewContent;
        this.rating = rating;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}