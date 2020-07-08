package com.company.smarthost;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.company.smarthost.controller.IRoomOccupancyManagerController;
import com.company.smarthost.domain.Response;
import com.company.smarthost.service.IRoomOccupancyManagerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(IRoomOccupancyManagerController.class)
public class WebMockTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private IRoomOccupancyManagerService service;

  @Test
  public void roomOccupancyManagerShouldReturnMessageFromService() throws Exception {
    Response response = getMockedResponse();

    when(service.getRoomsOccupiedAndRevenue(3, 3)).thenReturn(ResponseEntity.ok(response));
    this.mockMvc.perform(get("/smarthost/room-occupancy?freeEconomyRooms=3&freePremiumRooms=3"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(
            "{\"premiumRoom\":3,\"economyRoom\":3,\"premiumRoomPrice\":738,\"economyRoomPrice\":167}"));
  }

  public static Response getMockedResponse() {

    Response response = new Response();
    response.setEconomyRoom(3);
    response.setPremiumRoom(3);
    response.setEconomyRoomPrice(167);
    response.setPremiumRoomPrice(738);
    return response;
  }
}