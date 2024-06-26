package com.technix.bbplus.service;

import com.technix.bbplus.entity.Brand;
import com.technix.bbplus.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department createdepartment(Department department);

    List<Department> getAlldepartment();

    Department getdepartmentbyid(int id);

    Department updatedepartment(int id, Department department);

    void deletedepartment(int id);

    List<Department> getBycompanyId(int CompanyId);

}
