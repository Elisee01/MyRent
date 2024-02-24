package com.bakanna.assurance.service.api.service;

import com.bakanna.assurance.service.api.model.Contract;

import java.util.List;

public interface ContractService {

    List<Contract> getAllContracts();

    Contract getContractById(Long id);

    Contract createContract(Contract contract);

    Contract updateContract(Long id, Contract contract);

    void deleteContract(Long id);

    // Additional method for creating a contract with a partner
    void createContractWithPartner(Long partnerId, Contract contract);
}
