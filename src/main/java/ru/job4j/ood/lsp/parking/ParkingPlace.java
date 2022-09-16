package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingPlace implements Parking {

    private int carSpot;
    private int truckSpot;

    private final List<Vehicle> cars;
    private final List<Vehicle> trucks;

    public ParkingPlace(int carSpot, int truckSpot) {
        this.carSpot = carSpot;
        this.truckSpot = truckSpot;
        this.cars = new ArrayList<>(carSpot);
        this.trucks = new ArrayList<>(truckSpot);
    }

    @Override
    public boolean addVehicle(Vehicle vehicle) {
        boolean result = false;
        int vehSize = vehicle.getSize();
        if (vehSize > Car.SIZE && trucks.size() > truckSpot && vehSize <= carSpot) {
            cars.add(vehicle);
            carSpot -= vehicle.getSize();
            result = true;
        }
        if (vehicle.getSize() > Car.SIZE && trucks.size() <= truckSpot) {
            trucks.add(vehicle);
            truckSpot--;
            result = true;
        } else if (vehicle.getSize() == Car.SIZE && cars.size() <= carSpot) {
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
