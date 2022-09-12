package ru.job4j.ood.lsp.product;

import java.time.LocalDate;

public class Juice extends Food {

    public Juice(String name, LocalDate expireDate, LocalDate createDate, double price, int discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
