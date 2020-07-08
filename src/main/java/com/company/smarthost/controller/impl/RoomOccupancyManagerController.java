package com.company.smarthost.controller.impl;

import com.company.smarthost.controller.IRoomOccupancyManagerController;
import com.company.smarthost.service.IRoomOccupancyManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RoomOccupancyManagerController implements IRoomOccupancyManagerController {

  @Autowired
  private IRoomOccupancyManagerService roomOccupancyManagerService;

  @Override
  public ResponseEntity getRoomsOccupiedAndRevenue(Integer freePremiumRooms,
      Integer freeEconomyRooms) {
    return roomOccupancyManagerService
        .getRoomsOccupiedAndRevenue(freePremiumRooms, freeEconomyRooms);
  }
}
