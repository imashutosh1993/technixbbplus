package com.technix.bbplus.service;

import com.technix.bbplus.dto.PageResponse;
import com.technix.bbplus.entity.Company;
import com.technix.bbplus.entity.Subscription;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CompanyService {

    Company createCompany(Company company,MultipartFile file);

    Company getCompanyById(int id);

    PageResponse<Company> getAllCompanies(int page, int size);

    Company updateCompany(int id, Company companyDetails);

    void deleteCompany(int id);


    List<Company> getBycustomerId(int CustomerId);


}
