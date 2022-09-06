package ru.job4j.design.srp;

import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.function.Predicate;

public class ReportJson implements Report {

    private Store store;

    public ReportJson(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        var lib = new GsonBuilder().create();
        String json = lib.toJson(employees);
        return json;
    }
}
