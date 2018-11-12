package com.example.demo.NioStudy;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.*;

/**
 * 除NIO外，使用java进行I/O操作有两种基本方式
 * 使用基于InputStream和OutputStream的方式 字节流
 * 使用Writer和Reader 字符流
 *
 * OutputStream FileOutputStream BufferedOutputStream
 * InputStream FileInputStream BufferInputStream
 * Writer FileWriter BufferedWriter
 * Reader FileReader BuffereaReader
 *
 */
public class StreamCompareToBuffer {
    private final static Integer count = 99999;

    public static void main(String[] args) {
        streamOutInputExample();
        bufferOutInputStream();
        fileWriteAndRead();
        bufferWriterAndReader();
    }

    public static  void  streamOutInputExample(){
        try {
            //往一个文件里写入内容
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("testfile.txt"));
            long start = System.currentTimeMillis();
            for(int i = 0; i< count; i++){
                dos.writeByte(i);
            }
            dos.close();
            System.out.println("testStream write file cost: "+(System.currentTimeMillis()-start));

            DataInputStream dis = new DataInputStream(new FileInputStream("testfile.txt"));
            start = System.currentTimeMillis();
            while (dis.readLine() != null){};
            dis.close();

            System.out.println("teststream read file cost: "+(System.currentTimeMillis()-start));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void bufferOutInputStream(){
        try {
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("testfile.txt")));
            long start = System.currentTimeMillis();
            for(int i = 0; i < count; i++){
                dos.writeByte(i);
            }
            dos.close();
            System.out.println("testbuffer write file cost: " + (System.currentTimeMillis()-start));

            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("testfile.txt")));
            start = System.currentTimeMillis();
            while(dis.readLine() != null){

            }
            dis.close();
            System.out.println("testBuffer read file cost: "+(System.currentTimeMillis() - start));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileWriteAndRead(){
        try {
            FileWriter fw = new FileWriter("testfile.txt");
            long start = System.currentTimeMillis();
            for(int i = 0;i<count*10; i++){
                fw.write(String.valueOf(i)+"\r\n");
            }
            fw.close();
            System.out.println("testFileWriter write file cost: " + (System.currentTimeMillis() - start));

            FileReader fr = new FileReader("testfile.txt");
            start = System.currentTimeMillis();
            while(fr.read() != -1){

            }
            fr.close();
            System.out.println("testFileReader read file cost: "+(System.currentTimeMillis() - start));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

public static void bufferWriterAndReader(){
    try {
        BufferedWriter fw = new BufferedWriter(new FileWriter("testfile.txt"));
        long start = System.currentTimeMillis();
        for(int i =0; i< count * 10; i++){
            fw.write(String.valueOf(i)+"/r/n");
        }
        fw.close();
        System.out.println("testBUfferedWriter write file cost: "+(System.currentTimeMillis() - start));

        BufferedReader fr = new BufferedReader(new FileReader("testfile.txt"));
        while(fr.read() != -1){

        }
        fr.close();
        System.out.println("testBufferedReader read file cost: "+(System.currentTimeMillis() - start));
    } catch (IOException e) {
        e.printStackTrace();
    }

}
}
