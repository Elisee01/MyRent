package com.bakanna.assurance.service.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "partners")
public class Partner {
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
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PartnerType type;

    @Getter
    @OneToMany(mappedBy = "partner", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("partner")
    private Set<Contract> contracts = new HashSet<>();

    public void addContract(Contract contract) {
        if (!hasActiveContract(contract)) {
            contracts.add(contract);
            contract.setPartner(this);
        } else {
            throw new RuntimeException("Partner already has an active contract");
        }
    }

    public void removeContract(Contract contract) {
        contracts.remove(contract);
        contract.setPartner(null);
    }

    private boolean hasActiveContract(Contract newContract) {
        LocalDate currentDate = LocalDate.now();

        for (Contract contract : contracts) {
            if (!contract.equals(newContract) && currentDate.isAfter(contract.getStartDate()) && currentDate.isBefore(contract.getEndDate())) {
                return true;
            }
        }

        return false;
    }
}