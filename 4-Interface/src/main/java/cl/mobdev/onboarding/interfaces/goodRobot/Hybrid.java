package cl.mobdev.onboarding.interfaces.goodRobot;

import cl.mobdev.onboarding.interfaces.domain.Car;

public class Hybrid extends Car implements Mobilizable, ElectricCapacity, FuelCapacity {

  @Override
  public int numberOfWheels() {
    return 4;
  }

  @Override
  public int maximumSpeedInKilometersByHours() {
    return 150;
  }

  @Override
  public int maximumElectricCapacityInKilowattsByHour() {
    return 100;
  }

  @Override
  public int maximumFuelCapacityInLiters() {
    return 20;
  }
}
