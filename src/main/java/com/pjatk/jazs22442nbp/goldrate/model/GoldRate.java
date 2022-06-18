package com.pjatk.jazs22442nbp.goldrate.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "NBP Gold Rate", description = "Gold rate data with value and date from NBP API")
public class GoldRate {
    @ApiModelProperty(value = "The value of the gold rate")
    private double cena;

    @ApiModelProperty(value = "The date of the gold rate")
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
