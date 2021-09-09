package com.tencent.wxop.stat.common;

import _m_j.dkg;
import _m_j.dlm;
import _m_j.dlo;
import _m_j.dlv;
import _m_j.dmb;
import android.content.Context;
import org.json.JSONObject;

public class b {

    /* renamed from: O000000o  reason: collision with root package name */
    static dlo f5888O000000o;
    private static dlm O00000o = dlv.O00000o0();
    private static JSONObject O00000oO = new JSONObject();
    Integer O00000Oo = null;
    String O00000o0 = null;

    private static synchronized dlo O000000o(Context context) {
        dlo dlo;
        synchronized (b.class) {
            if (f5888O000000o == null) {
                f5888O000000o = new dlo(context.getApplicationContext(), (byte) 0);
            }
            dlo = f5888O000000o;
        }
        return dlo;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    public final void O000000o(JSONObject jSONObject, Thread thread) {
        String str;
        Object obj;
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (f5888O000000o != null) {
                f5888O000000o.O000000o(jSONObject2, thread);
            }
            dmb.O000000o(jSONObject2, "cn", this.O00000o0);
            if (this.O00000Oo != null) {
                jSONObject2.put("tn", this.O00000Oo);
            }
            if (thread == null) {
                str = "ev";
                obj = jSONObject2;
            } else {
                str = "errkv";
                obj = jSONObject2.toString();
            }
            jSONObject.put(str, obj);
            if (O00000oO != null && O00000oO.length() > 0) {
                jSONObject.put("eva", O00000oO);
            }
        } catch (Throwable th) {
            O00000o.O00000Oo(th);
        }
    }

    public b(Context context) {
        try {
            O000000o(context);
            this.O00000Oo = dlv.O0000Ooo(context.getApplicationContext());
            this.O00000o0 = dkg.O000000o(context).O00000o0;
        } catch (Throwable th) {
            O00000o.O00000Oo(th);
        }
    }
}
