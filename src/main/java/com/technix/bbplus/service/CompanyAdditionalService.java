package com.technix.bbplus.service;

import com.technix.bbplus.dto.PageResponse;
import com.technix.bbplus.entity.CompanyAdditional;

import java.util.List;

public interface CompanyAdditionalService {


    CompanyAdditional createcompanyadditional(CompanyAdditional companyAdditional);

    CompanyAdditional getcompanyadditionalById(int id);

    PageResponse<CompanyAdditional> getAllcompanyadditionals(int page,int Size);

    CompanyAdditional updatecompanyadditional(int id,CompanyAdditional companyAdditional);

    void deletecompanyadditional(int id);

    List<CompanyAdditional> getBycompanyId(int CompanyId);

}
