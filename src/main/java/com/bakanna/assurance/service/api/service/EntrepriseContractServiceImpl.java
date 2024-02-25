package com.bakanna.assurance.service.api.service;

import com.bakanna.assurance.service.api.exception.EntrepriseNotFoundException;
import com.bakanna.assurance.service.api.model.EntrepriseContract;
import com.bakanna.assurance.service.api.model.Entreprise;
import com.bakanna.assurance.service.api.repository.EntrepriseContractRepository;
import com.bakanna.assurance.service.api.repository.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EntrepriseContractServiceImpl implements EntrepriseContractService {

    private final EntrepriseContractRepository entreprisecontractRepository;
    private final EntrepriseRepository entrepriseRepository;

    @Autowired
    public EntrepriseContractServiceImpl(EntrepriseContractRepository entreprisecontractRepository, EntrepriseRepository entrepriseRepository) {
        this.entreprisecontractRepository = entreprisecontractRepository;
        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public List<EntrepriseContract> getAllEntrepriseContracts() {
        return entreprisecontractRepository.findAll();
    }

    @Override
    public EntrepriseContract getEntrepriseContractById(Long id) {
        return entreprisecontractRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entreprise Contract not found with id: " + id));
    }

    @Override
    public EntrepriseContract createEntrepriseContract(EntrepriseContract entreprisecontract) {
        return entreprisecontractRepository.save(entreprisecontract);
    }

    @Override
    public EntrepriseContract updateEntrepriseContract(Long id, EntrepriseContract entreprisecontract) {
        Optional<EntrepriseContract> existingEntrepriseContractOptional = entreprisecontractRepository.findById(id);

        if (existingEntrepriseContractOptional.isPresent()) {
            EntrepriseContract existingEntrepriseContract = existingEntrepriseContractOptional.get();
            existingEntrepriseContract.setEntreprise(entreprisecontract.getEntreprise());
            existingEntrepriseContract.setContractNumber(entreprisecontract.getContractNumber());
            existingEntrepriseContract.setContractName(entreprisecontract.getContractName());
            existingEntrepriseContract.setStartDate(entreprisecontract.getStartDate());
            existingEntrepriseContract.setEndDate(entreprisecontract.getEndDate());
            existingEntrepriseContract.setFilePath(entreprisecontract.getFilePath());
            existingEntrepriseContract.setFileName(entreprisecontract.getFileName());
            existingEntrepriseContract.setFileContentType(entreprisecontract.getFileContentType());
            return entreprisecontractRepository.save(existingEntrepriseContract);
        } else {
            throw new RuntimeException("Entreprise Contract not found with id: " + id);
        }
    }

    @Override
    public void deleteEntrepriseContract(Long id) {

        entreprisecontractRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void createEntrepriseContractWithEntreprise(Long entrepriseId, EntrepriseContract entreprisecontract) {
        Entreprise entreprise = entrepriseRepository.findById(entrepriseId)
                .orElseThrow(() -> new EntrepriseNotFoundException(entrepriseId));

        entreprisecontract.setEntrepriseAndPersist(entreprise);
        entreprisecontractRepository.save(entreprisecontract);
    }
}
