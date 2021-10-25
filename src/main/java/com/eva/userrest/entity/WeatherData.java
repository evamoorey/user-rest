package com.eva.userrest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {
    private Weather[] weather;
    private Main main;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Weather getWeather() {
        return weather[0];
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }
}
