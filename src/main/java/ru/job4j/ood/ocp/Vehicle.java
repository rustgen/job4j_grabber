package ru.job4j.ood.ocp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Vehicle {

    private ArrayList<Vehicle> vehicles;
    private String name;

    public Vehicle(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    private static class Plane {
        public String move() {
            return "fly";
        }
    }

    private static class Ship {
        public String move() {
            return "sail";
        }
    }

    public ArrayList<Vehicle> version(String year) {
        vehicles.forEach(v -> System.out.println(v.getName() + year));
        return vehicles;
    }

    public List<String> versionLast(ArrayList<Vehicle> list) {
        List<String> versions = list.stream()
                .map(Vehicle::getName)
                .filter(v -> v.contains("2023") || v.contains("2024"))
                .collect(Collectors.toList());
        return versions;
    }
}
