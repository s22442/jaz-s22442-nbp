package com.pjatk.jazs22442nbp.goldrate.model;

public class GoldRate {
    private double cena;
    private String data;

    public GoldRate() {
    }

    public GoldRate(double cena, String data) {
        this.cena = cena;
        this.data = data;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
