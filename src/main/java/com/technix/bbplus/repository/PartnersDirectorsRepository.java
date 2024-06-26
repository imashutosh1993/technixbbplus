package com.technix.bbplus.repository;

import com.technix.bbplus.entity.PartnersDirectors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartnersDirectorsRepository extends JpaRepository <PartnersDirectors,Integer>{

    List<PartnersDirectors> findBycompanyId(int CompanyId);
}
