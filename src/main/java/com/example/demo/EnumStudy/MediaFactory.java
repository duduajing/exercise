package com.example.demo.EnumStudy;

public class MediaFactory<T> {

    public static void main(String[] args) {
        "s".equals("a");
        System.out.println(MediaFactory.getMedia(Media.class,"Book").getK());
        System.out.println(MediaFactory.getMedia(1));

    }

    public static <T extends Enum<T>> T getMedia(Class<T> enumClass,String s){
        return Enum.valueOf(enumClass, s.toLowerCase());
    }

    public static Media getMedia(int n){
        return Media.values()[n];
    }
}
