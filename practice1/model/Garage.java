package model;

import java.util.ArrayList;

public class Garage {
    private ArrayList<Vehicle> vehicles;

    public Garage() {
        vehicles = new ArrayList<>();
    }

    public String addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        return vehicle + " added to garage";
    }

    public String removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
        return vehicle + " removed from garage";
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public String toString() {
        return "Garage: " + vehicles.size() + " vehicles";
    }
}

