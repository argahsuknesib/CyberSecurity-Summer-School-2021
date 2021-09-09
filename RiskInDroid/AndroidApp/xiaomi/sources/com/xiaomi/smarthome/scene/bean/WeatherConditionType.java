package com.xiaomi.smarthome.scene.bean;

import com.xiaomi.smarthome.R;

public enum WeatherConditionType {
    TYPE_SUNRISE(1, LAUNCH_TYPE.SUN_RISE, 101, R.string.sunrise, "cloud.weather.sunrise"),
    TYPE_SUNSET(2, LAUNCH_TYPE.SUN_SET, 101, R.string.sunset, "cloud.weather.sunset"),
    TYPE_LESS_HUMIDITY(3, LAUNCH_TYPE.HUMIDITY, 113, R.string.humidity_less, "cloud.weather.humidity"),
    TYPE_ABOVE_HUMIDITY(4, LAUNCH_TYPE.HUMIDITY, 112, R.string.humidity_above, "cloud.weather.humidity"),
    TYPE_LESS_TEMPERATURE(5, LAUNCH_TYPE.TEMPERATURE, 111, R.string.temperature_less, "cloud.weather.temperature"),
    TYPE_ABOVE_TEMPERATURE(6, LAUNCH_TYPE.TEMPERATURE, 110, R.string.temperature_above, "cloud.weather.temperature"),
    TYPE_LESS_AQI(7, LAUNCH_TYPE.AQI, 106, R.string.aqi_less, "cloud.weather.aqi"),
    TYPE_ABOVE_AQI(8, LAUNCH_TYPE.AQI, 105, R.string.aqi_above, "cloud.weather.aqi");
    
    public int compatibleId;
    public final int conditionId;
    public int conditionNameId;
    public String key;
    public LAUNCH_TYPE launchType;

    private WeatherConditionType(int i, LAUNCH_TYPE launch_type, int i2, int i3, String str) {
        this.conditionId = i;
        this.launchType = launch_type;
        this.compatibleId = i2;
        this.conditionNameId = i3;
        this.key = str;
    }
}
