package com.technix.bbplus.repository;

import com.technix.bbplus.entity.Brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand ,Integer> {

    List<Brand> findBycompanyId(int CompanyId);

}
