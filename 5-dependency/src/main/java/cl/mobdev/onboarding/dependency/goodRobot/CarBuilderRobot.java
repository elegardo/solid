package cl.mobdev.onboarding.dependency.goodRobot;

import cl.mobdev.onboarding.dependency.domain.Car;
import cl.mobdev.onboarding.dependency.domain.Engine;

public class CarBuilderRobot {

  Car makeANewCar(Engine engine) {

    //initialize building a new Car
    Car newCar = new Car();

    //install engine provided in car
    newCar.setEngine(engine);

    return newCar;
  }

}
