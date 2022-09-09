package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public interface Store {

    boolean add(Food food);

    boolean accept(Food food);

    Food get(int index);

    List<Food> getAll();

    default double getPercentLifeExpired(Food food) {
        double total = food.getCreateDate().until(food.getExpireDate(), DAYS);
        double current = food.getCreateDate().until(LocalDate.now(), DAYS);
        return (current / total) * 100;
    }
}
