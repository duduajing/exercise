package com.example.demo.EnumStudy;

public enum Media {
    book(1,"book"),
    music_cd(2,"music_cd"),
    music_vinyl(3,"music_vinyl"),
    movie_vhs(4,"movie_vhs"),
    moovie_dvd(5,"moovie_dvd");

    private Integer k;
    private String v;

    Media(Integer k, String v) {
        this.k = k;
        this.v = v;
    }

    public Integer getK() {
        return k;
    }

    public String getV() {
        return v;
    }
}
