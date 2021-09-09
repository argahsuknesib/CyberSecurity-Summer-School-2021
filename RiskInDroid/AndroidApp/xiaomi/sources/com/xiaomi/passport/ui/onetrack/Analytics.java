package com.xiaomi.passport.ui.onetrack;

import _m_j.ejh;
import _m_j.ekg;
import android.content.Context;
import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.OneTrack;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Analytics {

    /* renamed from: O000000o  reason: collision with root package name */
    private static OneTrack f6268O000000o;

    public static void O000000o(Context context) {
        Context applicationContext = context.getApplicationContext();
        f6268O000000o = OneTrack.createInstance(applicationContext, new Configuration.Builder().setAppId("30000000031").setChannel("xiaomi").setMode(OneTrack.Mode.SDK).build());
        HashMap hashMap = new HashMap();
        hashMap.put("os_platform", ejh.O000000o("ro.miui.ui.version.name", "others"));
        hashMap.put("package_name", applicationContext.getPackageName());
        hashMap.put("locale", Locale.getDefault().getCountry());
        f6268O000000o.setCommonProperty(hashMap);
        if (ekg.O000000o(applicationContext)) {
            OneTrack.setDebugMode(true);
        }
    }

    private static void O000000o(String str, Map<String, Object> map) {
        f6268O000000o.track(str, map);
    }

    public static void O000000o(String str, String str2) {
        HashMap hashMap = new HashMap();
        O000000o("view_" + str + str2, hashMap);
    }

    public static void O000000o(String str) {
        O000000o("view_".concat(String.valueOf(str)), new HashMap());
    }

    public static void O00000Oo(String str) {
        O000000o("click_".concat(String.valueOf(str)), new HashMap());
    }

    public static void O00000o0(String str) {
        O000000o(str, new HashMap());
    }
}
