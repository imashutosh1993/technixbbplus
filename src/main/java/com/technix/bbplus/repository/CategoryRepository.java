package com.technix.bbplus.repository;

import com.technix.bbplus.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    List<Category> findBycompanyId(int CompanyId);

}
