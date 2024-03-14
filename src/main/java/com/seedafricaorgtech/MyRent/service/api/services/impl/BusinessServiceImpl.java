package com.seedafricaorgtech.MyRent.service.api.services.impl;

import com.seedafricaorgtech.MyRent.service.api.dto.BusinessDto;
import com.seedafricaorgtech.MyRent.service.api.entity.Business;
import com.seedafricaorgtech.MyRent.service.api.services.BusinessRepository;
import com.seedafricaorgtech.MyRent.service.api.services.BusinessService;
import com.seedafricaorgtech.MyRent.service.api.mapper.BusinessMapper;
import org.springframework.stereotype.Service;
@Service
public class BusinessServiceImpl implements BusinessService {

    private final BusinessRepository businessRepository;

    public BusinessServiceImpl(BusinessRepository businessRepository){
        this.businessRepository = businessRepository;
    }

    @Override
    public BusinessDto createBusiness(BusinessDto businessDto) {
        Business business = BusinessMapper.mapToBusiness(businessDto);
        Business savedBusiness = businessRepository.save(business);
        return BusinessMapper.mapToBusinessDto(savedBusiness);
    }
}

