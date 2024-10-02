package model;

public class Bus implements IVehicle {
    public int doorsCount;
    public int capacity;

    public Bus(int doorsCount, int capacity) {
        this.doorsCount = doorsCount;
        this.capacity = capacity;
    }
    @Override
    public void Drive() {
        System.out.println(STR."Вы едете на автобусе с \{doorsCount} дверями и \{capacity} вместимостью людей");
    }

    @Override
    public void Refuel() {
        System.out.println("Идет заправка автобуса...");
    }
}
