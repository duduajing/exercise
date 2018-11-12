package com.example.demo.bufferStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CatStdin {

    public static void main(String[] args) {

        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            String inputFile;
            while((inputFile = is.readLine())!=null){
                System.out.println(inputFile);
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
