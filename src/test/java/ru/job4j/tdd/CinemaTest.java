//package ru.job4j.tdd;
//
//import org.junit.Ignore;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import static org.assertj.core.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//import java.util.Calendar;
//import java.util.List;
//
//@Disabled
//public class CinemaTest {
//
//    @Ignore
//    @Test
//    public void whenBuy() {
//        Account account = new AccountCinema();
//        Cinema cinema = new Cinema3D();
//        Calendar date = Calendar.getInstance();
//        Ticket ticket = cinema.buy(account, 1, 1, date);
//        assertThat(ticket).isEqualTo(new Ticket3D());
//    }
//
//    @Ignore
//    @Test
//    public void whenFind() {
//        Cinema cinema = new Cinema3D();
//        cinema.add(new Session3D());
//        List<Session> sessions = cinema.find(session -> true);
//        assertThat(sessions).isNull();
//    }
//
//    @Ignore
//    @Test()
//    public void whenInvalidPlace() {
//        Account account = new AccountCinema();
//        Cinema cinema = new Cinema3D();
//        Calendar date = Calendar.getInstance();
//        assertThrows(IllegalArgumentException.class, () -> {
//            cinema.buy(account, -1, 1, date);
//        });
//    }
//
//    @Ignore
//    @Test()
//    public void whenInvalidDate() {
//        Account account = new AccountCinema();
//        Cinema cinema = new Cinema3D();
//        Calendar date = Calendar.getInstance();
//        date.set(1999, 12, 23);
//        assertThrows(IllegalArgumentException.class, () -> {
//            cinema.buy(account, 2, 1, date);
//        });
//    }
//
//    @Ignore
//    @Test (expected = IllegalArgumentException.class)
//    public void whenCantBuy() {
//        Account account = new AccountCinema();
//        Cinema cinema = new Cinema3D();
//        Calendar date = Calendar.getInstance();
//        Ticket ticket = cinema.buy(account, 1, 1, date);
//        boolean expected = ticket.equals(new Ticket3D());
//    }
//}
