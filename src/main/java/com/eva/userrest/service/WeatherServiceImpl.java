package com.eva.userrest.service;

import com.eva.userrest.component.WeatherRequest;
import com.eva.userrest.entity.Weather;
import com.eva.userrest.entity.WeatherData;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherServiceImpl implements WeatherService{
    private final WeatherRequest weatherRequest;

    public WeatherServiceImpl(WeatherRequest weatherRequest) {
        this.weatherRequest = weatherRequest;
    }

    public boolean isCity(String city) {
        return weatherRequest.isCity(city);
    }

    public WeatherData getCurrentWeather(String city){
        return weatherRequest.getWeather(city);
    }
}
