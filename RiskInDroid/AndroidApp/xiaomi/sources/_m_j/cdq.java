package _m_j;

import com.mi.mistatistic.sdk.data.EventData;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class cdq extends cdm {
    private String O00000oO;
    private String O00000oo;
    private String O0000O0o;
    private ArrayList<EventData> O0000OOo;

    public final String O00000o() {
        return "mistat_stat_event";
    }

    public cdq() {
    }

    public cdq(String str, String str2, String str3, ArrayList<EventData> arrayList) {
        this.O00000oO = str;
        this.O00000oo = str2;
        this.O0000O0o = str3;
        this.O0000OOo = arrayList;
    }

    public final String O000000o() {
        return this.f13669O000000o;
    }

    public final void O000000o(String str) {
        this.f13669O000000o = str;
    }

    public final long O00000Oo() {
        return this.O00000Oo;
    }

    public final void O000000o(long j) {
        this.O00000Oo = j;
    }

    public final String O00000oO() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sessionId", this.f13669O000000o);
            jSONObject.put("timestamp", this.O00000Oo);
            jSONObject.put("eventId", this.O00000oO);
            jSONObject.put("pageId", this.O00000oo);
            jSONObject.put("label", this.O0000O0o);
            jSONObject.put("data", O00000oo());
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private String O00000oo() {
        try {
            JSONArray jSONArray = new JSONArray();
            if (this.O0000OOo != null && this.O0000OOo.size() > 0) {
                Iterator<EventData> it = this.O0000OOo.iterator();
                while (it.hasNext()) {
                    EventData next = it.next();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", next.f5063O000000o);
                    jSONObject.put("value", next.O00000Oo);
                    jSONObject.put("type", next.O00000o0);
                    jSONArray.put(jSONObject);
                }
            }
            return jSONArray.toString();
        } catch (Exception e) {
            cdc.O000000o("dataToJsonArrayString  Exception: ", e);
            return "";
        }
    }
}
