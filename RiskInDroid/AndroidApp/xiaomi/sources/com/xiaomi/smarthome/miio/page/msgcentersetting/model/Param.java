package com.xiaomi.smarthome.miio.page.msgcentersetting.model;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class Param implements Serializable {
    private Map<String, Object> additionalProperties = new HashMap();
    public int deviceShare = 1;
    public int familyShare = 1;
    public int noInterrupt = 0;
    public NoInterruptTime noInterruptTime = new NoInterruptTime();
    public int scene = 1;
    public int shop = 1;

    public static Param O000000o(JSONObject jSONObject) {
        Param param = new Param();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (TextUtils.equals(next, "scene")) {
                param.O000000o(Integer.valueOf(jSONObject.optInt(next)));
            } else if (TextUtils.equals(next, "device_share")) {
                param.O00000Oo(Integer.valueOf(jSONObject.optInt(next)));
            } else if (TextUtils.equals(next, "family_share")) {
                param.O00000o0(Integer.valueOf(jSONObject.optInt(next)));
            } else if (TextUtils.equals(next, "shop")) {
                param.O00000o(Integer.valueOf(jSONObject.optInt(next)));
            } else if (TextUtils.equals(next, "no_interrupt")) {
                param.O00000oO(Integer.valueOf(jSONObject.optInt(next)));
            } else if (TextUtils.equals(next, "no_interrupt_time")) {
                param.noInterruptTime = NoInterruptTime.O000000o(jSONObject.optJSONObject("no_interrupt_time"));
            } else {
                try {
                    param.additionalProperties.put(next, jSONObject.get(next));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return param;
    }

    public final JSONObject O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("no_interrupt_time", this.noInterruptTime.O000000o());
            jSONObject.put("scene", this.scene);
            jSONObject.put("device_share", this.deviceShare);
            jSONObject.put("family_share", this.familyShare);
            jSONObject.put("shop", this.shop);
            jSONObject.put("no_interrupt", this.noInterrupt);
            for (String next : this.additionalProperties.keySet()) {
                jSONObject.put(next, this.additionalProperties.get(next));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final void O000000o(Integer num) {
        this.scene = num.intValue();
    }

    public final void O00000Oo(Integer num) {
        this.deviceShare = num.intValue();
    }

    public final void O00000o0(Integer num) {
        this.familyShare = num.intValue();
    }

    public final void O00000o(Integer num) {
        this.shop = num.intValue();
    }

    public final void O00000oO(Integer num) {
        this.noInterrupt = num.intValue();
    }
}
