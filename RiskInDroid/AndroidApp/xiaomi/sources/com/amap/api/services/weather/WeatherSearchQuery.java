package com.amap.api.services.weather;

import com.amap.api.services.a.s;

public class WeatherSearchQuery implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private String f3552a;
    private int b = 1;

    public WeatherSearchQuery(String str, int i) {
        this.f3552a = str;
        this.b = i;
    }

    public WeatherSearchQuery() {
    }

    public String getCity() {
        return this.f3552a;
    }

    public int getType() {
        return this.b;
    }

    public WeatherSearchQuery clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            s.a(e, "WeatherSearchQuery", "clone");
        }
        return new WeatherSearchQuery(this.f3552a, this.b);
    }
}
