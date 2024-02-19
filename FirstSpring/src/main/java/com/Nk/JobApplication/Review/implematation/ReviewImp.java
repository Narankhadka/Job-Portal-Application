//package com.Nk.JobApplication.Review.implematation;
//
//import com.Nk.JobApplication.Review.Review;
//import com.Nk.JobApplication.Review.ReviewRepository;
//import com.Nk.JobApplication.Review.ReviewService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
////@Service
//public class ReviewImp implements ReviewService {
//    private ReviewRepository reviewRepository;
//
//    public ReviewImp(ReviewRepository reviewRepository) {
//        this.reviewRepository = reviewRepository;
//    }
//
//    @Override
//    public  List<Review> getALLReviews(Long companyId) {
//        List<Review>reviews=reviewRepository.findByCompanyId(companyId);
//        return reviews;
//    }
//}
