package ru.job4j.ood.isp;

public interface Stove {

    void on();

    int maxTemperature();

    void giveGas();

    String infoPanel(String info);

    void off();
}
