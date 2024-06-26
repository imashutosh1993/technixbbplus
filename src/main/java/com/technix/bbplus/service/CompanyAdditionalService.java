package com.technix.bbplus.service;

import com.technix.bbplus.entity.CompanyAdditional;

import java.util.List;

public interface CompanyAdditionalService {


    CompanyAdditional createcompanyadditional(CompanyAdditional companyAdditional);

    CompanyAdditional getcompanyadditionalById(int id);

    List<CompanyAdditional> getAllcompanyadditionals();

    CompanyAdditional updatecompanyadditional(int id,CompanyAdditional companyAdditional);

    void deletecompanyadditional(int id);

    List<CompanyAdditional> getBycompanyId(int CompanyId);

}
