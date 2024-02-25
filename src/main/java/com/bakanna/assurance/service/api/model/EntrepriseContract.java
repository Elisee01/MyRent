package com.bakanna.assurance.service.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "entreprise_contracts")
public class EntrepriseContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne(cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "entreprise_id", nullable = false)
    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    @JsonIgnoreProperties("entreprisecontracts")
    private Entreprise entreprise;

    @Column(name = "contract_number", nullable = false)
    private String contractNumber;

    @Column(name = "contract_name", nullable = false)
    private String contractName;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_content_type")
    private String fileContentType;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;


    public void setEntrepriseAndPersist(Entreprise entreprise) {
        this.entreprise = entreprise;
        if (entreprise != null) {
            entreprise.getEntreprisecontracts().add(this);
        }
    }
}
