package ru.job4j.ood.ocp;

public class Sedan extends Car {
    @Override
    public void gas() {
        System.out.println("Sedan accelerates!");
    }

    @Override
    public void brake() {
        System.out.println("Sedan slows down!");
    }
}
