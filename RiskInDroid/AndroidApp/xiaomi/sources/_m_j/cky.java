package _m_j;

import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cky {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f13977O000000o = "cky";

    public static void O000000o(String str, String[] strArr, final Callback<Long> callback) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i <= 0; i++) {
            jSONArray.put(strArr[0]);
        }
        try {
            jSONObject.put("dids", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cki.O00000o(f13977O000000o, "get offline time params=".concat(String.valueOf(jSONObject.toString())));
        XmPluginHostApi.instance().callSmartHomeApi(str, "/appgateway/miot/appdeviceinfo_service/AppDeviceInfoService/get_last_online", jSONObject, new Callback<JSONObject>() {
            /* class _m_j.cky.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            static final /* synthetic */ boolean f13978O000000o = (!cky.class.desiredAssertionStatus());

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                try {
                    String str = cky.f13977O000000o;
                    cki.O00000o(str, "get offline time onSuccess=" + jSONObject.toString());
                    JSONArray optJSONArray = jSONObject.optJSONArray("info");
                    if (!f13978O000000o) {
                        if (optJSONArray == null) {
                            throw new AssertionError();
                        }
                    }
                    callback.onSuccess(Long.valueOf(optJSONArray.getJSONObject(0).getLong("last_online")));
                } catch (JSONException e) {
                    e.printStackTrace();
                    callback.onFailure(-1, e.toString());
                }
            }

            public final void onFailure(int i, String str) {
                String str2 = cky.f13977O000000o;
                cki.O00000o(str2, "get offline time onFailure=" + i + " errorInfo=" + str);
                callback.onFailure(i, str);
            }
        }, Parser.DEFAULT_PARSER);
    }
}
