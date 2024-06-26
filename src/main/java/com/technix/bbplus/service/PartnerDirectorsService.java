package com.technix.bbplus.service;

import com.technix.bbplus.entity.PartnersDirectors;

import java.util.List;
import java.util.Optional;

public interface PartnerDirectorsService {

     PartnersDirectors savePartner(PartnersDirectors partner);
     List<PartnersDirectors> getAllPartners();
    Optional<PartnersDirectors> getPartnerById(int id);
    PartnersDirectors updatePartner(int id, PartnersDirectors partnerDetails);
    void deletePartner(int id);

    List<PartnersDirectors> getBycompanyId(int CompanyId );
}
