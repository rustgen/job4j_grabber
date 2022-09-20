package ru.job4j.ood.isp.menu;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleMenuTest {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    @Test
    public void whenAddThenReturnSame() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Go to the shop", STUB_ACTION);
        menu.add(Menu.ROOT, "Feed the dog", STUB_ACTION);
        menu.add("Go to the shop", "Buy products", STUB_ACTION);
        menu.add("Buy products", "Buy bread", STUB_ACTION);
        menu.add("Buy products", "Buy milk", STUB_ACTION);
        assertThat(new Menu.MenuItemInfo("Go to the shop",
                List.of("Buy products"), STUB_ACTION, "1."))
                .isEqualTo(menu.select("Go to the shop").get());
        assertThat(new Menu.MenuItemInfo(
                "Buy products",
                List.of("Buy bread", "Buy milk"), STUB_ACTION, "1.1."))
                .isEqualTo(menu.select("Buy products").get());
        assertThat(new Menu.MenuItemInfo(
                "Feed the dog", List.of(), STUB_ACTION, "2."))
                .isEqualTo(menu.select("Feed the dog").get());
        menu.forEach(i -> System.out.println(i.getNumber() + i.getName()));
    }

    @Test
    public void whenSelectThenOutAllSelected() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Reminders", STUB_ACTION);
        menu.add(Menu.ROOT, "Tasks", STUB_ACTION);
        menu.add("Reminders", "Pay the phone", STUB_ACTION);
        menu.add("Reminders", "Pay for insurance", STUB_ACTION);
        menu.add("Tasks", "Clean home", STUB_ACTION);
        menu.add("Tasks", "Buy products", STUB_ACTION);
        assertThat(menu.select("Reminders").get())
                .isEqualTo(new Menu.MenuItemInfo(
                        "Reminders",
                        List.of("Pay the phone", "Pay for insurance"),
                        STUB_ACTION,
                        "1."));
    }

    @Test
    public void whenAddThenOut() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Reminders", STUB_ACTION);
        menu.add(Menu.ROOT, "Tasks", STUB_ACTION);
        menu.add("Reminders", "Pay the phone", STUB_ACTION);
        menu.add("Reminders", "Pay for insurance", STUB_ACTION);
        menu.add("Tasks", "Clean home", STUB_ACTION);
        menu.add("Tasks", "Buy products", STUB_ACTION);
        List<Menu.MenuItemInfo> expected = List.of((new Menu.MenuItemInfo(
                "Reminders",
                List.of("Pay the phone", "Pay for insurance"), STUB_ACTION, "1."
        )), new Menu.MenuItemInfo(
                "Tasks",
                List.of("Clean home", "Pay for insurance"), STUB_ACTION, "2."
        ));
        menu.forEach(i -> System.out.println(i.getNumber() + i.getName()));
        List<String> result = new ArrayList<>();
        menu.forEach(el -> result.add(el.getNumber() + el.getName()));
    }
}