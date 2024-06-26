package com.technix.bbplus.service.impl;

import com.technix.bbplus.entity.Brand;
import com.technix.bbplus.entity.Supplier;
import com.technix.bbplus.repository.SupplierRepository;
import com.technix.bbplus.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;
    @Override
    public Supplier createsupplier(Supplier supplier) {
        try {
            return supplierRepository.save(supplier);
        }catch (Exception e){
            throw new RuntimeException("Error create supplier: " + e.getMessage() );
        }
    }

    @Override
    public List<Supplier> getAllsupplier() {
        try {
            return supplierRepository.findAll();
        }catch(Exception e){
            throw new RuntimeException("Error getAll Supplier: " + e.getMessage());
        }
    }

    @Override
    public Supplier getbysupplierid(int id) {
        try {
            return supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Error getById"));
        }catch (Exception e){
            throw new RuntimeException("Error getByid: " + e.getMessage() );
        }
    }

    @Override
    public Supplier updatesupplier(int id, Supplier supplier) {
        try {
            Supplier supplier1 = supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Error update"));
            supplier1.setSupplier(supplier.getSupplier());
            supplier1.setDescription(supplier.getDescription());
            supplier1.setCreatedBy(supplier.getCreatedBy());
            supplier1.setCreatedAt(supplier.getCreatedAt());
            return supplierRepository.save(supplier1);
        }catch (Exception e){
            throw new RuntimeException("Error update supplier");
        }
    }

    @Override
    public void deletesupplier(int id) {
        supplierRepository.deleteById(id);

    }

    @Override
    public List<Supplier> getBycompanyId(int CompanyId) {
        try {
            return supplierRepository.findBycompanyId(CompanyId);
        }catch(Exception e){
            throw new RuntimeException("Error getBycompanyId: " + e.getMessage());
        }
    }

}
