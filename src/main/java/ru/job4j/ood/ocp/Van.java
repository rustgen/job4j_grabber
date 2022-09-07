package ru.job4j.ood.ocp;

public class Van extends Car {

    public Van(int maxSpeed) {
        super(maxSpeed);
    }

    @Override
    public String speed(String miles) {
        int speed = 20;
        return Integer.toString(speed) + " " + miles;
    }

    @Override
    public void gas() {
        System.out.println("Van accelerates!");
    }

    @Override
    public void brake() {
        System.out.println("Van slows down!");
    }
}
