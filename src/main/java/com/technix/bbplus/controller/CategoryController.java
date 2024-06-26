package com.technix.bbplus.controller;

import com.technix.bbplus.entity.Category;
import com.technix.bbplus.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/post")
    public ResponseEntity<?> createcategory(@RequestBody Category category){
        return new ResponseEntity<Category>(categoryService.createcategory(category), HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<List<Category>>  getAllcategory(){
        return new ResponseEntity<>(categoryService.getAllcategory(),HttpStatus.OK);
    }
    @GetMapping("/getby/{id}")
    public ResponseEntity<?> getcategorybyid(@PathVariable int id){
        return new ResponseEntity<Category>(categoryService.getcategorybyid(id),HttpStatus.OK);
    }
    @PutMapping("/updateby/{id}")
    public ResponseEntity<?> updatecategory(@PathVariable int id, @RequestBody Category category){
        return new ResponseEntity<>(categoryService.updatecategory(id,category),HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteby/{id}")
    public ResponseEntity<?> deletecategory(int id){
        return new ResponseEntity<String>("delete sucessfully",HttpStatus.OK);
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<?> getBycompanyId(int CompanyId){
        return new ResponseEntity<>(categoryService.getBycompanyId(CompanyId), HttpStatus.OK);
    }




}
