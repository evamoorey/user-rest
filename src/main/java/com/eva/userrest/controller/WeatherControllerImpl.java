package com.eva.userrest.controller;

import com.eva.userrest.entity.WeatherData;
import com.eva.userrest.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/weather")
public class WeatherControllerImpl implements WeatherController {

    private final WeatherService weatherService;

    public WeatherControllerImpl(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<WeatherData> getWeatherInCity(@PathVariable String city){
        return Optional.ofNullable(weatherService.getCurrentWeather(city))
                .map(weather -> ResponseEntity.ok().body(weather))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
