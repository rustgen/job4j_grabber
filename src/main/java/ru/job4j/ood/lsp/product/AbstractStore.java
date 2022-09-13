package ru.job4j.ood.lsp.product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public abstract class AbstractStore {

    private List<Food> grocery = new ArrayList<>();

    public List<Food> getGrocery() {
        return grocery;
    }

    public boolean add(Food food) {
        boolean accept = accept(food);
        if (accept) {
            grocery.add(food);
        }
        return accept;
    }

    public Food get(int index) {
        return grocery.get(index);
    }

    public List<Food> getAll() {
        return new ArrayList<>(grocery);
    }

    abstract boolean accept(Food food);

    public double getPercentLifeExpired(Food food) {
        double total = food.getCreateDate().until(food.getExpireDate(), DAYS);
        double current = food.getCreateDate().until(LocalDate.now(), DAYS);
        return (current / total) * 100;
    }

    public void clearStore() {
        grocery.clear();
    }
}
