package com.technix.bbplus.service.impl;

import com.technix.bbplus.dto.PageResponse;
import com.technix.bbplus.entity.Brand;
import com.technix.bbplus.repository.BrandRepository;
import com.technix.bbplus.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public PageResponse<Brand> getAllbrand(int page,int size) {
        try {
            PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id"));
            Page<Brand> page1 = brandRepository.findAll(pageRequest);

            return new PageResponse<>(
                    page1.getContent(),
                    page1.getNumber(),
                    page1.getSize(),
                    page1.getTotalElements(),
                    page1.getTotalPages()
            );
        }catch (Exception e){
            throw new RuntimeException("Error getAll brand: " + e.getMessage());
        }
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
