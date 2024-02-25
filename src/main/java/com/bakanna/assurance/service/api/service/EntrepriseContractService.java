package com.bakanna.assurance.service.api.service;

import com.bakanna.assurance.service.api.model.EntrepriseContract;

import java.util.List;

public interface EntrepriseContractService {

    List<EntrepriseContract> getAllEntrepriseContracts();

    EntrepriseContract getEntrepriseContractById(Long id);

    EntrepriseContract createEntrepriseContract(EntrepriseContract entreprisecontract);

    EntrepriseContract updateEntrepriseContract(Long id, EntrepriseContract entreprisecontract);

    void deleteEntrepriseContract(Long id);


    void createEntrepriseContractWithEntreprise(Long entrepriseId, EntrepriseContract entreprisecontract);
}
