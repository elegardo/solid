package cl.mobdev.onboarding.open.badRobot;

import cl.mobdev.onboarding.open.badRobot.domain.Car;

public class CarInventoryRobot {

  private final int costByDoor = 50;

  private final int doorsBySedan = 4;
  private final int doorsBySuv = 5;
  private final int doorsByOffRoad = 2;

  public int calculateTotalCost(Car car) {

    if ("sedan".equals(car.getModel())) {

      return costByDoor * doorsBySedan;

    } else if ("suv".equals(car.getModel())) {

      return costByDoor * doorsBySuv;

    } else if ("offRoad".equals(car.getModel())) {

      return costByDoor * doorsByOffRoad;

    } else {

      throw new RuntimeException("Robot CarInventoryRobot don't can calculate cost for this model");

    }

  }
}
