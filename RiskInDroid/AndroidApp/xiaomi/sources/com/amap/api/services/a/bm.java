package com.amap.api.services.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.a.ac;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IWeatherSearch;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;

public class bm implements IWeatherSearch {

    /* renamed from: a  reason: collision with root package name */
    private Context f3336a;
    /* access modifiers changed from: private */
    public WeatherSearchQuery b;
    /* access modifiers changed from: private */
    public WeatherSearch.OnWeatherSearchListener c;
    /* access modifiers changed from: private */
    public LocalWeatherLiveResult d;
    /* access modifiers changed from: private */
    public LocalWeatherForecastResult e;
    /* access modifiers changed from: private */
    public Handler f = null;

    public bm(Context context) {
        this.f3336a = context.getApplicationContext();
        this.f = ac.a();
    }

    public WeatherSearchQuery getQuery() {
        return this.b;
    }

    public void setQuery(WeatherSearchQuery weatherSearchQuery) {
        this.b = weatherSearchQuery;
    }

    public void searchWeatherAsyn() {
        try {
            as.a().a(new Runnable() {
                /* class com.amap.api.services.a.bm.AnonymousClass1 */

                public void run() {
                    Message obtainMessage = ac.a().obtainMessage();
                    obtainMessage.arg1 = 13;
                    Bundle bundle = new Bundle();
                    if (bm.this.b == null) {
                        try {
                            throw new AMapException("无效的参数 - IllegalArgumentException");
                        } catch (AMapException e) {
                            s.a(e, "WeatherSearch", "searchWeatherAsyn");
                        }
                    } else if (bm.this.b.getType() == 1) {
                        try {
                            LocalWeatherLiveResult unused = bm.this.d = bm.this.a();
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e2) {
                            bundle.putInt("errorCode", e2.getErrorCode());
                            s.a(e2, "WeatherSearch", "searchWeatherAsyn");
                        } catch (Throwable th) {
                            s.a(th, "WeatherSearch", "searchWeatherAnsyThrowable");
                        } finally {
                            ac.l lVar = new ac.l();
                            obtainMessage.what = 1301;
                            lVar.b = bm.this.c;
                            lVar.f3284a = bm.this.d;
                            obtainMessage.obj = lVar;
                            obtainMessage.setData(bundle);
                            bm.this.f.sendMessage(obtainMessage);
                        }
                    } else if (bm.this.b.getType() == 2) {
                        try {
                            LocalWeatherForecastResult unused2 = bm.this.e = bm.this.b();
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e3) {
                            bundle.putInt("errorCode", e3.getErrorCode());
                            s.a(e3, "WeatherSearch", "searchWeatherAsyn");
                        } catch (Throwable th2) {
                            s.a(th2, "WeatherSearch", "searchWeatherAnsyThrowable");
                        } finally {
                            ac.k kVar = new ac.k();
                            obtainMessage.what = 1302;
                            kVar.b = bm.this.c;
                            kVar.f3283a = bm.this.e;
                            obtainMessage.obj = kVar;
                            obtainMessage.setData(bundle);
                            bm.this.f.sendMessage(obtainMessage);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public LocalWeatherLiveResult a() throws AMapException {
        aa.a(this.f3336a);
        WeatherSearchQuery weatherSearchQuery = this.b;
        if (weatherSearchQuery != null) {
            aw awVar = new aw(this.f3336a, weatherSearchQuery);
            return LocalWeatherLiveResult.createPagedResult((WeatherSearchQuery) awVar.j(), (LocalWeatherLive) awVar.c());
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    /* access modifiers changed from: private */
    public LocalWeatherForecastResult b() throws AMapException {
        aa.a(this.f3336a);
        WeatherSearchQuery weatherSearchQuery = this.b;
        if (weatherSearchQuery != null) {
            av avVar = new av(this.f3336a, weatherSearchQuery);
            return LocalWeatherForecastResult.createPagedResult((WeatherSearchQuery) avVar.j(), (LocalWeatherForecast) avVar.c());
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    public void setOnWeatherSearchListener(WeatherSearch.OnWeatherSearchListener onWeatherSearchListener) {
        this.c = onWeatherSearchListener;
    }
}
