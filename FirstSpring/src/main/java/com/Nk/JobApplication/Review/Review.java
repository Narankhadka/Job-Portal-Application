//package com.Nk.JobApplication.Review;
//
//import com.Nk.JobApplication.Companies.CompaniesEntity;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//
//@Entity
//public class Review {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String title;
//    private String description;
//    private  double rating;
//    @JsonIgnore
//    @ManyToOne
//
//    private CompaniesEntity companies;
//
//    public CompaniesEntity getCompanies() {
//        return companies;
//    }
//
//    public void setCompanies(CompaniesEntity companies) {
//        this.companies = companies;
//    }
//
//    public Review() {
//    }
//
//    public Review(Long id, String title, String description, double rating) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.rating = rating;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public double getRating() {
//        return rating;
//    }
//
//    public void setRating(double rating) {
//        this.rating = rating;
//    }
//}
