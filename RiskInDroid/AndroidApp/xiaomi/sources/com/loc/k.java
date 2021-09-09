package com.loc;

import _m_j.brq;
import _m_j.brs;
import _m_j.bsw;
import _m_j.bvt;
import _m_j.bvz;
import _m_j.bwi;
import _m_j.bwt;
import _m_j.bwv;
import _m_j.bwy;
import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class k {

    /* renamed from: O000000o  reason: collision with root package name */
    bsw f4539O000000o = null;

    public static String O000000o(Context context, String str, String str2) {
        Map<String, String> O00000Oo = O00000Oo(context, str2, null, null, null, null, null, null);
        O00000Oo.put("extensions", "all");
        return O000000o(context, str, O00000Oo);
    }

    public static String O000000o(Context context, String str, String str2, String str3, String str4, String str5) {
        Map<String, String> O00000Oo = O00000Oo(context, str2, str3, str4, str5, null, null, null);
        O00000Oo.put("children", "1");
        O00000Oo.put("page", "1");
        O00000Oo.put("extensions", "base");
        return O000000o(context, str, O00000Oo);
    }

    public static String O000000o(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Map<String, String> O00000Oo = O00000Oo(context, str2, str3, null, str4, str5, str6, str7);
        O00000Oo.put("children", "1");
        O00000Oo.put("page", "1");
        O00000Oo.put("extensions", "base");
        return O000000o(context, str, O00000Oo);
    }

    private static Map<String, String> O00000Oo(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap hashMap = new HashMap(16);
        hashMap.put("key", bwt.O00000oo(context));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("keywords", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("types", str2);
        }
        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
            hashMap.put("location", str6 + "," + str5);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("city", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("offset", str4);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put("radius", str7);
        }
        return hashMap;
    }

    public k(Context context) {
        try {
            bwy.O000000o.f13370O000000o.O000000o(context);
        } catch (Throwable unused) {
        }
        this.f4539O000000o = bsw.O000000o();
    }

    private static String O000000o(Context context, String str, Map<String, String> map) {
        byte[] bArr;
        try {
            HashMap hashMap = new HashMap(16);
            bvt bvt = new bvt();
            hashMap.clear();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", "AMAP_Location_SDK_Android 4.7.1");
            String O000000o2 = bwv.O000000o();
            String O000000o3 = bwv.O000000o(context, O000000o2, brs.O00000Oo(map));
            map.put("ts", O000000o2);
            map.put("scode", O000000o3);
            bvt.O00000Oo = map;
            bvt.f13321O000000o = hashMap;
            bvt.O00000oo = str;
            bvt.O00000oO = brq.O000000o(context);
            bvt.O00000o0 = bvz.O00000oo;
            bvt.O00000o = bvz.O00000oo;
            if (bwi.O0000OoO(context)) {
                bvt.O00000oo = str.replace("http:", "https:");
                bArr = bsw.O000000o(bvt);
            } else {
                bArr = bsw.O00000Oo(bvt);
            }
            return new String(bArr, "utf-8");
        } catch (Throwable unused) {
        }
        return null;
    }
}
