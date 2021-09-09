package _m_j;

import android.content.Context;
import com.tencent.wxop.stat.a.f;
import java.util.Map;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;

public final class dkh extends dkk {

    /* renamed from: O000000o  reason: collision with root package name */
    protected dki f14741O000000o = new dki();
    private long O0000o0 = -1;

    public dkh(Context context, int i, String str, dkf dkf) {
        super(context, i, dkf);
        this.f14741O000000o.f14742O000000o = str;
    }

    public final dki O000000o() {
        return this.f14741O000000o;
    }

    public final f O00000Oo() {
        return f.CUSTOM;
    }

    public final boolean O000000o(JSONObject jSONObject) {
        String str;
        Object obj;
        Properties O000000o2;
        jSONObject.put("ei", this.f14741O000000o.f14742O000000o);
        long j = this.O0000o0;
        if (j > 0) {
            jSONObject.put("du", j);
        }
        if (this.f14741O000000o.O00000Oo == null) {
            if (!(this.f14741O000000o.f14742O000000o == null || (O000000o2 = dke.O000000o(this.f14741O000000o.f14742O000000o)) == null || O000000o2.size() <= 0)) {
                if (this.f14741O000000o.O00000o0 == null || this.f14741O000000o.O00000o0.length() == 0) {
                    this.f14741O000000o.O00000o0 = new JSONObject((Map<?, ?>) O000000o2);
                } else {
                    for (Map.Entry entry : O000000o2.entrySet()) {
                        try {
                            this.f14741O000000o.O00000o0.put(entry.getKey().toString(), entry.getValue());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            obj = this.f14741O000000o.O00000o0;
            str = "kv";
        } else {
            obj = this.f14741O000000o.O00000Oo;
            str = "ar";
        }
        jSONObject.put(str, obj);
        return true;
    }
}
