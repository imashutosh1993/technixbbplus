package com.technix.bbplus.controller;

import com.technix.bbplus.entity.Product;
import com.technix.bbplus.service.ProductService;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/post")
    public ResponseEntity<?> createproduct(@RequestBody Product product){
        return new ResponseEntity<Product>(productService.createproduct(product), HttpStatus.CREATED);
    }
    @GetMapping("/getby{id}")
    public ResponseEntity<?> getproductById(@PathVariable int id){
        return new ResponseEntity<Product>(productService.getproductById(id),HttpStatus.OK);
    }
@GetMapping("/get")
    public ResponseEntity<?> getAllproduct(){
        return new ResponseEntity<>(productService.getAllproduct(),HttpStatus.OK);
    }
@PutMapping("/update/{id}")
    public ResponseEntity<?> updateproduct(@PathVariable int id,@RequestBody Product product){
        return new ResponseEntity<Product>(productService.updateproduct(id,product),HttpStatus.CREATED);
    }
@DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteproduct(@PathVariable int id){
        productService.deleteproduct(id);

        return new ResponseEntity<String>("delete successfully",HttpStatus.OK);
    }
    @GetMapping("/company/{companyId}")
    public ResponseEntity<?> getBycompanyId(int CompanyId){
        return new ResponseEntity<>(productService.getBycompanyId(CompanyId), HttpStatus.OK);
    }
}


