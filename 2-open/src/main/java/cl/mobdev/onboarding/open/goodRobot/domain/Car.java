package cl.mobdev.onboarding.open.goodRobot.domain;

abstract public class Car {

  private final int numberOfDoors;

  protected Car(int numberOfDoors) {
    this.numberOfDoors = numberOfDoors;
  }

  public int getNumberOfDoors() {
    return numberOfDoors;
  }

}
