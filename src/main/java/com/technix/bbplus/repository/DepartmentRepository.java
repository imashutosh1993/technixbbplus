package com.technix.bbplus.repository;

import com.technix.bbplus.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    List<Department> findBycompanyId(int CompanyId);

}
