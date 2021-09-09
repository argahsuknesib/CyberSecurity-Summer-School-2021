package com.xiaomi.smarthome.miio.page.msgcentersetting.model;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class From implements Serializable {
    private Map<String, Object> additionalProperties = new HashMap();
    public int hour = 23;
    public int min = 0;

    public static From O000000o(JSONObject jSONObject) {
        From from = new From();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (TextUtils.equals(next, "hour")) {
                from.O000000o(Integer.valueOf(jSONObject.optInt("hour")));
            } else if (TextUtils.equals(next, "min")) {
                from.O00000Oo(Integer.valueOf(jSONObject.optInt("min")));
            } else {
                try {
                    from.additionalProperties.put(next, jSONObject.get(next));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return from;
    }

    public final JSONObject O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hour", this.hour);
            jSONObject.put("min", this.min);
            for (String next : this.additionalProperties.keySet()) {
                jSONObject.put(next, this.additionalProperties.get(next));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final void O000000o(Integer num) {
        this.hour = num.intValue();
    }

    public final void O00000Oo(Integer num) {
        this.min = num.intValue();
    }
}
