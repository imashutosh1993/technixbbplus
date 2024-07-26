package com.technix.bbplus.service;

import com.technix.bbplus.dto.PageResponse;

import com.technix.bbplus.entity.Product;



import java.util.List;

public interface ProductService {

    Product createproduct(Product product);

    Product getproductById(int id);

    PageResponse getAllproduct(int page,int size);

    Product updateproduct(int id,Product product);

    void deleteproduct(int id);

    List<Product> getBycompanyId(int CompanyId);

}
