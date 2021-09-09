package _m_j;

import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hvl {

    /* renamed from: O000000o  reason: collision with root package name */
    List<hvj> f703O000000o = new CopyOnWriteArrayList();
    hvj O00000Oo = null;
    private int O00000o;
    private String O00000o0;
    private hvk O00000oO = new hvk();

    public static int O00000o(int i) {
        if (i == 0) {
            return 10;
        }
        if (i == 11) {
            return 43;
        }
        if (i == 2) {
            return 40;
        }
        if (i != 3) {
            return i != 4 ? 0 : 12;
        }
        return 20;
    }

    hvl(String str, int i) {
        this.O00000o0 = str;
        this.O00000o = i;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(String str, String str2) {
        this.O00000oO.O000000o(str, str2);
    }

    /* access modifiers changed from: package-private */
    public final String O000000o(int i) {
        O000000o();
        return O00000oO(i);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, Map<String, String> map) {
        hvj hvj = this.O00000Oo;
        if (hvj == null) {
            gsy.O000000o(6, "SmartConfigProcess", "Please start/add action before finished");
            return;
        }
        hvj.O000000o(map);
        this.O00000Oo.O000000o(i);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        hvj hvj = this.O00000Oo;
        if (hvj != null) {
            hvj.O000000o(0);
            this.f703O000000o.add(this.O00000Oo);
        }
    }

    /* access modifiers changed from: package-private */
    public final hvj O00000Oo(int i) {
        hvj hvj = this.O00000Oo;
        if (hvj != null && hvj.f701O000000o == i) {
            return this.O00000Oo;
        }
        List<hvj> list = this.f703O000000o;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (hvj next : this.f703O000000o) {
            if (next.f701O000000o == i) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final hvj O00000o0(int i) {
        hvj hvj = this.O00000Oo;
        if (hvj != null && hvj.O00000Oo == i) {
            return this.O00000Oo;
        }
        hvj hvj2 = null;
        List<hvj> list = this.f703O000000o;
        if (list != null && list.size() > 0) {
            for (hvj next : this.f703O000000o) {
                if (i == next.O00000Oo) {
                    hvj2 = next;
                }
            }
        }
        return hvj2;
    }

    private String O00000oO(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            ServerBean O00000o2 = fju.O000000o().O00000o();
            String str = this.O00000o0;
            if (O00000o2 != null && !"CN".equalsIgnoreCase(O00000o2.O00000Oo)) {
                str = gnj.O000000o(this.O00000o0);
            }
            jSONObject.put("0", str + "+" + System.currentTimeMillis());
            jSONObject.put("1", this.O00000o);
            jSONObject.put("2", this.O00000oO.O000000o());
            JSONArray jSONArray = new JSONArray();
            for (hvj O00000Oo2 : this.f703O000000o) {
                jSONArray.put(O00000Oo2.O00000Oo());
            }
            jSONObject.put("3", jSONArray);
            jSONObject.put("4", i);
            jSONObject.put("5", "1");
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
