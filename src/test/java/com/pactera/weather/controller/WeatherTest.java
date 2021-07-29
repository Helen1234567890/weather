package com.pactera.weather.controller;

import com.pactera.weather.domain.City;
import com.pactera.weather.domain.DateWeather;
import com.pactera.weather.service.WeatherService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

@SpringBootTest
public class WeatherTest {
    @InjectMocks
    private Weather weather;

    @Mock
    private WeatherService weatherService;

    @Test
    public void getAllCity(){
        List<City> list = new ArrayList<>();
        City city = new City();
        city.setCity("纽约");
        list.add(city);
        when(weatherService.getAllCity()).thenReturn(list);
        ModelAndView mv= weather.getAllCity();
        Assert.assertNotNull(mv);
    }

    @Test
    public void getCityWeather() throws Exception{
        Map map = new HashMap();
        DateWeather wea = new DateWeather();
        wea.setDate("2021-07-29");
        map.put("weather",wea);
        when(weatherService.getCityWeather("纽约")).thenReturn(map);
        ModelAndView mv= weather.getCityWeather("纽约");
        Assert.assertNotNull(mv);
    }
}
