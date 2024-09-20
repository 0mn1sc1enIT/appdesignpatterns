package model;

import java.util.ArrayList;

public class Fleet {
    private ArrayList<Garage> garages;

    public Fleet() {
        garages = new ArrayList<>();
    }

    public String addGarage(Garage garage) {
        garages.add(garage);
        return "Garage added to fleet";
    }

    public String removeGarage(Garage garage) {
        garages.remove(garage);
        return "Garage removed from fleet.";
    }

    public Vehicle findVehicle(String model) {
        for (Garage garage : garages) {
            for (Vehicle vehicle : garage.getVehicles()) {
                if (vehicle.toString().contains(model)) {
                    return vehicle;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Fleet: " + garages.size() + " garages";
    }
}
