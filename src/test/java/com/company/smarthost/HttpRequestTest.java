package com.company.smarthost;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void roomOccupancyManagerShouldReturnDefaultMessage() throws Exception {
    assertThat(this.restTemplate.getForObject("http://localhost:" + port
            + "/smarthost/room-occupancy?freeEconomyRooms=3&freePremiumRooms=3",
        String.class)).contains(
        "{\"premiumRoom\":3,\"economyRoom\":3,\"premiumRoomPrice\":738,\"economyRoomPrice\":167}");
  }
}