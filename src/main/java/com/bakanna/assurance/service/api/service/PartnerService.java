package com.bakanna.assurance.service.api.service;

import com.bakanna.assurance.service.api.model.Partner;

import java.util.List;

public interface PartnerService {

    List<Partner> getAllPartners();

    Partner getPartnerById(Long id);

    Partner createPartner(Partner partner);

    Partner updatePartner(Long id, Partner partner);

    void deletePartner(Long id);
}
