package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.util.Scanner;

public class Emulator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Put the directory: ");
        DirFileCache cache = new DirFileCache(sc.nextLine());

        boolean run = true;
        while (run) {
            System.out.println("Enter file name for check: ");
            System.out.println(cache.get(sc.nextLine()));
            System.out.println("Put word '/NEXT'/ for look next file");
            String userChoice = sc.nextLine();
            if (!"NEXT".equals(userChoice)) {
                System.out.println("EXIT");
                run = false;
            }
        }
    }
}
