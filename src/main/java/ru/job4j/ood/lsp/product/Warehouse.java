package ru.job4j.ood.lsp.product;

public class Warehouse extends AbstractStore {

    @Override
    boolean accept(Food food) {
        return getPercentLifeExpired(food) < PhysicalConstants.GOODQUAL;
    }
}
