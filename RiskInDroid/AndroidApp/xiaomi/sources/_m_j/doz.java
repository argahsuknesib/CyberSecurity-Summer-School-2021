package _m_j;

import _m_j.doy;
import android.util.Log;
import com.tmall.wireless.vaf.framework.VafContext;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class doz extends doy {
    private AtomicInteger O00000oO = new AtomicInteger(0);
    private o0O0OOO0<String, Integer> O00000oo = new o0O0OOO0<>();
    private o0OO00o0<String> O0000O0o = new o0OO00o0<>();
    private JSONArray O0000OOo;

    public doz(VafContext vafContext) {
        super(vafContext);
    }

    public final void O000000o(Object obj) {
        if (obj == null) {
            this.O0000OOo = null;
        } else if (obj instanceof JSONArray) {
            this.O0000OOo = (JSONArray) obj;
        } else {
            Log.e("ArrayAdapter_TMTEST", "setData failed:".concat(String.valueOf(obj)));
        }
    }

    public final int O000000o() {
        JSONArray jSONArray = this.O0000OOo;
        if (jSONArray != null) {
            return jSONArray.length();
        }
        return 0;
    }

    public final int O00000Oo(int i) {
        JSONArray jSONArray = this.O0000OOo;
        if (jSONArray == null) {
            return 0;
        }
        try {
            String optString = jSONArray.getJSONObject(i).optString("type");
            if (this.O00000oo.containsKey(optString)) {
                return this.O00000oo.get(optString).intValue();
            }
            int andIncrement = this.O00000oO.getAndIncrement();
            this.O00000oo.put(optString, Integer.valueOf(andIncrement));
            this.O0000O0o.O00000Oo(andIncrement, optString);
            return andIncrement;
        } catch (JSONException unused) {
            return 0;
        }
    }

    public final void O000000o(doy.O000000o o000000o, int i) {
        try {
            Object obj = this.O0000OOo.get(i);
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                dpf virtualView = ((dpb) o000000o.f14823O000000o).getVirtualView();
                if (virtualView != null) {
                    virtualView.O000000o(jSONObject);
                }
                if (virtualView.O0000oo0()) {
                    this.f14822O000000o.O00000Oo().O000000o(1, dpj.O000000o(this.f14822O000000o, virtualView));
                }
                virtualView.O00000o0();
                return;
            }
            Log.e("ArrayAdapter_TMTEST", "failed");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final doy.O000000o O00000o0(int i) {
        return new doy.O000000o(this.O00000o.O000000o(this.O0000O0o.O000000o(i, null), this.O00000o0, true));
    }
}
