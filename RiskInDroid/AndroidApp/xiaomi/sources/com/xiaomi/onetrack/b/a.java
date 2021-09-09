package com.xiaomi.onetrack.b;

import android.text.TextUtils;
import com.xiaomi.onetrack.g.b;
import com.xiaomi.onetrack.g.c;
import com.xiaomi.onetrack.h.h;
import com.xiaomi.onetrack.h.j;
import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.r;
import com.xiaomi.onetrack.h.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private static boolean n = false;

    public static void a(String str) {
        j.a(new b(str));
    }

    public static void b(String str) {
        if (c(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            a(arrayList);
            return;
        }
        q.a("AppConfigUpdater", "AppConfigUpdater Does not meet prerequisites for request");
    }

    private static boolean c(String str) {
        if (!c.a()) {
            q.a("AppConfigUpdater", "net is not connected!");
            return false;
        }
        j d = f.a().d(str);
        if (d == null) {
            return true;
        }
        long j = d.b;
        if (j < System.currentTimeMillis() || j - System.currentTimeMillis() > 172800000) {
            return true;
        }
        return false;
    }

    private static void a(List<String> list) {
        if (!r.a("AppConfigUpdater") && !n) {
            HashMap hashMap = new HashMap();
            try {
                n = true;
                hashMap.put("oa", com.xiaomi.onetrack.h.a.a.a().a(com.xiaomi.onetrack.f.a.a()));
                hashMap.put("ov", r.b());
                hashMap.put("ob", r.c());
                hashMap.put("ii", r.A() ? "1" : "0");
                hashMap.put("sv", "1.1.5");
                hashMap.put("av", r.l());
                hashMap.put("ml", h.c());
                hashMap.put("re", r.B());
                hashMap.put("ail", b(list));
                hashMap.put("sender", com.xiaomi.onetrack.f.a.d());
                hashMap.put("platform", "Android");
                String c = w.a().c();
                q.a("AppConfigUpdater", "pullData:".concat(String.valueOf(c)));
                String b = b.b(c, hashMap, true);
                q.a("AppConfigUpdater", "response:".concat(String.valueOf(b)));
                a(b, list);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                n = false;
            }
        }
    }

    private static String b(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                jSONObject.put("appId", str);
                jSONObject.put("hash", f.a().c(str));
                jSONArray.put(jSONObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONArray.toString();
    }

    public static void a(String str, List<String> list) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("code") == 0) {
                    a(jSONObject.optJSONObject("data").optJSONArray("apps"), list);
                }
            } catch (Exception e) {
                q.a("AppConfigUpdater", "saveAppCloudData: " + e.toString());
            }
        }
    }

    private static void a(JSONArray jSONArray, List<String> list) throws JSONException {
        long currentTimeMillis = System.currentTimeMillis() + 86400000 + ((long) new Random().nextInt(86400000));
        if (jSONArray == null || jSONArray.length() <= 0) {
            a(list, currentTimeMillis);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            int optInt = optJSONObject != null ? optJSONObject.optInt("type") : -1;
            String optString = optJSONObject != null ? optJSONObject.optString("appId") : "";
            if (optInt == 0 || optInt == 1) {
                a(optJSONObject, currentTimeMillis);
            } else if (optInt == 2) {
                b(optJSONObject, currentTimeMillis);
            } else {
                q.a("AppConfigUpdater", "updateDataToDb do nothing!");
            }
            if (!TextUtils.isEmpty(optString)) {
                arrayList.add(optString);
            }
        }
        a(list, currentTimeMillis, arrayList);
    }

    private static void a(JSONObject jSONObject, long j) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            j jVar = new j();
            jVar.c = jSONObject.optString("hash");
            jVar.f6124a = jSONObject.optString("appId");
            jVar.b = j;
            if (jSONObject.has("events")) {
                jVar.d = jSONObject;
            }
            arrayList.add(jVar);
        }
        if (!arrayList.isEmpty()) {
            f.a().a(arrayList);
        } else {
            q.a("AppConfigUpdater", "handleFullOrNoNewData no configuration can be updated!");
        }
    }

    private static void b(JSONObject jSONObject, long j) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || !jSONObject.has("events")) {
            q.a("AppConfigUpdater", "handleIncrementalUpdate config is not change!");
        } else {
            j jVar = new j();
            jVar.c = jSONObject.optString("hash");
            String optString = jSONObject.optString("appId");
            jVar.f6124a = optString;
            jVar.b = j;
            jVar.d = a(optString, jSONObject);
            arrayList.add(jVar);
        }
        if (!arrayList.isEmpty()) {
            f.a().a(arrayList);
        } else {
            q.a("AppConfigUpdater", "handleIncrementalUpdate no configuration can be updated!");
        }
    }

    private static JSONObject a(String str, JSONObject jSONObject) {
        try {
            j d = f.a().d(str);
            jSONObject.put("events", a(d != null ? d.d.optJSONArray("events") : null, jSONObject.optJSONArray("events")));
            return jSONObject;
        } catch (Exception e) {
            q.b("AppConfigUpdater", "mergeConfig: " + e.toString());
            return null;
        }
    }

    private static JSONArray a(JSONArray jSONArray, JSONArray jSONArray2) {
        JSONArray jSONArray3 = jSONArray;
        int i = 0;
        while (jSONArray2 != null) {
            try {
                if (i >= jSONArray2.length()) {
                    break;
                }
                JSONObject optJSONObject = jSONArray2.optJSONObject(i);
                String optString = optJSONObject.optString("event");
                int i2 = 0;
                while (true) {
                    if (jSONArray3 == null || i2 >= jSONArray3.length()) {
                        break;
                    } else if (TextUtils.equals(optString, jSONArray3.optJSONObject(i2).optString("event"))) {
                        jSONArray3.remove(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!optJSONObject.has("status") || (optJSONObject.has("status") && !TextUtils.equals(optJSONObject.optString("status"), "deleted"))) {
                    if (jSONArray3 == null) {
                        jSONArray3 = new JSONArray();
                    }
                    jSONArray3.put(optJSONObject);
                }
                i++;
            } catch (Exception e) {
                q.b("AppConfigUpdater", "mergeEventsElement error:" + e.toString());
            }
        }
        return jSONArray3;
    }

    private static void a(List<String> list, long j, List<String> list2) {
        try {
            if (list.size() != list2.size()) {
                list.removeAll(list2);
                a(list, j);
            }
        } catch (Exception e) {
            q.b("AppConfigUpdater", "handleInvalidAppIds error:" + e.toString());
        }
    }

    private static void a(List<String> list, long j) {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                j jVar = new j();
                jVar.f6124a = list.get(i);
                jVar.b = j;
                arrayList.add(jVar);
            }
            f.a().a(arrayList);
        } catch (Exception e) {
            q.b("AppConfigUpdater", "handleError" + e.toString());
        }
    }
}
