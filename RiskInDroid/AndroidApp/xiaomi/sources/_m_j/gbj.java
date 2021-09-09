package _m_j;

import android.text.TextUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.gson.Gson;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class gbj {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Gson f17497O000000o = new Gson();

    public static Object O000000o(String str, Class cls) {
        try {
            return f17497O000000o.fromJson(str, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> String O000000o(Object obj) {
        try {
            return new Gson().toJsonTree(obj).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static WritableMap O000000o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        WritableMap createMap = Arguments.createMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Object obj = jSONObject.get(next);
                if (obj instanceof String) {
                    createMap.putString(next, (String) obj);
                } else {
                    if (!(obj instanceof Integer)) {
                        if (!(obj instanceof Long)) {
                            if (obj instanceof Double) {
                                createMap.putDouble(next, ((Double) obj).doubleValue());
                            } else if (obj instanceof Boolean) {
                                createMap.putBoolean(next, ((Boolean) obj).booleanValue());
                            } else if (obj instanceof JSONArray) {
                                createMap.putArray(next, O000000o((JSONArray) obj));
                            } else if (obj instanceof JSONObject) {
                                createMap.putMap(next, O000000o((JSONObject) obj));
                            } else {
                                fyc.O00000o0("JSONUtil", "toWritableArray, unknown data type:".concat(String.valueOf(obj)));
                            }
                        }
                    }
                    createMap.putInt(next, ((Integer) obj).intValue());
                }
            } catch (JSONException e) {
                fyc.O000000o("JSONUtil", "toWritableMap error:", e);
            }
        }
        return createMap;
    }

    public static WritableArray O000000o(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        WritableArray createArray = Arguments.createArray();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                Object obj = jSONArray.get(i);
                if (obj instanceof String) {
                    createArray.pushString((String) obj);
                } else {
                    if (!(obj instanceof Integer)) {
                        if (!(obj instanceof Long)) {
                            if (obj instanceof Double) {
                                createArray.pushDouble(((Double) obj).doubleValue());
                            } else if (obj instanceof Boolean) {
                                createArray.pushBoolean(((Boolean) obj).booleanValue());
                            } else if (obj instanceof JSONArray) {
                                createArray.pushArray(O000000o((JSONArray) obj));
                            } else if (obj instanceof JSONObject) {
                                createArray.pushMap(O000000o((JSONObject) obj));
                            } else {
                                fyc.O00000o0("JSONUtil", "toWritableArray, unknown data type:".concat(String.valueOf(obj)));
                            }
                        }
                    }
                    createArray.pushInt(((Integer) obj).intValue());
                }
            } catch (JSONException e) {
                fyc.O000000o("JSONUtil", "toWritableArray error:", e);
            }
        }
        return createArray;
    }

    public static boolean O000000o(JSONArray jSONArray, String str) {
        if (jSONArray == null || jSONArray.length() == 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        int length = jSONArray.length();
        int i = 0;
        while (i < length) {
            try {
                if (str.equals(jSONArray.getString(i))) {
                    return true;
                }
                i++;
            } catch (JSONException unused) {
                return false;
            }
        }
        return false;
    }
}
