package ru.job4j.ood.isp.menu;

public class MenuPrint implements MenuPrinter {

    private static final String INDENT = "---";

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo itemInfo : menu) {
            String repeater = INDENT.repeat(itemInfo.getNumber().split("\\.").length - 1)
                    + " " + itemInfo.getName()
                    + " " + itemInfo.getNumber();
            System.out.println(repeater);
        }
    }
}
