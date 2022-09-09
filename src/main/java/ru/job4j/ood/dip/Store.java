package ru.job4j.ood.dip;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private String name;

    private List<Bed> beds = new ArrayList<>();

    public Store(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printList(ArrayList list) {
        list.forEach(System.out::println);
    }

    public String workingTimeError(String time) {
        return "working time error: " + time + " " + name;
    }

    public void printReceipt(List<String> receipt) {
        receipt.forEach(System.out::println);
    }

    public void holidays() {
        System.out.println("We are closed on holidays");
    }
}
