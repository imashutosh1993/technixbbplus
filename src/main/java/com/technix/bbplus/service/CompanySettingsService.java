package com.technix.bbplus.service;

import com.technix.bbplus.entity.CompanySettings;
import com.technix.bbplus.entity.PartnersDirectors;

import java.util.List;

public interface CompanySettingsService {

    CompanySettings createcompanysetting(CompanySettings companySettings);

    List<CompanySettings> getAllcompanysettings();

    CompanySettings getcompanysettingById(int id);

    CompanySettings updatecompanysettings(int id, CompanySettings companySettings);

    void deletecompanysetting(int id);

    List<CompanySettings> getBycompanyId(int CompanyId);


}
