package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.xiaoai;

import _m_j.ft;
import _m_j.fyc;
import _m_j.gbq;
import _m_j.gbv;
import _m_j.gdu;
import _m_j.gdv;
import _m_j.gvu;
import _m_j.gvv;
import _m_j.gwa;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBaseJavaModule;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class MIOTWifiSpeakerModule extends MIOTBaseJavaModule {
    public String getName() {
        return "MIOTWifiSpeaker";
    }

    public MIOTWifiSpeakerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @SuppressLint({"CheckResult"})
    @ReactMethod
    public void callXiaoaiNetworkAPI(String str, String str2, int i, ReadableMap readableMap, int i2, final Callback callback) {
        HttpUrl.Builder builder;
        HttpUrl.Builder builder2;
        String url = XiaoaiServer.fromHost(str).getUrl();
        if (TextUtils.isEmpty(url)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "invalid host"));
            return;
        }
        if (readableMap == null) {
            readableMap = Arguments.createMap();
        }
        String str3 = i2 == 1 ? getDevice().did : "";
        Map<String, Object> O000000o2 = gbv.O000000o(readableMap);
        ReadableMap O00000o = gbv.O00000o(readableMap, "cookie");
        Observable<Response> observable = null;
        HashMap<String, Object> hashMap = O00000o != null ? O00000o.toHashMap() : null;
        XiaoaiApiManager.O000000o(O000000o2);
        if (i == 0) {
            observable = XiaoaiApiManager.O000000o().O000000o(url, str2, O000000o2, str3, hashMap);
        } else if (i == 1) {
            XiaoaiApiManager O000000o3 = XiaoaiApiManager.O000000o();
            if (!TextUtils.isEmpty(str2)) {
                builder = HttpUrl.parse(url).resolve(str2).newBuilder();
            } else {
                builder = HttpUrl.parse(url).newBuilder();
            }
            HttpUrl build = builder.build();
            Request.Builder builder3 = new Request.Builder();
            builder3.url(build);
            if (!O000000o2.isEmpty()) {
                builder3.post(XiaoaiApiManager.O00000Oo(O000000o2));
            }
            observable = O000000o3.O000000o(builder3.build(), str3, hashMap);
        } else if (i != 2) {
            fyc.O00000o0("MIOTWifiSpeakerModule", " method = " + i + " is not support");
        } else {
            XiaoaiApiManager O000000o4 = XiaoaiApiManager.O000000o();
            if (!TextUtils.isEmpty(str2)) {
                builder2 = HttpUrl.parse(url).resolve(str2).newBuilder();
            } else {
                builder2 = HttpUrl.parse(url).newBuilder();
            }
            HttpUrl build2 = builder2.build();
            Request.Builder builder4 = new Request.Builder();
            builder4.url(build2);
            if (!O000000o2.isEmpty()) {
                builder4.put(XiaoaiApiManager.O00000Oo(O000000o2));
            }
            observable = O000000o4.O000000o(builder4.build(), str3, hashMap);
        }
        if (observable == null) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "internal error"));
        } else {
            observable.subscribeOn(Schedulers.io()).subscribe(new Consumer<Response>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.xiaoai.MIOTWifiSpeakerModule.AnonymousClass1 */

                public final /* synthetic */ void accept(Object obj) throws Exception {
                    Response response = (Response) obj;
                    if (response.isSuccessful()) {
                        callback.invoke(Boolean.TRUE, response.body().string());
                        return;
                    }
                    callback.invoke(Boolean.FALSE, response.body().string());
                }
            }, new Consumer<Throwable>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.xiaoai.MIOTWifiSpeakerModule.AnonymousClass2 */

                public final /* synthetic */ void accept(Object obj) throws Exception {
                    callback.invoke(Boolean.FALSE, gbq.O000000o(-2, ((Throwable) obj).getMessage()));
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gdu.O000000o(android.content.Context, java.lang.String):void
     arg types: [android.app.Activity, java.lang.String]
     candidates:
      _m_j.gdu.O000000o(android.app.Activity, java.lang.String):void
      _m_j.gdu.O000000o(java.lang.String, java.lang.String):void
      _m_j.gdu.O000000o(android.content.Context, java.lang.String):void */
    @ReactMethod
    public void openXiaoaiContentPage() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            fyc.O00000o0("MIOTWifiSpeakerModule", "openXiaoaiContentPage,activity is null");
            return;
        }
        ((gdu) gdv.f17570O000000o.getUiInterface()).O000000o((Context) currentActivity, getDevice().did);
    }

    @ReactMethod
    public void openClockMusicSelector(ReadableMap readableMap, final Callback callback) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            fyc.O00000o0("MIOTWifiSpeakerModule", "openClockMusicSelector,activity is null");
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "internal error,activity is null"));
            return;
        }
        String O000000o2 = gbv.O000000o(readableMap, "ringtone_id");
        String O000000o3 = gbv.O000000o(readableMap, "ringtone_query");
        String O000000o4 = gbv.O000000o(readableMap, "ringtone_tab");
        String O000000o5 = gbv.O000000o(readableMap, "ringtone_name");
        String O000000o6 = gbv.O000000o(readableMap, "language");
        ft.O000000o(currentActivity).O000000o(new BroadcastReceiver() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.xiaoai.MIOTWifiSpeakerModule.AnonymousClass3 */

            public final void onReceive(Context context, Intent intent) {
                ft.O000000o(currentActivity).O000000o(this);
                gvv parseAlarmRingResult = gwa.O000000o().parseAlarmRingResult(intent);
                WritableMap createMap = Arguments.createMap();
                if (parseAlarmRingResult != null) {
                    createMap.putString("ringtone_id", parseAlarmRingResult.O00000Oo);
                    createMap.putString("ringtone_query", parseAlarmRingResult.O00000o);
                    createMap.putString("ringtone_tab", parseAlarmRingResult.f18398O000000o);
                    createMap.putString("ringtone_name", parseAlarmRingResult.O00000o0);
                }
                callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
            }
        }, new IntentFilter("miotwifispeaker.pick_alarm_ring"));
        currentActivity.startActivityForResult(gwa.O000000o().getAlarmRingIntent(currentActivity, O000000o2, O000000o3, O000000o4, O000000o5, O000000o6), 301);
    }

    @ReactMethod
    public void openEarthquakeLocationSelector(ReadableMap readableMap, final Callback callback) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            fyc.O00000o0("MIOTWifiSpeakerModule", "openEarthquakeLocationSelector,activity is null");
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "internal error,activity is null"));
            return;
        }
        String O000000o2 = gbv.O000000o(readableMap, "name");
        double O00000oo = gbv.O00000oo(readableMap, "latitude");
        double O00000oo2 = gbv.O00000oo(readableMap, "longitude");
        String O000000o3 = gbv.O000000o(readableMap, "city");
        String O000000o4 = gbv.O000000o(readableMap, "district");
        ft.O000000o(currentActivity).O000000o(new BroadcastReceiver() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.xiaoai.MIOTWifiSpeakerModule.AnonymousClass4 */

            public final void onReceive(Context context, Intent intent) {
                ft.O000000o(currentActivity).O000000o(this);
                gvu parseAddressSelectionResult = gwa.O000000o().parseAddressSelectionResult(intent);
                if (parseAddressSelectionResult == null) {
                    callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "no selected address"));
                    return;
                }
                WritableMap createMap = Arguments.createMap();
                createMap.putString("name", parseAddressSelectionResult.f18397O000000o);
                createMap.putDouble("latitude", parseAddressSelectionResult.O00000Oo);
                createMap.putDouble("longitude", parseAddressSelectionResult.O00000o0);
                createMap.putString("city", parseAddressSelectionResult.O00000o);
                createMap.putString("district", parseAddressSelectionResult.O00000oO);
                callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
            }
        }, new IntentFilter("miotwifispeaker.address_select"));
        currentActivity.startActivityForResult(gwa.O000000o().getAddressSelectionIntent(currentActivity, O000000o2, O00000oo, O00000oo2, O000000o3, O000000o4, currentActivity.getString(R.string.earthquakelocation_selector_title)), 401);
    }

    @ReactMethod
    public void openStereoSettingPage() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.startActivity(new Intent(currentActivity, ((gdu) gdv.f17570O000000o.getUiInterface()).O0000oO()));
        }
    }
}
