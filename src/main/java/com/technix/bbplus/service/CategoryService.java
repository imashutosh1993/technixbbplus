package com.technix.bbplus.service;

import com.technix.bbplus.entity.Category;
import com.technix.bbplus.entity.Supplier;

import java.util.List;

public interface CategoryService {

    Category createcategory(Category category);

    List<Category> getAllcategory();

    Category getcategorybyid(int id);

    Category updatecategory(int id,Category  category);

    void deletecategory(int id);

    List<Category> getBycompanyId(int CompanyId );

}
