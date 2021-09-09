package _m_j;

import org.json.JSONException;
import org.json.JSONObject;

public final class duy extends duz {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f14964O000000o;
    public long O00000Oo = -1;
    public long O00000o0 = -1;

    public final JSONObject O000000o() {
        try {
            JSONObject O000000o2 = super.O000000o();
            if (O000000o2 == null) {
                return null;
            }
            O000000o2.put("code", this.f14964O000000o);
            O000000o2.put("perfCounts", this.O00000Oo);
            O000000o2.put("perfLatencies", this.O00000o0);
            return O000000o2;
        } catch (JSONException e) {
            duv.O000000o(e);
            return null;
        }
    }

    public final String O00000Oo() {
        return super.O00000Oo();
    }
}
