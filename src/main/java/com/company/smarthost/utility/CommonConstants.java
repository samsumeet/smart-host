package com.company.smarthost.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonConstants {

  public static final int ECONOMY_TO_PREMIUM_ROOM_THRESHOLD = 100;
  public static final ArrayList<Integer> GUEST_READY_TO_PAY_IN_EURO = new ArrayList<>(
      Arrays.asList(23, 45, 155, 374, 22, 99, 100,
          101, 115, 209));

  private CommonConstants() {
  }

}
