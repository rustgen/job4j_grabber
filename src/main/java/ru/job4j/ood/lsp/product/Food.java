package ru.job4j.ood.lsp.product;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Food {

    private String name;
    private LocalDate expireDate;
    private LocalDate createDate;
    private double price;
    private int discount;

    public Food(String name, LocalDate expireDate, LocalDate createDate, double price, int discount) {
        this.name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Double.compare(food.price, price) == 0 && discount == food.discount && Objects.equals(name, food.name) && Objects.equals(expireDate, food.expireDate) && Objects.equals(createDate, food.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expireDate, createDate, price, discount);
    }

    @Override
    public String toString() {
        return "Food{"
              + "name='" + name + '\''
              + ", expireDate=" + expireDate
              + ", createDate=" + createDate
              + ", price=" + price
              + ", discount=" + discount
              + '}';
    }
}
