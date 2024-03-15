package com.seedafricaorgtech.MyRent.service.api.services;

import com.seedafricaorgtech.MyRent.service.api.dto.BusinessDto;
import com.seedafricaorgtech.MyRent.service.api.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {

}
