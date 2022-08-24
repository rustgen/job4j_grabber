package ru.job4j.gc.prof;

import java.util.Random;

public class GarbMainMenu {
    public static void main(String[] args) {

        RandomArray randomArray = new RandomArray(new Random());
        randomArray.insert(250000);
        new BubbleSort().sort(randomArray);
        new InsertSort().sort(randomArray);
        new MergeSort().sort(randomArray);
    }
}
