package com.technix.bbplus.service.impl;

import com.technix.bbplus.dto.PageResponse;
import com.technix.bbplus.entity.Product;
import com.technix.bbplus.repository.ProductRepository;
import com.technix.bbplus.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createproduct(Product product) {
        try {
            return productRepository.save(product);
        }catch (Exception e){
            throw new RuntimeException("Error create product");
        }
    }

    @Override
    public Product getproductById(int id) {
        try {
            return productRepository.findById(id).orElseThrow(()-> new RuntimeException("product not found"));
        }catch (Exception e){
            throw new RuntimeException("Error findById product");
        }
    }
    @Override
    public PageResponse getAllproduct(int page, int size ) {
        try {
            PageRequest pageRequest=PageRequest.of(page,size);

             Page<Product> paging= productRepository.findAll(pageRequest);
             return new PageResponse(
                     paging.getContent(),
                     paging.getNumber(),
                     paging.getSize(),
                     paging.getTotalElements(),
                     paging.getTotalPages()

             );

        }catch (Exception e){
            throw new RuntimeException("Error get product");
        }
    }
    @Override
    public Product updateproduct(int id, Product product) {
        try {
            Product product1 = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product Not found"));
            product1.setProductType(product.getProductType());
            product1.setProductName(product.getProductName());
            product1.setShortName(product.getShortName());
            product1.setDescription(product.getDescription());
            product1.setImage(product.getImage());
            product1.setCategoryId(product.getCategoryId());
            product1.setDepartmentId(product.getDepartmentId());
            product1.setBrandId(product.getBrandId());
            product1.setManufacturerId(product.getManufacturerId());
            product1.setSupplierId(product.getSupplierId());
            product1.setUnit(product.getUnit());
            product1.setUQCCode(product.getUQCCode());
            product1.setAltUnitRequired(product.getAltUnitRequired());
            product1.setSecondaryUnit(product.getSecondaryUnit());
            product1.setSecondaryUnitUQC(product.getSecondaryUnitUQC());
            product1.setDefaultSalesUnit(product.getDefaultSalesUnit());
            product1.setConversionFactor(product.getConversionFactor());
            product1.setManageItemBy(product.getManageItemBy());
            product1.setManagementMethod(product.getManagementMethod());
            product1.setWarrantyPeriod(product.getWarrantyPeriod());
            product1.setBarcode(product.getBarcode());
            product1.setSKU(product.getSKU());
            product1.setModelNo(product.getModelNo());
            product1.setColor(product.getColor());
            product1.setSize(product.getSize());
            product1.setIsTaxable(product.getIsTaxable());
            product1.setTaxId(product.getTaxId());
            product1.setTaxationType(product.getTaxationType());
            product1.setTaxPer(product.getTaxPer());
            product1.setHSNCode(product.getHSNCode());
            product1.setReorderPoint(product.getReorderPoint());
            product1.setMRP(product.getMRP());
            product1.setDiscountPer(product.getDiscountPer());
            product1.setPurchaseRate(product.getPurchaseRate());
            product1.setDistributorPrice(product.getDistributorPrice());
            product1.setDealerPrice(product.getDealerPrice());
            product1.setWholesalePrice(product.getWholesalePrice());
            product1.setSellingRate(product.getSellingRate());
            product1.setOpeningStock(product.getOpeningStock());
            product1.setOpeningStock(product.getOpeningStock());
            product1.setUnitRate(product.getUnitRate());
            product1.setOpeningValue(product.getOpeningValue());
            product1.setBin(product.getBin());
            product1.setStatus(product.getStatus());
            product1.setCreatedBy(product.getCreatedBy());
            product1.setCreationDate(product.getCreationDate());
            return productRepository.save(product1);
        }catch (Exception e){
            throw new RuntimeException("Error update product: "+ e.getMessage());
        }
    }

    @Override
    public void deleteproduct(int id) {
        try {
           productRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("delete product: " + e.getMessage());
        }
    }
    @Override
    public List<Product> getBycompanyId(int CompanyId) {
        try {
            return productRepository.findBycompanyId(CompanyId);
        } catch (Exception e) {
            throw new RuntimeException("Error get Company: " + e.getMessage());
        }

    }

}
