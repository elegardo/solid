package cl.mobdev.onboarding.dependency.badRobot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import cl.mobdev.onboarding.dependency.domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarBuilderRobotTest {

  private CarBuilderRobot carBuilderRobot;

  @BeforeEach
  void setUp() {
    carBuilderRobot = new CarBuilderRobot();
  }

  @Test
  void should_a_make_a_new_car_with_engine_of_1600cc_capacity() {
    int capacityExpected = 1600;

    Car newCar = carBuilderRobot.makeANewCar();

    assertEquals(capacityExpected, newCar.getEngine().getCapacity());
  }

  @Test
  void should_a_make_a_new_car_with_engine_of_160_weight() {
    int weightExpected = 160;

    Car newCar = carBuilderRobot.makeANewCar();

    assertEquals(weightExpected, newCar.getEngine().getWeight());
  }

  /**
   * El area de negocios ha cerrado un contrato gubernamental en el
   * que se comprometen a vender unas 10.000 unidades de autos nuevos,
   * pero debido a una necesidad especifica del gobierno los motores deben
   * tener una capacidad de 2.000 cc
   **/

  @Test
  void should_a_make_a_new_car_with_engine_of_2000cc_capacity() {
    fail("Robot CarBuilderRobot don't build engines with this capacity!");
  }

}
