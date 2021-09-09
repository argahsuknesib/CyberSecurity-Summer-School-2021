package _m_j;

import org.json.JSONException;
import org.json.JSONObject;

public final class pm {

    /* renamed from: O000000o  reason: collision with root package name */
    protected long f2388O000000o = 43200000;
    protected String O00000Oo;
    protected long O00000o;
    protected int O00000o0;
    protected O000000o O00000oO;
    private final long O00000oo = 300000;
    private final long O0000O0o = 259200000;

    public class O000000o {
        private JSONObject O00000Oo;

        O000000o(String str) throws JSONException {
            this.O00000Oo = new JSONObject(str);
        }
    }

    protected pm() {
    }

    public final String O000000o() {
        return this.O00000Oo;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(long, long):long}
     arg types: [long, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(float, float):float}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(long, long):long} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [long, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0046  */
    public final boolean O000000o(String str) {
        String str2;
        boolean z = true;
        try {
            str2 = str.substring(str.indexOf("$") + 1, str.length());
            try {
                JSONObject jSONObject = new JSONObject(str2);
                this.f2388O000000o = Math.min(jSONObject.optLong("p", 43200000), 259200000L);
                this.f2388O000000o = Math.max(this.f2388O000000o, 300000L);
                this.O00000o0 = jSONObject.optInt("v");
                this.O00000oO = new O000000o(str2);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str2 = null;
            z = false;
            if (z) {
            }
            return z;
        }
        if (z) {
            this.O00000Oo = str2;
        }
        return z;
    }
}
