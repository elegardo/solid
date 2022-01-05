package cl.mobdev.onboarding.liskov.badRobot;

import cl.mobdev.onboarding.liskov.badRobot.domain.Car;

public class CarBuilderRobot {

  public Car makeANewCar() {

    //initialize building a new Car
    Car newCar = new Car();

    return newCar;
  }

}
