package ru.job4j.ood.lsp.parking;

public class Truck implements Vehicle {

    private static int size;

    public static int getSize() {
        return size;
    }

    @Override
    public int sizeSlot() {
        return 0;
    }
}
