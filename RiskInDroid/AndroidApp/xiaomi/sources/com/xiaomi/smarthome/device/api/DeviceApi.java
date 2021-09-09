package com.xiaomi.smarthome.device.api;

import _m_j.fnq;
import _m_j.fsm;
import _m_j.fsn;
import _m_j.fso;
import _m_j.fss;
import _m_j.gog;
import _m_j.gpn;
import _m_j.gsy;
import _m_j.gvi;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.multikey.PowerMultikeyBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceApi {
    private static volatile DeviceApi sInstance;
    private static final Object sLock = new Object();

    private DeviceApi() {
    }

    public static DeviceApi getInstance() {
        if (sInstance == null) {
            synchronized (sLock) {
                if (sInstance == null) {
                    sInstance = new DeviceApi();
                }
            }
        }
        return sInstance;
    }

    public fsn getModelGroupInfoJson(Context context, fsm<String, fso> fsm) {
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/virtualdevicedef").O000000o(), new fss<String>() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass1 */

            public String parse(JSONObject jSONObject) throws JSONException {
                if (jSONObject == null) {
                    return null;
                }
                return jSONObject.toString();
            }
        }, Crypto.RC4, fsm);
    }

    public fsn createModelGroup(Context context, String[] strArr, String str, fsm<Device, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "create");
            jSONObject.put("name", str);
            JSONArray jSONArray = new JSONArray();
            for (String put : strArr) {
                jSONArray.put(put);
            }
            jSONObject.put("memberDids", jSONArray);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/virtualdevicectr").O000000o(arrayList).O000000o(), new fss<Device>() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass2 */

            public Device parse(JSONObject jSONObject) throws JSONException {
                Device O000000o2 = DeviceFactory.O000000o(jSONObject);
                O000000o2.setOwner(true);
                return O000000o2;
            }
        }, Crypto.RC4, fsm);
    }

    public fsn deleteModelGroup(Context context, String str, fsm<String, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "del");
            jSONObject.put("masterDid", str);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/virtualdevicectr").O000000o(arrayList).O000000o(), new fss<String>() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass3 */

            public String parse(JSONObject jSONObject) throws JSONException {
                return jSONObject.toString();
            }
        }, Crypto.RC4, fsm);
    }

    public fsn getVirtualDeviceInfoById(Context context, String str, fsm<fnq, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "get");
            jSONObject.put("masterDid", str);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/virtualdevicectr").O000000o(arrayList).O000000o(), new fss<fnq>() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass4 */

            public fnq parse(JSONObject jSONObject) throws JSONException {
                fnq fnq = new fnq();
                fnq.f16711O000000o = jSONObject.optString("did");
                fnq.O00000o = jSONObject.optInt("pid");
                fnq.O00000o0 = jSONObject.optString("model");
                fnq.O00000Oo = jSONObject.optString("name");
                JSONArray optJSONArray = jSONObject.optJSONArray("members");
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    fnq.O00000oO = null;
                } else {
                    fnq.O00000oO = new String[optJSONArray.length()];
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        fnq.O00000oO[i] = optJSONArray.getJSONObject(i).toString();
                    }
                }
                return fnq;
            }
        }, Crypto.RC4, fsm);
    }

    public fsn modifyModelGroup(Context context, String[] strArr, String str, String str2, fsm<String, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "mod");
            jSONObject.put("name", str2);
            jSONObject.put("masterDid", str);
            JSONArray jSONArray = new JSONArray();
            for (String put : strArr) {
                jSONArray.put(put);
            }
            jSONObject.put("memberDids", jSONArray);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/virtualdevicectr").O000000o(arrayList).O000000o(), new fss<String>() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass5 */

            public String parse(JSONObject jSONObject) throws JSONException {
                if (jSONObject != null) {
                    return jSONObject.toString();
                }
                return null;
            }
        }, Crypto.RC4, fsm);
    }

    public fsn createVirtalDevice(Context context, String str, String str2, fsm<Device, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "create");
            if (context != null) {
                jSONObject.put("name", str);
            }
            jSONObject.put("model", str2);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/virtualdevicectr").O000000o(arrayList).O000000o(), new fss<Device>() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass6 */

            public Device parse(JSONObject jSONObject) throws JSONException {
                Device O000000o2 = DeviceFactory.O000000o(jSONObject);
                O000000o2.setOwner(true);
                return O000000o2;
            }
        }, Crypto.RC4, fsm);
    }

    public fsn netChange(Context context, String str, String str2, fsm<Void, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ssid_before", str);
            jSONObject.put("ssid_current", str2);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/stat/net_change").O000000o(arrayList).O000000o(), (fss) null, Crypto.RC4, fsm);
    }

    @Deprecated
    public fsn getSmartHomeConfigList(Context context, fsm<List<String>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        AnonymousClass7 r5 = new fss<List<String>>() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass7 */

            public List<String> parse(JSONObject jSONObject) throws JSONException {
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("result");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.optString(i));
                }
                return arrayList;
            }
        };
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/suggest_new_devices").O000000o(arrayList).O000000o(), r5, Crypto.RC4, fsm);
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
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass8 */

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

    public fsn updateDeviceDesc(Context context, final List<Device> list, final fsm<List<Device>, fso> fsm) {
        JSONObject jSONObject = new JSONObject();
        if (list != null) {
            AnonymousClass9 r8 = new fss<List<Device>>() {
                /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass9 */

                public List<Device> parse(JSONObject jSONObject) throws JSONException {
                    for (Device device : list) {
                        Object opt = jSONObject.opt(device.did);
                        if (opt instanceof JSONObject) {
                            JSONObject jSONObject2 = (JSONObject) opt;
                            device.desc = jSONObject2.optString("desc");
                            device.descNew = jSONObject2.optString("descNew");
                        } else if (opt instanceof String) {
                            device.desc = (String) opt;
                        }
                    }
                    return list;
                }
            };
            final List<List> O000000o2 = gpn.O000000o(list, 300);
            AnonymousClass10 r9 = new fsm<List<Device>, fso>() {
                /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass10 */
                fso mError;
                AtomicInteger times = new AtomicInteger(O000000o2.size());

                public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    onSuccess((List<Device>) ((List) obj));
                }

                public void onSuccess(List<Device> list) {
                    onFailure(null);
                }

                public void onFailure(fso fso) {
                    if (fso != null) {
                        this.mError = fso;
                    }
                    if (this.times.decrementAndGet() == 0) {
                        fso fso2 = this.mError;
                        if (fso2 == null) {
                            fsm.onSuccess(list);
                        } else {
                            fsm.onFailure(fso2);
                        }
                    }
                }
            };
            final ArrayList arrayList = new ArrayList();
            for (List<Device> list2 : O000000o2) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Device device : list2) {
                        if (!TextUtils.isEmpty(device.did)) {
                            jSONArray.put(device.did);
                        }
                    }
                    jSONObject.put("dids", jSONArray);
                } catch (JSONException unused) {
                }
                arrayList.add(CoreApi.O000000o().O000000o(context, getNetRequest("/v2/device/get_device_desc", jSONObject), r8, Crypto.RC4, r9));
            }
            return new fsn<List<Device>>(null) {
                /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass11 */

                public void cancel() {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((fsn) it.next()).cancel();
                    }
                }
            };
        }
        fsm.onFailure(new fso(-1, "new rquest devices"));
        return null;
    }

    public fsn updateDeviceList(Context context, JSONObject jSONObject, fsm<ArrayList<Device>, fso> fsm) {
        final AnonymousClass12 r4 = new fss<JSONObject>() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass12 */

            public JSONObject parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        };
        final Context context2 = context;
        final JSONObject jSONObject2 = jSONObject;
        final fsm<ArrayList<Device>, fso> fsm2 = fsm;
        return new fsn(new fsn.O00000Oo() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass13 */
            public boolean mCancel = false;
            public fsn mCurrentHandle = CoreApi.O000000o().O000000o(context2, DeviceApi.this.getNetRequest("/v2/home/device_list_page", jSONObject2), r4, Crypto.RC4, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass13.AnonymousClass1 */
                private ArrayList<Device> result = new ArrayList<>();

                public void onSuccess(JSONObject jSONObject) {
                    if (!AnonymousClass13.this.mCancel) {
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
                                    gsy.O00000Oo("DeviceApi", "/home/device_list_new request next page with did:".concat(String.valueOf(optString)));
                                    jSONObject2.put("start_did", optString);
                                    AnonymousClass13.this.mCurrentHandle = CoreApi.O000000o().O000000o(context2, DeviceApi.this.getNetRequest("/v2/home/device_list_page", jSONObject2), r4, Crypto.RC4, this);
                                    return;
                                }
                                gsy.O00000Oo("DeviceApi", "/home/device_list_response success times:" + this.result.size());
                                if (fsm2 != null) {
                                    fsm2.onSuccess(this.result);
                                }
                            } catch (JSONException e) {
                                gsy.O00000Oo("DeviceApi", "/home/device_list_response JSONException times:" + this.result.size());
                                if (fsm2 != null) {
                                    fsm2.onFailure(new fso(-1, Log.getStackTraceString(e)));
                                }
                            }
                        } else {
                            gsy.O00000Oo("DeviceApi", "/home/device_list_response resultObject null times:" + this.result.size());
                            if (fsm2 != null) {
                                fsm2.onSuccess(this.result);
                            }
                        }
                    }
                }

                public void onFailure(fso fso) {
                    gsy.O00000Oo("DeviceApi", "/home/device_list_response onFailure times:" + this.result.size());
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
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass14 */

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

    public fsn rpcAsyncRemote(Context context, String str, String str2, String str3, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", str3));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/rpc/".concat(String.valueOf(str))).O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass15 */

            public JSONObject parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public fsn rpcAsyncRemote(Context context, String str, String str2, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", str2));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/rpc/".concat(String.valueOf(str))).O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass16 */

            public JSONObject parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public fsn reportIpDetectResult(Context context, JSONArray jSONArray, String str, String str2, fsm<Void, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ipcost", jSONArray);
            jSONObject.put("net", "wifi");
            jSONObject.put("Trigger", str2);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("sign", str);
            }
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/reportips").O000000o(arrayList).O000000o(), (fss) null, Crypto.RC4, fsm);
    }

    public fsn updateSceneAuthData(Context context, List<String> list, String str, fsm<JSONObject, fso> fsm) {
        if (list == null) {
            fsm.onFailure(null);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < list.size(); i++) {
            jSONArray.put(list.get(i));
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("voice_dev_ids", jSONArray);
            jSONObject2.put("scene_id", Long.parseLong(str));
            jSONArray2.put(jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            jSONObject.put("authdata", jSONArray2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/voicectrl/update_auth_scene_device").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass17 */

            public JSONObject parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public fsn getAllSceneAuthDataByUsId(Context context, String str, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put(Long.parseLong(str));
            try {
                jSONObject.put("scene_ids", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/voicectrl/get_auth_scene_device").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass18 */

                public JSONObject parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception unused) {
            if (fsm == null) {
                return null;
            }
            fsm.onFailure(new fso(-9999, "sceneId is not long"));
            return null;
        }
    }

    public fsn setUserLicenseConfig(Context context, String str, String str2, fsm<String, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("did", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("type", str2);
            }
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/device/set_privacy_confirmation").O000000o(arrayList).O000000o(), new fss<String>() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass19 */

            public String parse(JSONObject jSONObject) throws JSONException {
                if (jSONObject == null) {
                    return null;
                }
                return jSONObject.toString();
            }
        }, Crypto.RC4, fsm);
    }

    public fsn getUserLicenseConfig(Context context, String str, fsm<Boolean, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("did", str);
            }
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/device/get_privacy_confirmation").O000000o(arrayList).O000000o(), new fss<Boolean>() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass20 */

            public Boolean parse(JSONObject jSONObject) throws JSONException {
                if (jSONObject == null) {
                    return Boolean.FALSE;
                }
                if (jSONObject.has("result")) {
                    return Boolean.valueOf(jSONObject.optBoolean("result"));
                }
                return Boolean.FALSE;
            }
        }, Crypto.RC4, fsm);
    }

    public fsn reportNewBind(Context context, String str, String str2, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("regist_by", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AnonymousClass21 r5 = new fss<JSONObject>() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass21 */

            public JSONObject parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        };
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/home/report_new_bind").O000000o(arrayList).O000000o(), r5, Crypto.RC4, fsm);
    }

    public fsn createLightGroup(Context context, List<String> list, String str, fsm<String, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                jSONArray.put(list.get(i));
            }
            jSONObject.put("member_dids", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/group/create").O000000o(arrayList).O000000o(), new fss<String>() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass22 */

            public String parse(JSONObject jSONObject) throws JSONException {
                if (jSONObject != null) {
                    return jSONObject.toString();
                }
                return null;
            }
        }, Crypto.RC4, fsm);
    }

    public fsn createLightGroupV2(Context context, List<String> list, String str, fsm<String, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                jSONArray.put(list.get(i));
            }
            jSONObject.put("member_dids", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/groupv2/create").O000000o(arrayList).O000000o(), new fss<String>() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass23 */

            public String parse(JSONObject jSONObject) throws JSONException {
                if (jSONObject != null) {
                    return jSONObject.toString();
                }
                return null;
            }
        }, Crypto.RC4, fsm);
    }

    public fsn modLightGroupOld(Context context, String str, List<String> list, List<String> list2, fsm<String, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("group_did", str);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                jSONArray.put(list.get(i));
            }
            jSONObject.put("add_dids", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (int i2 = 0; i2 < list2.size(); i2++) {
                jSONArray2.put(list2.get(i2));
            }
            jSONObject.put("remove_dids", jSONArray2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/group/mod_member").O000000o(arrayList).O000000o(), new fss<String>() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass24 */

            public String parse(JSONObject jSONObject) throws JSONException {
                if (jSONObject != null) {
                    return jSONObject.toString();
                }
                return null;
            }
        }, Crypto.RC4, fsm);
    }

    public fsn modLightGroup(Context context, String str, List<String> list, List<String> list2, fsm<String, fso> fsm, boolean... zArr) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("group_did", str);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                jSONArray.put(list.get(i));
            }
            jSONObject.put("add_dids", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (int i2 = 0; i2 < list2.size(); i2++) {
                jSONArray2.put(list2.get(i2));
            }
            jSONObject.put("remove_dids", jSONArray2);
            if (zArr.length != 0) {
                jSONObject.put("keep_model", zArr[0]);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/groupv2/mod_member").O000000o(arrayList).O000000o(), new fss<String>() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass25 */

            public String parse(JSONObject jSONObject) throws JSONException {
                if (jSONObject != null) {
                    return jSONObject.toString();
                }
                return null;
            }
        }, Crypto.RC4, fsm);
    }

    public fsn queryLightGroup(Context context, List<String> list, fsm<String, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                jSONArray.put(list.get(i));
            }
            jSONObject.put("group_did", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/groupv2/query_status").O000000o(arrayList).O000000o(), new fss<String>() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass26 */

            public String parse(JSONObject jSONObject) throws JSONException {
                if (jSONObject != null) {
                    return jSONObject.toString();
                }
                return null;
            }
        }, Crypto.RC4, fsm);
    }

    public static fsn getEncryptLtmk(Context context, String str, fsm<JSONObject, fso> fsm) {
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
        gsy.O00000Oo("DeviceApi", String.format("getEncryptLtmk: [%s]", jSONObject));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/share/askbluetoothkey").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass27 */

            public final JSONObject parse(JSONObject jSONObject) throws JSONException {
                gsy.O00000Oo("DeviceApi", String.format("Http Response: [%S]", jSONObject));
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public static fsn setSecurePinSwitch(String str, boolean z, fsm<JSONObject, fso> fsm) {
        if (TextUtils.isEmpty(str)) {
            if (fsm != null) {
                fsm.onFailure(new fso(Integer.MIN_VALUE, "empty did"));
            }
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("show_secure_pin", z ? "1" : "0");
            jSONObject.put("extra_data", jSONObject2);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/device/set_extra_data").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass28 */

                public final JSONObject parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception unused) {
            return null;
        }
    }

    public fsn getHMBandSignature(Context context, String str, String str2, int i, int i2, final fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("publickeyhash", str2);
            jSONObject.put("device_type", i);
            jSONObject.put("appid", i2);
            jSONObject.put("random", str);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/huami/get_brand_sign").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass29 */

            public JSONObject parse(JSONObject jSONObject) throws JSONException {
                fsm.onSuccess(jSONObject);
                return new JSONObject();
            }
        }, Crypto.RC4, fsm);
    }

    public fsn requestBleWifiSpeakerState(Context context, String str, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            jSONObject.put("dids", jSONArray);
        } catch (JSONException unused) {
        }
        String jSONObject2 = jSONObject.toString();
        gsy.O00000Oo(LogType.NETWORK, "DeviceApi", "request bleWifispeaker:".concat(String.valueOf(jSONObject2)));
        arrayList.add(new KeyValuePair("data", jSONObject2));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/blemesh/check_enable_switch").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass30 */

            public JSONObject parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    public fsn updateDeviceAlias(String str, List<String> list, fsm<JSONObject, fso> fsm, String str2, List<PowerMultikeyBean> list2) {
        List<String> O000000o2;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", str);
            jSONObject.put("type", "alias");
            jSONObject.put("reset", false);
            if (TextUtils.isEmpty(str2)) {
                str2 = "common";
            }
            JSONArray jSONArray = new JSONArray();
            for (String put : list) {
                jSONArray.put(put);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str2, jSONArray);
            if (list2 != null && !TextUtils.equals("common", str2)) {
                for (PowerMultikeyBean next : list2) {
                    if (!TextUtils.equals(str2, next.O00000oo) && (O000000o2 = gvi.O000000o().O000000o(str, null, false, next.O00000oo)) != null && !O000000o2.isEmpty()) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (String put2 : O000000o2) {
                            jSONArray2.put(put2);
                        }
                        jSONObject2.put(next.O00000oo, jSONArray2);
                    }
                }
            }
            jSONObject.put("value", jSONObject2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/device/set_voice_conf").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass31 */

                public JSONObject parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public fsn getSupportAliasModel(fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/voicectrl/ctrl_voice_models").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass32 */

                public JSONObject parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public fsn getDeviceAlias(String str, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", str);
            jSONObject.put("type", "alias");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/device/get_voice_conf").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass33 */

                public JSONObject parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public fsn getCommentConfig(fsm<Boolean, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("rate_switch");
            jSONObject.put("keys", jSONArray);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/user/switch_control").O000000o(arrayList).O000000o(), new fss<Boolean>() {
                /* class com.xiaomi.smarthome.device.api.DeviceApi.AnonymousClass34 */

                public Boolean parse(JSONObject jSONObject) throws JSONException {
                    if (jSONObject != null) {
                        try {
                            if (!jSONObject.isNull("rate_switch")) {
                                JSONObject optJSONObject = jSONObject.optJSONObject("rate_switch");
                                if (optJSONObject != null) {
                                    if (!optJSONObject.isNull("data")) {
                                        return Boolean.valueOf(TextUtils.equals(optJSONObject.optString("data", ""), "on"));
                                    }
                                }
                                return Boolean.FALSE;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            return Boolean.FALSE;
                        }
                    }
                    return Boolean.FALSE;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
