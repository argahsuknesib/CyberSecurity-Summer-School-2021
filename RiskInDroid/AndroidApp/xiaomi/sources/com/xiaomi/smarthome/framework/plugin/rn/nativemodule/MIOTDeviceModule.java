package com.xiaomi.smarthome.framework.plugin.rn.nativemodule;

import _m_j.ft;
import _m_j.fvo;
import _m_j.fyc;
import _m_j.fyf;
import _m_j.gbp;
import _m_j.gbq;
import _m_j.gbu;
import _m_j.gbz;
import _m_j.gdt;
import _m_j.gdv;
import _m_j.gfr;
import _m_j.gqb;
import _m_j.grv;
import _m_j.hxi;
import android.content.Intent;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.DeviceUpdateInfo;
import com.xiaomi.smarthome.device.api.MessageCallback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.ProductInfo;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.plugin.host.PluginHostApi;
import com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.plugin.Error;
import com.xiaomi.smarthome.plugin.devicesubscribe.PluginSubscribeCallback;
import com.xiaomi.smarthome.plugin.devicesubscribe.PluginUnSubscribeCallback;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class MIOTDeviceModule extends MIOTBaseJavaModule {
    private static final Parser<String> PARSERFORRAWRESULT = new PluginHostApi.ParserForRawResult<String>() {
        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTDeviceModule.AnonymousClass9 */

        public final /* bridge */ /* synthetic */ Object parse(String str) throws JSONException {
            return str;
        }
    };
    private static int PERMISSION_NONE_MASK = 30;
    private static int PERMISSION_OWNER = 16;
    private static List<Integer> mErrorcodesShowForDebug;

    public int convertRssiToSignal(int i) {
        if (i >= -50) {
            return 4;
        }
        if (i >= -70) {
            return 3;
        }
        if (i >= -90) {
            return 2;
        }
        return i >= -100 ? 1 : 0;
    }

    public String getName() {
        return "MIOTDevice";
    }

    static {
        ArrayList arrayList = new ArrayList();
        mErrorcodesShowForDebug = arrayList;
        arrayList.add(-9999);
        mErrorcodesShowForDebug.add(-12);
        mErrorcodesShowForDebug.add(-97);
        mErrorcodesShowForDebug.add(-4);
        mErrorcodesShowForDebug.add(-3);
        mErrorcodesShowForDebug.add(-1);
    }

    public MIOTDeviceModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        updateConfig();
    }

    private void updateConfig() {
        Observable.just(0).subscribeOn(Schedulers.io()).map(new Function<Integer, Object>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTDeviceModule.AnonymousClass1 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                Integer num = (Integer) obj;
                gbp.O000000o();
                return num;
            }
        }).subscribe();
    }

    public Map<String, Object> getConstants() {
        WritableMap _getCurrentDeviceInfo = _getCurrentDeviceInfo();
        HashMap hashMap = new HashMap();
        hashMap.put("currentDevice", _getCurrentDeviceInfo);
        return hashMap;
    }

    private WritableMap _getCurrentDeviceInfo() {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        device2Map(writableNativeMap, getDevice());
        PluginDeviceInfo pluginInfo = getPluginInfo();
        if (pluginInfo != null) {
            boolean z = true;
            if (pluginInfo.O0000o0o != 1) {
                z = false;
            }
            writableNativeMap.putBoolean("isVoiceDevice", z);
        }
        return writableNativeMap;
    }

    @ReactMethod
    public void getFreqFlag(Callback callback) {
        DeviceStat device = getDevice();
        if (device == null) {
            fyc.O00000o0("MIOTDeviceModule", "getFreqFlag: stat = null");
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "device is null"));
            return;
        }
        if (!TextUtils.isEmpty(device.model)) {
            boolean z = device.model.contains("camera") && !device.model.contains("mxiang.");
            if (z) {
                hxi.O00000o0.O00000Oo();
            }
            hxi.O00000o0.O00000o(z ? 1 : 2);
        }
        DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(device.did);
        if (deviceByDid != null) {
            callback.invoke(Boolean.TRUE, gbq.O000000o(0, Boolean.valueOf(deviceByDid.freqFlag)));
            return;
        }
        fyc.O00000o0("MIOTDeviceModule", "getFreqFlag:getDeviceByDid return null");
        callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "cur device is null"));
    }

    @ReactMethod
    public void getFreqCameraFlag(Callback callback) {
        DeviceStat device = getDevice();
        if (device == null) {
            fyc.O00000o0("MIOTDeviceModule", "getFreqCameraFlag: stat = null");
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "device is null"));
            return;
        }
        DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(device.did);
        if (deviceByDid != null) {
            callback.invoke(Boolean.TRUE, gbq.O000000o(0, Boolean.valueOf((deviceByDid.comFlag & 2) == 2)));
            return;
        }
        fyc.O00000o0("MIOTDeviceModule", "getFreqCameraFlag:getDeviceByDid return null");
        callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "cur device is null"));
    }

    @ReactMethod
    public void loadSubDevices(String str, final Callback callback) {
        if (TextUtils.isEmpty(str)) {
            callback.invoke(Boolean.FALSE, "did is empty...");
        } else if (getDevice() == null) {
            callback.invoke(Boolean.FALSE, "current device is null...");
        } else {
            XmPluginHostApi.instance().getSubDevice(getDevice().model, new String[]{str}, new com.xiaomi.smarthome.device.api.Callback<List<DeviceStat>>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTDeviceModule.AnonymousClass10 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    WritableNativeArray writableNativeArray = new WritableNativeArray();
                    for (DeviceStat deviceStat : (List) obj) {
                        WritableNativeMap writableNativeMap = new WritableNativeMap();
                        DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(deviceStat.did);
                        if (deviceByDid != null) {
                            MIOTDeviceModule.this.copyValueToAppDeviceStat(deviceStat, deviceByDid);
                            MIOTDeviceModule.device2Map(writableNativeMap, deviceByDid);
                        } else {
                            MIOTDeviceModule.device2Map(writableNativeMap, deviceStat);
                        }
                        writableNativeArray.pushMap(writableNativeMap);
                    }
                    callback.invoke(Boolean.TRUE, writableNativeArray);
                }

                public final void onFailure(int i, String str) {
                    callback.invoke(Boolean.FALSE, str);
                }
            });
        }
    }

    public void copyValueToAppDeviceStat(DeviceStat deviceStat, DeviceStat deviceStat2) {
        if (deviceStat != null && deviceStat2 != null) {
            deviceStat2.name = deviceStat.name;
        }
    }

    @ReactMethod
    public void getVersion(boolean z, final Callback callback) {
        DeviceStat device = getDevice();
        if (device == null) {
            callback.invoke(Boolean.FALSE, "has no device");
            return;
        }
        DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(device.did);
        if (deviceByDid == null || TextUtils.isEmpty(deviceByDid.version)) {
            XmPluginHostApi.instance().getUpdateInfo(device.model, device.did, device.pid, new com.xiaomi.smarthome.device.api.Callback<DeviceUpdateInfo>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTDeviceModule.AnonymousClass11 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    callback.invoke(Boolean.TRUE, ((DeviceUpdateInfo) obj).mCurVersion);
                }

                public final void onFailure(int i, String str) {
                    Callback callback = callback;
                    callback.invoke(Boolean.FALSE, i + str);
                }
            });
            return;
        }
        callback.invoke(Boolean.TRUE, deviceByDid.version);
    }

    public void showErrorInfoForDebug(int i, String str) {
        if (gfr.O0000OOo && mErrorcodesShowForDebug.contains(Integer.valueOf(i))) {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            gbz.O000000o(reactApplicationContext, "errorcode: " + i + ", info: " + str);
        }
    }

    @ReactMethod
    public void callMethod(String str, String str2, String str3, String str4, final Callback callback) {
        try {
            DeviceStat device = getDevice();
            boolean O00000Oo = gbp.O00000Oo();
            gbu.O000000o("MIOTDeviceModule#callMethod,needCheckDid:".concat(String.valueOf(O00000Oo)));
            if (!O00000Oo || TextUtils.isEmpty(str) || device == null || str.equalsIgnoreCase(device.did) || str.equalsIgnoreCase(device.parentId)) {
                JSONObject jSONObject = str4 == null ? new JSONObject() : new JSONObject(str4);
                jSONObject.put("id", ((PluginHostApi) XmPluginHostApi.instance()).generateNonce());
                jSONObject.put("method", str2);
                if (str3 == null) {
                    str3 = "";
                }
                jSONObject.put("params", new JSONTokener(str3).nextValue());
                AnonymousClass12 r9 = null;
                if (callback != null) {
                    r9 = new com.xiaomi.smarthome.device.api.Callback<String>() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTDeviceModule.AnonymousClass12 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            String str = (String) obj;
                            try {
                                WritableMap createMap = Arguments.createMap();
                                fyf.O000000o(new JSONObject(str), createMap);
                                callback.invoke(Boolean.TRUE, createMap);
                            } catch (JSONException unused) {
                                callback.invoke(Boolean.TRUE, str);
                            }
                        }

                        public final void onFailure(int i, String str) {
                            MIOTDeviceModule.this.showErrorInfoForDebug(i, str);
                            WritableNativeMap writableNativeMap = new WritableNativeMap();
                            writableNativeMap.putInt("error", i);
                            writableNativeMap.putString("message", str);
                            callback.invoke(Boolean.FALSE, writableNativeMap);
                        }
                    };
                }
                XmPluginHostApi.instance().callMethod(str, jSONObject.toString(), r9, MIOTServiceModule.PARSERFORRAWRESULT);
                return;
            }
            gbu.O000000o("MIOTDeviceModule#callMethod,parameter error,invalid did:".concat(String.valueOf(str)));
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putInt("error", -101);
            writableNativeMap.putString("message", "parameter error,invalid did");
            callback.invoke(Boolean.FALSE, writableNativeMap);
        } catch (Throwable th) {
            if (callback != null) {
                callback.invoke(Boolean.FALSE, Log.getStackTraceString(th));
            }
        }
    }

    @ReactMethod
    public void callMethodFromLocal(String str, String str2, String str3, String str4, Callback callback) {
        if (callback != null) {
            try {
                DeviceStat device = getDevice();
                if (!device.did.equals(str)) {
                    device = XmPluginHostApi.instance().getDeviceByDid(str);
                }
                if (device.location != 1) {
                    final String str5 = str;
                    final String str6 = str2;
                    final String str7 = str3;
                    final String str8 = str4;
                    final Callback callback2 = callback;
                    XmPluginHostApi.instance().localPing(str, new com.xiaomi.smarthome.device.api.Callback<Void>() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTDeviceModule.AnonymousClass13 */

                        public final void onFailure(int i, String str) {
                            if (MIOTDeviceModule.this.getDevice().did.equals(str5)) {
                                MIOTDeviceModule.this.getDevice().location = 0;
                            }
                            callback2.invoke(Boolean.FALSE, gbq.O000000o(i, str));
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            gbu.O000000o("localPing is success...");
                            if (MIOTDeviceModule.this.getDevice().did.equals(str5)) {
                                MIOTDeviceModule.this.getDevice().location = 1;
                            }
                            MIOTDeviceModule.this.callMethodFromLocalWithoutLocalPint(str5, str6, str7, str8, callback2);
                        }
                    });
                    return;
                }
                callMethodFromLocalWithoutLocalPint(str, str2, str3, str4, callback);
            } catch (Exception e) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, e.toString()));
            }
        }
    }

    public void callMethodFromLocalWithoutLocalPint(String str, String str2, String str3, String str4, final Callback callback) {
        JSONObject jSONObject;
        AnonymousClass14 r0 = callback != null ? new com.xiaomi.smarthome.device.api.Callback<String>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTDeviceModule.AnonymousClass14 */

            public final /* synthetic */ void onSuccess(Object obj) {
                String str = (String) obj;
                try {
                    WritableMap createMap = Arguments.createMap();
                    fyf.O000000o(new JSONObject(str), createMap);
                    callback.invoke(Boolean.TRUE, createMap);
                } catch (JSONException unused) {
                    callback.invoke(Boolean.TRUE, str);
                }
            }

            public final void onFailure(int i, String str) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putInt("error", i);
                writableNativeMap.putString("message", str);
                callback.invoke(Boolean.FALSE, writableNativeMap);
            }
        } : null;
        if (str4 == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable th) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, th.toString()));
                return;
            }
        } else {
            jSONObject = new JSONObject(str4);
        }
        jSONObject.put("id", ((PluginHostApi) XmPluginHostApi.instance()).generateNonce());
        jSONObject.put("method", str2);
        if (str3 == null) {
            str3 = "";
        }
        jSONObject.put("params", new JSONTokener(str3).nextValue());
        XmPluginHostApi.instance().callMethodFromLocal(str, jSONObject.toString(), r0, MIOTServiceModule.PARSERFORRAWRESULT);
    }

    @ReactMethod
    public void localPingWithCallback(String str, Callback callback) {
        int i;
        int i2;
        try {
            if (gfr.O0000Oo || gfr.O0000OOo) {
                fvo.O000000o();
                int[] O0000o0O = fvo.O0000o0O();
                if (O0000o0O[0] > 0 && O0000o0O[1] > 0) {
                    int i3 = O0000o0O[0];
                    i2 = O0000o0O[1] * 1000;
                    i = i3;
                    final String str2 = str;
                    final int i4 = i2;
                    final int i5 = i;
                    final Callback callback2 = callback;
                    XmPluginHostApi.instance().localPingWithParams(str, i2, i, new com.xiaomi.smarthome.device.api.Callback<Void>() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTDeviceModule.AnonymousClass15 */

                        public final void onFailure(int i, String str) {
                            if (gfr.O0000Oo || gfr.O0000OOo) {
                                gbu.O0000O0o("local ping error  did: " + str2 + "  timeout: " + i4 + "  retry: " + i5 + "  errorCode: " + str + "  errorInfo: " + str);
                            }
                            Callback callback = callback2;
                            callback.invoke(Boolean.FALSE, i + str);
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            if (gfr.O0000Oo || gfr.O0000OOo) {
                                gbu.O0000O0o("local ping success  did: " + str2 + "  timeout: " + i4 + "  retry: " + i5);
                            }
                            callback2.invoke(Boolean.TRUE);
                        }
                    });
                }
            }
            i2 = 2000;
            i = 3;
            final String str22 = str;
            final int i42 = i2;
            final int i52 = i;
            final Callback callback22 = callback;
            XmPluginHostApi.instance().localPingWithParams(str, i2, i, new com.xiaomi.smarthome.device.api.Callback<Void>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTDeviceModule.AnonymousClass15 */

                public final void onFailure(int i, String str) {
                    if (gfr.O0000Oo || gfr.O0000OOo) {
                        gbu.O0000O0o("local ping error  did: " + str22 + "  timeout: " + i42 + "  retry: " + i52 + "  errorCode: " + str + "  errorInfo: " + str);
                    }
                    Callback callback = callback22;
                    callback.invoke(Boolean.FALSE, i + str);
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    if (gfr.O0000Oo || gfr.O0000OOo) {
                        gbu.O0000O0o("local ping success  did: " + str22 + "  timeout: " + i42 + "  retry: " + i52);
                    }
                    callback22.invoke(Boolean.TRUE);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @ReactMethod
    public void callMethodFromCloud(String str, String str2, String str3, String str4, final Callback callback) {
        try {
            boolean O00000Oo = gbp.O00000Oo();
            fyc.O00000Oo("MIOTDeviceModule", "callMethodFromCloud,needCheckDid:".concat(String.valueOf(O00000Oo)));
            DeviceStat device = getDevice();
            if (!O00000Oo || TextUtils.isEmpty(str) || device == null || str.equalsIgnoreCase(device.did) || str.equalsIgnoreCase(device.parentId)) {
                JSONObject jSONObject = str4 == null ? new JSONObject() : new JSONObject(str4);
                jSONObject.put("id", ((PluginHostApi) XmPluginHostApi.instance()).generateNonce());
                jSONObject.put("method", str2);
                jSONObject.put("params", new JSONTokener(str3).nextValue());
                XmPluginHostApi.instance().callMethodFromCloud(str, jSONObject.toString(), new com.xiaomi.smarthome.device.api.Callback<String>() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTDeviceModule.AnonymousClass16 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        String str = (String) obj;
                        try {
                            WritableMap createMap = Arguments.createMap();
                            fyf.O000000o(new JSONObject(str), createMap);
                            callback.invoke(Boolean.TRUE, createMap);
                        } catch (JSONException unused) {
                            callback.invoke(Boolean.TRUE, str);
                        }
                    }

                    public final void onFailure(int i, String str) {
                        MIOTDeviceModule.this.showErrorInfoForDebug(i, str);
                        WritableNativeMap writableNativeMap = new WritableNativeMap();
                        writableNativeMap.putInt("error", i);
                        writableNativeMap.putString("message", str);
                        callback.invoke(Boolean.FALSE, writableNativeMap);
                    }
                }, MIOTServiceModule.PARSERFORRAWRESULT);
                return;
            }
            fyc.O00000Oo("MIOTDeviceModule", "callMethodFromCloud,parameter error,invalid did:".concat(String.valueOf(str)));
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putInt("error", -101);
            writableNativeMap.putString("message", "parameter error,invalid did");
            callback.invoke(Boolean.FALSE, writableNativeMap);
        } catch (Throwable th) {
            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
            writableNativeMap2.putInt("error", -1);
            writableNativeMap2.putString("message", Log.getStackTraceString(th));
            callback.invoke(Boolean.FALSE, writableNativeMap2);
        }
    }

    @ReactMethod
    public void subscribeMessages(String str, final ReadableArray readableArray, final Callback callback) {
        DeviceStat device = getDevice();
        PluginDeviceInfo pluginInfo = getPluginInfo();
        gbu.O0000O0o("================开始订阅=====================");
        gbu.O0000O0o(readableArray.toString());
        if (pluginInfo == null || device == null) {
            callback.invoke(Boolean.FALSE, "no device pluginRecord ");
            return;
        }
        String str2 = str;
        XmPluginHostApi.instance().subscribeDeviceV2(str2, device.pid, Arguments.toList(readableArray), 10, new PluginSubscribeCallback() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTDeviceModule.AnonymousClass17 */
            private String O00000o;

            public final void onReceive(String str, String str2, JSONArray jSONArray) {
                gbu.O0000O0o("收到消息: subId=" + this.O00000o + "  data=" + jSONArray.toString());
                ReactApplicationContext reactApplicationContext = MIOTDeviceModule.this.getReactApplicationContext();
                if (reactApplicationContext != null && jSONArray != null) {
                    ft.O000000o(reactApplicationContext).O000000o(new Intent().setAction("devicestatuschanged").putExtra("emit_data", jSONArray.toString()).putExtra("emit_subid", this.O00000o).putExtra("emit_did", str));
                }
            }

            public final void onSuccess(String str) {
                this.O00000o = str;
                gbu.O0000O0o("订阅成功:  subId=" + str + "  " + readableArray.toString());
                gbu.O000000o("   subscribeEvent : onSuccess".concat(String.valueOf(str)));
                Callback callback = callback;
                if (callback != null) {
                    callback.invoke(Boolean.TRUE, str);
                }
            }

            public final void onFailure(Error error) {
                gbu.O0000O0o("订阅失败: " + readableArray.toString() + "\n error=" + error.toString());
                gbu.O00000Oo("   subscribeEvent : onFailure   ".concat(String.valueOf(error)));
                Callback callback = callback;
                if (callback != null) {
                    callback.invoke(Boolean.FALSE, String.valueOf(error));
                }
            }
        });
    }

    @ReactMethod
    public void unsubscribeMessages(String str, ReadableArray readableArray, String str2, final Callback callback) {
        DeviceStat device = getDevice();
        if (getPluginInfo() == null || device == null) {
            callback.invoke(Boolean.FALSE, "no device pluginRecord ");
            return;
        }
        String str3 = str;
        XmPluginHostApi.instance().unsubscribeDeviceV2(str3, device.pid, Arguments.toList(readableArray), str2, new PluginUnSubscribeCallback() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTDeviceModule.AnonymousClass2 */

            public final void onSuccess() {
                Callback callback = callback;
                if (callback != null) {
                    callback.invoke(Boolean.TRUE);
                }
                fyc.O00000Oo("ReactNative", "   unsubscribeEvent : onSuccess");
            }

            public final void onFailure(Error error) {
                Callback callback = callback;
                if (callback != null) {
                    callback.invoke(Boolean.FALSE);
                }
                fyc.O00000Oo("ReactNative", "   unsubscribeEvent : onFailure   ".concat(String.valueOf(error)));
            }
        });
    }

    @ReactMethod
    public void readDeviceNetWorkInfo(String str, Callback callback) {
        if (callback != null) {
            DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
            if (deviceByDid != null) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("bssid", deviceByDid.bssid);
                writableNativeMap.putString("ssid", deviceByDid.ssid);
                writableNativeMap.putInt("rssi", deviceByDid.rssi);
                callback.invoke(Boolean.TRUE, writableNativeMap);
                return;
            }
            callback.invoke(Boolean.FALSE, "device info is null, please  insure your did is right!");
        }
    }

    @ReactMethod
    public void requestAuthorizedDeviceListData(String str, Callback callback) {
        List<DeviceStat> filterBluetoothDeviceList = XmPluginHostApi.instance().getFilterBluetoothDeviceList(str);
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (DeviceStat next : filterBluetoothDeviceList) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            device2Map(writableNativeMap, next);
            ProductInfo productInfo = XmPluginHostApi.instance().getProductInfo(next.model);
            writableNativeMap.putInt("product_id", productInfo.productId);
            writableNativeMap.putString("product_name", productInfo.name);
            writableNativeArray.pushMap(writableNativeMap);
        }
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        writableNativeMap2.putArray("result", writableNativeArray);
        callback.invoke(Boolean.TRUE, writableNativeMap2);
    }

    @ReactMethod
    public void reportDeviceGPSInfo(final Callback callback) {
        if (callback != null) {
            DeviceStat device = getDevice();
            if (device == null) {
                callback.invoke(Boolean.FALSE, "device is null...");
                return;
            }
            XmPluginHostApi.instance().reportDeviceGPSInfo(device.did, new com.xiaomi.smarthome.device.api.Callback<JSONObject>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTDeviceModule.AnonymousClass3 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    WritableMap createMap = Arguments.createMap();
                    if (jSONObject != null) {
                        createMap.putString("longitude", jSONObject.optString("longitude"));
                        createMap.putString("latitude", jSONObject.optString("latitude"));
                        createMap.putString("adminArea", jSONObject.optString("adminArea"));
                        createMap.putString("countryCode", jSONObject.optString("countryCode"));
                        createMap.putString("locality", jSONObject.optString("locality"));
                        createMap.putString("thoroughfare", jSONObject.optString("thoroughfare"));
                        createMap.putString("subLocality", jSONObject.optString("subLocality"));
                        try {
                            DeviceStat device = MIOTDeviceModule.this.getDevice();
                            device.latitude = Double.parseDouble(jSONObject.optString("latitude"));
                            device.longitude = Double.parseDouble(jSONObject.optString("longitude"));
                        } catch (NumberFormatException e) {
                            gbu.O00000Oo(e.toString());
                        }
                    }
                    callback.invoke(Boolean.TRUE, createMap);
                }

                public final void onFailure(int i, String str) {
                    callback.invoke(Boolean.FALSE, str);
                }
            });
        }
    }

    @ReactMethod
    public void getLinkedBTDevices(String str, final Callback callback) {
        if (callback != null) {
            DeviceStat device = getDevice();
            if (device == null) {
                callback.invoke(Boolean.FALSE, "current device is null... ");
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str) || (!str.equals(device.did) && !str.equals(device.parentId))) {
                callback.invoke(Boolean.FALSE, "did is empty...");
                return;
            }
            arrayList.add(str);
            XmPluginHostApi.instance().getBleGatewaySubDevices(arrayList, new com.xiaomi.smarthome.device.api.Callback<List<DeviceStat>>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTDeviceModule.AnonymousClass4 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    List list = (List) obj;
                    WritableArray createArray = Arguments.createArray();
                    WritableArray createArray2 = Arguments.createArray();
                    if (list != null && list.size() > 0) {
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            String string = ((DeviceStat) list.get(i)).property == null ? "" : ((DeviceStat) list.get(i)).property.getString("deviceGatewayType");
                            WritableMap createMap = Arguments.createMap();
                            ((DeviceStat) list.get(i)).rssi = MIOTDeviceModule.this.convertRssiToSignal(((DeviceStat) list.get(i)).rssi);
                            MIOTDeviceModule.device2Map(createMap, (DeviceStat) list.get(i));
                            if ("mesh".equalsIgnoreCase(string)) {
                                createArray.pushMap(createMap);
                            } else {
                                createArray2.pushMap(createMap);
                            }
                        }
                    }
                    callback.invoke(Boolean.TRUE, MIOTDeviceModule.this.combineBleGatewayDevice(createArray, createArray2));
                }

                public final void onFailure(int i, String str) {
                    callback.invoke(Boolean.FALSE, str);
                }
            });
        }
    }

    @ReactMethod
    public void getDeviceTimeZone(final String str, final Callback callback) {
        if (getCurrentActivity() == null) {
            callback.invoke(Boolean.FALSE, "current activity is null...");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject.put("did", str);
            jSONArray.put("timezone");
            jSONObject.put("keys", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        XmPluginHostApi.instance().callSmartHomeApi((String) null, "/v2/device/get_extra_data", jSONObject.toString(), new com.xiaomi.smarthome.device.api.Callback<String>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTDeviceModule.AnonymousClass5 */

            public final /* synthetic */ void onSuccess(Object obj) {
                String str = (String) obj;
                if (TextUtils.isEmpty(str)) {
                    callback.invoke(Boolean.TRUE, Arguments.createMap());
                    return;
                }
                try {
                    String str2 = (String) new JSONObject(str).getJSONObject("result").getJSONObject("data").get("timezone");
                    if (TextUtils.isEmpty(str2)) {
                        callback.invoke(Boolean.TRUE, Arguments.createMap());
                        return;
                    }
                    TimeZone timeZone = TimeZone.getTimeZone(str2);
                    TimeZone timeZone2 = TimeZone.getDefault();
                    TimeZone.setDefault(timeZone);
                    String displayName = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
                    TimeZone.setDefault(timeZone2);
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("timeZone", displayName);
                    createMap.putString("timeZoneId", str2);
                    createMap.putString("did", str);
                    callback.invoke(Boolean.TRUE, createMap);
                } catch (JSONException e) {
                    gbu.O00000Oo(e.toString());
                    callback.invoke(Boolean.FALSE, e.toString());
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                callback.invoke(Boolean.FALSE, "error: " + i + ",  " + str);
            }
        }, PARSERFORRAWRESULT);
    }

    @ReactMethod
    public void changeDeviceName(final String str, String str2, final Callback callback) {
        DeviceStat deviceStat;
        DeviceStat device = getDevice();
        if (TextUtils.isEmpty(str2)) {
            if (device == null) {
                callback.invoke(Boolean.FALSE, "this did and current device is empty, change device name failed...");
                return;
            }
            str2 = device.did;
            deviceStat = null;
        } else if (device == null) {
            callback.invoke(Boolean.FALSE, "current device is empty, change device name failed...");
            return;
        } else {
            deviceStat = XmPluginHostApi.instance().getDeviceByDid(str2);
            if (deviceStat == null || !device.did.equals(deviceStat.parentId)) {
                callback.invoke(Boolean.FALSE, "this device is not current child device, change device name failed...");
                return;
            }
        }
        if (TextUtils.isEmpty(str)) {
            callback.invoke(Boolean.FALSE, "new name is empty");
        } else if (device.did.equals(str2) && str.equals(device.name)) {
            callback.invoke(Boolean.FALSE, "update current device name, new name is same with current device name");
        } else if (deviceStat != null && deviceStat.did.equals(str2) && str.equals(deviceStat.name)) {
            callback.invoke(Boolean.FALSE, "update child device name, new name is same with child device name");
        } else if (gqb.O00000Oo(str.trim())) {
            callback.invoke(Boolean.FALSE, "new name contains not support emoji");
        } else if (gqb.O000000o((CharSequence) str.trim()) > 40) {
            callback.invoke(Boolean.FALSE, "Chinese length should not exceed 20, English length should not exceed 40");
        } else {
            XmPluginHostApi.instance().modDeviceName(str2, str, new com.xiaomi.smarthome.device.api.Callback<Void>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTDeviceModule.AnonymousClass6 */

                public final void onFailure(int i, String str) {
                    Callback callback = callback;
                    callback.invoke(Boolean.FALSE, "errorCode: " + i + ",  errorInfo: " + str);
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    callback.invoke(Boolean.TRUE, str);
                }
            });
        }
    }

    @ReactMethod
    public void getRecommendScenes(String str, String str2, final Callback callback) {
        if (callback != null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                callback.invoke(Boolean.FALSE, "model or did is empty...");
                return;
            }
            XmPluginHostApi.instance().getRecommendScenes(str, str2, new com.xiaomi.smarthome.device.api.Callback<JSONObject>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTDeviceModule.AnonymousClass7 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    callback.invoke(Boolean.TRUE, jSONObject.toString());
                }

                public final void onFailure(int i, String str) {
                    Callback callback = callback;
                    callback.invoke(Boolean.FALSE, "code: " + i + "   errorInfo: " + str);
                }
            });
        }
    }

    @ReactMethod
    public void getCurrentDeviceValue(Callback callback) {
        DeviceStat device = getDevice();
        if (device == null) {
            callback.invoke(Boolean.FALSE, "device is null...");
            return;
        }
        JSONArray deviceProp = XmPluginHostApi.instance().getDeviceProp(device.did);
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (deviceProp != null) {
            for (int i = 0; i < deviceProp.length(); i++) {
                try {
                    JSONObject jSONObject = deviceProp.getJSONObject(i);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next != null) {
                            if (next.startsWith("prop.") || next.startsWith("event.")) {
                                writableNativeMap.putString(next, jSONObject.optString(next));
                            } else {
                                writableNativeMap.putString("prop.".concat(String.valueOf(next)), jSONObject.optString(next));
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            callback.invoke(Boolean.TRUE, writableNativeMap);
            return;
        }
        callback.invoke(Boolean.FALSE, "deviceProp is null... ");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056  */
    @ReactMethod
    public void getRoomInfoForCurrentHome(String str, Callback callback) {
        Room room;
        if (TextUtils.isEmpty(str)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "did is empty"));
            return;
        }
        Home home = null;
        try {
            room = ((gdt) gdv.f17570O000000o.getServiceInterface()).O00000oO(str);
            try {
                home = ((gdt) gdv.f17570O000000o.getServiceInterface()).O00000o(str);
            } catch (RemoteException e) {
                e = e;
                fyc.O000000o("MIOTDeviceModule", "getRoomInfoForCurrentHome error:", e);
                if (room == null) {
                }
            }
        } catch (RemoteException e2) {
            e = e2;
            room = null;
            fyc.O000000o("MIOTDeviceModule", "getRoomInfoForCurrentHome error:", e);
            if (room == null) {
            }
        }
        if (room == null) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "room not found"));
        } else if (home == null) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-3, "home not found"));
        } else {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("roomId", room.getId());
            createMap.putString("roomName", room.getName());
            createMap.putString("homeId", home.getId());
            createMap.putString("homeName", home.getRawName());
            callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
        }
    }

    @ReactMethod
    public void sendKeyFramePayLoad(String str, int i, String str2, final Callback callback) {
        if (callback != null) {
            DeviceStat device = getDevice();
            if (device == null) {
                RnApiErrorInfo rnApiErrorInfo = RnApiErrorInfo.DEVICE_ERROR;
                callback.invoke(Boolean.FALSE, gbq.O000000o(rnApiErrorInfo.getCode(), rnApiErrorInfo.getMessage()));
            } else if (TextUtils.isEmpty(str)) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.PARAMS_ERROR, "params payload is empty..."));
            } else {
                ((gdt) gdv.f17570O000000o.getServiceInterface()).O000000o(str, device, i, str2, new MessageCallback() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTDeviceModule.AnonymousClass8 */

                    public final void onSuccess(Intent intent) {
                        if (intent == null) {
                            callback.invoke(Boolean.TRUE, "");
                            return;
                        }
                        String stringExtra = intent.getStringExtra("result");
                        try {
                            WritableMap createMap = Arguments.createMap();
                            fyf.O000000o(new JSONObject(stringExtra), createMap);
                            callback.invoke(Boolean.TRUE, createMap);
                        } catch (Exception unused) {
                            callback.invoke(Boolean.TRUE, stringExtra);
                        }
                    }

                    public final void onFailure(int i, String str) {
                        callback.invoke(Boolean.FALSE, gbq.O000000o(i, str));
                    }
                });
            }
        }
    }

    @ReactMethod
    public final void getAllDevicesOfBelongedCompanies(Callback callback) {
        DeviceStat device = getDevice();
        if (device == null) {
            fyc.O00000o0("MIOTDeviceModule", "getAllDevicesOfBelongedCompanies：deviceStat is null");
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "cannot get current device info"));
            return;
        }
        String companyIdentifierByModel = getCompanyIdentifierByModel(device.model);
        if (TextUtils.isEmpty(companyIdentifierByModel)) {
            fyc.O00000o0("MIOTDeviceModule", "getAllDevicesOfBelongedCompanies,get company identifier error:" + device.model);
            callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "get company identifier error"));
            return;
        }
        List<DeviceStat> deviceList = XmPluginHostApi.instance().getDeviceList();
        WritableArray createArray = Arguments.createArray();
        if (deviceList != null) {
            for (DeviceStat next : deviceList) {
                if (TextUtils.equals(companyIdentifierByModel, getCompanyIdentifierByModel(next.model))) {
                    WritableMap createMap = Arguments.createMap();
                    device2Map(createMap, next);
                    createArray.pushMap(createMap);
                }
            }
        }
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, createArray));
    }

    private String getCompanyIdentifierByModel(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str) && (split = str.split("\\.")) != null && split.length > 0 && !TextUtils.isEmpty(split[0])) {
            return split[0];
        }
        return "";
    }

    public WritableMap combineBleGatewayDevice(WritableArray writableArray, WritableArray writableArray2) {
        WritableMap createMap = Arguments.createMap();
        createMap.putArray("mesh", writableArray);
        createMap.putArray("normal", writableArray2);
        return createMap;
    }

    private static final String NVL(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        String obj2 = obj.toString();
        if (obj2 == null) {
            return "";
        }
        return obj2;
    }

    public static void device2Map(WritableMap writableMap, DeviceStat deviceStat) {
        convertDeviceStat2Map(writableMap, deviceStat);
        if (deviceStat != null && !TextUtils.isEmpty(deviceStat.parentId)) {
            writableMap.putMap("parentDevice", parentDvice2Map(deviceStat.parentId));
        }
    }

    private static WritableMap parentDvice2Map(String str) {
        WritableMap createMap = Arguments.createMap();
        if (TextUtils.isEmpty(str)) {
            return createMap;
        }
        convertDeviceStat2Map(createMap, XmPluginHostApi.instance().getDeviceByDid(str));
        return createMap;
    }

    private static void convertDeviceStat2Map(WritableMap writableMap, DeviceStat deviceStat) {
        if (deviceStat != null && writableMap != null) {
            writableMap.putString("model", NVL(deviceStat.model));
            writableMap.putString("did", NVL(deviceStat.did));
            writableMap.putString("mac", NVL(deviceStat.mac));
            writableMap.putString("name", NVL(deviceStat.name));
            writableMap.putInt("permitLevel", deviceStat.permitLevel);
            writableMap.putString("extrainfo", NVL(deviceStat.extrainfo));
            writableMap.putString("ownerName", NVL(deviceStat.ownerName));
            if (!TextUtils.isEmpty(deviceStat.ownerId) || !isOwner(deviceStat.permitLevel)) {
                writableMap.putString("ownerId", NVL(deviceStat.ownerId));
            } else {
                writableMap.putString("ownerId", NVL(XmPluginHostApi.instance().getAccountId()));
            }
            writableMap.putString("bssid", NVL(deviceStat.bssid));
            writableMap.putString("deviceIconReal", NVL(deviceStat.deviceIconReal));
            writableMap.putString("iconURL", NVL(deviceStat.deviceIconReal));
            writableMap.putString("event", NVL(deviceStat.event));
            writableMap.putString("ip", NVL(deviceStat.ip));
            writableMap.putBoolean("isOnline", deviceStat.isOnline);
            writableMap.putInt("isSetPinCode", deviceStat.isSetPinCode);
            writableMap.putString("parentId", NVL(deviceStat.parentId));
            writableMap.putString("parentModel", NVL(deviceStat.parentModel));
            writableMap.putString("lastModified", NVL(String.valueOf(deviceStat.lastModified)));
            writableMap.putString("session", NVL(grv.O000000o(NVL(deviceStat.token) + "4E60D36E")).toUpperCase());
            writableMap.putInt("location", deviceStat.location);
            writableMap.putString("latitude", Double.toString(deviceStat.latitude));
            writableMap.putString("longitude", Double.toString(deviceStat.longitude));
            writableMap.putString("pid", NVL(String.valueOf(deviceStat.pid)));
            writableMap.putString("rssi", NVL(String.valueOf(deviceStat.rssi)));
            writableMap.putInt("resetFlag", deviceStat.resetFlag);
            writableMap.putString("ssid", NVL(deviceStat.ssid));
            writableMap.putString("version", NVL(deviceStat.version));
            writableMap.putInt("showMode", deviceStat.showMode);
            writableMap.putString("propInfo", NVL(deviceStat.propInfo));
            writableMap.putBoolean("isGrouped", deviceStat.isGrouped);
            double d = 0.0d;
            if (!TextUtils.isEmpty(deviceStat.orderTimeJString)) {
                try {
                    d = Double.parseDouble(deviceStat.orderTimeJString);
                } catch (Exception e) {
                    fyc.O00000o("MIOTDeviceModule", Log.getStackTraceString(e));
                }
            }
            writableMap.putDouble("orderTime", d);
        }
    }

    private static boolean isOwner(int i) {
        return ((i & PERMISSION_NONE_MASK) & PERMISSION_OWNER) != 0;
    }
}
