package com.eva.userrest.controller;

import com.eva.userrest.entity.Weather;

public interface WeatherController {
    Weather getWeatherInCity(String id);
}
