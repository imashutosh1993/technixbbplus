package com.technix.bbplus.service.impl;

import com.technix.bbplus.entity.Manufacturer;
import com.technix.bbplus.repository.ManufacturerRepository;
import com.technix.bbplus.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public Manufacturer createmanufacturer(Manufacturer manufacturer) {
        try{
        return manufacturerRepository.save(manufacturer);
    }catch (Exception e){
            throw new RuntimeException("Error create manufacture : " + e.getMessage());
        }
    }

    @Override
    public List<Manufacturer> getAllmanufacturer() {
        try{
        return manufacturerRepository.findAll();
    }catch (Exception e){
            throw new RuntimeException("Error getAll manufacturer");
        }
    }

    @Override
    public Manufacturer getbymanufacturerid(int id) {
        try{
        return manufacturerRepository.findById(id).orElseThrow(()-> new RuntimeException("Error getbyid"));

    }catch (Exception e){
            throw  new RuntimeException("Error getbyid:  "+ e.getMessage());
        }
    }




    @Override
    public Manufacturer updatemanufacturer(int id, Manufacturer manufacturer) {
        try {
            Manufacturer manufacturer1 = manufacturerRepository.findById(id).orElseThrow(() -> new RuntimeException("Error update manufactutrer"));
            manufacturer1.setManufacturer(manufacturer.getManufacturer());
            manufacturer1.setDescription(manufacturer.getDescription());
            manufacturer1.setCreatedAt(manufacturer.getCreatedAt());
            manufacturer1.setCreatedBy(manufacturer.getCreatedBy());
            return manufacturerRepository.save(manufacturer1);
        }catch (Exception e){
            throw new RuntimeException("Error update manufacturer: " + e.getMessage());
        }
    }

    @Override
    public void deletemanufacturer(int id) {
        try {
            manufacturerRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Error delete manufacturer: " + e.getMessage());
        }
    }

    @Override
    public List<Manufacturer> getBycompanyId(int CompanyId) {
        try {
            return manufacturerRepository.findBycompanyId(CompanyId);
        }catch (Exception e){
            throw new RuntimeException("Error getcompanyid: " + e.getMessage());
        }
    }
}
