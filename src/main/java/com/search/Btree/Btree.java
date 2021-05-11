package com.search.Btree;

public class Btree {

    private static Integer M;       // 每个树节点的最大长度
    private Integer hegiht = 0;  // 树的高度
    private Integer count = 0;   // 树中维护的节点数量

    private BtreeNode root;

    public Btree(Integer M) {
        if(M <= 0) {
            throw new RuntimeException("M must be greater than 0");
        }
        this.M = M;
    }

    public static void main(String[] args) {
        Btree btree = new Btree(5);

    }

    // 增加
    public void put(String key, Object value){
        if(root == null) {
            root = new BtreeNode(M);
        }
        root.insert(key, value);
    }

    public void get(){

    }
    public void remove(){

    }


    private BtreeNode searchNode(){
        return null;
    }

}
