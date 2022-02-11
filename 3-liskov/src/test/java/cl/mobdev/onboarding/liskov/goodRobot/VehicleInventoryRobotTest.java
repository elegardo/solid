package cl.mobdev.onboarding.liskov.goodRobot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.mobdev.onboarding.liskov.goodRobot.domain.Car;
import cl.mobdev.onboarding.liskov.goodRobot.domain.Motorcycle;
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
    int costExpected = 440;

    Car car1 = carBuilderRobot.makeANewCar();
    Car car2 = carBuilderRobot.makeANewCar();

    int totalCost = vehicleInventoryRobot.calculateTotalCostOfWheels(car1)
        + vehicleInventoryRobot.calculateTotalCostOfDoors(car1)
        + vehicleInventoryRobot.calculateTotalCostOfWheels(car2)
        + vehicleInventoryRobot.calculateTotalCostOfDoors(car2);

    assertEquals(costExpected, totalCost);
  }

  @Test
  void should_return_correct_cost_when_calculate_3_cars() {
    int costExpected = 660;

    Car car1 = carBuilderRobot.makeANewCar();
    Car car2 = carBuilderRobot.makeANewCar();
    Car car3 = carBuilderRobot.makeANewCar();

    int totalCost = vehicleInventoryRobot.calculateTotalCostOfWheels(car1)
        + vehicleInventoryRobot.calculateTotalCostOfDoors(car1)
        + vehicleInventoryRobot.calculateTotalCostOfWheels(car2)
        + vehicleInventoryRobot.calculateTotalCostOfDoors(car2)
        + vehicleInventoryRobot.calculateTotalCostOfWheels(car3)
        + vehicleInventoryRobot.calculateTotalCostOfDoors(car3);

    assertEquals(costExpected, totalCost);
  }

  /*
   * Como el metodo calculateTotalCostOfWheels del robot VehicleInventoryRobot
   * calcula el costo de un vehiculo, puede calcular el costo de un automovil
   * y de una motocicleta porque ambos heredan de Vehicle, por lo tanto
   * cumple con el principio de sustitucion de Liskov
   */

  @Test
  void should_return_correct_cost_when_calculate_1_motorcycle() {
    int costExpected = 100;

    Motorcycle motorcycle = motorcycleBuilderRobot.makeANewMotorcycle();

    int totalCost = vehicleInventoryRobot.calculateTotalCostOfWheels(motorcycle);

    assertEquals(costExpected, totalCost);
  }

}
