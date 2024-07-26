package com.technix.bbplus.service.impl;
import com.technix.bbplus.dto.PageResponse;
import com.technix.bbplus.entity.Supplier;
import com.technix.bbplus.repository.SupplierRepository;
import com.technix.bbplus.service.SupplierService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ResourceLoader resourceLoader;

    String Path = "C:\\Users\\ashut\\OneDrive\\Desktop\\jasperreport";


    @Override
    public Supplier createsupplier(Supplier supplier) {
        try {
            return supplierRepository.save(supplier);
        } catch (Exception e) {
            throw new RuntimeException("Error create supplier: " + e.getMessage());
        }
    }

    @Override
    public PageResponse<Supplier> getAllsupplier(int page, int size) {
        try {
            PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id"));
            Page<Supplier> page1 = supplierRepository.findAll(pageRequest);
            return new PageResponse<>(
                    page1.getContent(),
                    page1.getNumber(),
                    page1.getSize(),
                    page1.getTotalElements(),
                    page1.getTotalPages()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error getAll Supplier: " + e.getMessage());
        }
    }

    @Override
    public Supplier getbysupplierid(int id) {
        try {
            return supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Error getById"));
        } catch (Exception e) {
            throw new RuntimeException("Error getByid: " + e.getMessage());
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
        } catch (Exception e) {
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
        } catch (Exception e) {
            throw new RuntimeException("Error getBycompanyId: " + e.getMessage());
        }
    }

    @Override
    public byte[] exportReport(String reportFormat) {
        try {
            List<Supplier> suppliers = supplierRepository.findAll();
            File file = ResourceUtils.getFile("classpath:Supplier.jrxml");

            JasperReport jr = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(suppliers);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("createdBy", "learn jasper report");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr, parameters, dataSource);

            if (reportFormat.equalsIgnoreCase("pdf")) {
                ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
                JasperExportManager.exportReportToPdfStream(jasperPrint, pdfOutputStream);
                return pdfOutputStream.toByteArray();
            }
            else {
                return ("Unsupported format: " + reportFormat).getBytes();
            }
        } catch (FileNotFoundException | JRException e) {
            e.printStackTrace();
            return ("Error occurred: " + e.getMessage()).getBytes();
        }
    }

}


