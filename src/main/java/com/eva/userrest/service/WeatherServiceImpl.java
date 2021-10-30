package com.eva.userrest.service;

import com.eva.userrest.component.WeatherRequest;
import com.eva.userrest.entity.WeatherData;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService{
    private final WeatherRequest weatherRequest;

    public WeatherServiceImpl(WeatherRequest weatherRequest) {
        this.weatherRequest = weatherRequest;
    }

    public WeatherData getCurrentWeatherByCity(String city){
        return weatherRequest.getWeatherByCity(city);
    }

    public WeatherData getCurrentWeatherById(Integer id){
        return weatherRequest.getWeatherById(id);
    }
}
