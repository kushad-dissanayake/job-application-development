package com.example.reviewmicroservice.data;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Integer companyId);
    boolean addReview(Integer companyId, Review review);

    Review getReview(Integer reviewId);

    boolean updateReview(Integer reviewId, Review review);

    boolean deleteReview(Integer reviewId);
}
