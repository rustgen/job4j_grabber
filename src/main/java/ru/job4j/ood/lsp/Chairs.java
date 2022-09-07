package ru.job4j.ood.lsp;

public class Chairs extends Furniture {

    public Chairs(String model) {
        super(model);
    }

    @Override
    public void setModel(String model) {
        super.setModel(model);
    }

    public void type(String season) {
        if (model == null) {
            throw new IllegalArgumentException("Need model in any case");
        }
        System.out.println(season);
    }

    @Override
    public String sale(int price) {
        String salePercent;
        if (price > 10000) {
            salePercent = "10%";
        } else {
            salePercent = "25%";
        }
        return salePercent;
    }
}
