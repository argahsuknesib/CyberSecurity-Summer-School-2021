package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleKeyValuePair;
import com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fgo {
    public static void O000000o(String str, String str2, String str3, String str4, final feo<String, fes> feo) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mac", str2);
            jSONObject.put("model", str3);
            jSONObject.put("token", str4);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("did", str);
            }
        } catch (JSONException unused) {
        }
        gnk.O00000o0(String.format("Apply did: [%s]", jSONObject));
        arrayList.add(new BleKeyValuePair("data", jSONObject.toString()));
        BleNetRequest.O000000o o000000o = new BleNetRequest.O000000o();
        o000000o.f6799O000000o = "POST";
        o000000o.O00000Oo = "/device/bltapplydid";
        o000000o.O00000o0 = arrayList;
        BleNetRequest O000000o2 = o000000o.O000000o();
        final AnonymousClass1 r4 = new feq<String>() {
            /* class _m_j.fgo.AnonymousClass1 */

            public final /* synthetic */ Object O000000o(JSONObject jSONObject) throws JSONException {
                gnk.O00000o0(String.format("Http Response: [%s]", jSONObject));
                return jSONObject.optString("did");
            }
        };
        fec.O00000o0().O000000o(O000000o2, new fer() {
            /* class _m_j.fgo.AnonymousClass12 */

            public final void O000000o(String str) {
                fet.O000000o().O000000o(str, r4, feo);
            }

            public final void O000000o(int i, String str) {
                feo feo = feo;
                if (feo != null) {
                    feo.O000000o(new fes(i, str));
                }
            }
        });
    }

    public static void O00000Oo(String str, String str2, String str3, String str4, final feo<Boolean, fes> feo) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("token", str3);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", "prop");
            jSONObject2.put("key", "bind_key");
            jSONObject2.put("value", str2);
            jSONArray.put(0, jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("type", "prop");
            jSONObject3.put("key", "smac");
            jSONObject3.put("value", str4);
            jSONArray.put(1, jSONObject3);
            jSONObject.put("props", jSONArray);
        } catch (JSONException unused) {
        }
        gnk.O00000o0(String.format("Bind did: [%s]", jSONObject));
        arrayList.add(new BleKeyValuePair("data", jSONObject.toString()));
        BleNetRequest.O000000o o000000o = new BleNetRequest.O000000o();
        o000000o.f6799O000000o = "POST";
        o000000o.O00000Oo = "/device/bltbind";
        o000000o.O00000o0 = arrayList;
        BleNetRequest O000000o2 = o000000o.O000000o();
        final AnonymousClass23 r10 = new feq<Boolean>() {
            /* class _m_j.fgo.AnonymousClass23 */

            public final /* synthetic */ Object O000000o(JSONObject jSONObject) throws JSONException {
                gnk.O00000o0(String.format("Http Response: [%S]", jSONObject));
                return Boolean.valueOf(jSONObject.optBoolean("result"));
            }
        };
        fec.O00000o0().O000000o(O000000o2, new fer() {
            /* class _m_j.fgo.AnonymousClass29 */

            public final void O000000o(String str) {
                fet.O000000o().O000000o(str, r10, feo);
            }

            public final void O000000o(int i, String str) {
                feo feo = feo;
                if (feo != null) {
                    feo.O000000o(new fes(i, str));
                }
            }
        });
    }

    public static void O000000o(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, String str10, String str11, String str12, feo<Boolean, fes> feo) {
        int i2 = i;
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mac", str);
            String str13 = str2;
            jSONObject.put("model", str2);
            String str14 = str3;
            jSONObject.put("token", str3);
            String str15 = str4;
            jSONObject.put("ltmk", str4);
            String str16 = str5;
            jSONObject.put("name", str5);
            String str17 = str6;
            jSONObject.put("device_cert", str6);
            String str18 = str7;
            jSONObject.put("manu_cert", str7);
            String str19 = str10;
            jSONObject.put("app_signature", str10);
            jSONObject.put("sign_data", str11);
            if (!TextUtils.isEmpty(str8)) {
                String str20 = str8;
                jSONObject.put("beacon_key", str8);
            }
            if (!TextUtils.isEmpty(str9)) {
                String str21 = str9;
                jSONObject.put("cloud_key", str9);
            }
            if (i2 != 0) {
                jSONObject.put("encrypt_type", i);
            }
            if (!TextUtils.isEmpty(str12)) {
                jSONObject.put("bindkey", str12);
            }
            jSONObject.put("props", new JSONArray());
        } catch (JSONException unused) {
        }
        arrayList.add(new BleKeyValuePair("data", jSONObject.toString()));
        BleNetRequest.O000000o o000000o = new BleNetRequest.O000000o();
        o000000o.f6799O000000o = "POST";
        o000000o.O00000Oo = "/device/blelockbind";
        o000000o.O00000o0 = arrayList;
        BleNetRequest O000000o2 = o000000o.O000000o();
        final AnonymousClass30 r1 = new feq<Boolean>() {
            /* class _m_j.fgo.AnonymousClass30 */

            public final /* synthetic */ Object O000000o(JSONObject jSONObject) throws JSONException {
                boolean z = true;
                gnk.O00000o0(String.format("Http Response: [%S]", jSONObject));
                if (!jSONObject.has("code")) {
                    return Boolean.FALSE;
                }
                if (jSONObject.getInt("code") != 0) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        };
        final feo<Boolean, fes> feo2 = feo;
        fec.O00000o0().O000000o(O000000o2, new fer() {
            /* class _m_j.fgo.AnonymousClass31 */

            public final void O000000o(String str) {
                fet.O000000o().O000000o(str, r1, feo2);
            }

            public final void O000000o(int i, String str) {
                feo feo = feo2;
                if (feo != null) {
                    feo.O000000o(new fes(i, str));
                }
            }
        });
    }

    public static void O000000o(final String str, final int i, final feo<Boolean, fes> feo) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("pid", i);
        } catch (JSONException unused) {
        }
        jSONArray.put(jSONObject);
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("devList", jSONArray);
        } catch (JSONException unused2) {
        }
        arrayList.add(new BleKeyValuePair("data", jSONObject2.toString()));
        BleNetRequest.O000000o o000000o = new BleNetRequest.O000000o();
        o000000o.f6799O000000o = "POST";
        o000000o.O00000Oo = "/user/del_owner_device_batch";
        o000000o.O00000o0 = arrayList;
        fec.O00000o0().O000000o(o000000o.O000000o(), new fer() {
            /* class _m_j.fgo.AnonymousClass32 */

            public final void O000000o(String str) {
                JSONObject optJSONObject;
                gnk.O000000o("unbindDevice (did=%s, pid=%d), onSuccess, response=%s", str, Integer.valueOf(i), str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("code", -1) == 0 && (optJSONObject = jSONObject.optJSONObject("result")) != null && optJSONObject.has(str)) {
                        if (feo != null) {
                            feo.O000000o(Boolean.TRUE);
                            return;
                        }
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                feo feo = feo;
                if (feo != null) {
                    feo.O000000o(Boolean.FALSE);
                }
            }

            public final void O000000o(int i, String str) {
                gnk.O000000o("unbindDevice (did=%s, pid=%d), onFailure, errorCode=%d, detail=%s", str, Integer.valueOf(i), Integer.valueOf(i), str);
                feo feo = feo;
                if (feo != null) {
                    feo.O000000o(new fes(i, str));
                }
            }
        });
    }

    public static void O00000Oo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, String str10, String str11, String str12, feo<JSONObject, fes> feo) {
        int i2 = i;
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mac", str);
            String str13 = str2;
            jSONObject.put("model", str2);
            String str14 = str3;
            jSONObject.put("token", str3);
            String str15 = str4;
            jSONObject.put("ltmk", str4);
            String str16 = str5;
            jSONObject.put("name", str5);
            String str17 = str6;
            jSONObject.put("device_cert", str6);
            String str18 = str7;
            jSONObject.put("manu_cert", str7);
            String str19 = str10;
            jSONObject.put("app_signature", str10);
            jSONObject.put("sign_data", str11);
            if (!TextUtils.isEmpty(str8)) {
                String str20 = str8;
                jSONObject.put("beacon_key", str8);
            }
            if (!TextUtils.isEmpty(str9)) {
                String str21 = str9;
                jSONObject.put("cloud_key", str9);
            }
            if (i2 != 0) {
                jSONObject.put("encrypt_type", i);
            }
            if (!TextUtils.isEmpty(str12)) {
                jSONObject.put("bindkey", str12);
            }
            jSONObject.put("props", new JSONArray());
        } catch (JSONException unused) {
        }
        arrayList.add(new BleKeyValuePair("data", jSONObject.toString()));
        BleNetRequest.O000000o o000000o = new BleNetRequest.O000000o();
        o000000o.f6799O000000o = "POST";
        o000000o.O00000Oo = "/v2/device/ble_secure_bind";
        o000000o.O00000o0 = arrayList;
        BleNetRequest O000000o2 = o000000o.O000000o();
        final AnonymousClass33 r1 = new feq<JSONObject>() {
            /* class _m_j.fgo.AnonymousClass33 */

            public final /* synthetic */ Object O000000o(JSONObject jSONObject) throws JSONException {
                gnk.O00000o0(String.format("Http Response: [%S]", jSONObject));
                return jSONObject;
            }
        };
        final feo<JSONObject, fes> feo2 = feo;
        fec.O00000o0().O000000o(O000000o2, new fer() {
            /* class _m_j.fgo.AnonymousClass34 */

            public final void O000000o(String str) {
                fet.O000000o().O000000o(str, r1, feo2);
            }

            public final void O000000o(int i, String str) {
                feo feo = feo2;
                if (feo != null) {
                    feo.O000000o(new fes(i, str));
                }
            }
        });
    }

    public static void O000000o(String str, feo<JSONObject, fes> feo) {
        O000000o("own", str, "0", feo);
    }

    public static void O000000o(String str, String str2, String str3, final feo<JSONObject, fes> feo) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", str);
            jSONObject.put("did", str2);
            long j = 0;
            try {
                j = Long.valueOf(str3).longValue();
            } catch (Exception unused) {
            }
            jSONObject.put("keyid", j);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new BleKeyValuePair("data", jSONObject.toString()));
        gnk.O00000o0(String.format("askSecurityShareKey: [%s]", jSONObject));
        BleNetRequest.O000000o o000000o = new BleNetRequest.O000000o();
        o000000o.f6799O000000o = "POST";
        o000000o.O00000Oo = "/share/askbluetoothkey";
        o000000o.O00000o0 = arrayList;
        BleNetRequest O000000o2 = o000000o.O000000o();
        final AnonymousClass2 r4 = new feq<JSONObject>() {
            /* class _m_j.fgo.AnonymousClass2 */

            public final /* synthetic */ Object O000000o(JSONObject jSONObject) throws JSONException {
                gnk.O00000o0(String.format("Http Response: [%S]", jSONObject));
                return jSONObject;
            }
        };
        fec.O00000o0().O000000o(O000000o2, new fer() {
            /* class _m_j.fgo.AnonymousClass3 */

            public final void O000000o(String str) {
                fet.O000000o().O000000o(str, r4, feo);
            }

            public final void O000000o(int i, String str) {
                feo feo = feo;
                if (feo != null) {
                    feo.O000000o(new fes(i, str));
                }
            }
        });
    }

    public static void O00000o0(String str, String str2, String str3, String str4, final feo<String, fes> feo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", str2);
            jSONObject2.put("key", str3);
            jSONObject2.put("value", str4);
            jSONArray.put(jSONObject2);
            jSONObject.put("datas", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BleKeyValuePair("data", jSONObject.toString()));
        gnk.O00000o0(String.format("reportDeviceEvent: [%s]", jSONObject));
        BleNetRequest.O000000o o000000o = new BleNetRequest.O000000o();
        o000000o.f6799O000000o = "POST";
        o000000o.O00000Oo = "/device/event";
        o000000o.O00000o0 = arrayList;
        fec.O00000o0().O000000o(o000000o.O000000o(), new fer() {
            /* class _m_j.fgo.AnonymousClass4 */

            public final void O000000o(String str) {
                feo feo = feo;
                if (feo != null) {
                    feo.O000000o("");
                }
            }

            public final void O000000o(int i, String str) {
                feo feo = feo;
                if (feo != null) {
                    feo.O000000o(new fes(i, str));
                }
            }
        });
    }

    public static void O000000o(final feo<Long, fes> feo) {
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BleKeyValuePair("data", jSONObject.toString()));
        BleNetRequest.O000000o o000000o = new BleNetRequest.O000000o();
        o000000o.f6799O000000o = "POST";
        o000000o.O00000Oo = "/device/get_utc_time";
        o000000o.O00000o0 = arrayList;
        BleNetRequest O000000o2 = o000000o.O000000o();
        final AnonymousClass5 r1 = new feq<Long>() {
            /* class _m_j.fgo.AnonymousClass5 */

            public final /* synthetic */ Object O000000o(JSONObject jSONObject) throws JSONException {
                gnk.O00000o0(String.format("Http Response: [%S]", jSONObject));
                return Long.valueOf(jSONObject.optLong("result", -1));
            }
        };
        fec.O00000o0().O000000o(O000000o2, new fer() {
            /* class _m_j.fgo.AnonymousClass6 */

            public final void O000000o(String str) {
                fet.O000000o().O000000o(str, r1, feo);
            }

            public final void O000000o(int i, String str) {
                feo feo = feo;
                if (feo != null) {
                    feo.O000000o(new fes(i, str));
                }
            }
        });
    }

    public static void O000000o(String str, String str2, String str3, String str4, String str5, String str6, final feo<Void, fes> feo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("fw_ver", str2);
            jSONObject.put("hw_ver", str3);
            jSONObject.put("latitude", str4);
            jSONObject.put("longitude", str5);
            jSONObject.put("iternetip", str6);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BleKeyValuePair("data", jSONObject.toString()));
        gnk.O00000o0(String.format("reportBleMeshDevInfo: [%s]", jSONObject));
        BleNetRequest.O000000o o000000o = new BleNetRequest.O000000o();
        o000000o.f6799O000000o = "POST";
        o000000o.O00000Oo = "/v2/blemesh/dev_info";
        o000000o.O00000o0 = arrayList;
        fec.O00000o0().O000000o(o000000o.O000000o(), new fer() {
            /* class _m_j.fgo.AnonymousClass18 */

            public final void O000000o(String str) {
                feo feo = feo;
                if (feo != null) {
                    feo.O000000o((Object) null);
                }
            }

            public final void O000000o(int i, String str) {
                feo feo = feo;
                if (feo != null) {
                    feo.O000000o(new fes(i, str));
                }
            }
        });
    }

    public static void O000000o(final String str, final String str2, final feo<Void, fes> feo) {
        fea.O000000o(str, new BleResponse<String>() {
            /* class _m_j.fgo.AnonymousClass19 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                String str = (String) obj;
                if (i != 0 || TextUtils.isEmpty(str)) {
                    feo feo = feo;
                    if (feo != null) {
                        feo.O000000o(new fes(-1, "read version failed"));
                        return;
                    }
                    return;
                }
                fgm.O000000o(str, str2, str);
                fgo.O000000o(str2, str, "", "", "", "", new feo<Void, fes>() {
                    /* class _m_j.fgo.AnonymousClass19.AnonymousClass1 */

                    public final void O000000o(fes fes) {
                        if (feo != null) {
                            feo.O000000o(fes);
                        }
                    }

                    public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                        if (feo != null) {
                            feo.O000000o((Object) null);
                        }
                    }
                });
            }
        });
    }

    public static void O000000o(String str, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("show_secure_pin", z ? "1" : "0");
            jSONObject.put("extra_data", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BleKeyValuePair("data", jSONObject.toString()));
        BleNetRequest.O000000o o000000o = new BleNetRequest.O000000o();
        o000000o.f6799O000000o = "POST";
        o000000o.O00000Oo = "/v2/device/set_extra_data";
        o000000o.O00000o0 = arrayList;
        BleNetRequest O000000o2 = o000000o.O000000o();
        gnk.O00000o0(String.format("setShowSecurePin: [%s]", jSONObject));
        fec.O00000o0().O000000o(O000000o2, new fer() {
            /* class _m_j.fgo.AnonymousClass22 */

            public final void O000000o(int i, String str) {
            }

            public final void O000000o(String str) {
                gnk.O00000o0(String.format("setShowSecurePin response: [%s]", str));
            }
        });
    }

    public static void O00000Oo(String str, String str2, feo<Void, fes> feo) {
        O000000o(new fcp(str, str2), feo);
    }

    public static void O000000o(fcp fcp, final feo<Void, fes> feo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", fcp.f16086O000000o);
            if (!TextUtils.isEmpty(fcp.O00000Oo)) {
                jSONObject.put("fw_ver", fcp.O00000Oo);
            }
            if (!TextUtils.isEmpty(fcp.O00000o0)) {
                jSONObject.put("mcu_ver", fcp.O00000o0);
            }
            if (!TextUtils.isEmpty(fcp.O00000o)) {
                jSONObject.put("sn", fcp.O00000o);
            }
            if (!TextUtils.isEmpty(fcp.O00000oO)) {
                jSONObject.put("hw_ver", fcp.O00000oO);
            }
            if (!TextUtils.isEmpty(fcp.O00000oo)) {
                jSONObject.put("latitude", fcp.O00000oo);
            }
            if (!TextUtils.isEmpty(fcp.O0000O0o)) {
                jSONObject.put("longitude", fcp.O0000O0o);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BleKeyValuePair("data", jSONObject.toString()));
        gnk.O00000o0(String.format("reportCommonBleVersion: [%s]", jSONObject));
        BleNetRequest.O000000o o000000o = new BleNetRequest.O000000o();
        o000000o.f6799O000000o = "POST";
        o000000o.O00000Oo = "/v2/device/bledevice_info";
        o000000o.O00000o0 = arrayList;
        fec.O00000o0().O000000o(o000000o.O000000o(), new fer() {
            /* class _m_j.fgo.AnonymousClass24 */

            public final void O000000o(String str) {
                feo feo = feo;
                if (feo != null) {
                    feo.O000000o((Object) null);
                }
            }

            public final void O000000o(int i, String str) {
                feo feo = feo;
                if (feo != null) {
                    feo.O000000o(new fes(i, str));
                }
            }
        });
    }
}
