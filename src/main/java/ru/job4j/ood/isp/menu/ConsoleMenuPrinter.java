package ru.job4j.ood.isp.menu;

import java.util.StringJoiner;

public class ConsoleMenuPrinter implements MenuPrinter {

    private static final String INDENT = "---";
    private static final String SPLITTER = "\\.";

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo itemInfo : menu) {
            String repeater = String.join(
                    INDENT.repeat(itemInfo.getNumber().split(SPLITTER).length - 1),
                    itemInfo.getName(),
                    itemInfo.getNumber()
            );
            System.out.println(repeater);
        }
    }
}
