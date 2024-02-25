package com.bakanna.assurance.service.api.repository;


import com.bakanna.assurance.service.api.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
    Optional<Entreprise> findByName(String name);
}

