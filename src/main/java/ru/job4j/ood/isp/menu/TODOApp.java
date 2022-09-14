package ru.job4j.ood.isp.menu;

import ru.job4j.ood.isp.menu.ActionDelegate;
import ru.job4j.ood.isp.menu.Menu;
import ru.job4j.ood.isp.menu.SimpleMenu;

import java.util.Scanner;

public class TODOApp {

    private static final ActionDelegate STUB_ACTION = System.out::println;
    private static final String ADD_PARENT_ITEM = "1";
    private static final String ADD_CHILD_ITEM = "2";
    private static final String ALL_ITEMS = "3";
    private static final String EXIT = "4";
    private static final String SHOW_MENU = """
         CHOSE OPTION:
         "1" - for add parent item
         "2" - for add child item
         "3" - for showing all items
         "4" - for exit
            """;

    private final Menu menu = new SimpleMenu();
    private final Scanner sc = new Scanner(System.in);

    private void addItem() {
        System.out.println("Put parent item name");
        String item = sc.nextLine();
        menu.add(Menu.ROOT, item, STUB_ACTION);
        System.out.println("Item was added");
    }

    private void addChildItem() {
        System.out.println("Put parent item name:");
        String parent = sc.nextLine();
        System.out.println("Put child item name:");
        String child = sc.nextLine();
        menu.add(parent, child, STUB_ACTION);
        System.out.println("Item was added");
    }

    private void showAllItems() {
        System.out.println("All items:");
        new MenuPrint().print(menu);
    }

    private void start() {
        String choice = "";
        while (!choice.equals(EXIT)) {
            System.out.println(SHOW_MENU);
            choice  = sc.nextLine();
            switch (choice) {
                case ADD_PARENT_ITEM -> addItem();
                case ADD_CHILD_ITEM -> addChildItem();
                case ALL_ITEMS -> showAllItems();
                case EXIT -> System.out.println("Exit");
                default -> System.out.println("Incorrect put, choose only 4 options");
            }
        }
    }

    public static void main(String[] args) {
        new TODOApp().start();
    }
}
