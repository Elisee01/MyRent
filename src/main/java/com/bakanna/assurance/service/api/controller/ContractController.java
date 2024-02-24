package com.bakanna.assurance.service.api.controller;

import com.bakanna.assurance.service.api.model.Contract;
import com.bakanna.assurance.service.api.model.Partner;
import com.bakanna.assurance.service.api.service.ContractService;
import com.bakanna.assurance.service.api.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {

    private final ContractService contractService;
    private final PartnerService partnerService;

    @Autowired
    public ContractController(ContractService contractService, PartnerService partnerService) {
        this.contractService = contractService;
        this.partnerService = partnerService;
    }

    @GetMapping
    public List<Contract> getAllContracts() {
        return contractService.getAllContracts();
    }

    @GetMapping("/{id}")
    public Contract getContractById(@PathVariable Long id) {
        return contractService.getContractById(id);
    }

    @PostMapping
    public ResponseEntity<Contract> createContract(@RequestBody ContractRequest contractRequest) {
        try {
            Partner partner = partnerService.getPartnerById(contractRequest.getPartnerId());
            Contract contract = contractRequest.getContract();
            contract.setPartner(partner);

            Contract createdContract = contractService.createContract(contract);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdContract);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PutMapping("/{id}")
    public Contract updateContract(@PathVariable Long id, @RequestBody Contract contract) {
        return contractService.updateContract(id, contract);
    }

    @DeleteMapping("/{id}")
    public void deleteContract(@PathVariable Long id) {
        contractService.deleteContract(id);
    }
}
