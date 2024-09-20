import model.*;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Lamborgini", "Aventador", 2015, 2, "Automatic");
        Car car2 = new Car("Mercedez-Benz", "190", 1993, 4, "Manual");
        Motorcycle bike1 = new Motorcycle("Kawasaki", "Ninja", 2023, "Sport", false);

        Garage garage1 = new Garage();
        Garage garage2 = new Garage();

        System.out.println(garage1.addVehicle(car1));
        System.out.println(garage1.addVehicle(bike1));
        System.out.println(garage2.addVehicle(car2));

        Fleet fleet = new Fleet();
        System.out.println(fleet.addGarage(garage1));
        System.out.println(fleet.addGarage(garage2));

        Vehicle foundVehicle = fleet.findVehicle("Aventador");
        if (foundVehicle != null) {
            System.out.println("Vehicle found: " + foundVehicle);
        } else {
            System.out.println("Vehicle not found.");
        }
        Vehicle foundVehicle1 = fleet.findVehicle("Gallardo");
        if (foundVehicle != null) {
            System.out.println("Vehicle found: " + foundVehicle1);
        } else {
            System.out.println("Vehicle not found.");
        }
        System.out.println(garage1.removeVehicle(bike1));

        System.out.println(fleet.removeGarage(garage1));

        System.out.println(fleet);

        System.out.println(car1.startEngine());
        System.out.println(car1.stopEngine());
    }
}