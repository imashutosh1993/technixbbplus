package com.technix.bbplus.repository;

import com.technix.bbplus.entity.CompanyAdditional;
import com.technix.bbplus.entity.CompanySettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyAdditionalRepository extends JpaRepository<CompanyAdditional,Integer> {
    List<CompanyAdditional> findBycompanyId(int CompanyId);

}
