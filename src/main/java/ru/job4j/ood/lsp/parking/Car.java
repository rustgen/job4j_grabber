package ru.job4j.ood.lsp.parking;

public class Car implements Vehicle {

    private static final int SIZE = 1;

    @Override
    public int sizeSlot() {
        return SIZE;
    }
}
