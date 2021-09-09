package com.xiaomi.mipush.sdk;

import _m_j.duv;
import _m_j.erv;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class b {
    private static volatile b O00000oO;

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f6053O000000o;
    public a O00000Oo = new a(this.f6053O000000o);
    public String O00000o;
    public Map<String, a> O00000o0 = new HashMap();

    public static class a {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f6054O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;
        public String O00000oO;
        public String O00000oo;
        public String O0000O0o;
        public String O0000OOo;
        public boolean O0000Oo = false;
        public boolean O0000Oo0 = true;
        public int O0000OoO = 1;
        public Context O0000Ooo;

        public a(Context context) {
            this.O0000Ooo = context;
        }

        public static String O000000o(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f6054O000000o);
                jSONObject.put("appToken", aVar.O00000Oo);
                jSONObject.put("regId", aVar.O00000o0);
                jSONObject.put("regSec", aVar.O00000o);
                jSONObject.put("devId", aVar.O00000oo);
                jSONObject.put("vName", aVar.O00000oO);
                jSONObject.put("valid", aVar.O0000Oo0);
                jSONObject.put("paused", aVar.O0000Oo);
                jSONObject.put("envType", aVar.O0000OoO);
                jSONObject.put("regResource", aVar.O0000O0o);
                return jSONObject.toString();
            } catch (Throwable th) {
                duv.O000000o(th);
                return null;
            }
        }

        public final void O000000o(String str, String str2, String str3) {
            this.f6054O000000o = str;
            this.O00000Oo = str2;
            this.O0000O0o = str3;
            SharedPreferences.Editor edit = b.O00000Oo(this.O0000Ooo).edit();
            edit.putString("appId", this.f6054O000000o);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public final boolean O000000o() {
            return O000000o(this.f6054O000000o, this.O00000Oo);
        }

        public final boolean O000000o(String str, String str2) {
            boolean equals = TextUtils.equals(this.f6054O000000o, str);
            boolean equals2 = TextUtils.equals(this.O00000Oo, str2);
            boolean z = !TextUtils.isEmpty(this.O00000o0);
            boolean z2 = !TextUtils.isEmpty(this.O00000o);
            boolean z3 = TextUtils.equals(this.O00000oo, erv.O0000Oo0(this.O0000Ooo)) || TextUtils.equals(this.O00000oo, erv.O0000OOo(this.O0000Ooo));
            boolean z4 = equals && equals2 && z && z2 && z3;
            if (!z4) {
                duv.O00000oo(String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s;did=%s", Boolean.valueOf(equals), Boolean.valueOf(equals2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)));
            }
            return z4;
        }

        public final String O00000Oo() {
            Context context = this.O0000Ooo;
            return g.O000000o(context, context.getPackageName());
        }

        public final void O00000o0() {
            b.O00000Oo(this.O0000Ooo).edit().clear().commit();
            this.f6054O000000o = null;
            this.O00000Oo = null;
            this.O00000o0 = null;
            this.O00000o = null;
            this.O00000oo = null;
            this.O00000oO = null;
            this.O0000Oo0 = false;
            this.O0000Oo = false;
            this.O0000OOo = null;
            this.O0000OoO = 1;
        }
    }

    public static b O000000o(Context context) {
        if (O00000oO == null) {
            synchronized (b.class) {
                if (O00000oO == null) {
                    O00000oO = new b(context);
                }
            }
        }
        return O00000oO;
    }

    public static SharedPreferences O00000Oo(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    public final void O000000o(String str, String str2, String str3) {
        this.O00000Oo.O000000o(str, str2, str3);
    }

    public final boolean O000000o() {
        if (this.O00000Oo.O000000o()) {
            return true;
        }
        duv.O000000o("Don't send message before initialization succeeded!");
        return false;
    }

    public final boolean O00000Oo() {
        return !this.O00000Oo.O0000Oo0;
    }

    private b(Context context) {
        this.f6053O000000o = context;
        SharedPreferences sharedPreferences = this.f6053O000000o.getSharedPreferences("mipush", 0);
        this.O00000Oo.f6054O000000o = sharedPreferences.getString("appId", null);
        this.O00000Oo.O00000Oo = sharedPreferences.getString("appToken", null);
        this.O00000Oo.O00000o0 = sharedPreferences.getString("regId", null);
        this.O00000Oo.O00000o = sharedPreferences.getString("regSec", null);
        this.O00000Oo.O00000oo = sharedPreferences.getString("devId", null);
        if (!TextUtils.isEmpty(this.O00000Oo.O00000oo) && erv.O000000o(this.O00000Oo.O00000oo)) {
            this.O00000Oo.O00000oo = erv.O0000Oo0(this.f6053O000000o);
            sharedPreferences.edit().putString("devId", this.O00000Oo.O00000oo).commit();
        }
        this.O00000Oo.O00000oO = sharedPreferences.getString("vName", null);
        this.O00000Oo.O0000Oo0 = sharedPreferences.getBoolean("valid", true);
        this.O00000Oo.O0000Oo = sharedPreferences.getBoolean("paused", false);
        this.O00000Oo.O0000OoO = sharedPreferences.getInt("envType", 1);
        this.O00000Oo.O0000O0o = sharedPreferences.getString("regResource", null);
        this.O00000Oo.O0000OOo = sharedPreferences.getString("appRegion", null);
    }

    public final void O000000o(boolean z) {
        this.O00000Oo.O0000Oo = z;
        this.f6053O000000o.getSharedPreferences("mipush", 0).edit().putBoolean("paused", z).commit();
    }

    public final void O000000o(int i) {
        this.O00000Oo.O0000OoO = i;
        this.f6053O000000o.getSharedPreferences("mipush", 0).edit().putInt("envType", i).commit();
    }
}
