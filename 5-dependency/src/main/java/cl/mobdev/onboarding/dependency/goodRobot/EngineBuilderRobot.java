package cl.mobdev.onboarding.dependency.goodRobot;

import cl.mobdev.onboarding.dependency.goodRobot.domain.Capacity;
import cl.mobdev.onboarding.dependency.goodRobot.domain.Engine;

public class EngineBuilderRobot {

  public Engine makeANewEngine(Capacity capacity) {

    //initialize building a new Engine
    Engine engine = new Engine();

    //setting capacity
    engine.setCapacity(capacity);

    //calculation total weight
    engine.setWeight(weightCalculation(capacity.maximumCapacityInCentimetersCubic()));

    return engine;
  }

  private double weightCalculation(int capacity) {
    return capacity * 0.1;
  }

}
