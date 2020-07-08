package com.company.smarthost.service.impl;

import com.company.smarthost.domain.Response;
import com.company.smarthost.service.IRoomOccupancyManagerService;
import com.company.smarthost.utility.RoomManagementUtil;
import com.company.smarthost.utility.CommonConstants;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class RoomOccupancyManagerService implements IRoomOccupancyManagerService {

  @Override
  public ResponseEntity getRoomsOccupiedAndRevenue(Integer freePremiumRooms,
      Integer freeEconomyRooms) {
    if (freeEconomyRooms == 0 && freePremiumRooms == 0) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    Response response = new Response();
    ArrayList<Integer> guestReadyToPayInEuro = CommonConstants.GUEST_READY_TO_PAY_IN_EURO;

    RoomManagementUtil.getRoomsOccupiedAndRevenue(response, guestReadyToPayInEuro, freePremiumRooms,
        freeEconomyRooms);

    return ResponseEntity.ok(response);
  }
}
