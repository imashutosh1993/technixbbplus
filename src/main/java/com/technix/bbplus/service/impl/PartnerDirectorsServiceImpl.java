package com.technix.bbplus.service.impl;

import com.technix.bbplus.entity.PartnersDirectors;
import com.technix.bbplus.repository.PartnersDirectorsRepository;
import com.technix.bbplus.service.PartnerDirectorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartnerDirectorsServiceImpl implements PartnerDirectorsService {

    @Autowired
    private PartnersDirectorsRepository partnersDirectorsRepository;


    @Override
    public PartnersDirectors savePartner(PartnersDirectors partner) {
        try {
            return partnersDirectorsRepository.save(partner);
        } catch (Exception e) {
            throw new RuntimeException("Error saving partner: " + e.getMessage());
        }
    }

    @Override
    public List<PartnersDirectors> getAllPartners() {
        return partnersDirectorsRepository.findAll();
    }

    @Override
    public Optional<PartnersDirectors> getPartnerById(int id) {
        try {
            return partnersDirectorsRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching partner by id: " + e.getMessage());
        }
    }

    @Override
    public PartnersDirectors updatePartner(int id, PartnersDirectors partnerDetails) {
        try {
            PartnersDirectors partner = partnersDirectorsRepository.findById(id).orElseThrow(() -> new RuntimeException("partner not found"));
            partner.setDirectorName(partnerDetails.getDirectorName());
            partner.setDirectorIdentityNumber(partnerDetails.getDirectorIdentityNumber());
            partner.setAdress(partnerDetails.getAdress());
            partner.setCity(partnerDetails.getCity());
            partner.setPin(partnerDetails.getPin());
            partner.setState(partnerDetails.getState());
            partner.setCountry(partnerDetails.getCountry());
            partner.setExecutive(partnerDetails.isExecutive());
            partner.setPan(partnerDetails.getPan());
            partner.setAadhar(partnerDetails.getAadhar());
            partner.setMobileNumber(partnerDetails.getMobileNumber());
            partner.setEmail(partnerDetails.getEmail());
            partner.setDigitalSignature(partnerDetails.getDigitalSignature());
            partner.setCreatedBy(partnerDetails.getCreatedBy());
            partner.setCreatedAt(partnerDetails.getCreatedAt());
            return partnersDirectorsRepository.save(partner);
        } catch (Exception e) {
            throw new RuntimeException("Error update partner: " + e.getMessage());
        }
    }

    @Override
    public void deletePartner(int id) {
        try {
            partnersDirectorsRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting partner: " + e.getMessage());
        }
    }

    @Override
    public List<PartnersDirectors> getBycompanyId(int CompanyId) {
        try {
            return partnersDirectorsRepository.findBycompanyId(CompanyId);
        } catch (Exception e) {
            throw new RuntimeException("Error Customer: " + e.getMessage());
        }
    }
}