package ru.job4j.ood.lsp;

public class Furniture {

    protected String model;
    protected String withoutSalePercent = "0";

    public Furniture(String model) {
        checkModel(model);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        checkModel(model);
        this.model = model;
    }

    public void type(String season) {
        if (model == null) {
            throw new IllegalArgumentException("Need model in any case");
        }
        System.out.println(season);
    }

    public String sale(int price) {
        String salePercent;
        if (price > 10000) {
            salePercent = "10%";
        } else {
            salePercent = "25%";
        }
        if (withoutSalePercent.equals(salePercent)) {
            throw new IllegalArgumentException("We have a sale actually");
        }
        return salePercent;
    }

    protected void checkModel(String model) {
        if ("outside".contains(model) || "outdoors".contains(model)) {
            throw new IllegalArgumentException("We sell only inside furniture");
        }
    }
}
