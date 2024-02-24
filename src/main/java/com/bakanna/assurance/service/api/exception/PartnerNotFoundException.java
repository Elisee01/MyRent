package com.bakanna.assurance.service.api.exception;

public class PartnerNotFoundException extends RuntimeException {

    public PartnerNotFoundException(Long partnerId) {
        super("Partner not found with id: " + partnerId);
    }
}
