package cl.mobdev.onboarding.open.goodRobot;

import cl.mobdev.onboarding.open.goodRobot.domain.Car;

public class CarInventoryRobot {

  private final int costByWheel = 50;
  private final int costBySecurityBelt = 5;

  public int calculateTotalCost(Car car) {
    return costBySecurityBelt * car.getNumberOfSecurityBelts() + costByWheel * car.getNumberOfWheels();
  }

}
