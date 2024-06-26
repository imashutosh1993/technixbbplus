package com.technix.bbplus.controller;
import com.technix.bbplus.entity.Company;
import com.technix.bbplus.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/post")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        Company createdCompany = companyService.createCompany(company);
        return ResponseEntity.ok(createdCompany);
    }

    @GetMapping("/getby/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable int id) {
            Company company = companyService.getCompanyById(id);
            return ResponseEntity.ok(company);

    }

    @GetMapping("/get")
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
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
