package ru.job4j.ood.srp;

public class Temperature implements Saver {

    private static String temp = "fahrenheits";

    @Override
    public String save(String degree) {
        String temperature;
        temperature = degree + " " + temp;
        return temperature;
    }
}
