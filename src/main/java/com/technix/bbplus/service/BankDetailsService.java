package com.technix.bbplus.service;

import com.technix.bbplus.entity.BankDetails;
import com.technix.bbplus.entity.PartnersDirectors;

import java.util.List;
import java.util.Optional;

public interface BankDetailsService {

    BankDetails createBankdetail(BankDetails bankDetails);

    List<BankDetails> getAllBankdetails();

    Optional<BankDetails> getBankdetailsById(int id);

    BankDetails updateBankdetails(int id, BankDetails bankDetails);

    void deleteBankdetails(int id);

    List<BankDetails> getBycompanyId(int CompanyId );



}




