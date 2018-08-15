package com.example.rakesh.movietrailers;

public class Details {
    int poster;
    private String name;
    private String director;
    private String artists;


    public Details(int poster,String name, String director, String artists) {
        this.poster = poster;
        this.name = name;
        this.director = director;
        this.artists = artists;

    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }
}
