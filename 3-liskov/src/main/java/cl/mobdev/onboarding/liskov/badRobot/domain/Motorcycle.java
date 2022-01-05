package cl.mobdev.onboarding.liskov.badRobot.domain;

public class Motorcycle extends Vehicle {

  @Override
  public int numberOfWheels() {
    return 2;
  }

  @Override
  public int numberOfSecurityBelt() {
    throw new UnsupportedOperationException("Motorbikes don't have security belts");
  }

}
