package com.company.smarthost.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.company.smarthost.domain.Response;
import org.junit.jupiter.api.Test;

public class RoomManagementUtilTest {

  @Test
  public void test_roomsOccupiedAndRevenue_success() {

    assertEquals(738, RoomManagementUtil.getRoomsOccupiedAndRevenue(new Response(),
        CommonConstants.GUEST_READY_TO_PAY_IN_EURO, 3, 3).getPremiumRoomPrice());
  }

}
