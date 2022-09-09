package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    private List<Food> grocery = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean accept = accept(food);
        if (accept) {
            applySale(food);
            grocery.add(food);
        }
        return accept;
    }

    @Override
    public boolean accept(Food food) {
        return getPercentLifeExpired(food) >= 25 && getPercentLifeExpired(food) <= 75;
    }

    @Override
    public Food get(int index) {
        return grocery.get(index);
    }

    @Override
    public List<Food> getAll() {
        return grocery;
    }

    @Override
    public double getPercentLifeExpired(Food food) {
        return Store.super.getPercentLifeExpired(food);
    }

    private void applySale(Food food) {
        if (getPercentLifeExpired(food) > 75) {
            food.setPrice(
                    food.getPrice() - food.getDiscount()
            );
        }
    }
}
