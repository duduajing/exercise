package com.example.demo.NioStudy;

import java.nio.ByteBuffer;

public class BufferTest {
    public static void main(String[] args) {
        ByteBuffer b = ByteBuffer.allocate(15);
        System.out.println("limit="+b.limit()+" capacity="+b.capacity()+" position="+b.position());
        for(int i = 0;i<10;i++){
            b.put((byte)i);
        }
        System.out.println("limit="+b.limit()+" capacity="+b.capacity()
                +" position="+b.position()+" mark="+b.mark());
        b.rewind();
        System.out.println("limit="+b.limit()+" capacity="+b.capacity()
                +" position="+b.position()+" mark="+b.mark());

        b.flip();
        System.out.println("limit="+b.limit()+" capacity="+b.capacity()+" position="+b.position());
        for(int i=0;i<5;i++){
            System.out.println(b.get());
        }
        System.out.println();
        System.out.println("limit="+b.limit()+" capacity="+b.capacity()+" position="+b.position());
        b.flip();
        System.out.println("limit="+b.limit()+" capacity="+b.capacity()+" position="+b.position());

    }

    /**
     * 使用静态方法allocate()从堆中分配缓冲区
     */
    public static ByteBuffer createBufferStatic(){
        return ByteBuffer.allocate(1024);
    }

    /**
     * 从既有数组中创建
     * @return
     */
    public static  ByteBuffer createBufferFromArray(){
        byte[] array = new byte[1024];
        return ByteBuffer.wrap(array);
    }



}
