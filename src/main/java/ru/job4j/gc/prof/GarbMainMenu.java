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

    public static final String SELECT = "�������� ����� ����";
    public static final String SORT = "�������� ��� ����������. 2 - ���������, 3 - ��������, 4 - ��������";
    public static final String TEXT_OF_CREATE = "��������� ������ �� 250 ��� ���������";
    public static final String TEXT_OF_BUBBLE = "��������� ���������� ���������";
    public static final String TEXT_OF_INSERT = "��������� ���������� ��������";
    public static final String TEXT_OF_MERGE = "��������� ���������� ��������";
    public static final String EXIT = "����� ������";

    public static final String MENU = """
                ������� 1 ��� �������� �������.
                ������� 2 ��� ���������� ���������.
                ������� 3 ��� ���������� ��������.
                ������� 4 ��� ���������� ��������.
                ������� 5 ��� ������ �� ���������.
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
                System.out.println("�������� ������ ���� �� 1 �� 5");
                System.out.println(MENU);
            }
        }
    }
}
