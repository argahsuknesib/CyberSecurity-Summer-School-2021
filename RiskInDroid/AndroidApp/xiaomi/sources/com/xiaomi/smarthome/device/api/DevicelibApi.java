package com.xiaomi.smarthome.device.api;

import _m_j.fsm;
import _m_j.fsn;
import _m_j.fso;
import _m_j.fss;
import _m_j.ftt;
import _m_j.fun;
import _m_j.gsy;
import _m_j.gtf;
import _m_j.gwf;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DevicelibApi {
    public static fsn getDeviceLocationList(Context context, JSONArray jSONArray, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bssid", jSONArray);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/location/list").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class com.xiaomi.smarthome.device.api.DevicelibApi.AnonymousClass1 */

            public final JSONObject parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public static fsn getDeviceCategory(Context context, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        AnonymousClass2 r4 = new fss<JSONObject>() {
            /* class com.xiaomi.smarthome.device.api.DevicelibApi.AnonymousClass2 */

            public final JSONObject parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        };
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/product/category_v3").O000000o(arrayList).O000000o(), r4, Crypto.RC4, fsm);
    }

    public static fsn getDeviceCategoryV2(Context context, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        AnonymousClass3 r4 = new fss<JSONObject>() {
            /* class com.xiaomi.smarthome.device.api.DevicelibApi.AnonymousClass3 */

            public final JSONObject parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        };
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/product/category_v2").O000000o(arrayList).O000000o(), r4, Crypto.RC4, fsm);
    }

    public static fsn getDeviceExtraInfo(Context context, ArrayList<String> arrayList, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList2 = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("dids", jSONArray);
        } catch (JSONException unused) {
        }
        arrayList2.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/device/extra_info").O000000o(arrayList2).O000000o(), new fss<JSONObject>() {
            /* class com.xiaomi.smarthome.device.api.DevicelibApi.AnonymousClass4 */

            public final JSONObject parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public static fsn getGeekDeviceDesc(Context context, Set<String> set, fsm<String, fso> fsm) {
        if (set != null && set.size() > 0) {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                Object[] array = set.toArray();
                for (Object put : array) {
                    jSONArray.put(put);
                }
                jSONObject.put("models", jSONArray);
                arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/getmodeluiconfig").O000000o(arrayList).O000000o(), new fss<String>() {
                    /* class com.xiaomi.smarthome.device.api.DevicelibApi.AnonymousClass5 */

                    public final String parse(JSONObject jSONObject) throws JSONException {
                        if (jSONObject == null) {
                            return null;
                        }
                        return jSONObject.toString();
                    }
                }, Crypto.RC4, fsm);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static fsn batchGetDeviceProps(Context context, JSONArray jSONArray, fsm<String, fso> fsm, String str) {
        if (jSONArray != null && jSONArray.length() > 0) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("from_flag", str);
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONArray.toString()));
            return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/device/batchdevicedatas").O000000o(arrayList).O000000o(), new fss<String>() {
                /* class com.xiaomi.smarthome.device.api.DevicelibApi.AnonymousClass6 */

                public final String parse(JSONObject jSONObject) throws JSONException {
                    if (jSONObject == null) {
                        return null;
                    }
                    return jSONObject.toString();
                }
            }, Crypto.RC4, fsm);
        } else if (fsm == null) {
            return null;
        } else {
            fsm.onFailure(new fso(-1, "param is null"));
            return null;
        }
    }

    public static fsn reportGPSInfo(Context context, String str, double d, double d2, String str2, String str3, String str4, String str5, String str6, fsm<Void, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("lng", d);
            jSONObject.put("lat", d2);
            jSONObject.put("adminArea", str2);
            jSONObject.put("countryCode", str3);
            jSONObject.put("locality", str4);
            jSONObject.put("thoroughfare", str5);
            jSONObject.put("language", "zh_CN");
            jSONObject.put("subLocality", str6);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/location/set").O000000o(arrayList).O000000o(), (fss) null, Crypto.RC4, fsm);
    }

    public static fsn delDevice(Context context, JSONObject jSONObject, final ftt<Void> ftt) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("type", "delDevice");
            jSONObject2.put("param", jSONObject);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject2.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/mdata").O000000o(arrayList).O000000o(), new fss<fun>() {
            /* class com.xiaomi.smarthome.device.api.DevicelibApi.AnonymousClass7 */

            public final fun parse(JSONObject jSONObject) throws JSONException {
                fun fun = new fun();
                fun.f17192O000000o = jSONObject.optInt("ret");
                fun.O00000Oo = jSONObject.optLong("lastModify");
                JSONObject optJSONObject = jSONObject.optJSONObject("init");
                if (optJSONObject != null) {
                    fun.O00000o0 = gwf.O000000o(optJSONObject);
                }
                return fun;
            }
        }, Crypto.RC4, new fsm<fun, fso>() {
            /* class com.xiaomi.smarthome.device.api.DevicelibApi.AnonymousClass8 */

            public final void onSuccess(fun fun) {
                if (fun.O000000o()) {
                    ftt.O000000o((Object) null);
                } else {
                    ftt.O000000o(ErrorCode.INVALID.getCode());
                }
            }

            public final void onFailure(fso fso) {
                ftt.O000000o(fso.f17063O000000o);
            }
        });
    }

    public static fsn delSubDevice(Context context, JSONObject jSONObject, final ftt<Void> ftt) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("type", "delSubDevice");
            jSONObject2.put("param", jSONObject);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject2.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/mdata").O000000o(arrayList).O000000o(), new fss<fun>() {
            /* class com.xiaomi.smarthome.device.api.DevicelibApi.AnonymousClass9 */

            public final fun parse(JSONObject jSONObject) throws JSONException {
                fun fun = new fun();
                fun.f17192O000000o = jSONObject.optInt("ret");
                fun.O00000Oo = jSONObject.optLong("lastModify");
                JSONObject optJSONObject = jSONObject.optJSONObject("init");
                if (optJSONObject != null) {
                    fun.O00000o0 = gwf.O000000o(optJSONObject);
                }
                return fun;
            }
        }, Crypto.RC4, new fsm<fun, fso>() {
            /* class com.xiaomi.smarthome.device.api.DevicelibApi.AnonymousClass10 */

            public final void onSuccess(fun fun) {
                if (fun.O000000o()) {
                    ftt.O000000o((Object) null);
                } else {
                    ftt.O000000o(ErrorCode.INVALID.getCode());
                }
            }

            public final void onFailure(fso fso) {
                ftt.O000000o(fso.f17063O000000o);
            }
        });
    }

    public static fsn getLiveCameraList(Context context, double d, double d2, fsm<JSONArray, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("longitude", d);
            jSONObject.put("latitude", d2);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/broadcastlist").O000000o(arrayList).O000000o(), new fss<JSONArray>() {
            /* class com.xiaomi.smarthome.device.api.DevicelibApi.AnonymousClass11 */

            public final JSONArray parse(JSONObject jSONObject) throws JSONException {
                return jSONObject.optJSONArray("places");
            }
        }, Crypto.RC4, fsm);
    }

    public static fsn bindDevice(Context context, String str, String str2, int i, fsm<Integer, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("token", str2);
            jSONObject.put("pid", i);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/binddevice").O000000o(arrayList).O000000o(), new fss<Integer>() {
            /* class com.xiaomi.smarthome.device.api.DevicelibApi.AnonymousClass12 */

            public final Integer parse(JSONObject jSONObject) throws JSONException {
                return Integer.valueOf(jSONObject.getInt("ret"));
            }
        }, Crypto.RC4, fsm);
    }

    public static fsn setShowMode(Context context, String str, int i, fsm<Boolean, fso> fsm) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("show_mode", i);
        } catch (JSONException unused) {
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/device/set_show_mode").O000000o(arrayList).O000000o(), new fss<Boolean>() {
            /* class com.xiaomi.smarthome.device.api.DevicelibApi.AnonymousClass13 */

            public final Boolean parse(JSONObject jSONObject) throws JSONException {
                int optInt = jSONObject.optInt("code", -1);
                boolean z = false;
                boolean optBoolean = jSONObject.optBoolean("result", false);
                if (optInt == 0 && optBoolean) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }, Crypto.RC4, fsm);
    }

    public static fsn setShowMode(Context context, Set<String> set, int i, fsm<Boolean, fso> fsm) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (set != null && set.size() > 0) {
                for (String put : set) {
                    jSONArray.put(put);
                }
            }
            jSONObject.put("didlist", jSONArray);
            jSONObject.put("show_mode", i);
        } catch (JSONException unused) {
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/device/set_multi_show_mode").O000000o(arrayList).O000000o(), new fss<Boolean>() {
            /* class com.xiaomi.smarthome.device.api.DevicelibApi.AnonymousClass14 */

            public final Boolean parse(JSONObject jSONObject) throws JSONException {
                int optInt = jSONObject.optInt("code", -1);
                boolean z = false;
                boolean optBoolean = jSONObject.optBoolean("result", false);
                if (optInt == 0 && optBoolean) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }, Crypto.RC4, fsm);
    }

    public static fsn defLightGroup(Context context, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        AnonymousClass15 r4 = new fss<JSONObject>() {
            /* class com.xiaomi.smarthome.device.api.DevicelibApi.AnonymousClass15 */

            public final JSONObject parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        };
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/group/device_def").O000000o(arrayList).O000000o(), r4, Crypto.RC4, fsm);
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
    public static fsn subscribeDevice(Context context, String str, int i, List<String> list, int i2, fsm<Boolean, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("pid", i);
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < list.size(); i3++) {
                jSONArray.put(list.get(i3));
            }
            jSONObject.put("method", jSONArray);
            jSONObject.put("supportUpinfo", true);
            jSONObject.put("pushid", CommonApplication.getApplication().getPushId());
            jSONObject.put("expire", i2);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/mipush/eventsub").O000000o(arrayList).O000000o(), new fss<Boolean>() {
            /* class com.xiaomi.smarthome.device.api.DevicelibApi.AnonymousClass16 */

            public final Boolean parse(JSONObject jSONObject) throws JSONException {
                return Boolean.valueOf(jSONObject.getBoolean("ret"));
            }
        }, Crypto.RC4, fsm);
    }

    public static fsn unsubscribeDevice(Context context, String str, int i, List<String> list, fsm<Boolean, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("pid", i);
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < list.size(); i2++) {
                jSONArray.put(list.get(i2));
            }
            jSONObject.put("method", jSONArray);
            jSONObject.put("pushid", CommonApplication.getApplication().getPushId());
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/mipush/eventunsub").O000000o(arrayList).O000000o(), new fss<Boolean>() {
            /* class com.xiaomi.smarthome.device.api.DevicelibApi.AnonymousClass17 */

            public final Boolean parse(JSONObject jSONObject) throws JSONException {
                return Boolean.valueOf(jSONObject.getBoolean("ret"));
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
    public static fsn subscribeDeviceV2(Context context, String str, int i, List<String> list, String str2, int i2, fsm<Boolean, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("pid", i);
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < list.size(); i3++) {
                jSONArray.put(list.get(i3));
            }
            jSONObject.put("method", jSONArray);
            jSONObject.put("supportUpinfo", true);
            jSONObject.put("pushid", CommonApplication.getApplication().getPushId());
            jSONObject.put("expire", i2);
            jSONObject.put("subid", str2);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/mipush/eventsub").O000000o(arrayList).O000000o(), new fss<Boolean>() {
            /* class com.xiaomi.smarthome.device.api.DevicelibApi.AnonymousClass18 */

            public final Boolean parse(JSONObject jSONObject) throws JSONException {
                return Boolean.valueOf(jSONObject.getBoolean("ret"));
            }
        }, Crypto.RC4, fsm);
    }

    public static fsn unsubscribeDeviceV2(Context context, String str, int i, List<String> list, String str2, fsm<Boolean, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("pid", i);
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < list.size(); i2++) {
                jSONArray.put(list.get(i2));
            }
            jSONObject.put("method", jSONArray);
            jSONObject.put("pushid", CommonApplication.getApplication().getPushId());
            jSONObject.put("subid", str2);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/mipush/eventunsub").O000000o(arrayList).O000000o(), new fss<Boolean>() {
            /* class com.xiaomi.smarthome.device.api.DevicelibApi.AnonymousClass19 */

            public final Boolean parse(JSONObject jSONObject) throws JSONException {
                return Boolean.valueOf(jSONObject.getBoolean("ret"));
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
    public static fsn subscribeDeviceBatchV2(Context context, JSONObject jSONObject, String str, int i, fsm<String, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("didList", jSONObject);
            String pushId = CommonApplication.getApplication().getPushId();
            if (TextUtils.isEmpty(pushId)) {
                gsy.O00000Oo(LogType.NETWORK, "DevicelibApi", "subscribeDeviceBatchV2 pushId is null");
            }
            jSONObject2.put("pushId", pushId);
            jSONObject2.put("expire", i);
            jSONObject2.put("supportUpinfo", true);
            if (!TextUtils.isEmpty(str)) {
                jSONObject2.put("subId", str);
            }
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject2.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/mipush/eventsubbatch").O000000o(arrayList).O000000o(), new fss<String>() {
            /* class com.xiaomi.smarthome.device.api.DevicelibApi.AnonymousClass20 */

            public final String parse(JSONObject jSONObject) throws JSONException {
                return jSONObject.getString("subId");
            }
        }, Crypto.RC4, fsm);
    }

    public static fsn unsubscribeDeviceBatchV2(Context context, String str, fsm<Void, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("subId", str);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/mipush/eventunsubbatch").O000000o(arrayList).O000000o(), (fss) null, Crypto.RC4, fsm);
    }

    public static fsn queryModelFunction(Context context, String[] strArr, Set<String> set, fsm<SparseArray<List<String>>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        int i = 0;
        while (i < strArr.length) {
            try {
                jSONArray2.put(strArr[i]);
                i++;
            } catch (JSONException unused) {
            }
        }
        for (String put : set) {
            jSONArray.put(put);
        }
        jSONObject.put("models", jSONArray);
        jSONObject.put("tags", jSONArray2);
        AnonymousClass21 r7 = new fss<SparseArray<List<String>>>() {
            /* class com.xiaomi.smarthome.device.api.DevicelibApi.AnonymousClass21 */

            public final SparseArray<List<String>> parse(JSONObject jSONObject) throws JSONException {
                SparseArray<List<String>> sparseArray = new SparseArray<>();
                JSONObject optJSONObject = jSONObject.optJSONObject("tagModels");
                for (int i = 0; i < gtf.O00000o0.length; i++) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray(gtf.O00000o0[i]);
                    HashSet hashSet = new HashSet();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        hashSet.add(optJSONArray.optString(i2));
                    }
                    sparseArray.put(i, new ArrayList(hashSet));
                }
                return sparseArray;
            }
        };
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/group/query_model_func").O000000o(arrayList).O000000o(), r7, Crypto.RC4, fsm);
    }
}
