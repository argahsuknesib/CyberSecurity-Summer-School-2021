package _m_j;

import _m_j.hsi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactInstanceManagerBuilder;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.CatalystInstanceImpl;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JSBundleLoaderDelegate;
import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.JavascriptException;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.devsupport.DevLoadingViewController;
import com.facebook.react.devsupport.JSException;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.util.padcompat.PadCompatUtil;
import com.horcrux.svg.SvgPackage;
import com.reactnativecommunity.asyncstorage.AsyncStoragePackage;
import com.reactnativecommunity.geolocation.GeolocationPackage;
import com.reactnativecommunity.netinfo.NetInfoPackage;
import com.reactnativecommunity.viewpager.RNCViewPagerPackage;
import com.reactnativecommunity.webview.RNCWebViewPackage;
import com.xiaomi.plugin.core.XmPluginPackage;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.IBridgeCallback;
import com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager;
import com.xiaomi.smarthome.frame.plugin.debug.PluginErrorInfoActivity;
import com.xiaomi.smarthome.frame.plugin.host.PluginHostApi;
import com.xiaomi.smarthome.frame.plugin.rn.debugmock.MockRnDevicePluginManager;
import com.xiaomi.smarthome.frame.plugin.runtime.bridge.BridgeError;
import com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTPackageModule;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.jsi.MIOTTurboModuleManager;
import com.xiaomi.smarthome.framework.plugin.rn.report.RnNetReport;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.darkmode.AppearanceModule;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

public final class fwy {
    public static int O00000Oo = 0;
    public static final Thread.UncaughtExceptionHandler O00000o0 = Thread.getDefaultUncaughtExceptionHandler();
    private static int O000O0oo = 101;
    private static int O000OO = 0;
    private static int O000OO00 = 0;
    private static int O000OO0o = 102;
    private static final Object O000OOOo = new Object();

