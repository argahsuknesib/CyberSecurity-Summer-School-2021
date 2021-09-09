package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.WeatherSearchQuery;

public class av extends ax<WeatherSearchQuery, LocalWeatherForecast> {
    private LocalWeatherForecast i = new LocalWeatherForecast();

    public /* bridge */ /* synthetic */ String i() {
        return super.i();
    }

    public av(Context context, WeatherSearchQuery weatherSearchQuery) {
        super(context, weatherSearchQuery);
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String city = ((WeatherSearchQuery) this.f3422a).getCity();
        if (!z.i(city)) {
            String c = c(city);
            stringBuffer.append("&city=");
            stringBuffer.append(c);
        }
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&key=" + bp.f(this.d));
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public LocalWeatherForecast a(String str) throws AMapException {
        this.i = z.e(str);
        return this.i;
    }
}
