package com.pactera.weather.domain;

import lombok.Data;
import java.util.List;

@Data
public class DateWeather {
         private String date;
         private String date_true;
         private String wea;
         private String wea_img;
         private String tem1;
         private String tem2;
         private String[] win;
         private String win_speed;
         private List<HoursWeather> hours;
}
