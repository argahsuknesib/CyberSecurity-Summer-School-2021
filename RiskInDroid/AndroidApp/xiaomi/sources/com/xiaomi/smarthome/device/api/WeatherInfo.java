package com.xiaomi.smarthome.device.api;

public class WeatherInfo {
    public Aqi aqi = new Aqi();

    public static class Aqi {
        public String aqi;
        public String city;
        public String city_id;
        public String no2;
        public String pm10;
        public String pm25;
        public String pub_time;
        public String so2;
        public String spot;
        public String src;
    }
}
