package com.Nk.JobApplication.Review1;

import java.util.List;

public interface ReviewService {
   // List<Review> getAllReviews(Long companiesId);

    List<Review> getALlReviews(Long companiesId);

    boolean addReviews(Long companiesId, Review review);

  //  void addReviews(Long companiesId,Review review);

    Review getReview (Long companiesId, Long reviewId);

   // Review getReview(Long companiesId, Review review);
    boolean updateReview(Long companiesId, Long reviewId, Review review);

    boolean deleteReview(Long companiesId, Long reviewId);
}
