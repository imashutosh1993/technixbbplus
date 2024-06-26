package com.technix.bbplus.controller;

import com.technix.bbplus.entity.Manufacturer;
import com.technix.bbplus.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufacturer")
public class ManufactureController {
    @Autowired
    private ManufacturerService manufacturerService;

    @PostMapping("/post")
    public ResponseEntity<?> createmanufacturer(@RequestBody Manufacturer manufacturer) {
        return new ResponseEntity<Manufacturer>(manufacturerService.createmanufacturer(manufacturer), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllmanufacturer() {
        return new ResponseEntity<List<Manufacturer>>(manufacturerService.getAllmanufacturer(), HttpStatus.OK);
    }

    @GetMapping("/getby/{id}")
    public ResponseEntity<?> getbymanufacturerid(@PathVariable int id) {
        return new ResponseEntity<>(manufacturerService.getbymanufacturerid(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatemanufacturer(@PathVariable int id, @RequestBody Manufacturer manufacturer) {
        return new ResponseEntity<Manufacturer>(manufacturerService.updatemanufacturer(id, manufacturer), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletemanufacturer(@PathVariable int id) {
        manufacturerService.deletemanufacturer(id);
        return new ResponseEntity<String>("delete sucessfully", HttpStatus.CREATED);
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<?> getBycompanyId(int CompanyId){
        return new ResponseEntity<>(manufacturerService.getBycompanyId(CompanyId),HttpStatus.OK);
    }

}
