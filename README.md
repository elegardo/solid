# Proyecto muldimodulo que contiene ejemplos de los principios S.O.L.I.D.

Para entender los principios SOLID imaginemos que trabajamos construyendo robots en una prestigiosa fabrica de autos.

Se usaran las definiciones de [Wikipedia](https://es.wikipedia.org/wiki/SOLID)

### Single Responsibility

> "Un objeto solo debería tener una única responsabilidad".

Modulo: [1-single](1-single/README.md)

Supongamos que hemos contruido un nuevo robot que construye autos llamado [CarBuilderRobot](1-single/src/main/java/cl/mobdev/onboarding/single/badRobot/CarBuilderRobot.java)

```java
public class CarBuilderRobot {

  public Car makeANewCar() {

    Car newCar = new Car();
    Car newCarPainted = paintRedColor(newCar);
    Engine engine1600CC = makeANewEngine();
    newCarPainted.setEngine(engine1600CC);

    return newCarPainted;
  }

  private Car paintRedColor(Car car) {
    final String colorAvailable = "red";
    car.setColor(colorAvailable);
    return car;
  }

  private Engine makeANewEngine() {
    final int capacityInCentimetersCubic = 1600;
    final double weightInKilograms = capacityInCentimetersCubic * 0.1;

    Engine engine1600CC = new Engine();
    engine1600CC.setCapacity(capacityInCentimetersCubic);
    engine1600CC.setWeight(weightInKilograms);

    return engine1600CC;
  }

}
```

Este robot tiene el metodo `makeANewCar()` que construye un auto pintado y con un motor instalado, totalmente funcional 
y listo para salir de la linea de montaje.

Una vez terminado el robot, nuestro supervisor desea someterlo a una serie de pruebas para certificar que 
todo funciona como se espera, asi que comienza a desarrollar varios test para probar su funcionalidad.

[CarBuilderRobotTest](1-single/src/test/java/cl/mobdev/onboarding/single/badRobot/CarBuilderRobotTest.java)
```java
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
```

El robot supera exitosamente los test del supervisor, pero ha llegado una nueva informacion:

> _"La empresa acaba de concretar un muy buen negocio con un partner, en dicho acuerdo nuestra compañia podra venderles 
> motores a un muy buen precio a nuestro partner"_

Este nuevo escenario obliga a crear un nuevo test para saber si nuestro robot es capaz de satisfacer 
el nuevo requerimiento.

```java
  @Test
  void should_a_make_a_new_engine_weight_equal_to_160() {
    fail("Robot CarBuilderRobot don't can build engines!");
  }
```

#### El problema:
Para construir un motor el robot `CarBuilderRobot` primero debe construir un auto, al no tener 
responsabilidades separadas existe dependencias entre las distintas actividades, lo que provoca
que sea muy poco factible usar el robot para construir solo motores.


#### La solucion:
Crear robots con responsabilidades distintas

* [CarBuilderRobot](1-single/src/main/java/cl/mobdev/onboarding/single/goodRobot/CarBuilderRobot.java)
* [CarPainterRobot](1-single/src/main/java/cl/mobdev/onboarding/single/goodRobot/CarPainterRobot.java)
* [EngineBuilderRobot](1-single/src/main/java/cl/mobdev/onboarding/single/goodRobot/EngineBuilderRobot.java)

y cuando cada uno de los robots se someten a los test, verificamos que la separacion de responsabilidades permite
satisfacer los nuevos requerimientos de la empresa.

[CarBuilderRobotTest](1-single/src/test/java/cl/mobdev/onboarding/single/goodRobot/CarBuilderRobotTest.java)

```java
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
```

[CarPainterRobotTest](1-single/src/test/java/cl/mobdev/onboarding/single/goodRobot/CarPainterRobotTest.java)

```java
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
```

[EngineBuilderRobotTest](1-single/src/test/java/cl/mobdev/onboarding/single/goodRobot/EngineBuilderRobotTest.java)

```java
  /*
   * La creación del robot EngineBuilderRobot permite separar
   * responsabilidades, ahora cada robot hace tareas especificas
   * e independientes. Ahora es posible crear motores por separado
   * lo que permite dar solución al problema propuesto.
   */

  @Test
  void should_a_make_a_new_engine_with_capacity_1600() {
    int capacityExpected = 1600;
    
    Engine newEngine1600CC = engineBuilderRobot.makeANewEngine();
      
    assertEquals(capacityExpected, newEngine1600CC.getCapacity());
  }

  @Test
  void should_a_make_a_new_engine_with_weight_equal_to_160() {
    int weightExpected = 160;

    Engine newEngine1600CC = engineBuilderRobot.makeANewEngine();

    assertEquals(weightExpected, newEngine1600CC.getWeight());
  }
```

---
## Open / Closed

> "Las entidades de software deben estar abiertas para su extensión, pero cerradas para su modificación".

Modulo: [2-open](2-open/README.md)

Hemos construido 2 robots, uno que construye autos ([CarBuilderRobot](2-open/src/main/java/cl/mobdev/onboarding/open/badRobot/CarBuilderRobot.java)) y otro que puede calcular el costo de produccion 
en base al costo de cada rueda y los cinturones de seguridad que tienen cada auto.

[CarInventoryRobot](2-open/src/main/java/cl/mobdev/onboarding/open/badRobot/CarInventoryRobot.java)
```java
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
      
      totalCost = costByWheel * wheelsBySedanCar + costBySecurityBelt * beltsBySedanCar;
      
    } else if ("suv".equals(car.getModel())) {
      
      totalCost = costByWheel * wheelsBySuvCar + costBySecurityBelt * beltsBySuvCar;
      
    } else if ("offRoad".equals(car.getModel())) {
      
      totalCost = costByWheel * wheelsByOffRoadCar + costBySecurityBelt * beltsByOffRoadCar;
      
    }

    return totalCost;
  }
}
```

Para probar el robot de inventarios el jefe de finazas crea los siguientes test:

[CarInventoryRobotTest](2-open/src/test/java/cl/mobdev/onboarding/open/badRobot/CarInventoryRobotTest.java)
```java
  @Test
  void should_return_correct_cost_when_calculate_3_sedan_cars() {
    int costExpected = 675;
    
    Car sedanCar1 = carBuilderRobot.makeANewSedan();
    Car sedanCar2 = carBuilderRobot.makeANewSedan();
    Car sedanCar3 = carBuilderRobot.makeANewSedan();
    
    int totalCost = carInventoryRobot.calculateTotalCost(sedanCar1)
      + carInventoryRobot.calculateTotalCost(sedanCar2)
      + carInventoryRobot.calculateTotalCost(sedanCar3);
    
    assertEquals(costExpected, totalCost);
  }

  @Test
  void should_return_correct_cost_when_calculate_1_sedan_car_1_suv_car_1_offRoad_car() {
    int costExpected = 720;

    Car sedanCar = carBuilderRobot.makeANewSedan();
    Car suvCar = carBuilderRobot.makeANewSuv();
    Car offRoadCar = carBuilderRobot.makeANewOffRoad();

    int totalCost = carInventoryRobot.calculateTotalCost(sedanCar)
      + carInventoryRobot.calculateTotalCost(suvCar)
      + carInventoryRobot.calculateTotalCost(offRoadCar);

      assertEquals(costExpected, totalCost);
  }

```

El robot supera exitosamente los test, pero ha llegado una nueva informacion:

> _"El area de innovacion a desarrollado el modelo Coupe de la marca, se espera que la produccion comience 
> lo antes posible y asi satisfacer la creciente demanda por este tipo de modelo"_

Este nuevo escenario obliga a crear un nuevo test para saber si nuestro robot es capaz de satisfacer
el nuevo requerimiento.

```java
  @Test
  void should_return_correct_cost_of_wheels_when_calculate_2_coupe_car() {
      fail("Robot CarInventoryRobot don't can calculate cost for coupe car!");
  }
```

#### El problema:
Si se quiere que [CarInventoryRobot](2-open/src/main/java/cl/mobdev/onboarding/open/badRobot/CarInventoryRobot.java) calcule el costo total de un auto de tipo distinto a `sedan`, `suv` u `offRoad`,
entonces se debe modificar la programación del robot e incluir otros modelos, esto rompe el principio
de cerrado para modificaciones.

#### La solucion:
Primero traspasar la responsabilidad del numero de ruedas y cinturones de seguridad a cada tipo de auto, crear entidades
especificas de 
[SedanCar](2-open/src/main/java/cl/mobdev/onboarding/open/goodRobot/domain/SedanCar.java), 
[SuvCar](2-open/src/main/java/cl/mobdev/onboarding/open/goodRobot/domain/SuvCar.java) ,
[OffRoadCar](2-open/src/main/java/cl/mobdev/onboarding/open/goodRobot/domain/OffRoadCar.java) y
[CoupeCar](2-open/src/main/java/cl/mobdev/onboarding/open/goodRobot/domain/CoupeCar.java) 
que hereden de la entidad 
[Car](2-open/src/main/java/cl/mobdev/onboarding/open/goodRobot/domain/Car.java). 
De esta manera el robot `CarInventoryRobot` solo se preocupa de calcular el costo de cualquier
tipo de automovil que herede de la entidad `Car`.

Al someterlo nuevamente a los mismos tests demuestra que puede abarcar el nuevo escenario y satisfacer el requerimieto.

[CarInventoryRobotTest](2-open/src/test/java/cl/mobdev/onboarding/open/goodRobot/CarInventoryRobotTest.java)
```java

  @Test
  void should_return_correct_cost_when_calculate_3_sedan_cars() {
    int costExpected = 675;

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
    int costExpected = 720;

    SedanCar sedanCar = carBuilderRobot.makeANewSedan();
    SuvCar suvCar = carBuilderRobot.makeANewSuvCar();
    OffRoadCar offRoadCar = carBuilderRobot.makeANewOffRoad();

    int totalCost = carInventoryRobot.calculateTotalCost(sedanCar)
      + carInventoryRobot.calculateTotalCost(suvCar)
      + carInventoryRobot.calculateTotalCost(offRoadCar);

    assertEquals(costExpected, totalCost);
  }

  @Test
  void should_return_correct_cost_of_wheels_when_calculate_2_coupe_car() {
    int costExpected = 420;

    CoupeCar coupeCar1 = carBuilderRobot.makeANewCoupeCar();
    CoupeCar coupeCar2 = carBuilderRobot.makeANewCoupeCar();

    int totalCost = carInventoryRobot.calculateTotalCost(coupeCar1)
      + carInventoryRobot.calculateTotalCost(coupeCar2);

    assertEquals(costExpected, totalCost);
  }
```

---

## Liskov Substitution

> "Los objetos de un programa deberían ser reemplazables por instancias de sus subtipos sin alterar el correcto funcionamiento del programa".

Modulo: [3-liskov](3-liskov/README.md)

Tenemos que crear un modelo de entidades que permita a los robots funcionar sin problemas y en todos los posibles escenarios.

Para eso creamos una entidad [Vehicle](3-liskov/src/main/java/cl/mobdev/onboarding/liskov/badRobot/domain/Vehicle.java) de la cual pueden heredar otros objetos:

```java
abstract public class Vehicle {

  public abstract int numberOfWheels();

  public abstract int numberOfSecurityBelt();

}
```
[Car](3-liskov/src/main/java/cl/mobdev/onboarding/liskov/badRobot/domain/Car.java)
```java
public class Car extends Vehicle {

  @Override
  public int numberOfSecurityBelt() {
    return 5;
  }

  @Override
  public int numberOfWheels() {
    return 4;
  }

}
```

Para probar el nuevo modelo de dominio creamos tests para el robot de inventarios:

[VehicleInventoryRobotTest](3-liskov/src/test/java/cl/mobdev/onboarding/liskov/badRobot/VehicleInventoryRobotTest.java)
```java
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

```

El robot supera exitosamente los test, pero ha llegado una nueva informacion:

> _"Segun un estudio del departamento de marketing, los nuevos mercados a los que se esta abriendo la empresa 
> tienen grandes problemas de congestion, por lo tanto es necesario dar prioridad a la construccion de motocicletas 
> para no perder cuotas de mercado."_

Este nuevo escenario obliga a crear una nueva entidad

[Motorcycle](3-liskov/src/main/java/cl/mobdev/onboarding/liskov/badRobot/domain/Motorcycle.java)
```java
public class Motorcycle extends Vehicle {

  @Override
  public int numberOfWheels() {
    return 2;
  }

  @Override
  public int numberOfSecurityBelt() {
    throw new UnsupportedOperationException("Motorbikes don't have security belts");
  }

}
```

y un nuevo test para saber si nuestro robot es capaz de satisfacer el nuevo requerimiento.

```java
  @Test
  void should_return_correct_cost_when_calculate_1_motorcycle() {

    int costExpected = 100;

    Motorcycle motorcycle = motorcycleBuilderRobot.makeANewMotorcycle();

    int totalCost = vehicleInventoryRobot.calculateTotalCost(motorcycle);

    assertEquals(costExpected, totalCost);
  }
```

#### El problema:
El robot `VehicleInventoryRobot` recibe como parametro un objeto `Vehicle`, cuando se envia un objeto `Car` funciona 
porque `Car` es hija de `Vehicule`, pero si se envia `Motorcycle`, a pesar de tambien ser hija de `Vehicule`, 
lanza una excepcion, por lo tanto viola el principio de sustitucion de Liskov.


#### La solucion:
Modelar nuevas entidades

[Vehicle](3-liskov/src/main/java/cl/mobdev/onboarding/liskov/goodRobot/domain/Vehicle.java)
```java
abstract public class Vehicle {

  public abstract int numberOfWheels();

}
```

[Car](3-liskov/src/main/java/cl/mobdev/onboarding/liskov/goodRobot/domain/Car.java)
```java
public class Car extends Vehicle {

  public int numberOfSecurityBelt() {
    return 5;
  }

  @Override
  public int numberOfWheels() {
    return 4;
  }

}
```

[Motorcycle](3-liskov/src/main/java/cl/mobdev/onboarding/liskov/goodRobot/domain/Motorcycle.java)
```java
public class Motorcycle extends Vehicle {

  @Override
  public int numberOfWheels() {
    return 2;
  }

}
```

Refactorizar el robot `VehicleInventoryRobot`

[VehicleInventoryRobot](3-liskov/src/main/java/cl/mobdev/onboarding/liskov/goodRobot/VehicleInventoryRobot.java)

```java
public class VehicleInventoryRobot {

  private final int costByWheel = 50;
  private final int costBySecurityBelt = 5;

  public int calculateTotalCostOfWheels(Vehicle vehicle) {
    return costByWheel * vehicle.numberOfWheels();
  }

  public int calculateTotalCostOfSecurityBelts(Car car) {
    return costBySecurityBelt * car.numberOfSecurityBelt();
  }

}
```

Ahora, si nuevamente sometemos a los mismos test el robot no lanzara errores. 

[VehicleInventoryRobotTest](3-liskov/src/test/java/cl/mobdev/onboarding/liskov/goodRobot/VehicleInventoryRobotTest.java)

```java
  @Test
  void should_return_correct_cost_when_calculate_2_cars() {
    int costExpected = 450;

    Car car1 = carBuilderRobot.makeANewCar();
    Car car2 = carBuilderRobot.makeANewCar();

    int totalCost = vehicleInventoryRobot.calculateTotalCostOfWheels(car1)
      + vehicleInventoryRobot.calculateTotalCostOfSecurityBelts(car1)
      + vehicleInventoryRobot.calculateTotalCostOfWheels(car2)
      + vehicleInventoryRobot.calculateTotalCostOfSecurityBelts(car2);

    assertEquals(costExpected, totalCost);
  }

  @Test
  void should_return_correct_cost_when_calculate_3_cars() {
    int costExpected = 675;

    Car car1 = carBuilderRobot.makeANewCar();
    Car car2 = carBuilderRobot.makeANewCar();
    Car car3 = carBuilderRobot.makeANewCar();

    int totalCost = vehicleInventoryRobot.calculateTotalCostOfWheels(car1)
      + vehicleInventoryRobot.calculateTotalCostOfSecurityBelts(car1)
      + vehicleInventoryRobot.calculateTotalCostOfWheels(car2)
      + vehicleInventoryRobot.calculateTotalCostOfSecurityBelts(car2)
      + vehicleInventoryRobot.calculateTotalCostOfWheels(car3)
      + vehicleInventoryRobot.calculateTotalCostOfSecurityBelts(car3);

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
```

---

## Interface Segregation

> "Muchas interfaces cliente específicas son mejores que una interfaz de propósito general".

Modulo: [4-interface](4-interface/README.md)

Tenemos un nuevo modelo de entidades e interfaces que es usado por todos los robots de la fabrica.

Se ha definido una interfaz general.

```java
public interface Mobilizable {

  double maximumFuelCapacityInLiters();

  int maximumSpeedInKilometersByHours();

}
```

Ademas se define la clase `Car`, juntas modelaran todos los tipos de automoviles.

[Car](4-Interface/src/main/java/cl/mobdev/onboarding/interfaces/domain/Car.java)
````java
abstract public class Car {

  public abstract int numberOfWheels();

}
````

[Sedan](4-Interface/src/main/java/cl/mobdev/onboarding/interfaces/badRobot/Sedan.java)
````java
public class Sedan extends Car implements Mobilizable {

  @Override
  public int numberOfWheels() {
    return 4;
  }

  @Override
  public double maximumFuelCapacityInLiters() {
    return 40;
  }

  @Override
  public int maximumSpeedInKilometersByHours() {
    return 220;
  }
}
````
[Suv](4-Interface/src/main/java/cl/mobdev/onboarding/interfaces/badRobot/Suv.java)
````java
public class Suv extends Car implements Mobilizable {

  @Override
  public int numberOfWheels() {
    return 4;
  }

  @Override
  public double maximumFuelCapacityInLiters() {
    return 60;
  }

  @Override
  public int maximumSpeedInKilometersByHours() {
    return 200;
  }
````

El nuevo modelo funciona para el actual escenario, pero ha llegado una nueva informacion:

> _"La compañia ha desarrollado una nueva estrategia de electromovilidad, en la que planea crear sus
> primeros automoviles electricos en un plazo de 10 años. En el corto plazo se construiran autos hybridos y
> posteriormente se incluiran versiones completamente electricos."_

Esta informacion nos obliga a crear un nuevo tipo de automovil

[Electric](4-Interface/src/main/java/cl/mobdev/onboarding/interfaces/badRobot/Electric.java)
````java
public class Electric extends Car implements Mobilizable {

  @Override
  public int numberOfWheels() {
    return 4;
  }

  @Override
  public double maximumFuelCapacityInLiters() {
    throw new UnsupportedOperationException("Electric cars don't use fuel");
  }

  @Override
  public int maximumSpeedInKilometersByHours() {
    return 150;
  }

  public double maximumElectricCapacityInKilowattsByHour(){
    return 100;
  }

}

````
#### El problema:
La interfaz `Mobilizable` agrupa todas funcionalidades que deberia tener un automovil a combustible
lo que provoca que los nuevos autos electricos deban implementar funcionalidades que no deben.


#### La solucion:
Crear nuevas interfaces mas especificas. 

[Mobilizable](4-Interface/src/main/java/cl/mobdev/onboarding/interfaces/goodRobot/Mobilizable.java)
````java
public interface Mobilizable {

  int maximumSpeedInKilometersByHours();

}
````

[ElectricCapacity](4-Interface/src/main/java/cl/mobdev/onboarding/interfaces/goodRobot/ElectricCapacity.java)
````java
public interface ElectricCapacity {

  int maximumElectricCapacityInKilowattsByHour();

}
````
[FuelCapacity](4-Interface/src/main/java/cl/mobdev/onboarding/interfaces/goodRobot/FuelCapacity.java)
````java
public interface FuelCapacity {

  int maximumFuelCapacityInLiters();

}
````

Entonces cada tipo de automovil puede implementar una o mas de las interfaces para modelar comportamiento.

[Sedan](4-Interface/src/main/java/cl/mobdev/onboarding/interfaces/goodRobot/Sedan.java)
````java
public class Sedan extends Car implements Mobilizable, FuelCapacity {

  @Override
  public int numberOfWheels() {
    return 4;
  }

  @Override
  public int maximumFuelCapacityInLiters() {
    return 40;
  }

  @Override
  public int maximumSpeedInKilometersByHours() {
    return 220;
  }
}
````
[Electric](4-Interface/src/main/java/cl/mobdev/onboarding/interfaces/goodRobot/Electric.java)
````java
public class Electric extends Car implements Mobilizable, ElectricCapacity {

  @Override
  public int numberOfWheels() {
    return 4;
  }

  @Override
  public int maximumSpeedInKilometersByHours() {
    return 150;
  }

  @Override
  public int maximumElectricCapacityInKilowattsByHour() {
    return 100;
  }

}
````
[Hybrid](4-Interface/src/main/java/cl/mobdev/onboarding/interfaces/goodRobot/Hybrid.java)
````java
public class Hybrid extends Car implements Mobilizable, ElectricCapacity, FuelCapacity {

  @Override
  public int numberOfWheels() {
    return 4;
  }

  @Override
  public int maximumSpeedInKilometersByHours() {
    return 150;
  }

  @Override
  public int maximumElectricCapacityInKilowattsByHour() {
    return 100;
  }

  @Override
  public int maximumFuelCapacityInLiters() {
    return 20;
  }
}
````

---

## Dependency Inversion

> Depender de abstracciones, no depender de implementaciones.

Modulo: [5-dependency](5-dependency/README.md)

El robot `CarBuilderRobot` es el robot mas eficiente de la fabrica y produce la version mas vendida.

```java
public class CarBuilderRobot {

  Car makeANewCar() {

    //initialize building a new Car
    Car newCar = new Car();

    //make a new engine
    Engine engine = makeANewEngine();

    //install new engine in car
    newCar.setEngine(engine);

    return newCar;
  }

  private Engine makeANewEngine() {
    final int capacityInCentimetersCubic = 1600;
    final double weightInKilograms = capacityInCentimetersCubic * 0.1;

    Engine engine = new Engine();
    engine.setCapacity(capacityInCentimetersCubic);
    engine.setWeight(weightInKilograms);

    return engine;
  }

}
```

La fama de este automovil es tal que permite crear nuevos negocios:

> _"El area de negocios ha cerrado un contrato gubernamental en el que se comprometen a vender 
> unas 10.000 unidades de autos nuevos, pero debido a una necesidad especifica del gobierno 
> los motores deben tener una capacidad de 2.000 cc."_

Esta informacion nos obliga a modificar el motor que usa este auto.


#### El problema:
El robot `CarBuilderRobot` agrupa todas funcionalidades lo que provoca que los nuevos autos 
con motores con distintas capacidades no puedan ser construidos.


#### La solucion:
Separar responsabilidades y usar la inversion de control y/o inyeccion de dependencias.