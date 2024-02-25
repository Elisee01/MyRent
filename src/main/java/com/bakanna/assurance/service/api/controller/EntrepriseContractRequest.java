package com.bakanna.assurance.service.api.controller;

import com.bakanna.assurance.service.api.model.EntrepriseContract;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EntrepriseContractRequest {
    private Long entrepriseId;
    private EntrepriseContract entreprisecontract;

}
