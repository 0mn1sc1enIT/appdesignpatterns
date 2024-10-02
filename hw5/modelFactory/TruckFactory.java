package modelFactory;

import model.*;

public class TruckFactory extends VehicleFactory {
    private int carryingCapacity;
    private int numAxes;

    public TruckFactory(int carryingCapacity, int numAxes) {
        this.carryingCapacity = carryingCapacity;
        this.numAxes = numAxes;
    }
    @Override
    public IVehicle CreateVehicle() {
        return new Truck(carryingCapacity, numAxes);
    }
}
