package model;

public class Car extends Vehicle {
    private int numberOfDoors;
    private String transmissionType;

    public Car(String brand, String model, int year, int numberOfDoors, String transmissionType) {
        super(brand, model, year);
        this.numberOfDoors = numberOfDoors;
        this.transmissionType = transmissionType;
    }

    @Override
    public String toString() {
        return super.toString() + " [Car: " + numberOfDoors + " doors, Transmission: " + transmissionType + "]";
    }
}

