package com.mibi.sdk.common;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class BundleUtils {
    public static Map<String, Object> convertJson2Map(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (!(obj instanceof Integer) && !(obj instanceof Boolean)) {
                    if (!(obj instanceof String)) {
                        Log.e("BundleUtils", "can not convert types except for int string and string key:".concat(String.valueOf(next)));
                    }
                }
                hashMap.put(next, obj);
            }
            return hashMap;
        } catch (JSONException e) {
            Log.e("BundleUtils", "BundleUtils convertJson2Map JSONException: ", e);
            return null;
        }
    }

    public static Bundle convertMap2Bundle(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (String next : map.keySet()) {
            Object obj = map.get(next);
            if (obj instanceof Integer) {
                bundle.putInt(next, ((Integer) obj).intValue());
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(next, ((Boolean) obj).booleanValue());
            } else if (obj instanceof String) {
                bundle.putString(next, (String) obj);
            } else {
                Log.e("BundleUtils", "can not convert types except for int string and string key:".concat(String.valueOf(next)));
            }
        }
        return bundle;
    }

    public static String appendBundle2Url(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            if ((obj instanceof Integer) || (obj instanceof Boolean) || (obj instanceof String)) {
                parse = parse.buildUpon().appendQueryParameter(next, obj.toString()).build();
            }
        }
        return parse.toString();
    }

    public static JSONObject convertBundle2Json(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            try {
                if (obj instanceof String) {
                    try {
                        jSONObject.put(next, new JSONObject(obj.toString()));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        jSONObject.put(next, obj);
                    }
                }
                jSONObject.put(next, obj.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
                Log.e("BundleUtils", "can not convert types except for int string and string key:".concat(String.valueOf(next)));
            }
        }
        return jSONObject;
    }

    public static Bundle convertJson2Bundle(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new Bundle();
        }
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Object obj = jSONObject.get(next);
                if (obj instanceof String) {
                    bundle.putString(next, obj.toString());
                } else if (obj instanceof Boolean) {
                    bundle.putBoolean(next, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Integer) {
                    bundle.putInt(next, ((Integer) obj).intValue());
                } else if (obj instanceof Double) {
                    bundle.putDouble(next, ((Double) obj).doubleValue());
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Log.e("BundleUtils", "can not put value into bundle string and string key:".concat(String.valueOf(next)));
            }
        }
        return bundle;
    }
}
