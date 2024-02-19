package com.Nk.JobApplication.Review1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review ,Long> {
    //List<Review> findByCompanyId(Long companyId);

    List<Review> findByCompaniesId(Long companiesId);

    // List<Review> findByCompanyId(Long companyId);
}
