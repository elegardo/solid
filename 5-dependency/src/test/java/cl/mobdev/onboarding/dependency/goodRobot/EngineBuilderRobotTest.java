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

  /*
   * El robot EngineBuilderRobot usa inyeccion de dependecias para construir motores
   * con distintas capacidades. Al aceptar una interfaz es posible inyectar cualquier
   * dependencia que implemente esa interfaz sin ser necesario un cambio en la programacion
   * de EngineBuilderRobot. Por lo tanto, es posible delegar la responsabilidad de
   * la capacidad en distintas clases que pueden ser inyectadas en tiempo de construccion del motor.
   */

  @Test
  void should_a_make_a_new_engine_with_2000cc_capacity() {
    int capacityExpected = 2000;

    engineBuilderRobot = new EngineBuilderRobot();
    Engine newEngine2000CC = engineBuilderRobot.makeANewEngine(new Capacity2000CC());

    assertEquals(capacityExpected, newEngine2000CC.getCapacity().maximumCapacityInCentimetersCubic());
  }

  @Test
  void should_a_make_a_new_engine_with_200_weigh() {
    int weighExpected = 200;

    engineBuilderRobot = new EngineBuilderRobot();
    Engine newEngine2000CC = engineBuilderRobot.makeANewEngine(new Capacity2000CC());

    assertEquals(weighExpected, newEngine2000CC.getWeight());
  }

  @Test
  void should_a_make_a_new_engine_with_2500cc_capacity() {
    int capacityExpected = 2500;

    engineBuilderRobot = new EngineBuilderRobot();
    Engine newEngine2500CC = engineBuilderRobot.makeANewEngine(new Capacity2500CC());

    assertEquals(capacityExpected, newEngine2500CC.getCapacity().maximumCapacityInCentimetersCubic());
  }

  @Test
  void should_a_make_a_new_engine_with_250_weigh() {
    int weighExpected = 250;

    engineBuilderRobot = new EngineBuilderRobot();
    Engine newEngine2500CC = engineBuilderRobot.makeANewEngine(new Capacity2500CC());

    assertEquals(weighExpected, newEngine2500CC.getWeight());
  }

}
