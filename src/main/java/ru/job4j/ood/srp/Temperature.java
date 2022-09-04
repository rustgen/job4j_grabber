package ru.job4j.ood.srp;

public class Temperature implements Saver {

    private static String temp = "fahrenheits";

    @Override
    public String save(String degree) {
        return degree + " " + temp;
    }

    public void log() {
        System.out.println("Temperature monitoring was 3 days a day");
    }

    public void print() {
        String degreeMorning = "97";
        System.out.println(save(degreeMorning));
    }
}
