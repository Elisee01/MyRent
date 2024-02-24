package com.bakanna.assurance.service.api.service;

import com.bakanna.assurance.service.api.model.Partner;
import com.bakanna.assurance.service.api.repository.PartnerRepository;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PartnerService {
    private final PartnerRepository partnerRepository;

    @Autowired
    public PartnerService(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    public Partner createPartner(Partner partner) {
        validatePartner(partner); // Validate partner data

        return partnerRepository.save(partner);
    }

    private void validatePartner(Partner partner) {
        // Basic validation to ensure required fields are not null or empty
        if (StringUtils.isBlank(partner.getName()) ||
                StringUtils.isBlank(partner.getPhone()) ||
                StringUtils.isBlank(partner.getAddress()) ||
                StringUtils.isBlank(partner.getRepresentativeName()) ||
                StringUtils.isBlank(partner.getRepresentativePhone()) ||
                StringUtils.isBlank(partner.getRepresentativeEmail()) ||
                partner.getType() == null) {
            throw new IllegalArgumentException("All partner fields are required");
        }

    }
}


