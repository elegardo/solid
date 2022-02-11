package cl.mobdev.onboarding.liskov.badRobot.domain;

public class Car extends Vehicle {

  @Override
  public int numberOfWheels() {
    return 4;
  }

  @Override
  public int numberOfDoors() {
    return 4;
  }

}
