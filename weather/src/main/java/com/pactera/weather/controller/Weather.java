package com.pactera.weather.controller;

import com.pactera.weather.domain.Hours;
import com.pactera.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.net.URLDecoder;

@RestController
public class Weather {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value = "/city",method = RequestMethod.GET)
    public ModelAndView getAllCity(){
        ModelAndView mav = new ModelAndView("weather");
        mav.addObject("citylist", weatherService.getAllCity());
        return mav;
    }

    @RequestMapping(value ="/weather", method = RequestMethod.GET)
    public ModelAndView getCityWeather(@RequestParam String city) throws Exception{
        city = URLDecoder.decode(city, "UTF-8");
        ModelAndView mav = new ModelAndView("cityWeather");
        Hours hourWeather = weatherService.getCityWeather(city);
        mav.addObject("cityWeather",hourWeather);
        mav.addObject("city",city);
        return mav;
    }
}
