package cl.mobdev.onboarding.liskov.badRobot;

import cl.mobdev.onboarding.liskov.badRobot.domain.Vehicle;

public class VehicleInventoryRobot {

  private final int costByWheel = 50;
  private final int costBySecurityBelt = 5;

  public int calculateTotalCost(Vehicle vehicle) {
    return costBySecurityBelt * vehicle.numberOfSecurityBelt() + costByWheel * vehicle.numberOfWheels();
  }
}
