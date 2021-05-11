package com.search;

import com.util.RandomUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class HeapTest {

    private static Heap heap;


    static {
//        Integer[] array = {8, 6, 7, 3, 2, 4, 1};
        Integer[] array = RandomUtil.randomNumGenerator(1000);
        heap = new Heap(array);
//        System.out.println(heap.toString());
    }


    @Test
    public void remove() {
        System.out.println("remove start:" + heap.size());
        Integer[] sortArray = heap.remove(heap.size());
        System.out.println("sortArray size:" + sortArray.length);
        List<Integer> list = Arrays.asList(sortArray);
        print(list);
        System.out.println("remove end");


    }

    @Test
    public void size() {
        System.out.println("size:" + heap.size());
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
                System.out.println(value1);
                value = value1;
            }

        }
    }


}