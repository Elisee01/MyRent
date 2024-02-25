package com.bakanna.assurance.service.api.service;

import com.bakanna.assurance.service.api.model.Entreprise;
import com.bakanna.assurance.service.api.repository.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {

    private final EntrepriseRepository entrepriseRepository;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public List<Entreprise> getAllEntreprises() {
        return entrepriseRepository.findAll();
    }

    @Override
    public Entreprise getEntrepriseById(Long id) {
        return entrepriseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entreprise not found with id: " + id));
    }

    @Override
    public Entreprise createEntreprise(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    @Override
    public Entreprise updateEntreprise(Long id, Entreprise entreprise) {
        Optional<Entreprise> existingEntrepriseOptional = entrepriseRepository.findById(id);

        if (existingEntrepriseOptional.isPresent()) {
            Entreprise existingEntreprise = existingEntrepriseOptional.get();
            existingEntreprise.setName(entreprise.getName());
            existingEntreprise.setPhone(entreprise.getPhone());
            existingEntreprise.setAddress(entreprise.getAddress());
            existingEntreprise.setRepresentativeName(entreprise.getRepresentativeName());
            existingEntreprise.setRepresentativePhone(entreprise.getRepresentativePhone());
            existingEntreprise.setEntrepriseEmail(entreprise.getEntrepriseEmail());
            existingEntreprise.setRepresentativeEmail(entreprise.getRepresentativeEmail());

            return entrepriseRepository.save(existingEntreprise);
        } else {
            throw new RuntimeException("Entreprise not found with id: " + id);
        }
    }

    @Override
    public void deleteEntreprise(Long id) {
        entrepriseRepository.deleteById(id);
    }
}
