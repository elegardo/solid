package cl.mobdev.onboarding.open.badRobot;

import cl.mobdev.onboarding.open.badRobot.domain.Car;

public class CarBuilderRobot {

  public Car makeANewSedan() {
    String model = "sedan";

    return new Car(model);
  }

  public Car makeANewSuv() {
    String model = "suv";

    return new Car(model);
  }

  public Car makeANewOffRoad() {
    String model = "offRoad";

    return new Car(model);
  }

  public Car makeANewCoupe() {
    String model = "coupe";

    return new Car(model);
  }

}
