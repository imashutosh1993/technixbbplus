package com.technix.bbplus.controller;

import com.technix.bbplus.entity.CompanySettings;
import com.technix.bbplus.service.CompanySettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companysetting")
public class CompanySettingsController {

    @Autowired
    private CompanySettingsService companySettingsService;

    @PostMapping("/post")
    public ResponseEntity<?> createcompanysetting(@RequestBody CompanySettings companySettings) {
        return new ResponseEntity<>(companySettingsService.createcompanysetting(companySettings), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatecompanysettings(@PathVariable int id, @RequestBody CompanySettings companySettings) {
        return new ResponseEntity<CompanySettings>(companySettingsService.updatecompanysettings(id, companySettings), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<CompanySettings>> getAllcompanysettings() {
        return new ResponseEntity<List<CompanySettings>>(companySettingsService.getAllcompanysettings(), HttpStatus.OK);
    }

    @GetMapping("/getby{id}")
    public ResponseEntity<?> getcompanysettingById(int id) {
        return new ResponseEntity<CompanySettings>(companySettingsService.getcompanysettingById(id), HttpStatus.OK);
    }
    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<?> deletecompanysetting(int id){
        companySettingsService.deletecompanysetting(id);
        return new ResponseEntity<String>("delete Sucessfully",HttpStatus.OK);
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<?> getBycompanyId(int CompanyId){
        return new ResponseEntity<>(companySettingsService.getBycompanyId(CompanyId), HttpStatus.OK);
    }
}


