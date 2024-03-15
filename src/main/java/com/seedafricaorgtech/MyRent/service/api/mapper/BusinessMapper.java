package com.seedafricaorgtech.MyRent.service.api.mapper;

import com.seedafricaorgtech.MyRent.service.api.dto.BusinessDto;
import com.seedafricaorgtech.MyRent.service.api.entity.Business;
import org.springframework.stereotype.Component;

@Component
public class BusinessMapper {
    public static BusinessDto mapToBusinessDto(Business business){
        BusinessDto businessDto = new BusinessDto(

                business.getName(),
                business.getPhone_no(),
                business.getMomo_name(),
                business.getAcc_num(),
                business.getAcc_name()
        );
        return businessDto;
    }

    public static Business mapToBusiness(BusinessDto businessDto){
        Business business = new Business(
                businessDto.getName(),
                businessDto.getPhone_no(),
                businessDto.getMomo_name(),
                businessDto.getAcc_num(),
                businessDto.getAcc_name()
        );
        return business;
    }

}