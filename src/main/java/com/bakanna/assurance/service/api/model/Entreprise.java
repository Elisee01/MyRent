package com.bakanna.assurance.service.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "entreprises")
public class Entreprise {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(nullable = false)
    private String name;

    @Setter
    @Getter
    @Column(name = "entre_email", nullable = false)
    private String entrepriseEmail;

    @Setter
    @Getter
    @Column(nullable = false)
    private String phone;

    @Setter
    @Getter
    @Column(nullable = false)
    private String address;

    @Setter
    @Getter
    @Column(name = "rep_name", nullable = false)
    private String representativeName;

    @Setter
    @Getter
    @Column(name = "rep_phone", nullable = false)
    private String representativePhone;

    @Setter
    @Getter
    @Column(name = "rep_email", nullable = false)
    private String representativeEmail;


    @Getter
    @OneToMany(mappedBy = "entreprise", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("entreprise")
    private Set<EntrepriseContract> entreprisecontracts = new HashSet<>();

    public void addEntrepriseContract(EntrepriseContract entreprisecontract) {
        if (!hasActiveEntrepriseContract(entreprisecontract)) {
            entreprisecontracts.add(entreprisecontract);
            entreprisecontract.setEntreprise(this);
        } else {
            throw new RuntimeException("Entreprise already has an active contract");
        }
    }

    public void removeEntrepriseContract(EntrepriseContract entreprisecontract) {
        entreprisecontracts.remove(entreprisecontract);
        entreprisecontract.setEntreprise(null);
    }

    private boolean hasActiveEntrepriseContract(EntrepriseContract newEntrepriseContract) {
        LocalDate currentDate = LocalDate.now();

        for (EntrepriseContract entreprisecontract : entreprisecontracts) {
            if (!entreprisecontract.equals(newEntrepriseContract) && currentDate.isAfter(entreprisecontract.getStartDate()) && currentDate.isBefore(entreprisecontract.getEndDate())) {
                return true;
            }
        }

        return false;
    }
}