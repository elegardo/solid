package cl.mobdev.onboarding.liskov.badRobot;

import cl.mobdev.onboarding.liskov.badRobot.domain.Vehicle;

public class VehicleInventoryRobot {

  private final int costByWheel = 10;
  private final int costByDoor = 50;

  public int calculateTotalCost(Vehicle vehicle) {
    return costByWheel * vehicle.numberOfWheels() + costByDoor * vehicle.numberOfDoors();
  }
}
