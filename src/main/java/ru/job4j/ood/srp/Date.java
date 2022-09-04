package ru.job4j.ood.srp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date implements Printer {

    private static final LocalDate DATE = LocalDate.now();

    @Override
    public void printInfo(String msg) {
        System.out.println(DATE.format(DateTimeFormatter.ofPattern(msg)));
    }
}
