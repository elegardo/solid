package cl.mobdev.onboarding.liskov.badRobot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.mobdev.onboarding.liskov.badRobot.domain.Car;
import cl.mobdev.onboarding.liskov.badRobot.domain.Motorcycle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VehicleInventoryRobotTest {

  private CarBuilderRobot carBuilderRobot;
  private MotorcycleBuilderRobot motorcycleBuilderRobot;
  private VehicleInventoryRobot vehicleInventoryRobot;

  @BeforeEach
  void setUp() {
    carBuilderRobot = new CarBuilderRobot();
    motorcycleBuilderRobot = new MotorcycleBuilderRobot();
    vehicleInventoryRobot = new VehicleInventoryRobot();
  }

  @Test
  void should_return_correct_cost_when_calculate_2_cars() {
    int costExpected = 450;

    Car car1 = carBuilderRobot.makeANewCar();
    Car car2 = carBuilderRobot.makeANewCar();

    int totalCost = vehicleInventoryRobot.calculateTotalCost(car1)
        + vehicleInventoryRobot.calculateTotalCost(car2);

    assertEquals(costExpected, totalCost);
  }

  @Test
  void should_return_correct_cost_when_calculate_3_cars() {
    int costExpected = 675;

    Car car1 = carBuilderRobot.makeANewCar();
    Car car2 = carBuilderRobot.makeANewCar();
    Car car3 = carBuilderRobot.makeANewCar();

    int totalCost = vehicleInventoryRobot.calculateTotalCost(car1)
        + vehicleInventoryRobot.calculateTotalCost(car2)
        + vehicleInventoryRobot.calculateTotalCost(car3);

    assertEquals(costExpected, totalCost);
  }

  /**
   * Segun un estudio del departamento de marketing los nuevos mercados
   * a los que se esta abriendo la empresa tienen grandes problemas de
   * congestion, por lo tanto es necesario dar prioridad a la construccion
   * de motocicletas para no perder cuotas de mercado.
   **/

  @Test
  void should_return_correct_cost_when_calculate_1_motorcycle() {
    /*
     * El robot VehicleInventoryRobot recibe como parametro un objeto Vehicle,
     * cuando se envia un objeto Car funciona porque Car es hija de Vehicule,
     * pero si se envia Motorcycle, a pesar de tambien ser hija de Vehicule,
     * lanza una excepcion, por lo tanto viola el principio de sustitucion de Liskov
     */

    int costExpected = 100;

    Motorcycle motorcycle = motorcycleBuilderRobot.makeANewMotorcycle();

    int totalCost = vehicleInventoryRobot.calculateTotalCost(motorcycle);

    assertEquals(costExpected, totalCost);
  }

}
