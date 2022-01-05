package cl.mobdev.onboarding.single.goodRobot;

import cl.mobdev.onboarding.single.domain.Car;

public class CarPainterRobot {

  public Car paintRedColor(Car car) {
    final String color = "red";

    //paint a car with available color
    car.setColor(color);

    return car;
  }

  public Car paintBlueColor(Car car) {
    final String color = "blue";

    //paint a car with available color
    car.setColor(color);

    return car;
  }

  public Car paintBlackColor(Car car) {
    final String color = "black";

    //paint a car with available color
    car.setColor(color);

    return car;
  }

}
