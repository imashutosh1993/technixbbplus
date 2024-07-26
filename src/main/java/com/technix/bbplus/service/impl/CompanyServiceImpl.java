package com.technix.bbplus.service.impl;

import com.technix.bbplus.dto.PageResponse;
import com.technix.bbplus.entity.Company;

import com.technix.bbplus.repository.CompanyRepository;
import com.technix.bbplus.repository.CustomerRepository;
import com.technix.bbplus.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CustomerRepository customerRepository;

    private final String FOLDER_PATH = "D:\\office work\\BbplusAPILogo";

    @Override
    public Company createCompany(Company company, MultipartFile file) {
        try {

            Company saved = companyRepository.save(company);

            Path fp = Paths.get(FOLDER_PATH);

            if (!Files.exists(fp)) {
                Files.createDirectories(fp);
            }


            Path imagePath = fp.resolve(String.valueOf(saved.getCompanyId()));
            String filePath = file.getOriginalFilename();
            Path ffp = imagePath.resolve(filePath);
            if (!file.isEmpty()) {
                if (!Files.exists(imagePath)) {
                    Files.createDirectories(imagePath);
                }
            }
            file.transferTo(ffp);
            saved.setLogo(ffp.toString());
            saved = companyRepository.save(saved);
            return saved;

        } catch (Exception e) {
            throw new RuntimeException("error while creating company with image");
        }
    }

    @Override
    public Company getCompanyById(int id) {
        try {
            Optional<Company> company = companyRepository.findById(id);
            if (company.isPresent()) {
                return company.get();
            } else {
                throw new Exception("Company not found");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public PageResponse<Company> getAllCompanies(int page, int size) {
        try {
            PageRequest pageRequest = PageRequest.of(page, size, Sort.by("companyId"));
            Page<Company> page1 = companyRepository.findAll(pageRequest);
            return new PageResponse<>(
                    page1.getContent(),
                    page1.getNumber(),
                    page1.getSize(),
                    page1.getTotalElements(),
                    page1.getTotalPages()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error getAll paggination : " + e.getMessage());
        }
    }


    @Override
    public Company updateCompany(int id, Company companyDetails) {
        if (companyDetails == null) {

            throw new IllegalArgumentException("Company details cannot be null");
        }

        try {
            Company company = companyRepository.findById(id)
                    .orElseThrow(() -> new Exception("Company not found"));

            if (companyDetails.getCompanyName() != null) company.setCompanyName(companyDetails.getCompanyName());
            if (companyDetails.getBusinessType() != null) company.setBusinessType(companyDetails.getBusinessType());
            if (companyDetails.getCinNumber() != null) company.setCinNumber(companyDetails.getCinNumber());
            if (companyDetails.getRegistrationDate() != null)
                company.setRegistrationDate(companyDetails.getRegistrationDate());
            if (companyDetails.getAddress() != null) company.setAddress(companyDetails.getAddress());
            if (companyDetails.getCity() != null) company.setCity(companyDetails.getCity());
            if (companyDetails.getState() != null) company.setState(companyDetails.getState());
            if (companyDetails.getCountry() != null) company.setCountry(companyDetails.getCountry());
            if (companyDetails.getPostalCode() != null) company.setPostalCode(companyDetails.getPostalCode());
            if (companyDetails.getPhoneNumber() != null) company.setPhoneNumber(companyDetails.getPhoneNumber());
            if (companyDetails.getMobileNumber() != null) company.setMobileNumber(companyDetails.getMobileNumber());
            if (companyDetails.getFax() != null) company.setFax(companyDetails.getFax());
            if (companyDetails.getEmailId() != null) company.setEmailId(companyDetails.getEmailId());
            if (companyDetails.getWebsite() != null) company.setWebsite(companyDetails.getWebsite());
            if (companyDetails.getLogo() != null) company.setLogo(companyDetails.getLogo());
            if (companyDetails.getLogoPosition() != null) company.setLogoPosition(companyDetails.getLogoPosition());
            if (companyDetails.isLogoOnInvoice()) company.setLogoOnInvoice(true);
            if (companyDetails.getCreatedBy() != 0) company.setCreatedBy(companyDetails.getCreatedBy());
            if (companyDetails.getCreatedAt() != null) company.setCreatedAt(companyDetails.getCreatedAt());

            return companyRepository.save(company);
        } catch (Exception e) {
            log.error("field error");
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteCompany(int id) {
        try {
            Company company = companyRepository.findById(id)
                    .orElseThrow(() -> new Exception("Company not found"));
            companyRepository.delete(company);
        } catch (Exception e) {
            log.error("Not found");
            throw new RuntimeException(e.getMessage());
        }
    }



    @Override
    public List<Company> getBycustomerId(int CustomerId) {
        return companyRepository.findBycustomerId(CustomerId);
    }


}




