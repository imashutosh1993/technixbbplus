package com.technix.bbplus.service.impl;

import com.technix.bbplus.entity.Brand;
import com.technix.bbplus.repository.BrandRepository;
import com.technix.bbplus.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandServiceImpl implements BrandService {

@Autowired
private BrandRepository brandRepository;
    @Override
    public Brand createbrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public List<Brand> getAllbrand() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getBybrandid(int id) {
        return brandRepository.findById(id).orElseThrow(()-> new RuntimeException("find brand id"));
    }

    @Override
    public Brand updatebrand(int id, Brand brand) {
       Brand brand1= brandRepository.findById(id).orElseThrow(()-> new RuntimeException("update by id"));
       brand1.setBrandName(brand.getBrandName());
       brand1.setDescription(brand.getDescription());
       brand1.setCreatedBy(brand.getCreatedBy());
       brand1.setCreatedAt(brand.getCreatedAt());
        return brandRepository.save(brand1);
    }

    @Override
    public void deletebrand(int id) {
        brandRepository.deleteById(id);

    }

    @Override
    public List<Brand> getBycompanyId(int CompanyId) {
        return brandRepository.findBycompanyId(CompanyId);
    }
}
