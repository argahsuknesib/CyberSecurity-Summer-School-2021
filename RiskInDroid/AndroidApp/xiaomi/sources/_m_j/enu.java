package _m_j;

import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

final class enu implements Comparable<enu> {

    /* renamed from: O000000o  reason: collision with root package name */
    String f15659O000000o;
    protected int O00000Oo;
    private long O00000o;
    private final LinkedList<enk> O00000o0;

    public enu() {
        this(null, 0);
    }

    public enu(String str) {
        this(str, 0);
    }

    public enu(String str, int i) {
        this.O00000o0 = new LinkedList<>();
        this.O00000o = 0;
        this.f15659O000000o = str;
        this.O00000Oo = i;
    }

    public final String toString() {
        return this.f15659O000000o + ":" + this.O00000Oo;
    }

    /* access modifiers changed from: protected */
    public final synchronized void O000000o(enk enk) {
        if (enk != null) {
            this.O00000o0.add(enk);
            int i = enk.f15652O000000o;
            if (i > 0) {
                this.O00000Oo += enk.f15652O000000o;
            } else {
                int i2 = 0;
                int size = this.O00000o0.size() - 1;
                while (size >= 0 && this.O00000o0.get(size).f15652O000000o < 0) {
                    i2++;
                    size--;
                }
                this.O00000Oo += i * i2;
            }
            if (this.O00000o0.size() > 30) {
                this.O00000Oo -= this.O00000o0.remove().f15652O000000o;
            }
        }
    }

    public final synchronized JSONObject O000000o() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("tt", this.O00000o);
        jSONObject.put("wt", this.O00000Oo);
        jSONObject.put("host", this.f15659O000000o);
        JSONArray jSONArray = new JSONArray();
        Iterator<enk> it = this.O00000o0.iterator();
        while (it.hasNext()) {
            enk next = it.next();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("cost", next.O00000Oo);
            jSONObject2.put("size", next.O00000oO);
            jSONObject2.put("ts", next.O00000o0);
            jSONObject2.put("wt", next.f15652O000000o);
            jSONObject2.put("expt", next.O00000o);
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    public final synchronized enu O000000o(JSONObject jSONObject) {
        this.O00000o = jSONObject.getLong("tt");
        this.O00000Oo = jSONObject.getInt("wt");
        this.f15659O000000o = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            LinkedList<enk> linkedList = this.O00000o0;
            enk enk = new enk();
            enk.O00000Oo = jSONObject2.getLong("cost");
            enk.O00000oO = jSONObject2.getLong("size");
            enk.O00000o0 = jSONObject2.getLong("ts");
            enk.f15652O000000o = jSONObject2.getInt("wt");
            enk.O00000o = jSONObject2.optString("expt");
            linkedList.add(enk);
        }
        return this;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        enu enu = (enu) obj;
        if (enu == null) {
            return 1;
        }
        return enu.O00000Oo - this.O00000Oo;
    }
}
