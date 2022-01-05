package cl.mobdev.onboarding.open.badRobot;

import cl.mobdev.onboarding.open.badRobot.domain.Car;

public class CarBuilderRobot {

  public Car makeANewSedan() {
    Car newCar = new Car();
    newCar.setModel("sedan");
    return newCar;
  }

  public Car makeANewSuv() {
    Car newCar = new Car();
    newCar.setModel("suv");
    return newCar;
  }


  public Car makeANewOffRoad() {
    Car newCar = new Car();
    newCar.setModel("offRoad");
    return newCar;
  }


}
