import modelFactory.*;
import model.*;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество транспортных средств: ");
        int n = scan.nextInt();
        scan.nextLine();
        IVehicle[] vehicles = new IVehicle[n];
        for (int i = 0; i < n; i++) {
            try {
                System.out.print("Введите тип транспорта (Car, Truck, Motorcycle, Bus): ");
                String userInput = scan.nextLine();
                TransportType transportType = TransportType.valueOf(userInput);
                VehicleFactory factory = getFactory(transportType);
                vehicles[i] = factory.CreateVehicle();
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid transport type entered.");
            }
        }
        scan.close();
        for (IVehicle vehicle: vehicles) {
            vehicle.Drive();
            vehicle.Refuel();
        }
    }
    public static VehicleFactory getFactory(TransportType transportType) {
        Scanner scan = new Scanner(System.in);
        switch (transportType) {
            case Car:
                System.out.println("Введите бренд, модель, тип топлива машины:");
                return new CarFactory(scan.next(), scan.next(), scan.next());
            case Motorcycle:
                System.out.println("Введите тип мотоцикла, объем двигателя мотоцикла:");
                return new MotorcycleFactory(scan.next(), scan.nextFloat());
            case Truck:
                System.out.println("Введите грузоподъемность, количество осей грузовика:");
                return new TruckFactory(scan.nextInt(), scan.nextInt());
            case Bus:
                System.out.println("Введите количество дверей, вместимость автобуса");
                return new BusFactory(scan.nextInt(), scan.nextInt());
            default:
                throw new IllegalArgumentException("Unknown transport type: " + transportType);
        }
    }
}


