package com.bakanna.assurance.service.api.controller;

import com.bakanna.assurance.service.api.model.Contract;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContractRequest {
    private Long partnerId;
    private Contract contract;

}
