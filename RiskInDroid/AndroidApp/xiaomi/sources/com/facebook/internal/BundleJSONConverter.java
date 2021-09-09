package com.facebook.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BundleJSONConverter {
    private static final Map<Class<?>, Setter> SETTERS;

    public interface Setter {
        void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException;

        void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException;
    }

    static {
        HashMap hashMap = new HashMap();
        SETTERS = hashMap;
        hashMap.put(Boolean.class, new Setter() {
            /* class com.facebook.internal.BundleJSONConverter.AnonymousClass1 */

            public final void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            }

            public final void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        SETTERS.put(Integer.class, new Setter() {
            /* class com.facebook.internal.BundleJSONConverter.AnonymousClass2 */

            public final void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putInt(str, ((Integer) obj).intValue());
            }

            public final void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        SETTERS.put(Long.class, new Setter() {
            /* class com.facebook.internal.BundleJSONConverter.AnonymousClass3 */

            public final void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putLong(str, ((Long) obj).longValue());
            }

            public final void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        SETTERS.put(Double.class, new Setter() {
            /* class com.facebook.internal.BundleJSONConverter.AnonymousClass4 */

            public final void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            }

            public final void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        SETTERS.put(String.class, new Setter() {
            /* class com.facebook.internal.BundleJSONConverter.AnonymousClass5 */

            public final void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putString(str, (String) obj);
            }

            public final void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        SETTERS.put(String[].class, new Setter() {
            /* class com.facebook.internal.BundleJSONConverter.AnonymousClass6 */

            public final void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                throw new IllegalArgumentException("Unexpected type from JSON");
            }

            public final void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                JSONArray jSONArray = new JSONArray();
                for (String put : (String[]) obj) {
                    jSONArray.put(put);
                }
                jSONObject.put(str, jSONArray);
            }
        });
        SETTERS.put(JSONArray.class, new Setter() {
            /* class com.facebook.internal.BundleJSONConverter.AnonymousClass7 */

            public final void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                JSONArray jSONArray = (JSONArray) obj;
                ArrayList arrayList = new ArrayList();
                if (jSONArray.length() == 0) {
                    bundle.putStringArrayList(str, arrayList);
                    return;
                }
                int i = 0;
                while (i < jSONArray.length()) {
                    Object obj2 = jSONArray.get(i);
                    if (obj2 instanceof String) {
                        arrayList.add((String) obj2);
                        i++;
                    } else {
                        throw new IllegalArgumentException("Unexpected type in an array: " + obj2.getClass());
                    }
                }
                bundle.putStringArrayList(str, arrayList);
            }

            public final void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
            }
        });
    }

    public static JSONObject convertToJSON(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            if (obj != null) {
                if (obj instanceof List) {
                    JSONArray jSONArray = new JSONArray();
                    for (String put : (List) obj) {
                        jSONArray.put(put);
                    }
                    jSONObject.put(next, jSONArray);
                } else if (obj instanceof Bundle) {
                    jSONObject.put(next, convertToJSON((Bundle) obj));
                } else {
                    Setter setter = SETTERS.get(obj.getClass());
                    if (setter != null) {
                        setter.setOnJSON(jSONObject, next, obj);
                    } else {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                }
            }
        }
        return jSONObject;
    }

    public static Bundle convertToBundle(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (!(obj == null || obj == JSONObject.NULL)) {
                if (obj instanceof JSONObject) {
                    bundle.putBundle(next, convertToBundle((JSONObject) obj));
                } else {
                    Setter setter = SETTERS.get(obj.getClass());
                    if (setter != null) {
                        setter.setOnBundle(bundle, next, obj);
                    } else {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                }
            }
        }
        return bundle;
    }
}
