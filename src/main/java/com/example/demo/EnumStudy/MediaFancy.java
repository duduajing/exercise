package com.example.demo.EnumStudy;

public enum MediaFancy {
    book{
        @Override
        public String toString(){
            return "Book";
        }
    },music_cd, music_vinyl,movie_vhs, movie_dvd;

    public static void main(String[] args) {
        MediaFancy[] data = {book, movie_dvd,music_vinyl};

        for(MediaFancy mf : data){
            System.out.println(mf);
        }
    }
}
