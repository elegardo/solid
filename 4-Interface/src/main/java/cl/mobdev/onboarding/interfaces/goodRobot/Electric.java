package cl.mobdev.onboarding.interfaces.goodRobot;

import cl.mobdev.onboarding.interfaces.domain.Car;

public class Electric extends Car implements Mobilizable, ElectricCapacity {

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

}
