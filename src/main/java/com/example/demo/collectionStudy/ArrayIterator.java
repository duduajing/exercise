package com.example.demo.collectionStudy;

import java.util.Iterator;

public class ArrayIterator implements Iterator {

    protected Object[] data;

    protected int index = 0;

    public ArrayIterator(Object[] data) {
        setData(data);
    }
    public void setData(Object[] data){
        this.data = data;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index<data.length;
    }

    @Override
    public Object next() {
        if(hasNext()){
           return data[index++];
        }
        throw new IndexOutOfBoundsException("only "+ data.length+" elements");
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("This demo does not implement the remove method");
    }

    public static void main(String[] args) {
         String[] data = {"one", "two", "three"};
         ArrayIterator it = new ArrayIterator(data);
         while (it.hasNext()){
             System.out.println(it.next());
         }


    }
}
