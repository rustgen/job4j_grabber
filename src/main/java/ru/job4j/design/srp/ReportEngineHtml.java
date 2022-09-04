package ru.job4j.design.srp;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngineHtml implements Report, Writer {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    private static final String FILE = "report.html";

    private Store store;

    public ReportEngineHtml(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        List<Employee> employees = store.findBy(filter);
        for (Employee employee : employees) {
            text.append(employee.getName()).append(";")
                    .append(DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                    .append(DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        write(employees);
        return text.toString();
    }

    @Override
    public void write(List<Employee> list) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(FILE)))) {
            for (Employee e : list) {
                out.write(e.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
