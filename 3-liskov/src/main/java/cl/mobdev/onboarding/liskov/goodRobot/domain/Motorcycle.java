package cl.mobdev.onboarding.liskov.goodRobot.domain;

public class Motorcycle extends Vehicle {

  @Override
  public int numberOfWheels() {
    return 2;
  }

}
