package cl.mobdev.onboarding.open.badRobot;

import cl.mobdev.onboarding.open.badRobot.domain.Car;

public class CarInventoryRobot {

  private final int costByWheel = 50;
  private final int costBySecurityBelt = 5;

  private final int wheelsBySedanCar = 4;
  private final int beltsBySedanCar = 5;

  private final int wheelsBySuvCar = 4;
  private final int beltsBySuvCar = 5;

  private final int wheelsByOffRoadCar = 5;
  private final int beltsByOffRoadCar = 4;

  public int calculateTotalCost(Car car) {
    int totalCost = 0;

    if ("sedan".equals(car.getModel())) {
      totalCost = costByWheel * wheelsBySedanCar
          + costBySecurityBelt * beltsBySedanCar;
    } else if ("suv".equals(car.getModel())) {
      totalCost = costByWheel * wheelsBySuvCar
          + costBySecurityBelt * beltsBySuvCar;
    } else if ("offRoad".equals(car.getModel())) {
      totalCost = costByWheel * wheelsByOffRoadCar
          + costBySecurityBelt * beltsByOffRoadCar;
    }

    return totalCost;
  }
}
