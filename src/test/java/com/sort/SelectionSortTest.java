package com.sort;

import com.util.RandomUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SelectionSortTest {

    public SelectionSort selectionSort;

    @Before
    public void init() {
        selectionSort = new SelectionSort();
    }

    @Test
    public void sort() {
        Integer[] array = RandomUtil.randomNumGenerator(1000);
        List<Integer> list = Arrays.asList(array);
        List<Integer> sortedList = selectionSort.sort(list);
        for (Integer num : sortedList) {
            System.out.println(num);
        }

    }

}