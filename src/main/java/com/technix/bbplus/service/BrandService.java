package com.technix.bbplus.service;

import com.technix.bbplus.entity.Brand;
import com.technix.bbplus.entity.PartnersDirectors;

import java.util.List;

public interface BrandService {

    Brand createbrand(Brand brand);

    List<Brand> getAllbrand();

    Brand getBybrandid(int id);

    Brand updatebrand(int id,Brand brand);

    void deletebrand(int id);

    List<Brand> getBycompanyId(int CompanyId );


}
