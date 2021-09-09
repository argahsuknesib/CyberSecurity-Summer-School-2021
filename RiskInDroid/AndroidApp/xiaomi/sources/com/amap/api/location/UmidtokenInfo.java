package com.amap.api.location;

import _m_j.bvz;
import _m_j.bww;
import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer2.source.dash.DashMediaSource;

public class UmidtokenInfo {

    /* renamed from: a  reason: collision with root package name */
    static Handler f3266a = new Handler();
    static String b = null;
    static boolean c = true;
    /* access modifiers changed from: private */
    public static AMapLocationClient d;
    private static long e = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;

    static class a implements AMapLocationListener {
        a() {
        }

        public final void onLocationChanged(AMapLocation aMapLocation) {
            try {
                if (UmidtokenInfo.d != null) {
                    UmidtokenInfo.f3266a.removeCallbacksAndMessages(null);
                    UmidtokenInfo.d.onDestroy();
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "UmidListener", "onLocationChanged");
            }
        }
    }

    public static String getUmidtoken() {
        return b;
    }

    public static void setLocAble(boolean z) {
        c = z;
    }

    public static synchronized void setUmidtoken(Context context, String str) {
        synchronized (UmidtokenInfo.class) {
            try {
                b = str;
                bww.O000000o(str);
                if (d == null && c) {
                    a aVar = new a();
                    d = new AMapLocationClient(context);
                    AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
                    aMapLocationClientOption.setOnceLocation(true);
                    aMapLocationClientOption.setNeedAddress(false);
                    d.setLocationOption(aMapLocationClientOption);
                    d.setLocationListener(aVar);
                    d.startLocation();
                    f3266a.postDelayed(new Runnable() {
                        /* class com.amap.api.location.UmidtokenInfo.AnonymousClass1 */

                        public final void run() {
                            try {
                                if (UmidtokenInfo.d != null) {
                                    UmidtokenInfo.d.onDestroy();
                                }
                            } catch (Throwable th) {
                                bvz.O000000o(th, "UmidListener", "postDelayed");
                            }
                        }
                    }, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "UmidListener", "setUmidtoken");
            }
        }
    }
}
