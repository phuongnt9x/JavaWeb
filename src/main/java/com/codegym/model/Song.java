package com.codegym.model;

public class Song {
    private int id;

    private String name;
    private String artist;

    private String category;

    private String fileName;

    public Song() {
    }

    public Song(int id, String name, String artist, String category, String fileName) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.category = category;
        this.fileName = fileName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
