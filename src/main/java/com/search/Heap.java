package com.search;

/**
 * 优先队列，个人比较喜欢的一种数据结构，以前也用 c 语言实现过很多次
 * 这一次使用 java 来写一下
 */
public class Heap {

    private Integer[] array;

    private int DEFAULT_SIZE = 8;

    private int size;

    public Heap() {
        this.array = new Integer[DEFAULT_SIZE];
    }

    public Heap(Integer[] number) {
        this.array = number;
        this.size = number.length;
        if (array != null && array.length > 1) {
            this.makeHeap();
        }
    }

    public void addAll(Integer[] number) {
        if (number != null && number.length > 0) {
            for (Integer num : number) {
                add(num);
            }
        }
    }

    public int size() {
        return this.size;
    }

    /**
     * 添加一个数
     *
     * @param num
     */
    public void add(int num) {
        // 判断数组容量，是否足够
        checkCapacity();
        // 开始增加
        array[size] = num;
        size++;
        if(size > 1) {
            fixUp();
        }
    }


    /**
     * 从 heap 中删除 number 个节点
     */
    public Integer[] remove(int number) {
        if (number > size) {
            throw new RuntimeException("remove number great than array size");
        }

        Integer[] numberArray = new Integer[number];
        for (int i = 0; i < number; i++) {
            numberArray[i] = this.remove();
        }

        return numberArray;
    }

    /**
     * heap 的每次删除都是删除数组的第一个节点
     */
    public int remove() {
        if (size == 0) {
            throw new RuntimeException("array is blank");
        }

        int value = array[0];
        size--;
        array[0] = array[size];
        if (size > 1) {
            fixDown(0);
        }

        return value;
    }

    /**
     * 判断空间是否足够
     */
    private void checkCapacity() {
        if (size >= array.length - 1) {
            grow();
        }
    }

    /**
     * 进行扩容,
     * 这里实现的是简单的扩容方式，
     * 扩展之后的容量是之前的两倍
     */
    private void grow() {
        int currentSize = array.length;
        int newSize = currentSize * 2;
        Integer[] newArray = new Integer[newSize];

        for (int i = 0; i < currentSize; i++) {
            newArray[i] = array[i];
        }

        this.array = newArray;
    }


    /**
     * 将数组整理成 heap
     * 获取子节点中最小的那个节点，与当前父节点进行比较
     * 如果比当前父节点进行比较，如果发生交换，则要向下进行整理
     *
     * @return
     */
    private void makeHeap() {
        int index = array.length / 2 - 1;
        for (int start = index; start >= 0; start--) {

            int minChildIndex = this.getMinChildIndex(start);
            Boolean isSwap = this.swap(start, minChildIndex);
            if (isSwap) {
                fixDown(minChildIndex);
        }
        }
    }

    /**
     * 自顶向下开始整理
     *
     * @param index
     * @return
     */
    private void fixDown(int index) {
        // 判断节点是否有子节点
        int start = index;
        while (start * 2 + 1 < size) {
            int minChildIndex = this.getMinChildIndex(start);
            Boolean isSwap = swap(start, minChildIndex);
            // 如果没有发生交换
            if(!isSwap) {
                break;
            }
            start = minChildIndex;
        }
    }

    /**
     * 会采用自底向上的方式重新整理一遍
     *
     * @return
     */
    private void fixUp() {
        int index = size / 2 - 1;
        for (int start = index; start >= 0; start--) {
            Boolean isSwap = this.swap(start, this.getMinChildIndex(start));
            if(!isSwap) {
                break;
            }
        }
    }

    /**
     * 获取最小的子节点的下标
     *
     * @param start
     * @return
     */
    private int getMinChildIndex(int start) {
        int minChildIndex = start * 2 + 1;
        if (minChildIndex + 1 < size && array[minChildIndex] > array[minChildIndex + 1]) {
            ++minChildIndex;
        }
        return minChildIndex;
    }

    /**
     * 如果最小的子节点小于父节点，将该子节点和父节点进行交换
     *
     * @param start
     * @param minChildIndex
     * @return
     */
    private Boolean swap(int start, int minChildIndex) {
        int parent = array[start];
        int minChild = array[minChildIndex];
        if(parent <= minChild) {
            return false;
        }
        int temp = array[start];
        array[start] = array[minChildIndex];
        array[minChildIndex] = temp;

        return Boolean.TRUE;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        if(size > 0){
            for(int i = 0; i < size; i++){
                builder.append(" " + array[i] + " ");
            }
        }

        builder.append("]");
        return builder.toString();
    }


}
