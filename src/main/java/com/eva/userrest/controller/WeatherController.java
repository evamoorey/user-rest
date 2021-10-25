package com.eva.userrest.controller;

import com.eva.userrest.entity.WeatherData;

public interface WeatherController {
    WeatherData getWeatherInCity(String id);
}
