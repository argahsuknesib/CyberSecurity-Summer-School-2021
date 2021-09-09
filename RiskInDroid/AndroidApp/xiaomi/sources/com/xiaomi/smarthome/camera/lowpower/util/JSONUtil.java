package com.xiaomi.smarthome.camera.lowpower.util;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JSONUtil {
    public static ArrayList<String> toList(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        ArrayList<String> arrayList = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(jSONArray.optString(i));
        }
        return arrayList;
    }

    public static JSONArray getSingleJSONArray(Object obj) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(obj);
        return jSONArray;
    }

    public static JSONArray getJSONArrayFromList(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    public static String getJSONArrayLikeFromList(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String append : list) {
            sb.append(append);
            sb.append(",");
        }
        if (sb.length() <= 0 || sb.indexOf(",") == -1) {
            return sb.toString();
        }
        return sb.subSequence(0, sb.length() - 1).toString();
    }

    public static boolean hasKey(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }

    public static String getString(JSONObject jSONObject, String str, String str2) {
        return hasKey(jSONObject, str) ? jSONObject.optString(str, str2) : str2;
    }

    public static int getInt(JSONObject jSONObject, String str, int i) {
        return hasKey(jSONObject, str) ? jSONObject.optInt(str, i) : i;
    }

    public static int getInt(JSONObject jSONObject, String str) {
        return getInt(jSONObject, str, 0);
    }

    public static String getString(JSONObject jSONObject, String str) {
        return getString(jSONObject, str, null);
    }

    public static boolean isEmpty(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() <= 0;
    }

    public static boolean isNotEmpty(JSONObject jSONObject) {
        return !isEmpty(jSONObject);
    }
}
