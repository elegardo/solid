package cl.mobdev.onboarding.dependency.goodRobot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.mobdev.onboarding.dependency.goodRobot.domain.Capacity1600CC;
import cl.mobdev.onboarding.dependency.goodRobot.domain.Capacity2000CC;
import cl.mobdev.onboarding.dependency.goodRobot.domain.Capacity2500CC;
import cl.mobdev.onboarding.dependency.goodRobot.domain.Engine;
import org.junit.jupiter.api.Test;

public class EngineBuilderRobotTest {

  private EngineBuilderRobot engineBuilderRobot;

  @Test
  void should_a_make_a_new_engine_with_1600cc_capacity() {
    int capacityExpected = 1600;

    engineBuilderRobot = new EngineBuilderRobot(new Capacity1600CC());
    Engine newEngine1600CC = engineBuilderRobot.makeANewEngine();

    assertEquals(capacityExpected, newEngine1600CC.getCapacity());
  }

  @Test
  void should_a_make_a_new_engine_with_2000cc_capacity() {
    int capacityExpected = 2000;

    engineBuilderRobot = new EngineBuilderRobot(new Capacity2000CC());
    Engine newEngine2000CC = engineBuilderRobot.makeANewEngine();

    assertEquals(capacityExpected, newEngine2000CC.getCapacity());
  }

  /*
   * El robot EngineBuilderRobot usa inyeccion de dependecias lo que permite
   * crear muchas instancias de él con distintas capacidades. Al aceptar una
   * interfaz es posible inyectar cualquier dependencia que implemente esa interfaz
   * sin ser necesario un cambio en la programacion de EngineBuilderRobot.
   * Por lo tanto, es posible delegar la responsabilidad de la capacidad en
   * distintas clases que pueden ser inyectadas en tiempo de construccion del robot.
   */

  @Test
  void should_a_make_a_new_engine_with_2500cc_capacity() {
    int capacityExpected = 2500;

    engineBuilderRobot = new EngineBuilderRobot(new Capacity2500CC());
    Engine newEngine2500CC = engineBuilderRobot.makeANewEngine();

    assertEquals(capacityExpected, newEngine2500CC.getCapacity());
  }

}
