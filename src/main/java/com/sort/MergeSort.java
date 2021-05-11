package com.sort;

import com.util.ListUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * 归并排序，是一种性能比较稳定的排序算法
 * 时间复杂度 O(N * lgN)
 */
public class MergeSort implements Sort {

    /**
     * 非递归形式的归并排序
     *
     * @param list
     * @return
     */
    public List<Integer> sort(List<Integer> list) {
        checkList(list);
        if (list.size() > 1) {
            int i = 2;
            for (; i <= list.size(); i *= 2) {
                for (int j = 0; j < list.size(); j += i) {
                    handleSpan(list, j, j + i);
                }
            }

            if (needMerge(list.size())) {
                int middle = i / 2;
                this.merge(list, 0, middle, middle, list.size());
            }
        }


        return list;
    }

    /**
     * 判断 list 的 size 是否为 2 的 N 次方
     *
     * @param number
     * @return
     */
    private Boolean needMerge(int number) {
        if (number > 2) {
            return ((number - 1) & number) != 0;
        }

        return Boolean.FALSE;
    }

    /**
     * 处理间距内的数据
     * <p>
     * ps：传入的 end 根据间距计算的，这里要根据 end 来计算块的切分点
     *
     * @param list
     * @param start
     * @param end
     */
    private void handleSpan(List<Integer> list, int start, int end) {
        // 先计算中间节点，判断中间节点是否越界
        int middle = (end - start) / 2 + start;
        if (middle < list.size()) {
            end = end <= list.size() ? end : list.size();
            this.merge(list, start, middle, middle, end);
        }
    }

    /**
     * 这一步是整个归并排序最重要的一步，合并
     * 不管是递归形式的归并排序，还是非递归形式的归并排序
     * 都会使用到这一步
     *
     * @param list
     * @param start_1
     * @param end_1
     * @param start_2
     * @param end_2
     */
    private void merge(List<Integer> list, int start_1, int end_1, int start_2, int end_2) {
        int start = start_1;
        int end = end_2;
        int size = end - start;

        List<Integer> temp = new ArrayList<Integer>(size);

        for (int i = 0; i < size; i++) {
            int a = list.get(start_1);
            int b = list.get(start_2);
            Boolean isGreatThan = a > b;
            int min = isGreatThan ? b : a;
            temp.add(min);

            if (isGreatThan) {
                ++start_2;
            } else {
                ++start_1;
            }

            // 有一部分已经处理完，就跳出循环
            if (start_1 == end_1 || start_2 == end_2) {
                break;
            }

        }

        // 判断那个部分没有结束，将剩下的那部分直接复制
        if (start_1 < end_1 && start_2 == end_2) {
            handleLeft(temp, list, start_1, end_1);
        } else if (start_1 == end_1 && start_2 < end_2) {
            handleLeft(temp, list, start_2, end_2);
        }


        copyTempToList(temp, list, start, end);

    }

    /**
     * 将整理好的 temp list 覆盖到原来的地方
     *
     * @param temp
     * @param list
     * @param start
     * @param end
     */
    private void copyTempToList(List<Integer> temp, List<Integer> list, int start, int end) {
        for (int i = 0; i < temp.size(); i++) {
            int index = start + i;
            if (index >= end) {
                throw new RuntimeException("copyTempToList list index out of end");
            }

            list.set(index, temp.get(i));
        }
    }

    /**
     * 将未处理完的部分直接合并
     *
     * @param temp
     * @param list
     * @param start
     * @param end
     */
    private void handleLeft(List<Integer> temp, List<Integer> list, int start, int end) {
        for (int i = start; i < end; i++) {
            temp.add(list.get(i));
        }
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
