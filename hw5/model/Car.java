package model;

public class Car implements IVehicle {
    String brand;
    String model;
    String fuelType;

    public Car(String brand, String model, String fuelType) {
        this.model = model;
        this.fuelType = fuelType;
        this.brand = brand;
    }

    @Override
    public void Drive() {
        System.out.println(STR."Вы едете на машине \{brand} \{model} с типом топлива: \{fuelType}");
    }

    @Override
    public void Refuel() {
        System.out.println(STR."Идет заправка машины \{fuelType}...");
    }
}
