package com.xiaomi.smarthome.device;

import _m_j.fjd;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class XiaomiRedMiRouter15 extends Device {
    String mRealModel;
    private String routerSsid;

    public XiaomiRedMiRouter15(String str, String str2) {
        this.mRealModel = str2;
        this.did = "wifi:" + this.mRealModel;
        this.model = "xiaomi.router.rmo15";
        this.canUseNotBind = true;
        this.routerSsid = str;
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str2);
        if (O00000oO != null) {
            this.name = O00000oO.O0000Oo0();
        }
    }

    public final String O000000o() {
        String str = this.routerSsid;
        return str == null ? "" : str;
    }

    public final Bundle O00000Oo() {
        Bundle bundle = new Bundle();
        bundle.putInt("scene_type", -2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rn_ssid", O000000o());
            jSONObject.put("rn_model", this.mRealModel);
            JSONArray O00000o0 = O00000o0();
            if (O00000o0 != null) {
                jSONObject.put("bind_models", O00000o0);
            }
            bundle.putString("extra", jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bundle;
    }

    public static JSONArray O00000o0() throws JSONException {
        fjd O000000o2 = fjd.O000000o();
        HashMap hashMap = new HashMap();
        ArrayList<Device> O00000Oo = O000000o2.O00000Oo();
        if (O00000Oo.size() > 0) {
            for (Device next : O00000Oo) {
                String model = next.getModel();
                if (!TextUtils.isEmpty(model) && model.startsWith("xiaomi.router.")) {
                    hashMap.put(next.getDid(), next);
                }
            }
        }
        if (hashMap.size() <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : hashMap.keySet()) {
            Device device = (Device) hashMap.get(str);
            if (device != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("model", device.getModel());
                jSONObject.put("deviceId", str);
                jSONObject.put("routerName", device.getName());
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }
}
