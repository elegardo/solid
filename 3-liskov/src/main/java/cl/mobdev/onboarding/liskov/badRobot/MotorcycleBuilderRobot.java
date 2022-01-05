package cl.mobdev.onboarding.liskov.badRobot;

import cl.mobdev.onboarding.liskov.badRobot.domain.Motorcycle;

public class MotorcycleBuilderRobot {

  public Motorcycle makeANewMotorcycle() {

    //initialize building a new Motorcycle
    Motorcycle newMotorcycle = new Motorcycle();

    return newMotorcycle;
  }

}
