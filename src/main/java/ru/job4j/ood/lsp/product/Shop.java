package ru.job4j.ood.lsp.product;

import java.util.ArrayList;
import java.util.List;

public class Shop extends AbstractStore {

    @Override
    boolean accept(Food food) {
        if (getPercentLifeExpired(food) > PhysicalConstants.MEDIUMQUAL
                && getPercentLifeExpired(food) < PhysicalConstants.BADQUAL) {
            food.setPrice(
                    food.getPrice() - food.getDiscount()
            );
        }
        return getPercentLifeExpired(food) >= PhysicalConstants.GOODQUAL
                && getPercentLifeExpired(food) < PhysicalConstants.BADQUAL;
    }
}
