package com.technix.bbplus.service.impl;

import com.technix.bbplus.dto.PageResponse;
import com.technix.bbplus.entity.CompanyAdditional;
import com.technix.bbplus.repository.CompanyAdditionalRepository;
import com.technix.bbplus.service.CompanyAdditionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompanyAdditionalImpl implements CompanyAdditionalService {

    @Autowired
    private CompanyAdditionalRepository companyAdditionalRepository;

    @Override
    public CompanyAdditional createcompanyadditional(CompanyAdditional companyAdditional) {
        try {
            return companyAdditionalRepository.save(companyAdditional);
        }catch (Exception e){
            throw new RuntimeException("Error create companyaditional: " + e.getMessage());
        }
    }
    @Override
    public CompanyAdditional getcompanyadditionalById(int id) {
        try {

            return companyAdditionalRepository.findById(id).orElseThrow(() -> new RuntimeException("companyadditional not found"));
        }catch (Exception e){
            throw new RuntimeException("Error getBy companyadditional:" + e.getMessage());
        }
    }

    @Override
    public PageResponse<CompanyAdditional> getAllcompanyadditionals(int page ,int size) {
        try {
            PageRequest pageRequest=PageRequest.of(page,size, Sort.by("id"));
            Page<CompanyAdditional> companyAdditionals = companyAdditionalRepository.findAll(pageRequest);
            return new PageResponse<>(
                    companyAdditionals.getContent(),
                    companyAdditionals.getNumber(),
                    companyAdditionals.getSize(),
                    companyAdditionals.getTotalElements(),
                    companyAdditionals.getTotalPages()
            );

        }catch (Exception e){
            throw new RuntimeException("Error getAll customeradditional: " +  e.getMessage());
        }
    }

    @Override
    public CompanyAdditional updatecompanyadditional(int id, CompanyAdditional companyAdditional) {
        try {
            CompanyAdditional companyAdditional1 = companyAdditionalRepository.findById(id).orElseThrow(() -> new RuntimeException("company additional not found"));
            companyAdditional1.setAuthorizedCapital(companyAdditional.getAuthorizedCapital());
            companyAdditional1.setPaidUpCapital(companyAdditional.getPaidUpCapital());
            companyAdditional1.setTotalNumberOfShares(companyAdditional.getTotalNumberOfShares());
            companyAdditional1.setValueOfEachShare(companyAdditional.getValueOfEachShare());
            companyAdditional1.setCreatedBy(companyAdditional.getCreatedBy());
            companyAdditional1.setCreatedAt(companyAdditional.getCreatedAt());
            return companyAdditionalRepository.save(companyAdditional1);
        }catch (Exception e){
            throw new RuntimeException("Error update companyadditional");
        }
    }

    @Override
    public void deletecompanyadditional(int id) {
        try {
            companyAdditionalRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Error delete companyadditional: " + e.getMessage());
        }
    }

    @Override
    public List<CompanyAdditional> getBycompanyId(int CompanyId) {
        return companyAdditionalRepository.findBycompanyId(CompanyId);
    }


}


