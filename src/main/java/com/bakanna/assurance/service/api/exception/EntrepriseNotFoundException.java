package com.bakanna.assurance.service.api.exception;

public class EntrepriseNotFoundException extends RuntimeException {

    public EntrepriseNotFoundException(Long entrepriseId) {
        super("Entreprise not found with id: " + entrepriseId);
    }
}
