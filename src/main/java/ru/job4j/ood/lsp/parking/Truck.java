package ru.job4j.ood.lsp.parking;

public class Truck implements Vehicle {

    public final int size;

    public Truck(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        if (size <= 1) {
            throw new IllegalArgumentException("Truck size should be more than 1");
        }
        return size;
    }
}
