package com.technix.bbplus.service;


import com.technix.bbplus.entity.Manufacturer;

import java.util.List;

public interface ManufacturerService {


    Manufacturer createmanufacturer(Manufacturer manufacturer);

List<Manufacturer> getAllmanufacturer();
    Manufacturer getbymanufacturerid(int id);
    Manufacturer updatemanufacturer(int id,Manufacturer manufacturer);

    void deletemanufacturer(int id);
    List<Manufacturer> getBycompanyId(int CompanyId);

}
