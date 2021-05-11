package com.util;


import org.junit.Test;


public class RandomUtilTest {

    @Test
    public void randomNumGenerator() {
        Integer[] array = RandomUtil.randomNumGenerator(2000);
        System.out.println("array length :" + array.length);
        for(Integer i : array){
            System.out.println(i);
        }
    }

}