package cl.mobdev.onboarding.open.goodRobot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.mobdev.onboarding.open.goodRobot.domain.CoupeCar;
import cl.mobdev.onboarding.open.goodRobot.domain.OffRoadCar;
import cl.mobdev.onboarding.open.goodRobot.domain.SedanCar;
import cl.mobdev.onboarding.open.goodRobot.domain.SuvCar;
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

    SedanCar sedanCar1 = carBuilderRobot.makeANewSedan();
    SedanCar sedanCar2 = carBuilderRobot.makeANewSedan();
    SedanCar sedanCar3 = carBuilderRobot.makeANewSedan();

    int totalCost = carInventoryRobot.calculateTotalCost(sedanCar1)
        + carInventoryRobot.calculateTotalCost(sedanCar2)
        + carInventoryRobot.calculateTotalCost(sedanCar3);

    assertEquals(costExpected, totalCost);
  }

  @Test
  void should_return_correct_cost_when_calculate_1_sedan_car_1_suv_car_1_offRoad_car() {
    int costExpected = 550;

    SedanCar sedanCar = carBuilderRobot.makeANewSedan();
    SuvCar suvCar = carBuilderRobot.makeANewSuvCar();
    OffRoadCar offRoadCar = carBuilderRobot.makeANewOffRoad();

    int totalCost = carInventoryRobot.calculateTotalCost(sedanCar)
        + carInventoryRobot.calculateTotalCost(suvCar)
        + carInventoryRobot.calculateTotalCost(offRoadCar);

    assertEquals(costExpected, totalCost);
  }

  /*
   * Un mejor modelo de dominio permite al nuevo CarInventoryRobot poder calcular
   * correctamente los costos del nuevo modelo Coupe, ademas, como esta cerrado
   * a modificacion y abierto a extension, puede calcular el costo cualquier objeto Car
   */

  @Test
  void should_return_correct_cost_of_wheels_when_calculate_2_coupe_car() {
    int costExpected = 200;

    CoupeCar coupeCar1 = carBuilderRobot.makeANewCoupeCar();
    CoupeCar coupeCar2 = carBuilderRobot.makeANewCoupeCar();

    int totalCost = carInventoryRobot.calculateTotalCost(coupeCar1)
        + carInventoryRobot.calculateTotalCost(coupeCar2);

    assertEquals(costExpected, totalCost);
  }

}
