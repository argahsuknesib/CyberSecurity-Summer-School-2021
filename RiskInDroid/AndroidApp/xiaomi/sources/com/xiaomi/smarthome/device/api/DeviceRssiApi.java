package com.xiaomi.smarthome.device.api;

import _m_j.fsm;
import _m_j.fsn;
import _m_j.fso;
import _m_j.fss;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceRssiApi {
    private DeviceRssiApi() {
    }

    public static DeviceRssiApi getInstance() {
        return DeviceRssiApiHolder.INSTANCE;
    }

    public fsn requestAllRssiConfig(Context context, String str, fsm<Map<String, Integer>, fso> fsm) {
        if (TextUtils.isEmpty(str)) {
            fsm.onFailure(new fso(-1, "phone key is empty!"));
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("phonekey", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/home/rssi_threshold").O000000o(arrayList).O000000o(), new fss<Map<String, Integer>>() {
            /* class com.xiaomi.smarthome.device.api.DeviceRssiApi.AnonymousClass1 */

            public Map<String, Integer> parse(JSONObject jSONObject) throws JSONException {
                HashMap hashMap = new HashMap();
                if (jSONObject == null) {
                    return hashMap;
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, Integer.valueOf(jSONObject.getJSONObject(next).optInt("rssi", 0)));
                }
                return hashMap;
            }
        }, Crypto.RC4, fsm);
    }

    static class DeviceRssiApiHolder {
        public static final DeviceRssiApi INSTANCE = new DeviceRssiApi();

        private DeviceRssiApiHolder() {
        }
    }
}
