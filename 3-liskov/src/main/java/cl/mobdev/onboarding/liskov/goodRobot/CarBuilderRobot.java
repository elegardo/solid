package cl.mobdev.onboarding.liskov.goodRobot;

import cl.mobdev.onboarding.liskov.goodRobot.domain.Car;

public class CarBuilderRobot {

  public Car makeANewCar() {

    //initialize building a new Car
    Car newCar = new Car();

    return newCar;
  }

}
