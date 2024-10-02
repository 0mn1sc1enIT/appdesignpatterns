package model;

import model.IVehicle;

public class Motorcycle implements IVehicle {
    String motoType;
    float engineVolume;

    public Motorcycle(String motoType, float engineVolume) {
        this.engineVolume = engineVolume;
        this.motoType = motoType;
    }
    @Override
    public void Drive() {
        System.out.println(STR."Вы водите \{motoType} мотоцикл с объемом двигателя \{engineVolume}");
    }

    @Override
    public void Refuel() {
        System.out.println("Идет заправка мотоцикла...");
    }
}
