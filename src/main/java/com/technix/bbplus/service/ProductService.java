package com.technix.bbplus.service;

import com.technix.bbplus.entity.CompanySettings;
import com.technix.bbplus.entity.Product;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductService {

    Product createproduct(Product product);

    Product getproductById(int id);

    Page<Product> getAllproduct();

    Product updateproduct(int id,Product product);

    void deleteproduct(int id);

    List<Product> getBycompanyId(int CompanyId);

}
