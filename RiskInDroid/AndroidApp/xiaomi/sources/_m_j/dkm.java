package _m_j;

import android.content.Context;
import com.tencent.wxop.stat.a.f;
import org.json.JSONObject;

public final class dkm extends dkk {

    /* renamed from: O000000o  reason: collision with root package name */
    Long f14745O000000o = null;
    String O0000o0;
    String O0000o0O;

    public dkm(Context context, String str, String str2, int i, Long l, dkf dkf) {
        super(context, i, dkf);
        this.O0000o0O = str;
        this.O0000o0 = str2;
        this.f14745O000000o = l;
    }

    public final boolean O000000o(JSONObject jSONObject) {
        dmb.O000000o(jSONObject, "pi", this.O0000o0);
        dmb.O000000o(jSONObject, "rf", this.O0000o0O);
        Long l = this.f14745O000000o;
        if (l == null) {
            return true;
        }
        jSONObject.put("du", l);
        return true;
    }

    public final f O00000Oo() {
        return f.PAGE_VIEW;
    }
}
