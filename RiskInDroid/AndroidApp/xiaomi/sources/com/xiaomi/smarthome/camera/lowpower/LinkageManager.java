package com.xiaomi.smarthome.camera.lowpower;

import _m_j.civ;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fss;
import _m_j.fsy;
import _m_j.ft;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.smarthome.camera.lowpower.entity.LinkageDeviceInfo;
import com.xiaomi.smarthome.camera.lowpower.util.JSONUtil;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.host.PluginHostApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LinkageManager {
    public static String LONG_TIME_KEY_PREFIX = "prop.s_chuangmi_clocks";
    public static volatile boolean isRequesting = false;
    private static LinkageManager sInstance;
    private List<LinkageDeviceInfo> mLinkageDeviceList = new ArrayList();

    private void clearDatas() {
    }

    public boolean isRequesting() {
        return isRequesting;
    }

    private LinkageManager() {
    }

    public static LinkageManager getInstance() {
        if (sInstance == null) {
            sInstance = new LinkageManager();
        }
        return sInstance;
    }

    public void destroyInstance() {
        LinkageManager linkageManager = sInstance;
        if (linkageManager != null) {
            linkageManager.clearDatas();
            sInstance = null;
        }
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
    public void getLinkageDeviceList(final String str, final String str2, final Callback<JSONObject> callback) {
        if (!isRequesting) {
            isRequesting = true;
            final AnonymousClass1 r1 = new Callback<JSONObject>() {
                /* class com.xiaomi.smarthome.camera.lowpower.LinkageManager.AnonymousClass1 */

                public void onSuccess(JSONObject jSONObject) {
                    LinkageManager.isRequesting = false;
                    ft.O000000o(XmPluginHostApi.instance().context()).O000000o(new Intent("device_list_request_completed"));
                    callback.onSuccess(jSONObject);
                }

                public void onFailure(int i, String str) {
                    callback.onFailure(i, str);
                    ft.O000000o(XmPluginHostApi.instance().context()).O000000o(new Intent("device_list_request_completed"));
                    LinkageManager.isRequesting = false;
                }
            };
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", str);
                jSONObject.put("get_doorbell_linked_did", true);
                jSONObject.put("language", Locale.getDefault().getLanguage());
                jSONObject.put("region", Locale.getDefault().getCountry());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            civ.O000000o("xm111", "url:/v2/device/get_filter_device param:" + jSONObject.toString());
            XmPluginHostApi.instance().callSmartHomeApi(str2, "", "/v2/device/get_filter_device", "POST", jSONObject.toString(), new Callback<JSONObject>() {
                /* class com.xiaomi.smarthome.camera.lowpower.LinkageManager.AnonymousClass2 */

                public void onSuccess(JSONObject jSONObject) {
                    if (r1 != null) {
                        if (jSONObject == null || jSONObject.optJSONArray("dids") == null) {
                            r1.onFailure(-10000, "null dids");
                            return;
                        }
                        civ.O000000o("xm111", "url:/v2/device/get_filter_device result ok:" + jSONObject.toString());
                        JSONArray optJSONArray = jSONObject.optJSONArray("dids");
                        if (optJSONArray.length() == 0) {
                            r1.onFailure(-10000, "null dids");
                            return;
                        }
                        final ArrayList<String> list = JSONUtil.toList(optJSONArray);
                        new Thread(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.lowpower.LinkageManager.AnonymousClass2.AnonymousClass1 */

                            public void run() {
                                LinkageManager.this.getAuthDeviceWithScreenDids(str, list, str2, r1);
                            }
                        }).start();
                    }
                }

                public void onFailure(int i, String str) {
                    civ.O000000o("xm111", "url:/v2/device/get_filter_device result fail: error:" + i + " errorInfo:" + str);
                    Callback callback = r1;
                    if (callback != null) {
                        callback.onFailure(i, str);
                    }
                }
            }, Parser.DEFAULT_PARSER);
        }
    }

    public void getAuthDeviceWithScreenDids(String str, List<String> list, String str2, Callback<JSONObject> callback) {
        boolean z;
        ArrayList arrayList;
        boolean z2;
        String str3 = str;
        Callback<JSONObject> callback2 = callback;
        Object obj = new Object();
        for (int i = 0; i < list.size(); i++) {
            String str4 = list.get(i);
            Iterator<LinkageDeviceInfo> it = this.mLinkageDeviceList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getDeviceStat().did.equals(str4)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z && XmPluginHostApi.instance().getDeviceByDid(str4) != null) {
                int[] iArr = {0};
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    boolean[] zArr = new boolean[2];
                    arrayList = arrayList2;
                    int[] iArr2 = iArr;
                    z2 = true;
                    getScreenLinkedDevice(str2, str4, iArr, zArr, arrayList2, obj, callback);
                    if (zArr[0]) {
                        if (callback2 != null) {
                            callback2.onFailure(-33, "访问数据出错");
                        }
                    } else if (iArr2[0] <= 0) {
                        z2 = false;
                        break;
                    } else {
                        arrayList2 = arrayList;
                        iArr = iArr2;
                    }
                }
                if (!z2) {
                    LinkageDeviceInfo linkageDeviceInfo = new LinkageDeviceInfo(XmPluginHostApi.instance().getDeviceByDid(str4), arrayList);
                    linkageDeviceInfo.setBinded(linkageDeviceInfo.getConnectedDids().contains(str3));
                    linkageDeviceInfo.setSelected(linkageDeviceInfo.getConnectedDids().contains(str3));
                    this.mLinkageDeviceList.add(linkageDeviceInfo);
                } else if (callback2 != null) {
                    callback2.onFailure(-33, "访问出错");
                    return;
                } else {
                    return;
                }
            }
        }
        callback2.onSuccess(null);
    }

    private void getScreenLinkedDevice(String str, String str2, int[] iArr, boolean[] zArr, List<String> list, Object obj, Callback<JSONObject> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("offset", iArr[0]);
            try {
                jSONObject.put("did", str2);
            } catch (JSONException e) {
                e = e;
            }
        } catch (JSONException e2) {
            e = e2;
            e.printStackTrace();
            civ.O000000o("xm111", "url:/v2/device/get_partner_device param:" + jSONObject + " current thread:" + Thread.currentThread().getName());
            final boolean[] zArr2 = zArr;
            final int[] iArr2 = iArr;
            final String str3 = str;
            final String str4 = str2;
            final List<String> list2 = list;
            callSmartHomeApi(str, "/v2/device/get_partner_device", jSONObject.toString(), new Callback<JSONObject>() {
                /* class com.xiaomi.smarthome.camera.lowpower.LinkageManager.AnonymousClass3 */

                public void onSuccess(JSONObject jSONObject) {
                    civ.O000000o("xm111", "url:/v2/device/get_partner_device result ok:" + jSONObject + " current thread:" + Thread.currentThread().getName());
                    if (jSONObject == null || jSONObject.optJSONArray("auth_dids") == null) {
                        zArr2[0] = true;
                        return;
                    }
                    iArr2[0] = jSONObject.optInt("offset", -1);
                    ArrayList<String> list = JSONUtil.toList(jSONObject.optJSONArray("auth_dids"));
                    Object obj = new Object();
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        boolean[] zArr = {true};
                        LinkageManager.this.queryDevicePropsByBatch(str3, it.next(), str4, zArr, obj);
                        if (zArr[0]) {
                            it.remove();
                        }
                    }
                    list2.addAll(list);
                }

                public void onFailure(int i, String str) {
                    civ.O000000o("xm111", "url:/v2/device/get_partner_device result faid: error:" + i + " errorInfo:" + str);
                    zArr2[0] = true;
                }
            }, Parser.DEFAULT_PARSER);
        }
        civ.O000000o("xm111", "url:/v2/device/get_partner_device param:" + jSONObject + " current thread:" + Thread.currentThread().getName());
        final boolean[] zArr22 = zArr;
        final int[] iArr22 = iArr;
        final String str32 = str;
        final String str42 = str2;
        final List<String> list22 = list;
        callSmartHomeApi(str, "/v2/device/get_partner_device", jSONObject.toString(), new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.camera.lowpower.LinkageManager.AnonymousClass3 */

            public void onSuccess(JSONObject jSONObject) {
                civ.O000000o("xm111", "url:/v2/device/get_partner_device result ok:" + jSONObject + " current thread:" + Thread.currentThread().getName());
                if (jSONObject == null || jSONObject.optJSONArray("auth_dids") == null) {
                    zArr22[0] = true;
                    return;
                }
                iArr22[0] = jSONObject.optInt("offset", -1);
                ArrayList<String> list = JSONUtil.toList(jSONObject.optJSONArray("auth_dids"));
                Object obj = new Object();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    boolean[] zArr = {true};
                    LinkageManager.this.queryDevicePropsByBatch(str32, it.next(), str42, zArr, obj);
                    if (zArr[0]) {
                        it.remove();
                    }
                }
                list22.addAll(list);
            }

            public void onFailure(int i, String str) {
                civ.O000000o("xm111", "url:/v2/device/get_partner_device result faid: error:" + i + " errorInfo:" + str);
                zArr22[0] = true;
            }
        }, Parser.DEFAULT_PARSER);
    }

    public void queryDevicePropsByBatch(String str, final String str2, final String str3, final boolean[] zArr, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str2);
            jSONObject.put("props", new JSONArray().put("prop.s_notify_screen_dev_enable").put("prop.s_notify_screen_dev_did"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        civ.O000000o("xm111", "url:/device/batchdevicedatas param:" + jSONObject + " current thread:" + Thread.currentThread().getName());
        callSmartHomeApi(str, "/device/batchdevicedatas", new JSONArray().put(jSONObject).toString(), new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.camera.lowpower.LinkageManager.AnonymousClass4 */

            public void onSuccess(JSONObject jSONObject) {
                civ.O000000o("xm111", "url:/device/batchdevicedatas result ok:" + jSONObject + " current thread:" + Thread.currentThread().getName());
                if (jSONObject.optJSONObject(str2) != null) {
                    JSONObject optJSONObject = jSONObject.optJSONObject(str2);
                    String optString = optJSONObject.optString("prop.s_notify_screen_dev_enable", "");
                    String optString2 = optJSONObject.optString("prop.s_notify_screen_dev_did", "");
                    if ("1".equals(optString) && optString2.contains(str3)) {
                        zArr[0] = false;
                    }
                }
            }

            public void onFailure(int i, String str) {
                civ.O000000o("xm111", "url:/device/batchdevicedatas result failed:error:" + i + " errorInfo:" + str + " current thread:" + Thread.currentThread().getName());
            }
        }, Parser.DEFAULT_PARSER);
    }

    public List<LinkageDeviceInfo> getLinkageList() {
        return this.mLinkageDeviceList;
    }

    public final <T> void callSmartHomeApi(String str, String str2, String str3, final Callback<T> callback, final Parser<T> parser) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", str3));
        NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo(str2).O000000o(arrayList).O000000o();
        if (parser == null) {
            z = false;
        } else {
            z = parser instanceof PluginHostApi.ParserForRawResult;
        }
        CoreApi.O000000o().O000000o((Context) null, O000000o2, new fss<T>() {
            /* class com.xiaomi.smarthome.camera.lowpower.LinkageManager.AnonymousClass5 */

            public T parse(JSONObject jSONObject) throws JSONException {
                Parser parser = parser;
                if (parser != null) {
                    return parser.parse(jSONObject.toString());
                }
                return null;
            }
        }, Crypto.RC4, new fsy<T, fso>() {
            /* class com.xiaomi.smarthome.camera.lowpower.LinkageManager.AnonymousClass6 */

            public void onSuccess(T t) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(t);
                }
            }

            public void onFailure(fso fso) {
                Callback callback = callback;
                if (callback != null) {
                    if (fso != null) {
                        callback.onFailure(fso.f17063O000000o, fso.O00000Oo);
                    } else {
                        callback.onFailure(-1, "");
                    }
                }
            }
        }, z);
    }

    public <T> void callSmartHomeApi(String str, String str2, String str3, String str4, String str5, final Callback<T> callback, final Parser<T> parser) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", str5));
        if (TextUtils.isEmpty(str4) || (!str4.toLowerCase().equals("get") && !str4.toLowerCase().equals("post"))) {
            str4 = "GET";
        }
        if (parser == null) {
            z = false;
        } else {
            z = parser instanceof PluginHostApi.ParserForRawResult;
        }
        CoreApi.O000000o().O000000o((Context) null, new NetRequest.O000000o().O00000o0(str2).O000000o(str4).O00000Oo(str3).O000000o(arrayList).O000000o(), new fss<T>() {
            /* class com.xiaomi.smarthome.camera.lowpower.LinkageManager.AnonymousClass7 */

            public T parse(JSONObject jSONObject) throws JSONException {
                Parser parser = parser;
                if (parser != null) {
                    return parser.parse(jSONObject.toString());
                }
                return null;
            }
        }, Crypto.RC4, new fsm<T, fso>() {
            /* class com.xiaomi.smarthome.camera.lowpower.LinkageManager.AnonymousClass8 */

            public void onSuccess(T t) {
                if (callback == null) {
                }
            }

            public void onFailure(fso fso) {
                Callback callback = callback;
                if (callback != null) {
                    if (fso != null) {
                        callback.onFailure(fso.f17063O000000o, fso.O00000Oo);
                    } else {
                        callback.onFailure(-1, "");
                    }
                }
            }
        }, z);
    }

    public void submitSelectedInfo(String str, String str2, Callback<JSONObject> callback) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        for (LinkageDeviceInfo next : this.mLinkageDeviceList) {
            if (next.isSelected() && !next.isBinded()) {
                arrayList2.add(next.getDeviceStat().did);
            } else if (!next.isSelected() && next.isBinded()) {
                arrayList.add(next.getDeviceStat().did);
            }
        }
        final String str3 = str;
        final String str4 = str2;
        final Callback<JSONObject> callback2 = callback;
        new Thread(new Runnable() {
            /* class com.xiaomi.smarthome.camera.lowpower.LinkageManager.AnonymousClass9 */

            public void run() {
                LinkageManager.this.startUnbindAndBind(str3, str4, arrayList, arrayList2, callback2);
            }
        }).start();
    }

    public void startUnbindAndBind(String str, String str2, List<String> list, List<String> list2, Callback<JSONObject> callback) {
        Callback<JSONObject> callback2 = callback;
        if (list != null && list2 != null) {
            boolean[] zArr = new boolean[1];
            if (list.size() > 0) {
                startUnauth(str, str2, list, callback, zArr);
            } else {
                zArr[0] = true;
            }
            if (zArr[0]) {
                if (list2.size() > 0) {
                    startAuth(str, str2, list2, callback, zArr);
                } else {
                    zArr[0] = true;
                }
                if (!zArr[0]) {
                    if (callback2 != null) {
                        callback2.onFailure(-1, "");
                    }
                } else if (callback2 != null) {
                    callback2.onSuccess(null);
                }
            } else if (callback2 != null) {
                callback2.onFailure(-1, "");
            }
        }
    }

    private void startUnauth(String str, String str2, List<String> list, Callback<JSONObject> callback, final boolean[] zArr) {
        for (String next : list) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", next);
                jSONObject.put("partner_did_lst", JSONUtil.getSingleJSONArray(str2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            final boolean[] zArr2 = {false};
            callSmartHomeApi(str, "/v2/device/cancel_partner_device", jSONObject.toString(), new Callback<JSONObject>() {
                /* class com.xiaomi.smarthome.camera.lowpower.LinkageManager.AnonymousClass10 */

                public void onSuccess(JSONObject jSONObject) {
                    if (jSONObject == null || jSONObject.optInt("code", -1) == -1) {
                        zArr2[0] = false;
                    } else {
                        zArr2[0] = true;
                    }
                }

                public void onFailure(int i, String str) {
                    zArr2[0] = false;
                }
            }, Parser.DEFAULT_PARSER);
            if (!zArr2[0]) {
                zArr[0] = false;
                return;
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("did", str2);
            ArrayList arrayList = new ArrayList();
            for (LinkageDeviceInfo next2 : this.mLinkageDeviceList) {
                if (next2.isSelected()) {
                    arrayList.add(next2.getDeviceStat().did);
                }
            }
            jSONObject2.put("props", new JSONObject().put("prop.s_notify_screen_dev_enable", "0").put("prop.s_notify_screen_dev_did", JSONUtil.getJSONArrayLikeFromList(arrayList)));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        callSmartHomeApi(str, "/v2/device/set_props", jSONObject2.toString(), new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.camera.lowpower.LinkageManager.AnonymousClass11 */

            public void onSuccess(JSONObject jSONObject) {
                JSONObject optJSONObject = jSONObject.optJSONObject("prop_result");
                if (optJSONObject == null) {
                    zArr[0] = false;
                } else if (!optJSONObject.optBoolean("prop.s_notify_screen_dev_enable", false) || !optJSONObject.optBoolean("prop.s_notify_screen_dev_did", false)) {
                    zArr[0] = false;
                } else {
                    zArr[0] = true;
                }
            }

            public void onFailure(int i, String str) {
                zArr[0] = false;
            }
        }, Parser.DEFAULT_PARSER);
    }

    private void startAuth(String str, String str2, List<String> list, Callback<JSONObject> callback, final boolean[] zArr) {
        for (int i = 0; i < list.size(); i++) {
            String str3 = list.get(i);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", str3);
                jSONObject.put("auth_dids", new JSONArray().put(str2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            final boolean[] zArr2 = {false};
            callSmartHomeApi(str, "/v2/device/auth_partner_device", jSONObject.toString(), new Callback<JSONObject>() {
                /* class com.xiaomi.smarthome.camera.lowpower.LinkageManager.AnonymousClass12 */

                public void onSuccess(JSONObject jSONObject) {
                    if (jSONObject == null || jSONObject.optInt("code", -1) == -1) {
                        zArr2[0] = false;
                    } else {
                        zArr2[0] = true;
                    }
                }

                public void onFailure(int i, String str) {
                    zArr2[0] = false;
                }
            }, Parser.DEFAULT_PARSER);
            if (!zArr2[0]) {
                zArr[0] = false;
                return;
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("did", str2);
            ArrayList arrayList = new ArrayList();
            for (LinkageDeviceInfo next : this.mLinkageDeviceList) {
                if (next.isSelected()) {
                    arrayList.add(next.getDeviceStat().did);
                }
            }
            jSONObject2.put("props", new JSONObject().put("prop.s_notify_screen_dev_enable", "1").put("prop.s_notify_screen_dev_did", JSONUtil.getJSONArrayLikeFromList(arrayList)));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        callSmartHomeApi(str, "/v2/device/set_props", jSONObject2.toString(), new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.camera.lowpower.LinkageManager.AnonymousClass13 */

            public void onSuccess(JSONObject jSONObject) {
                JSONObject optJSONObject = jSONObject.optJSONObject("prop_result");
                if (optJSONObject == null) {
                    zArr[0] = false;
                } else if (!optJSONObject.optBoolean("prop.s_notify_screen_dev_enable", false) || !optJSONObject.optBoolean("prop.s_notify_screen_dev_did", false)) {
                    zArr[0] = false;
                } else {
                    zArr[0] = true;
                }
            }

            public void onFailure(int i, String str) {
                zArr[0] = false;
            }
        }, Parser.DEFAULT_PARSER);
    }

    public void getTimeRange(String str, final String str2, final Callback<JSONObject> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str2);
            jSONObject.put("props", new JSONArray().put("prop.s_notify_screen_time_span"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        civ.O000000o("xm111", "url:/device/batchdevicedatas param:" + jSONObject + " current thread:" + Thread.currentThread().getName());
        XmPluginHostApi.instance().callSmartHomeApi(str, "/device/batchdevicedatas", new JSONArray().put(jSONObject).toString(), new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.camera.lowpower.LinkageManager.AnonymousClass14 */

            public void onSuccess(JSONObject jSONObject) {
                civ.O000000o("xm111", "url:/device/batchdevicedatas result ok:" + jSONObject + " current thread:" + Thread.currentThread().getName());
                if (jSONObject.optJSONObject(str2) == null) {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(-1, "return data null");
                        return;
                    }
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optJSONObject(str2).optString("prop.s_notify_screen_time_span", ""));
                    if (jSONObject2.has("timezone") && callback != null) {
                        callback.onSuccess(jSONObject2);
                        return;
                    }
                } catch (Exception unused) {
                }
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onFailure(-1, "return data null");
                }
            }

            public void onFailure(int i, String str) {
                civ.O000000o("xm111", "url:/device/batchdevicedatas result failed:error:" + i + " errorInfo:" + str + " current thread:" + Thread.currentThread().getName());
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public void setAlarmKey(String str, String str2, List<String> list, final Callback<JSONObject> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str2);
            JSONObject jSONObject2 = new JSONObject();
            int i = 0;
            while (i < list.size()) {
                StringBuilder sb = new StringBuilder();
                sb.append(LONG_TIME_KEY_PREFIX);
                int i2 = i + 1;
                sb.append(i2);
                jSONObject2.put(sb.toString(), list.get(i));
                i = i2;
            }
            jSONObject.put("props", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callSmartHomeApi(str, "/v2/device/set_props", jSONObject.toString(), new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.camera.lowpower.LinkageManager.AnonymousClass15 */

            public void onSuccess(JSONObject jSONObject) {
                if (callback != null) {
                    if (jSONObject.optJSONObject("prop_result") == null) {
                        callback.onFailure(-1, "");
                    } else {
                        callback.onSuccess(jSONObject);
                    }
                }
            }

            public void onFailure(int i, String str) {
                callback.onFailure(-1, "");
            }
        }, Parser.DEFAULT_PARSER);
    }

    public void submitTimeRange(String str, String str2, String str3, final Callback<JSONObject> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str2);
            jSONObject.put("props", new JSONObject().put("prop.s_notify_screen_time_span", str3));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        XmPluginHostApi.instance().callSmartHomeApi(str, "/v2/device/set_props", jSONObject.toString(), new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.camera.lowpower.LinkageManager.AnonymousClass16 */

            public void onSuccess(JSONObject jSONObject) {
                if (callback != null) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("prop_result");
                    if (optJSONObject == null) {
                        callback.onFailure(-1, "");
                    } else if (optJSONObject.optBoolean("prop.s_notify_screen_time_span", false)) {
                        callback.onSuccess(jSONObject);
                    } else {
                        callback.onFailure(-1, "");
                    }
                }
            }

            public void onFailure(int i, String str) {
                callback.onFailure(-1, "");
            }
        }, Parser.DEFAULT_PARSER);
    }

    public void restoreDeviceListFromJSON(String str, JSONArray jSONArray) {
        int length = jSONArray.length();
        int i = 0;
        while (i < length) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String next = optJSONObject.keys().next();
                LinkageDeviceInfo linkageDeviceInfo = new LinkageDeviceInfo(XmPluginHostApi.instance().getDeviceByDid(next), JSONUtil.toList(optJSONObject.optJSONArray(next)));
                linkageDeviceInfo.setBinded(linkageDeviceInfo.getConnectedDids().contains(str));
                linkageDeviceInfo.setSelected(linkageDeviceInfo.getConnectedDids().contains(str));
                this.mLinkageDeviceList.add(linkageDeviceInfo);
                i++;
            } else {
                return;
            }
        }
    }
}
