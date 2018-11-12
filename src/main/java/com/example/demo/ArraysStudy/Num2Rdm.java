package com.example.demo.ArraysStudy;

import java.util.Arrays;

/**
 * 将一个浮点数转换成人民币读法字符串
 * 该程序要完善的功能有
 * a 有两个零连在一起时怎么处理？
 * b 最高位是零如何处理
 * c 最低位是0如何处理
 */
public class Num2Rdm {

    private String[] hanArr = { "零", "壹", "贰", "叁", "肆", "伍",
            "陆", "柒", "捌", "玖"};

    private String[] unitArr = {"拾", "佰", "仟","万","万","万","万","亿"};

    /**
     * 把一个浮点数分解成整数部分和小数部分字符串
     * @param num
     * @return
     */
    private String[] divide(double num){
        long zheng = (long)num;
        long xiao = Math.round((num - zheng)*100);
        return new String[]{zheng+"", String.valueOf(xiao)};
    }

    private String toHanStr(String numStr){
        String result = "";
        int numLen = numStr.length();
        for(int i = 0 ; i < numLen ; i++){

            int num = Integer.parseInt(String.valueOf(numStr.charAt(i)));
            if(i != numLen -1 && num != 0){
                int unitArrIndex = numLen-2-i;
                if(unitArrIndex == unitArr.length ){
                    unitArrIndex = unitArr.length-1;
                }
               result += hanArr[num] + unitArr[unitArrIndex];

            } else {
                result += hanArr[num];
            }
        }
        return  result;

    }

    public static void main(String[] args) {
        Num2Rdm nr = new Num2Rdm();
        System.out.println(Arrays.toString(nr.divide(236711125.123)));
        System.out.println(nr.toHanStr("236711125"));
    }
}
