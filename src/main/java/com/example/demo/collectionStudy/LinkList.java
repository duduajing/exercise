package com.example.demo.collectionStudy;

public class LinkList {

    public static void main(String[] args) {
        System.out.println("Here is a demo of a Linked List in Java");
        LinkList l = new LinkList();
        l.add(new Object());
        l.add("hello");

        System.out.println("Here is a list of all the elements");
        l.print();
        if(l.lookup("hello")){
            System.out.println("Lookup works");
        } else {
            System.out.println("Lookup does not work");
        }
    }

    class TNode{
        TNode next;
        Object data;

        public TNode(Object data) {
            this.data = data;
        }
    }

    protected TNode root;
    protected TNode last;

    /**
     * 构造LinkList类： 设置首节点与尾节点
     */
    public LinkList() {
        root = new TNode(this);
        last = root;
    }


    /**
     * 在链表的末尾添加一个对象。更新最后节点的"next" 引用，
     * 使其指向新节点；更新"last"引用，指向该节点的"next"。
     * @param o
     */
    void add(Object o){
        last.next = new TNode(o);
        last = last.next;
    }

    public boolean lookup(Object o){
        for(TNode p = root.next; p != null; p = p.next){
            if(p.data == o || p.data.equals(o)){
                return true;
            }

        }
        return false;
    }

    void print(){
        for(TNode p = root.next; p != null; p = p.next){
            System.out.println("TNode "+ p +" = "+p.data);
        }
    }
}
