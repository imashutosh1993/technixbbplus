package com.technix.bbplus.controller;

import com.technix.bbplus.entity.PartnersDirectors;
import com.technix.bbplus.service.PartnerDirectorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/partner")
public class PartnerDirectorsController {

    @Autowired
    private PartnerDirectorsService partnerDirectorsService;

    @PostMapping("/post")
    public ResponseEntity<?> createPartner(@RequestBody PartnersDirectors partner) {
        PartnersDirectors savePartner = (partnerDirectorsService.savePartner(partner));
        return ResponseEntity.ok(savePartner);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllPartners() {
        List<PartnersDirectors> partners = partnerDirectorsService.getAllPartners();
        return ResponseEntity.ok(partners);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getPartnerById(@PathVariable int id) {
        Optional<PartnersDirectors> partner = partnerDirectorsService.getPartnerById(id);
        return partner.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePartner(@PathVariable int id, @RequestBody PartnersDirectors partnerDetails) {
        PartnersDirectors updatepartner = partnerDirectorsService.updatePartner(id, partnerDetails);
        return ResponseEntity.ok(updatepartner);
    }
@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePartner(@PathVariable int id){
        partnerDirectorsService.deletePartner(id);
        return ResponseEntity.noContent().build();

    }
@GetMapping("/company/{companyId}")
    public ResponseEntity<?> getBycompanyId(int CompanyId){
        return new ResponseEntity<>(partnerDirectorsService.getBycompanyId(CompanyId), HttpStatus.OK);
    }
}
