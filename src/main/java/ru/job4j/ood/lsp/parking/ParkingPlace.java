package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingPlace implements Parking {

    private static int carSpot;
    private static int truckSpot;

    List<Vehicle> cars = new ArrayList<>(carSpot);
    List<Vehicle> trucks = new ArrayList<>(truckSpot);

    @Override
    public boolean addVehicle(Vehicle vehicle) {
        boolean result = false;
        int vehSize = vehicle.getSize();
        if (vehSize > 1 && trucks.size() >= truckSpot && cars.size() > truckSpot) {
            cars.add(vehicle);
            carSpot -= vehicle.getSize();
            result = true;
        }
        if (vehicle.getSize() > 1 && trucks.size() < truckSpot) {
            trucks.add(vehicle);
            truckSpot--;
            result = true;
        } else if (vehicle.getSize() == 1 && cars.size() < carSpot) {
            cars.add(vehicle);
            carSpot--;
            result = true;
        }
        return result;
    }

    @Override
    public List<Vehicle> getCars() {
        return cars;
    }

    @Override
    public List<Vehicle> getTrucks() {
        return trucks;
    }
}
