package com.xiaomi.smarthome.device.api;

import _m_j.fsm;
import _m_j.fsn;
import _m_j.fso;
import _m_j.fss;
import _m_j.gog;
import _m_j.gsy;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FDDeviceApi {
    private static volatile FDDeviceApi sInstance;
    private static final Object sLock = new Object();

    private FDDeviceApi() {
    }

    public static FDDeviceApi getInstance() {
        if (sInstance == null) {
            synchronized (sLock) {
                if (sInstance == null) {
                    sInstance = new FDDeviceApi();
                }
            }
        }
        return sInstance;
    }

    public fsn getWhiteDeveloperCompanyInfo(Context context, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", new JSONObject().toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/developer/get_whitelist").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class com.xiaomi.smarthome.device.api.FDDeviceApi.AnonymousClass1 */

            public JSONObject parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public fsn getSubDevice(Context context, String[] strArr, fsm<List<Device>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        if (strArr != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (String put : strArr) {
                    jSONArray.put(put);
                }
                jSONObject.put("dids", jSONArray);
            } catch (JSONException unused) {
            }
        }
        String O00000Oo = gog.O00000Oo(context);
        if (!TextUtils.isEmpty(O00000Oo)) {
            jSONObject.put("uid", O00000Oo.toUpperCase());
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/sub_device_list").O000000o(arrayList).O000000o(), new fss<List<Device>>() {
            /* class com.xiaomi.smarthome.device.api.FDDeviceApi.AnonymousClass2 */

            public List<Device> parse(JSONObject jSONObject) throws JSONException {
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (optJSONArray == null) {
                    return arrayList;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    Device O000000o2 = DeviceFactory.O000000o(optJSONArray.getJSONObject(i));
                    if (O000000o2 != null) {
                        arrayList.add(O000000o2);
                    }
                }
                return arrayList;
            }
        }, Crypto.RC4, fsm);
    }

    public fsn getDeviceDetail(Context context, String[] strArr, final fsm<List<Device>, fso> fsm) {
        JSONObject jSONObject = new JSONObject();
        if (strArr != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (String put : strArr) {
                    jSONArray.put(put);
                }
                jSONObject.put("dids", jSONArray);
            } catch (JSONException unused) {
            }
        }
        String O00000o0 = gog.O00000o0(context);
        String O00000Oo = gog.O00000Oo(context);
        if (!TextUtils.isEmpty(O00000o0) && !TextUtils.isEmpty(O00000Oo) && !TextUtils.equals(O00000Oo, "02:00:00:00:00:00")) {
            jSONObject.put("ssid", O00000o0);
            jSONObject.put("bssid", O00000Oo.toUpperCase());
        }
        return updateDeviceList(context, jSONObject, new fsm<ArrayList<Device>, fso>() {
            /* class com.xiaomi.smarthome.device.api.FDDeviceApi.AnonymousClass3 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((ArrayList<Device>) ((ArrayList) obj));
            }

            public void onSuccess(ArrayList<Device> arrayList) {
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onSuccess(arrayList);
                }
            }

            public void onFailure(fso fso) {
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onFailure(fso);
                }
            }
        });
    }

    public fsn updateDeviceList(Context context, JSONObject jSONObject, fsm<ArrayList<Device>, fso> fsm) {
        final AnonymousClass4 r4 = new fss<JSONObject>() {
            /* class com.xiaomi.smarthome.device.api.FDDeviceApi.AnonymousClass4 */

            public JSONObject parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        };
        final Context context2 = context;
        final JSONObject jSONObject2 = jSONObject;
        final fsm<ArrayList<Device>, fso> fsm2 = fsm;
        return new fsn(new fsn.O00000Oo() {
            /* class com.xiaomi.smarthome.device.api.FDDeviceApi.AnonymousClass5 */
            public boolean mCancel = false;
            public fsn mCurrentHandle = CoreApi.O000000o().O000000o(context2, FDDeviceApi.this.getNetRequest("/v2/home/device_list_page", jSONObject2), r4, Crypto.RC4, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.device.api.FDDeviceApi.AnonymousClass5.AnonymousClass1 */
                private ArrayList<Device> result = new ArrayList<>();

                public void onSuccess(JSONObject jSONObject) {
                    if (!AnonymousClass5.this.mCancel) {
                        if (jSONObject != null) {
                            try {
                                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                                if (optJSONArray != null) {
                                    for (int i = 0; i < optJSONArray.length(); i++) {
                                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                        if (optJSONObject != null) {
                                            this.result.add(DeviceFactory.O000000o(optJSONObject));
                                        }
                                    }
                                }
                                if (jSONObject.optBoolean("has_more")) {
                                    String optString = jSONObject.optString("next_start_did");
                                    gsy.O00000Oo("FDDeviceApi", "/home/device_list_new request next page with did:".concat(String.valueOf(optString)));
                                    jSONObject2.put("start_did", optString);
                                    AnonymousClass5.this.mCurrentHandle = CoreApi.O000000o().O000000o(context2, FDDeviceApi.this.getNetRequest("/v2/home/device_list_page", jSONObject2), r4, Crypto.RC4, this);
                                    return;
                                }
                                gsy.O00000Oo("FDDeviceApi", "/home/device_list_response success times:" + this.result.size());
                                if (fsm2 != null) {
                                    fsm2.onSuccess(this.result);
                                }
                            } catch (JSONException e) {
                                gsy.O00000Oo("FDDeviceApi", "/home/device_list_response JSONException times:" + this.result.size());
                                if (fsm2 != null) {
                                    fsm2.onFailure(new fso(-1, Log.getStackTraceString(e)));
                                }
                            }
                        } else {
                            gsy.O00000Oo("FDDeviceApi", "/home/device_list_response resultObject null times:" + this.result.size());
                            if (fsm2 != null) {
                                fsm2.onSuccess(this.result);
                            }
                        }
                    }
                }

                public void onFailure(fso fso) {
                    gsy.O00000Oo("FDDeviceApi", "/home/device_list_response onFailure times:" + this.result.size());
                    if (fsm2 != null) {
                        fsm2.onFailure(fso);
                    }
                }
            });
            final String url = "/v2/home/device_list_page";

            public void cancel() {
                this.mCancel = true;
                fsn fsn = this.mCurrentHandle;
                if (fsn != null) {
                    fsn.cancel();
                }
            }
        });
    }

    public NetRequest getNetRequest(String str, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return new NetRequest.O000000o().O000000o("POST").O00000Oo(str).O000000o(arrayList).O000000o();
    }

    public fsn verifyQrcode(Context context, String str, String str2, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("qrcode", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("model", str2);
            }
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/device/verify_qrcode").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class com.xiaomi.smarthome.device.api.FDDeviceApi.AnonymousClass6 */

            public JSONObject parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public fsn verifyQrcodeNew(Context context, String str, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bind_key", str);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/bind_with_bindkey").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class com.xiaomi.smarthome.device.api.FDDeviceApi.AnonymousClass7 */

            public JSONObject parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }
}
