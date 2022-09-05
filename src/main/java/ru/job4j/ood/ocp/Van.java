package ru.job4j.ood.ocp;

public class Van extends Car {
    @Override
    public void gas() {
        System.out.println("Van accelerates!");
    }

    @Override
    public void brake() {
        System.out.println("Van slows down!");
    }
}
