package com.technix.bbplus.repository;

import com.technix.bbplus.entity.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {


    List<Company> findBycustomerId(int CustomerId);


}

