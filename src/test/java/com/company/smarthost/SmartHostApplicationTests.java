package com.company.smarthost;

import static org.assertj.core.api.Assertions.assertThat;

import com.company.smarthost.controller.IRoomOccupancyManagerController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmartHostApplicationTests {

  @Autowired
  private IRoomOccupancyManagerController controller;

  @Test
  void contextLoads() {
    assertThat(controller).isNotNull();
  }


}
