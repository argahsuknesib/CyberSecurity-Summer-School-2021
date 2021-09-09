package com.xiaomi.smarthome.framework.plugin.rn.nativemodule;

import _m_j.ckq;
import _m_j.dn;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fio;
import _m_j.fir;
import _m_j.fku;
import _m_j.flk;
import _m_j.fsp;
import _m_j.ft;
import _m_j.ftn;
import _m_j.fuw;
import _m_j.fuy;
import _m_j.fvt;
import _m_j.fwz;
import _m_j.fxm;
import _m_j.fxt;
import _m_j.fxv;
import _m_j.fyc;
import _m_j.fyf;
import _m_j.gat;
import _m_j.gbl;
import _m_j.gbq;
import _m_j.gbt;
import _m_j.gbu;
import _m_j.gbv;
import _m_j.gbz;
import _m_j.gdt;
import _m_j.gdu;
import _m_j.gdv;
import _m_j.gfr;
import _m_j.gnn;
import _m_j.gpc;
import _m_j.gpn;
import _m_j.grr;
import _m_j.gsc;
import _m_j.gsy;
import _m_j.gtb;
import _m_j.gwc;
import _m_j.hxi;
import _m_j.hyy;
import _m_j.iag;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Base64;
import android.util.Log;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.FileProvider;
import com.Utils.MediaStoreUtil;
import com.amap.api.location.AMapLocation;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager;
import com.xiaomi.smarthome.frame.plugin.host.PluginActivityHostApi;
import com.xiaomi.smarthome.frame.plugin.host.PluginHostApi;
import com.xiaomi.smarthome.frame.plugin.rn.debugmock.MockRnDevicePluginManager;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.plugin.rn.LoadingRNActivity;
import com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo;
import com.xiaomi.smarthome.framework.plugin.rn.report.RnNetReport;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.lang.ref.WeakReference;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import miui.os.SystemProperties;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MIOTHostModule extends MIOTBaseJavaModule {
    private static final Set<String> FREE_ACCESS_EXTERNAL_STORAGE_MODELS = new HashSet(Arrays.asList("xiaomi.router.ra70", "xiaomi.router.r3g"));
    private Callback mJumpToThirdpartyAppCallback;
    private Map<String, KeyPair> mKeyPairMap;

    private String getCurveTypeValue(int i) {
        return i != 128 ? i != 192 ? (i == 256 || i != 384) ? "secp256r1" : "secp384r1" : "secp192r1" : "secp128r1";
    }

    public String getName() {
        return "MIOTHost";
    }

    public MIOTHostModule(ReactApplicationContext reactApplicationContext, PluginPackageInfo pluginPackageInfo, DeviceStat deviceStat) {
        super(reactApplicationContext);
    }

    public MIOTHostModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void createExecutor(String str, String str2, Callback callback) {
        fxt O000000o2 = fxt.O000000o();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str)) {
            if (str.startsWith("file:///")) {
                str = str.substring(7, str.length());
            } else if (str.startsWith("file://")) {
                str = str.substring(6, str.length());
            } else if (str.startsWith("file:/")) {
                str = str.substring(5, str.length());
            } else if (str.startsWith("file:")) {
                str = File.separator + str.substring(5, str.length());
            }
        }
        new Thread(new Runnable(reactApplicationContext, str, callback, str2) {
            /* class _m_j.fxt.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ ReactApplicationContext f17383O000000o;
            final /* synthetic */ String O00000Oo;
            final /* synthetic */ String O00000o;
            final /* synthetic */ Callback O00000o0;

            {
                this.f17383O000000o = r2;
                this.O00000Oo = r3;
                this.O00000o0 = r4;
                this.O00000o = r5;
            }

            public final void run() {
                String str;
                boolean z = this.O00000Oo.startsWith("http://") || this.O00000Oo.startsWith("https://");
                if (z) {
                    str = new File(this.f17383O000000o.getExternalCacheDir(), gbk.O000000o(this.O00000Oo) + ".jx").getAbsolutePath();
                    gbi.O000000o(str);
                } else {
                    str = this.O00000Oo;
                }
                if (z) {
                    if (!(gof.O000000o(this.f17383O000000o, this.O00000Oo, new File(str), null).O00000Oo == 3)) {
                        this.O00000o0.invoke(Boolean.FALSE, "failed to download jx");
                        return;
                    }
                }
                O000000o o000000o = new O000000o(fxt.this, (byte) 0);
                o000000o.f17386O000000o = new WeakReference(this.f17383O000000o);
                try {
                    o000000o.O00000Oo = new fxu();
                    o000000o.O00000Oo.O000000o(this.f17383O000000o, str, this.O00000o);
                    if (o000000o.O00000Oo.O00000Oo()) {
                        fxt.this.f17382O000000o.add(o000000o);
                        this.O00000o0.invoke(Boolean.TRUE, o000000o.O00000Oo.O000000o());
                        return;
                    }
                    o000000o.O000000o();
                    this.O00000o0.invoke(Boolean.FALSE, "failed to load jx");
                } catch (Exception e) {
                    e.printStackTrace();
                    o000000o.O000000o();
                    Callback callback = this.O00000o0;
                    callback.invoke(Boolean.FALSE, "failed to load jx:" + e.getMessage());
                }
            }
        }).start();
    }

    @ReactMethod
    public void executeMethod(String str, String str2, String str3, Callback callback) {
        fxt O000000o2 = fxt.O000000o();
        fxt.O000000o O000000o3 = O000000o2.O000000o(str);
        if (O000000o3 == null || O000000o3.O00000Oo == null) {
            callback.invoke(Boolean.FALSE, "jsContext is destroyed", "destroyed");
            return;
        }
        gbu.O000000o("execute threadName:  " + Thread.currentThread().getName());
        O000000o3.O00000Oo.O000000o(str2, str3, new fxv(callback) {
            /* class _m_j.fxt.AnonymousClass3 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ Callback f17385O000000o;

            {
                this.f17385O000000o = r2;
            }

            public final void O000000o(String str) {
                gbu.O000000o("jsc execute onSuccess threadName:  " + Thread.currentThread().getName());
                this.f17385O000000o.invoke(Boolean.TRUE, str);
            }

            public final void O00000Oo(String str) {
                gbu.O00000Oo("jsc execute onFailure threadName:  " + Thread.currentThread().getName());
                this.f17385O000000o.invoke(Boolean.FALSE, str);
            }
        });
    }

    @ReactMethod
    public void removeExecutor(String str) {
        fxt O000000o2 = fxt.O000000o();
        fxt.O000000o O000000o3 = O000000o2.O000000o(str);
        if (O000000o3 != null) {
            gbu.O000000o("jsc remove:  " + Thread.currentThread().getName());
            if (O000000o3 != null) {
                O000000o3.O000000o();
                O000000o2.f17382O000000o.remove(O000000o3);
            }
        }
    }

    public Map<String, Object> getConstants() {
        String str;
        String str2;
        HashMap hashMap = new HashMap();
        WritableMap createMap = Arguments.createMap();
        createMap.putString("mobileModel", Build.MODEL);
        createMap.putString("sysVersion", Build.VERSION.RELEASE);
        createMap.putInt("hostApiLevel", 10058);
        createMap.putBoolean("isXiaomiPhone", isXiaomiPhone());
        try {
            if (grr.O00000oO()) {
                createMap.putString("miuiVersion", SystemProperties.get("ro.miui.ui.version.name", ""));
            }
        } catch (Throwable th) {
            Log.e("MIOTHostModule", "fatal", th);
        }
        hashMap.put("systemInfo", createMap);
        Locale settingLocale = XmPluginHostApi.instance().getSettingLocale();
        if (settingLocale == null && (settingLocale = Locale.getDefault()) == null) {
            settingLocale = getReactApplicationContext().getResources().getConfiguration().locale;
        }
        String country = settingLocale.getCountry();
        if (country == null) {
            str = settingLocale.getLanguage();
        } else {
            str = settingLocale.getLanguage() + "_" + country;
        }
        if (Build.VERSION.SDK_INT >= 21 && TextUtils.equals("zh_CN", str) && TextUtils.equals("Hant", settingLocale.getScript())) {
            str = "zh_TW";
        }
        hashMap.put("language", str);
        hashMap.put("buildType", gfr.O0000Oo0 ? "release" : "debug");
        grr.O000000o();
        hashMap.put("appVersion", grr.O00000Oo(getReactApplicationContext()));
        grr.O000000o();
        hashMap.put("appVersionCode", Integer.valueOf(grr.O00000o0(getReactApplicationContext())));
        hashMap.put("timeZone", TimeZone.getDefault().getID());
        hashMap.put("appConfigEnv", Integer.valueOf(XmPluginHostApi.instance().getUsePreviewConfig()));
        boolean is24HourFormat = DateFormat.is24HourFormat(getReactApplicationContext());
        fyc.O00000Oo("MIOTHostModule", "is24: ".concat(String.valueOf(is24HourFormat)));
        hashMap.put("is24HourTime", Boolean.valueOf(is24HourFormat));
        hashMap.put("displayCutoutTop", Integer.valueOf(ckq.O000000o(getCurrentActivity())));
        Locale O00000Oo = gwc.O00000Oo();
        if (O00000Oo != null) {
            String country2 = O00000Oo.getCountry();
            if (TextUtils.isEmpty(country2)) {
                str2 = O00000Oo.getLanguage();
            } else {
                str2 = O00000Oo.getLanguage() + "_" + country2;
            }
            hashMap.put("systemLanguage", str2);
        } else {
            gsy.O000000o(6, "miot-rn-plugin", "MIOTHostModule  Locale.getDefault is null...");
        }
        hashMap.put("isPad", Boolean.valueOf(isPad()));
        return hashMap;
    }

    private boolean hasNavigationBar() {
        if (Build.VERSION.SDK_INT >= 17 && Settings.Global.getInt(getCurrentActivity().getContentResolver(), "force_fsg_nav_bar", 0) != 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            Display defaultDisplay = getCurrentActivity().getWindowManager().getDefaultDisplay();
            Point point = new Point();
            Point point2 = new Point();
            defaultDisplay.getSize(point);
            defaultDisplay.getRealSize(point2);
            if (point2.y != point.y) {
                return true;
            }
            return false;
        }
        boolean hasPermanentMenuKey = ViewConfiguration.get(getCurrentActivity()).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey || deviceHasKey) {
            return false;
        }
        return true;
    }

    private WritableMap getPhoneScreenInfo() {
        int i;
        WritableMap createMap = Arguments.createMap();
        if (getCurrentActivity() == null) {
            return null;
        }
        View findViewById = getCurrentActivity().findViewById(R.id.fl_root);
        int i2 = -1;
        if (findViewById != null) {
            i2 = findViewById.getHeight();
            i = findViewById.getWidth();
        } else {
            i = -1;
        }
        Display defaultDisplay = getCurrentActivity().getWindowManager().getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        gbu.O000000o("View宽高--> viewHeight:  " + i2 + "   viewWidth: " + i);
        if (i2 < 200 || i < 200) {
            i2 = point2.y;
            i = point2.x;
        }
        int abs = Math.abs(point2.y - i2);
        gbu.O000000o("屏幕高度--> size.y:  " + point.y + "   realSize.y: " + point2.y + "  navigationBarHeight: " + abs);
        createMap.putInt("viewWidth", gpc.O00000Oo((float) i));
        createMap.putInt("viewHeight", gpc.O00000Oo((float) i2));
        createMap.putInt("viewWidthPixel", i);
        createMap.putInt("viewHeightPixel", i2);
        createMap.putInt("displayCutoutTop", ckq.O000000o(getCurrentActivity()));
        return createMap;
    }

    @ReactMethod
    public final void getPhoneScreenInfo(Callback callback) {
        if (callback != null) {
            WritableMap phoneScreenInfo = getPhoneScreenInfo();
            if (phoneScreenInfo != null) {
                callback.invoke(Boolean.TRUE, phoneScreenInfo);
                return;
            }
            callback.invoke(Boolean.FALSE, "current activity is not init...");
        }
    }

    @ReactMethod
    public final void getCurrentTimeMillis(Callback callback) {
        callback.invoke(Double.valueOf((double) System.currentTimeMillis()));
    }

    @Deprecated
    @ReactMethod
    public final void getLocation(final Callback callback) {
        fuw.O000000o().O000000o(new fuw.O000000o() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass1 */

            public final void O000000o() {
            }

            public final void O000000o(AMapLocation aMapLocation) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("country", aMapLocation.getCountry());
                createMap.putString("aoiname", aMapLocation.getAoiName());
                createMap.putString("district", aMapLocation.getDistrict());
                createMap.putString("street", aMapLocation.getStreet());
                createMap.putString("city", aMapLocation.getCity());
                createMap.putString("citycode", aMapLocation.getCityCode());
                createMap.putString("province", aMapLocation.getProvince());
                createMap.putString("adcode", aMapLocation.getAdCode());
                createMap.putString("address", aMapLocation.getAddress());
                StringBuilder sb = new StringBuilder();
                sb.append(aMapLocation.getLatitude());
                createMap.putString("latitude", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(aMapLocation.getLongitude());
                createMap.putString("longitude", sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(aMapLocation.getAccuracy());
                createMap.putString("accuracy", sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append(aMapLocation.getAltitude());
                createMap.putString("altitude", sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append(aMapLocation.getSpeed());
                createMap.putString("speed", sb5.toString());
                callback.invoke(Boolean.TRUE, createMap);
            }
        }, "high");
    }

    @ReactMethod
    public final void saveInfo(String str, String str2) {
        getSharedPreferencesV2().edit().putString(str, str2).apply();
    }

    @ReactMethod
    public final void keepScreenNotLock(final boolean z) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass12 */

                public final void run() {
                    try {
                        if (z) {
                            currentActivity.getWindow().addFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
                        } else {
                            currentActivity.getWindow().clearFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
                        }
                    } catch (Exception e) {
                        gsy.O000000o(6, "rn-plugin", e.toString());
                    }
                }
            });
        }
    }

    @ReactMethod
    public final void encodeMD5(String str, Callback callback) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.TRUE;
            if (str == null) {
                str = "";
            }
            objArr[1] = fku.O000000o(instance.digest(str.getBytes()));
            callback.invoke(objArr);
        } catch (Throwable th) {
            callback.invoke(Boolean.FALSE, Log.getStackTraceString(th));
        }
    }

    @ReactMethod
    public final void encodeBase64(String str, Callback callback) {
        try {
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.TRUE;
            if (str == null) {
                str = "";
            }
            objArr[1] = Base64.encodeToString(str.getBytes(), 0);
            callback.invoke(objArr);
        } catch (Throwable th) {
            callback.invoke(Boolean.FALSE, Log.getStackTraceString(th));
        }
    }

    @ReactMethod
    public final void decodeBase64(String str, Callback callback) {
        try {
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.TRUE;
            if (str == null) {
                str = "";
            }
            objArr[1] = new String(Base64.decode(str.getBytes(), 0));
            callback.invoke(objArr);
        } catch (Throwable th) {
            callback.invoke(Boolean.FALSE, Log.getStackTraceString(th));
        }
    }

    @ReactMethod
    public final void encodeSHA1(String str, Callback callback) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.TRUE;
            if (str == null) {
                str = "";
            }
            objArr[1] = fku.O000000o(instance.digest(str.getBytes()));
            callback.invoke(objArr);
        } catch (Throwable th) {
            callback.invoke(Boolean.FALSE, Log.getStackTraceString(th));
        }
    }

    @ReactMethod
    public final void encodeSHA2(String str, Callback callback) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.TRUE;
            if (str == null) {
                str = "";
            }
            objArr[1] = fku.O000000o(instance.digest(str.getBytes()));
            callback.invoke(objArr);
        } catch (Throwable th) {
            callback.invoke(Boolean.FALSE, Log.getStackTraceString(th));
        }
    }

    @ReactMethod
    public final void loadInfoCallback(String str, Callback callback) {
        String string = getSharedPreferencesV2().getString(str, "");
        if (TextUtils.isEmpty(string)) {
            string = getSharedPreferences().getString(str, "");
            if (!TextUtils.isEmpty(string)) {
                saveInfo(str, string);
            }
        }
        callback.invoke(string);
    }

    @ReactMethod
    public final void openDeleteDevice(String str) {
        DeviceStat device = getDevice();
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null && device != null) {
            ((gdu) gdv.f17570O000000o.getUiInterface()).O000000o(currentActivity, str, device.did, device.pid);
        }
    }

    @ReactMethod
    public final void closeCurrentPage(ReadableMap readableMap) {
        fyc.O00000o0("MIOTHostModule", "closeCurrentPage");
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass23 */

            public final void run() {
                gbu.O00000oo("MIOTHostModule-->closeCurrentPage()...");
                fwz.O000000o().O00000Oo().O00000o();
            }
        });
    }

    @ReactMethod
    public final void openShareListBar(String str, String str2, ReadableArray readableArray, String str3) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            ((gdu) gdv.f17570O000000o.getUiInterface()).O000000o(currentActivity, getDevice(), str, str2, readableArray, str3);
        } else {
            gbu.O00000Oo("current activity is null...");
        }
    }

    @ReactMethod
    public final void getDevicesWithModel(String str, boolean z, Callback callback) {
        List<DeviceStat> list;
        List<DeviceStat> currentHomeDevicesWithPid;
        if (TextUtils.isEmpty(str)) {
            callback.invoke(Boolean.FALSE, "request model is empty or null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (z) {
            list = XmPluginHostApi.instance().getCurrentHomeDevicesWithModel(str);
            if (!(list == null || (currentHomeDevicesWithPid = XmPluginHostApi.instance().getCurrentHomeDevicesWithPid(Device.PID_VIRTUAL_GROUP)) == null)) {
                for (DeviceStat deviceStat : currentHomeDevicesWithPid) {
                    try {
                        JSONObject optJSONObject = new JSONObject(deviceStat.extrainfo).optJSONObject("member_list");
                        JSONObject jSONObject = null;
                        if (optJSONObject != null) {
                            jSONObject = optJSONObject.optJSONObject("member_ship");
                        }
                        if (jSONObject != null) {
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                for (DeviceStat next2 : list) {
                                    if (next2.did.equals(next)) {
                                        next2.isGrouped = true;
                                    }
                                }
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            list = XmPluginHostApi.instance().getDeviceListV2(arrayList);
        }
        WritableArray createArray = Arguments.createArray();
        if (list != null) {
            for (DeviceStat device2Map : list) {
                WritableMap createMap = Arguments.createMap();
                MIOTDeviceModule.device2Map(createMap, device2Map);
                createArray.pushMap(createMap);
            }
        }
        callback.invoke(Boolean.TRUE, createArray);
    }

    @ReactMethod
    public final void openShareDevicePage() {
        final DeviceStat device = getDevice();
        final Activity currentActivity = getCurrentActivity();
        if (device != null && currentActivity != null) {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass34 */

                public final void run() {
                    if (MIOTHostModule.this.getCurrentActivity() != null) {
                        ((gdu) gdv.f17570O000000o.getUiInterface()).O000000o(currentActivity, device.did);
                    } else {
                        gbu.O00000Oo("current activity is null...");
                    }
                }
            });
        }
    }

    @ReactMethod
    public final void openSystemShareWindow(String str) {
        Uri uri;
        String str2;
        gbu.O00000o("MIOTHOST#openSystemShareWindow: pathOrUrl=".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str) || (!str.startsWith("content://") && !MediaStoreUtil.O000000o(str) && !gbt.O00000Oo(getFilesPath().getAbsolutePath(), str))) {
            gbu.O00000o("MIOTHOST#openSystemShareWindow: pathOrUrl is illegal");
            return;
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (TextUtils.isEmpty(scheme) || (!scheme.startsWith("http") && !scheme.startsWith("https") && !scheme.startsWith("content"))) {
                try {
                    File file = new File(str);
                    if (!file.exists()) {
                        gbu.O00000o("MIOTHOST#openSystemShareWindow: pathOrUrl not exist");
                        return;
                    } else if (MediaStoreUtil.O000000o(str)) {
                        uri = Uri.parse(str);
                    } else {
                        String packageName = currentActivity.getApplicationContext().getPackageName();
                        uri = FileProvider.getUriForFile(currentActivity, packageName + ".fileprovider", file);
                    }
                } catch (IllegalArgumentException e) {
                    gbu.O00000o("MIOTHOST#openSystemShareWindow error:" + Log.getStackTraceString(e));
                    uri = null;
                }
            } else {
                uri = Uri.parse(str);
            }
            if (uri == null) {
                gbu.O00000o("MIOTHOST#openSystemShareWindow error: fileUri = null,sdk_int:" + Build.VERSION.SDK_INT);
                return;
            }
            if (TextUtils.isEmpty(scheme) || !scheme.startsWith("content")) {
                str2 = gsc.O00000Oo(str);
            } else {
                File O00000Oo = gsc.O00000Oo(currentActivity, parse);
                if (O00000Oo == null || (str2 = gtb.O000000o(gsc.O000000o(O00000Oo.getName()))) == null) {
                    str2 = "application/octet-stream";
                }
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "*/*";
            }
            gbu.O00000o("MIOTHOST#openSystemShareWindow: mimeType=".concat(String.valueOf(str2)));
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", uri);
            intent.addFlags(1);
            intent.addFlags(268435456);
            intent.setType(str2);
            currentActivity.startActivity(Intent.createChooser(intent, null));
        }
    }

    @ReactMethod
    public final void openRoomManagementPage() {
        final DeviceStat device = getDevice();
        final Activity currentActivity = getCurrentActivity();
        if (device == null || currentActivity == null) {
            gbu.O00000Oo("device is null or current activity is null...");
        } else {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass45 */

                public final void run() {
                    ((gdu) gdv.f17570O000000o.getUiInterface()).O00000Oo(currentActivity, device.did);
                }
            });
        }
    }

    @ReactMethod
    public final void openZigbeeConnectDeviceList(String str) {
        final DeviceStat device = getDevice();
        final Activity currentActivity = getCurrentActivity();
        if (device == null || currentActivity == null) {
            gbu.O00000Oo("device is null or current activity is null...");
        } else {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass51 */

                public final void run() {
                    fsp.O000000o().O0000Oo.openGatewaySubDeviceList(currentActivity, device.did);
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gdu.O00000Oo(android.content.Context, java.lang.String):void
     arg types: [android.app.Activity, java.lang.String]
     candidates:
      _m_j.gdu.O00000Oo(android.app.Activity, java.lang.String):void
      _m_j.gdu.O00000Oo(java.lang.String, java.lang.String):void
      _m_j.gdu.O00000Oo(android.content.Context, java.lang.String):void */
    @ReactMethod
    public final void openVoiceCtrlDeviceAuthPage() {
        Activity currentActivity;
        DeviceStat device = getDevice();
        if (device != null && (currentActivity = getCurrentActivity()) != null) {
            ((gdu) gdv.f17570O000000o.getUiInterface()).O00000Oo((Context) currentActivity, device.did);
        }
    }

    @ReactMethod
    public final void openIftttAutoPage() {
        final DeviceStat device = getDevice();
        final Activity currentActivity = getCurrentActivity();
        if (device == null || currentActivity == null) {
            gbu.O00000Oo("device is null or current activity is null...");
        } else {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass52 */

                public final void run() {
                    PluginActivityHostApi pluginActivityHostApi = fsp.O000000o().O0000Oo;
                    Activity activity = currentActivity;
                    DeviceStat deviceStat = device;
                    pluginActivityHostApi.openSceneActivity(activity, deviceStat, deviceStat.did);
                }
            });
        }
    }

    @ReactMethod
    public final void openIftttAutoPageWithDid(String str) {
        if (!TextUtils.isEmpty(str)) {
            final DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
            final Activity currentActivity = getCurrentActivity();
            if (deviceByDid == null || currentActivity == null) {
                gbu.O00000Oo("device is null or current activity is null...");
            } else {
                CommonApplication.getGlobalHandler().post(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass53 */

                    public final void run() {
                        PluginActivityHostApi pluginActivityHostApi = fsp.O000000o().O0000Oo;
                        Activity activity = currentActivity;
                        DeviceStat deviceStat = deviceByDid;
                        pluginActivityHostApi.openSceneActivity(activity, deviceStat, deviceStat.did);
                    }
                });
            }
        }
    }

    @ReactMethod
    public final void openPowerSwitchNameActivity() {
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass54 */

            public final void run() {
                DeviceStat device = MIOTHostModule.this.getDevice();
                Activity currentActivity = MIOTHostModule.this.getCurrentActivity();
                if (currentActivity == null || device == null) {
                    gbu.O00000Oo("device is null or current activity is null...");
                } else {
                    fsp.O000000o().O0000Oo.openPowerSwitchNameActivity(currentActivity, device.did, device.mac);
                }
            }
        });
    }

    @ReactMethod
    public final void openFeedbackInput() {
        final DeviceStat device = getDevice();
        final Activity currentActivity = getCurrentActivity();
        if (device != null && currentActivity != null) {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass2 */

                public final void run() {
                    XmPluginHostApi.instance().gotoFeedback(currentActivity, device.model, device.did, PluginRuntimeManager.getInstance().getXmPluginPackage(CoreApi.O000000o().O0000Oo(device.model)));
                }
            });
        }
    }

    @ReactMethod
    public final void openSecuritySetting() {
        final DeviceStat device = getDevice();
        final Activity currentActivity = getCurrentActivity();
        if (device != null && currentActivity != null) {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass3 */

                public final void run() {
                    ((gdu) gdv.f17570O000000o.getUiInterface()).O00000Oo(currentActivity, device.did, "");
                }
            });
        }
    }

    @ReactMethod
    public final void openHelpPage() {
        final DeviceStat device = getDevice();
        final Activity currentActivity = getCurrentActivity();
        if (device != null && currentActivity != null) {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass4 */

                public final void run() {
                    ((gdu) gdv.f17570O000000o.getUiInterface()).O00000o0(currentActivity, device.model, device.did);
                }
            });
        }
    }

    @ReactMethod
    public final void openAddIRController(String str, final int i, final ReadableArray readableArray, final ReadableMap readableMap) {
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass5 */

            public final void run() {
                String[] strArr;
                ArrayList list = Arguments.toList(readableArray);
                Activity currentActivity = MIOTHostModule.this.getCurrentActivity();
                DeviceStat device = MIOTHostModule.this.getDevice();
                if (currentActivity != null && device != null) {
                    gdu gdu = (gdu) gdv.f17570O000000o.getUiInterface();
                    int i = i;
                    if (list == null) {
                        strArr = null;
                    } else {
                        strArr = (String[]) list.toArray(new String[list.size()]);
                    }
                    gdu.O000000o(currentActivity, device, i, strArr, Arguments.toBundle(readableMap));
                }
            }
        });
    }

    @ReactMethod
    public final void openBtGatewayPage() {
        final DeviceStat device = getDevice();
        final Activity currentActivity = getCurrentActivity();
        if (device != null && currentActivity != null) {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass6 */

                public final void run() {
                    ((gdu) gdv.f17570O000000o.getUiInterface()).O00000o0(currentActivity, device.did);
                }
            });
        }
    }

    @Deprecated
    @ReactMethod
    public final void privacyAndProtocolReview(String str, ReadableArray readableArray, String str2, ReadableArray readableArray2) {
        final DeviceStat device = getDevice();
        final Activity currentActivity = getCurrentActivity();
        if (device != null && currentActivity != null) {
            final String str3 = str;
            final ReadableArray readableArray3 = readableArray;
            final String str4 = str2;
            final ReadableArray readableArray4 = readableArray2;
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass7 */

                public final void run() {
                    ((gdu) gdv.f17570O000000o.getUiInterface()).O000000o(currentActivity, device.did, str3, readableArray3, str4, readableArray4);
                }
            });
        }
    }

    @Deprecated
    @ReactMethod
    public final void openPrivacyLicense(String str, ReadableArray readableArray, String str2, ReadableArray readableArray2, Callback callback) {
        final DeviceStat device = getDevice();
        final Activity currentActivity = getCurrentActivity();
        if (device != null && currentActivity != null) {
            final String str3 = str;
            final ReadableArray readableArray3 = readableArray;
            final String str4 = str2;
            final ReadableArray readableArray4 = readableArray2;
            final Callback callback2 = callback;
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass8 */

                public final void run() {
                    ((gdu) gdv.f17570O000000o.getUiInterface()).O000000o(currentActivity, device.did, device.name, str3, readableArray3, str4, readableArray4, callback2);
                }
            });
        }
    }

    @ReactMethod
    public void showDeclarationWithConfig(final ReadableMap readableMap, final Callback callback) {
        if (readableMap == null) {
            callback.invoke(Boolean.FALSE, "params is null...");
            return;
        }
        final DeviceStat device = getDevice();
        if (device == null || getCurrentActivity() == null) {
            callback.invoke(Boolean.FALSE, "current device is null or activity is null...");
            return;
        }
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass9 */

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
            public final void run() {
                String O000000o2 = fyf.O000000o(fyf.O00000Oo(readableMap, "agreementURL"));
                String O000000o3 = fyf.O000000o(fyf.O00000Oo(readableMap, "privacyURL"));
                String O000000o4 = fyf.O000000o(fyf.O00000Oo(readableMap, "experiencePlanURL"));
                boolean O000000o5 = fyf.O000000o(readableMap, "hideAgreement");
                boolean O000000o6 = fyf.O000000o(readableMap, "hideUserExperiencePlan");
                if (O000000o5) {
                    O000000o2 = null;
                }
                String str = O000000o2;
                Intent intent = new Intent();
                if (O000000o6) {
                    intent.putExtra("enable_privacy_setting", false);
                } else {
                    intent.putExtra("enable_privacy_setting", true);
                    if (!TextUtils.isEmpty(O000000o4)) {
                        intent.putExtra("usrExpPlanContentRnUri", O000000o4);
                    }
                }
                fsp.O000000o().O0000Oo.showUserLicenseUriDialogV2(MIOTHostModule.this.getCurrentActivity(), device.name, O000000o5, str, O000000o3, new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass9.AnonymousClass1 */

                    public final void onClick(View view) {
                        callback.invoke(Boolean.TRUE);
                    }
                }, device.did, intent);
            }
        });
    }

    @ReactMethod
    public void openDeclarationWithConfig(final ReadableMap readableMap, final Callback callback) {
        if (readableMap == null) {
            callback.invoke(Boolean.FALSE, "params is null...");
            return;
        }
        final DeviceStat device = getDevice();
        if (device == null || getCurrentActivity() == null) {
            callback.invoke(Boolean.FALSE, "current device is null or activity is null...");
            return;
        }
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass10 */

            public final void run() {
                String O000000o2 = fyf.O000000o(fyf.O00000Oo(readableMap, "agreementURL"));
                String O000000o3 = fyf.O000000o(fyf.O00000Oo(readableMap, "privacyURL"));
                String O000000o4 = fyf.O000000o(fyf.O00000Oo(readableMap, "experiencePlanURL"));
                boolean O000000o5 = fyf.O000000o(readableMap, "hideAgreement");
                boolean O000000o6 = fyf.O000000o(readableMap, "hideUserExperiencePlan");
                if (O000000o5) {
                    O000000o2 = null;
                }
                String str = O000000o2;
                Activity currentActivity = MIOTHostModule.this.getCurrentActivity();
                if (currentActivity != null) {
                    ((gdu) gdv.f17570O000000o.getUiInterface()).O000000o(currentActivity, device, str, O000000o3, O000000o4, O000000o5, O000000o6);
                    callback.invoke(Boolean.TRUE, "success...");
                }
            }
        });
    }

    @ReactMethod
    public final void openWebPage(final String str, final ReadableMap readableMap) {
        gsy.O000000o(4, "MIOTHostModule", "openWebPage ".concat(String.valueOf(str)));
        RnNetReport.reportWebPageURL(str);
        if (!RnNetReport.isInWhiteListHost(str)) {
            gsy.O000000o(6, "DNSHook", "openWebPage host is not in the whiteList url=".concat(String.valueOf(str)));
            if (gfr.O0000OOo || gfr.O0000Ooo || gfr.O0000Oo || gfr.O0000o00) {
                gbz.O000000o("禁止访问的网页!");
                return;
            }
            return;
        }
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass11 */

            public final void run() {
                boolean z = true;
                try {
                    if (readableMap.hasKey("onCurrentPageIfAvailable") && !readableMap.isNull("onCurrentPageIfAvailable")) {
                        z = readableMap.getBoolean("onCurrentPageIfAvailable");
                    }
                    if (!MIOTHostModule.this.isRedirectUrl(str) || !z) {
                        ((gdu) gdv.f17570O000000o.getUiInterface()).O000000o(str, "");
                    } else {
                        ((gdu) gdv.f17570O000000o.getUiInterface()).O00000Oo(str, "");
                    }
                } catch (RemoteException e) {
                    Log.e("MIOTHostModule", "openWebPage", e);
                }
            }
        });
    }

    public boolean isRedirectUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.startsWith("http://account.xiaomi.com/oauth2/authorize") || str.startsWith("https://router.uu.163.com/xiaomi/index.html");
        }
        return false;
    }

    @ReactMethod
    public final void openOperationUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            gbu.O00000o("MIOTHost#openOperationUrl: url is empty");
            return;
        }
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host)) {
            gbu.O00000o("MIOTHost#openOperationUrl: host is empty");
        } else if (host.contains("mi.com") || host.contains("xiaomi.com") || host.contains("xiaomiyoupin.com")) {
            Activity currentActivity = getCurrentActivity();
            if (currentActivity != null) {
                Intent intent = new Intent(currentActivity, ((gdu) gdv.f17570O000000o.getUiInterface()).O0000O0o());
                intent.putExtra("url", str);
                intent.setFlags(268435456);
                currentActivity.startActivity(intent);
            }
        } else {
            gbu.O00000o("MIOTHost#openOperationUrl: not in the domain white-list");
        }
    }

    @ReactMethod
    public final void openChangeDeviceName() {
        final DeviceStat device = getDevice();
        final Activity currentActivity = getCurrentActivity();
        if (device != null && currentActivity != null) {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass13 */

                public final void run() {
                    ((gdu) gdv.f17570O000000o.getUiInterface()).O000000o(currentActivity, device.did, device.mac, device.pid, device.name, new Callback() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass13.AnonymousClass1 */

                        public final void invoke(Object... objArr) {
                            device.name = (String) objArr[0];
                        }
                    });
                }
            });
        }
    }

    @ReactMethod
    public final void openAddToDesktopPage() {
        final DeviceStat device = getDevice();
        gsy.O00000Oo("MIOTHostModule", "openAddToDesktopPage device:".concat(String.valueOf(device)));
        if (device != null) {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass14 */

                public final void run() {
                    try {
                        ((gdt) gdv.f17570O000000o.getServiceInterface()).O000000o(MIOTHostModule.this.getCurrentActivity(), device.did);
                    } catch (RemoteException e) {
                        Log.e("MIOTHostModule", "openAddToDesktopPage", e);
                    }
                }
            });
        }
    }

    @ReactMethod
    public final void openBleMeshDeviceUpgradePage() {
        final DeviceStat device = getDevice();
        final Activity currentActivity = getCurrentActivity();
        if (device != null && currentActivity != null) {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass15 */

                public final void run() {
                    fsp.O000000o().O0000Oo.goBleMeshDeviceUpdateActivity(currentActivity, device.did);
                }
            });
        }
    }

    @ReactMethod
    public final void openBleOtaDeviceUpgradePage(final ReadableMap readableMap) {
        final DeviceStat device = getDevice();
        if (device != null) {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass16 */

                public final void run() {
                    gbl gbl = new gbl(readableMap);
                    int O000000o2 = gbl.O000000o("auth_type");
                    String O000000o3 = gbl.O000000o("fake_dfu_name", (String) null);
                    String O000000o4 = gbl.O000000o("fake_dfu_url", (String) null);
                    String O000000o5 = gbl.O000000o("md5", (String) null);
                    Activity currentActivity = MIOTHostModule.this.getCurrentActivity();
                    if (currentActivity != null) {
                        fsp.O000000o().O0000Oo.goBleOtaDeviceUpdateActivity(currentActivity, O000000o2, O000000o4, device.did, O000000o3, O000000o5);
                    }
                }
            });
        }
    }

    @ReactMethod
    public final void openDeviceUpgradePage() {
        final DeviceStat device = getDevice();
        final Activity currentActivity = getCurrentActivity();
        if (device != null && currentActivity != null) {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass17 */

                public final void run() {
                    fsp.O000000o().O0000Oo.goUpdateActivity(currentActivity, device.did);
                }
            });
        }
    }

    @ReactMethod
    public final void openDeviceUpgradeHistoryPage() {
        DeviceStat device = getDevice();
        Activity currentActivity = getCurrentActivity();
        if (device != null && currentActivity != null) {
            fbt fbt = new fbt(currentActivity, "FireWareHistoryActivity");
            fbt.O000000o("did", device.did);
            fbs.O000000o(fbt);
        }
    }

    @ReactMethod
    public final void openAddDeviceGroupPage() {
        final DeviceStat device = getDevice();
        final Activity currentActivity = getCurrentActivity();
        if (device != null && currentActivity != null) {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass18 */

                public final void run() {
                    XmPluginHostApi.instance().createDeviceGroup(currentActivity, device.model);
                }
            });
        }
    }

    @ReactMethod
    public final void openAddDeviceGroupPageWithGroupModel(final String str) {
        DeviceStat device = getDevice();
        final Activity currentActivity = getCurrentActivity();
        if (device != null && currentActivity != null) {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass19 */

                public final void run() {
                    XmPluginHostApi.instance().createDeviceGroup(currentActivity, str);
                }
            });
        }
    }

    @ReactMethod
    public final void openEditDeviceGroupPage(ReadableArray readableArray) {
        final DeviceStat device = getDevice();
        final Activity currentActivity = getCurrentActivity();
        if (device == null || currentActivity == null) {
            gbu.O00000Oo("openEditDeviceGroupPage: device is null");
        } else {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass20 */

                public final void run() {
                    ((gdu) gdv.f17570O000000o.getUiInterface()).O000000o(currentActivity, device.model, device.did);
                }
            });
        }
    }

    @Deprecated
    @ReactMethod
    public final void openTimerSettingPage(String str, String str2, String str3, String str4) {
        final DeviceStat device = getDevice();
        final Activity currentActivity = getCurrentActivity();
        if (device != null && currentActivity != null) {
            final String str5 = str;
            final String str6 = str2;
            final String str7 = str3;
            final String str8 = str4;
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass21 */

                public final void run() {
                    fsp.O000000o().O0000Oo.startSetTimerList(currentActivity, device.did, str5, str6, str7, str8, "", "");
                }
            });
        }
    }

    @Deprecated
    @ReactMethod
    public final void openTimerSettingPageWithVariousTypeParams(String str, String str2, String str3, String str4) {
        final DeviceStat device = getDevice();
        final Activity currentActivity = getCurrentActivity();
        if (device != null && currentActivity != null) {
            final String str5 = str;
            final String str6 = str2;
            final String str7 = str3;
            final String str8 = str4;
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass22 */

                public final void run() {
                    fsp.O000000o().O0000Oo.startSetTimerList(currentActivity, device.did, str5, str6, str7, str8, "", "");
                }
            });
        }
    }

    @Deprecated
    @ReactMethod
    public final void openTimerSettingPageWithCustomIdentifier(String str, String str2, String str3, String str4, String str5) {
        final DeviceStat device = getDevice();
        final Activity currentActivity = getCurrentActivity();
        if (device != null && currentActivity != null) {
            final String str6 = str2;
            final String str7 = str3;
            final String str8 = str4;
            final String str9 = str5;
            final String str10 = str;
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass24 */

                public final void run() {
                    fsp.O000000o().O0000Oo.startSetTimerList(currentActivity, device.did, str6, str7, str8, str9, str10, "", "");
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gbl.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gbl.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.gbl.O000000o(java.lang.String, boolean):boolean */
    @ReactMethod
    public final void openTimerSettingPageWithOptions(ReadableMap readableMap) {
        final DeviceStat device = getDevice();
        if (device == null || readableMap == null) {
            gbu.O00000Oo("device is null or params is null...");
            return;
        }
        gbl gbl = new gbl(readableMap);
        final String O000000o2 = gbl.O000000o("onMethod", "");
        final String O000000o3 = gbl.O000000o("onParam", "");
        final String O000000o4 = gbl.O000000o("offMethod", "");
        final String O000000o5 = gbl.O000000o("offParam", "");
        final String O000000o6 = gbl.O000000o("displayName", "");
        final String O000000o7 = gbl.O000000o("identify", "");
        final String O000000o8 = gbl.O000000o("timerTitle", "");
        final String O000000o9 = gbl.O000000o("did", "");
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("on_timer_tips", gbl.O000000o("onTimerTips", ""));
            jSONObject.put("off_timer_tips", gbl.O000000o("offTimerTips", ""));
            jSONObject.put("list_timer_tips", gbl.O000000o("listTimerTips", ""));
            jSONObject.put("both_timer_must_be_set", gbl.O000000o("bothTimerMustBeSet", false));
            jSONObject.put("on_timer_type", gbl.O000000o("showOnTimerType", true));
            jSONObject.put("off_timer_type", gbl.O000000o("showOffTimerType", true));
            jSONObject.put("period_timer_type", gbl.O000000o("showPeriodTimerType", true));
        } catch (JSONException e) {
            gbu.O00000Oo("MIOTHost:  " + e.toString());
        }
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass25 */

            public final void run() {
                fsp.O000000o().O0000Oo.startSetTimerListV4(MIOTHostModule.this.getCurrentActivity(), TextUtils.isEmpty(O000000o9) ? device.did : O000000o9, false, O000000o2, O000000o3, O000000o4, O000000o5, O000000o7, O000000o6, O000000o8, jSONObject);
            }
        });
    }

    @ReactMethod
    public final void openPowerMultikeyPage(final String str, final String str2) {
        if (getDevice() != null) {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass26 */

                public final void run() {
                    ((gdu) gdv.f17570O000000o.getUiInterface()).O00000oO(MIOTHostModule.this.getCurrentActivity(), str, str2);
                }
            });
        }
    }

    @ReactMethod
    public final void launchCountDownWhenDevice(final boolean z, final ReadableMap readableMap) {
        final DeviceStat device = getDevice();
        if (device != null) {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass27 */

                public final void run() {
                    gbl gbl = new gbl(readableMap);
                    String O000000o2 = gbl.O000000o("onMethod", "");
                    String O000000o3 = gbl.O000000o("offMethod", "");
                    String O000000o4 = gbl.O000000o("onParam", "");
                    String O000000o5 = gbl.O000000o("offParam", "");
                    String O000000o6 = gbl.O000000o("identify", "");
                    String O000000o7 = gbl.O000000o("displayName", "");
                    if (MIOTHostModule.this.getCurrentActivity() != null) {
                        fsp.O000000o().O0000Oo.startSetTimerCountDownV2(MIOTHostModule.this.getCurrentActivity(), device.did, O000000o2, O000000o4, O000000o3, O000000o5, z, O000000o6, O000000o7);
                    } else {
                        gbu.O00000Oo("current activity is null...");
                    }
                }
            });
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
    public final void openDevice(String str, String str2, ReadableMap readableMap, Callback callback) {
        DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
        if (deviceByDid == null) {
            gbu.O00000Oo("device is null...");
        } else if (!CoreApi.O000000o().O00000o(deviceByDid.model)) {
            gbu.O00000Oo("model is not plugin device...");
        } else if (getCurrentActivity() == null) {
            gbu.O00000Oo("current activity is null...");
        } else {
            Intent intent = new Intent(getCurrentActivity(), LoadingRNActivity.class);
            Bundle bundle = Arguments.toBundle(readableMap);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            intent.putExtra("activity_start_from", 1001);
            intent.putExtra("did", str);
            intent.putExtra("optReuseProcessEnable", false);
            getCurrentActivity().startActivity(intent);
        }
    }

    @ReactMethod
    public final void openOneTimePassword(final String str, final int i, final int i2) {
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass28 */

            public final void run() {
                fsp.O000000o().O0000Oo.openOneTimePasswordActivity(MIOTHostModule.this.getCurrentActivity(), str, i, i2);
            }
        });
    }

    @ReactMethod
    public final void openDeviceTimeZoneSettingPage(final ReadableMap readableMap) {
        final DeviceStat device = getDevice();
        if (device == null || getCurrentActivity() == null) {
            gbu.O00000Oo("current device or current activity is null...");
        } else {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass29 */

                public final void run() {
                    ReadableMap readableMap = readableMap;
                    boolean O000000o2 = readableMap != null ? fyf.O000000o(readableMap, "sync_device") : false;
                    Intent intent = new Intent(MIOTHostModule.this.getCurrentActivity(), ((gdu) gdv.f17570O000000o.getUiInterface()).O00000o0());
                    intent.putExtra("extra_device_did", device.did);
                    intent.putExtra("sync_device", O000000o2);
                    MIOTHostModule.this.getCurrentActivity().startActivityForResult(intent, 3);
                }
            });
        }
    }

    @ReactMethod
    public final void openBtGatewayActivity() {
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass30 */

            public final void run() {
                DeviceStat device = MIOTHostModule.this.getDevice();
                Activity currentActivity = MIOTHostModule.this.getCurrentActivity();
                if (currentActivity == null || device == null) {
                    gbu.O00000Oo("current device or current activity is null...");
                } else {
                    fsp.O000000o().O0000Oo.openBtGatewayActivity(currentActivity, device.did);
                }
            }
        });
    }

    @ReactMethod
    public final void openPhoneBluSettingActivity() {
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass31 */

            public final void run() {
                Activity currentActivity = MIOTHostModule.this.getCurrentActivity();
                if (currentActivity != null) {
                    currentActivity.startActivity(new Intent("android.settings.BLUETOOTH_SETTINGS"));
                }
            }
        });
    }

    @ReactMethod
    public final void openXiaoAiLearnPage(final ReadableMap readableMap) {
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass32 */

            public final void run() {
                Activity currentActivity = MIOTHostModule.this.getCurrentActivity();
                if (currentActivity != null) {
                    ((gdu) gdv.f17570O000000o.getUiInterface()).O00000o(currentActivity, gbv.O00000o0(readableMap));
                }
            }
        });
    }

    @ReactMethod
    public final void openConnectSucceedPage(final String str, final String str2) {
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass33 */

            public final void run() {
                Activity currentActivity = MIOTHostModule.this.getCurrentActivity();
                if (currentActivity != null) {
                    ((gdu) gdv.f17570O000000o.getUiInterface()).O00000o(currentActivity, str, str2);
                }
            }
        });
    }

    @ReactMethod
    public final void openCurtainGroupNamePage(final String str, final String str2, final String str3) {
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass35 */

            public final void run() {
                Activity currentActivity = MIOTHostModule.this.getCurrentActivity();
                if (currentActivity != null) {
                    ((gdu) gdv.f17570O000000o.getUiInterface()).O000000o(currentActivity, str, str2, str3);
                }
            }
        });
    }

    @ReactMethod
    public final void loadRealDeviceConfig(String str, Callback callback) {
        String str2;
        String str3;
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str);
        WritableMap createMap = Arguments.createMap();
        if (O00000oO != null) {
            createMap.putString("deviceName", O00000oO.O0000Oo0());
            createMap.putString("deviceIconURL", O00000oO.O0000o0());
        }
        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
        if (O00oOooo == null) {
            O00oOooo = Locale.getDefault();
        }
        if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
            StringBuilder sb = new StringBuilder("https://");
            if (O0000ooO != null) {
                str3 = O0000ooO.f7546O000000o + ".";
            } else {
                str3 = "";
            }
            sb.append(str3);
            sb.append("home.mi.com/views/deviceReset.html?model=");
            sb.append(str);
            sb.append("&locale=");
            sb.append(flk.O000000o(O00oOooo));
            str2 = sb.toString();
        } else {
            str2 = "https://home.mi.com/views/deviceReset.html?model=" + str + "&locale=" + flk.O000000o(O00oOooo);
        }
        createMap.putInt("productID", CoreApi.O000000o().O0000O0o(str));
        createMap.putString("resetPageURL", str2);
        callback.invoke(Boolean.TRUE, createMap);
    }

    @ReactMethod
    public final void loadCurrentCountryCode(Callback callback) {
        try {
            callback.invoke(new JSONObject(XmPluginHostApi.instance().getCurrentServer()).optString("countryCode"));
        } catch (JSONException e) {
            callback.invoke(e.toString());
        }
    }

    @ReactMethod
    public final void getConnectedWifi(Callback callback) {
        boolean z;
        if (Build.VERSION.SDK_INT < 28) {
            z = true;
        } else {
            z = fuy.O00000o();
        }
        if (z) {
            WifiManager wifiManager = (WifiManager) getReactApplicationContext().getApplicationContext().getSystemService("wifi");
            if (wifiManager.isWifiEnabled()) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("BSSID", connectionInfo.getBSSID());
                    createMap.putString("SSID", connectionInfo.getSSID());
                    callback.invoke(Boolean.TRUE, createMap);
                    return;
                }
                callback.invoke(Boolean.FALSE, "wifi info is null!");
                return;
            }
            callback.invoke(Boolean.FALSE, "wifi is disabled!");
            return;
        }
        if (getCurrentActivity() != null) {
            getCurrentActivity().startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        }
        callback.invoke(Boolean.FALSE, "not open location server!");
    }

    @ReactMethod
    public final void getAppName(Callback callback) {
        String str = "";
        try {
            str = getCurrentActivity().getString(R.string.mj_app_name);
            if (TextUtils.isEmpty(str)) {
                str = (String) getCurrentActivity().getApplicationContext().getPackageManager().getApplicationLabel(getCurrentActivity().getApplicationInfo());
            }
        } catch (Exception e) {
            fyc.O00000o("rn-plugin", e.toString());
        }
        callback.invoke(str);
    }

    @ReactMethod
    public final void getUserConfigs(int i, ReadableArray readableArray, final Callback callback) {
        DeviceStat device = getDevice();
        int size = readableArray.size();
        int[] iArr = new int[size];
        int i2 = 0;
        while (i2 < size) {
            try {
                iArr[i2] = readableArray.getInt(i2);
                i2++;
            } catch (Exception e) {
                callback.invoke(Boolean.FALSE, -1, e.toString());
                return;
            }
        }
        XmPluginHostApi.instance().getUserConfigV2(null, device.model, i, iArr, new com.xiaomi.smarthome.device.api.Callback<Map<String, Object>>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass36 */

            public final /* synthetic */ void onSuccess(Object obj) {
                Map map = (Map) obj;
                WritableMap createMap = Arguments.createMap();
                if (map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        Object value = entry.getValue();
                        if (value != null) {
                            createMap.putString((String) entry.getKey(), value.toString());
                        } else {
                            createMap.putString((String) entry.getKey(), "");
                        }
                    }
                }
                callback.invoke(Boolean.TRUE, createMap, "success");
            }

            public final void onFailure(int i, String str) {
                callback.invoke(Boolean.FALSE, Integer.valueOf(i), str);
            }
        });
    }

    @ReactMethod
    public void colorsToImageBase64(String str, String str2, String str3, String str4, Callback callback) {
        Observable.just(str).map(new Function(str, str2, str3, str4) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTHostModule$I5vJrGuHg5DT3y1NaVmbinzeoTo */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ String f$3;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final Object apply(Object obj) {
                return MIOTHostModule.lambda$colorsToImageBase64$0(this.f$0, this.f$1, this.f$2, this.f$3, (String) obj);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTHostModule$5tyAgwVIJE7Gyr3pUlXPIHGAfUY */

            public final void accept(Object obj) {
                Callback.this.invoke(Boolean.TRUE, (String) obj);
            }
        }, new Consumer() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTHostModule$jCCHc1i2TA9yfODf46zKTXK3do */

            public final void accept(Object obj) {
                MIOTHostModule.lambda$colorsToImageBase64$2(Callback.this, (Throwable) obj);
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    static /* synthetic */ String lambda$colorsToImageBase64$0(String str, String str2, String str3, String str4, String str5) throws Exception {
        byte[] decode = Base64.decode(str, 2);
        int O000000o2 = fyf.O000000o(decode, 58);
        int O000000o3 = fyf.O000000o(decode, 62);
        int parseColor = Color.parseColor(str2);
        int parseColor2 = Color.parseColor(str3);
        int parseColor3 = Color.parseColor(str4);
        int[] iArr = new int[(O000000o2 * O000000o3)];
        int length = iArr.length;
        int i = 86;
        for (int i2 = 0; i2 < length; i2++) {
            byte b = decode[i];
            if (b == -1) {
                iArr[i2] = parseColor;
            } else if (b == 0) {
                iArr[i2] = parseColor2;
            } else if (b == 1) {
                iArr[i2] = parseColor3;
            }
            i++;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(-1.0f, 1.0f);
        Bitmap createBitmap = Bitmap.createBitmap(iArr, O000000o2, O000000o3, Bitmap.Config.ARGB_8888);
        Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, O000000o2, O000000o3, matrix, true);
        String O000000o4 = fyf.O000000o(createBitmap2);
        createBitmap.recycle();
        createBitmap2.recycle();
        return O000000o4;
    }

    static /* synthetic */ void lambda$colorsToImageBase64$2(Callback callback, Throwable th) throws Exception {
        fyc.O00000o("MIOTHostModule", th.toString());
        callback.invoke(Boolean.FALSE, th.toString());
    }

    @ReactMethod
    public void pointsToImageBase64(int i, int i2, String str, String str2, Callback callback) {
        Observable.just(str).map(new Function(i, i2, str2) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTHostModule$3YCTFfAyfmDCJXggORfqUpm3nRQ */
            private final /* synthetic */ int f$0;
            private final /* synthetic */ int f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object apply(Object obj) {
                return MIOTHostModule.lambda$pointsToImageBase64$3(this.f$0, this.f$1, this.f$2, (String) obj);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTHostModule$PEe5bI2z2jSf6GYqa6hZbOkwQL8 */

            public final void accept(Object obj) {
                Callback.this.invoke(Boolean.TRUE, (String) obj);
            }
        }, new Consumer() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTHostModule$giT3yIQA6_bbvJBS80Lv9dWsQ */

            public final void accept(Object obj) {
                MIOTHostModule.lambda$pointsToImageBase64$5(Callback.this, (Throwable) obj);
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    static /* synthetic */ String lambda$pointsToImageBase64$3(int i, int i2, String str, String str2) throws Exception {
        gbu.O000000o("pointsToImageBase64:  width==" + i + "   height==" + i2);
        JSONObject jSONObject = new JSONObject(str);
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, Integer.valueOf(Color.parseColor(jSONObject.getString(next))));
        }
        String[] split = str2.split(",");
        int[] iArr = new int[(i * i2)];
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = ((Integer) hashMap.get(split[i3])).intValue();
        }
        Matrix matrix = new Matrix();
        matrix.setScale(1.0f, -1.0f);
        Bitmap createBitmap = Bitmap.createBitmap(iArr, i, i2, Bitmap.Config.ARGB_8888);
        Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, i, i2, matrix, true);
        String O000000o2 = fyf.O000000o(createBitmap2);
        createBitmap.recycle();
        createBitmap2.recycle();
        return O000000o2;
    }

    static /* synthetic */ void lambda$pointsToImageBase64$5(Callback callback, Throwable th) throws Exception {
        th.printStackTrace();
        callback.invoke(Boolean.FALSE, th.toString());
    }

    private boolean isXiaomiPhone() {
        String lowerCase = Build.BRAND.toLowerCase();
        if (!TextUtils.isEmpty(lowerCase)) {
            return lowerCase.contains("xiaomi");
        }
        return false;
    }

    private boolean isSamsungPhone() {
        return Build.MANUFACTURER.trim().toLowerCase().contains("samsung");
    }

    @ReactMethod
    public void phoneHasNfc(Callback callback) {
        if (callback != null) {
            if (getCurrentActivity() == null) {
                callback.invoke(Boolean.FALSE, "current activity is null...");
                return;
            }
            NfcAdapter defaultAdapter = ((NfcManager) getCurrentActivity().getSystemService("nfc")).getDefaultAdapter();
            WritableMap createMap = Arguments.createMap();
            if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
                createMap.putBoolean("hasNfc", false);
                callback.invoke(Boolean.TRUE, createMap);
                return;
            }
            createMap.putBoolean("hasNfc", true);
            callback.invoke(Boolean.TRUE, createMap);
        }
    }

    @ReactMethod
    public void openMiPayPage(ReadableMap readableMap, Callback callback) {
        String format = String.format("https://tsmclient.miui.com?action=%1$s&type=%2$s&product_id=%3$s&source_channel=%4$s", fyf.O000000o(readableMap, "action", "issue_mifare"), fyf.O000000o(readableMap, "type", "1"), fyf.O000000o(readableMap, "product_id", "66666-00211"), fyf.O000000o(readableMap, "source_channel", "mijia"));
        gbu.O000000o("MIOTHost openMiPayPage  url=".concat(String.valueOf(format)));
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
        WritableMap createMap = Arguments.createMap();
        if (getCurrentActivity() == null) {
            createMap.putBoolean("result", false);
            createMap.putBoolean("isSupportMiPay", isSupportMiPay());
            createMap.putString("detail", "current activity is null");
            callback.invoke(Boolean.FALSE, createMap);
        } else if (isSupportMiPay()) {
            getCurrentActivity().startActivity(intent);
            createMap.putBoolean("result", true);
            createMap.putBoolean("isSupportMiPay", true);
            createMap.putString("detail", "");
            callback.invoke(Boolean.TRUE, createMap);
        } else {
            createMap.putBoolean("result", false);
            createMap.putBoolean("isSupportMiPay", false);
            createMap.putString("detail", "");
            callback.invoke(Boolean.FALSE, createMap);
        }
    }

    private boolean isSupportMiPay() {
        try {
            if (getCurrentActivity().getPackageManager().getPackageInfo("com.miui.tsmclient", 0).versionCode >= 41) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            gbu.O00000Oo(e.toString());
            return false;
        }
    }

    @ReactMethod
    public void loadOperatorsType(Callback callback) {
        if (getCurrentActivity() == null) {
            callback.invoke(Boolean.FALSE, "current activity is null ...");
            return;
        }
        TelephonyManager telephonyManager = (TelephonyManager) getCurrentActivity().getSystemService("phone");
        WritableMap createMap = Arguments.createMap();
        createMap.putString("name", telephonyManager.getSimOperatorName());
        createMap.putString("simOperator", telephonyManager.getSimOperator());
        createMap.putString("countryCode", telephonyManager.getSimCountryIso());
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putMap("1", createMap);
        callback.invoke(Boolean.TRUE, createMap2);
    }

    @ReactMethod
    public void openMeshDeviceGroupPage(final String str, final String str2, int i) {
        if (i == 1) {
            openMeshDeviceGroupPageV1(str, str2);
        } else {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass37 */

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
                public final void run() {
                    if (MIOTHostModule.this.getCurrentActivity() == null) {
                        gbu.O000000o("current activity is null...");
                        return;
                    }
                    DeviceStat deviceByDid = PluginHostApi.instance().getDeviceByDid(str2);
                    if (deviceByDid == null) {
                        gbu.O000000o("current device is null...");
                        return;
                    }
                    Intent intent = new Intent(MIOTHostModule.this.getCurrentActivity(), ((gdu) gdv.f17570O000000o.getUiInterface()).O0000OOo());
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(deviceByDid.did);
                    intent.putExtra("args_key_did_list", arrayList);
                    if ("add".equalsIgnoreCase(str)) {
                        intent.putExtra("lightGroupNeedInit", true);
                    } else if ("edit".equalsIgnoreCase(str)) {
                        intent.putExtra("args_key_edit_mode", true);
                    }
                    MIOTHostModule.this.getCurrentActivity().startActivity(intent);
                }
            });
        }
    }

    private void openMeshDeviceGroupPageV1(final String str, final String str2) {
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass38 */

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
            public final void run() {
                if (MIOTHostModule.this.getCurrentActivity() == null) {
                    gbu.O000000o("current activity is null...");
                    return;
                }
                DeviceStat deviceByDid = PluginHostApi.instance().getDeviceByDid(str2);
                if (deviceByDid == null) {
                    gbu.O000000o("current device is null...");
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("did", deviceByDid.did);
                String str = deviceByDid.model;
                if ("add".equalsIgnoreCase(str)) {
                    intent.setClass(MIOTHostModule.this.getCurrentActivity(), ((gdu) gdv.f17570O000000o.getUiInterface()).O0000Oo0());
                    str = XmPluginHostApi.instance().getLightDeviceGroupModel(deviceByDid.model);
                    intent.putExtra("create_mode", true);
                    intent.putExtra("lightGroupNeedInit", true);
                } else if ("edit".equalsIgnoreCase(str)) {
                    intent.setClass(MIOTHostModule.this.getCurrentActivity(), ((gdu) gdv.f17570O000000o.getUiInterface()).O0000Oo());
                }
                if (TextUtils.isEmpty(str)) {
                    gbu.O00000o("openMeshDeviceGroupPage: groupModel is empty");
                }
                intent.putExtra("key_group_model", str);
                MIOTHostModule.this.getCurrentActivity().startActivity(intent);
            }
        });
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
    public void openLightGroupUpgradePage() {
        if (getCurrentActivity() == null) {
            gbu.O000000o("current activity is null...");
            return;
        }
        DeviceStat device = getDevice();
        if (device == null) {
            gbu.O000000o("current device is null...");
            return;
        }
        Intent intent = new Intent(getCurrentActivity(), ((gdu) gdv.f17570O000000o.getUiInterface()).O0000Oo());
        intent.putExtra("did", device.did);
        intent.putExtra("args_key_upgrade_only", true);
        getCurrentActivity().startActivity(intent);
    }

    @ReactMethod
    public void openBleGroupUpgradePage(int i) {
        if (getCurrentActivity() == null) {
            gbu.O000000o("current activity is null...");
            return;
        }
        DeviceStat device = getDevice();
        if (device == null) {
            gbu.O000000o("current device is null...");
            return;
        }
        fbt fbt = new fbt(getCurrentActivity(), "BleGroupUpgradeDectectActivity");
        fbt.O000000o("arg_auth_type", 5);
        fbt.O000000o("did", device.did);
        fbs.O000000o(fbt);
    }

    @ReactMethod
    public void checkStoreSupportted(Callback callback) {
        if (callback != null) {
            boolean isChinaMainLand = XmPluginHostApi.instance().isChinaMainLand(getCurrentActivity().getApplicationContext());
            gbu.O000000o("MIOTHostMudule  是否为国内服务器：  ".concat(String.valueOf(isChinaMainLand)));
            callback.invoke(Boolean.valueOf(isChinaMainLand));
        }
    }

    @ReactMethod
    public void pointsScaleToImageBase64(int i, int i2, String str, String str2, int i3, Callback callback) {
        Observable.just(str).map(new Function(i, i2, str2, i3) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTHostModule$UZXL2dq5C6I1eUlXspzx3x5ppU */
            private final /* synthetic */ int f$0;
            private final /* synthetic */ int f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ int f$3;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final Object apply(Object obj) {
                return MIOTHostModule.lambda$pointsScaleToImageBase64$6(this.f$0, this.f$1, this.f$2, this.f$3, (String) obj);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTHostModule$aUmTgm5g0cmf2S9CF17iR2B4GM */

            public final void accept(Object obj) {
                Callback.this.invoke(Boolean.TRUE, (String) obj);
            }
        }, new Consumer() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTHostModule$H8nkyYKymErbD93yYDioBPB2xc */

            public final void accept(Object obj) {
                MIOTHostModule.lambda$pointsScaleToImageBase64$8(Callback.this, (Throwable) obj);
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    static /* synthetic */ String lambda$pointsScaleToImageBase64$6(int i, int i2, String str, int i3, String str2) throws Exception {
        int i4 = i;
        int i5 = i2;
        String str3 = str;
        int i6 = i3;
        gbu.O000000o("width==" + i4 + "   height==" + i5 + "  colorsMap=" + str3 + "  scale=" + i6);
        JSONObject jSONObject = new JSONObject(str3);
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, Integer.valueOf(Color.parseColor(jSONObject.getString(next))));
        }
        String[] split = str2.split(",");
        int i7 = i4 * i6;
        int[] iArr = new int[(i7 * i5 * i6)];
        int i8 = i4 * i5;
        for (int i9 = 0; i9 < i8; i9++) {
            String str4 = split[i9];
            Integer num = (Integer) hashMap.get(str4);
            if (num == null) {
                gbu.O00000Oo("colorKey=" + str4 + " is null");
                num = 0;
            }
            if (i6 == 1) {
                iArr[i9] = num.intValue();
            } else {
                int i10 = i9 / i4;
                for (int i11 = 0; i11 < i6; i11++) {
                    int i12 = (i9 * i6) + ((i10 + i11) * i4 * i6);
                    for (int i13 = 0; i13 < i6; i13++) {
                        iArr[i12 + i13] = num.intValue();
                    }
                }
            }
        }
        Matrix matrix = new Matrix();
        matrix.setScale(1.0f, -1.0f);
        int i14 = i5 * i6;
        Bitmap createBitmap = Bitmap.createBitmap(iArr, i7, i14, Bitmap.Config.ARGB_8888);
        Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, i7, i14, matrix, true);
        String O000000o2 = fyf.O000000o(createBitmap2);
        createBitmap.recycle();
        createBitmap2.recycle();
        return O000000o2;
    }

    static /* synthetic */ void lambda$pointsScaleToImageBase64$8(Callback callback, Throwable th) throws Exception {
        th.printStackTrace();
        callback.invoke(Boolean.FALSE, th.toString());
    }

    @ReactMethod
    public void zhuimiRobotTracesToImageBase64(final int i, final int i2, final String str, final Callback callback) {
        Observable.just(str).map(new Function<String, String>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass41 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                return fyf.O000000o(i, i2, str);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass39 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap
             arg types: [int, java.lang.String]
             candidates:
              _m_j.gbq.O000000o(int, java.lang.String):com.facebook.react.bridge.WritableMap
              _m_j.gbq.O000000o(com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo, java.lang.String):com.facebook.react.bridge.WritableMap
              _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap */
            public final /* synthetic */ void accept(Object obj) throws Exception {
                callback.invoke(Boolean.TRUE, gbq.O000000o(0, (Object) ((String) obj)));
            }
        }, new Consumer<Throwable>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass40 */

            public final /* synthetic */ void accept(Object obj) throws Exception {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, ((Throwable) obj).toString()));
            }
        });
    }

    @ReactMethod
    public void openPluginRecommendScene(final String str, final int i) {
        if (getCurrentActivity() == null) {
            gbu.O00000Oo("current activity is null...");
        } else {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass42 */

                public final void run() {
                    Intent intent = new Intent(MIOTHostModule.this.getCurrentActivity(), ((gdu) gdv.f17570O000000o.getUiInterface()).O0000OoO());
                    intent.putExtra("did", str);
                    intent.putExtra("sr_id", i);
                    MIOTHostModule.this.getCurrentActivity().startActivity(intent);
                }
            });
        }
    }

    @ReactMethod
    public void getSystemTimezoneNameWithCallback(Callback callback) {
        if (callback != null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("timeZone", TimeZone.getDefault().getID());
            callback.invoke(Boolean.TRUE, createMap);
        }
    }

    @ReactMethod
    public void pageShouldAdapterSoftKeyboard(final boolean z, Callback callback) {
        if (callback != null) {
            if (getCurrentActivity() == null) {
                callback.invoke(Boolean.FALSE, "current activity is null...");
                return;
            }
            gbu.O000000o("pageShouldFixSoftKeyboard-->pageShouldFix: ".concat(String.valueOf(z)));
            final Activity currentActivity = getCurrentActivity();
            if (currentActivity != null) {
                currentActivity.runOnUiThread(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass43 */

                    public final void run() {
                        if (z) {
                            currentActivity.getWindow().setSoftInputMode(16);
                        } else {
                            currentActivity.getWindow().setSoftInputMode(32);
                        }
                        fxm.O000000o().O00000oO = z;
                    }
                });
                callback.invoke(Boolean.TRUE, Boolean.TRUE);
            }
        }
    }

    @ReactMethod
    public void refreshDeviceList(final Callback callback) {
        if (callback == null) {
            gbu.O00000Oo("callback is null...");
            return;
        }
        final boolean[] zArr = {false};
        XmPluginHostApi.instance().updateDeviceList(new com.xiaomi.smarthome.device.api.Callback<Void>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass44 */

            public final void onFailure(int i, String str) {
                boolean[] zArr = zArr;
                if (!zArr[0]) {
                    zArr[0] = true;
                    try {
                        Callback callback = callback;
                        callback.invoke("code: " + i + "   errorInfo: " + str);
                    } catch (Exception e) {
                        gbu.O00000Oo(e.toString());
                    }
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                boolean[] zArr = zArr;
                if (!zArr[0]) {
                    zArr[0] = true;
                    try {
                        callback.invoke(Boolean.TRUE, Boolean.TRUE);
                    } catch (Exception e) {
                        gbu.O00000Oo(e.toString());
                    }
                }
            }
        });
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
    public final void openPluginPage(String str, String str2, ReadableMap readableMap, Callback callback) {
        if (callback != null) {
            if (TextUtils.isEmpty(str)) {
                callback.invoke(Boolean.FALSE, "did is empty!");
                return;
            }
            DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
            if (deviceByDid == null) {
                callback.invoke(Boolean.FALSE, "cannot get device info from did, did is ".concat(String.valueOf(str)));
            } else if (getCurrentActivity() == null) {
                callback.invoke(Boolean.FALSE, "current activity is null");
            } else {
                fyc.O00000o0("MIOTHostModule", "openPluginPage,curModel:" + deviceByDid.model + ",targetPage:" + str2);
                Intent intent = new Intent(getCurrentActivity(), LoadingRNActivity.class);
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                intent.putExtra("pageName", str2);
                intent.putExtra("pageParams", fyf.O000000o(readableMap));
                intent.putExtra("did", str);
                intent.putExtra("optReuseProcessEnable", false);
                if (MockRnDevicePluginManager.getInstance().didIsMockDid(str)) {
                    intent.putExtra("activity_start_from", 1002);
                    intent.putExtra(fvt.O0000O0o, MockRnDevicePluginManager.getInstance().getMockPluginDownloadUrl(str));
                } else {
                    intent.putExtra("activity_start_from", 1001);
                }
                getCurrentActivity().startActivity(intent);
                callback.invoke(Boolean.TRUE, Boolean.TRUE);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public final void openDeviceNetworkInfoPage() {
        DeviceStat device = getDevice();
        if (device == null) {
            gbu.O00000Oo("openDeviceNetworkInfoPage: cannot get device info");
            return;
        }
        String str = device.did;
        if (TextUtils.isEmpty(str)) {
            gbu.O00000Oo("openDeviceNetworkInfoPage: did is empty");
            return;
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            gbu.O00000Oo("openDeviceNetworkInfoPage: getCurrentActivity is null");
            return;
        }
        Intent intent = new Intent(currentActivity, ((gdu) gdv.f17570O000000o.getUiInterface()).O0000Ooo());
        intent.putExtra("did", str);
        currentActivity.startActivity(intent);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap
     arg types: [int, java.lang.String]
     candidates:
      _m_j.gbq.O000000o(int, java.lang.String):com.facebook.react.bridge.WritableMap
      _m_j.gbq.O000000o(com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo, java.lang.String):com.facebook.react.bridge.WritableMap
      _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap */
    @ReactMethod
    public void convertDateToCron(ReadableMap readableMap, Callback callback) {
        if (callback != null) {
            callback.invoke(Boolean.TRUE, gbq.O000000o(0, (Object) ((gdt) gdv.f17570O000000o.getServiceInterface()).O000000o(readableMap)));
        }
    }

    @ReactMethod
    public void convertCronToDate(ReadableMap readableMap, Callback callback) {
        if (callback == null) {
            return;
        }
        if (readableMap == null) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "params is null"));
        } else if (TextUtils.isEmpty(readableMap.getString("cron"))) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "cron is empty"));
        } else {
            callback.invoke(Boolean.TRUE, gbq.O000000o(0, ((gdt) gdv.f17570O000000o.getServiceInterface()).O00000Oo(readableMap)));
        }
    }

    @ReactMethod
    public void connectWifiWithSSID(final String str, final Callback callback) {
        CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass46 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap
             arg types: [int, java.lang.String]
             candidates:
              _m_j.gbq.O000000o(int, java.lang.String):com.facebook.react.bridge.WritableMap
              _m_j.gbq.O000000o(com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo, java.lang.String):com.facebook.react.bridge.WritableMap
              _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap */
            public final void run() {
                WifiManager wifiManager = (WifiManager) CommonApplication.getAppContext().getApplicationContext().getSystemService("wifi");
                if (wifiManager == null || TextUtils.isEmpty(str)) {
                    callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.INVALID_ERROR, "invalid ssid"));
                } else if (!wifiManager.isWifiEnabled()) {
                    callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.INVALID_ERROR, "wifi is not enabled"));
                } else {
                    List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
                    WifiConfiguration wifiConfiguration = null;
                    if (!gpn.O000000o(configuredNetworks)) {
                        Iterator<WifiConfiguration> it = configuredNetworks.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            WifiConfiguration next = it.next();
                            if (next.SSID != null && next.SSID.equals(iag.O000000o(str))) {
                                wifiConfiguration = next;
                                break;
                            }
                        }
                    }
                    if (wifiConfiguration != null) {
                        try {
                            if (wifiManager.disconnect() && wifiManager.enableNetwork(wifiConfiguration.networkId, true) && wifiManager.reconnect()) {
                                Callback callback = callback;
                                callback.invoke(Boolean.TRUE, gbq.O000000o(0, (Object) ("connect to " + str + " success")));
                                return;
                            }
                        } catch (SecurityException unused) {
                        }
                    }
                    callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.INVALID_ERROR, "cannot connect to specific ssid"));
                }
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap
     arg types: [int, java.lang.String]
     candidates:
      _m_j.gbq.O000000o(int, java.lang.String):com.facebook.react.bridge.WritableMap
      _m_j.gbq.O000000o(com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo, java.lang.String):com.facebook.react.bridge.WritableMap
      _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap */
    @ReactMethod
    public void bindProcessToNetwork(int i, Callback callback) {
        ReactContext currentReactContext;
        if (callback != null) {
            ReactInstanceManager reactInstanceManager = fwz.O000000o().O00000Oo().O0000O0o;
            if (reactInstanceManager == null || (currentReactContext = reactInstanceManager.getCurrentReactContext()) == null) {
                gbu.O00000Oo("rncamera ReactInstanceManager is null, can not show alarm videos");
                callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.INVALID_ERROR, "null rn runtime"));
                return;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) currentReactContext.getSystemService("connectivity");
            if (connectivityManager == null) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.INVALID_ERROR, "null connectivityManager"));
            } else if (gnn.O00000oO) {
                Network network = null;
                if (i != 2) {
                    Network[] allNetworks = connectivityManager.getAllNetworks();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= allNetworks.length) {
                            break;
                        }
                        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(allNetworks[i2]);
                        if (networkInfo != null) {
                            if (networkInfo.getType() == (i == 0 ? 0 : 1)) {
                                network = allNetworks[i2];
                                break;
                            }
                        }
                        i2++;
                    }
                    if (network == null) {
                        callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.INVALID_ERROR, "unable find specific type"));
                    } else if (connectivityManager.bindProcessToNetwork(network)) {
                        callback.invoke(Boolean.TRUE, gbq.O000000o(0, (Object) "bind process to specific wifi success"));
                    } else {
                        callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.INVALID_ERROR, "bind process to specific network failed"));
                    }
                } else if (connectivityManager.bindProcessToNetwork(null)) {
                    callback.invoke(Boolean.TRUE, gbq.O000000o(0, (Object) "bind process to specific wifi success"));
                } else {
                    callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.INVALID_ERROR, "bind process to specific network failed"));
                }
            } else {
                callback.invoke(Boolean.TRUE, gbq.O000000o(0, (Object) "ignored under os version 5.x"));
            }
        }
    }

    @ReactMethod
    public void openDeviceSettingPageWithType(int i) {
        if (getCurrentActivity() == null) {
            gbu.O00000Oo("current activity is null...");
        } else if (i == 1) {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", getCurrentActivity().getPackageName(), null));
            getCurrentActivity().startActivity(intent);
        } else if (i == 2) {
            getCurrentActivity().startActivity(new Intent("android.settings.WIFI_SETTINGS"));
        } else if (i == 3) {
            Intent intent2 = new Intent();
            intent2.setAction("android.net.wifi.PICK_WIFI_NETWORK");
            getCurrentActivity().startActivity(intent2);
        }
    }

    @ReactMethod
    public void checkPhoneLocationServerIsOpen(Callback callback) {
        if (callback != null) {
            if (getCurrentActivity() == null) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "current activity is null..."));
                return;
            }
            LocationManager locationManager = (LocationManager) getCurrentActivity().getSystemService("location");
            boolean z = locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
            WritableMap createMap = Arguments.createMap();
            createMap.putBoolean("locationServerIsOpen", z);
            callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
        }
    }

    @ReactMethod
    public void openPhoneLocationServerSettingPage() {
        if (getCurrentActivity() == null) {
            gbu.O00000Oo("current activity is null...");
            return;
        }
        getCurrentActivity().startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }

    @ReactMethod
    public void getBtGateWaySubDeviceRSSIWithMac(final String str, final Callback callback) {
        JSONArray jSONArray;
        if (callback != null) {
            if (TextUtils.isEmpty(str)) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "mac can not empty..."));
                return;
            }
            try {
                jSONArray = new JSONArray(XmBluetoothManager.getInstance().getBluetoothGatewayDevices());
            } catch (JSONException e) {
                e.printStackTrace();
                jSONArray = new JSONArray();
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    arrayList.add(jSONArray.getJSONObject(i).getString("did"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (arrayList.size() == 0) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "current account not have gateway device..."));
                return;
            }
            XmPluginHostApi.instance().getBleGatewaySubDevices(arrayList, new com.xiaomi.smarthome.device.api.Callback<List<DeviceStat>>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass47 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    List<DeviceStat> list = (List) obj;
                    if (list == null || list.size() == 0) {
                        callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "current account not have gateway sub device..."));
                    }
                    DeviceStat deviceStat = null;
                    for (DeviceStat deviceStat2 : list) {
                        if (str.equals(deviceStat2.mac)) {
                            if (deviceStat == null) {
                                deviceStat = deviceStat2;
                            }
                            if (deviceStat.rssi < deviceStat2.rssi) {
                                deviceStat = deviceStat2;
                            }
                        }
                    }
                    if (deviceStat == null) {
                        Callback callback = callback;
                        callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "the device mac is " + str + ", but is not gateway sub device..."));
                        return;
                    }
                    WritableMap createMap = Arguments.createMap();
                    createMap.putInt("RSSI", deviceStat.rssi);
                    callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
                }

                public final void onFailure(int i, String str) {
                    callback.invoke(Boolean.FALSE, gbq.O000000o(i, str));
                }
            });
        }
    }

    @ReactMethod
    public void jumpToThirdpartyApplication(String str, Callback callback) {
        String str2;
        if (getCurrentActivity() != null) {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW", parse);
            if (str.startsWith("market") && isSamsungPhone()) {
                String query = parse.getQuery();
                if (query.startsWith("id=")) {
                    str2 = query.replace("id=", "appId=");
                } else {
                    str2 = query.replace("&id=", "&appId=");
                }
                intent = new Intent("android.intent.action.VIEW", Uri.parse("http://apps.samsung.com/appquery/appDetail.as?".concat(String.valueOf(str2))));
                intent.setPackage("com.sec.android.app.samsungapps");
            }
            try {
                getCurrentActivity().startActivityForResult(intent, 201);
                this.mJumpToThirdpartyAppCallback = callback;
            } catch (Exception e) {
                if (callback != null) {
                    callback.invoke(Boolean.FALSE, gbq.O000000o(-1, e.toString()));
                }
            }
        } else if (callback != null) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "current activity is null..."));
        }
    }

    public void jumpToThirdpartyAppResultCallback(boolean z, WritableMap writableMap) {
        Callback callback = this.mJumpToThirdpartyAppCallback;
        if (callback != null) {
            callback.invoke(Boolean.valueOf(z), writableMap);
            this.mJumpToThirdpartyAppCallback = null;
            return;
        }
        gbu.O00000Oo("jumpToThirdpartyAppResultCallback is null...");
    }

    @ReactMethod
    public void checkAbilityOfJumpToThirdpartyApplication(String str, Callback callback) {
        if (callback != null) {
            callback.invoke(Boolean.TRUE, gbq.O000000o(0, Boolean.valueOf(!getCurrentActivity().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(str)), 0).isEmpty())));
        }
    }

    @ReactMethod
    public void generateECCCryptoObjectWithCurveType(int i, Callback callback) {
        if (callback != null) {
            if (this.mKeyPairMap == null) {
                this.mKeyPairMap = new HashMap();
            }
            try {
                KeyPairGenerator instance = KeyPairGenerator.getInstance("EC");
                instance.initialize(new ECGenParameterSpec(getCurveTypeValue(i)));
                KeyPair generateKeyPair = instance.generateKeyPair();
                String uuid = UUID.randomUUID().toString();
                this.mKeyPairMap.put(uuid, generateKeyPair);
                ECPublicKey eCPublicKey = (ECPublicKey) generateKeyPair.getPublic();
                int bitLength = ((eCPublicKey.getParams().getOrder().bitLength() + 8) - 1) / 8;
                byte[] bArr = new byte[((bitLength * 2) + 1)];
                bArr[0] = 4;
                byte[] byteArray = eCPublicKey.getW().getAffineX().toByteArray();
                if (byteArray.length <= bitLength) {
                    System.arraycopy(byteArray, 0, bArr, (bitLength + 1) - byteArray.length, byteArray.length);
                } else if (byteArray.length == bitLength + 1 && byteArray[0] == 0) {
                    System.arraycopy(byteArray, 1, bArr, 1, bitLength);
                } else {
                    throw new IllegalStateException("x value is too large");
                }
                int i2 = bitLength + 1;
                byte[] byteArray2 = eCPublicKey.getW().getAffineY().toByteArray();
                if (byteArray2.length <= bitLength) {
                    System.arraycopy(byteArray2, 0, bArr, (i2 + bitLength) - byteArray2.length, byteArray2.length);
                } else if (byteArray2.length == i2 && byteArray2[0] == 0) {
                    System.arraycopy(byteArray2, 1, bArr, i2, bitLength);
                } else {
                    throw new IllegalStateException("y value is too large");
                }
                String str = new String(Base64.encode(bArr, 2));
                WritableMap createMap = Arguments.createMap();
                createMap.putString("uuid", uuid);
                createMap.putString("publicKey", str);
                callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
            } catch (NoSuchAlgorithmException e) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, e.toString()));
            } catch (InvalidAlgorithmParameterException e2) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, e2.toString()));
            }
        }
    }

    @ReactMethod
    public void sharedSecretFromCryptoObject(String str, String str2, Callback callback) {
        if (callback != null) {
            if (this.mKeyPairMap == null) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "not generator KeyPair"));
            } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "uuid or otherPublicKey can not empty..."));
            } else {
                KeyPair keyPair = this.mKeyPairMap.get(str);
                if (keyPair == null) {
                    callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "can not find KeyPair for this uuid, uuid is ".concat(String.valueOf(str))));
                    return;
                }
                try {
                    String str3 = new String(Base64.encode(fir.O000000o(fio.O000000o(Base64.decode(str2, 2), ((ECPublicKey) keyPair.getPublic()).getParams()), keyPair.getPrivate()).getEncoded(), 2));
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("sharedSecret", str3);
                    callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
                } catch (Exception e) {
                    callback.invoke(Boolean.FALSE, gbq.O000000o(-1, e.toString()));
                }
            }
        }
    }

    @ReactMethod
    public void openVoiceCtrlDevListPage() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            fyc.O00000o0("MIOTHostModule", "openVoiceCtrlDevListPage,getCurrentActivity returns null");
            return;
        }
        XmPluginHostApi.instance().checkAndShowVoiceCtrlAuthorizePageIfNeed(currentActivity, getDevice().did, -1);
    }

    @ReactMethod
    public void openResetAndConnectDevicePage() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            fyc.O00000o0("MIOTHostModule", "openResetAndConnectDevicePage, activity is null");
            return;
        }
        DeviceStat device = getDevice();
        Intent intent = new Intent(currentActivity, ((gdu) gdv.f17570O000000o.getUiInterface()).O0000oO0());
        intent.putExtra("extra_model", device.model);
        intent.addFlags(268435456);
        currentActivity.startActivity(intent);
    }

    private boolean allowFreeAccessExternalStorage(String str) {
        return !TextUtils.isEmpty(str) && FREE_ACCESS_EXTERNAL_STORAGE_MODELS.contains(str);
    }

    @ReactMethod
    public void openFileSelectPage(String str, final Callback callback) {
        if (TextUtils.isEmpty(str)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "mimeType cann't be empty"));
        } else if (!allowFreeAccessExternalStorage(getDevice().model)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "cann't find target page,permission denied"));
        } else {
            final Activity currentActivity = getCurrentActivity();
            if (currentActivity != null) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.OPEN_DOCUMENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType(str);
                if (currentActivity.getPackageManager().resolveActivity(intent, 131072) == null) {
                    callback.invoke(Boolean.FALSE, gbq.O000000o(-3, String.format("cann't find target page,please check if your mimeType:%s is correct", str)));
                    return;
                }
                ft.O000000o(currentActivity).O000000o(new BroadcastReceiver() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass48 */

                    public final void onReceive(Context context, Intent intent) {
                        String str;
                        String str2;
                        ft.O000000o(currentActivity).O000000o(this);
                        Uri uri = (Uri) intent.getParcelableExtra("intent.mData");
                        String str3 = "";
                        if (uri != null) {
                            dn O000000o2 = dn.O000000o(CommonApplication.getAppContext(), uri);
                            String uri2 = uri.toString();
                            str2 = O000000o2.O00000Oo();
                            String O00000o02 = O000000o2.O00000o0();
                            MediaStoreUtil.O000000o(CommonApplication.getAppContext(), uri, 1);
                            str = O00000o02;
                            str3 = uri2;
                        } else {
                            str = str3;
                            str2 = str;
                        }
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("path", str3);
                        createMap.putString("name", str2);
                        createMap.putString("mimeType", str);
                        callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
                    }
                }, new IntentFilter("miot-rn-framework.file_select"));
                currentActivity.startActivityForResult(intent, 402);
            }
        }
    }

    @ReactMethod
    public void openDirectorySelectPage(final Callback callback) {
        if (Build.VERSION.SDK_INT < 21) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "minimum support Android API is 21,current is " + Build.VERSION.SDK_INT));
        } else if (!allowFreeAccessExternalStorage(getDevice().model)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "cann't find target page,permission denied"));
        } else {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.OPEN_DOCUMENT_TREE");
            final Activity currentActivity = getCurrentActivity();
            if (currentActivity != null) {
                ft.O000000o(currentActivity).O000000o(new BroadcastReceiver() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass49 */

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap
                     arg types: [int, java.lang.String]
                     candidates:
                      _m_j.gbq.O000000o(int, java.lang.String):com.facebook.react.bridge.WritableMap
                      _m_j.gbq.O000000o(com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo, java.lang.String):com.facebook.react.bridge.WritableMap
                      _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap */
                    public final void onReceive(Context context, Intent intent) {
                        Uri uri = (Uri) intent.getParcelableExtra("intent.mData");
                        if (uri != null) {
                            MediaStoreUtil.O000000o(CommonApplication.getAppContext(), uri, 3);
                        }
                        Callback callback = callback;
                        Object[] objArr = new Object[2];
                        objArr[0] = Boolean.TRUE;
                        objArr[1] = gbq.O000000o(0, (Object) (uri != null ? uri.toString() : ""));
                        callback.invoke(objArr);
                        ft.O000000o(currentActivity).O000000o(this);
                    }
                }, new IntentFilter("miot-rn-framework.file_select"));
                currentActivity.startActivityForResult(intent, 403);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gdu.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
     arg types: [android.app.Activity, java.lang.String, java.lang.String, java.lang.String]
     candidates:
      _m_j.gdu.O000000o(android.app.Activity, java.lang.String, java.lang.String, int):void
      _m_j.gdu.O000000o(android.app.Activity, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gdu.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void */
    @ReactMethod
    public void openNFCWriteDeviceInfoPage(String str) {
        DeviceStat device = getDevice();
        if (device == null) {
            fyc.O00000o0("MIOTHostModule", "openNFCWriteDeviceInfoPage device is null");
            return;
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            fyc.O00000o0("MIOTHostModule", "openNFCWriteDeviceInfoPage activity is null");
        } else {
            ((gdu) gdv.f17570O000000o.getUiInterface()).O000000o((Context) currentActivity, device.did, device.model, str);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gdu.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
     arg types: [android.app.Activity, java.lang.String, java.lang.String, java.lang.String]
     candidates:
      _m_j.gdu.O000000o(android.app.Activity, java.lang.String, java.lang.String, int):void
      _m_j.gdu.O000000o(android.app.Activity, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gdu.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void */
    @ReactMethod
    public void openNFCWriteDeviceInfoPage_debugonly(ReadableMap readableMap) {
        if (gfr.O0000o0o || gfr.O0000Oo) {
            DeviceStat device = getDevice();
            if (device != null) {
                String str = device.model;
                boolean z = false;
                if (!TextUtils.isEmpty(str)) {
                    JSONArray jSONArray = (JSONArray) gat.O00000Oo("nfc_debug_write_devices", new JSONArray());
                    int length = jSONArray.length();
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        } else if (TextUtils.equals(jSONArray.optString(i), str)) {
                            z = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (z) {
                    String O000000o2 = gbv.O000000o(readableMap, "did");
                    String O000000o3 = gbv.O000000o(readableMap, "model");
                    if (TextUtils.isEmpty(O000000o2) || TextUtils.isEmpty(O000000o3)) {
                        fyc.O00000o0("MIOTHostModule", "openNFCWriteDeviceInfoPage: did or model is empty");
                        gbz.O000000o("did or model cannot be empty");
                        return;
                    }
                    String O000000o4 = gbv.O000000o(readableMap, "extra");
                    Activity currentActivity = getCurrentActivity();
                    if (currentActivity == null) {
                        fyc.O00000o0("MIOTHostModule", "openNFCWriteDeviceInfoPage activity is null");
                        return;
                    } else {
                        ((gdu) gdv.f17570O000000o.getUiInterface()).O000000o((Context) currentActivity, O000000o2, O000000o3, O000000o4);
                        return;
                    }
                }
            }
            fyc.O00000o0("MIOTHostModule", "openNFCWriteDeviceInfoPage: only specific model supported");
            gbz.O000000o("no permission");
            return;
        }
        fyc.O00000o0("MIOTHostModule", "openNFCWriteDeviceInfoPage: only debug version supported");
        gbz.O000000o("only debug version supported");
    }

    @ReactMethod
    public void openSystemFileWindow(String str) {
        if (TextUtils.isEmpty(str)) {
            gbu.O00000Oo("openSystemFileWindow pathOrUrl is empty...");
            return;
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            gbu.O00000Oo("openSystemFileWindow  activity is null...");
            return;
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        Uri uri = null;
        if (TextUtils.isEmpty(scheme) || (!scheme.startsWith("http") && !scheme.startsWith("https") && !scheme.startsWith("content"))) {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    gbu.O00000Oo("openSystemFileWindow: pathOrUrl not exist,path=".concat(String.valueOf(str)));
                    return;
                } else if (MediaStoreUtil.O000000o(str)) {
                    uri = Uri.parse(str);
                } else if (gbt.O00000Oo(getFilesPath().getAbsolutePath(), str)) {
                    String packageName = currentActivity.getApplicationContext().getPackageName();
                    uri = FileProvider.getUriForFile(currentActivity, packageName + ".fileprovider", file);
                }
            } catch (IllegalArgumentException e) {
                gbu.O00000Oo("openSystemFileWindow error:" + Log.getStackTraceString(e));
            }
        } else {
            uri = Uri.parse(str);
        }
        if (uri == null) {
            gbu.O00000Oo("openSystemFileWindow error: fileUri = null,sdk_int:" + Build.VERSION.SDK_INT);
            return;
        }
        if (!TextUtils.isEmpty(scheme) && scheme.startsWith("content")) {
            str = gsc.O000000o(currentActivity, parse);
        }
        String O000000o2 = gtb.O000000o(gtb.O00000o0(str).toLowerCase());
        if (TextUtils.isEmpty(O000000o2)) {
            O000000o2 = "*/*";
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(uri, O000000o2);
        intent.addFlags(2);
        intent.addFlags(1);
        gbu.O000000o("pathOrUrl=" + uri + "  type=" + O000000o2);
        currentActivity.startActivity(intent);
    }

    @ReactMethod
    public void openCommonDeviceSettingPage(int i) {
        DeviceStat device = getDevice();
        if (device == null) {
            fyc.O00000o0("MIOTHostModule", "openCommonDeviceSettingPage: deviceStat is null");
            return;
        }
        if (!TextUtils.isEmpty(device.model)) {
            boolean z = device.model.contains("camera") && !device.model.contains("mxiang.");
            if (i == 0) {
                hxi.O00000o.O0000oO(z ? 1 : 2);
            } else if (i == 1) {
                hxi.O00000o.O0000o0o();
            }
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            fyc.O00000o0("MIOTHostModule", "openCommonDeviceSettingPage: activity is null");
        } else if (i == 0) {
            fbt fbt = new fbt(currentActivity, "FreqDeviceSetActivity");
            fbt.O000000o("did", device.did);
            fbt.O000000o("pagetype", 1);
            fbs.O000000o(fbt);
        } else if (i != 1) {
            fyc.O00000o0("MIOTHostModule", "openCommonDeviceSettingPage unknown type:".concat(String.valueOf(i)));
        } else {
            fbt fbt2 = new fbt(currentActivity, "FreqDeviceSetActivity");
            fbt2.O000000o("did", device.did);
            fbt2.O000000o("pagetype", 2);
            fbs.O000000o(fbt2);
        }
    }

    @ReactMethod
    public void clearFreqCameraNeedShowRedPoint() {
        ((gdt) gdv.f17570O000000o.getServiceInterface()).O00000oO();
    }

    @ReactMethod
    public void getFreqCameraNeedShowRedPoint(Callback callback) {
        boolean O00000oo = ((gdt) gdv.f17570O000000o.getServiceInterface()).O00000oo();
        fyc.O000000o("MIOTHostModule", "freqCameraNeedShowRedPoint,showRedDot:".concat(String.valueOf(O00000oo)));
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, Boolean.valueOf(O00000oo)));
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
    public void openGenerateCrontabStringPage(ReadableMap readableMap, final Callback callback) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            String O000000o2 = gbv.O000000o(readableMap, "crontab");
            String O000000o3 = gbv.O000000o(readableMap, "title");
            boolean O00000o0 = gbv.O00000o0(readableMap, "hideLegalTime");
            ft.O000000o(currentActivity).O000000o(new BroadcastReceiver() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTHostModule.AnonymousClass50 */

                public final void onReceive(Context context, Intent intent) {
                    String stringExtra;
                    ft.O000000o(currentActivity).O000000o(this);
                    if (intent != null && (stringExtra = intent.getStringExtra("crontab")) != null) {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("crontab", stringExtra);
                        callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap));
                    }
                }
            }, new IntentFilter("miot-rn-framework.ui.generate_crontab_string"));
            Intent intent = new Intent(currentActivity, ((gdu) gdv.f17570O000000o.getUiInterface()).O0000oOO());
            intent.putExtra("from_plugin", true);
            intent.putExtra("crontab", O000000o2);
            intent.putExtra("title", O000000o3);
            intent.putExtra("hideLegalTime", O00000o0);
            currentActivity.startActivityForResult(intent, 404);
        }
    }

    @ReactMethod
    public void openFirmWareAutoOTAPage() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            fbs.O000000o(new fbt(currentActivity, "ShowFirmwareUpdateActivity"));
        }
    }

    public void onCatalystInstanceDestroy() {
        this.mJumpToThirdpartyAppCallback = null;
    }

    public static boolean isPad() {
        return hyy.O000000o();
    }
}
