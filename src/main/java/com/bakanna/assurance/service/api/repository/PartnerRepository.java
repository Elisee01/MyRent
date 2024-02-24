package com.bakanna.assurance.service.api.repository;


import com.bakanna.assurance.service.api.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartnerRepository extends JpaRepository<Partner, Long> {
    Optional<Partner> findByName(String name);
}

