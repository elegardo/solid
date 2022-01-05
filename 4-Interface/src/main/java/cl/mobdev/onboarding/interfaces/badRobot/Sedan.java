package cl.mobdev.onboarding.interfaces.badRobot;

import cl.mobdev.onboarding.interfaces.domain.Car;

public class Sedan extends Car implements Mobilizable {

  @Override
  public int numberOfWheels() {
    return 4;
  }

  @Override
  public double maximumFuelCapacityInLiters() {
    return 40;
  }

  @Override
  public int maximumSpeedInKilometersByHours() {
    return 220;
  }
}
