package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {

    private final List<Food> grocery = new ArrayList<>();

    @Override
    public void add(Food food) {
        grocery.add(food);
    }
}
