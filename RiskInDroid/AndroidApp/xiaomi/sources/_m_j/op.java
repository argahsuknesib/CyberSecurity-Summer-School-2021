package _m_j;

import android.text.TextUtils;
import org.json.JSONObject;

public final class op {
    public static String O0000O0o;

    /* renamed from: O000000o  reason: collision with root package name */
    public double f2369O000000o = 0.0d;
    public double O00000Oo = 0.0d;
    public long O00000o = 0;
    public float O00000o0 = 0.0f;
    public String O00000oO = "new";
    public String O00000oo = "";
    private String O0000OOo = "";
    private float O0000Oo = 0.0f;
    private double O0000Oo0 = 0.0d;
    private float O0000OoO = 0.0f;
    private String O0000Ooo = "";
    private String O0000o = "";
    private String O0000o0 = "";
    private String O0000o00 = "";
    private String O0000o0O = "";
    private String O0000o0o = "";
    private String O0000oO = "";
    private String O0000oO0 = "";
    private String O0000oOO = "";
    private String O0000oOo = "";
    private String O0000oo = "";
    private String O0000oo0 = "";
    private String O0000ooO = "";
    private String O0000ooo = null;
    private boolean O000O00o = false;
    private int O000O0OO = -1;
    private String O000O0Oo = "";
    private byte[] O000O0o = null;
    private float O000O0o0 = 0.0f;
    private int O000O0oO = -1;
    private String O000O0oo = "";
    private boolean O000OO00;
    private JSONObject O00oOoOo = null;
    private String O00oOooO = "";
    private String O00oOooo = "";

    private JSONObject O000000o(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("altitude", this.O0000Oo0);
            jSONObject.put("speed", (double) this.O0000Oo);
            jSONObject.put("bearing", (double) this.O0000OoO);
            jSONObject.put("retype", this.O00000oo);
            jSONObject.put("rdesc", this.O0000Ooo);
            jSONObject.put("citycode", this.O0000o00);
            jSONObject.put("desc", this.O0000o0);
            jSONObject.put("adcode", this.O0000o0O);
            jSONObject.put("country", this.O0000o0o);
            jSONObject.put("province", this.O0000o);
            jSONObject.put("city", this.O0000oO0);
            jSONObject.put("district", this.O0000oO);
            jSONObject.put("road", this.O0000oOO);
            jSONObject.put("street", this.O0000oOo);
            jSONObject.put("number", this.O0000oo0);
            jSONObject.put("aoiname", this.O0000oo);
            jSONObject.put("poiname", this.O0000ooO);
            jSONObject.put("cens", this.O0000ooo);
            jSONObject.put("poiid", this.O00oOooO);
            jSONObject.put("floor", this.O00oOooo);
            jSONObject.put("coord", this.O000O0OO);
            jSONObject.put("mcell", this.O000O0Oo);
            jSONObject.put("scenarioConfidence", this.O000O0oO);
            jSONObject.put("resubtype", this.O000O0oo);
            jSONObject.put("isLast", this.O000OO00);
            if (this.O00oOoOo != null && jSONObject.has("offpct")) {
                jSONObject.put("offpct", this.O00oOoOo.getString("offpct"));
            }
            jSONObject.put("time", this.O00000o);
            jSONObject.put("provider", this.O0000OOo);
            jSONObject.put("lon", this.f2369O000000o);
            jSONObject.put("lat", this.O00000Oo);
            jSONObject.put("accuracy", (double) this.O00000o0);
            jSONObject.put("type", this.O00000oO);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public final double O000000o() {
        return this.f2369O000000o;
    }

    public final void O000000o(double d) {
        if (d > 180.0d || d < -180.0d) {
            this.f2369O000000o = 0.0d;
            this.O000O00o = true;
            return;
        }
        double round = (double) Math.round(d * 1000000.0d);
        Double.isNaN(round);
        this.f2369O000000o = round / 1000000.0d;
    }

    public final double O00000Oo() {
        return this.O00000Oo;
    }

    public final void O00000Oo(double d) {
        if (d > 90.0d || d < -90.0d) {
            this.O00000Oo = 0.0d;
            this.O000O00o = true;
            return;
        }
        double round = (double) Math.round(d * 1000000.0d);
        Double.isNaN(round);
        this.O00000Oo = round / 1000000.0d;
    }

    public final String O00000oO() {
        JSONObject O000000o2 = O000000o(1);
        if (O000000o2 == null) {
            return null;
        }
        return O000000o2.toString();
    }

    public final void O000000o(float f) {
        this.O00000o0 = Float.parseFloat(String.valueOf(Math.round(f)));
    }

    public final void O00000o0() {
        if (TextUtils.isEmpty("0")) {
            this.O000O0OO = -1;
        } else if (this.O0000OOo.equals("gps")) {
            this.O000O0OO = 0;
        } else {
            this.O000O0OO = 0;
        }
    }

    public final boolean O00000o() {
        if (this.O00000oo.equals("8") || this.O00000oo.equals("5") || this.O00000oo.equals("6")) {
            return false;
        }
        double d = this.f2369O000000o;
        double d2 = this.O00000Oo;
        float f = this.O00000o0;
        if ((d != 0.0d || d2 != 0.0d || ((double) f) != 0.0d) && d <= 180.0d && d2 <= 90.0d && d >= -180.0d && d2 >= -90.0d) {
            return true;
        }
        return false;
    }
}
