package com.bakanna.assurance.service.api.service;

import com.bakanna.assurance.service.api.model.Partner;
import com.bakanna.assurance.service.api.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartnerServiceImpl implements PartnerService {

    private final PartnerRepository partnerRepository;

    @Autowired
    public PartnerServiceImpl(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    @Override
    public List<Partner> getAllPartners() {
        return partnerRepository.findAll();
    }

    @Override
    public Partner getPartnerById(Long id) {
        return partnerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partner not found with id: " + id));
    }

    @Override
    public Partner createPartner(Partner partner) {
        return partnerRepository.save(partner);
    }

    @Override
    public Partner updatePartner(Long id, Partner partner) {
        Optional<Partner> existingPartnerOptional = partnerRepository.findById(id);

        if (existingPartnerOptional.isPresent()) {
            Partner existingPartner = existingPartnerOptional.get();
            existingPartner.setName(partner.getName());
            existingPartner.setPhone(partner.getPhone());
            existingPartner.setAddress(partner.getAddress());
            existingPartner.setRepresentativeName(partner.getRepresentativeName());
            existingPartner.setRepresentativePhone(partner.getRepresentativePhone());
            existingPartner.setRepresentativeEmail(partner.getRepresentativeEmail());
            existingPartner.setType(partner.getType());

            return partnerRepository.save(existingPartner);
        } else {
            throw new RuntimeException("Partner not found with id: " + id);
        }
    }

    @Override
    public void deletePartner(Long id) {
        partnerRepository.deleteById(id);
    }
}
