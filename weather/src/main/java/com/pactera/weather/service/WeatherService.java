package com.pactera.weather.service;

import com.pactera.weather.domain.City;
import com.pactera.weather.domain.Hours;
import com.pactera.weather.domain.Weather;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@PropertySource(value = "classpath:application.properties")
public class WeatherService {
    @Value("${city}")
    private String city;

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

    public Hours getCityWeather(String city){
        RestTemplate template = new RestTemplate();
        String uri = "https://tianqiapi.com/api?version=v5&appid=24685659&appsecret=xJDM66T1&city="+city;
        Weather weather =  template.getForObject(uri, Weather.class);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:s.SSS z");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println(format.format(new Date()));
        String date = format.format(new Date());
//        List wea = weather.getData().stream().filter(i -> date.indexOf(i.getDate()) >0 ).collect(Collectors.toList());
////        dateWeather.get(0).getHours().stream().filter(i -> i.getHours().substring(2,4).compareTo(date.substring(10,12)) <=0).findFirst();
//         ;
        return weather.getData().get(0).getHours().get(0);
    }

}
