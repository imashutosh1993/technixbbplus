package com.technix.bbplus.service.impl;

import com.technix.bbplus.dto.PageResponse;
import com.technix.bbplus.entity.BankDetails;
import com.technix.bbplus.repository.BankDetailsRepository;
import com.technix.bbplus.service.BankDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankDetailsServiceImpl implements BankDetailsService {

    @Autowired
    private BankDetailsRepository bankDetailsRepository;

    @Override
    public BankDetails createBankdetail(BankDetails bankDetails) {
        try {
            return bankDetailsRepository.save(bankDetails);
        } catch (Exception e) {
            throw new RuntimeException("Error save bankdetails: " + e.getMessage());

        }
    }

    @Override
    public PageResponse<BankDetails> getAllBankdetails(int page,int size) {
        try {
       PageRequest pageRequest= PageRequest.of(page,size, Sort.by("id"));
            Page<BankDetails> page1= bankDetailsRepository.findAll(pageRequest);
            return new PageResponse<>(
                    page1.getContent(),
                    page1.getNumber(),
                    page1.getSize(),
                    page1.getTotalElements(),
                    page1.getTotalPages()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error getAll bankdetails: " + e.getMessage());
        }
    }

    @Override
    public Optional<BankDetails> getBankdetailsById(int id) {
        try {
            return bankDetailsRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error getbyId BankDetails: " + e.getMessage());
        }
    }


    @Override
    public BankDetails updateBankdetails(int id, BankDetails bankDetails) {
        try {
            BankDetails Details = bankDetailsRepository.findById(id).orElseThrow(() -> new RuntimeException("bankDetails Not found"));
            Details.setBankAccountNature(bankDetails.getBankAccountNature());
            Details.setAccountNumber(bankDetails.getAccountNumber());
            Details.setBankName(bankDetails.getBankName());
            Details.setBranchName(bankDetails.getBranchName());
            Details.setBranchAdress(bankDetails.getBranchAdress());
            Details.setIfscCode(bankDetails.getIfscCode());
            Details.setSigningAuthority(bankDetails.getSigningAuthority());
            Details.setAccountType(bankDetails.getAccountType());
            Details.setIbanNo(bankDetails.getIbanNo());
            Details.setSwiftCode(bankDetails.getSwiftCode());
            Details.setUpiNo(bankDetails.getUpiNo());
            Details.setCreatedBy(bankDetails.getCreatedBy());
            Details.setCreatedAt(bankDetails.getCreatedAt());
            return bankDetailsRepository.save(Details);
        } catch (Exception e) {
            throw new RuntimeException("Error update Details: " + e.getMessage());
        }
    }

    @Override
    public void deleteBankdetails(int id) {
        try {
            bankDetailsRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error delete bankdetails: " + e.getMessage());
        }
    }

    @Override
    public List<BankDetails> getBycompanyId(int CompanyId) {
        try {
            return bankDetailsRepository.findBycompanyId(CompanyId);
        } catch (Exception e) {
            throw new RuntimeException("Error get Company: " + e.getMessage());
        }

    }
}
