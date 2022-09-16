package ru.job4j.ood.lsp.parking;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ParkingPlaceTest {

    @Test
    public void whenParkCar() {
        Parking parking = new ParkingPlace(2, 1);
        Vehicle car = new Car();
        parking.addVehicle(car);
        assertThat(parking.getCars(), is(List.of(car)));
    }

    @Test
    public void whenParkTruck() {
        Parking parking = new ParkingPlace(5, 1);
        Vehicle truck1 = new Truck(3);
        Vehicle truck2 = new Truck(2);
        Vehicle car1 = new Car();
        Vehicle car2 = new Car();
        Vehicle car3 = new Car();
        Vehicle car4 = new Car();
        parking.addVehicle(truck1);
        parking.addVehicle(car1);
        parking.addVehicle(car2);
        parking.addVehicle(car3);
        parking.addVehicle(truck2);
        assertThat(parking.getTrucks(), is(List.of(truck1)));
        assertThat(parking.getCars(), is(List.of(car1, car2, car3, truck2)));
        assertFalse(parking.addVehicle(car4));
    }

    @Test
    public void whenCantParkCarOnTruckPlace() {
        Parking parking = new ParkingPlace(2, 1);
        Vehicle car1 = new Car();
        Vehicle car2 = new Car();
        Vehicle car3 = new Car();
        parking.addVehicle(car1);
        parking.addVehicle(car2);
        assertThat(parking.getCars(), is(List.of(car1, car2)));
        assertFalse(parking.addVehicle(car3));
    }

    @Test
    public void whenCantParkCarOnTruckPlacem() {
        Parking parking = new ParkingPlace(3, 1);
        Vehicle car1 = new Car();
        Vehicle car2 = new Car();
        Vehicle truck1 = new Truck(3);
        Vehicle truck2 = new Truck(2);
        parking.addVehicle(car1);
        parking.addVehicle(car2);
        parking.addVehicle(truck1);
        assertThat(parking.getCars(), is(List.of(car1, car2)));
        assertThat(parking.getTrucks(), is(List.of(truck1)));
        assertFalse(parking.addVehicle(truck2));
    }
}