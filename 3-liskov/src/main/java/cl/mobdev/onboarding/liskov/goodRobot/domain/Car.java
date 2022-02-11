package cl.mobdev.onboarding.liskov.goodRobot.domain;

public class Car extends Vehicle {

  @Override
  public int numberOfWheels() {
    return 4;
  }

  public int numberOfDoors() {
    return 4;
  }

}
