package com.example.demo.StringStudy;

import java.util.StringTokenizer;

/**
 * 使用StringTokenizer类，包括返回分隔符
 */
public class StrTokDemo4 {

    public final static int MAXFIFLDS = 5;
    public final static String DELIM = "|";

    public static String[] process(String line){
        String[] results = new String[MAXFIFLDS];
        StringTokenizer st = new StringTokenizer(line, DELIM, true);
        int i = 0;
        while (st.hasMoreTokens()){
            String s = st.nextToken();
            if(s.equals(DELIM)){
                if(i++ >= MAXFIFLDS){
                    throw new IllegalArgumentException("Input line" + line +" has too many fields");
                }
                continue;
            }
            results[i] = s;
        }
        return results;
    }

    public static void printResults(String input, String[] outputs){
        System.out.println("Input: "+ input);
        for(int i = 0; i < outputs.length; i++){
            System.out.println("Output " + i +" was: "+outputs[i]);
        }
    }

    public static void main(String[] args) {
        printResults("A|B|C|D", process("A|B|C|D"));
        printResults("A||C|D", process("A||C|D"));
        printResults("A|||C|D", process("A|||C|D"));

    }
}
