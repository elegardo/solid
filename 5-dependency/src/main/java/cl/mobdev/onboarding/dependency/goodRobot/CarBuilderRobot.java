package cl.mobdev.onboarding.dependency.goodRobot;

import cl.mobdev.onboarding.dependency.goodRobot.domain.Car;
import cl.mobdev.onboarding.dependency.goodRobot.domain.Engine;

public class CarBuilderRobot {

  public Car makeANewCar(Engine engine) {

    //initialize building a new Car
    Car newCar = new Car();

    //install engine with capacity provided
    newCar.setEngine(engine);

    return newCar;
  }

}
