package com.seedafricaorgtech.MyRent.service.api.controller;

import com.seedafricaorgtech.MyRent.service.api.dto.BusinessDto;
import com.seedafricaorgtech.MyRent.service.api.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/business")
public class BusinessController {
    private final BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    // Add Business REST API
    @PostMapping
    public ResponseEntity<BusinessDto> addBusiness(@RequestBody BusinessDto businessDto){
        // Assuming createBusiness method exists in BusinessService
        BusinessDto createdBusiness = businessService.createBusiness(businessDto);
        return new ResponseEntity<>(createdBusiness, HttpStatus.CREATED);
    }
}