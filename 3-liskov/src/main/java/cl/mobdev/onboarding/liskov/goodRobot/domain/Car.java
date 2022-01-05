package cl.mobdev.onboarding.liskov.goodRobot.domain;

public class Car extends Vehicle {

  public int numberOfSecurityBelt() {
    return 5;
  }

  @Override
  public int numberOfWheels() {
    return 4;
  }

}
