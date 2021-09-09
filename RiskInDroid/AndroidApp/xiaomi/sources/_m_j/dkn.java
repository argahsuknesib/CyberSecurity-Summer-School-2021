package _m_j;

import android.content.Context;
import com.tencent.wxop.stat.a.f;
import com.tencent.wxop.stat.common.b;
import org.json.JSONObject;

public final class dkn extends dkk {

    /* renamed from: O000000o  reason: collision with root package name */
    private b f14746O000000o;
    private JSONObject O0000o0 = null;

    public dkn(Context context, int i, JSONObject jSONObject, dkf dkf) {
        super(context, i, dkf);
        this.f14746O000000o = new b(context);
        this.O0000o0 = jSONObject;
    }

    public final f O00000Oo() {
        return f.SESSION_ENV;
    }

    public final boolean O000000o(JSONObject jSONObject) {
        if (this.O00000oO != null) {
            jSONObject.put("ut", this.O00000oO.O00000o0);
        }
        JSONObject jSONObject2 = this.O0000o0;
        if (jSONObject2 != null) {
            jSONObject.put("cfg", jSONObject2);
        }
        if (dlv.O0000oo0(this.O0000Ooo)) {
            jSONObject.put("ncts", 1);
        }
        this.f14746O000000o.O000000o(jSONObject, null);
        return true;
    }
}
