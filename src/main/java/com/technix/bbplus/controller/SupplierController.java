package com.technix.bbplus.controller;

import com.technix.bbplus.entity.Supplier;
import com.technix.bbplus.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping("/post")
    public ResponseEntity<?> createsupplier(@RequestBody Supplier supplier){
        return new ResponseEntity<Supplier>(supplierService.createsupplier(supplier), HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<List<Supplier>>  getAllsupplier(){
        return new ResponseEntity<>(supplierService.getAllsupplier(),HttpStatus.OK);
    }
    @GetMapping("/getby/{id}")
    public ResponseEntity<?> getbysupplierid(@PathVariable int id){
        return new ResponseEntity<Supplier>(supplierService.getbysupplierid(id),HttpStatus.OK);
    }
    @PutMapping("/updateby/{id}")
    public ResponseEntity<?> updatesupplier(@PathVariable int id,@RequestBody Supplier  supplier){
        return new ResponseEntity<Supplier>(supplierService.updatesupplier(id, supplier),HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteby/{id}")
    public ResponseEntity<?> deletesupplier(@PathVariable int id){
        supplierService.deletesupplier(id);
        return new ResponseEntity<String>("delete sucessfully",HttpStatus.OK);
    }
    @GetMapping("/company/{companyId}")
    public ResponseEntity<?> getBycompanyId(int CompanyId){
        return new ResponseEntity<>(supplierService.getBycompanyId(CompanyId), HttpStatus.OK);
    }

}
