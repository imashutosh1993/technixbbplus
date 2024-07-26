package com.technix.bbplus.controller;

import com.technix.bbplus.service.AuditLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/Auditlog")
public class AuditLogsController {
    @Autowired
    private AuditLogsService auditLogsService;
@GetMapping("/user/{userid}")
public ResponseEntity<?> getByuserid(int userId){
    return  new ResponseEntity<>(auditLogsService.getByuserid(userId), HttpStatus.OK);
}
}

