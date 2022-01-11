package cl.mobdev.onboarding.dependency.badRobot;

import cl.mobdev.onboarding.dependency.badRobot.domain.Car;
import cl.mobdev.onboarding.dependency.badRobot.domain.Engine;

public class CarBuilderRobot {

  public Car makeANewCar(Engine engine) {

    //initialize building a new Car
    Car newCar = new Car();

    //install new engine in car
    newCar.setEngine(engine);

    return newCar;
  }

}
