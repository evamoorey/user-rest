package com.eva.userrest.component;

import com.eva.userrest.entity.Weather;
import com.eva.userrest.entity.WeatherData;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class WeatherRequest {
    private final RestTemplate restTemplate;

    public WeatherRequest() {
        restTemplate = new RestTemplate();
    }

    // Get current weather in city.
    public WeatherData getWeather(String city){
        try {
            return restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q={city}&appid={API key}"
                            .replace("{city}",city)
                    .replace("{API key}", "8e13dbfdb4d289209b9e3fab3b32c8e1"), WeatherData.class);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
