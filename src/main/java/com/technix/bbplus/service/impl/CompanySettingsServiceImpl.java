package com.technix.bbplus.service.impl;

import com.technix.bbplus.entity.CompanySettings;
import com.technix.bbplus.repository.CompanySettingsRepository;
import com.technix.bbplus.service.CompanySettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanySettingsServiceImpl implements CompanySettingsService {
    @Autowired
    CompanySettingsRepository companySettingsRepository;

    @Override
    public CompanySettings createcompanysetting(CompanySettings companySettings) {
        try {
            return companySettingsRepository.save(companySettings);
        } catch (Exception e) {
            throw new RuntimeException("Error save companysetting: " + e.getMessage());
        }
    }

    @Override
    public List<CompanySettings> getAllcompanysettings() {
        return companySettingsRepository.findAll();
    }

    @Override
    public CompanySettings getcompanysettingById(int id) {
        try {
            return companySettingsRepository.findById(id).orElseThrow(() -> new RuntimeException("Company Setting NOT FOUND"));
        } catch (Exception e) {
            throw new RuntimeException("failed to getById: " + e.getMessage());
        }
    }

    @Override
    public CompanySettings updatecompanysettings(int id, CompanySettings companySettings) {
        try {
            CompanySettings companySettings1 = companySettingsRepository.findById(id).orElseThrow(() -> new RuntimeException("company settings NOT FOUND"));
            companySettings1.setCurrencySymbol(companySettings.getCurrencySymbol());
            companySettings1.setCurrencyName(companySettings.getCurrencyName());
            companySettings1.setDateFormat(companySettings.getDateFormat());
            companySettings1.setSuffixSymbolToAmount(companySettings.isSuffixSymbolToAmount());
            companySettings1.setShowInMillions(companySettings.isShowInMillions());
            companySettings1.setNumberOfDecimalPlace(companySettings.getNumberOfDecimalPlace());
            companySettings1.setWordRepresentingAmountAfterDecimalPlace(companySettings.getWordRepresentingAmountAfterDecimalPlace());
            companySettings1.setNoOfDecimalPlacesForAmountInWords(companySettings.getNoOfDecimalPlacesForAmountInWords());
            companySettings1.setCreatedBy(companySettings.getCreatedBy());
            companySettings1.setCreatedAt(companySettings.getCreatedAt());
            return companySettingsRepository.save(companySettings1);
        }catch (Exception e){
            throw new RuntimeException("Error update companysettings: " + e.getMessage());
        }
    }

    @Override
    public void deletecompanysetting(int id) {
        try {
            companySettingsRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Error delete companysettings: " + e.getMessage());
        }


    }



    @Override
    public List<CompanySettings> getBycompanyId(int CompanyId) {
        return companySettingsRepository.findBycompanyId(CompanyId);
    }
}
