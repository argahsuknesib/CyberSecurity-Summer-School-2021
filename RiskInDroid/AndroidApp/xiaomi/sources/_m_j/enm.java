package _m_j;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

final class enm {

    /* renamed from: O000000o  reason: collision with root package name */
    String f15654O000000o;
    final ArrayList<enl> O00000Oo = new ArrayList<>();

    public enm() {
    }

    public enm(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f15654O000000o = str;
            return;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    public final synchronized enm O000000o(JSONObject jSONObject) {
        this.f15654O000000o = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.O00000Oo.add(new enl(this.f15654O000000o).O000000o(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public final synchronized JSONObject O00000o0() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("host", this.f15654O000000o);
        JSONArray jSONArray = new JSONArray();
        Iterator<enl> it = this.O00000Oo.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().O00000o());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f15654O000000o);
        sb.append("\n");
        Iterator<enl> it = this.O00000Oo.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    public final synchronized void O000000o(enl enl) {
        int i = 0;
        while (true) {
            if (i >= this.O00000Oo.size()) {
                break;
            } else if (TextUtils.equals(this.O00000Oo.get(i).f15653O000000o, enl.f15653O000000o)) {
                this.O00000Oo.set(i, enl);
                break;
            } else {
                i++;
            }
        }
        if (i >= this.O00000Oo.size()) {
            this.O00000Oo.add(enl);
        }
    }

    public final synchronized enl O000000o() {
        for (int size = this.O00000Oo.size() - 1; size >= 0; size--) {
            enl enl = this.O00000Oo.get(size);
            if (TextUtils.equals(enl.f15653O000000o, enp.m593a())) {
                enp.a().m597a(enl.O00000o0());
                return enl;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0048 A[SYNTHETIC] */
    public final synchronized void O00000Oo() {
        boolean z;
        for (int size = this.O00000Oo.size() - 1; size >= 0; size--) {
            enl enl = this.O00000Oo.get(size);
            long j = 864000000;
            if (864000000 < enl.O0000Ooo) {
                j = enl.O0000Ooo;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - enl.O00000Oo <= j) {
                if (currentTimeMillis - enl.O00000Oo <= enl.O0000Ooo || !enl.f15653O000000o.startsWith("WIFI-")) {
                    z = false;
                    if (!z) {
                        this.O00000Oo.remove(size);
                    }
                }
            }
            z = true;
            if (!z) {
            }
        }
    }
}
