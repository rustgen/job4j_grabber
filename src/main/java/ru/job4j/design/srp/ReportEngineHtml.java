package ru.job4j.design.srp;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngineHtml implements Report {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    private Store store;

    public ReportEngineHtml(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<!DOCTYPE HTML>")
                .append(System.lineSeparator())
                .append("<html>").append(System.lineSeparator())
                .append("<head>").append(System.lineSeparator())
                .append("<meta http-equiv=\"content-Type\" content=\"text/html; charset=utf-8\">")
                .append(System.lineSeparator())
                .append("<title>Table</title>")
                .append(System.lineSeparator())
                .append("</head>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("<table>").append(System.lineSeparator())
                .append("<tr>").append(System.lineSeparator())
                .append("<th>Name</th><th>Hired</th><th>Fired</th><th>salary</th>")
                .append(System.lineSeparator())
                .append("</tr>").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append("<tr>").append(System.lineSeparator())
                    .append("<td>").append(employee.getName()).append("</td>")
                    .append("<td>").append(DATE_FORMAT.format(employee.getHired().getTime())).append("</td>")
                    .append("<td>").append(DATE_FORMAT.format(employee.getFired().getTime())).append("</td>")
                    .append("<td>").append(employee.getSalary()).append("</td>")
                    .append("</tr>").append(System.lineSeparator());
        }
        text.append("‹/table>").append(System.lineSeparator())
                .append("</body>").append(System.lineSeparator())
                .append("</html>").append(System.lineSeparator());
        return text.toString();
    }
}
