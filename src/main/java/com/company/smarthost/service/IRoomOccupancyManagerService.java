package com.company.smarthost.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IRoomOccupancyManagerService {

  ResponseEntity getRoomsOccupiedAndRevenue(Integer freePremiumRooms, Integer freeEconomyRooms);
}
