package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {

    public <T> T maxMin(List<T> value, Comparator<T> comparator) {
        T res;
        if (value.isEmpty()) {
            res = null;
        } else {
            res = value.get(0);
            for (T t : value) {
                if (comparator.compare(t, res) > 0) {
                    res = t;
                }
            }
        }
        return res;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return maxMin(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return max(value, comparator.reversed());
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(12, -5, 124, 3, 9, -6, -35, 0, 18);
        Comparator<Integer> comparator = Integer::compareTo;
        MaxMin maxMin = new MaxMin();
        int max = maxMin.max(list, comparator);
        System.out.println(max);
        int min = maxMin.min(list, comparator);
        System.out.println(min);
    }
}