    /* renamed from: O000000o  reason: collision with root package name */
    public int f17340O000000o = 0;
    public ReactRootView O00000o;
    public fwt O00000oO;
    public String O00000oo;
    public ReactInstanceManager O0000O0o;
    public Activity O0000OOo;
    public String O0000Oo;
    public hsi.O000000o O0000Oo0;
    public PluginPackageInfo O0000OoO;
    public PluginDeviceInfo O0000Ooo;
    public long O0000o = -1;
    public Bundle O0000o0;
    public DeviceStat O0000o00;
    public boolean O0000o0O = false;
    public ArrayList<O000000o> O0000o0o;
    public String O0000oO = null;
    public long O0000oO0 = -1;
    public volatile byte O0000oOO = 0;
    public IBridgeCallback O0000oOo;
    public boolean O0000oo = true;
    public volatile boolean O0000oo0 = false;
    public volatile String O0000ooO = "";
    public volatile boolean O0000ooo = false;
    public int O000O00o = 1;
    public StringBuilder O000O0OO = new StringBuilder();
    public boolean O000O0Oo;
    public O00000Oo O000O0o = new O00000Oo(this, (byte) 0);
    public DefaultHardwareBackBtnHandler O000O0o0 = new DefaultHardwareBackBtnHandler() {
        /* class _m_j.fwy.AnonymousClass7 */

        public final void invokeDefaultOnBackPressed() {
            gbu.O000000o("rn runtime... invoke on backpressed");
            if (fwy.this.O0000OOo != null) {
                fwy.this.O0000OOo.finish();
            }
        }
    };
    private StringBuilder O000O0oO = new StringBuilder();
    private boolean O000OOo = false;
    private boolean O000OOo0 = false;
    private boolean O000OOoO = false;
    private HashMap<String, String> O000OOoo = new HashMap<>();
    private volatile int O000Oo0 = 0;
    private Map<String, Integer> O000Oo00 = new HashMap();
    private volatile boolean O000Oo0O = false;
    private CountDownLatch O000Oo0o = new CountDownLatch(1);
    private boolean O000OoO0 = false;
    public final BroadcastReceiver O00oOoOo = new BroadcastReceiver() {
        /* class _m_j.fwy.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            ReactContext currentReactContext;
            String action = intent.getAction();
            if (action != null) {
                char c = 65535;
                switch (action.hashCode()) {
                    case -1513001754:
                        if (action.equals("rn_plugin_darkmode_switch_changed")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -171909593:
                        if (action.equals("mijia://plugin")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 158859398:
                        if (action.equals("android.intent.action.CONFIGURATION_CHANGED")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1415192249:
                        if (action.equals("downrnsdk_action")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    long longExtra = intent.getLongExtra("sdk_api_level", -1);
                    if (longExtra < fwy.this.O0000o || fwy.this.O0000OOo != null) {
                        gbu.O00000oo("receiver broadcast rn sdk can not re init, apiLevel is " + longExtra + " and mLoadedSdkApiLevel is " + fwy.this.O0000o);
                        return;
                    }
                    gbu.O00000oo("receiver broadcast rn sdk will re init, apiLevel is " + longExtra + " and mLoadedSdkApiLevel is " + fwy.this.O0000o);
                    fwy.this.O000000o(2);
                } else if (c == 1) {
                    String colorSchemeForCurrentConfiguration = AppearanceModule.colorSchemeForCurrentConfiguration(CommonApplication.getAppContext());
                    if (fwy.this.O0000ooO.equals(colorSchemeForCurrentConfiguration)) {
                        gbu.O00000oo("system appearance changed, color scheme still: ".concat(String.valueOf(colorSchemeForCurrentConfiguration)));
                        return;
                    }
                    fwy.this.O0000ooO = colorSchemeForCurrentConfiguration;
                    gbu.O00000oo("system appearance changed, color scheme changed to: ".concat(String.valueOf(colorSchemeForCurrentConfiguration)));
                    gbu.O00000oo("receiver broadcast rn sdk will re init, system color scheme changed");
                    fwy.this.O000000o(3);
                } else if (c == 2) {
                    gbu.O00000oo("receiver broadcast rn sdk will re init, rn plugin dark mode switch changed");
                    fwy.this.O000000o(4);
                } else if (c == 3) {
                    WritableMap createMap = Arguments.createMap();
                    String stringExtra = intent.getStringExtra("url");
                    Uri parse = Uri.parse(stringExtra);
                    Set<String> queryParameterNames = parse.getQueryParameterNames();
                    if (queryParameterNames != null) {
                        for (String next : queryParameterNames) {
                            createMap.putString(next, parse.getQueryParameter(next));
                        }
                    }
                    createMap.putString("schema_url", stringExtra);
                    createMap.putString("eventName", "packageReceivedOutAppInformation_36621");
                    if (fwy.this.O0000O0o == null || (currentReactContext = fwy.this.O0000O0o.getCurrentReactContext()) == null) {
                        gbu.O00000oo("RNRuntime-->receive url:".concat(String.valueOf(stringExtra)));
                    } else {
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("packageReceivedOutAppInformation_36621", createMap);
                    }
                }
            }
        }
    };
    public boolean O00oOooO;
    public int O00oOooo = 0;

    public interface O000000o {
        void onAttachPlugin(ReactRootView reactRootView, ReactInstanceManager reactInstanceManager, DeviceStat deviceStat, PluginPackageInfo pluginPackageInfo);
    }

    public fwy() {
        if (CommonApplication.getApplication() != null) {
            this.O0000ooO = AppearanceModule.colorSchemeForCurrentConfiguration(CommonApplication.getAppContext());
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("downrnsdk_action");
            intentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
            intentFilter.addAction("rn_plugin_darkmode_switch_changed");
            intentFilter.addAction("mijia://plugin");
            CommonApplication.getAppContext().registerReceiver(this.O00oOoOo, intentFilter);
            if (CommonApplication.getApplication() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("SmartHome AppInfo versionName = ");
                sb.append(gfr.O00000oo);
                sb.append(",");
                sb.append("versionCode = ");
                sb.append(gfr.O00000oO);
                sb.append(",");
                sb.append("SDK level = 10058,");
                sb.append("channel = ");
                sb.append(gfr.O0000o0O);
                sb.append(",");
                grr.O000000o();
                sb.append(grr.O0000OoO().replace("-", ""));
                sb.append(" ");
                grr.O000000o();
                sb.append(grr.O0000Oo().replace("-", ""));
                sb.append(" ");
                grr.O000000o();
                sb.append(grr.O0000O0o().replace("-", ""));
                sb.append(" ");
                grr.O000000o();
                sb.append(grr.O0000Oo0().replace("-", ""));
                fyc.O00000Oo("RNRuntimeTAG", sb.toString());
            }
        }
    }

    public final void O000000o(JSBundleLoaderDelegate jSBundleLoaderDelegate, hsi.O000000o o000000o, boolean z) {
        hsi.O000000o o000000o2;
        gbu.O00000oo("RNRuntime loadScriptCache(),ifLoadPluginBundle=".concat(String.valueOf(z)));
        O00000Oo(",load_script_cache_if_plugin_".concat(String.valueOf(z)));
        if (jSBundleLoaderDelegate == null || (o000000o2 = this.O0000Oo0) == null || o000000o2 != o000000o) {
            hsi.O000000o o000000o3 = this.O0000Oo0;
            if (o000000o3 == null) {
                O00000Oo(",load_script_cache_sdk_info_null");
            } else if (o000000o3 != o000000o) {
                gbu.O00000oo("RNRuntime loadScriptCache(),mSdkInfo=" + this.O0000Oo0 + ",usedSdkInfo=" + o000000o);
                O00000Oo(",load_script_cache_sdk_info_not_match");
            } else {
                O00000Oo(",load_script_cache_instance_null");
            }
        } else {
            if (this.O000Oo0O) {
                try {
                    this.O000Oo0o.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                String str = "";
                if (this.O0000o < 0) {
                    this.O0000o = this.O0000Oo0.f598O000000o;
                    this.O0000oO0 = this.O0000Oo0.O00000Oo;
                    O00000Oo(",load_sdk_" + this.O0000o);
                    hsi.O000000o("runtime load sdk script");
                    gbu.O00000oo("2、 start load rn sdk bundle, PluginStartTime  loadScript  is_inner_sdk: " + this.O0000Oo0.O00000oO + "  path: " + this.O0000Oo0.O00000o0);
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        if (this.O0000Oo0.O00000oO) {
                            JSBundleLoader.createAssetLoader(CommonApplication.getAppContext(), this.O0000Oo0.O00000o0, false).loadScript(jSBundleLoaderDelegate);
                        } else {
                            JSBundleLoader.createFileLoader(this.O0000Oo0.O00000o0, this.O0000Oo0.O00000o, false).loadScript(jSBundleLoaderDelegate);
                        }
                        gav.O000000o("load_sdk", str, 0, System.currentTimeMillis() - currentTimeMillis);
                    } catch (Throwable th) {
                        gbu.O00000oo("load sdk error,message" + Log.getStackTraceString(th));
                        this.f17340O000000o = this.f17340O000000o | 2;
                        O00000Oo(",load_sdk_error_" + this.O0000o);
                        gav.O000000o("load_sdk", str, -1001, System.currentTimeMillis() - currentTimeMillis);
                    }
                }
                if (!z) {
                    gbu.O00000oo("load sdk over,no need to load plugin");
                } else if (this.O0000oO != null || TextUtils.isEmpty(this.O0000Oo)) {
                    gbu.O00000oo("RNRuntime loadScriptCache(),mLoadedPluginPath:" + this.O0000oO);
                    gbu.O00000oo("RNRuntime loadScriptCache(),mPluginBundlePath:" + this.O0000Oo);
                    O00000Oo(",load_plugin_loaded_or_no_path");
                } else {
                    hsi.O000000o("runtime load plugin");
                    File file = new File(this.O0000Oo, "main.bundle");
                    if (file.exists()) {
                        this.O0000oO = this.O0000Oo;
                        hsi.O000000o("runtime load plugin", Long.valueOf(this.O0000o), this.O0000Oo0.O00000o0, this.O0000oO);
                        gsy.O00000Oo("PluginStartTime", "loadScript  " + System.currentTimeMillis() + "  " + file);
                        StringBuilder sb = new StringBuilder("3、 start load plugin bundle, path:");
                        sb.append(this.O0000oO);
                        gbu.O00000oo(sb.toString());
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (this.O0000Ooo != null) {
                            str = this.O0000Ooo.O00000Oo();
                        }
                        try {
                            O00000Oo(",load_plugin_" + this.O00000oo);
                            JSBundleLoader.createFileLoader(file.getAbsolutePath(), this.O0000oO, false).loadScript(jSBundleLoaderDelegate);
                            gav.O000000o("load_plugin", str, 0, System.currentTimeMillis() - currentTimeMillis2);
                        } catch (Throwable th2) {
                            O00000Oo(",load_plugin_error_" + this.O00000oo);
                            this.f17340O000000o = this.f17340O000000o | 131072;
                            gbu.O00000oo("load plugin error,message:" + Log.getStackTraceString(th2));
                            gav.O000000o("load_plugin", str, -1001, System.currentTimeMillis() - currentTimeMillis2);
                        }
                    } else {
                        gbu.O00000oo("RNRuntime loadScriptCache(),bundleFile not exist,path:" + this.O0000Oo);
                        this.f17340O000000o = this.f17340O000000o | 65536;
                        O00000Oo(",load_plugin_bundle_not_exist");
                    }
                }
            } catch (Exception e2) {
                gbu.O00000oo("loadScript: " + Log.getStackTraceString(e2));
                O00000Oo(",load_script_cache_error");
                gsy.O000000o(6, "fatal", Log.getStackTraceString(e2));
            }
        }
    }

    public final synchronized void O000000o(XmPluginPackage xmPluginPackage, Throwable th, boolean z) {
        String str;
        String str2;
        long j;
        long j2;
        int i;
        Throwable th2 = th;
        synchronized (this) {
            Context context = null;
            if (this.O0000O0o != null) {
                context = this.O0000O0o.getCurrentReactContext();
            }
            if (context == null) {
                context = CommonApplication.getAppContext();
            }
            String O00000o02 = ftm.O00000o0(context);
            if (!TextUtils.isEmpty(O00000o02) && O00000o02.startsWith("com.xiaomi.smarthome:")) {
                O00000o02 = O00000o02.replace("com.xiaomi.smarthome:", "");
            }
            String str3 = "";
            long[] jArr = new long[2];
            if (th2 != null) {
                if (z) {
                    j2 = (long) O000OO0o;
                    i = O000OO;
                } else {
                    if (!(th2 instanceof JavascriptException) && !(th2 instanceof JSApplicationCausedNativeException) && !(th2 instanceof JSException)) {
                        if (!(th2 instanceof IllegalArgumentException)) {
                            j2 = (long) O000O0oo;
                            i = O000OO00;
                        }
                    }
                    String stackTraceString = Log.getStackTraceString(th);
                    if (TextUtils.isEmpty(stackTraceString) || (!stackTraceString.contains("Error calling AppRegistry.runApplication") && !stackTraceString.contains("has not been registered"))) {
                        if (xmPluginPackage != null) {
                            j2 = xmPluginPackage.getPluginId();
                            j = xmPluginPackage.getPackageId();
                        } else if (this.O0000OoO != null) {
                            j2 = this.O0000OoO.O000000o();
                            j = this.O0000OoO.O00000Oo();
                        } else {
                            j = 0;
                            j2 = 0;
                        }
                        jArr[0] = j2;
                        jArr[1] = j;
                    } else {
                        j2 = (long) O000O0oo;
                        i = O000OO00;
                    }
                }
                j = (long) i;
                jArr[0] = j2;
                jArr[1] = j;
            }
            long j3 = jArr[0];
            long j4 = jArr[1];
            String str4 = "";
            if (j3 == ((long) O000O0oo) && j4 == ((long) O000OO00)) {
                str4 = fky.O000000o(this.O0000OoO, this.O0000Ooo != null ? this.O0000Ooo.O00000Oo() : "", this.O0000Oo);
            }
            String str5 = "===plugin crash===\npluginType=ReactNative\npluginId=" + j3 + "\npkgId=" + j4 + "\npackageInfo=" + str4 + "\npluginVersion=" + (this.O0000OoO != null ? this.O0000OoO.O00000oO() : -1);
            String str6 = "";
            String str7 = "";
            if (this.O0000Oo0 != null) {
                str5 = str5 + "rnSdkApiLevel=" + this.O0000Oo0.f598O000000o + "\nrnSdkBuildTime=" + this.O0000Oo0.O00000Oo + "\nrnSdkIsInner=" + this.O0000Oo0.O00000oO + "\nrnSdkInnerApiLevel=10058\nAppVersion=" + gfr.O00000oo + "\n";
                str7 = this.O0000Oo0.O00000oo;
            }
            String str8 = str7;
            if (this.O0000o00 != null) {
                str5 = (str5 + "model=" + this.O0000o00.model + "\n") + "did=" + this.O0000o00.did + "\n";
                str3 = this.O0000o00.did;
                str6 = this.O0000o00.model;
            }
            String str9 = str3;
            String str10 = str6;
            try {
                this.O000Oo0++;
                str = ((((((((((str5 + "userId=" + CoreApi.O000000o().O0000o0() + "\n") + "debug=" + gfr.f17662O000000o + "\n") + "isGrayPublish=" + gfr.O0000Ooo + "\n") + "reportTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\n") + "reportIndex=" + this.O000Oo0 + "\n") + "currentPluginProcessName=" + fyf.O000000o(context) + "\n") + "launchErrorCode=" + this.f17340O000000o + "\n") + "runtimeReused=" + this.O00oOooO + "\n") + "cacheHitType=" + this.O00oOooo + "\n") + "packageNameOperation=" + this.O000O0OO.toString() + "\n") + "reInitSRc=" + this.O000O0oO.toString() + "\n";
            } catch (Exception unused) {
                str = str5;
            }
            if (th2 == null) {
                str2 = "";
            } else {
                StringWriter stringWriter = new StringWriter();
                th2.printStackTrace(new PrintWriter(stringWriter));
                str2 = stringWriter.toString();
            }
            String O000000o2 = grv.O000000o(str2);
            if (!this.O000Oo00.containsKey(O000000o2)) {
                this.O000Oo00.put(O000000o2, 1);
                if (this.O000Oo0 > 1) {
                    gbu.O00000Oo("crashIndex:" + this.O000Oo0 + ",crashIndex >1,needn't report(only report the 1st crash)");
                    return;
                }
                String str11 = str + str2;
                if (str11.length() > 5000) {
                    str11 = str11.substring(0, 5000);
                }
                String str12 = str11;
                String str13 = "";
                if (xmPluginPackage != null) {
                    str13 = xmPluginPackage.getPackageName();
                } else if (this.O0000OoO != null) {
                    str13 = this.O0000OoO.O00000oo();
                }
                String str14 = str10;
                long j5 = j4;
                long j6 = j3;
                int i2 = 1;
                ftc.O000000o().O000000o(CommonApplication.getAppContext(), "@ExceptionFromReactNative", "@ExceptionFromReactNative", str12, O00000o02, fsr.O0000Oo, str9, j3, j5, str14, str13, str8);
                HashMap hashMap = new HashMap();
                if (!z) {
                    i2 = 0;
                }
                hashMap.put("outside_rn", Integer.valueOf(i2));
                hashMap.put("call_stack", str2);
                hashMap.put("process_name", O00000o02);
                fwz O000000o3 = fwz.O000000o();
                boolean O000000o4 = gbt.O000000o();
                if (O000000o3.O00000Oo != null) {
                    hashMap.put("reuse_switch_status", Integer.valueOf(O000000o3.O00000Oo.O00000oO));
                    hashMap.put("reuse_status", Integer.valueOf(O000000o3.O00000Oo.O0000O0o));
                    hashMap.put("model_support", Integer.valueOf(O000000o3.O00000Oo.O00000oo));
                }
                if (O000000o4) {
                    hashMap.put("cur_cache_size", Integer.valueOf(fxa.O000000o().O00000Oo.size()));
                    hashMap.put("max_cache_size", Integer.valueOf(fxa.O000000o().f17359O000000o));
                } else {
                    hashMap.put("cur_cache_size", 0);
                    hashMap.put("max_cache_size", Integer.valueOf(gbt.O00000o0()));
                }
                hashMap.put("package_id", String.valueOf(j5));
                hashMap.put("plugin_id", String.valueOf(j6));
                hashMap.put("device_id", String.valueOf(str9));
                hashMap.put("device_model", str14);
                hashMap.put("sdk_level", 10058);
                PluginHostApi.instance().statReport("rn_plugin_framework", "rn_runtime_reuse_crash", hashMap);
            }
        }
    }

    public final class O00000Oo {
        /* synthetic */ O00000Oo(fwy fwy, byte b) {
            this();
        }

        private O00000Oo() {
        }

        public final File O000000o() {
            return MIOTPackageModule.getPluginFilesPath(MIOTPackageModule.getPluginDir(fwy.this.O0000O0o.getCurrentReactContext(), fwy.this.O0000OoO), fwy.this.O0000o00);
        }
    }

