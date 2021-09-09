package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fup {

    /* renamed from: O000000o  reason: collision with root package name */
    public static TreeMap<Long, fum> f17194O000000o = new TreeMap<>();

    public static void O000000o(Device device, JSONArray jSONArray, fum fum) {
        JSONArray jSONArray2;
        if (device != null && fum != null) {
            JSONArray jSONArray3 = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("maketime", fum.f17191O000000o);
                jSONObject.put("starttime", fum.O00000Oo);
                jSONObject.put("expiretime", fum.O00000o0);
                jSONObject.put("password", fum.O00000o);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jSONArray == null || jSONArray.length() == 0) {
                jSONArray3.put(jSONObject);
            } else {
                int i = 0;
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(0);
                    if (jSONObject2 != null) {
                        String optString = jSONObject2.optString("value", "");
                        if (!TextUtils.isEmpty(optString)) {
                            jSONArray3 = new JSONArray(optString);
                        }
                        if (jSONArray3.length() >= 0) {
                            while (i < jSONArray3.length()) {
                                JSONObject jSONObject3 = jSONArray3.getJSONObject(i);
                                long optLong = jSONObject3.optLong("expiretime");
                                if (optLong <= fum.f17191O000000o) {
                                    jSONArray3.remove(i);
                                    i--;
                                } else {
                                    String optString2 = jSONObject3.optString("password");
                                    if (!TextUtils.isEmpty(optString2) && optString2.length() <= 8) {
                                        jSONObject3.put("password", O000000o(optString2, String.valueOf(optLong), device.mac, device.userId));
                                    }
                                }
                                i++;
                            }
                            jSONArray2 = jSONArray3;
                        } else {
                            jSONArray2 = new JSONArray();
                        }
                        try {
                            jSONArray2.put(jSONObject);
                            jSONArray3 = jSONArray2;
                        } catch (JSONException e2) {
                            jSONArray3 = jSONArray2;
                            e = e2;
                            e.printStackTrace();
                            XmPluginHostApi.instance().setUserDeviceData(device.model, device.did, "prop", "device_lock", fum.f17191O000000o, jSONArray3, new Callback<JSONArray>() {
                                /* class _m_j.fup.AnonymousClass1 */

                                public final void onFailure(int i, String str) {
                                    gsy.O000000o(6, "OneTimePwdManager", "onFailure, upload onetime pwd failed, error = " + i + ", msg = " + str);
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    gsy.O000000o(6, "OneTimePwdManager", " upload onetime pwd successfully.");
                                }
                            });
                        }
                    }
                } catch (JSONException e3) {
                    e = e3;
                    e.printStackTrace();
                    XmPluginHostApi.instance().setUserDeviceData(device.model, device.did, "prop", "device_lock", fum.f17191O000000o, jSONArray3, new Callback<JSONArray>() {
                        /* class _m_j.fup.AnonymousClass1 */

                        public final void onFailure(int i, String str) {
                            gsy.O000000o(6, "OneTimePwdManager", "onFailure, upload onetime pwd failed, error = " + i + ", msg = " + str);
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            gsy.O000000o(6, "OneTimePwdManager", " upload onetime pwd successfully.");
                        }
                    });
                }
            }
            XmPluginHostApi.instance().setUserDeviceData(device.model, device.did, "prop", "device_lock", fum.f17191O000000o, jSONArray3, new Callback<JSONArray>() {
                /* class _m_j.fup.AnonymousClass1 */

                public final void onFailure(int i, String str) {
                    gsy.O000000o(6, "OneTimePwdManager", "onFailure, upload onetime pwd failed, error = " + i + ", msg = " + str);
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    gsy.O000000o(6, "OneTimePwdManager", " upload onetime pwd successfully.");
                }
            });
        }
    }

    public static TreeMap<Long, fum> O000000o(Device device, JSONArray jSONArray, long j) {
        Device device2 = device;
        JSONArray jSONArray2 = jSONArray;
        TreeMap<Long, fum> treeMap = new TreeMap<>();
        if (jSONArray2 == null) {
            return treeMap;
        }
        try {
            JSONObject jSONObject = jSONArray2.getJSONObject(0);
            if (jSONObject != null) {
                String optString = jSONObject.optString("value", "");
                if (TextUtils.isEmpty(optString)) {
                    return treeMap;
                }
                JSONArray jSONArray3 = new JSONArray(optString);
                if (jSONArray3.length() == 0) {
                    return treeMap;
                }
                for (int i = 0; i < jSONArray3.length(); i++) {
                    JSONObject jSONObject2 = jSONArray3.getJSONObject(i);
                    long optLong = jSONObject2.optLong("maketime", -1);
                    if (optLong < 0) {
                        optLong = jSONObject2.optLong("time", -1);
                    }
                    long optLong2 = jSONObject2.optLong("starttime");
                    long optLong3 = jSONObject2.optLong("expiretime");
                    String optString2 = jSONObject2.optString("password");
                    if (optLong3 >= j) {
                        if (device2 != null && optString2.length() <= 8) {
                            optString2 = O000000o(optString2, String.valueOf(optLong3), device2.mac, device2.userId);
                        }
                        treeMap.put(Long.valueOf(optLong), new fum(optLong, optLong2, optLong3, optString2));
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return treeMap;
    }

    public static String O000000o(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        sb.append(fku.O000000o(str.getBytes()));
        if (str2 == null) {
            str2 = "";
        }
        sb.append(fku.O000000o(str2.getBytes()));
        if (str3 == null) {
            str3 = "";
        }
        sb.append(str3.replace(":", ""));
        if (str4 == null) {
            str4 = "";
        }
        sb.append(fku.O000000o(str4.getBytes()));
        try {
            String O000000o2 = fku.O000000o(MessageDigest.getInstance("SHA-256").digest(sb.toString().getBytes()));
            return O000000o2.substring(2, O000000o2.length() - 2);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
