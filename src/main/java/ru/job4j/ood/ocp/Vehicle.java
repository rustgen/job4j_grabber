package ru.job4j.ood.ocp;

public class Vehicle {

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
}
