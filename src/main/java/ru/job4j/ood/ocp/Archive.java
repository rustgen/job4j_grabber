package ru.job4j.ood.ocp;

public class Archive {

    public void save(Car car) {
        if (car instanceof Sedan) {
            System.out.println("smth");
        }
        if (car instanceof Van) {
            System.out.println("smth");
        }
    }
}
