package com.xiaomi.smarthome.frame.plugin.runtime.activity;

import _m_j.ba;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fsp;
import _m_j.fss;
import _m_j.fte;
import _m_j.gnk;
import _m_j.gsy;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class LockSecurePinUtil {
    public static void checkSecurePinChanged(Activity activity, String str, final String str2) {
        getShowSecurePin(activity.getApplicationContext(), str, new fsm<Boolean, fso>() {
            /* class com.xiaomi.smarthome.frame.plugin.runtime.activity.LockSecurePinUtil.AnonymousClass1 */

            public final void onFailure(fso fso) {
            }

            public final void onSuccess(Boolean bool) {
                LockSecurePinUtil.setPropShowPincode(str2, bool.booleanValue());
            }
        });
    }

    public static void checkSecurePinChangedV2(Activity activity, String str, final String str2, final ba<Void> baVar) {
        getShowSecurePin(activity.getApplicationContext(), str, new fsm<Boolean, fso>() {
            /* class com.xiaomi.smarthome.frame.plugin.runtime.activity.LockSecurePinUtil.AnonymousClass2 */

            public final void onSuccess(Boolean bool) {
                LockSecurePinUtil.setPropShowPincode(str2, bool.booleanValue());
                baVar.accept(null);
            }

            public final void onFailure(fso fso) {
                baVar.accept(null);
            }
        });
    }

    public static void checkLtmkChangedV2(Activity activity, String str, String str2, boolean z, ba<Void> baVar) {
        Context context;
        if (activity != null) {
            context = activity.getApplicationContext();
        } else {
            context = CommonApplication.getAppContext();
        }
        final String str3 = str2;
        final Activity activity2 = activity;
        final boolean z2 = z;
        final String str4 = str;
        final ba<Void> baVar2 = baVar;
        getEncryptLtmk(context, str, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.frame.plugin.runtime.activity.LockSecurePinUtil.AnonymousClass3 */

            public final void onSuccess(JSONObject jSONObject) {
                int i;
                String str;
                if (jSONObject != null) {
                    str = jSONObject.optString("key");
                    i = jSONObject.optInt("encrypt_type");
                } else {
                    i = 0;
                    str = "";
                }
                if (!TextUtils.isEmpty(str)) {
                    String propLtmk = LockSecurePinUtil.getPropLtmk(str3);
                    if (LockSecurePinUtil.getEncryptType(str3) != i) {
                        LockSecurePinUtil.setPropLtmkEncryptType(str3, i);
                    }
                    String propPincode = LockSecurePinUtil.getPropPincode(str3);
                    if (!TextUtils.equals(propLtmk, str) || TextUtils.isEmpty(propPincode)) {
                        gsy.O00000o0(LogType.BLUETOOTH, "LockSecurePinUtil", "checkLtmkChangedV2, local ltmk not equal encrypt ltmk, will clear PIN-CODE");
                        LockSecurePinUtil.setPropPincode(str3, "");
                        LockSecurePinUtil.setPropLtmk(str3, str);
                        if (i != 0) {
                            boolean propShowPincode = LockSecurePinUtil.getPropShowPincode(str3);
                            Activity activity = activity2;
                            if (activity != null && !activity.isFinishing() && !z2 && !propShowPincode) {
                                Bundle bundle = new Bundle();
                                bundle.putString("extra_device_did", str4);
                                fsp.O000000o().O0000Oo.openVerfyPincode(activity2, bundle, 9999);
                            }
                        }
                    }
                }
                ba baVar = baVar2;
                if (baVar != null) {
                    baVar.accept(null);
                }
            }

            public final void onFailure(fso fso) {
                ba baVar = baVar2;
                if (baVar != null) {
                    baVar.accept(null);
                }
            }
        });
    }

    public static void checkLtmkChanged(final Activity activity, final String str, final String str2, final boolean z) {
        getEncryptLtmk(activity.getApplicationContext(), str, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.frame.plugin.runtime.activity.LockSecurePinUtil.AnonymousClass4 */

            public final void onFailure(fso fso) {
            }

            public final void onSuccess(JSONObject jSONObject) {
                int i;
                String str;
                if (jSONObject != null) {
                    str = jSONObject.optString("key");
                    i = jSONObject.optInt("encrypt_type");
                } else {
                    i = 0;
                    str = "";
                }
                if (!TextUtils.isEmpty(str)) {
                    String propLtmk = LockSecurePinUtil.getPropLtmk(str2);
                    if (LockSecurePinUtil.getEncryptType(str2) != i) {
                        LockSecurePinUtil.setPropLtmkEncryptType(str2, i);
                    }
                    if (!TextUtils.equals(propLtmk, str)) {
                        gsy.O00000o0(LogType.BLUETOOTH, "LockSecurePinUtil", "checkLtmkChanged, local ltmk not equal encrypt ltmk, will clear PIN-CODE");
                        LockSecurePinUtil.setPropPincode(str2, "");
                        LockSecurePinUtil.setPropLtmk(str2, str);
                        if (i != 0 && !activity.isFinishing() && !z) {
                            Bundle bundle = new Bundle();
                            bundle.putString("extra_device_did", str);
                            fsp.O000000o().O0000Oo.openVerfyPincode(activity, bundle, 9999);
                        }
                    }
                }
            }
        });
    }

    private static void getShowSecurePin(Context context, String str, fsm<Boolean, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("show_secure_pin");
            jSONObject.put("keys", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        gnk.O00000o0(String.format("getShowSecurePin: [%s]", jSONObject));
        Context context2 = context;
        CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/device/get_extra_data").O000000o(arrayList).O000000o(), new fss<Boolean>() {
            /* class com.xiaomi.smarthome.frame.plugin.runtime.activity.LockSecurePinUtil.AnonymousClass5 */

            public final Boolean parse(JSONObject jSONObject) throws JSONException {
                String str;
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    str = optJSONObject.optString("show_secure_pin", "1");
                } else {
                    str = "1";
                }
                return Boolean.valueOf(TextUtils.equals(str, "1"));
            }
        }, Crypto.RC4, fsm);
    }

    private static void getEncryptLtmk(Context context, String str, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "own");
            jSONObject.put("did", str);
            jSONObject.put("keyid", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        gnk.O00000o0(String.format("getEncryptLtmk: [%s]", jSONObject));
        Context context2 = context;
        CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O000000o("POST").O00000Oo("/share/askbluetoothkey").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class com.xiaomi.smarthome.frame.plugin.runtime.activity.LockSecurePinUtil.AnonymousClass6 */

            public final JSONObject parse(JSONObject jSONObject) throws JSONException {
                gnk.O00000o0(String.format("Http Response: [%S]", jSONObject));
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public static String getPropLtmk(String str) {
        Bundle bundle = new Bundle();
        CoreApi.O000000o().O000000o(str, 19, bundle);
        return bundle.getString("extra.result", "");
    }

    public static int getEncryptType(String str) {
        Bundle bundle = new Bundle();
        CoreApi.O000000o().O000000o(str, 22, bundle);
        return bundle.getInt("extra.result", 0);
    }

    public static void setPropLtmk(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            fte.O00000Oo(String.format("setPropLtmk mac null", new Object[0]));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extra.value", str2);
        CoreApi.O000000o().O00000Oo(str, 19, bundle);
    }

    public static String getPropPincode(String str) {
        Bundle bundle = new Bundle();
        CoreApi.O000000o().O000000o(str, 21, bundle);
        return bundle.getString("extra.result", "");
    }

    public static void setPropPincode(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            fte.O00000Oo(String.format("setPropPincode mac null", new Object[0]));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extra.value", str2);
        CoreApi.O000000o().O00000Oo(str, 21, bundle);
    }

    public static void setPropLtmkEncryptType(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            fte.O00000Oo(String.format("setPropLtmkEncryptType mac null", new Object[0]));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("extra.value", i);
        CoreApi.O000000o().O00000Oo(str, 22, bundle);
    }

    public static boolean getPropShowPincode(String str) {
        Bundle bundle = new Bundle();
        CoreApi.O000000o().O000000o(str, 23, bundle);
        return bundle.getBoolean("extra.result", true);
    }

    public static void setPropShowPincode(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            fte.O00000Oo(String.format("setPropShowPincode mac null", new Object[0]));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("extra.value", z);
        CoreApi.O000000o().O00000Oo(str, 23, bundle);
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
