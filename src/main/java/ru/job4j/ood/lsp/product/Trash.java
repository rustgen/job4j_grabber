package ru.job4j.ood.lsp.product;

public class Trash extends AbstractStore {

    @Override
    boolean accept(Food food) {
        return getPercentLifeExpired(food) >= PhysicalConstants.BADQUAL;
    }
}
