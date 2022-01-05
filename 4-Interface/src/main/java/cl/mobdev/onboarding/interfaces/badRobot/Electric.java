package cl.mobdev.onboarding.interfaces.badRobot;

import cl.mobdev.onboarding.interfaces.domain.Car;

public class Electric extends Car implements Mobilizable {

  @Override
  public int numberOfWheels() {
    return 4;
  }

  @Override
  public double maximumFuelCapacityInLiters() {
    throw new UnsupportedOperationException("Electric cars don't use fuel");
  }

  @Override
  public int maximumSpeedInKilometersByHours() {
    return 150;
  }

  public double maximumElectricCapacityInKilowattsByHour(){
    return 100;
  }

}
