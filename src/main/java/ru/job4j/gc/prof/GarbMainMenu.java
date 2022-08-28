package ru.job4j.gc.prof;

import ru.job4j.gc.leak.Post;

import java.util.Random;
import java.util.Scanner;

public class GarbMainMenu {

    public static final int CREATE_ARRAY = 1;
    public static final int BUBBLE_SORT = 2;
    public static final int INSERT_SORT = 3;
    public static final int MERGE_SORT = 4;
    public static final int EXIT_PROGRAM = 5;

    public static final String SELECT = "Выберите пункт меню";
    public static final String SORT = "Выберите тип сортировки. 2 - пузырьком, 3 - вставкой, 4 - слиянием";
    public static final String TEXT_OF_CREATE = "Создается массив на 250 тыс элементов";
    public static final String TEXT_OF_BUBBLE = "Применена сортировка пузырьком";
    public static final String TEXT_OF_INSERT = "Применена сортировка вставкой";
    public static final String TEXT_OF_MERGE = "Применена сортировка слиянием";
    public static final String EXIT = "Конец работы";

    public static final String MENU = """
                Введите 1 для создание массива.
                Введите 2 для сортировки пузырьком.
                Введите 3 для сортировки вставкой.
                Введите 4 для сортировки слиянием.
                Введите 5 для выхода из программы.
            """;

    public static void main(String[] args) {

        RandomArray randomArray = new RandomArray(new Random());
        Scanner scanner = new Scanner(System.in);
        start(randomArray, scanner);
    }

    private static void start(RandomArray randomArray, Scanner scanner) {
        boolean run = true;
        while (run) {
            System.out.println(MENU);
            System.out.println(SELECT);
            int userChoice = Integer.parseInt(scanner.nextLine());
            System.out.println(userChoice);
            if (CREATE_ARRAY == userChoice) {
                System.out.println(TEXT_OF_CREATE);
                randomArray.insert(250000);
                System.out.println(SORT);
            } else if (BUBBLE_SORT == userChoice) {
                new BubbleSort().sort(randomArray);
                System.out.println(TEXT_OF_BUBBLE);
            } else if (INSERT_SORT == userChoice) {
                new InsertSort().sort(randomArray);
                System.out.println(TEXT_OF_INSERT);
            } else if (MERGE_SORT == userChoice) {
                new MergeSort().sort(randomArray);
                System.out.println(TEXT_OF_MERGE);
            } else if (EXIT_PROGRAM == userChoice) {
                run = false;
                System.out.println(EXIT);
            } else {
                System.out.println("Выберите пункты меню от 1 до 5");
                System.out.println(MENU);
            }
        }
    }
}
