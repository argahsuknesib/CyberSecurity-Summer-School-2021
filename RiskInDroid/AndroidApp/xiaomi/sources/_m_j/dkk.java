package _m_j;

import android.content.Context;
import com.tencent.wxop.stat.a.f;
import org.json.JSONObject;

public abstract class dkk {
    protected static String O0000Oo;
    protected String O00000Oo = null;
    protected int O00000o;
    protected long O00000o0;
    protected dln O00000oO = null;
    protected int O00000oo;
    protected String O0000O0o = null;
    protected String O0000OOo = null;
    protected String O0000Oo0 = null;
    protected boolean O0000OoO = false;
    protected Context O0000Ooo;
    public dkf O0000o00 = null;

    public abstract boolean O000000o(JSONObject jSONObject);

    public abstract f O00000Oo();

    public final Context O00000o() {
        return this.O0000Ooo;
    }

    public final long O00000o0() {
        return this.O00000o0;
    }

    public final boolean O00000oO() {
        return this.O0000OoO;
    }

    public final String O00000oo() {
        try {
            JSONObject jSONObject = new JSONObject();
            O00000Oo(jSONObject);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    protected dkk(Context context, int i, dkf dkf) {
        this.O0000Ooo = context;
        this.O00000o0 = System.currentTimeMillis() / 1000;
        this.O00000o = i;
        this.O0000OOo = dkd.O00000Oo(context);
        this.O0000Oo0 = dlv.O0000Oo(context);
        this.O00000Oo = dkd.O000000o(context);
        if (dkf != null) {
            this.O0000o00 = dkf;
            if (dlv.O00000o0(dkf.f14739O000000o)) {
                this.O00000Oo = dkf.f14739O000000o;
            }
            if (dlv.O00000o0(dkf.O00000Oo)) {
                this.O0000OOo = dkf.O00000Oo;
            }
            if (dlv.O00000o0(dkf.O00000o0)) {
                this.O0000Oo0 = dkf.O00000o0;
            }
            this.O0000OoO = dkf.O00000oO;
        }
        this.O0000O0o = dkd.O00000o(context);
        this.O00000oO = dkz.O000000o(context).O00000Oo(context);
        this.O00000oo = O00000Oo() != f.NETWORK_DETECTOR ? dlv.O0000o(context).intValue() : -f.NETWORK_DETECTOR.a();
        if (!dgi.O00000Oo(O0000Oo)) {
            String O00000oO2 = dkd.O00000oO(context);
            O0000Oo = O00000oO2;
            if (!dlv.O00000o0(O00000oO2)) {
                O0000Oo = "0";
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dlv.O000000o(android.content.Context, boolean):int
     arg types: [android.content.Context, int]
     candidates:
      _m_j.dlv.O000000o(android.content.Context, java.lang.String):java.lang.String
      _m_j.dlv.O000000o(android.content.Context, int):void
      _m_j.dlv.O000000o(android.content.Context, boolean):int */
    private boolean O00000Oo(JSONObject jSONObject) {
        try {
            dmb.O000000o(jSONObject, "ky", this.O00000Oo);
            jSONObject.put("et", O00000Oo().a());
            if (this.O00000oO != null) {
                jSONObject.put("ui", this.O00000oO.f14771O000000o);
                dmb.O000000o(jSONObject, "mc", this.O00000oO.O00000Oo);
                int i = this.O00000oO.O00000o0;
                jSONObject.put("ut", i);
                if (i == 0 && dlv.O0000oOO(this.O0000Ooo) == 1) {
                    jSONObject.put("ia", 1);
                }
            }
            dmb.O000000o(jSONObject, "cui", this.O0000O0o);
            if (O00000Oo() != f.SESSION_ENV) {
                dmb.O000000o(jSONObject, "av", this.O0000Oo0);
                dmb.O000000o(jSONObject, "ch", this.O0000OOo);
            }
            if (this.O0000OoO) {
                jSONObject.put("impt", 1);
            }
            dmb.O000000o(jSONObject, "mid", O0000Oo);
            jSONObject.put("idx", this.O00000oo);
            jSONObject.put("si", this.O00000o);
            jSONObject.put("ts", this.O00000o0);
            jSONObject.put("dts", dlv.O000000o(this.O0000Ooo, false));
            return O000000o(jSONObject);
        } catch (Throwable unused) {
            return false;
        }
    }
}
