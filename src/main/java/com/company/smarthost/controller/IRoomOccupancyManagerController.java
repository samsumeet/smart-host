package com.company.smarthost.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("smarthost")
public interface IRoomOccupancyManagerController {

  @ApiOperation(value = "Retrieve rooms occupied and Money hotel will make")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 500, message = "Failure")})
  @GetMapping(value = "/room-occupancy", produces = {MediaType.APPLICATION_JSON_VALUE})
  ResponseEntity getRoomsOccupiedAndRevenue(@RequestParam Integer freePremiumRooms,
      @RequestParam Integer freeEconomyRooms);
}
