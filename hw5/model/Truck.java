package model;

import model.IVehicle;

public class Truck implements IVehicle {
    int carryingCapacity;
    int numAxes;

    public Truck(int carryingCapacity, int numAxes) {
        this.carryingCapacity = carryingCapacity;
        this.numAxes = numAxes;
    }

    @Override
    public void Drive() {
        System.out.println(STR."Вы ведете грузовик с грузоподъемностью \{carryingCapacity} кг и \{numAxes} количеством осей");
    }

    @Override
    public void Refuel() {
        System.out.println("Идет заправка грузовика...");
    }
}
