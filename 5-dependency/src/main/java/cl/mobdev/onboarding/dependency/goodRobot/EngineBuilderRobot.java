package cl.mobdev.onboarding.dependency.goodRobot;

import cl.mobdev.onboarding.dependency.domain.Engine;

public class EngineBuilderRobot {

  Engine makeANewEngine(int capacity) {

    //initialize building a new Engine
    Engine newEngine = new Engine();

    //setting capacity
    newEngine.setCapacity(capacity);

    //calculation total weight
    newEngine.setWeight(weightCalculation(capacity));

    return newEngine;
  }

  private double weightCalculation(int capacity) {
    return capacity * 0.1;
  }

}
