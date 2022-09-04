package ru.job4j.design.srp;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;
import static ru.job4j.design.srp.ReportEngine.DATE_FORMAT;

public class ReportEngineTest {

    private static final MemStore STORE = new MemStore();
    private static final Calendar NOW = Calendar.getInstance();
    private static final Employee JOHN = new Employee("John", NOW, NOW, 150);
    private static final Employee ADAM = new Employee("Adam", NOW, NOW, 120);
    private static final Employee KEVIN = new Employee("Kevin", NOW, NOW, 160);
    private static final Employee SALLY = new Employee("Sally", NOW, NOW, 140);

    private static final double EXCHANGE_RATE = 60.25;
    private static final String CURRENCY = "USD";

    @Test
    public void whenOldGenerated() {
        STORE.add(JOHN);
        Report engine = new ReportEngine(STORE);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(JOHN.getName()).append(";")
                .append(DATE_FORMAT.format(JOHN.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(JOHN.getFired().getTime())).append(";")
                .append(JOHN.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenReportHR() {
        STORE.add(JOHN);
        STORE.add(ADAM);
        STORE.add(KEVIN);
        STORE.add(SALLY);
        Report hr = new ReportHr(STORE);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(KEVIN.getName()).append(";").append(KEVIN.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(JOHN.getName()).append(";").append(JOHN.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(SALLY.getName()).append(";").append(SALLY.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(ADAM.getName()).append(";").append(ADAM.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(hr.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenReportAccountant() {
        STORE.add(SALLY);
        Report engine = new ReportAccountant(STORE);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(SALLY.getName()).append(";")
                .append(DATE_FORMAT.format(SALLY.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(SALLY.getFired().getTime())).append(";")
                .append(SALLY.getSalary() / EXCHANGE_RATE).append(CURRENCY).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}