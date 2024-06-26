package com.technix.bbplus.controller;

import com.technix.bbplus.entity.Brand;
import com.technix.bbplus.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping("/createbrand")
    public ResponseEntity<?> createbrand(@RequestBody Brand brand){
        return new ResponseEntity<>(brandService.createbrand(brand), HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<List<Brand>> getAllbrand (){
        return new ResponseEntity<>(brandService.getAllbrand(),HttpStatus.OK);
    }
    @GetMapping("/getby/{id}")
    public ResponseEntity<?> getBybrandid(@PathVariable int id){
        return new ResponseEntity<Brand>(brandService.getBybrandid(id),HttpStatus.OK);
    }
@PutMapping("/updateby/{id}")
    public ResponseEntity<?> updatebrand(@PathVariable int id, @RequestBody Brand brand){
        return new ResponseEntity<>(brandService.updatebrand(id, brand),HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteby{id}")
    public ResponseEntity<?> deletebrand(@PathVariable int id){
        brandService.deletebrand(id);
        return new ResponseEntity<String>("delete Sucessfully",HttpStatus.OK);
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<?> getBycompanyId(int CompanyId){
        return new ResponseEntity<>(brandService.getBycompanyId(CompanyId), HttpStatus.OK);
    }
}

