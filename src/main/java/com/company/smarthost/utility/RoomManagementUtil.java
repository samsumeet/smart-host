package com.company.smarthost.utility;

import com.company.smarthost.domain.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RoomManagementUtil {

  public static long totalEconomyRooms(ArrayList<Integer> guestReadyToPayInEuro) {
    return guestReadyToPayInEuro.stream()
        .filter(value -> value < CommonConstants.ECONOMY_TO_PREMIUM_ROOM_THRESHOLD).count();
  }

  public static Response getRoomsOccupiedAndRevenue(Response response,
      ArrayList<Integer> guestReadyToPayInEuro, Integer freePremiumRooms,
      Integer freeEconomyRooms) {
    Collections.sort(guestReadyToPayInEuro, Comparator.reverseOrder());

    long totalEconomyRooms = totalEconomyRooms(guestReadyToPayInEuro);
    int premiumRoomCount = 0, economyRoomCount = 0;

    for (int i = 0; i < guestReadyToPayInEuro.size(); i++) {

      if (guestReadyToPayInEuro.get(i) >= CommonConstants.ECONOMY_TO_PREMIUM_ROOM_THRESHOLD
          && premiumRoomCount < freePremiumRooms ||
          (premiumRoomCount < freePremiumRooms && totalEconomyRooms > freeEconomyRooms)) {

        response.setPremiumRoomPrice(
            guestReadyToPayInEuro.get(i) + response.getPremiumRoomPrice());
        premiumRoomCount++;

      } else if (guestReadyToPayInEuro.get(i) < CommonConstants.ECONOMY_TO_PREMIUM_ROOM_THRESHOLD
          && economyRoomCount < freeEconomyRooms) {

        response.setEconomyRoomPrice(
            guestReadyToPayInEuro.get(i) + response.getEconomyRoomPrice());
        economyRoomCount++;
      }
    }
    response.setPremiumRoom(premiumRoomCount);
    response.setEconomyRoom(economyRoomCount);

    return response;
  }
}
