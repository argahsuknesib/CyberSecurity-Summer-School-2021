package com.xiaomi.smarthome.miio.page.msgcentersetting.model;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NoInterruptTime implements Serializable {
    private Map<String, Object> additionalProperties = new HashMap();
    public From from = new From();
    public To to = new To();
    private List<Integer> wday = new ArrayList();

    public static NoInterruptTime O000000o(JSONObject jSONObject) {
        NoInterruptTime noInterruptTime = new NoInterruptTime();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (TextUtils.equals(next, "from")) {
                noInterruptTime.from = From.O000000o(jSONObject.optJSONObject("from"));
            } else if (TextUtils.equals(next, "to")) {
                noInterruptTime.to = To.O000000o(jSONObject.optJSONObject("to"));
            } else if (TextUtils.equals(next, "wday")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("wday");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        noInterruptTime.wday.add(Integer.valueOf(optJSONArray.optInt(i)));
                    }
                }
            } else {
                try {
                    noInterruptTime.additionalProperties.put(next, jSONObject.get(next));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return noInterruptTime;
    }

    public final JSONObject O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.from.O000000o());
            jSONObject.put("to", this.to.O000000o());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.wday.size(); i++) {
                jSONArray.put(this.wday.get(i).intValue());
            }
            jSONObject.put("wday", jSONArray);
            for (String next : this.additionalProperties.keySet()) {
                jSONObject.put(next, this.additionalProperties.get(next));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
