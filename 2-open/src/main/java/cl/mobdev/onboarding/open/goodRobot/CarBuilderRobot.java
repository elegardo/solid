package cl.mobdev.onboarding.open.goodRobot;

import cl.mobdev.onboarding.open.goodRobot.domain.CoupeCar;
import cl.mobdev.onboarding.open.goodRobot.domain.OffRoadCar;
import cl.mobdev.onboarding.open.goodRobot.domain.SedanCar;
import cl.mobdev.onboarding.open.goodRobot.domain.SuvCar;

public class CarBuilderRobot {

  public SedanCar makeANewSedan() {
    int numberOfWheels = 4;
    int numberOfSecurityBelts = 5;

    return new SedanCar(numberOfWheels, numberOfSecurityBelts);
  }

  public SuvCar makeANewSuvCar() {
    int numberOfWheels = 4;
    int numberOfSecurityBelts = 5;

    return new SuvCar(numberOfWheels, numberOfSecurityBelts);
  }

  public OffRoadCar makeANewOffRoad() {
    int numberOfWheels = 5;
    int numberOfSecurityBelts = 4;

    return new OffRoadCar(numberOfWheels, numberOfSecurityBelts);
  }

  public CoupeCar makeANewCoupeCar() {
    int numberOfWheels = 4;
    int numberOfSecurityBelts = 2;

    return new CoupeCar(numberOfWheels, numberOfSecurityBelts);
  }
}
