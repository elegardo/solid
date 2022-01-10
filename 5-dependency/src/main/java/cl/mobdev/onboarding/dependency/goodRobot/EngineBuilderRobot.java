package cl.mobdev.onboarding.dependency.goodRobot;

import cl.mobdev.onboarding.dependency.goodRobot.domain.Capacity;
import cl.mobdev.onboarding.dependency.goodRobot.domain.Engine;

public class EngineBuilderRobot {

  private final Capacity capacity;

  public EngineBuilderRobot(Capacity capacity) {
    this.capacity = capacity;
  }

  Engine makeANewEngine() {

    //initialize building a new Engine
    Engine engine = new Engine();

    //setting capacity
    engine.setCapacity(this.capacity.maximumCapacityInCentimetersCubic());

    //calculation total weight
    engine.setWeight(weightCalculation(this.capacity.maximumCapacityInCentimetersCubic()));

    return engine;
  }

  private double weightCalculation(int capacity) {
    return capacity * 0.1;
  }

}
