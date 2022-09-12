package ru.job4j.ood.lsp.product;

import java.util.List;

public class ControlQuality {

    private List<AbstractStore> stores;

    public ControlQuality(List<AbstractStore> stores) {
        this.stores = stores;
    }

    public List<AbstractStore> getStores() {
        return stores;
    }

    public void distribute(Food food) {
        for (AbstractStore s : stores) {
            s.add(food);
        }
    }
}
