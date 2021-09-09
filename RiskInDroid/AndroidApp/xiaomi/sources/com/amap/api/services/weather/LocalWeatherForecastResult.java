package com.amap.api.services.weather;

public class LocalWeatherForecastResult {

    /* renamed from: a  reason: collision with root package name */
    private WeatherSearchQuery f3548a;
    private LocalWeatherForecast b;

    public static LocalWeatherForecastResult createPagedResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherForecast localWeatherForecast) {
        return new LocalWeatherForecastResult(weatherSearchQuery, localWeatherForecast);
    }

    private LocalWeatherForecastResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherForecast localWeatherForecast) {
        this.f3548a = weatherSearchQuery;
        this.b = localWeatherForecast;
    }

    public WeatherSearchQuery getWeatherForecastQuery() {
        return this.f3548a;
    }

    public LocalWeatherForecast getForecastResult() {
        return this.b;
    }
}
