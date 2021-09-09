package com.amap.api.services.weather;

import android.content.Context;
import com.amap.api.services.a.bm;
import com.amap.api.services.interfaces.IWeatherSearch;

public class WeatherSearch {

    /* renamed from: a  reason: collision with root package name */
    private IWeatherSearch f3551a = null;

    public interface OnWeatherSearchListener {
        void onWeatherForecastSearched(LocalWeatherForecastResult localWeatherForecastResult, int i);

        void onWeatherLiveSearched(LocalWeatherLiveResult localWeatherLiveResult, int i);
    }

    public WeatherSearch(Context context) {
        if (this.f3551a == null) {
            try {
                this.f3551a = new bm(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public WeatherSearchQuery getQuery() {
        IWeatherSearch iWeatherSearch = this.f3551a;
        if (iWeatherSearch != null) {
            return iWeatherSearch.getQuery();
        }
        return null;
    }

    public void setQuery(WeatherSearchQuery weatherSearchQuery) {
        IWeatherSearch iWeatherSearch = this.f3551a;
        if (iWeatherSearch != null) {
            iWeatherSearch.setQuery(weatherSearchQuery);
        }
    }

    public void searchWeatherAsyn() {
        IWeatherSearch iWeatherSearch = this.f3551a;
        if (iWeatherSearch != null) {
            iWeatherSearch.searchWeatherAsyn();
        }
    }

    public void setOnWeatherSearchListener(OnWeatherSearchListener onWeatherSearchListener) {
        IWeatherSearch iWeatherSearch = this.f3551a;
        if (iWeatherSearch != null) {
            iWeatherSearch.setOnWeatherSearchListener(onWeatherSearchListener);
        }
    }
}
