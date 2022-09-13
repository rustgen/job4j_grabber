package ru.job4j.ood.lsp.product;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private List<AbstractStore> stores;

    public ControlQuality(List<AbstractStore> stores) {
        this.stores = stores;
    }

    public List<AbstractStore> getStores() {
        return new ArrayList<>(stores);
    }

    public void distribute(Food food) {
        for (AbstractStore s : stores) {
            s.add(food);
        }
    }

    public void resort() {
        List<Food> food = new ArrayList<>();
        for (AbstractStore store : stores) {
            List<Food> grocery = store.getGrocery();
            food.addAll(grocery);
            store.clearStore();
        }
        for (Food product : food) {
            distribute(product);
        }
    }
}
