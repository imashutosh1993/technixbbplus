package com.technix.bbplus.service.impl;

import com.technix.bbplus.entity.Category;
import com.technix.bbplus.repository.CategoryRepository;
import com.technix.bbplus.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
   private CategoryRepository categoryRepository;
    @Override
    public Category createcategory(Category category) {
        try {
            return categoryRepository.save(category);
        }catch(Exception e){
            throw new RuntimeException("Error Create Category:  " + e.getMessage() );
        }
    }

    @Override
    public List<Category> getAllcategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getcategorybyid(int id) {
        return categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Error getbyid"));
    }

    @Override
    public Category updatecategory(int id, Category category) {
        try {
            Category category1 = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Error update category"));
            category1.setCategoryName(category.getCategoryName());
            category1.setDescription(category.getDescription());
            category1.setParentId(category.getParentId());
            category1.setParentId(category.getParentId());
            category1.setCreatedAt(category.getCreatedAt());
            return categoryRepository.save(category1);
        }catch (Exception e){
            throw new RuntimeException("Error update category");
        }
    }

    @Override
    public void deletecategory(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getBycompanyId(int CompanyId) {
        try {
            return categoryRepository.findBycompanyId(CompanyId);
        }catch (Exception e){
            throw new RuntimeException("Error getBycompanyId:  " + e.getMessage());
        }
    }


}
