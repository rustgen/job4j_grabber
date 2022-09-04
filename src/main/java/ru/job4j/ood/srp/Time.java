package ru.job4j.ood.srp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class Time implements Printer {

    private static final LocalDateTime TIME = LocalDateTime.now();

    @Override
    public void printInfo(String msg) {
        System.out.println(TIME.format(DateTimeFormatter.ofPattern(msg)));
    }

    public class TemperatureTime {

        private static final LocalDateTime TIME = LocalDateTime.now();
        private String temperature;
        private static String temp = "fahrenheits";

        public TemperatureTime() {
        }

        public TemperatureTime(String temperature) {
            this.temperature = temperature;
        }

        public void print(TemperatureTime tempT) {
            System.out.println(tempT + temp + TIME);
        }
    }
}
