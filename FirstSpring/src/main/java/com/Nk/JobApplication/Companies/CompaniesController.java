package com.Nk.JobApplication.Companies;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompaniesController {
    private CompaniesService companiesService;

    public CompaniesController(CompaniesService companiesService) {
        this.companiesService = companiesService;
    }
    @GetMapping
    public ResponseEntity<List<CompaniesEntity>>getAllCompanies(){
        return new ResponseEntity<>( companiesService.getAllCompanies(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String>updateCompany(@PathVariable Long id,@RequestBody CompaniesEntity companies)
    {
        companiesService.updateCompany(id, companies);
        return new ResponseEntity<>("Company updated Successfully", HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String > addCompany(@RequestBody CompaniesEntity companies)
    {
        companiesService.createCompany(companies);
        return new ResponseEntity<>("Company added Sucessfully",HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id)
    {
        boolean isDeleted=companiesService.deleteCompanyById(id);
        if (isDeleted)
        {
            return new ResponseEntity<>("Company sucessfully deleted",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Company Not Found",HttpStatus.NOT_FOUND);
        }


    }
    @GetMapping("/{id}")
    public ResponseEntity<CompaniesEntity> getCompany(@PathVariable Long id)
    {
        CompaniesEntity companiesEntity=companiesService.getCompanyById(id);
        if (companiesEntity !=null)
        {
            return new ResponseEntity<>(companiesEntity,HttpStatus.OK);

        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
