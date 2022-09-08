package ru.job4j.ood.lsp;

import java.util.Calendar;

public class Juice extends Food {
    public Juice(String name, Calendar expireDate, Calendar createDate, double price, int discount) {
        super(name, expireDate, createDate, price, discount);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public Calendar getExpireDate() {
        return super.getExpireDate();
    }

    @Override
    public Calendar getCreateDate() {
        return super.getCreateDate();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public int getDiscount() {
        return super.getDiscount();
    }
}
