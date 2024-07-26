package com.technix.bbplus.service;

import com.technix.bbplus.dto.PageResponse;
import com.technix.bbplus.entity.Supplier;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.util.List;

public interface SupplierService {

    Supplier createsupplier(Supplier supplier);
    PageResponse<Supplier> getAllsupplier(int page,int size);
    Supplier getbysupplierid(int id);
    Supplier updatesupplier(int id,Supplier supplier);
    void deletesupplier(int id);
    List<Supplier> getBycompanyId(int CompanyId );

    byte[] exportReport(String resportFormar) throws FileNotFoundException, JRException;

}
