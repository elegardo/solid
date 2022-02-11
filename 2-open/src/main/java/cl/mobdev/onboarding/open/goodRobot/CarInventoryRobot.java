package cl.mobdev.onboarding.open.goodRobot;

import cl.mobdev.onboarding.open.goodRobot.domain.Car;

public class CarInventoryRobot {

  private final int costByWheel = 50;

  public int calculateTotalCost(Car car) {
    return costByWheel * car.getNumberOfDoors();
  }

}
