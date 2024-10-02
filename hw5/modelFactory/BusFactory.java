package modelFactory;

import model.Bus;
import model.IVehicle;

public class BusFactory extends VehicleFactory {
    private int doorsCount;
    private int capacity;
    public BusFactory(int doorCount, int capacity) {
        this.capacity = capacity;
        this.doorsCount = doorCount;
    }

    @Override
    public IVehicle CreateVehicle() {
        return new Bus(doorsCount, capacity);
    }
}
