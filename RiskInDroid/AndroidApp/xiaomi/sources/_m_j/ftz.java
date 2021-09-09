package _m_j;

import _m_j.fua;
import android.content.Context;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ftz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f17137O000000o = "ftz";
    private static volatile ftz O00000Oo;
    private static final Object O00000o0 = new Object();

    private ftz() {
    }

    public static ftz O000000o() {
        if (O00000Oo == null) {
            synchronized (O00000o0) {
                if (O00000Oo == null) {
                    O00000Oo = new ftz();
                }
            }
        }
        return O00000Oo;
    }

    public final fsn O000000o(Context context, String[] strArr, int i, Object obj, fsm<fua.O00000o0, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", i);
            jSONObject.put("params", obj);
            if (strArr != null && strArr.length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String put : strArr) {
                    jSONArray.put(put);
                }
                jSONObject.put("dids", jSONArray);
            }
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/third/api").O000000o(arrayList).O000000o(), new fss<fua.O00000o0>() {
            /* class _m_j.ftz.AnonymousClass1 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                fua.O00000o0 o00000o0 = new fua.O00000o0();
                o00000o0.f17147O000000o = jSONObject.optLong("sid", -1);
                o00000o0.O00000Oo = jSONObject.optInt("interval", -1);
                o00000o0.O00000o0 = jSONObject.optInt("max_retry", -1);
                return o00000o0;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Context context, long j, int i, fsm<fua.O0000O0o, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sid", j);
            jSONObject.put("retry_time", i);
        } catch (JSONException unused) {
        }
        String str = f17137O000000o;
        gsy.O000000o(3, str, "getApiResult request data=" + jSONObject.toString());
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/third/api_result").O000000o(arrayList).O000000o(), new fss<fua.O0000O0o>() {
            /* class _m_j.ftz.AnonymousClass2 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                fua.O0000O0o o0000O0o = new fua.O0000O0o();
                o0000O0o.f17148O000000o = jSONObject;
                return o0000O0o;
            }
        }, Crypto.RC4, fsm);
    }
}
