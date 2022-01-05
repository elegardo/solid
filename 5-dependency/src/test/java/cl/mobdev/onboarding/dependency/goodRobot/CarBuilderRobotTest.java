package cl.mobdev.onboarding.dependency.goodRobot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.mobdev.onboarding.dependency.domain.Car;
import cl.mobdev.onboarding.dependency.domain.Engine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarBuilderRobotTest {

  private CarBuilderRobot carBuilderRobot;
  private EngineBuilderRobot engineBuilderRobot;

  @BeforeEach
  void setUp() {
    carBuilderRobot = new CarBuilderRobot();
    engineBuilderRobot = new EngineBuilderRobot();
  }

  @Test
  void should_a_make_a_new_car_with_engine_of_1600cc_capacity() {
    int capacityExpected = 1600;

    Engine newEngine = engineBuilderRobot.makeANewEngine(1600);
    Car newCar = carBuilderRobot.makeANewCar(newEngine);

    assertEquals(capacityExpected, newCar.getEngine().getCapacity());
  }

  @Test
  void should_a_make_a_new_car_with_engine_of_160_weight() {
    int weightExpected = 160;

    Engine newEngine = engineBuilderRobot.makeANewEngine(1600);
    Car newCar = carBuilderRobot.makeANewCar(newEngine);

    assertEquals(weightExpected, newCar.getEngine().getWeight());
  }

  /*
  * El robot CarBuilderRobot recibe un motor que sera ensamblado en
  * el nuevo auto, delegando la responsabilidad de la contrucción
  * del motor al robot EngineBuilderRobot. Por lo tanto, es posible
  * construir autos con distintos tipos de motores.
  */

  @Test
  void should_a_make_a_new_car_with_engine_of_2000cc_capacity() {
    int capacityExpected = 2000;
    int weightExpected = 200;

    Engine newEngine = engineBuilderRobot.makeANewEngine(2000);
    Car newCar = carBuilderRobot.makeANewCar(newEngine);

    assertEquals(capacityExpected, newCar.getEngine().getCapacity());
    assertEquals(weightExpected, newCar.getEngine().getWeight());
  }

}
