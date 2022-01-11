package cl.mobdev.onboarding.dependency.badRobot;

import cl.mobdev.onboarding.dependency.badRobot.domain.Capacity1600CC;
import cl.mobdev.onboarding.dependency.badRobot.domain.Engine;

public class EngineBuilderRobot {

  public Engine makeANewEngine(Capacity1600CC capacity) {

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
