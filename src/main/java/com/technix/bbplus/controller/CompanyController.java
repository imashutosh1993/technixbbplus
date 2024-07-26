package com.technix.bbplus.controller;
import com.technix.bbplus.dto.PageResponse;
import com.technix.bbplus.entity.Company;
import com.technix.bbplus.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {



    @Autowired
    private CompanyService companyService;

    public static String UploadDirectory = System.getProperty("user.dir")+"E:\\ashupic\\wallpaper";

    @PostMapping("/post")
    public ResponseEntity<Company> createCompany(@ModelAttribute Company company,
                                                 @RequestParam(value = "file",required = false) MultipartFile file) throws IOException {
//        String originalFilename = file.getOriginalFilename();
//        Path fileNameAndPath= Paths.get(UploadDirectory ,originalFilename);
//        Files.write(fileNameAndPath,file.getBytes());
//        company.setLogo(originalFilename);

        Company createdCompany = companyService.createCompany(company,file);
        return ResponseEntity.ok(createdCompany);
    }

    @GetMapping("/getby/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable int id) {
            Company company = companyService.getCompanyById(id);
            return ResponseEntity.ok(company);

    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllCompanies(@RequestParam int pageNo,@RequestParam int pageSize) {
        PageResponse<Company> companies = companyService.getAllCompanies(pageNo,pageSize);
        return ResponseEntity.ok(companies);
    }

    @PutMapping("/updateby/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable int id, @RequestBody Company companyDetails) {
        try {
            Company updatedCompany = companyService.updateCompany(id, companyDetails);
            return ResponseEntity.ok(updatedCompany);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteby/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable int id) {
        try {
            companyService.deleteCompany(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?>getBycustomerId(int CustomerId){
        return new ResponseEntity<>(companyService.getBycustomerId(CustomerId),HttpStatus.OK);
    }
}
