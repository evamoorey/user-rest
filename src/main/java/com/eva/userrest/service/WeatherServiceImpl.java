package com.eva.userrest.service;

import com.eva.userrest.component.WeatherRequest;
import com.eva.userrest.entity.WeatherData;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class WeatherServiceImpl implements WeatherService{
    private final WeatherRequest weatherRequest;

    public WeatherServiceImpl(WeatherRequest weatherRequest) {
        this.weatherRequest = weatherRequest;
    }

    public WeatherData getCurrentWeather(String city){
        return weatherRequest.getWeather(city);
    }
}
