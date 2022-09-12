package ru.job4j.ood.lsp.product;

import java.util.ArrayList;
import java.util.List;

public class Shop extends AbstractStore {

    private List<Food> grocery = new ArrayList<>();

    @Override
    boolean accept(Food food) {
        if (getPercentLifeExpired(food) > 75 && getPercentLifeExpired(food) < 100) {
            food.setPrice(
                    food.getPrice() - food.getDiscount()
            );
            return grocery.add(food);
        }
        return getPercentLifeExpired(food) >= 25 && getPercentLifeExpired(food) <= 75;
    }
}
