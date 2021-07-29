package com.pactera.weather.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class WeatherServiceTest {
    @InjectMocks
    private WeatherService weatherService;

    @Test
    public void getAllCity(){
        Assert.assertNotNull(weatherService.getAllCity());
    }

    @Test
    public void getCityWeather(){
        Assert.assertNotNull(weatherService.getCityWeather("纽约"));
    }
}
