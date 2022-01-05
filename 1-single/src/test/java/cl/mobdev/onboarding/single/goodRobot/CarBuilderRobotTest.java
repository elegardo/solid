package cl.mobdev.onboarding.single.goodRobot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.mobdev.onboarding.single.domain.Car;
import cl.mobdev.onboarding.single.domain.Engine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarBuilderRobotTest {

  private CarBuilderRobot carBuilderRobot;

  @BeforeEach
  void setUp() {
    carBuilderRobot = new CarBuilderRobot();
  }

  /*
   * El robot CarBuilderRobot ahora solo se dedica a construir autos,
   * las tareas de pintura y contruccion de motores las hacen otros robots.
   */

  @Test
  void should_a_make_a_new_car_without_painting() {
    String colorExpected = null;

    Car newCar = carBuilderRobot.makeANewCar();

    assertEquals(colorExpected, newCar.getColor());
  }

  @Test
  void should_a_make_a_new_car_without_engine() {
    Engine engineExpected = null;

    Car newCar = carBuilderRobot.makeANewCar();

    assertEquals(engineExpected, newCar.getEngine());
  }
}
