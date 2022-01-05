package cl.mobdev.onboarding.open.goodRobot.domain;

abstract public class Car {

  private int numberOfWheels;
  private int numberOfSecurityBelts;

  public int getNumberOfWheels() {
    return numberOfWheels;
  }

  public void setNumberOfWheels(int numberOfWheels) {
    this.numberOfWheels = numberOfWheels;
  }

  public int getNumberOfSecurityBelts() {
    return numberOfSecurityBelts;
  }

  public void setNumberOfSecurityBelts(int numberOfSecurityBelts) {
    this.numberOfSecurityBelts = numberOfSecurityBelts;
  }
}
