package ru.job4j.ood.srp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class DateTime implements Printer {

    private static final LocalDateTime DATE_TIME = LocalDateTime.now();
    private final Saver saver;

    public DateTime(Saver saver) {
        this.saver = saver;
    }

    @Override
    public void printInfo(String msg) {
        String save = saver.save(msg);
        System.out.println(DATE_TIME.format(DateTimeFormatter.ofPattern(save)));
    }
}
