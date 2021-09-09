package com.xiaomi.smarthome.device.api;

import org.json.JSONException;
import org.json.JSONObject;

public interface Parser<T> {
    public static final Parser<JSONObject> DEFAULT_PARSER = new Parser<JSONObject>() {
        /* class com.xiaomi.smarthome.device.api.Parser.AnonymousClass1 */

        public final JSONObject parse(String str) throws JSONException {
            return new JSONObject(str);
        }
    };

    T parse(String str) throws JSONException;
}
