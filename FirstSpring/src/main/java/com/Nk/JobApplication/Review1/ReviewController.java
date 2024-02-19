package com.Nk.JobApplication.Review1;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companiesId}")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>>getALLReviews(@PathVariable Long companiesId)
    {
        return new ResponseEntity<>(reviewService.getALlReviews(companiesId), HttpStatus.OK);
    }
    @PostMapping("/reviews")
    public ResponseEntity<String> addReviews(@PathVariable Long companiesId, @RequestBody Review review) {
        boolean isReview = reviewService.addReviews(companiesId, review);
        if (isReview) {
            return new ResponseEntity<>("Review Added Successfully", HttpStatus.OK);
        } else {

            return new ResponseEntity<>("Review  Not Saved", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<?> getReview(@PathVariable Long companiesId, @PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.getReview(companiesId, reviewId),HttpStatus.OK);

    }
    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<?> updateReview(@PathVariable Long companiesId, @PathVariable Long reviewId, @RequestBody Review review) {
        boolean isReviewedUpdate = reviewService.updateReview(companiesId, reviewId, review);
        if (isReviewedUpdate) {
            return new ResponseEntity<>("Review updated Successfully", HttpStatus.OK);
        }
        else {
            return  new ResponseEntity<>("Review Not  updated Successfully", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable Long companiesId, @PathVariable Long reviewId) {
        boolean isReviewDeleted = reviewService.deleteReview(companiesId, reviewId);
        if (isReviewDeleted) {
            return new ResponseEntity<>("Review Deleted Successfully", HttpStatus.OK);
        }
        else {
            return  new ResponseEntity<>("Review Not Deleted Successfully!!!!!!!!!!!!!!!!!", HttpStatus.NOT_FOUND);
        }
    }
}



