package cl.mobdev.onboarding.single.goodRobot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.mobdev.onboarding.single.domain.Engine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EngineBuilderRobotTest {

  private EngineBuilderRobot engineBuilderRobot;

  @BeforeEach
  void setUp() {
    engineBuilderRobot = new EngineBuilderRobot();
  }

  /*
   * La creación del robot EngineBuilderRobot permite separar
   * responsabilidades, ahora cada robot hace tareas especificas
   * e independientes. Ahora es posible crear motores por separado
   * lo que permite dar solución al problema propuesto.
   */

  @Test
  void should_a_make_a_new_engine_with_capacity_1600() {
    int capacityExpected = 1600;

    Engine newEngine = engineBuilderRobot.makeANewEngine();

    assertEquals(capacityExpected, newEngine.getCapacity());
  }

  @Test
  void should_a_make_a_new_engine_with_weight_equal_to_160() {
    int weightExpected = 160;

    Engine newEngine = engineBuilderRobot.makeANewEngine();

    assertEquals(weightExpected, newEngine.getWeight());
  }

}
