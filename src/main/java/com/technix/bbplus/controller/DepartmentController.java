package com.technix.bbplus.controller;

import com.technix.bbplus.entity.Department;
import com.technix.bbplus.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/post")
    public ResponseEntity<?> createdepartment(@RequestBody Department department){
        return new ResponseEntity<>(departmentService.createdepartment(department), HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<List<Department>>  getAlldepartment(){
        return new ResponseEntity<>(departmentService.getAlldepartment(),HttpStatus.OK);
    }
    @GetMapping("/getby/{id}")
    public ResponseEntity<?> getdepartmentbyid(@PathVariable int id){
        return new ResponseEntity<>(departmentService.getdepartmentbyid(id),HttpStatus.CREATED);
    }
    @PutMapping("/updateby/{id}")
    public ResponseEntity<?> updatedepartment(@PathVariable int id,@RequestBody Department department){
        return new ResponseEntity<>(departmentService.updatedepartment(id,department),HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteby/{id}")
    public ResponseEntity<?> deletedepartment(@PathVariable int id){
        departmentService.deletedepartment(id);
        return new ResponseEntity<String>("delete sucessfully",HttpStatus.OK);
    }
    @GetMapping("/company/{companyId}")
    public ResponseEntity<?> getBycompanyId(int CompanyId){
        return new ResponseEntity<>(departmentService.getBycompanyId(CompanyId),HttpStatus.OK);
    }
}
