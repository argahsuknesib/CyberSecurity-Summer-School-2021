package _m_j;

import org.json.JSONException;
import org.json.JSONObject;

public final class dux extends duz {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f14963O000000o;
    public int O00000Oo;
    public String O00000o;
    public long O00000o0;

    public final JSONObject O000000o() {
        try {
            JSONObject O000000o2 = super.O000000o();
            if (O000000o2 == null) {
                return null;
            }
            O000000o2.put("eventId", this.f14963O000000o);
            O000000o2.put("eventType", this.O00000Oo);
            O000000o2.put("eventTime", this.O00000o0);
            O000000o2.put("eventContent", this.O00000o == null ? "" : this.O00000o);
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
