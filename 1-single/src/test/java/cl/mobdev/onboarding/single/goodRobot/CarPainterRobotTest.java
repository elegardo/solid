package cl.mobdev.onboarding.single.goodRobot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.mobdev.onboarding.single.domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarPainterRobotTest {

  private CarBuilderRobot carBuilderRobot;
  private CarPainterRobot carPainterRobot;

  @BeforeEach
  void setUp() {
    carBuilderRobot = new CarBuilderRobot();
    carPainterRobot = new CarPainterRobot();
  }

  /*
   * El robot CarPainterRobotTest puede pintar autos, incluso si
   * el motor no esta instalado, cada tarea es independiente, pueden
   * existir tareas paralelas que permitan optimizar el proceso.
   */

  @Test
  void should_a_painted_a_new_car_color_red() {
    String colorExpected = "red";

    Car newCar = carBuilderRobot.makeANewCar();
    Car carPainted = carPainterRobot.paintRedColor(newCar);

    assertEquals(colorExpected, carPainted.getColor());
  }

  @Test
  void should_a_painted_a_new_car_color_blue() {
    String colorExpected = "blue";

    Car newCar = carBuilderRobot.makeANewCar();
    Car carPainted = carPainterRobot.paintBlueColor(newCar);

    assertEquals(colorExpected, carPainted.getColor());
  }

  @Test
  void should_a_painted_a_new_car_color_black() {
    String colorExpected = "black";

    Car newCar = carBuilderRobot.makeANewCar();
    Car carPainted = carPainterRobot.paintBlackColor(newCar);

    assertEquals(colorExpected, carPainted.getColor());
  }

}
