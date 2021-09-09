package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class htj {
    public static void O000000o(final Context context, final String str, final String str2) {
        hxi.O0000Oo.O00000Oo(str, (int) (System.currentTimeMillis() / 1000));
        CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
            /* class _m_j.htj.AnonymousClass1 */

            public final void run() {
                JSONObject jSONObject;
                htj.O000000o();
                Context appContext = CommonApplication.getAppContext();
                SharedPreferences sharedPreferences = appContext.getSharedPreferences("devicebind_statis_" + CoreApi.O000000o().O0000o0(), 0);
                String string = sharedPreferences.getString(str + "_start", null);
                if (string == null) {
                    jSONObject = new JSONObject();
                } else {
                    try {
                        jSONObject = new JSONObject(string);
                    } catch (JSONException e) {
                        gsy.O000000o(6, "DeviceBindStatis", Log.getStackTraceString(e));
                        jSONObject = new JSONObject();
                    }
                }
                try {
                    if (!TextUtils.isEmpty(str2)) {
                        long optLong = jSONObject.optLong(str2);
                        if (optLong <= 0) {
                            optLong = jSONObject.optLong("nossid");
                            if (optLong > 0) {
                                jSONObject.remove("nossid");
                                jSONObject.put(str2, optLong);
                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                edit.putString(str + "_start", jSONObject.toString()).apply();
                            }
                        }
                        if (optLong <= 0) {
                            jSONObject.put(str2, System.currentTimeMillis());
                            SharedPreferences.Editor edit2 = sharedPreferences.edit();
                            edit2.putString(str + "_start", jSONObject.toString()).apply();
                        }
                    } else if (jSONObject.optLong("nossid") <= 0) {
                        jSONObject.put("nossid", System.currentTimeMillis());
                        SharedPreferences.Editor edit3 = sharedPreferences.edit();
                        edit3.putString(str + "_start", jSONObject.toString()).apply();
                    }
                } catch (JSONException e2) {
                    gsy.O000000o(6, "DeviceBindStatis", Log.getStackTraceString(e2));
                }
            }
        });
    }

    private static void O00000Oo(final String str, final String str2) {
        CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
            /* class _m_j.htj.AnonymousClass2 */

            public final void run() {
                JSONObject jSONObject;
                Context appContext = CommonApplication.getAppContext();
                SharedPreferences sharedPreferences = appContext.getSharedPreferences("devicebind_statis_" + CoreApi.O000000o().O0000o0(), 0);
                String string = sharedPreferences.getString(str + "_end", null);
                if (string == null) {
                    jSONObject = new JSONObject();
                } else {
                    try {
                        jSONObject = new JSONObject(string);
                    } catch (JSONException e) {
                        gsy.O000000o(6, "DeviceBindStatis", Log.getStackTraceString(e));
                        jSONObject = new JSONObject();
                    }
                }
                try {
                    jSONObject.put(TextUtils.isEmpty(str2) ? "nossid" : str2, System.currentTimeMillis());
                } catch (JSONException e2) {
                    gsy.O000000o(6, "DeviceBindStatis", Log.getStackTraceString(e2));
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(str + "_end", jSONObject.toString()).apply();
            }
        });
    }

    public static void O000000o(String str, String str2) {
        O00000Oo(str, str2);
        O000000o();
    }

    public static void O000000o() {
        Context appContext = CommonApplication.getAppContext();
        final SharedPreferences sharedPreferences = appContext.getSharedPreferences("devicebind_statis_" + CoreApi.O000000o().O0000o0(), 0);
        CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
            /* class _m_j.htj.AnonymousClass3 */

            public final void run() {
                int i;
                String str;
                String str2;
                HashMap hashMap = new HashMap(sharedPreferences.getAll());
                SharedPreferences.Editor edit = sharedPreferences.edit();
                if (hashMap.size() != 0) {
                    HashMap hashMap2 = new HashMap();
                    HashMap hashMap3 = new HashMap();
                    Iterator it = hashMap.entrySet().iterator();
                    while (true) {
                        i = 6;
                        str = "_start";
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        String str3 = (String) entry.getKey();
                        if (str3.endsWith(str)) {
                            try {
                                hashMap2.put(str3.replace(str, ""), new JSONObject(entry.getValue().toString()));
                            } catch (JSONException e) {
                                gsy.O000000o(6, "DeviceBindStatis", Log.getStackTraceString(e));
                            }
                        } else if (str3.endsWith("_end")) {
                            try {
                                hashMap3.put(str3.replace("_end", ""), new JSONObject(entry.getValue().toString()));
                                edit.remove(str3);
                            } catch (JSONException e2) {
                                gsy.O000000o(6, "DeviceBindStatis", Log.getStackTraceString(e2));
                            }
                        }
                    }
                    for (Map.Entry entry2 : hashMap3.entrySet()) {
                        String str4 = (String) entry2.getKey();
                        JSONObject jSONObject = (JSONObject) hashMap2.get(str4);
                        JSONObject jSONObject2 = (JSONObject) entry2.getValue();
                        if (jSONObject2 == null) {
                            gsy.O000000o(i, "DeviceBindStatis", str4 + " endValue is null");
                            edit.remove(str4 + "_end");
                        } else if (jSONObject == null) {
                            gsy.O000000o(i, "DeviceBindStatis", str4 + " startTimeJson is null");
                            edit.remove(str4 + str);
                        } else if (jSONObject.length() == 1 && jSONObject2.length() == 1) {
                            htj.O000000o(str4, jSONObject.optLong(jSONObject.keys().next()), jSONObject2.optLong(jSONObject2.keys().next()));
                            edit.remove(str4 + str);
                        } else {
                            Iterator<String> keys = jSONObject2.keys();
                            ArrayList arrayList = new ArrayList();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                htj.O000000o(str4, jSONObject.optLong(next), jSONObject2.optLong(next));
                                arrayList.add(next);
                                str = str;
                            }
                            String str5 = str;
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                jSONObject.remove((String) it2.next());
                            }
                            if (jSONObject.length() == 0) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(str4);
                                str2 = str5;
                                sb.append(str2);
                                edit.remove(sb.toString());
                            } else {
                                str2 = str5;
                            }
                            str = str2;
                            i = 6;
                        }
                    }
                    String str6 = str;
                    for (Map.Entry entry3 : hashMap2.entrySet()) {
                        String str7 = (String) entry3.getKey();
                        JSONObject jSONObject3 = (JSONObject) entry3.getValue();
                        if (jSONObject3 == null) {
                            gsy.O000000o(6, "DeviceBindStatis", str7 + " startValue is null");
                            edit.remove(str7 + str6);
                        } else {
                            Iterator<String> keys2 = jSONObject3.keys();
                            ArrayList arrayList2 = new ArrayList();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                if (System.currentTimeMillis() - jSONObject3.optLong(next2) > 1800000) {
                                    hxi.O0000Oo.O000000o(str7, 2);
                                    gsy.O00000Oo("DeviceBindStatis", "adddevice_link_time_30min fail");
                                    arrayList2.add(next2);
                                }
                            }
                            Iterator it3 = arrayList2.iterator();
                            while (it3.hasNext()) {
                                jSONObject3.remove((String) it3.next());
                            }
                            if (jSONObject3.length() == 0) {
                                edit.remove(str7 + str6);
                            }
                        }
                    }
                    edit.apply();
                    return;
                }
                gsy.O00000Oo("DeviceBindStatis", "no connect statis collection");
            }
        });
    }

    public static void O000000o(String str, long j, long j2) {
        if (j2 == 0 || j == 0 || j2 <= j) {
            gsy.O000000o(6, "DeviceBindStatis", "startTime:" + j + " endTime:" + j2);
            return;
        }
        long j3 = j2 - j;
        if (j3 < 1800000) {
            hxi.O0000Oo.O000000o(str, 1);
            gsy.O00000Oo("DeviceBindStatis", "adddevice_link_time_30min success");
        } else {
            hxi.O0000Oo.O000000o(str, 2);
            gsy.O00000Oo("DeviceBindStatis", "adddevice_link_time_30min timeout");
        }
        hxt hxt = hxi.O0000Oo;
        int i = (int) (j3 / 1000);
        if (!flu.O00000oO().O00000Oo() && !gfr.f17662O000000o) {
            hxt.f960O000000o.O000000o("adddevice_link_all_time.AP", "model", str, "time", Integer.valueOf(i));
        }
    }
}
