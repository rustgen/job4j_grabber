package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingPlace implements Parking {

    private int carSpot;
    private int truckSpot;

    private List<Vehicle> cars = new ArrayList<>(carSpot);
    private List<Vehicle> trucks = new ArrayList<>(truckSpot);

    public ParkingPlace(int carSpot, int truckSpot) {
        this.carSpot = carSpot;
        this.truckSpot = truckSpot;
    }

    @Override
    public boolean addVehicle(Vehicle vehicle) {
        boolean result = false;
        int vehSize = vehicle.getSize();
        if (vehSize > 1 && trucks.size() > truckSpot && vehSize <= carSpot) {
            cars.add(vehicle);
            carSpot -= vehicle.getSize();
            result = true;
        }
        if (vehicle.getSize() > 1 && trucks.size() <= truckSpot) {
            trucks.add(vehicle);
            truckSpot--;
            result = true;
        } else if (vehicle.getSize() == 1 && cars.size() <= carSpot) {
            cars.add(vehicle);
            carSpot--;
            result = true;
        }
        return result;
    }

    @Override
    public List<Vehicle> getCars() {
        return new ArrayList<>(cars);
    }

    @Override
    public List<Vehicle> getTrucks() {
        return new ArrayList<>(trucks);
    }
}
