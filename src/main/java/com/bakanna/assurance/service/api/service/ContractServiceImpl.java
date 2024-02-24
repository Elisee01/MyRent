package com.bakanna.assurance.service.api.service;

import com.bakanna.assurance.service.api.exception.PartnerNotFoundException;
import com.bakanna.assurance.service.api.model.Contract;
import com.bakanna.assurance.service.api.model.Partner;
import com.bakanna.assurance.service.api.repository.ContractRepository;
import com.bakanna.assurance.service.api.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final PartnerRepository partnerRepository;

    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository, PartnerRepository partnerRepository) {
        this.contractRepository = contractRepository;
        this.partnerRepository = partnerRepository;
    }

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public Contract getContractById(Long id) {
        return contractRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contract not found with id: " + id));
    }

    @Override
    public Contract createContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Contract updateContract(Long id, Contract contract) {
        Optional<Contract> existingContractOptional = contractRepository.findById(id);

        if (existingContractOptional.isPresent()) {
            Contract existingContract = existingContractOptional.get();
            existingContract.setPartner(contract.getPartner());
            existingContract.setContractNumber(contract.getContractNumber());
            existingContract.setContractName(contract.getContractName());
            existingContract.setStartDate(contract.getStartDate());
            existingContract.setEndDate(contract.getEndDate());
            existingContract.setFilePath(contract.getFilePath());
            existingContract.setFileName(contract.getFileName());
            existingContract.setFileContentType(contract.getFileContentType());
            return contractRepository.save(existingContract);
        } else {
            throw new RuntimeException("Contract not found with id: " + id);
        }
    }

    @Override
    public void deleteContract(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void createContractWithPartner(Long partnerId, Contract contract) {
        Partner partner = partnerRepository.findById(partnerId)
                .orElseThrow(() -> new PartnerNotFoundException(partnerId));

        contract.setPartnerAndPersist(partner);
        contractRepository.save(contract);
    }
}
