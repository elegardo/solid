package cl.mobdev.onboarding.open.goodRobot;

import cl.mobdev.onboarding.open.goodRobot.domain.CoupeCar;
import cl.mobdev.onboarding.open.goodRobot.domain.OffRoadCar;
import cl.mobdev.onboarding.open.goodRobot.domain.SedanCar;
import cl.mobdev.onboarding.open.goodRobot.domain.SuvCar;

public class CarBuilderRobot {

  public SedanCar makeANewSedan() {
    return new SedanCar();
  }

  public SuvCar makeANewSuvCar() {
    return new SuvCar();
  }

  public OffRoadCar makeANewOffRoad() {
    return new OffRoadCar();
  }

  public CoupeCar makeANewCoupeCar() {
    return new CoupeCar();
  }
}
