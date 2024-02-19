package com.Nk.JobApplication.Review1.impl;

import com.Nk.JobApplication.Companies.CompaniesEntity;
import com.Nk.JobApplication.Companies.CompaniesService;
import com.Nk.JobApplication.Review1.Review;
import com.Nk.JobApplication.Review1.ReviewRepository;
import com.Nk.JobApplication.Review1.ReviewService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ReviewServiceImp implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompaniesService companiesService;

    public ReviewServiceImp(ReviewRepository reviewRepository, CompaniesService companiesService) {
        this.reviewRepository = reviewRepository;
        this.companiesService = companiesService;
    }

    @Override
    public List<Review> getALlReviews(Long companiesId) {
        if (reviewRepository != null) {
            return reviewRepository.findByCompaniesId(companiesId);
        } else {
            // Handle the case where reviewRepository is not initialized
            return Collections.emptyList(); // or throw an exception, log a message, etc.
        }
    }

    @Override
    public boolean addReviews(Long companiesId, Review review) {
        CompaniesEntity companiesEntity = companiesService.getCompanyById(companiesId);
        if (companiesEntity != null) {
            review.setCompanies(companiesEntity);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companiesId, Long reviewId) {
      List<Review> reviews= reviewRepository.findByCompaniesId(companiesId);
      return reviews.stream().
              filter(review -> review.
                      getId().
                      equals(reviewId)).
                        findFirst().
                          orElse(null);
    }

    @Override
    public boolean updateReview(Long companiesId, Long reviewId, Review updatedreview) {
        if (companiesService.getCompanyById(companiesId)!=null) {
            updatedreview.setCompanies(companiesService.getCompanyById(companiesId));
            updatedreview.setId(reviewId);
            reviewRepository.save(updatedreview);
            return  true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long companiesId, Long reviewId) {
if (companiesService.getCompanyById(companiesId)!=null&&reviewRepository.existsById(reviewId)) {
    Review review =reviewRepository.findById(reviewId).orElse(null);
    CompaniesEntity companiesEntity  =review.getCompanies();
    companiesEntity.getReviews().remove(review);
    review.setCompanies(null);
    companiesService.updateCompany(companiesId, companiesEntity);
    reviewRepository.deleteById(reviewId);
    return true;

}
return false;
    }


}
