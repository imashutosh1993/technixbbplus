package com.technix.bbplus.repository;

import com.technix.bbplus.entity.BankDetails;
import com.technix.bbplus.entity.PartnersDirectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetails,Integer> {

    List<BankDetails> findBycompanyId(int CompanyId);


}
