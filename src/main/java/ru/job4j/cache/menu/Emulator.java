package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;
import ru.job4j.gc.leak.CommentGenerator;
import ru.job4j.gc.leak.Post;
import ru.job4j.gc.leak.PostStore;
import ru.job4j.gc.leak.UserGenerator;

import java.util.Scanner;

public class Emulator {

    public static final int SPEC_CACHE = 1;
    public static final int LOAD_CONT = 2;
    public static final int GET_FILE = 3;

    public static final String SPECIFY = "Specify a cached directory: ";
    public static final String LOAD = "Load contents of the file into cache: ";
    public static final String GET_CONTENT = "Get file content from cache: ";
    public static final String EXIT = "End of work";

    public static final String MENU = """
                Put 1 specify cached directory.
                Put 2, load contents of the file into cache.
                Put 3, get file content from cache.
                Enter other number to exit.
            """;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DirFileCache cache = new DirFileCache(sc.nextLine());
        start(cache, sc);
    }

    private static void start(DirFileCache cache, Scanner scanner) {
        boolean run = true;
        String dir = "";
        while (run) {
            System.out.println(MENU);
            int userChoice = Integer.parseInt(scanner.nextLine());
            System.out.println(userChoice);
            if (SPEC_CACHE == userChoice) {
                System.out.println(SPECIFY);
                dir = scanner.nextLine();
            } else if (LOAD_CONT == userChoice) {
                System.out.println(LOAD);
                System.out.println("Не знаю, как реализовать пункт - загрузить содержимое файла в кэш");
            } else if (GET_FILE == userChoice) {
                System.out.println(GET_CONTENT);
                System.out.println(cache.get(dir));
            }  else {
                run = false;
                System.out.println(EXIT);
            }
        }
    }
}
