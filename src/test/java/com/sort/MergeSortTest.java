package com.sort;

import com.util.RandomUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MergeSortTest {
    public MergeSort mergeSort;

    @Before
    public void init() {
        mergeSort = new MergeSort();
    }

//    @Test
//    public void sort() {
//        Integer[] array = RandomUtil.randomNumGenerator(13);
//        List<Integer> list = Arrays.asList(array);
//        print(list);
//        mergeSort.sort(list);
//        System.out.println("");
//        print(list);
//
//    }

    @Test
    public void batchSort() {

        for (int i = 1; i< 100 ; i++){
            Integer[] array = RandomUtil.randomNumGenerator(i);
            System.out.println("开始进入第 " + i + "次测试");
            List<Integer> list = Arrays.asList(array);
            mergeSort.sort(list);
            System.out.println("");
            print(list);
        }


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