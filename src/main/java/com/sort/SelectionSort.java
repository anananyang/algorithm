package com.sort;


import com.util.ListUtil;

import java.util.List;

/**
 * 选择排序
 * <p>
 * 是一种比较简单的排序算法，时间复杂度 O(N^2)
 */
public class SelectionSort implements Sort{


    /**
     * @param list
     * @return
     */
    public List<Integer> sort(List<Integer> list) {
        checkList(list);
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(i)) {
                    int num = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, num);
                }
            }
        }

        return list;
    }


    /**
     * 对传入的 list 进行校验
     *
     * @param list
     */
    private void checkList(List<Integer> list) {
        if (ListUtil.isBlank(list)) {
            throw new RuntimeException("selection sort list is blank");
        }
    }

}
