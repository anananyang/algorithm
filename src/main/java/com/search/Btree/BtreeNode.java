package com.search.Btree;

public class BtreeNode {

    private BtreeNodeEntry[] entries;
    private int count;  // number of entries

    public BtreeNode(Integer M) {
        this.entries = new BtreeNodeEntry[M];
        this.count = 0;
    }

    /**
     * 插入
     * @param key
     * @param value
     */
    public void insert(String key, Object value){


    }
}
