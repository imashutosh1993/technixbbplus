package com.technix.bbplus.service;

import com.technix.bbplus.entity.Brand;
import com.technix.bbplus.entity.Supplier;

import java.util.List;

public interface SupplierService {

    Supplier createsupplier(Supplier supplier);
    List<Supplier> getAllsupplier();
    Supplier getbysupplierid(int id);
    Supplier updatesupplier(int id,Supplier supplier);
    void deletesupplier(int id);
    List<Supplier> getBycompanyId(int CompanyId );

}
