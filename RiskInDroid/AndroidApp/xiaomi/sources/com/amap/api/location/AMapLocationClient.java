package com.amap.api.location;

import _m_j.bvz;
import _m_j.bwq;
import _m_j.bww;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;

public class AMapLocationClient {

    /* renamed from: a  reason: collision with root package name */
    Context f3252a;
    bwq b;

    public AMapLocationClient(Context context) {
        if (context != null) {
            try {
                this.f3252a = context.getApplicationContext();
                this.b = new bwq(this.f3252a, null);
            } catch (Throwable th) {
                bvz.O000000o(th, "AMapLocationClient", "AMapLocationClient 1");
            }
        } else {
            throw new IllegalArgumentException("Context参数不能为null");
        }
    }

    public AMapLocationClient(Context context, Intent intent) {
        if (context != null) {
            try {
                this.f3252a = context.getApplicationContext();
                this.b = new bwq(this.f3252a, intent);
            } catch (Throwable th) {
                bvz.O000000o(th, "AMapLocationClient", "AMapLocationClient 2");
            }
        } else {
            throw new IllegalArgumentException("Context参数不能为null");
        }
    }

    public static String getDeviceId(Context context) {
        return bww.O0000oo0(context);
    }

    public static void setApiKey(String str) {
        try {
            AMapLocationClientOption.f3253a = str;
        } catch (Throwable th) {
            bvz.O000000o(th, "AMapLocationClient", "setApiKey");
        }
    }

    public void disableBackgroundLocation(boolean z) {
        try {
            if (this.b != null) {
                this.b.disableBackgroundLocation(z);
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "AMapLocationClient", "disableBackgroundLocation");
        }
    }

    public void enableBackgroundLocation(int i, Notification notification) {
        try {
            if (this.b != null) {
                this.b.enableBackgroundLocation(i, notification);
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "AMapLocationClient", "enableBackgroundLocation");
        }
    }

    public AMapLocation getLastKnownLocation() {
        try {
            if (this.b != null) {
                return this.b.getLastKnownLocation();
            }
            return null;
        } catch (Throwable th) {
            bvz.O000000o(th, "AMapLocationClient", "getLastKnownLocation");
            return null;
        }
    }

    public String getVersion() {
        return "4.7.1";
    }

    public boolean isStarted() {
        try {
            if (this.b != null) {
                return this.b.isStarted();
            }
            return false;
        } catch (Throwable th) {
            bvz.O000000o(th, "AMapLocationClient", "isStarted");
            return false;
        }
    }

    public void onDestroy() {
        try {
            if (this.b != null) {
                this.b.onDestroy();
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "AMapLocationClient", "onDestroy");
        }
    }

    public void setLocationListener(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener != null) {
            try {
                if (this.b != null) {
                    this.b.setLocationListener(aMapLocationListener);
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "AMapLocationClient", "setLocationListener");
            }
        } else {
            throw new IllegalArgumentException("listener参数不能为null");
        }
    }

    public void setLocationOption(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption != null) {
            try {
                if (this.b != null) {
                    this.b.setLocationOption(aMapLocationClientOption);
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "AMapLocationClient", "setLocationOption");
            }
        } else {
            throw new IllegalArgumentException("LocationManagerOption参数不能为null");
        }
    }

    public void startAssistantLocation() {
        try {
            if (this.b != null) {
                this.b.startAssistantLocation();
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "AMapLocationClient", "startAssistantLocation");
        }
    }

    public void startAssistantLocation(WebView webView) {
        try {
            if (this.b != null) {
                this.b.startAssistantLocation(webView);
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "AMapLocationClient", "startAssistantLocation1");
        }
    }

    public void startLocation() {
        try {
            if (this.b != null) {
                this.b.startLocation();
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "AMapLocationClient", "startLocation");
        }
    }

    public void stopAssistantLocation() {
        try {
            if (this.b != null) {
                this.b.stopAssistantLocation();
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "AMapLocationClient", "stopAssistantLocation");
        }
    }

    public void stopLocation() {
        try {
            if (this.b != null) {
                this.b.stopLocation();
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "AMapLocationClient", "stopLocation");
        }
    }

    public void unRegisterLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            if (this.b != null) {
                this.b.unRegisterLocationListener(aMapLocationListener);
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "AMapLocationClient", "unRegisterLocationListener");
        }
    }
}
