package ru.job4j.ood.srp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Date implements Printer {

    private String owner;
    private String model;
    private String code;
    private Date created;

    private static final LocalDate DATE = LocalDate.now();

    public Date(String owner, String model, String code, Date created) {
        this.owner = owner;
        this.model = model;
        this.code = code;
        this.created = created;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Date date = (Date) o;
        return Objects.equals(owner, date.owner)
                && Objects.equals(model, date.model)
                && Objects.equals(code, date.code)
                && Objects.equals(created, date.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, model, code, created);
    }

    @Override
    public void printInfo(String msg) {
        System.out.println(DATE.format(DateTimeFormatter.ofPattern(msg)));
    }

    public void save() {
        System.out.println("save smth");
    }

    public void read() {
        System.out.println("read smth");
    }

    public void create() {
        System.out.println("create smth");
    }
}
