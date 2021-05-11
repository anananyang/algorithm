package com.sort;

import com.util.RandomUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class QuickSortTest {

    public QuickSort quickSort;

    @Before
    public void init() {
        quickSort = new QuickSort();
    }

    @Test
    public void sort() {

        Integer[] array = RandomUtil.randomNumGenerator(5000);
        System.out.println(Arrays.toString(array));
        List<Integer> list = Arrays.asList(array);
        quickSort.sort(list);
        System.out.println(list.toString());
        System.out.println("");
        print(list);

    }


    private void print(List<Integer> list) {
        if (list != null && list.size() > 0) {
            Iterator it = list.iterator();
            Integer value = (Integer) it.next();
            System.out.println(value);

            while (it.hasNext()) {
                Integer value1 = (Integer) it.next();
                if (value1 < value) {
                    throw new RuntimeException("sort result error：value1 [ " + value1 + " ] < value [ " + value + " ] ");
                }
                value = value1;
            }

        }
    }

}