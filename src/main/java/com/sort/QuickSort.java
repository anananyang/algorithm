package com.sort;

import java.util.List;

/**
 * 快速排序，时间复杂度不稳定的排序算法，排序性能非常依赖排序过程中选取的主元
 */
public class QuickSort implements Sort {

    public List<Integer> sort(List<Integer> list) {
        return this.sort(list, 0, list.size());
    }

    /**
     * 如果传入的数只有一个，那么就不需要排序，直接返回
     *
     * @param list
     * @param start
     * @param end
     * @return
     */
    private List<Integer> sort(List<Integer> list, int start, int end) {
        if (end - start > 1) {
            int blockIndex = this.make(list, start, end);
            sort(list, start, blockIndex);
            sort(list, blockIndex + 1, end);
        }

        return list;
    }


    /**
     * 快速排序的核心方法
     * 这里选取主元的方式非常简单，就是选取 list 下标为 start 的节点
     * <p>
     * 所以还有非常多可以优化的地方
     *
     * @param list
     * @param start
     * @param end
     * @return
     */
    public int make(List<Integer> list, int start, int end) {
        // 采用最简单的方式来选取主元，list[start]
        int i = start;
        int j = end - 1;
        int main = list.get(start);
        int blockIndex = start;
        while (i < j) {

            for (; j > i; j--) {
                if (list.get(j) < main) {
                    break;
                }
            }

            if (i < j) {
                list.set(blockIndex, list.get(j));
                blockIndex = j;
            }


            for (++i; i < j; i++) {
                if (list.get(i) > main) {
                    break;
                }
            }

            if (i < j) {
                list.set(j, list.get(i));
                blockIndex = i;
            }

        }

        list.set(blockIndex, main);

        return blockIndex;
    }

}
