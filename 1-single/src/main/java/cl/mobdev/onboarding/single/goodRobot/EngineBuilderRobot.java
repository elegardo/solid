package cl.mobdev.onboarding.single.goodRobot;

import cl.mobdev.onboarding.single.domain.Engine;

public class EngineBuilderRobot {

  public Engine makeANewEngine() {
    final int capacityInCentimetersCubic = 1600;

    //initialize building a new Engine
    Engine newEngine = new Engine();

    //setting capacity
    newEngine.setCapacity(capacityInCentimetersCubic);

    //calculation total weight
    newEngine.setWeight(weightCalculation(capacityInCentimetersCubic));

    return newEngine;
  }

  private double weightCalculation(int capacityInCentimetersCubic) {
    return capacityInCentimetersCubic * 0.1;
  }

}
