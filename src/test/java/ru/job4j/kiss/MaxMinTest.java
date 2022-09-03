package ru.job4j.kiss;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class MaxMinTest {

    List<Integer> list = List.of(1, 2, 7, 1800, -250, 0, 6, 996, -643);
    Comparator<Integer> comparator = Integer::compareTo;
    MaxMin maxMin = new MaxMin();

    @Test
    public void whenMinus643IsMinNum() {
        int exp = -643;
        int res = maxMin.min(list, comparator);
        Assert.assertThat(exp, is(res));
    }

    @Test
    public void whenMinus643IsMaxNum() {
        int exp = 1800;
        int res = maxMin.max(list, comparator);
        Assert.assertEquals(res, exp);
    }

    @Test
    public void whenListIsEmptyThenResultIsNull() {
        Assert.assertNull(maxMin.min(new ArrayList<>(), comparator));
    }
}