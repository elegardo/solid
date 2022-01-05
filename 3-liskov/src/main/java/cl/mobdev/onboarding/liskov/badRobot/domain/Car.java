package cl.mobdev.onboarding.liskov.badRobot.domain;

public class Car extends Vehicle {

  @Override
  public int numberOfSecurityBelt() {
    return 5;
  }

  @Override
  public int numberOfWheels() {
    return 4;
  }

}
