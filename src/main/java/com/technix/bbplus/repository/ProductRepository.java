package com.technix.bbplus.repository;


import com.technix.bbplus.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findBycompanyId(int CompanyId);

}
