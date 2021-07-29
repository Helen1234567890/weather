package com.pactera.weather.service;

import com.pactera.weather.domain.City;
import com.pactera.weather.domain.DateWeather;
import com.pactera.weather.domain.Weather;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@PropertySource(value = "classpath:application.properties")
public class WeatherService {
    @Value("${city}")
    private String city;

    @Value("${weatherUri}")
    private String weatherUri;

    public List getAllCity(){
        List<City> list = new ArrayList<>();
        if(StringUtils.isNotEmpty(city)){
            String[] c = city.split(";");
            for(int i = 0 ;i <c.length; i++){
                City city = new City();
                city.setCity(c[i]);
                list.add(city);
            }
        }
        return list;
    }

    public Map getCityWeather(String city){
        Map map = new HashMap();
        RestTemplate template = new RestTemplate();
        String url = weatherUri+city;
        Weather weather =  template.getForObject(url, Weather.class);
        String[] win = weather.getData().get(0).getWin();
        String wind = "";
        for(int i = 0;i < win.length;i++){
            if(i == 0){
                wind = win[i];
            }
            else {
                wind = wind + "," +win[i];
            }
        }
        map.put("win",wind);
        map.put("dateWeather",weather.getData().get(0));
        map.put("updatetime",weather.getUpdate_time());
        return map;
    }

}
