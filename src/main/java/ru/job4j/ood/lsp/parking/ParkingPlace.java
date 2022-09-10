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
        int vehSize = vehicle.sizeSlot();
        if (vehSize > 1 && trucks.size() >= truckSpot && cars.size() > truckSpot) {
            cars.add(vehicle);
            carSpot -= vehicle.sizeSlot();
            result = true;
        }
        if (vehicle.sizeSlot() > 1 && trucks.size() < truckSpot) {
            trucks.add(vehicle);
            truckSpot--;
            result = true;
        } else if (vehicle.sizeSlot() == 1 && cars.size() < carSpot) {
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
