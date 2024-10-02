package modelFactory;

import model.*;

public class CarFactory extends VehicleFactory {
    private String brand;
    private String model;
    private String fuelType;
    public CarFactory(String brand, String model, String fuelType) {
        this.brand = brand;
        this.fuelType = fuelType;
        this.model = model;
    }
    @Override
    public IVehicle CreateVehicle() {
        return new Car(brand, model, fuelType);
    }
}
