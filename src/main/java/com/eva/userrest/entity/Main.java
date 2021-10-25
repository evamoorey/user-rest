package com.eva.userrest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {
    private int temp;

    public int getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = (int)Math.round(temp - 273);
    }
}
