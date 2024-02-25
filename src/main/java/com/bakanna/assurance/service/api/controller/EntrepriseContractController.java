package com.bakanna.assurance.service.api.controller;

import com.bakanna.assurance.service.api.model.EntrepriseContract;
import com.bakanna.assurance.service.api.model.Entreprise;
import com.bakanna.assurance.service.api.service.EntrepriseContractService;
import com.bakanna.assurance.service.api.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entreprises")
public class EntrepriseContractController {

    private final EntrepriseContractService entreprisecontractService;
    private final EntrepriseService entrepriseService;

    @Autowired
    public EntrepriseContractController(EntrepriseContractService entreprisecontractService, EntrepriseService entrepriseService) {
        this.entreprisecontractService = entreprisecontractService;
        this.entrepriseService = entrepriseService;
    }

    @GetMapping
    public List<EntrepriseContract> getAllEntrepriseContracts() {
        return entreprisecontractService.getAllEntrepriseContracts();
    }

    @GetMapping("/{id}")
    public EntrepriseContract getEntrepriseContractById(@PathVariable Long id) {
        return entreprisecontractService.getEntrepriseContractById(id);
    }

    @PostMapping
    public ResponseEntity<EntrepriseContract> createEntrepriseContract(@RequestBody EntrepriseContractRequest entreprisecontractRequest) {
        try {
            Entreprise entreprise = entrepriseService.getEntrepriseById(entreprisecontractRequest.getEntrepriseId());
            EntrepriseContract entreprisecontract = entreprisecontractRequest.getEntreprisecontract();
            entreprisecontract.setEntreprise(entreprise);

            EntrepriseContract createdEntrepriseContract = entreprisecontractService.createEntrepriseContract(entreprisecontract);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdEntrepriseContract);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PutMapping("/{id}")
    public EntrepriseContract updateEntrepriseContract(@PathVariable Long id, @RequestBody EntrepriseContract entreprisecontract) {
        return entreprisecontractService.updateEntrepriseContract(id, entreprisecontract);
    }

    @DeleteMapping("/{id}")
    public void deleteEntrepriseContract(@PathVariable Long id) {
        entreprisecontractService.deleteEntrepriseContract(id);
    }
}
