package com.Nk.JobApplication.Companies;

import java.util.List;

public interface CompaniesService {
    List<CompaniesEntity>getAllCompanies();
    boolean updateCompany(Long id, CompaniesEntity companiesEntity);
    void createCompany(CompaniesEntity companies);
    boolean deleteCompanyById(Long id);

    CompaniesEntity getCompanyById(Long id);


}
