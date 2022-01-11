package cl.mobdev.onboarding.dependency.badRobot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import cl.mobdev.onboarding.dependency.badRobot.domain.Capacity1600CC;
import cl.mobdev.onboarding.dependency.badRobot.domain.Engine;
import org.junit.jupiter.api.Test;

public class EngineBuilderRobotTest {

  private EngineBuilderRobot engineBuilderRobot;

  @Test
  void should_a_make_a_new_engine_with_1600cc_capacity() {
    int capacityExpected = 1600;

    engineBuilderRobot = new EngineBuilderRobot();
    Engine newEngine1600CC = engineBuilderRobot.makeANewEngine(new Capacity1600CC());

    assertEquals(capacityExpected, newEngine1600CC.getCapacity().maximumCapacityInCentimetersCubic());
  }

  @Test
  void should_a_make_a_new_engine_with_160_weigh() {
    int weighExpected = 160;

    engineBuilderRobot = new EngineBuilderRobot();
    Engine newEngine1600CC = engineBuilderRobot.makeANewEngine(new Capacity1600CC());

    assertEquals(weighExpected, newEngine1600CC.getWeight());
  }

  /**
   * El area de negocios ha cerrado un contrato gubernamental en el
   * que se comprometen a vender unas 10.000 unidades de autos nuevos,
   * pero debido a una necesidad especifica del gobierno los motores deben
   * tener una capacidad de 2.000 cc
   **/

  @Test
  void should_a_make_a_new_engine_of_2000cc_capacity() {
    fail("Robot EngineBuilderRobot don't build engines with this capacity!");
  }

}
