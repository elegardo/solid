package cl.mobdev.onboarding.single.badRobot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import cl.mobdev.onboarding.single.domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarBuilderRobotTest {

  private CarBuilderRobot carBuilderRobot;

  @BeforeEach
  void setUp() {
    carBuilderRobot = new CarBuilderRobot();
  }

  @Test
  void should_a_make_a_new_car_red_color() {
    String colorExpected = "red";

    Car newCar = carBuilderRobot.makeANewCar();

    assertEquals(colorExpected, newCar.getColor());
  }

  @Test
  void should_a_make_a_new_car_with_engine_capacity_1600() {
    int capacityExpected = 1600;

    Car newCar = carBuilderRobot.makeANewCar();

    assertEquals(capacityExpected, newCar.getEngine().getCapacity());
  }

  @Test
  void should_a_make_a_new_car_with_engine_weight_equal_to_160() {
    int weightExpected = 160;

    Car newCar = carBuilderRobot.makeANewCar();

    assertEquals(weightExpected, newCar.getEngine().getWeight());
  }

  /**
   * La empresa acaba de concretar un muy buen negocio con un partner
   * en el cual podra venderles motores a un muy buen precio
   **/

  @Test
  void should_a_make_a_new_engine_weight_equal_to_160() {

    /*
     * Para construir un motor el robot CarBuilderRobot primero debe
     * construir un auto, al no tener responsabilidades separadas existe
     * dependencias entre las distintas actividades
     */

    fail("Robot CarInventoryRobot don't can build engines!");
  }

}
