package _m_j;

import java.util.Map;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

public final class dki {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f14742O000000o;
    public JSONArray O00000Oo;
    public JSONObject O00000o0 = null;

    public dki() {
    }

    public dki(String str, Properties properties) {
        this.f14742O000000o = str;
        this.O00000o0 = properties != null ? new JSONObject((Map<?, ?>) properties) : new JSONObject();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof dki) {
            return toString().equals(((dki) obj).toString());
        }
        return false;
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f14742O000000o);
        sb.append(",");
        JSONArray jSONArray = this.O00000Oo;
        if (jSONArray != null) {
            sb.append(jSONArray.toString());
        }
        JSONObject jSONObject = this.O00000o0;
        if (jSONObject != null) {
            sb.append(jSONObject.toString());
        }
        return sb.toString();
    }
}
