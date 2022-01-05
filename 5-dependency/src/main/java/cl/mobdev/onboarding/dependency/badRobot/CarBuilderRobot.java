package cl.mobdev.onboarding.dependency.badRobot;

import cl.mobdev.onboarding.dependency.domain.Car;
import cl.mobdev.onboarding.dependency.domain.Engine;

public class CarBuilderRobot {

  Car makeANewCar() {

    //initialize building a new Car
    Car newCar = new Car();

    //make a new engine
    Engine engine = makeANewEngine();

    //install new engine in car
    newCar.setEngine(engine);

    return newCar;
  }

  private Engine makeANewEngine() {
    final int capacityInCentimetersCubic = 1600;
    final double weightInKilograms = capacityInCentimetersCubic * 0.1;

    Engine engine = new Engine();
    engine.setCapacity(capacityInCentimetersCubic);
    engine.setWeight(weightInKilograms);

    return engine;
  }

}
