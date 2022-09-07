package ru.job4j.design.srp;


import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringJoiner;

import static org.assertj.core.api.Assertions.*;
import static ru.job4j.design.srp.ReportEngine.DATE_FORMAT;

public class ReportEngineTest {

    private static MemStore store = new MemStore();
    private static Calendar now = Calendar.getInstance();
    private static Employee john = new Employee("John", now, now, 150);
    private static Employee adam = new Employee("Adam", now, now, 120);
    private static Employee kevin = new Employee("Kevin", now, now, 160);
    private static Employee sally = new Employee("Sally", now, now, 140);
    private static Employee henry = new Employee(
            "Henry", new GregorianCalendar(2021, Calendar.DECEMBER, 23),
            new GregorianCalendar(2022, Calendar.FEBRUARY, 13), 140);

    @Test
    public void whenOldGenerated() {
        store.add(john);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(john.getName()).append(";")
                .append(DATE_FORMAT.format(john.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(john.getFired().getTime())).append(";")
                .append(john.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenReportHR() {
        store.add(john);
        store.add(adam);
        store.add(kevin);
        store.add(sally);
        Report hr = new ReportHr(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(kevin.getName()).append(";").append(kevin.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(john.getName()).append(";").append(john.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(sally.getName()).append(";").append(sally.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(adam.getName()).append(";").append(adam.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(hr.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenReportAccountant() {
        store.add(sally);
        Report engine = new ReportAccountant(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(sally.getName()).append(";")
                .append(DATE_FORMAT.format(sally.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(sally.getFired().getTime())).append(";")
                .append(sally.getSalary() / ReportAccountant.EXCHANGE_RATE).append(ReportAccountant.CURRENCY).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenReportToHtml() {
        store.add(sally);
        Report engine = new ReportEngineHtml(store);
        StringBuilder expect = new StringBuilder()
                .append("<!DOCTYPE HTML>")
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
                .append("</tr>").append(System.lineSeparator())
                .append("<tr>").append(System.lineSeparator())
                .append("<td>").append(sally.getName()).append("</td>")
                .append("<td>").append(DATE_FORMAT.format(sally.getHired().getTime())).append("</td>")
                .append("<td>").append(DATE_FORMAT.format(sally.getFired().getTime())).append("</td>")
                .append("<td>").append(sally.getSalary()).append("</td>")
                .append("</tr>").append(System.lineSeparator())
                .append("</table>").append(System.lineSeparator())
                .append("</body>").append(System.lineSeparator())
                .append("</html>").append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenReportToJson() {
        store.add(henry);
        ReportJson engine = new ReportJson(store);
        String result = engine.generate(employee -> true);
        StringJoiner expect = new StringJoiner("")
                .add("[{\"name\":\"Henry\",")
                .add("\"hired\":{\"year\":2021,\"month\":11,\"dayOfMonth\":23,"
                        + "\"hourOfDay\":0,\"minute\":0,\"second\":0},")
                .add("\"fired\":{\"year\":2022,\"month\":1,\"dayOfMonth\":13,"
                        + "\"hourOfDay\":0,\"minute\":0,\"second\":0},")
                .add("\"salary\":140.0")
                .add("}]");
        assertThat(result).isEqualTo(expect.toString());
    }

    @Test
    public void whenReportToXml() {
        store.add(henry);
        Report engine = new ReportXml(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append(System.lineSeparator())
                .append("<employees/>")
                .append(System.lineSeparator())
                .append("");
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}