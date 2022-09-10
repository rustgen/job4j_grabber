package ru.job4j.ood.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ParkingPlaceTest {

    @Ignore
    @Test
    public void whenParkCar() {
        Parking parking = new ParkingPlace();
        Vehicle car = new Car();
        parking.addVehicle(car);
        assertThat(parking.getCars(), is(List.of(car)));
    }

    @Ignore
    @Test
    public void whenParkTruck() {
        Parking parking = new ParkingPlace();
        Vehicle truck = new Truck();
        parking.addVehicle(truck);
        assertThat(parking.getTrucks(), is(List.of(truck)));
    }

}