package com.example.demo.bufferStudy;

import java.io.*;

public class BufferedWriterTest {

    private static final int CIRCLE = 10000;

    public static void main(String[] args) {
        try {
//            BufferedWriterTest.noBufferWriter();
            addBufferWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void noBufferWriter() throws IOException {
        Writer writer = new FileWriter(new File("file.txt"));
        long begin = System.currentTimeMillis();
        for(int i = 0; i < CIRCLE; i++){
           writer.write(i);
        }
        writer.close();
        System.out.println("testFileWriterspend:"+(System.currentTimeMillis()-begin));
    }

    public static void addBufferWriter() throws IOException {
        Writer writer = new BufferedWriter(new FileWriter(new File("file.txt")));

        long begin = System.currentTimeMillis();
        for(int i = 0; i < CIRCLE; i++){
            writer.write(i);
        }
        writer.close();
        System.out.println("testFileWriterBufferspend:"+(System.currentTimeMillis()-begin));
    }



}
