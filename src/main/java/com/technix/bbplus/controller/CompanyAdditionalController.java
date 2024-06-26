package com.technix.bbplus.controller;

import com.technix.bbplus.entity.CompanyAdditional;
import com.technix.bbplus.service.CompanyAdditionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companyadditional")
public class CompanyAdditionalController {
    @Autowired
    private CompanyAdditionalService companyAdditionalService;

    @PostMapping("/post")
    public ResponseEntity<?> createcompanyadditional(@RequestBody CompanyAdditional companyAdditional){
        return new ResponseEntity<CompanyAdditional>(companyAdditionalService.createcompanyadditional(companyAdditional), HttpStatus.CREATED);
    }
    @GetMapping("/getBy/{id}")
    public ResponseEntity<?> getcompanyadditionalById(@PathVariable int id){
        return new ResponseEntity<CompanyAdditional>(companyAdditionalService.getcompanyadditionalById(id),HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<?> getAllcompanyadditionals(){
        return new ResponseEntity<>(companyAdditionalService.getAllcompanyadditionals(),HttpStatus.OK);
    }
@PutMapping("/updateBy/{id}")
public ResponseEntity<?> updatecompanyadditional(@PathVariable int id, @RequestBody CompanyAdditional companyAdditional){
        return new ResponseEntity<>(companyAdditionalService.updatecompanyadditional(id, companyAdditional),HttpStatus.CREATED);
}

@DeleteMapping("/deleteBy/{id}")
    public ResponseEntity<?> deletecompanyadditional(int id){
        try {
            companyAdditionalService.deletecompanyadditional(id);
            return new ResponseEntity<String>("delete sucessfully", HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException("Error delete companyadditional:" + e.getMessage());
        }
}

    @GetMapping("/company/{companyId}")
    public ResponseEntity<?> getBycompanyId(int CompanyId){
        return new ResponseEntity<>(companyAdditionalService.getBycompanyId(CompanyId), HttpStatus.OK);
    }

}
