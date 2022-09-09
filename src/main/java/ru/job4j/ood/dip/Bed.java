package ru.job4j.ood.dip;

public class Bed {

    private String name;
    private String model;
    private int serialNumber;

    public Bed(String name, String model, int serialNumber) {
        this.name = name;
        this.model = model;
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getSerialNumber() {
        return serialNumber;
    }
}
