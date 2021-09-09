package com.xiaomi.onetrack;

import android.os.Bundle;
import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.s;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataConverter {
    public static Map fromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            for (String next : bundle.keySet()) {
                Object obj = bundle.get(next);
                if (s.b(obj)) {
                    hashMap.put(next, obj);
                } else if (obj.getClass().isArray()) {
                    int length = Array.getLength(obj);
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < length; i++) {
                        Object obj2 = Array.get(obj, i);
                        if (s.b(obj2)) {
                            arrayList.add(obj2);
                        }
                    }
                    if (arrayList.size() > 0) {
                        hashMap.put(next, arrayList);
                    }
                } else if (obj instanceof List) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object next2 : (List) obj) {
                        if (s.b(next2)) {
                            arrayList2.add(next2);
                        }
                    }
                    if (arrayList2.size() > 0) {
                        hashMap.put(next, arrayList2);
                    }
                } else if (q.f6178a) {
                    s.a("DataConverter", next);
                }
            }
        } catch (Exception e) {
            q.b("DataConverter", "convert bundle error:" + e.toString());
        }
        return hashMap;
    }

    public static Map fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (s.b(obj)) {
                    hashMap.put(next, obj);
                } else if (obj instanceof JSONArray) {
                    hashMap.put(next, a((JSONArray) obj));
                } else if (q.f6178a) {
                    s.a("DataConverter", next);
                }
            }
        } catch (Exception e) {
            q.b("DataConverter", "convert json to map error:" + e.toString());
        }
        return hashMap;
    }

    private static List a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = jSONArray.get(i);
            if (s.b(obj)) {
                arrayList.add(obj);
            } else if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                Iterator<String> keys = jSONObject.keys();
                HashMap hashMap = new HashMap();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object obj2 = jSONObject.get(next);
                    if (s.b(obj2)) {
                        hashMap.put(next, obj2);
                    }
                }
                if (hashMap.size() > 0) {
                    arrayList.add(hashMap);
                }
            }
        }
        return arrayList;
    }
}
