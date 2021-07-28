package com.pactera.weather.domain;

import lombok.Data;

import java.util.List;

@Data
public class Weather {
    private String cityid;
    private String city;
    private String cityEn;
    private String country;
    private String countryEn;
    private String  update_time;
    private List<Date> data;
}
