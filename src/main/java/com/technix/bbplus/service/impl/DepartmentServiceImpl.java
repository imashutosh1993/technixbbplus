package com.technix.bbplus.service.impl;

import com.technix.bbplus.entity.Brand;
import com.technix.bbplus.entity.Department;
import com.technix.bbplus.repository.DepartmentRepository;
import com.technix.bbplus.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department createdepartment(Department department) {
        try {
            return departmentRepository.save(department);
        }catch (Exception e){
            throw new RuntimeException("Error create department");
        }
    }

    @Override
    public List<Department> getAlldepartment() {
        try {
            return departmentRepository.findAll();
        }catch (Exception e){
            throw new RuntimeException("Error getAll department");
        }
    }

    @Override
    public Department getdepartmentbyid(int id) {
        try {
            return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Error find department id"));
        }catch (Exception e){
            throw new RuntimeException("Error getbyid department:" + e);
        }
    }

    @Override
    public Department updatedepartment(int id, Department department) {
        try{
         Department department1=departmentRepository.findById(id).orElseThrow(()-> new RuntimeException("Update Error"));
         department1.setDepartment(department.getDepartment());
         department1.setDescription(department.getDescription());
         department1.setCreatedBy(department.getCreatedBy());
         department1.setCreatedAt(department.getCreatedAt());
        return departmentRepository.save(department1);
    }catch (Exception e){
            throw new RuntimeException("update error");
        }
    }

    @Override
    public void deletedepartment(int id) {
        try{
departmentRepository.deleteById(id);
    }catch (Exception e){
            throw new RuntimeException("Error delete department");
        }
    }

    @Override
    public List<Department> getBycompanyId(int CompanyId) {
        try {
            return departmentRepository.findBycompanyId(CompanyId);
        }catch (Exception e){
            throw new RuntimeException("Error get company: "  + e);
        }
    }


}
