package _m_j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class hvk {

    /* renamed from: O000000o  reason: collision with root package name */
    private Map<String, String> f702O000000o;

    public final JSONObject O000000o() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Map<String, String> map = this.f702O000000o;
        if (map != null && map.size() > 0) {
            for (Map.Entry next : this.f702O000000o.entrySet()) {
                jSONObject.put((String) next.getKey(), next.getValue());
            }
        }
        return jSONObject;
    }

    public final String toString() {
        return "ReportProcessContext{mContext=" + this.f702O000000o + '}';
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(String str, String str2) {
        if (this.f702O000000o == null) {
            this.f702O000000o = new ConcurrentHashMap();
        }
        this.f702O000000o.put(str, str2);
    }
}
