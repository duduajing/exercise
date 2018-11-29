package com.example.demo.pattern.prototype.deep;

public class Main {

    public static void main(String[] args) {
        QiTianDaSheng qts = new QiTianDaSheng();
//        System.out.println(qts);
//        try {
//            QiTianDaSheng c = (QiTianDaSheng)qts.clone();
////            System.out.println(c);
//            System.out.println(qts.getJingubang() == c.getJingubang());
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }

        QiTianDaSheng qts2 =qts.copy(qts);
        System.out.println(qts.getJingubang() == qts2.getJingubang());
    }
}
