package com.amap.api.services.a;

import com.amap.api.services.a.by;
import com.amap.api.services.core.ServiceSettings;

public class r {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f3423a = {"com.amap.api.services", "com.amap.api.search.admic"};

    public static String a() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restapi.amap.com/v3" : "https://restapi.amap.com/v3";
    }

    public static String b() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restapi.amap.com/v4" : "https://restapi.amap.com/v4";
    }

    public static String c() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://yuntuapi.amap.com" : "https://yuntuapi.amap.com";
    }

    public static by a(boolean z) {
        try {
            return new by.a("sea", "6.9.3", "AMAP SDK Android Search 6.9.3").a(f3423a).a(z).a("6.9.3").a();
        } catch (bo e) {
            s.a(e, "ConfigableConst", "getSDKInfo");
            return null;
        }
    }

    public static String d() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://m5.amap.com/ws/mapapi/shortaddress/transform" : "https://m5.amap.com/ws/mapapi/shortaddress/transform";
    }
}
