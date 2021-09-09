package _m_j;

import android.content.Context;
import com.tencent.wxop.stat.a.f;
import org.json.JSONObject;

public final class dkl extends dkk {
    private static String O0000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public String f14744O000000o = null;
    private String O0000o0O = null;

    public final boolean O000000o(JSONObject jSONObject) {
        dmb.O000000o(jSONObject, "op", O0000o0);
        dmb.O000000o(jSONObject, "cn", this.O0000o0O);
        jSONObject.put("sp", this.f14744O000000o);
        return true;
    }

    public final f O00000Oo() {
        return f.NETWORK_MONITOR;
    }

    public dkl(Context context, int i, dkf dkf) {
        super(context, i, dkf);
        this.O0000o0O = dkg.O000000o(context).O00000o0;
        if (O0000o0 == null) {
            O0000o0 = dlv.O0000Oo0(context);
        }
    }
}
