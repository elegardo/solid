package cl.mobdev.onboarding.liskov.goodRobot;

import cl.mobdev.onboarding.liskov.goodRobot.domain.Car;
import cl.mobdev.onboarding.liskov.goodRobot.domain.Vehicle;

public class VehicleInventoryRobot {

  private final int costByWheel = 50;
  private final int costBySecurityBelt = 5;

  public int calculateTotalCostOfWheels(Vehicle vehicle) {
    return costByWheel * vehicle.numberOfWheels();
  }

  public int calculateTotalCostOfSecurityBelts(Car car) {
    return costBySecurityBelt * car.numberOfSecurityBelt();
  }

}
