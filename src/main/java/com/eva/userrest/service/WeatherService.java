package com.eva.userrest.service;

import com.eva.userrest.entity.Weather;
import com.eva.userrest.entity.WeatherData;

import java.io.IOException;

public interface WeatherService {
    boolean isCity(String city) throws IOException;
    WeatherData getCurrentWeather(String city);
}
