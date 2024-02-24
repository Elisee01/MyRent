package com.bakanna.assurance.service.api.controller;

import com.bakanna.assurance.service.api.model.Partner;
import com.bakanna.assurance.service.api.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partners")
public class PartnerController {

    private final PartnerService partnerService;

    @Autowired
    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GetMapping
    public List<Partner> getAllPartners() {
        return partnerService.getAllPartners();
    }

    @GetMapping("/{id}")
    public Partner getPartnerById(@PathVariable Long id) {
        return partnerService.getPartnerById(id);
    }

    @PostMapping
    public Partner createPartner(@RequestBody Partner partner) {
        return partnerService.createPartner(partner);
    }

    @PutMapping("/{id}")
    public Partner updatePartner(@PathVariable Long id, @RequestBody Partner partner) {
        return partnerService.updatePartner(id, partner);
    }

    @DeleteMapping("/{id}")
    public void deletePartner(@PathVariable Long id) {
        partnerService.deletePartner(id);
    }
}
