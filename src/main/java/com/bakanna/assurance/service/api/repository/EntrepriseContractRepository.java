package com.bakanna.assurance.service.api.repository;

import com.bakanna.assurance.service.api.model.EntrepriseContract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntrepriseContractRepository extends JpaRepository<EntrepriseContract, Long> {

    Optional<EntrepriseContract> findByContractNumber(String contractNumber);

}
