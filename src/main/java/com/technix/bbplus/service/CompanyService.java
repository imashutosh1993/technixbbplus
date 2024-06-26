package com.technix.bbplus.service;

import com.technix.bbplus.entity.Company;
import com.technix.bbplus.entity.Subscription;

import java.util.List;

public interface CompanyService {

     Company createCompany(Company company);
     Company getCompanyById(int id);
     List<Company> getAllCompanies();
     Company updateCompany(int id, Company companyDetails);
     void deleteCompany(int id);


     List<Company> getBycustomerId(int CustomerId );



}
