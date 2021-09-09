package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class fwa {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Object f17296O000000o = new Object();
    private static volatile fwa O00000Oo;

    private fwa() {
    }

    public static fwa O000000o() {
        if (O00000Oo == null) {
            synchronized (f17296O000000o) {
                if (O00000Oo == null) {
                    O00000Oo = new fwa();
                }
            }
        }
        return O00000Oo;
    }

    public final fsn O000000o(Context context, String str, String str2, String str3, fsm<Integer, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pincode", str2);
            jSONObject.put("oldpincode", str3);
            jSONObject.put("did", str);
        } catch (JSONException e) {
            e.printStackTrace();
            fsm.onFailure(new fso(-35, e.getMessage()));
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/pincode/set").O000000o(arrayList).O000000o(), new fss<Integer>() {
            /* class _m_j.fwa.AnonymousClass1 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return Integer.valueOf(jSONObject.optInt("ret"));
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Context context, String str, String str2, fsm<Boolean, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pincode", str2);
            jSONObject.put("did", str);
        } catch (JSONException e) {
            e.printStackTrace();
            fsm.onFailure(new fso(-1, e.getMessage()));
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/pincode/check_alone").O000000o(arrayList).O000000o(), new fss<Boolean>() {
            /* class _m_j.fwa.AnonymousClass2 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return Boolean.valueOf(jSONObject.optBoolean("result"));
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O00000Oo(Context context, String str, String str2, fsm<Void, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("ltmk_key", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/device/blelockupdatekey").O000000o(arrayList).O000000o(), new fss<Void>() {
            /* class _m_j.fwa.AnonymousClass3 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return null;
            }
        }, Crypto.RC4, fsm);
    }
}
