package ru.job4j.ood.lsp;

import java.util.Calendar;

public class Food {

    private final String name;
    private final Calendar expireDate;
    private final Calendar createDate;
    private final double price;
    private final int discount;

    public Food(String name, Calendar expireDate, Calendar createDate, double price, int discount) {
        this.name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public Calendar getExpireDate() {
        return expireDate;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public double getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }
}
