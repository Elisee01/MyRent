package com.bakanna.assurance.service.api.service;

import com.bakanna.assurance.service.api.model.Entreprise;

import java.util.List;

public interface EntrepriseService {

    List<Entreprise> getAllEntreprises();

    Entreprise getEntrepriseById(Long id);

    Entreprise createEntreprise(Entreprise entreprise);

    Entreprise updateEntreprise(Long id, Entreprise entreprise);

    void deleteEntreprise(Long id);
}
