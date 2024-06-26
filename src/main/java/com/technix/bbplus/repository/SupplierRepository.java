package com.technix.bbplus.repository;

import com.technix.bbplus.entity.Brand;
import com.technix.bbplus.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {

    List<Supplier> findBycompanyId(int CompanyId);

}
