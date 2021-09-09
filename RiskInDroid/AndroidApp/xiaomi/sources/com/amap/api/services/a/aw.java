package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.WeatherSearchQuery;

public class aw extends ax<WeatherSearchQuery, LocalWeatherLive> {
    private LocalWeatherLive i = new LocalWeatherLive();

    public /* bridge */ /* synthetic */ String i() {
        return super.i();
    }

    public aw(Context context, WeatherSearchQuery weatherSearchQuery) {
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
        stringBuffer.append("&extensions=base");
        stringBuffer.append("&key=" + bp.f(this.d));
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public LocalWeatherLive a(String str) throws AMapException {
        this.i = z.d(str);
        return this.i;
    }
}
