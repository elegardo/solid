package cl.mobdev.onboarding.open.badRobot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.mobdev.onboarding.open.badRobot.domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarInventoryRobotTest {

  private CarBuilderRobot carBuilderRobot;
  private CarInventoryRobot carInventoryRobot;

  @BeforeEach
  void setUp() {
    carBuilderRobot = new CarBuilderRobot();
    carInventoryRobot = new CarInventoryRobot();
  }

  @Test
  void should_return_correct_cost_when_calculate_3_sedan_cars() {
    int costExpected = 600;

    Car sedanCar1 = carBuilderRobot.makeANewSedan();
    Car sedanCar2 = carBuilderRobot.makeANewSedan();
    Car sedanCar3 = carBuilderRobot.makeANewSedan();

    int totalCost = carInventoryRobot.calculateTotalCost(sedanCar1)
        + carInventoryRobot.calculateTotalCost(sedanCar2)
        + carInventoryRobot.calculateTotalCost(sedanCar3);

    assertEquals(costExpected, totalCost);
  }

  @Test
  void should_return_correct_cost_when_calculate_1_suv_car_1_suv_car_1_offRoad_car() {
    int costExpected = 550;

    Car sedanCar = carBuilderRobot.makeANewSedan();
    Car suvCar = carBuilderRobot.makeANewSuv();
    Car offRoadCar = carBuilderRobot.makeANewOffRoad();

    int totalCost = carInventoryRobot.calculateTotalCost(sedanCar)
        + carInventoryRobot.calculateTotalCost(suvCar)
        + carInventoryRobot.calculateTotalCost(offRoadCar);

    assertEquals(costExpected, totalCost);
  }

  /**
   * El area de innovacion a desarrollado el modelo Coupe de la marca, se espera
   * que la produccion comience lo antes posible y asi satisfacer la creciente
   * demanda por este tipo de modelo
   **/

  @Test
  void should_return_correct_cost_of_wheels_when_calculate_2_coupe_car() {
    int costExpected = 100;

    Car coupeCar1 = carBuilderRobot.makeANewCoupe();
    Car coupeCar2 = carBuilderRobot.makeANewCoupe();

    int totalCost = carInventoryRobot.calculateTotalCost(coupeCar1)
        + carInventoryRobot.calculateTotalCost(coupeCar2);

    assertEquals(costExpected, totalCost);
  }

}
