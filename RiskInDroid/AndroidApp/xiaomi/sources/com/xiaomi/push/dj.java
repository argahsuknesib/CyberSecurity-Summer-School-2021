package com.xiaomi.push;

import _m_j.enx;
import _m_j.eoc;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import org.json.JSONArray;

public class dj {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f6373O000000o;
    public SharedPreferences O00000Oo;

    public final JSONArray O000000o(boolean z) {
        String string = this.O00000Oo.getString("k_e", "");
        JSONArray jSONArray = null;
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray2 = new JSONArray(string);
                if (z) {
                    try {
                        String O00000o0 = eoc.O00000o0(this.f6373O000000o);
                        for (int i = 0; i < jSONArray2.length(); i++) {
                            jSONArray2.getJSONObject(i).put(enx.O00000oO, O00000o0);
                        }
                    } catch (Throwable unused) {
                    }
                }
                jSONArray = jSONArray2;
            } catch (Throwable unused2) {
            }
        }
        return jSONArray == null ? new JSONArray() : jSONArray;
    }

    public dj(Context context) {
        this.f6373O000000o = context.getApplicationContext();
        String str = "mipush_scr_file";
        try {
            String O000000o2 = g.O000000o(context, Process.myPid());
            if (O000000o2 != null) {
                str = str + "_" + O000000o2.hashCode();
            }
        } catch (Throwable unused) {
        }
        this.O00000Oo = context.getSharedPreferences(str, 0);
    }
}