    private synchronized void O00000Oo(int i) {
        this.O000O0oO.append(i);
    }

    public final void O000000o(final boolean z) {
        gbu.O00000oo("RNRuntime init(),ins=".concat(String.valueOf(this)));
        if (this.O0000O0o == null) {
            this.O000OoO0 = gbt.O00000oo();
            hsi.O000000o("runtime init");
            ((gdt) gdv.f17570O000000o.getServiceInterface()).O000000o();
            PadCompatUtil.getInstance().setPadUtils(new gbs());
            this.O000O00o = hyy.O000000o() ? 2 : 1;
            gsy.O000000o(6, "foldDevice", "init dimensionType = " + this.O000O00o);
            this.O0000oOO = 1;
            final AnonymousClass11 r0 = new Thread.UncaughtExceptionHandler() {
                /* class _m_j.fwy.AnonymousClass11 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.fwy.O000000o(com.xiaomi.plugin.core.XmPluginPackage, java.lang.Throwable, boolean):void
                 arg types: [com.xiaomi.plugin.core.XmPluginPackage, java.lang.Throwable, int]
                 candidates:
                  _m_j.fwy.O000000o(com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo, java.io.File, java.io.File):void
                  _m_j.fwy.O000000o(com.facebook.react.bridge.JSBundleLoaderDelegate, _m_j.hsi$O000000o, boolean):void
                  _m_j.fwy.O000000o(com.facebook.react.bridge.ReactContext, _m_j.hsi$O000000o, boolean):void
                  _m_j.fwy.O000000o(com.xiaomi.plugin.core.XmPluginPackage, java.lang.Throwable, boolean):void */
                public final void uncaughtException(Thread thread, Throwable th) {
                    fyc.O00000Oo("RNRuntimeTAG", "uncaughtException:", th);
                    XmPluginHostApi.instance().onRNRuntimeReuseDisable(2);
                    if (fwy.this.O0000OOo == null && fwy.this.O0000OoO == null && fwy.this.O0000o00 == null) {
                        fyc.O00000o0("RNRuntimeTAG", "not rn plugin,let sDefaultExceptionHandler handle it");
                        fwy.O00000o0.uncaughtException(thread, th);
                    } else if (fwy.O00000Oo > 1) {
                        fyc.O00000o0("RNRuntimeTAG", "uncaughtException: sSdkNativeOutSideRnCrashCount=" + fwy.O00000Oo);
                    } else {
                        fwy.O00000Oo++;
                        try {
                            XmPluginPackage xmPluginPackage = PluginRuntimeManager.getInstance().getXmPluginPackage(fwy.this.O0000OoO);
                            if (fwy.this.O0000o0O || gfr.O0000OOo || gfr.O0000Oo) {
                                PluginErrorInfoActivity.showErrorInfo(CommonApplication.getAppContext(), xmPluginPackage, th);
                            }
                            gbu.O00000oo("uncaughtException,runtimeReused=" + fwy.this.O00oOooO);
                            gbu.O00000oo("uncaughtException,packageNameOperation=" + fwy.this.O000O0OO.toString());
                            fwy.this.O000000o(xmPluginPackage, th, true);
                        } catch (Throwable th2) {
                            fyc.O000000o("RNRuntimeTAG", "uncaughtException,handle exception error:", th2);
                        }
                    }
                }
            };
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                /* class _m_j.fwy.AnonymousClass12 */

                public final void uncaughtException(Thread thread, Throwable th) {
                    fwy fwy = fwy.this;
                    fwy.O0000oOO = -1;
                    fwy.O0000O0o = null;
                    fwy.O0000o = -1;
                    fwy.O0000oO0 = -1;
                    fwy.O0000o00 = null;
                    fwy.O0000OoO = null;
                    fwy.O00000Oo(",exception_plugin_record_null");
                    fwy fwy2 = fwy.this;
                    fwy2.O0000Ooo = null;
                    fwy2.O0000oO = null;
                    gbu.O00000oo("ReactInstanceManager init error: " + Log.getStackTraceString(th));
                    CommonApplication.getAppContext().unregisterReceiver(fwy.this.O00oOoOo);
                    Thread.setDefaultUncaughtExceptionHandler(fwy.O00000o0);
                    CommonApplication.getAppContext().unregisterReceiver(fwz.O000000o().O00000o);
                }
            });
            this.O0000oo = true;
            this.O0000o = -1;
            this.O0000oO0 = -1;
            this.O0000o00 = null;
            this.O0000OoO = null;
            O00000Oo(",init_plugin_record_null");
            this.O0000Ooo = null;
            this.O0000oO = null;
            fkl.O000000o();
            hsi.O000000o O000000o2 = fkl.O000000o(CommonApplication.getAppContext());
            this.O0000Oo0 = O000000o2;
            this.O0000Oo = null;
            fxs.O000000o().O00000Oo();
            fvo.O000000o();
            this.O0000o0O = fvo.O00000oO();
            gbu.O000000o(this.O0000o0O);
            gbu.O00000oO(PluginBridgeService.process != null ? PluginBridgeService.process.getValue() : "rn_process");
            boolean O000000o3 = O000000o();
            if (this.O0000Oo0 != null || O000000o3) {
                if (this.O0000Oo0 != null) {
                    gbu.O00000oo("init> isRnCanDebug:" + O000000o3 + " rnSdkInfo: " + O000000o2.f598O000000o + "  install_path: " + O000000o2.O00000o0 + "  mIsRnDevSettingOpen:" + this.O0000o0O);
                } else {
                    gbu.O00000oo("init> rnSdkInfo is null...");
                }
                if (this.O0000o0O) {
                    fvo.O000000o();
                    if (fvo.O0000OOo() && hsi.O000000o(CommonApplication.getAppContext()) != null) {
                        this.O0000Oo0 = hsi.O000000o(CommonApplication.getAppContext());
                    }
                }
                ReactInstanceManagerBuilder builder = ReactInstanceManager.builder();
                this.O00000oO = new fwt(O000000o3);
                builder.setApplication(CommonApplication.getApplication()).addPackage(new fxn()).addPackage(new ui()).addPackage(new SvgPackage()).addPackage(new gaj()).addPackage(new csr()).addPackage(new cua()).addPackage(new bcv()).addPackage(new fwu()).addPackage(new nv()).addPackage(new gas()).addPackage(new jls()).addPackage(new gcq()).addPackage(new gca()).addPackage(new gct()).addPackage(new gcc()).addPackage(new gcp()).addPackage(new gcy()).addPackage(new gdh()).addPackage(this.O00000oO).addPackage(new RNCWebViewPackage()).addPackage(new AsyncStoragePackage()).addPackage(new NetInfoPackage()).addPackage(new RNCViewPagerPackage()).addPackage(new gdk()).addPackage(new GeolocationPackage()).addPackage(new gco()).addPackage(new fxp()).addPackage(new fzf()).addPackage(new gao()).addPackage(new fzi()).addPackage(new fzk()).addPackage(new fzm()).addPackage(new fzn()).addPackage(new fzl()).addPackage(new gah()).addPackage(new fzj()).setInitialLifecycleState(LifecycleState.BEFORE_CREATE).setDefaultHardwareBackBtnHandler(this.O000O0o0).setNativeModuleCallExceptionHandler(new NativeModuleCallExceptionHandler() {
                    /* class _m_j.fwy.AnonymousClass13 */

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.fwy.O000000o(com.xiaomi.plugin.core.XmPluginPackage, java.lang.Throwable, boolean):void
                     arg types: [com.xiaomi.plugin.core.XmPluginPackage, java.lang.Exception, int]
                     candidates:
                      _m_j.fwy.O000000o(com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo, java.io.File, java.io.File):void
                      _m_j.fwy.O000000o(com.facebook.react.bridge.JSBundleLoaderDelegate, _m_j.hsi$O000000o, boolean):void
                      _m_j.fwy.O000000o(com.facebook.react.bridge.ReactContext, _m_j.hsi$O000000o, boolean):void
                      _m_j.fwy.O000000o(com.xiaomi.plugin.core.XmPluginPackage, java.lang.Throwable, boolean):void */
                    public final void handleException(Exception exc) {
                        Log.e("ReactNativeJS", "NativeModuleCallExceptionHandler,  process name is " + fyf.O000000o(CommonApplication.getApplication()) + ",launchErrorCode:" + fwy.this.f17340O000000o, exc);
                        gbu.O00000oo("NativeModuleCallExceptionHandler,  process name is " + fyf.O000000o(CommonApplication.getApplication()) + ",launchErrorCode:" + fwy.this.f17340O000000o + ", error: " + Log.getStackTraceString(exc));
                        StringBuilder sb = new StringBuilder("NativeModuleCallExceptionHandler,runtimeReused=");
                        sb.append(fwy.this.O00oOooO);
                        gbu.O00000oo(sb.toString());
                        StringBuilder sb2 = new StringBuilder("NativeModuleCallExceptionHandler,packageNameOperation=");
                        sb2.append(fwy.this.O000O0OO.toString());
                        gbu.O00000oo(sb2.toString());
                        XmPluginHostApi.instance().onRNRuntimeReuseDisable(2);
                        if (fwy.this.O0000OoO != null) {
                            XmPluginPackage xmPluginPackage = PluginRuntimeManager.getInstance().getXmPluginPackage(fwy.this.O0000OoO);
                            if (fwy.this.O0000o0O || gfr.O0000OOo || gfr.O0000Oo) {
                                PluginErrorInfoActivity.showErrorInfo(CommonApplication.getAppContext(), xmPluginPackage, exc);
                            } else {
                                if (fwy.this.O0000o <= 0) {
                                    fwy.this.f17340O000000o |= 1;
                                }
                                fwy.this.O000000o(xmPluginPackage, (Throwable) exc, false);
                            }
                        }
                        fwy fwy = fwy.this;
                        if (fwy.O0000oOo != null) {
                            StringBuffer stringBuffer = new StringBuffer();
                            if (fwy.O0000o00 != null) {
                                stringBuffer.append(fwy.O0000o00.did);
                                stringBuffer.append("-");
                                stringBuffer.append(fwy.O0000o00.model);
                                stringBuffer.append("-");
                            }
                            if (fwy.O0000OoO != null) {
                                stringBuffer.append(fwy.O0000OoO.O00000Oo());
                                stringBuffer.append("-");
                                stringBuffer.append(fwy.O0000OoO.O000000o());
                            }
                            try {
                                fwy.O0000oOo.onMessageFailure(new BridgeError(-1001, stringBuffer.toString()));
                            } catch (RemoteException unused) {
                            }
                        }
                        fwy.this.O0000oo = true;
                    }
                }).setUseDeveloperSupport(O000000o3);
                if (O000000o3) {
                    builder.setJSMainModulePath("projects/" + this.O00000oo + "/index");
                    this.O0000O0o = builder.build();
                } else {
                    builder.setJSBundleLoader(new JSBundleLoader() {
                        /* class _m_j.fwy.AnonymousClass14 */

                        public final String loadScript(JSBundleLoaderDelegate jSBundleLoaderDelegate) {
                            gbu.O00000oo("1、 will loadScript rn sdk bundle...");
                            fwy.this.O00000Oo(",sdk_load_script_cache");
                            fwy fwy = fwy.this;
                            fwy.O000000o(jSBundleLoaderDelegate, fwy.O0000Oo0, z);
                            return "";
                        }
                    });
                    try {
                        this.O0000O0o = builder.build();
                        ReactRootView reactRootView = this.O00000o;
                        if (reactRootView != null) {
                            reactRootView.unmountReactApplication();
                            this.O00000o = null;
                        }
                        O00000Oo(",show_sdk");
                        O00000Oo().startReactApplication(this.O0000O0o, "sdk");
                        gsy.O00000Oo("PluginStartTime", "initRnRuntime  " + System.currentTimeMillis() + "  " + this.O0000Oo0.O00000o);
                    } catch (Exception e) {
                        gbu.O00000oo("failed to build ReactInstanceManager: " + Log.getStackTraceString(e));
                        return;
                    }
                }
                this.O0000O0o.addReactInstanceEventListener(new ReactInstanceManager.ReactInstanceEventListener() {
                    /* class _m_j.fwy.AnonymousClass2 */

                    public final void onReactContextInitialized(ReactContext reactContext) {
                        Thread.setDefaultUncaughtExceptionHandler(r0);
                        fwy.this.O0000oOO = 2;
                        ((NetworkingModule) reactContext.getNativeModule(NetworkingModule.class)).setNetRequestReporter(new RnNetReport());
                        MIOTTurboModuleManager.instance().installBinding(fwy.this.O0000O0o);
                        hsi.O000000o("runtime sdk ready");
                    }
                });
            }
        }
    }

    public final boolean O000000o() {
        if (!this.O0000o0O || !this.O000OOo0) {
            return this.O000OOo && this.O000OOoO;
        }
        return true;
    }

    public final void O000000o(DeviceStat deviceStat, PluginPackageInfo pluginPackageInfo, PluginDeviceInfo pluginDeviceInfo, Bundle bundle, boolean z) {
        gbu.O00000oo("RNRuntime initRNDevice(),ins=" + this + ",needShow" + z);
        DeviceStat deviceStat2 = this.O0000o00;
        if (!(deviceStat2 == null || this.O0000OoO == null || deviceStat == null || pluginPackageInfo == null || (deviceStat2.did.equals(this.O0000o00.did) && this.O0000OoO.O00000Oo() == pluginPackageInfo.O00000Oo()))) {
            this.O0000oo = true;
        }
        this.O0000o00 = deviceStat;
        this.O0000OoO = pluginPackageInfo;
        if (this.O0000OoO != null) {
            O00000Oo(",init_device_plugin_record_0_" + this.O0000OoO.O00000oo() + "_ns_" + z);
        } else {
            O00000Oo(",init_device_plugin_record_null_ns_".concat(String.valueOf(z)));
        }
        this.O0000Ooo = pluginDeviceInfo;
        this.O0000o0 = bundle;
        O000000o(this.O0000OoO);
        if (pluginPackageInfo != null && MockRnDevicePluginManager.getInstance().modelIsMockModel(deviceStat.model)) {
            pluginPackageInfo.O000000o((fkw.O000000o(CommonApplication.getAppContext()) + File.separator + "plugin" + File.separator + "install" + File.separator + "rn") + File.separator + pluginPackageInfo.O000000o() + File.separator + pluginPackageInfo.O00000Oo());
        }
        if (pluginDeviceInfo != null && deviceStat != null && TextUtils.isEmpty(deviceStat.deviceIconReal)) {
            deviceStat.deviceIconReal = pluginDeviceInfo.O0000o0();
        }
    }

    public final void O00000Oo(boolean z) {
        gbu.O00000oo("RNRuntime initRuntime(),ins=" + this + ",needShow=" + z);
        O00000Oo(this.O0000o00, this.O0000OoO, this.O0000Ooo, this.O0000o0, z);
    }

    private void O00000Oo(DeviceStat deviceStat, PluginPackageInfo pluginPackageInfo, PluginDeviceInfo pluginDeviceInfo, Bundle bundle, boolean z) {
        int i;
        String str;
        ReactInstanceManager reactInstanceManager;
        ReadableMap map;
        DeviceStat deviceStat2 = deviceStat;
        Bundle bundle2 = bundle;
        O00000Oo(",init_runtime_ns_".concat(String.valueOf(z)));
        if (bundle2 != null) {
            i = bundle2.getInt("package_msgType", 1);
        } else {
            i = 1;
        }
        int i2 = this.O00oOooo;
        if (this.O0000oo || this.O00000o == null || (reactInstanceManager = this.O0000O0o) == null || reactInstanceManager.getCurrentReactContext() == null || this.O0000O0o.getCurrentReactContext().getCurrentActivity() != null || TextUtils.isEmpty(this.O00000oo) || i == 3) {
            this.O00oOooO = false;
            gbu.O00000oo("RNRuntime initRuntime, 性能优化, 未复用 RN环境,model=" + deviceStat2.model + ",packageId=" + pluginPackageInfo.O00000Oo() + ",cacheHitType=" + i2);
            if (z) {
                O000000o(pluginPackageInfo.O00000Oo(), pluginPackageInfo.O000000o(), deviceStat2.model, 0, i2);
            }
            hsi.O000000o("runtime load plugin");
            this.O0000o0 = bundle2;
            String qrDebugModePackageName = XmPluginHostApi.instance().getQrDebugModePackageName();
            this.O000OOoO = CoreApi.O000000o().O0000OoO();
            if (!TextUtils.isEmpty(qrDebugModePackageName) && this.O000OOoO) {
                this.O000OOo = true;
                this.O00000oo = qrDebugModePackageName;
                this.O000OOo0 = true;
                DevLoadingViewController.setDevLoadingEnabled(false);
                O000000o(deviceStat, pluginPackageInfo, pluginDeviceInfo, i, z);
            } else if (this.O0000o0O) {
                DevLoadingViewController.setDevLoadingEnabled(false);
                fvo.O000000o();
                this.O00000oo = fvo.O0000o0();
                this.O000OOo0 = false;
                if ("t.t.t".equals(deviceStat2.model)) {
                    gbu.O000000o("RNRuntime  mock device, 仅供UI调试...");
                    this.O000OOo0 = true;
                    fvo.O000000o();
                    str = fvo.O0000o00();
                } else {
                    JSONObject O000000o2 = fvu.O000000o(deviceStat2.model);
                    if (O000000o2 != null) {
                        this.O000OOo0 = O000000o2.optBoolean(fvt.O00000o0);
                        str = O000000o2.optString(fvt.f17284O000000o);
                    } else {
                        this.O000OOo0 = false;
                        str = pluginPackageInfo.O00000oo();
                    }
                }
                gbu.O00000oo("RNRuntime  调试的插件包： " + str + "   model: " + deviceStat2.model);
                this.O00000oo = str;
                if (this.O000OOo0) {
                    O000000o(deviceStat, pluginPackageInfo, pluginDeviceInfo, i, z);
                } else {
                    O00000Oo(deviceStat, pluginPackageInfo, pluginDeviceInfo, i, z);
                    fvo.O000000o();
                    if (fvo.O00000oo()) {
                        if (this.O0000Oo0 != null) {
                            gbz.O00000Oo("model: " + deviceStat2.model + "\nnative apiLevel: 10058\nsdk Version: " + this.O0000Oo0.f598O000000o + "\nsdk createTime: " + (this.O0000Oo0.O00000Oo / 1000) + "\nplugin version: " + pluginPackageInfo.O00000oO() + "\nis_inner_sdk: " + this.O0000Oo0.O00000oO);
                        } else {
                            gbz.O000000o("加载 rn sdk error");
                        }
                    }
                }
                this.O00000oO.f17333O000000o = this.O000OOo0;
            } else {
                O00000Oo(deviceStat, pluginPackageInfo, pluginDeviceInfo, i, z);
            }
        } else {
            if (i2 == 1) {
                gbu.O00000oo("RNRuntime initRuntime, 性能优化, 复用 RN环境,model=" + deviceStat2.model + ",packageId=" + pluginPackageInfo.O00000Oo());
            } else if (i2 == 2) {
                gbu.O00000oo("RNRuntime initRuntime, 性能优化, 预加载 RN环境,model=" + deviceStat2.model + ",packageId=" + pluginPackageInfo.O00000Oo());
            } else {
                gbu.O00000oo("RNRuntime initRuntime, 性能优化, Cache RN环境 异常,model=" + deviceStat2.model + ",packageId=" + pluginPackageInfo.O00000Oo() + ",cacheHitType=" + i2);
            }
            ReadableMap O000000o3 = this.O00000oO.O000000o(this);
            if (O000000o3 == null || (map = O000000o3.getMap("package")) == null) {
                O00000Oo(",cache_constant_1_hit_type_".concat(String.valueOf(i2)));
            } else {
                String string = map.getString("packageName");
                O00000Oo(",cache_constant_0_" + string + "_hit_type_" + i2);
            }
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.O0000O0o.getCurrentReactContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onPluginConfigUpdate", O000000o3);
            this.O0000ooO = AppearanceModule.colorSchemeForCurrentConfiguration(this.O0000O0o.getCurrentReactContext());
            if (z) {
                O000000o(pluginPackageInfo.O00000Oo(), pluginPackageInfo.O000000o(), deviceStat2.model, 1, i2);
            }
            O00000Oo(",cache_show_" + this.O00000oo);
            this.O00000o = O00000Oo();
            this.O00000o.startReactApplication(this.O0000O0o, this.O00000oo);
            this.O000O0Oo = true;
            O000000o(deviceStat, pluginPackageInfo);
            if (z && gax.O000000o(i, deviceStat2.model)) {
                gav.O000000o(deviceStat2.model, pluginPackageInfo, "sdk_loaded");
            }
            this.O00oOooO = true;
        }
    }

    public final void O000000o(final DeviceStat deviceStat, final PluginPackageInfo pluginPackageInfo, int i, boolean z) {
        ReactRootView reactRootView = this.O00000o;
        if (reactRootView != null) {
            reactRootView.unmountReactApplication();
        }
        gbu.O00000oo("start react app > " + this.O00000oo + ",needShow=" + z);
        if (O000000o()) {
            O00000Oo(",debug_show_" + this.O00000oo + "_ns_" + z);
            this.O00000o = O00000Oo();
            if (z) {
                this.O00000o.startReactApplication(this.O0000O0o, this.O00000oo);
                this.O000O0Oo = true;
                if (this.O0000O0o.getCurrentReactContext() == null) {
                    this.O0000O0o.addReactInstanceEventListener(new ReactInstanceManager.ReactInstanceEventListener() {
                        /* class _m_j.fwy.AnonymousClass4 */

                        public final void onReactContextInitialized(ReactContext reactContext) {
                            fvo.O000000o();
                            if (fvo.O0000Ooo()) {
                                fwy.this.O0000oo = false;
                            }
                            fwy.this.O000000o(deviceStat, pluginPackageInfo);
                            hsi.O000000o("runtime plugin ready");
                        }
                    });
                    return;
                }
                fvo.O000000o();
                if (fvo.O0000Ooo()) {
                    this.O0000oo = false;
                }
                O000000o(deviceStat, pluginPackageInfo);
            }
        } else if (this.O0000O0o.getCurrentReactContext() == null) {
            gbu.O00000oo("release new reactview,context null need wait,needShow=".concat(String.valueOf(z)));
            O00000Oo(",load_show_context_wait_ns_".concat(String.valueOf(z)));
            final boolean z2 = z;
            final DeviceStat deviceStat2 = deviceStat;
            final PluginPackageInfo pluginPackageInfo2 = pluginPackageInfo;
            final int i2 = i;
            this.O0000O0o.addReactInstanceEventListener(new ReactInstanceManager.ReactInstanceEventListener() {
                /* class _m_j.fwy.AnonymousClass5 */

                public final void onReactContextInitialized(ReactContext reactContext) {
                    fyc.O00000o("RNRuntimeTAG", "----initRuntime onReactContextInitialized");
                    gbu.O00000oo("release new reactview,context wait ready,needShow=" + z2);
                    fwy fwy = fwy.this;
                    fwy.O0000oo = false;
                    fwy.O00000Oo(",load_show_0_" + fwy.this.O00000oo + "_ns_" + z2);
                    fwy.this.O00000o = fwy.O00000Oo();
                    if (z2) {
                        gbu.O00000oo("release new reactview, start react application");
                        fwy.this.O00000o.startReactApplication(fwy.this.O0000O0o, fwy.this.O00000oo);
                        fwy fwy2 = fwy.this;
                        fwy2.O000O0Oo = true;
                        fwy2.O000000o(deviceStat2, pluginPackageInfo2);
                        hsi.O000000o("runtime plugin ready");
                        if (gax.O000000o(i2, deviceStat2.model)) {
                            gav.O000000o(deviceStat2.model, pluginPackageInfo2, "sdk_loaded");
                        }
                    }
                }
            });
        } else {
            gbu.O00000oo("release new reactview, context not null,needShow=".concat(String.valueOf(z)));
            this.O0000oo = false;
            O00000Oo(",load_show_1_" + this.O00000oo + "_ns_" + z);
            this.O00000o = O00000Oo();
            if (z) {
                gbu.O00000oo("release new reactview, start react application");
                this.O00000o.startReactApplication(this.O0000O0o, this.O00000oo);
                this.O000O0Oo = true;
                O000000o(deviceStat, pluginPackageInfo);
                if (gax.O000000o(i, deviceStat.model)) {
                    gav.O000000o(deviceStat.model, pluginPackageInfo, "sdk_loaded");
                }
            }
        }
    }

    public static ReactRootView O00000Oo() {
        return new ReactRootView(CommonApplication.getAppContext());
    }

    private static void O000000o(long j, long j2, String str, int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("open_plugin_status", Integer.valueOf(i));
        hashMap.put("cache_hit_type", Integer.valueOf(i2));
        gav.O000000o(j, j2, str, hashMap);
    }

    private void O000000o(DeviceStat deviceStat, PluginPackageInfo pluginPackageInfo, PluginDeviceInfo pluginDeviceInfo, int i, boolean z) {
        this.O0000O0o = null;
        O00000Oo(",debug_init_sdk");
        O000000o(true);
        this.O0000Oo = fky.O00000Oo(pluginPackageInfo.O00000o()) + File.separator;
        pluginPackageInfo.O00000Oo(this.O00000oo);
        this.O0000o00 = deviceStat;
        this.O0000OoO = pluginPackageInfo;
        O00000Oo(",debug_plugin_record_" + this.O0000OoO.O00000oo());
        this.O0000Ooo = pluginDeviceInfo;
        gbu.O000000o("RNRuntime  initRuntime debug>" + this.O00000oo + ">" + this.O0000Oo);
        O000000o(deviceStat, pluginPackageInfo, i, z);
    }

    private void O00000Oo(DeviceStat deviceStat, PluginPackageInfo pluginPackageInfo, PluginDeviceInfo pluginDeviceInfo, int i, boolean z) {
        boolean z2;
        final hsi.O000000o o000000o = this.O0000Oo0;
        if (hsi.O000000o()) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        }
        String O00000oo2 = pluginPackageInfo.O00000oo();
        if (i == 3) {
            z2 = TextUtils.isEmpty(this.O00000oo);
            if (!(this.O0000o00 == null || deviceStat == null || TextUtils.equals(deviceStat.did, this.O0000o00.did))) {
                z2 = false;
            }
        } else {
            z2 = true;
        }
        O00000Oo(",set_package_name_".concat(String.valueOf(O00000oo2)));
        this.O00000oo = O00000oo2;
        if (z && (o000000o.f598O000000o > this.O0000Oo0.f598O000000o || !z2)) {
            gbu.O00000oo("RnPluginInfo releaseRnPluginInit(),recordReInit isSamePlugin=".concat(String.valueOf(z2)));
            O00000Oo(1);
            this.O0000O0o = null;
            O00000Oo(",same_plugin_init_sdk");
            O000000o(true);
        }
        this.O0000Oo = fky.O00000Oo(pluginPackageInfo.O00000o()) + File.separator;
        gbu.O00000oo("RnPluginInfo releaseRnPluginInit:  sdkInfo=" + this.O0000Oo0.toString() + "   PluginBundlePath=" + this.O0000Oo);
        this.O0000o00 = deviceStat;
        this.O0000OoO = pluginPackageInfo;
        O00000Oo(",release_plugin_record_" + this.O0000OoO.O00000oo());
        this.O0000Ooo = pluginDeviceInfo;
        ReactContext currentReactContext = this.O0000O0o.getCurrentReactContext();
        if (currentReactContext != null) {
            gbu.O00000oo("releaseRnPluginInit(),context not null,needShow=".concat(String.valueOf(z)));
            fyc.O00000o("RNRuntimeTAG", "context!=null,start load");
            O00000Oo(",plugin_init_context_ready");
            if (z || !this.O000O0Oo) {
                O000000o(currentReactContext, o000000o, z);
                O000000o(deviceStat, pluginPackageInfo, i, z);
                return;
            }
            O00000Oo(",plugin_init_context_ready_not_load");
            gbu.O00000oo("releaseRnPluginInit(),context ready not load");
            return;
        }
        fyc.O00000o("RNRuntimeTAG", "wait context then load");
        O00000Oo(",plugin_init_context_wait");
        gbu.O00000oo("RnPluginInfo releaseRnPluginInit(),context null,needShow=".concat(String.valueOf(z)));
        final boolean z3 = z;
        final DeviceStat deviceStat2 = deviceStat;
        final PluginPackageInfo pluginPackageInfo2 = pluginPackageInfo;
        final int i2 = i;
        this.O0000O0o.addReactInstanceEventListener(new ReactInstanceManager.ReactInstanceEventListener() {
            /* class _m_j.fwy.AnonymousClass6 */

            public final void onReactContextInitialized(ReactContext reactContext) {
                fyc.O00000o("RNRuntimeTAG", "wait context over,start load");
                fwy.this.O00000Oo(",plugin_init_context_wait_ready");
                gbu.O00000oo("releaseRnPluginInit(),context wait ready,needShow=" + z3);
                fwy.this.O0000O0o.removeReactInstanceEventListener(this);
                if (z3 || !fwy.this.O000O0Oo) {
                    fwy.this.O000000o(reactContext, o000000o, z3);
                    fwy.this.O000000o(deviceStat2, pluginPackageInfo2, i2, z3);
                    return;
                }
                fwy.this.O00000Oo(",plugin_init_context_wait_ready_not_load");
                gbu.O00000oo("releaseRnPluginInit(),context wait ready not load");
            }
        });
        this.f17340O000000o |= 262144;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fwy.O000000o(com.facebook.react.bridge.JSBundleLoaderDelegate, _m_j.hsi$O000000o, boolean):void
     arg types: [com.facebook.react.bridge.CatalystInstanceImpl, _m_j.hsi$O000000o, int]
     candidates:
      _m_j.fwy.O000000o(com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo, java.io.File, java.io.File):void
      _m_j.fwy.O000000o(com.facebook.react.bridge.ReactContext, _m_j.hsi$O000000o, boolean):void
      _m_j.fwy.O000000o(com.xiaomi.plugin.core.XmPluginPackage, java.lang.Throwable, boolean):void
      _m_j.fwy.O000000o(com.facebook.react.bridge.JSBundleLoaderDelegate, _m_j.hsi$O000000o, boolean):void */
    public final void O000000o(ReactContext reactContext, hsi.O000000o o000000o, boolean z) {
        ReadableMap map;
        gbu.O00000oo("RNRuntime tryLoadPlugin(),needShow=".concat(String.valueOf(z)));
        if (this.O0000o > 0) {
            gbu.O000000o("RNRuntime --> will send onPluginConfigUpdate event...");
            ReadableMap O000000o2 = this.O00000oO.O000000o(this);
            if (O000000o2 == null || (map = O000000o2.getMap("package")) == null) {
                O00000Oo(",load_constant_1_ns_".concat(String.valueOf(z)));
            } else {
                String string = map.getString("packageName");
                O00000Oo(",load_constant_0_" + string + "_ns_" + z);
            }
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onPluginConfigUpdate", O000000o2);
        } else {
            O00000Oo(",load_constant_2");
            gbu.O00000Oo("RNRuntime --> not send onPluginConfigUpdate event...");
        }
        this.O0000ooO = AppearanceModule.colorSchemeForCurrentConfiguration(reactContext);
        CatalystInstance catalystInstance = reactContext.getCatalystInstance();
        if (catalystInstance != null) {
            O00000Oo(",plugin_load_script_cache");
            O000000o((JSBundleLoaderDelegate) ((CatalystInstanceImpl) catalystInstance), o000000o, true);
            return;
        }
        O00000Oo(",load_plugin_catalyst_null");
    }

    public final void O000000o(O000000o o000000o) {
        if (o000000o == null) {
            return;
        }
        if (O00000o0()) {
            try {
                o000000o.onAttachPlugin(this.O00000o, this.O0000O0o, this.O0000o00, this.O0000OoO);
            } catch (Exception e) {
                Log.i("RNRuntimeTAG", "failed to register listener", e);
            }
        } else {
            ArrayList<O000000o> arrayList = this.O0000o0o;
            if (arrayList == null) {
                this.O0000o0o = new ArrayList<>();
                this.O0000o0o.add(o000000o);
            } else if (!arrayList.contains(o000000o)) {
                this.O0000o0o.add(o000000o);
            }
        }
    }

    public final boolean O00000o0() {
        ReactInstanceManager reactInstanceManager;
        return (this.O0000OoO == null || this.O0000Ooo == null || this.O0000o00 == null || (reactInstanceManager = this.O0000O0o) == null || reactInstanceManager.getCurrentReactContext() == null) ? false : true;
    }

    public final void O000000o(DeviceStat deviceStat, PluginPackageInfo pluginPackageInfo) {
        if (this.O0000o0o != null) {
            for (int i = 0; i < this.O0000o0o.size(); i++) {
                O000000o o000000o = this.O0000o0o.get(i);
                if (o000000o != null) {
                    o000000o.onAttachPlugin(this.O00000o, this.O0000O0o, deviceStat, pluginPackageInfo);
                }
            }
            this.O0000o0o = null;
        }
    }

    public final void O000000o(boolean z, WritableMap writableMap) {
        fwt fwt = this.O00000oO;
        if (fwt == null || fwt.O00000Oo == null) {
            gbu.O00000Oo("rn package is null...");
        } else {
            this.O00000oO.O00000Oo.jumpToThirdpartyAppResultCallback(z, writableMap);
        }
    }

    public final void O00000Oo(boolean z, WritableMap writableMap) {
        gbu.O00000o0("scanCodeResultCallback,RNRuntime");
        fwt fwt = this.O00000oO;
        if (fwt == null || fwt.O00000Oo == null) {
            gbu.O00000Oo("rn package is null...");
        } else {
            this.O00000oO.O00000o0.scanCodeResultCallback(z, writableMap);
        }
    }

    private void O000000o(PluginPackageInfo pluginPackageInfo) {
        if (pluginPackageInfo != null) {
            File pluginDir = MIOTPackageModule.getPluginDir(CommonApplication.getAppContext(), pluginPackageInfo);
            File file = new File(pluginDir, "files");
            if (file.exists()) {
                this.O000Oo0O = true;
                goq.O00000oO(new Runnable(pluginPackageInfo, pluginDir, file) {
                    /* class _m_j.$$Lambda$fwy$DZ9ydDWoetGirjQBajtLWlNpis */
                    private final /* synthetic */ PluginPackageInfo f$1;
                    private final /* synthetic */ File f$2;
                    private final /* synthetic */ File f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void run() {
                        fwy.this.O000000o(this.f$1, this.f$2, this.f$3);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(PluginPackageInfo pluginPackageInfo, File file, File file2) {
        List<DeviceStat> deviceListV2 = XmPluginHostApi.instance().getDeviceListV2(pluginPackageInfo.O0000OoO());
        if (deviceListV2 != null && deviceListV2.size() != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            for (DeviceStat deviceStat : deviceListV2) {
                O000000o(file2, file + File.separator + deviceStat.did);
            }
            this.O000Oo0O = false;
            this.O000Oo0o.countDown();
            long currentTimeMillis2 = System.currentTimeMillis();
            gsy.O000000o(5, "RNRuntime", Thread.currentThread().getName() + "migrate over and it costs time " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            gsc.O00000oO(file2.getAbsolutePath());
        }
    }

    private void O000000o(File file, String str) {
        if (file.isDirectory()) {
            String str2 = str + File.separator + file.getName();
            new File(str2).mkdirs();
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File O000000o2 : listFiles) {
                    O000000o(O000000o2, str2);
                }
            }
        } else if (file.isFile()) {
            gsc.O000000o(file.getAbsolutePath(), str + File.separator + file.getName());
        }
    }

    public static List<String> O000000o(List<String> list) {
        PluginPackageInfo O0000Oo2;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            Device O000000o2 = fno.O000000o().O000000o(next);
            if (O000000o2 != null && !TextUtils.isEmpty(O000000o2.did) && (O0000Oo2 = CoreApi.O000000o().O0000Oo(O000000o2.model)) != null && O0000Oo2.O0000o0O()) {
                arrayList.add(MIOTPackageModule.getPluginDir(CommonApplication.getAppContext(), O0000Oo2).getAbsolutePath() + File.separator + next);
            }
        }
        return arrayList;
    }

    public static void O00000Oo(List<String> list) {
        if (list != null && !list.isEmpty()) {
            for (String r1 : list) {
                goq.O000000o(new Runnable(r1) {
                    /* class _m_j.$$Lambda$fwy$zjiIZGufLVtt3zNak45dK60Eiz0 */
                    private final /* synthetic */ String f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void run() {
                        gsc.O00000oO(this.f$0);
                    }
                });
            }
            Intent intent = new Intent();
            intent.setAction("device_was_deleted");
            intent.putStringArrayListExtra("fold_lists", (ArrayList) list);
            CommonApplication.getAppContext().sendBroadcast(intent);
        }
    }

    public static void O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            O00000Oo(arrayList);
        }
    }

    public final void O00000o() {
        fyc.O00000o0("RNRuntimeTAG", "closeCurrentPage");
        Activity activity = this.O0000OOo;
        if (activity != null) {
            activity.finish();
        }
    }

    public final fwv O00000oO() {
        DeviceStat deviceStat = this.O0000o00;
        if (deviceStat == null || this.O0000OoO == null) {
            return null;
        }
        return new fwv(deviceStat.model, this.O0000o00.did, Long.valueOf(this.O0000OoO.O00000Oo()));
    }

    public final void O00000Oo(String str) {
        StringBuilder sb;
        if (this.O000OoO0 && (sb = this.O000O0OO) != null) {
            sb.append(str);
        }
    }

    public final boolean O000000o(int i) {
        if (this.O0000oOO == 1) {
            fyc.O00000o0("RNRuntimeTAG", "requestInit,invalid init request,RNRuntime is being initialized,wait a moment for the process to finish");
            return false;
        }
        this.O0000O0o = null;
        O00000Oo(i);
        O000000o(true);
        return true;
    }
}
