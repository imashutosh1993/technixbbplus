package com.technix.bbplus.repository;

import com.technix.bbplus.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer,Integer> {

    List<Manufacturer> findBycompanyId(int CompanyId);

}
