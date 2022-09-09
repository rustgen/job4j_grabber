package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.Calendar;

public class Fish extends Food {

    public Fish(String name, LocalDate expireDate, LocalDate createDate, double price, int discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
