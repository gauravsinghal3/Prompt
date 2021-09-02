package com.example.prompt;


public class WalmartStoreProfile {

    private String id;
    private double lat;
    private double lang;

    public WalmartStoreProfile(String id, double i, double i1) {
        this.id = id;
        this.lat = i;
        this.lang = i1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLang() {
        return lang;
    }

    public void setLang(double lang) {
        this.lang = lang;
    }
}
