package com.technix.bbplus.repository;


import com.technix.bbplus.entity.CompanySettings;
import com.technix.bbplus.entity.PartnersDirectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanySettingsRepository extends JpaRepository<CompanySettings,Integer> {
    List<CompanySettings> findBycompanyId(int CompanyId);


}
