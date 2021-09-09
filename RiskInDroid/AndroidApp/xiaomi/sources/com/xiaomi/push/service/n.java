package com.xiaomi.push.service;

import _m_j.esl;
import _m_j.esu;
import _m_j.esv;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.push.g;
import com.xiaomi.push.service.az;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class n {

    /* renamed from: a  reason: collision with root package name */
    public final int f6569a;

    /* renamed from: a  reason: collision with other field name */
    public final String f341a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public n(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.f341a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.f6569a = i;
    }

    private static String a(Context context) {
        if (!"com.xiaomi.xmsf".equals(context)) {
            return esl.O00000oO();
        }
        if (!TextUtils.isEmpty(null)) {
            return null;
        }
        String O000000o2 = esl.O000000o("ro.miui.region");
        return TextUtils.isEmpty(O000000o2) ? esl.O000000o("ro.product.locale.region") : O000000o2;
    }

    public static boolean a() {
        try {
            return esu.O000000o(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m221a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && a();
    }

    private static boolean b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public az.b a(XMPushService xMPushService) {
        az.b bVar = new az.b(xMPushService);
        a(bVar, xMPushService, xMPushService.m124b(), "c");
        return bVar;
    }

    public az.b a(az.b bVar, Context context, f fVar, String str) {
        String str2;
        bVar.f274a = context.getPackageName();
        bVar.f277b = this.f341a;
        bVar.h = this.c;
        bVar.c = this.b;
        bVar.g = "5";
        bVar.d = "XMPUSH-PASS";
        bVar.f276a = false;
        if (b(context)) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    String[] strArr = runningAppProcessInfo.pkgList;
                    int i = 0;
                    while (strArr != null && i < strArr.length) {
                        if (!arrayList.contains(strArr[i])) {
                            arrayList.add(strArr[i]);
                            if (arrayList.size() == 1) {
                                str2 = (String) arrayList.get(0);
                            } else {
                                sb.append("#");
                                str2 = strArr[i];
                            }
                            sb.append(str2.hashCode() % 100000);
                        }
                        i++;
                    }
                }
            }
        }
        esv.O000000o o000000o = new esv.O000000o();
        o000000o.O000000o("sdk_ver", 47).O000000o("cpvn", "4_2_0").O000000o("cpvc", 40020).O000000o("country_code", a.a(context).b()).O000000o("region", a.a(context).a()).O000000o("miui_vn", esl.O0000OOo()).O000000o("miui_vc", Integer.valueOf(esl.O0000O0o())).O000000o("xmsf_vc", Integer.valueOf(g.O00000Oo(context, "com.xiaomi.xmsf"))).O000000o("android_ver", Integer.valueOf(Build.VERSION.SDK_INT));
        String a2 = a(context);
        if (!TextUtils.isEmpty(a2)) {
            o000000o.O000000o("latest_country_code", a2);
        }
        bVar.e = o000000o.toString();
        String str3 = b(context) ? "1000271" : this.d;
        esv.O000000o o000000o2 = new esv.O000000o();
        o000000o2.O000000o("appid", str3).O000000o("locale", Locale.getDefault().toString()).O000000o("miid", esu.O00000o0(context)).O000000o("sync", 1);
        if (m221a(context)) {
            o000000o2.O000000o("ab", str);
        }
        bVar.f = o000000o2.toString();
        bVar.f273a = fVar;
        return bVar;
    }
}
