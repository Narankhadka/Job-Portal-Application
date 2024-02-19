package com.Nk.JobApplication.Companies.Imlementation;

import com.Nk.JobApplication.Companies.CompaniesEntity;
import com.Nk.JobApplication.Companies.CompaniesService;
import com.Nk.JobApplication.Companies.CompanyRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CompaniesEntiryImplementation implements CompaniesService {

    private CompanyRepository companyRepository;

    public CompaniesEntiryImplementation(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<CompaniesEntity> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override

    public boolean updateCompany(Long id, CompaniesEntity companiesEntity) {
        // Implementation
        Optional<CompaniesEntity>companies=companyRepository.findById(id);
        if (companies.isPresent())
        {
            CompaniesEntity company=companies.get();
            company.setDescription(companiesEntity.getDescription());
            company.setName(companiesEntity.getName());
            company.setJobs(companiesEntity.getJobs());
            companyRepository.save(company);
            return true;
        }
        return false;

    }

    @Override
    public void createCompany(CompaniesEntity companies) {
        companyRepository.save(companies);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
       if(companyRepository.existsById(id))
       {
           companyRepository.deleteById(id);
           return true;
       }
       return false;


    }

    @Override
    public CompaniesEntity getCompanyById(Long id) {
      return companyRepository.findById(id).orElse(null);
    }


}
