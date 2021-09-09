package _m_j;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class hvj {

    /* renamed from: O000000o  reason: collision with root package name */
    int f701O000000o;
    int O00000Oo;
    Map<String, String> O00000o;
    long O00000o0;
    private int O00000oO;
    private long O00000oo;

    /* access modifiers changed from: package-private */
    public final void O000000o(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            O000000o();
            this.O00000o.put(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(Map<String, String> map) {
        O000000o();
        if (map != null && map.size() != 0) {
            this.O00000o.putAll(map);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i) {
        this.O00000oO = i;
        this.O00000oo = System.currentTimeMillis() - this.O00000o0;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        if (this.O00000o == null) {
            this.O00000o = new ConcurrentHashMap();
        }
    }

    public final JSONObject O00000Oo() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("0", this.f701O000000o);
        jSONObject.put("1", this.O00000Oo);
        jSONObject.put("2", this.O00000o0);
        JSONObject jSONObject2 = new JSONObject();
        Map<String, String> map = this.O00000o;
        if (map != null && map.size() > 0) {
            for (Map.Entry next : this.O00000o.entrySet()) {
                jSONObject2.put((String) next.getKey(), next.getValue());
            }
        }
        jSONObject.put("3", jSONObject2);
        jSONObject.put("4", this.O00000oO);
        jSONObject.put("5", this.O00000oo);
        return jSONObject;
    }

    public final String toString() {
        return "ReportActionDetail{mIndex=" + this.f701O000000o + ", mCode=" + this.O00000Oo + ", mTimeStamp=" + this.O00000o0 + ", mContext=" + this.O00000o + ", mResultCode=" + this.O00000oO + ", mTimeCost=" + this.O00000oo + '}';
    }
}
