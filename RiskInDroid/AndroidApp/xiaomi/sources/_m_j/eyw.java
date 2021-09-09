package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.ad.api.AdPosition;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class eyw {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Object f15959O000000o = new Object();
    private static volatile eyw O00000Oo;

    private eyw() {
    }

    public static eyw O000000o() {
        if (O00000Oo == null) {
            synchronized (f15959O000000o) {
                if (O00000Oo == null) {
                    O00000Oo = new eyw();
                }
            }
        }
        return O00000Oo;
    }

    public final fsn O000000o(Context context, final fsm<List<AdPosition>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("plugin_id", 122);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        Context context2 = context;
        CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O000000o("GET").O00000Oo("/service/getadconfig").O000000o(arrayList).O000000o(), new fss<String>() {
            /* class _m_j.eyw.AnonymousClass1 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject.toString();
            }
        }, Crypto.RC4, new fsm<String, fso>() {
            /* class _m_j.eyw.AnonymousClass2 */

            public final /* synthetic */ void onSuccess(Object obj) {
                try {
                    JSONArray optJSONArray = new JSONObject((String) obj).optJSONArray("result");
                    if (optJSONArray != null) {
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            arrayList.add(AdPosition.O000000o(optJSONArray.optJSONObject(i)));
                        }
                        if (fsm != null) {
                            fsm.onSuccess(arrayList);
                        }
                    }
                } catch (Exception unused) {
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.onFailure(new fso(-1, "json parse error"));
                    }
                }
            }

            public final void onFailure(fso fso) {
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onFailure(new fso(fso.f17063O000000o, fso.O00000Oo));
                }
            }
        });
        return null;
    }

    public static void O000000o(String str) {
        O000000o("PageStart", str, "PluginOperateShow");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void
     arg types: [com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, int]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, boolean, long, long):int
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, _m_j.fsm<org.json.JSONObject, _m_j.fso>, boolean):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String[], boolean, com.xiaomi.smarthome.core.client.IClientCallback):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void */
    public static void O000000o(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str);
        if (O00000oO != null) {
            try {
                jSONObject.put("model", str);
                jSONObject.put("title", O00000oO.O0000Oo0());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            CoreApi.O000000o().O000000o(StatType.EVENT, str2, str3, jSONObject.toString(), false);
        }
    }
}
