package com.example.demo.bufferStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadStdinInt {

    public static void main(String[] args) {
        String line = null;
        int val = 0;
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            line = is.readLine();
            val = Integer.parseInt(line);
            is.close();

        } catch (IOException e) {
            System.out.println("Unexpected IO ERROR: "+ e);
        }
        System.out.println("I read the number: "+val);
    }
}
