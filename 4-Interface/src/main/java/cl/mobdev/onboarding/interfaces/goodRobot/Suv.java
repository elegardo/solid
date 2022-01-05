package cl.mobdev.onboarding.interfaces.goodRobot;

import cl.mobdev.onboarding.interfaces.domain.Car;

public class Suv extends Car implements Mobilizable, FuelCapacity {

  @Override
  public int numberOfWheels() {
    return 4;
  }

  @Override
  public int maximumFuelCapacityInLiters() {
    return 60;
  }

  @Override
  public int maximumSpeedInKilometersByHours() {
    return 200;
  }
}
