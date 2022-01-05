package cl.mobdev.onboarding.single.badRobot;

import cl.mobdev.onboarding.single.domain.Car;
import cl.mobdev.onboarding.single.domain.Engine;

public class CarBuilderRobot {

  // Es responsable de construir un auto
  public Car makeANewCar() {

    //initialize building a new Car
    Car newCar = new Car();

    //send to paint a car
    Car newCarPainted = paintRedColor(newCar);

    //make a new engine
    Engine engine = makeANewEngine();

    //install new engine in car
    newCarPainted.setEngine(engine);

    return newCarPainted;
  }

  // Es responsable de pintar el auto
  private Car paintRedColor(Car car) {
    final String colorAvailable = "red";
    car.setColor(colorAvailable);
    return car;
  }

  // Es responsable de construir el motor para el auto
  private Engine makeANewEngine() {
    final int capacityInCentimetersCubic = 1600;
    final double weightInKilograms = capacityInCentimetersCubic * 0.1;

    Engine engine = new Engine();
    engine.setCapacity(capacityInCentimetersCubic);
    engine.setWeight(weightInKilograms);

    return engine;
  }

}
