package _m_j;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import org.json.JSONObject;

public final class bws {

    /* renamed from: O000000o  reason: collision with root package name */
    Object f13351O000000o = new Object();
    Context O00000Oo;
    WebView O00000o = null;
    AMapLocationClient O00000o0 = null;
    String O00000oO = "AMap.Geolocation.cbk";
    AMapLocationClientOption O00000oo = null;
    volatile boolean O0000O0o = false;
    O000000o O0000OOo = null;

    public bws(Context context, WebView webView) {
        this.O00000Oo = context.getApplicationContext();
        this.O00000o = webView;
        this.O0000OOo = new O000000o();
    }

    static String O000000o(AMapLocation aMapLocation) {
        String locationDetail;
        JSONObject jSONObject = new JSONObject();
        String str = "errorInfo";
        if (aMapLocation == null) {
            try {
                jSONObject.put("errorCode", -1);
                locationDetail = "unknownError";
            } catch (Throwable unused) {
            }
        } else if (aMapLocation.getErrorCode() == 0) {
            jSONObject.put("errorCode", 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("x", aMapLocation.getLongitude());
            jSONObject2.put("y", aMapLocation.getLatitude());
            jSONObject2.put("precision", (double) aMapLocation.getAccuracy());
            jSONObject2.put("type", aMapLocation.getLocationType());
            jSONObject2.put("country", aMapLocation.getCountry());
            jSONObject2.put("province", aMapLocation.getProvince());
            jSONObject2.put("city", aMapLocation.getCity());
            jSONObject2.put("cityCode", aMapLocation.getCityCode());
            jSONObject2.put("district", aMapLocation.getDistrict());
            jSONObject2.put("adCode", aMapLocation.getAdCode());
            jSONObject2.put("street", aMapLocation.getStreet());
            jSONObject2.put("streetNum", aMapLocation.getStreetNum());
            jSONObject2.put("floor", aMapLocation.getFloor());
            jSONObject2.put("address", aMapLocation.getAddress());
            jSONObject.put("result", jSONObject2);
            return jSONObject.toString();
        } else {
            jSONObject.put("errorCode", aMapLocation.getErrorCode());
            jSONObject.put(str, aMapLocation.getErrorInfo());
            str = "locationDetail";
            locationDetail = aMapLocation.getLocationDetail();
        }
        jSONObject.put(str, locationDetail);
        return jSONObject.toString();
    }

    public final void O000000o() {
        synchronized (this.f13351O000000o) {
            this.O0000O0o = false;
            if (this.O00000o0 != null) {
                this.O00000o0.unRegisterLocationListener(this.O0000OOo);
                this.O00000o0.stopLocation();
                this.O00000o0.onDestroy();
                this.O00000o0 = null;
            }
            this.O00000oo = null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(15:7|(1:9)|10|(12:11|12|(1:14)(1:15)|16|17|18|(1:20)(1:21)|22|23|24|(1:27)|26)|32|33|(1:35)(1:37)|36|38|(1:40)(1:41)|42|(1:44)|45|46|(1:48)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0055 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x007c */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005c A[Catch:{ Throwable -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0064 A[Catch:{ Throwable -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006d A[Catch:{ Throwable -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x006e A[Catch:{ Throwable -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0074 A[Catch:{ Throwable -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0080  */
    @JavascriptInterface
    public final void getLocation(String str) {
        boolean z;
        boolean z2;
        AMapLocationClientOption aMapLocationClientOption;
        AMapLocationClientOption.AMapLocationMode aMapLocationMode;
        synchronized (this.f13351O000000o) {
            if (this.O0000O0o) {
                if (this.O00000oo == null) {
                    this.O00000oo = new AMapLocationClientOption();
                }
                int i = 5;
                long j = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
                boolean z3 = true;
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    j = jSONObject.optLong("to", DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
                    z = jSONObject.optInt("useGPS", 1) == 1;
                    try {
                        z2 = jSONObject.optInt("watch", 0) == 1;
                        i = jSONObject.optInt("interval", 5);
                        String optString = jSONObject.optString("callback", null);
                        if (TextUtils.isEmpty(optString)) {
                            optString = "AMap.Geolocation.cbk";
                        }
                        this.O00000oO = optString;
                    } catch (Throwable unused) {
                        z2 = false;
                        this.O00000oo.setHttpTimeOut(j);
                        if (!z) {
                        }
                        aMapLocationClientOption.setLocationMode(aMapLocationMode);
                        AMapLocationClientOption aMapLocationClientOption2 = this.O00000oo;
                        if (!z2) {
                        }
                        aMapLocationClientOption2.setOnceLocation(z3);
                        if (z2) {
                        }
                        if (this.O00000o0 != null) {
                        }
                        return;
                    }
                } catch (Throwable unused2) {
                    z = false;
                    z2 = false;
                    this.O00000oo.setHttpTimeOut(j);
                    if (!z) {
                    }
                    aMapLocationClientOption.setLocationMode(aMapLocationMode);
                    AMapLocationClientOption aMapLocationClientOption22 = this.O00000oo;
                    if (!z2) {
                    }
                    aMapLocationClientOption22.setOnceLocation(z3);
                    if (z2) {
                    }
                    if (this.O00000o0 != null) {
                    }
                    return;
                }
                this.O00000oo.setHttpTimeOut(j);
                if (!z) {
                    aMapLocationClientOption = this.O00000oo;
                    aMapLocationMode = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
                } else {
                    aMapLocationClientOption = this.O00000oo;
                    aMapLocationMode = AMapLocationClientOption.AMapLocationMode.Battery_Saving;
                }
                aMapLocationClientOption.setLocationMode(aMapLocationMode);
                AMapLocationClientOption aMapLocationClientOption222 = this.O00000oo;
                if (!z2) {
                    z3 = false;
                }
                aMapLocationClientOption222.setOnceLocation(z3);
                if (z2) {
                    this.O00000oo.setInterval((long) (i * 1000));
                }
                if (this.O00000o0 != null) {
                    this.O00000o0.setLocationOption(this.O00000oo);
                    this.O00000o0.stopLocation();
                    this.O00000o0.startLocation();
                }
            }
        }
    }

    @JavascriptInterface
    public final void stopLocation() {
        AMapLocationClient aMapLocationClient;
        if (this.O0000O0o && (aMapLocationClient = this.O00000o0) != null) {
            aMapLocationClient.stopLocation();
        }
    }

    class O000000o implements AMapLocationListener {
        O000000o() {
        }

        public final void onLocationChanged(AMapLocation aMapLocation) {
            if (bws.this.O0000O0o) {
                bws bws = bws.this;
                String O000000o2 = bws.O000000o(aMapLocation);
                try {
                    if (bws.O00000o == null) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        WebView webView = bws.O00000o;
                        webView.evaluateJavascript("javascript:" + bws.O00000oO + "('" + O000000o2 + "')", new ValueCallback<String>() {
                            /* class _m_j.bws.AnonymousClass1 */

                            public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                            }
                        });
                        return;
                    }
                    bws.O00000o.post(new Runnable(O000000o2) {
                        /* class _m_j.bws.AnonymousClass2 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ String f13353O000000o;

                        {
                            this.f13353O000000o = r2;
                        }

                        public final void run() {
                            WebView webView = bws.this.O00000o;
                            webView.loadUrl("javascript:" + bws.this.O00000oO + "('" + this.f13353O000000o + "')");
                        }
                    });
                } catch (Throwable th) {
                    bvz.O000000o(th, "H5LocationClient", "callbackJs()");
                }
            }
        }
    }
}
