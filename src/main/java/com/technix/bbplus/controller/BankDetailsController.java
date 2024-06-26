package com.technix.bbplus.controller;

import com.technix.bbplus.entity.BankDetails;
import com.technix.bbplus.service.BankDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bankdetails")
public class BankDetailsController {
    @Autowired
    private BankDetailsService bankDetailsService;
@PostMapping("/post")
    public ResponseEntity<?> createBankdetail(@RequestBody BankDetails bankDetails){
       return new ResponseEntity<>(bankDetailsService.createBankdetail(bankDetails), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBankdetails(@PathVariable int id, @RequestBody BankDetails bankDetails){
    return new ResponseEntity<>(bankDetailsService.updateBankdetails(id,bankDetails),HttpStatus.CREATED);
    }
@GetMapping("/getbyid/{id}")
    public ResponseEntity<?> getBankdetailsById(@PathVariable int id){
    return new ResponseEntity<>(bankDetailsService.getBankdetailsById(id),HttpStatus.OK);
    }
@GetMapping("/get")
    public  ResponseEntity<List<BankDetails>> getAllBankdetails(){
    return new ResponseEntity<List<BankDetails>>(bankDetailsService.getAllBankdetails(),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteBankdetails(@PathVariable int id){
    bankDetailsService.deleteBankdetails(id);
    return new ResponseEntity<String>("delete sucessfully",HttpStatus.OK);

    }
    @GetMapping("/company/{companyId}")
    public ResponseEntity<?> getBycompanyId(int CompanyId){
        return new ResponseEntity<>(bankDetailsService.getBycompanyId(CompanyId), HttpStatus.OK);
    }
}
