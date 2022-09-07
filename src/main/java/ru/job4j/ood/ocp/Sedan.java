package ru.job4j.ood.ocp;

public class Sedan extends Car {

    public Sedan(int maxSpeed) {
        super(maxSpeed);
    }

    @Override
    public String speed(String miles) {
        return String.valueOf(getMaxSpeed()) + " " + miles;
    }

    @Override
    public void gas() {
        System.out.println("Sedan accelerates!");
    }

    @Override
    public void brake() {
        System.out.println("Sedan slows down!");
    }
}
