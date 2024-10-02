package modelFactory;

import model.*;

public class MotorcycleFactory extends VehicleFactory {
    private String motoType;
    private float engineVolume;

    public MotorcycleFactory(String motoType, float engineVolume) {
        this.engineVolume = engineVolume;
        this.motoType = motoType;
    }
    @Override
    public IVehicle CreateVehicle() {
        return new Motorcycle(motoType, engineVolume);
    }
}
