package model;

public class Vehicle {
    private String brand;
    private String model;
    private int year;

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String startEngine() {
        return brand + " " + model + ": Engine started.";
    }

    public String stopEngine() {
        return brand + " " + model + ": Engine stopped.";
    }

    @Override
    public String toString() {
        return brand + " " + model + " (" + year + ")";
    }
}
