package com.xiaomi.smarthome.framework.plugin.rn.nativemodule;

import _m_j.fwx;
import _m_j.fwy;
import _m_j.fwz;
import _m_j.fxi;
import _m_j.fxx;
import _m_j.fya;
import _m_j.fyc;
import _m_j.fyf;
import _m_j.gat;
import _m_j.gav;
import _m_j.gax;
import _m_j.gbj;
import _m_j.gbq;
import _m_j.gbu;
import _m_j.gbw;
import _m_j.gdu;
import _m_j.gdv;
import _m_j.gfr;
import _m_j.gsy;
import _m_j.hsi;
import _m_j.hxh;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity;
import com.xiaomi.smarthome.library.log.LogType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class MIOTPackageModule extends MIOTBaseJavaModule {
    private static List<WeakReference<ReactInstanceManager>> ReactInstanceRef = new ArrayList(1);
    private final boolean isDebug;
    private boolean mIsFirstReportLoadTime = true;
    private boolean mIsFirstReportOpenTime = true;
    private boolean mIsFirstReportRenderTime = true;
    private HashMap<String, Long> mPluginHotLaunchTimeInfo = new HashMap<>();

    public String getName() {
        return "MIOTPackage";
    }

    public MIOTPackageModule(ReactApplicationContext reactApplicationContext, boolean z) {
        super(reactApplicationContext);
        this.isDebug = z;
        ReactInstanceRef.clear();
    }

    public Map<String, Object> getConstants() {
        return doGetConstants(fwz.O000000o().O00000Oo());
    }

    public Map<String, Object> getConstantsFromInputRNRuntime(fwy fwy) {
        return doGetConstants(fwy);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, int):int
     arg types: [com.facebook.react.bridge.WritableMap, java.lang.String, int]
     candidates:
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, double):double
      _m_j.fyf.O000000o(int, int, java.lang.String):java.lang.String
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, java.lang.String):java.lang.String
      _m_j.fyf.O000000o(com.facebook.react.bridge.ReadableMap, java.lang.String, int):int */
    private Map<String, Object> doGetConstants(fwy fwy) {
        HashMap hashMap = new HashMap();
        if (fwy == null) {
            return hashMap;
        }
        PluginPackageInfo pluginPackageInfo = fwy.O0000OoO;
        if (pluginPackageInfo != null) {
            hashMap.put("pluginID", Long.valueOf(pluginPackageInfo.O000000o()));
            hashMap.put("packageID", Long.valueOf(pluginPackageInfo.O00000Oo()));
            hashMap.put("packageName", pluginPackageInfo.O00000oo());
            hashMap.put("version", Integer.valueOf(pluginPackageInfo.O00000oO()));
            fyf.O000000o(pluginPackageInfo.O0000OoO(), "|");
            hashMap.put("models", getPluginInfo().O00000Oo());
        }
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        WritableMap createMap3 = Arguments.createMap();
        if (fwy.O0000o0 != null) {
            Bundle bundle = fwy.O0000o0;
            createMap3.putInt("package_msgType", bundle.getInt("package_msgType", 1));
            createMap3.putString("model", bundle.getString("model"));
            createMap3.putString("did", bundle.getString("did"));
            createMap3.putString("command", bundle.getString("action"));
            createMap3.putInt("id", bundle.getInt("actionId", -1));
            int i = bundle.getInt("scene_type", -1);
            if (i == 1) {
                String string = bundle.getString("last_value", "");
                if (TextUtils.isEmpty(string)) {
                    string = bundle.getString("value");
                }
                createMap3.putString("value", string);
            } else {
                createMap3.putString("value", bundle.getString("value"));
            }
            createMap3.putString("plug_id", bundle.getString("plug_id"));
            createMap3.putString("name", bundle.getString("name"));
            createMap3.putString("tr_id", bundle.getString("tr_id"));
            createMap3.putInt("scene_type", i);
            createMap3.putString("extra", bundle.getString("extra"));
        }
        int O000000o2 = fyf.O000000o((ReadableMap) createMap3, "package_msgType", 0);
        if (O000000o2 == 3) {
            createMap.putString("entrance", "scene");
            createMap2.putMap("payload", createMap3);
        } else if (O000000o2 == 1) {
            createMap.putString("entrance", "main");
            createMap2.putString("extra", fyf.O000000o(createMap3, "extra", ""));
        } else if (O000000o2 == 2) {
            createMap.putString("entrance", "main");
            addAppPushMessageInfo(fwy.O0000o0, createMap2);
        } else {
            createMap.putString("entrance", "main");
            gsy.O000000o(6, "MIOTPackageModule", "RN init activity is null");
        }
        Bundle bundle2 = fwy.O0000o0;
        if (bundle2 != null) {
            String string2 = bundle2.getString("pageName", "");
            String string3 = bundle2.getString("pageParams", new JSONObject().toString());
            if (!TextUtils.isEmpty(string2)) {
                createMap.putString("entrance", string2);
            }
            createMap2.putString("pageParams", string3);
            String string4 = bundle2.getString("nfc_extra_data", "");
            if (!TextUtils.isEmpty(string4)) {
                createMap2.putString("nfcdata", string4);
            }
            addSharePrinterArgsToInfo(createMap2, bundle2);
        }
        createMap.putMap("info", createMap2);
        hashMap.put("entryInfo", createMap);
        hashMap.put("buildType", this.isDebug ? "debug" : "release");
        hashMap.put("basePath", fwy.O0000Oo0.O00000o);
        hashMap.put("plugPath", fwy.O0000Oo);
        hashMap.put("localFilePath", getFilesPath().getAbsolutePath());
        hashMap.put("eventRandom", "_36621");
        gsy.O00000Oo("PluginStartTime", "ReactNativeGetConstants  " + System.currentTimeMillis());
        return hashMap;
    }

    private void addAppPushMessageInfo(Bundle bundle, WritableMap writableMap) {
        if (bundle != null && writableMap != null) {
            for (String next : bundle.keySet()) {
                try {
                    writableMap.putString(next, bundle.get(next).toString());
                } catch (Exception e) {
                    gbu.O00000Oo("MIOTPackageModule addAppPushMessageInfo-->" + e.toString());
                }
            }
        }
    }

    private void addSharePrinterArgsToInfo(WritableMap writableMap, Bundle bundle) {
        if (bundle != null && writableMap != null && bundle.getInt("source", 0) == 1) {
            WritableArray createArray = Arguments.createArray();
            Uri uri = (Uri) bundle.getParcelable("share_intent_data");
            if (uri == null) {
                uri = (Uri) bundle.getParcelable("android.intent.extra.STREAM");
            }
            if (uri == null) {
                fyc.O00000o0("MIOTPackageModule", "addSharePrinterArgsToInfo: fileUri is null");
                return;
            }
            createArray.pushString(uri.toString());
            WritableMap createMap = Arguments.createMap();
            createMap.putArray("photos", createArray);
            createMap.putString("mimeType", bundle.getString("share_intent_data_type"));
            writableMap.putMap("value", createMap.copy());
            writableMap.putMap("extra", createMap.copy());
            writableMap.putString("event", "share_print");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    @ReactMethod
    public final void setExitInfo(String str, Dynamic dynamic) {
        fwy O00000Oo = fwz.O000000o().O00000Oo();
        if (O00000Oo.O0000OOo != null) {
            Intent intent = O00000Oo.O0000OOo.getIntent();
            try {
                ReadableType type = dynamic.getType();
                if (type == ReadableType.String) {
                    JSONObject optJSONObject = new JSONObject(dynamic.asString()).optJSONObject("payload");
                    Object opt = optJSONObject.opt("value");
                    String optString = optJSONObject.optString("name");
                    gbu.O000000o("自能场景 entrance: " + str + "  extra: " + dynamic.asString() + "  value:" + opt + "  keyName: " + optString);
                    if (opt != null) {
                        if (opt instanceof Integer) {
                            intent.putExtra("value", ((Integer) opt).intValue());
                        } else if (opt instanceof Double) {
                            intent.putExtra("value", ((Double) opt).doubleValue());
                        } else if (opt instanceof Float) {
                            intent.putExtra("value", ((Float) opt).floatValue());
                        } else {
                            intent.putExtra("value", opt.toString());
                        }
                    }
                    intent.putExtra("key_name", optString);
                    intent.putExtra("isSaveEntrance", true);
                } else if (type == ReadableType.Map) {
                    ReadableMap O00000o0 = fyf.O00000o0(dynamic.asMap(), "payload");
                    String O000000o2 = fyf.O000000o(O00000o0, "value", "");
                    String O000000o3 = fyf.O000000o(O00000o0, "name", "");
                    gbu.O000000o("自能场景  entrance: " + str + "  value: " + O000000o2 + "  keyName: " + O000000o3);
                    intent.putExtra("value", O000000o2);
                    intent.putExtra("key_name", O000000o3);
                    intent.putExtra("isSaveEntrance", true);
                }
            } catch (Throwable th) {
                Log.e("ReactNativeJS", "MIOTPackage.setExitInfo", th);
            }
        }
    }

    public static final List getReactInstanceHolderForDetox() {
        return ReactInstanceRef;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01ff  */
    @ReactMethod
    public final void onPackageLifecycle(String str, String str2) {
        char c;
        long j;
        long j2;
        String str3 = str;
        boolean z = fwx.O000000o().O00000o;
        int hashCode = str.hashCode();
        if (hashCode != -1794592921) {
            if (hashCode != -176570662) {
                if (hashCode == 447167726 && str3.equals("willUnmount")) {
                    c = 2;
                    if (c != 0) {
                        hsi.O000000o("plugin componentWillMount");
                        DeviceStat device = getDevice();
                        PluginPackageInfo pluginPackageInfo = fwz.O000000o().O00000Oo().O0000OoO;
                        String statDevloperLabel = getStatDevloperLabel();
                        String O000000o2 = gbw.O000000o();
                        if (!(device == null || TextUtils.isEmpty(statDevloperLabel) || pluginPackageInfo == null)) {
                            long abs = Math.abs(System.currentTimeMillis() - fwx.O000000o().O00000Oo);
                            gsy.O000000o(4, "statistic-time", "statistic time:  rn plugin load time is " + abs + " and mIsFirstReportLoadTime is " + this.mIsFirstReportLoadTime + "  shouldReportTime: " + z);
                            if (abs >= 0 && abs < 60000 && z && this.mIsFirstReportLoadTime) {
                                this.mIsFirstReportLoadTime = false;
                                if (fwx.O000000o().O00000oO) {
                                    hxh.O00000o(statDevloperLabel, abs, getDevice().model, pluginPackageInfo.O000000o(), pluginPackageInfo.O00000Oo(), pluginPackageInfo.O00000oo(), O000000o2);
                                } else {
                                    hxh.O00000o0(statDevloperLabel, abs, getDevice().model, pluginPackageInfo.O000000o(), pluginPackageInfo.O00000Oo(), pluginPackageInfo.O00000oo(), O000000o2);
                                }
                                this.mPluginHotLaunchTimeInfo.put("plugin-load-time", Long.valueOf(abs));
                            }
                        }
                        int O000000o3 = gax.O000000o(fwz.O000000o().O00000Oo().O0000o0);
                        if (device != null && gax.O000000o(O000000o3, device.model)) {
                            gav.O000000o(device.model, pluginPackageInfo, "plugin_loaded");
                        }
                        fwx.O000000o().O00000Oo = 0;
                        fwx.O000000o().O00000o0 = System.currentTimeMillis();
                        return;
                    } else if (c == 1) {
                        if (hsi.O000000o() && gfr.O0000OoO) {
                            ReactInstanceRef.clear();
                            ReactInstanceRef.add(new WeakReference(fwz.O000000o().O00000Oo().O0000O0o));
                        }
                        hsi.O000000o("plugin componentDidMount");
                        hsi.O00000o0();
                        DeviceStat device2 = getDevice();
                        PluginPackageInfo pluginPackageInfo2 = fwz.O000000o().O00000Oo().O0000OoO;
                        String O000000o4 = gbw.O000000o();
                        String statDevloperLabel2 = getStatDevloperLabel();
                        long j3 = fwx.O000000o().O00000o0;
                        if (device2 != null && pluginPackageInfo2 != null && !TextUtils.isEmpty(statDevloperLabel2) && j3 > 0) {
                            long abs2 = Math.abs(System.currentTimeMillis() - j3);
                            gsy.O000000o(4, "statistic-time", "statistic time:  rn plugin render time is " + abs2 + " and mIsFirstReportRenderTime is " + this.mIsFirstReportRenderTime);
                            if (abs2 >= 0 && abs2 < 60000 && z && this.mIsFirstReportRenderTime) {
                                this.mIsFirstReportRenderTime = false;
                                if (fwx.O000000o().O00000oO) {
                                    j2 = abs2;
                                    hxh.O00000oo(statDevloperLabel2, abs2, getDevice().model, pluginPackageInfo2.O000000o(), pluginPackageInfo2.O00000Oo(), pluginPackageInfo2.O00000oo(), O000000o4);
                                } else {
                                    j2 = abs2;
                                    hxh.O00000oO(statDevloperLabel2, abs2, getDevice().model, pluginPackageInfo2.O000000o(), pluginPackageInfo2.O00000Oo(), pluginPackageInfo2.O00000oo(), O000000o4);
                                }
                                this.mPluginHotLaunchTimeInfo.put("plugin-render-time", Long.valueOf(j2));
                            }
                            long abs3 = Math.abs(System.currentTimeMillis() - fwx.O000000o().f17339O000000o);
                            gsy.O000000o(4, "statistic-time", "statistic time:  rn plugin open time is " + abs3 + " and mIsFirstReportOpenTime is " + this.mIsFirstReportOpenTime);
                            if (abs3 >= 0 && abs3 < 60000 && this.mIsFirstReportOpenTime) {
                                this.mIsFirstReportOpenTime = false;
                                if (fwx.O000000o().O00000oO) {
                                    if (z) {
                                        j = abs3;
                                        hxh.O00000Oo(statDevloperLabel2, abs3, getDevice().model, pluginPackageInfo2.O000000o(), pluginPackageInfo2.O00000Oo(), pluginPackageInfo2.O00000oo(), O000000o4);
                                        this.mPluginHotLaunchTimeInfo.put("plugin-start-time", Long.valueOf(j));
                                        fxi.O000000o(this.mPluginHotLaunchTimeInfo);
                                    } else {
                                        j = abs3;
                                    }
                                    fwz.O000000o().O000000o(true, j, z);
                                } else {
                                    long j4 = abs3;
                                    if (z) {
                                        hxh.O000000o(statDevloperLabel2, j4, getDevice().model, pluginPackageInfo2.O000000o(), pluginPackageInfo2.O00000Oo(), pluginPackageInfo2.O00000oo(), O000000o4);
                                        this.mPluginHotLaunchTimeInfo.put("plugin-start-time", Long.valueOf(j4));
                                        fxi.O000000o(this.mPluginHotLaunchTimeInfo);
                                    }
                                    fwz.O000000o().O000000o(false, j4, z);
                                }
                            }
                        }
                        int O000000o5 = gax.O000000o(fwz.O000000o().O00000Oo().O0000o0);
                        if (device2 != null && gax.O000000o(O000000o5, device2.model)) {
                            gav.O000000o(device2.model, pluginPackageInfo2, "plugin_rendered");
                        }
                        fwx.O000000o().O00000o0 = 0;
                        fwx.O000000o().f17339O000000o = 0;
                        return;
                    } else if (c == 2) {
                        ReactInstanceRef.clear();
                        resetFirstReportData();
                        return;
                    } else {
                        return;
                    }
                }
            } else if (str3.equals("didMount")) {
                c = 1;
                if (c != 0) {
                }
            }
        } else if (str3.equals("willMount")) {
            c = 0;
            if (c != 0) {
            }
        }
        c = 65535;
        if (c != 0) {
        }
    }

    private void resetFirstReportData() {
        this.mIsFirstReportOpenTime = true;
        this.mIsFirstReportLoadTime = true;
        this.mIsFirstReportRenderTime = true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    @ReactMethod
    public final void notifyCation(String str, String str2, String str3) {
        DeviceStat device = getDevice();
        Intent intent = new Intent("com.xiaomi.smarthome.action.viewdevice");
        intent.setComponent(new ComponentName(CommonApplication.getAppContext().getPackageName(), ((gdu) gdv.f17570O000000o.getUiInterface()).O000000o().getName()));
        intent.putExtra("device_mac", device.mac);
        intent.putExtra("device_id", device.did);
        intent.putExtra("source_tag", "short_cut");
        intent.putExtra("user_model", device.model);
        intent.putExtra("timestamp", System.currentTimeMillis());
        intent.putExtra("from_main_activity", true);
        intent.putExtra("extra", str3);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(CommonApplication.getAppContext());
        builder.O000000o(str);
        builder.O000000o((int) R.drawable.ic_launcher);
        builder.O000000o(System.currentTimeMillis());
        builder.O00000Oo();
        PendingIntent activity = PendingIntent.getActivity(CommonApplication.getAppContext(), R.string.app_name, intent, 134217728);
        builder.O00000Oo(str2);
        builder.O00000oo = activity;
        NotificationManager notificationManager = (NotificationManager) CommonApplication.getAppContext().getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.notify(device.did.hashCode(), builder.O00000o());
        }
    }

    @ReactMethod
    public void entry(Callback callback) {
        callback.invoke(new Object[0]);
    }

    @ReactMethod
    public void exit(boolean z, Callback callback) {
        callback.invoke(Boolean.TRUE);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getPluginAppConfigValueForKey(String str) {
        WritableMap createMap = Arguments.createMap();
        Object O00000Oo = gat.O00000Oo(str);
        fyc.O000000o("MIOTPackageModule", "getPluginAppConfigValueForKey,key:" + str + ",value:" + O00000Oo);
        if (O00000Oo == null) {
            createMap.putNull("value");
        } else if (O00000Oo instanceof String) {
            createMap.putString("value", (String) O00000Oo);
        } else if ((O00000Oo instanceof Integer) || (O00000Oo instanceof Long)) {
            createMap.putInt("value", ((Integer) O00000Oo).intValue());
        } else if (O00000Oo instanceof Double) {
            createMap.putDouble("value", ((Double) O00000Oo).doubleValue());
        } else if (O00000Oo instanceof Boolean) {
            createMap.putBoolean("value", ((Boolean) O00000Oo).booleanValue());
        } else if (O00000Oo instanceof JSONObject) {
            createMap.putMap("value", gbj.O000000o((JSONObject) O00000Oo));
        } else if (O00000Oo instanceof JSONArray) {
            createMap.putArray("value", gbj.O000000o((JSONArray) O00000Oo));
        } else {
            fyc.O00000o0("MIOTPackageModule", "getPluginAppConfigValueForKey,unsupport data type,key:" + str + ",value:" + O00000Oo);
            createMap.putNull("value");
        }
        return createMap;
    }

    @ReactMethod
    public void apiReport(ReadableMap readableMap) {
        String str;
        String str2;
        long j;
        long j2;
        gsy.O000000o(LogType.PLUGIN, "RnApp", "RnPluginLog", "miot-sdk-report:".concat(String.valueOf(readableMap)));
        PluginPackageInfo pluginPackageInfo = fwz.O000000o().O00000Oo().O0000OoO;
        String str3 = "";
        if (pluginPackageInfo != null) {
            long O00000Oo = pluginPackageInfo.O00000Oo();
            long O000000o2 = pluginPackageInfo.O000000o();
            PluginDeviceInfo pluginDeviceInfo = fwz.O000000o().O00000Oo().O0000Ooo;
            if (pluginDeviceInfo != null) {
                str3 = pluginDeviceInfo.O00000Oo();
            }
            str = pluginPackageInfo.O00000oo();
            str2 = str3;
            j2 = O00000Oo;
            j = O000000o2;
        } else {
            str2 = str3;
            str = str2;
            j2 = 0;
            j = 0;
        }
        gav.O000000o(j2, j, str2, str, readableMap);
    }

    @ReactMethod
    public void installModule(final String str, final Callback callback) {
        if (!fya.O000000o(str)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "invalid moduleId"));
            return;
        }
        fxx.O000000o().O000000o(str, new fxx.O000000o() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPackageModule.AnonymousClass1 */

            public final void O000000o(boolean z, String str) {
                fxx.O000000o();
                boolean O000000o2 = fxx.O000000o(str);
                WritableMap createMap = Arguments.createMap();
                createMap.putBoolean("installed", O000000o2);
                if (z) {
                    callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap, str));
                    return;
                }
                callback.invoke(Boolean.TRUE, gbq.O000000o(-3, createMap, str));
            }
        });
    }

    @ReactMethod
    public void onDeventJs(int i, ReadableMap readableMap) {
        fwy O00000Oo;
        Activity activity;
        if (i == 1) {
            int O000000o2 = fyf.O000000o(readableMap, "routeIndex", 0);
            String O000000o3 = fyf.O000000o(readableMap, "event", "");
            if ("show".equals(O000000o3)) {
                fwy O00000Oo2 = fwz.O000000o().O00000Oo();
                Activity activity2 = O00000Oo2.O0000OOo;
                gbu.O00000oo("RNRuntime onPageResume(),activity=".concat(String.valueOf(activity2)));
                if (activity2 != null && O00000Oo2.O00000o != null) {
                    ReactRootView reactRootView = O00000Oo2.O00000o;
                    if (reactRootView.getChildCount() == 0) {
                        reactRootView.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener(reactRootView, activity2, O000000o2) {
                            /* class _m_j.fwy.AnonymousClass8 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ ReactRootView f17353O000000o;
                            final /* synthetic */ Activity O00000Oo;
                            final /* synthetic */ int O00000o0;

                            public final void onChildViewRemoved(View view, View view2) {
                            }

                            {
                                this.f17353O000000o = r2;
                                this.O00000Oo = r3;
                                this.O00000o0 = r4;
                            }

                            public final void onChildViewAdded(View view, View view2) {
                                this.f17353O000000o.setOnHierarchyChangeListener(null);
                                this.f17353O000000o.post(new Runnable() {
                                    /* class _m_j.fwy.AnonymousClass8.AnonymousClass1 */

                                    public final void run() {
                                        ((PluginRNActivity) AnonymousClass8.this.O00000Oo).onPageResume(AnonymousClass8.this.f17353O000000o, AnonymousClass8.this.O00000o0);
                                    }
                                });
                            }
                        });
                    } else {
                        activity2.runOnUiThread(new Runnable(activity2, reactRootView, O000000o2) {
                            /* class _m_j.fwy.AnonymousClass9 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ Activity f17355O000000o;
                            final /* synthetic */ ReactRootView O00000Oo;
                            final /* synthetic */ int O00000o0;

                            {
                                this.f17355O000000o = r2;
                                this.O00000Oo = r3;
                                this.O00000o0 = r4;
                            }

                            public final void run() {
                                ((PluginRNActivity) this.f17355O000000o).onPageResume(this.O00000Oo, this.O00000o0);
                            }
                        });
                    }
                }
            } else if ("hide".equals(O000000o3) && (activity = (O00000Oo = fwz.O000000o().O00000Oo()).O0000OOo) != null) {
                activity.runOnUiThread(new Runnable(activity, O000000o2) {
                    /* class _m_j.fwy.AnonymousClass10 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ Activity f17342O000000o;
                    final /* synthetic */ int O00000Oo;

                    {
                        this.f17342O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final void run() {
                        ((PluginRNActivity) this.f17342O000000o).onPagePause(fwy.this.O00000o, this.O00000Oo);
                    }
                });
            }
        }
    }
}
