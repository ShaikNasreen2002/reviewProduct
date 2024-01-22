/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxttrendz1.repository;

import java.util.*;
import com.example.nxttrendz1.model.*;

// Write your code here
public interface ReviewRepository {
    ArrayList<Review> getReviews();

    Review addReview(Review review);

    Review getReviewById(int reviewId);

    Review updateReview(int reviewId, Review review);

    void deleteReview(int reviewId);

    Product getProductReview(int reviewId);

}