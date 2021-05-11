package com.util;


import java.util.Random;

/**
 * 随机数生成工具
 */
public class RandomUtil {

    private static int MIN_DEFAULT_SIZE = 10;
    private static int MAX_DEFAULT_SIZE = 10000;

    /**
     * 随机数生成器, 最多生成 1000 个随机数
     *
     * @param size
     * @return
     */
    public static Integer[] randomNumGenerator(int size) {
        size = checkSize(size);
        Integer[] array = new Integer[size];
        Random random = new Random(5000);

        for (int i = 0; i < array.length; i++) {
            int num = random.nextInt();
            array[i] = num;
        }

        return array;
    }


    /**
     * 对 size 进行校验
     *
     * @param size
     * @return
     */
    private static int checkSize(int size) {
        if (size < 0) {
            return MIN_DEFAULT_SIZE;
        }

        if (size > MAX_DEFAULT_SIZE) {
            return MIN_DEFAULT_SIZE;
        }

        return size;
    }
}
