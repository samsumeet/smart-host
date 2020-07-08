package com.company.smarthost.service;

import static org.mockito.Mockito.when;

import com.company.smarthost.WebMockTest;
import com.company.smarthost.domain.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
public class RoomOccupancyManagerServiceTest {

  @Autowired
  private IRoomOccupancyManagerService roomOccupancyManagerService;

  @Test
  public void test_getRoomsOccupiedAndRevenue_success() {
    Response response = WebMockTest.getMockedResponse();

    Assertions.assertEquals(((Response) roomOccupancyManagerService
            .getRoomsOccupiedAndRevenue(3, 3).getBody()).getPremiumRoomPrice(),
        response.getPremiumRoomPrice());

    Assertions.assertEquals(roomOccupancyManagerService
        .getRoomsOccupiedAndRevenue(3, 3).getStatusCode(), HttpStatus.OK);
  }

  @Test
  void test_ExpectedExceptionWithRoomsOccupiedAndRevenue() {
    Assertions.assertThrows(ResponseStatusException.class, () -> {
      roomOccupancyManagerService.getRoomsOccupiedAndRevenue(0, 0);
    });
  }

}
