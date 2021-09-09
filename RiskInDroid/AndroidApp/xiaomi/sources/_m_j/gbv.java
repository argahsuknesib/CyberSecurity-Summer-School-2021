package _m_j;

import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class gbv {
    public static String O000000o(ReadableMap readableMap, String str) {
        return (readableMap == null || !readableMap.hasKey(str)) ? "" : readableMap.getString(str);
    }

    public static int O00000Oo(ReadableMap readableMap, String str) {
        if (readableMap == null || !readableMap.hasKey(str)) {
            return 0;
        }
        return readableMap.getInt(str);
    }

    public static boolean O00000o0(ReadableMap readableMap, String str) {
        if (readableMap == null || !readableMap.hasKey(str)) {
            return false;
        }
        return readableMap.getBoolean(str);
    }

    public static ReadableMap O00000o(ReadableMap readableMap, String str) {
        if (readableMap == null || !readableMap.hasKey(str)) {
            return Arguments.createMap();
        }
        return readableMap.getMap(str);
    }

    public static ReadableArray O00000oO(ReadableMap readableMap, String str) {
        if (readableMap == null || !readableMap.hasKey(str)) {
            return Arguments.createArray();
        }
        return readableMap.getArray(str);
    }

    public static double O00000oo(ReadableMap readableMap, String str) {
        if (readableMap == null || !readableMap.hasKey(str)) {
            return 0.0d;
        }
        return readableMap.getDouble(str);
    }

    public static Map<String, Object> O000000o(ReadableMap readableMap) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(readableMap.toString()).getJSONObject("NativeMap");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.opt(next));
            }
        } catch (JSONException e) {
            fyc.O00000o0("RnReadableMapUtil", "toHashMap error:" + Log.getStackTraceString(e));
        }
        return hashMap;
    }

    public static Map<String, String> O00000Oo(ReadableMap readableMap) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(readableMap.toString()).getJSONObject("NativeMap");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.opt(next).toString());
            }
        } catch (JSONException e) {
            fyc.O00000o0("RnReadableMapUtil", "toHashMap error:" + Log.getStackTraceString(e));
        }
        return hashMap;
    }

    public static String O00000o0(ReadableMap readableMap) {
        try {
            return new JSONObject(readableMap.toString()).getJSONObject("NativeMap").toString();
        } catch (JSONException e) {
            fyc.O00000o0("RnReadableMapUtil", "toJsonString error:" + Log.getStackTraceString(e));
            return "";
        }
    }

    public static JSONObject O00000o(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            try {
                switch (readableMap.getType(nextKey)) {
                    case Null:
                        break;
                    case Map:
                        jSONObject.putOpt(nextKey, O00000o(readableMap.getMap(nextKey)));
                        continue;
                    case Array:
                        jSONObject.putOpt(nextKey, O000000o(readableMap.getArray(nextKey)));
                        continue;
                    case Number:
                        jSONObject.putOpt(nextKey, Double.valueOf(readableMap.getDouble(nextKey)));
                        continue;
                    case String:
                        jSONObject.putOpt(nextKey, readableMap.getString(nextKey));
                        continue;
                    case Boolean:
                        jSONObject.putOpt(nextKey, Boolean.valueOf(readableMap.getBoolean(nextKey)));
                        continue;
                    default:
                        continue;
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static JSONArray O000000o(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < readableArray.size(); i++) {
            try {
                switch (readableArray.getType(i)) {
                    case Null:
                        break;
                    case Map:
                        jSONArray.put(O00000o(readableArray.getMap(i)));
                        continue;
                    case Array:
                        jSONArray.put(O000000o(readableArray.getArray(i)));
                        continue;
                    case Number:
                        jSONArray.put(readableArray.getDouble(i));
                        continue;
                    case String:
                        jSONArray.put(readableArray.getString(i));
                        continue;
                    case Boolean:
                        jSONArray.put(readableArray.getBoolean(i));
                        continue;
                    default:
                        continue;
                }
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }
}
