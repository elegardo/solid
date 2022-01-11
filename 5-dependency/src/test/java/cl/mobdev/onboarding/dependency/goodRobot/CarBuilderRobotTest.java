package cl.mobdev.onboarding.dependency.goodRobot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.mobdev.onboarding.dependency.goodRobot.domain.Capacity1600CC;
import cl.mobdev.onboarding.dependency.goodRobot.domain.Capacity2000CC;
import cl.mobdev.onboarding.dependency.goodRobot.domain.Car;
import cl.mobdev.onboarding.dependency.goodRobot.domain.Engine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarBuilderRobotTest {

  private CarBuilderRobot carBuilderRobot;
  private EngineBuilderRobot engineBuilderRobot;

  @BeforeEach
  void setUp() {
    carBuilderRobot = new CarBuilderRobot();
  }

  @Test
  void should_a_make_a_new_car_with_engine_of_1600cc_capacity() {
    int capacityExpected = 1600;

    engineBuilderRobot = new EngineBuilderRobot();
    Engine newEngine1600CC = engineBuilderRobot.makeANewEngine(new Capacity1600CC());
    Car newCar = carBuilderRobot.makeANewCar(newEngine1600CC);

    assertEquals(capacityExpected, newCar.getEngine().getCapacity().maximumCapacityInCentimetersCubic());
  }

  @Test
  void should_a_make_a_new_car_with_engine_of_160_weight() {
    int weightExpected = 160;

    engineBuilderRobot = new EngineBuilderRobot();
    Engine newEngine1600CC = engineBuilderRobot.makeANewEngine(new Capacity1600CC());
    Car newCar = carBuilderRobot.makeANewCar(newEngine1600CC);

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

    engineBuilderRobot = new EngineBuilderRobot();
    Engine newEngine2000CC = engineBuilderRobot.makeANewEngine(new Capacity2000CC());
    Car newCar = carBuilderRobot.makeANewCar(newEngine2000CC);

    assertEquals(capacityExpected, newCar.getEngine().getCapacity().maximumCapacityInCentimetersCubic());
    assertEquals(weightExpected, newCar.getEngine().getWeight());
  }

}
