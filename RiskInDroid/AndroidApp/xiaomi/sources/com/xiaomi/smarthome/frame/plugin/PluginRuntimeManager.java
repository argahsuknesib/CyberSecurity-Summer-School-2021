package com.xiaomi.smarthome.frame.plugin;

import _m_j.exz;
import _m_j.fcx;
import _m_j.fkd;
import _m_j.fkl;
import _m_j.fso;
import _m_j.fsp;
import _m_j.ft;
import _m_j.ftm;
import _m_j.gfr;
import _m_j.gsy;
import _m_j.hsi;
import _m_j.hxi;
import _m_j.hyy;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import com.xiaomi.plugin.core.XmPluginPackage;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.core.server.internal.plugin.DynamicFeatureManager;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.IXmPluginMessageReceiver;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.IBridgeCallback;
import com.xiaomi.smarthome.frame.plugin.IBridgeServiceApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivity;
import com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivityMain;
import com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivityPlugin1;
import com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivityPlugin2;
import com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivityPlugin3;
import com.xiaomi.smarthome.frame.plugin.runtime.bridge.BridgeError;
import com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService;
import com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeServiceCamera;
import com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeServiceFrame1;
import com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeServiceFrame2;
import com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeServiceMain;
import com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeServicePlugin;
import com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeServicePlugin1;
import com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeServicePlugin2;
import com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeServicePlugin3;
import com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeServicePlugin4;
import com.xiaomi.smarthome.frame.plugin.runtime.service.PluginHostServiceDesaiShoe;
import com.xiaomi.smarthome.frame.plugin.runtime.service.PluginHostServiceOneMore;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import com.xiaomi.smarthome.plugin.service.HostService;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class PluginRuntimeManager {
    private static volatile PluginRuntimeManager sInstance;
    private static final Object sLock = new Object();
    public Context mAppContext = fsp.O000000o().O00000Oo;
    private IBridgeServiceApi mCameraBridgeApiProxy;
    long[] mCameraProcessModels = new long[2];
    private long mCurrentPackageId;
    private RunningProcess mCurrentProcess;
    private List<String> mCurrentRelations;
    private IBridgeServiceApi mFrame1BridgeApiProxy;
    private IBridgeServiceApi mFrame2BridgeApiProxy;
    private IBridgeServiceApi mMainBridgeApiProxy;
    private final ConcurrentMap<PluginPackageInfo, XmPluginPackage> mModelPackages = new ConcurrentHashMap();
    private boolean mMultiRNRuntimeProcessReuseDisable = false;
    public RunningProcess mNextProcess;
    private final ConcurrentMap<String, XmPluginPackage> mPackagePathPackages = new ConcurrentHashMap();
    private IBridgeServiceApi mPlugin1BridgeApiProxy;
    private IBridgeServiceApi mPlugin2BridgeApiProxy;
    private IBridgeServiceApi mPlugin3BridgeApiProxy;
    private IBridgeServiceApi mPlugin4BridgeApiProxy;
    private IBridgeServiceApi mPluginBridgeApiProxy;
    private int mProcessReuseEnterType;
    private boolean mRnProcessReuseEnable = true;
    private HashMap<Long, RunningProcess> mStartedCameraProcess = new HashMap<>();
    private HashMap<Long, RunningProcess> mStartedProcess = new HashMap<>();

    enum ProcessType {
        MAIN,
        CAMERA_FRAME,
        OTHER
    }

    public XmPluginPackage getPackageFromPackage(String str) {
        return null;
    }

    private PluginRuntimeManager() {
    }

    public static PluginRuntimeManager getInstance() {
        if (sInstance == null) {
            synchronized (sLock) {
                if (sInstance == null) {
                    sInstance = new PluginRuntimeManager();
                }
            }
        }
        return sInstance;
    }

    public static void clearViewBuffer() {
        try {
            Field declaredField = LayoutInflater.class.getDeclaredField("sConstructorMap");
            if (Modifier.isStatic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
                ((HashMap) declaredField.get(null)).clear();
            }
        } catch (Exception unused) {
        }
    }

    private static void applyLanguage(Resources resources, Locale locale) {
        if (resources != null) {
            gsy.O000000o(3, "LanguageUtil", "applyLanguage:" + locale.toString());
            Configuration configuration = resources.getConfiguration();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration.locale = locale;
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    public IBridgeServiceApi getBridgeApiProxy(RunningProcess runningProcess) {
        IBridgeServiceApi iBridgeServiceApi = null;
        if (runningProcess == null) {
            return null;
        }
        synchronized (sLock) {
            if (runningProcess == RunningProcess.MAIN) {
                iBridgeServiceApi = this.mMainBridgeApiProxy;
            } else if (runningProcess == RunningProcess.PLUGIN0) {
                iBridgeServiceApi = this.mPluginBridgeApiProxy;
            } else if (runningProcess == RunningProcess.PLUGIN1) {
                iBridgeServiceApi = this.mPlugin1BridgeApiProxy;
            } else if (runningProcess == RunningProcess.PLUGIN2) {
                iBridgeServiceApi = this.mPlugin2BridgeApiProxy;
            } else if (runningProcess == RunningProcess.PLUGIN3) {
                iBridgeServiceApi = this.mPlugin3BridgeApiProxy;
            } else if (runningProcess == RunningProcess.PLUGIN4) {
                iBridgeServiceApi = this.mPlugin4BridgeApiProxy;
            } else if (runningProcess == RunningProcess.FRAME1) {
                iBridgeServiceApi = this.mFrame1BridgeApiProxy;
            } else if (runningProcess == RunningProcess.FRAME2) {
                iBridgeServiceApi = this.mFrame2BridgeApiProxy;
            } else if (runningProcess == RunningProcess.CAMERA) {
                iBridgeServiceApi = this.mCameraBridgeApiProxy;
            }
        }
        return iBridgeServiceApi;
    }

    public void setBridgeApiProxy(String str, RunningProcess runningProcess, IBridgeServiceApi iBridgeServiceApi) {
        long j;
        if (runningProcess != null) {
            synchronized (sLock) {
                if (runningProcess == RunningProcess.MAIN) {
                    this.mMainBridgeApiProxy = iBridgeServiceApi;
                } else if (runningProcess == RunningProcess.PLUGIN0) {
                    this.mPluginBridgeApiProxy = iBridgeServiceApi;
                } else if (runningProcess == RunningProcess.PLUGIN1) {
                    this.mPlugin1BridgeApiProxy = iBridgeServiceApi;
                } else if (runningProcess == RunningProcess.PLUGIN2) {
                    this.mPlugin2BridgeApiProxy = iBridgeServiceApi;
                } else if (runningProcess == RunningProcess.PLUGIN3) {
                    this.mPlugin3BridgeApiProxy = iBridgeServiceApi;
                } else if (runningProcess == RunningProcess.PLUGIN4) {
                    this.mPlugin4BridgeApiProxy = iBridgeServiceApi;
                } else if (runningProcess == RunningProcess.FRAME1) {
                    this.mFrame1BridgeApiProxy = iBridgeServiceApi;
                } else if (runningProcess == RunningProcess.FRAME2) {
                    this.mFrame2BridgeApiProxy = iBridgeServiceApi;
                } else if (runningProcess == RunningProcess.CAMERA) {
                    this.mCameraBridgeApiProxy = iBridgeServiceApi;
                }
                if (iBridgeServiceApi == null) {
                    PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(str);
                    if (O0000Oo == null) {
                        j = 0;
                    } else {
                        j = O0000Oo.O00000Oo();
                    }
                    if (this.mCameraProcessModels[0] != 0 && this.mCameraProcessModels[0] == j) {
                        this.mCameraProcessModels[0] = 0;
                    }
                    if (this.mCameraProcessModels[1] != 0 && this.mCameraProcessModels[1] == j) {
                        this.mCameraProcessModels[1] = 0;
                    }
                }
            }
        }
    }

    public XmPluginPackage getXmPluginPackage(PluginPackageInfo pluginPackageInfo) {
        AssetManager assetManager;
        PackageInfo packageInfo;
        String str;
        IXmPluginMessageReceiver iXmPluginMessageReceiver;
        Class<?> cls;
        PluginPackageInfo pluginPackageInfo2 = pluginPackageInfo;
        XmPluginPackage xmPluginPackage = this.mModelPackages.get(pluginPackageInfo2);
        if (xmPluginPackage != null) {
            return xmPluginPackage;
        }
        long currentTimeMillis = System.currentTimeMillis();
        XmPluginPackage xmPluginPackage2 = null;
        if (pluginPackageInfo2 == null) {
            return null;
        }
        XmPluginPackage xmPluginPackage3 = this.mPackagePathPackages.get(pluginPackageInfo.O00000o());
        if (xmPluginPackage3 != null) {
            return xmPluginPackage3;
        }
        long O000000o2 = pluginPackageInfo.O000000o();
        long O00000Oo = pluginPackageInfo.O00000Oo();
        String O00000o = pluginPackageInfo.O00000o();
        if (hsi.O000000o(O000000o2) && hsi.O00000Oo(O00000Oo) && !TextUtils.isEmpty(O00000o)) {
            PackageManager packageManager = this.mAppContext.getPackageManager();
            if (DynamicFeatureManager.instance.isDynamicFeaturePath(O00000o)) {
                String O00000oo = pluginPackageInfo.O00000oo();
                PackageInfo packageInfo2 = new PackageInfo();
                packageInfo2.applicationInfo = new ApplicationInfo();
                packageInfo = packageInfo2;
                assetManager = this.mAppContext.getAssets();
                str = O00000oo;
            } else {
                PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(O00000o, NotificationCompat.FLAG_HIGH_PRIORITY);
                if (packageArchiveInfo == null) {
                    return null;
                }
                String string = packageArchiveInfo.applicationInfo.metaData != null ? packageArchiveInfo.applicationInfo.metaData.getString("message_handler") : "";
                packageInfo = packageArchiveInfo;
                assetManager = createAssetManager(O00000o);
                str = string;
            }
            String O00000oo2 = pluginPackageInfo.O00000oo();
            ClassLoader createLoader = CommonApplication.getApplication().createLoader(O000000o2, O00000Oo, O00000o);
            if (!TextUtils.isEmpty(str)) {
                if (createLoader == null) {
                    try {
                        cls = Class.forName(str);
                    } catch (Exception e) {
                        Log.e("PluginManagerFrame", "load apk", e);
                        return null;
                    }
                } else {
                    cls = createLoader.loadClass(str);
                }
                iXmPluginMessageReceiver = (IXmPluginMessageReceiver) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            } else {
                iXmPluginMessageReceiver = null;
            }
            PackageInfo packageInfo3 = packageInfo;
            ClassLoader classLoader = createLoader;
            PackageManager packageManager2 = packageManager;
            xmPluginPackage2 = new XmPluginPackage(O00000oo2, O00000o, classLoader, assetManager, packageInfo3, "", iXmPluginMessageReceiver);
            xmPluginPackage2.setModelList(pluginPackageInfo.O0000OoO());
            xmPluginPackage2.setPluginId(pluginPackageInfo.O000000o());
            xmPluginPackage2.setPackageId(pluginPackageInfo.O00000Oo());
            ApplicationInfo applicationInfo = packageInfo3.applicationInfo;
            if (Build.VERSION.SDK_INT >= 8) {
                applicationInfo.sourceDir = O00000o;
                applicationInfo.publicSourceDir = O00000o;
            }
            xmPluginPackage2.miniApiVersion = pluginPackageInfo.O0000OOo();
            xmPluginPackage2.appLabel = packageManager2.getApplicationLabel(applicationInfo);
            xmPluginPackage2.packageVersion = pluginPackageInfo.O00000oO();
            this.mModelPackages.put(pluginPackageInfo2, xmPluginPackage2);
            this.mPackagePathPackages.put(pluginPackageInfo.O00000o(), xmPluginPackage2);
            PluginBridgeService.mLoadTime = System.currentTimeMillis() - currentTimeMillis;
        }
        return xmPluginPackage2;
    }

    private AssetManager createAssetManager(String str) {
        try {
            AssetManager newInstance = AssetManager.class.newInstance();
            newInstance.getClass().getMethod("addAssetPath", String.class).invoke(newInstance, str);
            return newInstance;
        } catch (Exception unused) {
            return null;
        }
    }

    public static RunningProcess getProcessByName(String str) {
        if (str.equals(PluginBridgeServicePlugin.class.getName())) {
            return RunningProcess.PLUGIN0;
        }
        if (str.equals(PluginBridgeServicePlugin1.class.getName())) {
            return RunningProcess.PLUGIN1;
        }
        if (str.equals(PluginBridgeServicePlugin2.class.getName())) {
            return RunningProcess.PLUGIN2;
        }
        if (str.equals(PluginBridgeServicePlugin3.class.getName())) {
            return RunningProcess.PLUGIN3;
        }
        if (str.equals(PluginBridgeServicePlugin4.class.getName())) {
            return RunningProcess.PLUGIN4;
        }
        if (str.equals(PluginBridgeServiceMain.class.getName())) {
            return RunningProcess.MAIN;
        }
        if (str.equals(PluginBridgeServiceFrame1.class.getName())) {
            return RunningProcess.FRAME1;
        }
        if (str.equals(PluginBridgeServiceFrame2.class.getName())) {
            return RunningProcess.FRAME2;
        }
        if (str.equals(PluginBridgeServiceCamera.class.getName())) {
            return RunningProcess.CAMERA;
        }
        return null;
    }

    public void removeDexFile(Context context, long j, long j2) {
        if (hsi.O00000Oo(j2)) {
            File dir = context.getDir("dex", 0);
            new File(dir.getAbsolutePath() + File.separator + "plugin" + File.separator + j + File.separator + j2 + ".dex").delete();
        }
    }

    public XmPluginPackage getXmPluginPackageByCrashClassName(List<String> list) {
        boolean z;
        if (list == null || list.size() <= 0) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (String next : list) {
                if (!next.startsWith("android") && !next.startsWith("dalvik") && !next.startsWith("java") && !next.startsWith("javax") && !next.startsWith("com.xiaomi.smarthome")) {
                    String[] split = next.split("\\.");
                    if (split.length >= 3) {
                        arrayList.add(split[0] + "." + split[1] + "." + split[2]);
                    }
                    if (split.length >= 4) {
                        arrayList.add(split[0] + "." + split[1] + "." + split[2] + "." + split[3]);
                    }
                    if (split.length >= 5) {
                        arrayList.add(split[0] + "." + split[1] + "." + split[2] + "." + split[3] + "." + split[4]);
                    }
                }
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            XmPluginPackage xmPluginPackage = null;
            for (int i = 0; i < this.mPackagePathPackages.size(); i++) {
                XmPluginPackage xmPluginPackage2 = this.mPackagePathPackages.get(Integer.valueOf(i));
                String str = xmPluginPackage2.packageName;
                if (!TextUtils.isEmpty(str)) {
                    int size = arrayList.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            xmPluginPackage2 = xmPluginPackage;
                            z = false;
                            break;
                        } else if (str.equalsIgnoreCase((String) arrayList.get(i2))) {
                            z = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z) {
                        return xmPluginPackage2;
                    }
                    xmPluginPackage = xmPluginPackage2;
                }
            }
            return xmPluginPackage;
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean checkPluginProcess(RunningProcess runningProcess) {
        if (runningProcess == null) {
            return false;
        }
        return runningProcess == RunningProcess.PLUGIN0 || runningProcess == RunningProcess.MAIN || runningProcess == RunningProcess.PLUGIN2 || runningProcess == RunningProcess.PLUGIN3 || runningProcess == RunningProcess.PLUGIN4 || runningProcess == RunningProcess.PLUGIN1 || runningProcess == RunningProcess.FRAME1 || runningProcess == RunningProcess.FRAME2 || runningProcess == RunningProcess.CAMERA;
    }

    private Class getPluginBridgeServiceClass(RunningProcess runningProcess) {
        if (runningProcess == RunningProcess.PLUGIN0) {
            return PluginBridgeServicePlugin.class;
        }
        if (runningProcess == RunningProcess.PLUGIN1) {
            return PluginBridgeServicePlugin1.class;
        }
        if (runningProcess == RunningProcess.MAIN) {
            return PluginBridgeServiceMain.class;
        }
        if (runningProcess == RunningProcess.PLUGIN2) {
            return PluginBridgeServicePlugin2.class;
        }
        if (runningProcess == RunningProcess.PLUGIN3) {
            return PluginBridgeServicePlugin3.class;
        }
        if (runningProcess == RunningProcess.PLUGIN4) {
            return PluginBridgeServicePlugin4.class;
        }
        if (runningProcess == RunningProcess.FRAME1) {
            return PluginBridgeServiceFrame1.class;
        }
        if (runningProcess == RunningProcess.FRAME2) {
            return PluginBridgeServiceFrame2.class;
        }
        if (runningProcess == RunningProcess.CAMERA) {
            return PluginBridgeServiceCamera.class;
        }
        return null;
    }

    public RunningProcess getPluginProcess(int i, String str) {
        PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(str);
        long O00000Oo = O0000Oo != null ? O0000Oo.O00000Oo() : -1;
        RunningProcess runningProcess = this.mCurrentProcess;
        if (runningProcess != null && O00000Oo == this.mCurrentPackageId) {
            return runningProcess;
        }
        RunningProcess pluginProcessInnerNew = getPluginProcessInnerNew(ProcessType.MAIN, i, str, false);
        return pluginProcessInnerNew == null ? RunningProcess.PLUGIN0 : pluginProcessInnerNew;
    }

    public RunningProcess getPluginProcess(ProcessType processType, int i, String str, boolean z) {
        RunningProcess pluginProcessInnerNew = getPluginProcessInnerNew(processType, i, str, z);
        return pluginProcessInnerNew == null ? RunningProcess.PLUGIN0 : pluginProcessInnerNew;
    }

    private RunningProcess chooseOneCameraProcess(long j) {
        if (this.mStartedCameraProcess.size() < 3) {
            Collection<RunningProcess> values = this.mStartedCameraProcess.values();
            RunningProcess[] frameProcesses = RunningProcess.getFrameProcesses();
            int length = frameProcesses.length;
            int i = 0;
            while (i < length) {
                RunningProcess runningProcess = frameProcesses[i];
                if (values.contains(runningProcess) || runningProcess.equals(RunningProcess.MAIN)) {
                    i++;
                } else {
                    this.mStartedCameraProcess.put(Long.valueOf(j), runningProcess);
                    return runningProcess;
                }
            }
            return RunningProcess.PLUGIN0;
        }
        long j2 = Long.MAX_VALUE;
        long j3 = 0;
        Iterator it = new ArrayList(this.mStartedCameraProcess.keySet()).iterator();
        while (it.hasNext()) {
            Long l = (Long) it.next();
            if (this.mStartedCameraProcess.get(Long.valueOf(j)) != null && this.mStartedCameraProcess.get(Long.valueOf(j)).getTimeStamp() < j2) {
                long longValue = l.longValue();
                j2 = this.mStartedCameraProcess.get(Long.valueOf(j)).getTimeStamp();
                j3 = longValue;
            }
        }
        gsy.O000000o(6, "PluginManagerFrame", "kill progress - " + this.mStartedCameraProcess.get(Long.valueOf(j)));
        RunningProcess runningProcess2 = this.mStartedCameraProcess.get(Long.valueOf(j3));
        exitProcess(runningProcess2);
        this.mStartedCameraProcess.put(Long.valueOf(j), runningProcess2);
        return runningProcess2;
    }

    /* access modifiers changed from: package-private */
    public RunningProcess getMainSelectProcess(RunningProcess runningProcess) {
        if (runningProcess == null) {
            return RunningProcess.PLUGIN0;
        }
        String name = runningProcess.name();
        return RunningProcess.getByProcessValue("plugin".concat(String.valueOf((Integer.valueOf(name.substring(name.length() - 1)).intValue() + 1) % 3)));
    }

    /* access modifiers changed from: package-private */
    public void processDiedProcess(RunningProcess runningProcess) {
        RunningProcess runningProcess2 = this.mNextProcess;
        if (runningProcess == runningProcess2) {
            Class pluginBridgeServiceClass = getPluginBridgeServiceClass(runningProcess2);
            Intent intent = new Intent(this.mAppContext, pluginBridgeServiceClass);
            if (pluginBridgeServiceClass != null) {
                this.mAppContext.bindService(intent, new ServiceConnection() {
                    /* class com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager.AnonymousClass1 */
                    RunningProcess currentProcess = PluginRuntimeManager.this.mNextProcess;

                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        PluginRuntimeManager.this.setBridgeApiProxy("", this.currentProcess, IBridgeServiceApi.Stub.asInterface(iBinder));
                    }

                    public void onServiceDisconnected(ComponentName componentName) {
                        PluginRuntimeManager.this.setBridgeApiProxy("", this.currentProcess, null);
                        try {
                            PluginRuntimeManager.this.mAppContext.unbindService(this);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        PluginRuntimeManager.this.processDiedProcess(this.currentProcess);
                    }
                }, 1);
            }
        }
    }

    private RunningProcess getPluginProcessInnerNew(ProcessType processType, int i, String str, boolean z) {
        if (str.equalsIgnoreCase("onemore.soundbox.sm001") || str.equalsIgnoreCase("desay.bleshoes.s311")) {
            return RunningProcess.PLUGIN3;
        }
        PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(str);
        if ("t.t.t".equals(str)) {
            return RunningProcess.PLUGIN0;
        }
        if ("miot.clock.mijia".equals(str)) {
            return RunningProcess.MAIN;
        }
        if (hyy.O000000o()) {
            exz exz = exz.f15941O000000o;
            if (exz.O00000Oo(str) && !O0000Oo.O0000o0()) {
                return RunningProcess.PLUGIN4;
            }
        }
        if (str.contains("xiaomi.tv") || "chuangmi.wifi.v1".equals(str)) {
            return RunningProcess.MAIN;
        }
        if (TextUtils.isEmpty(str)) {
            return RunningProcess.PLUGIN0;
        }
        if (fsp.O000000o().O0000OOo.shouldStartInCameraProcess(str) && isRNPlugin(O0000Oo) && processType == ProcessType.MAIN) {
            return RunningProcess.CAMERA;
        }
        long j = 0;
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str);
        if (O0000Oo != null) {
            j = O0000Oo.O00000Oo();
        }
        List<String> list = null;
        if (processType == ProcessType.MAIN) {
            if (this.mCurrentProcess == null && this.mNextProcess == null) {
                this.mCurrentProcess = RunningProcess.PLUGIN0;
                this.mCurrentPackageId = j;
                if (!(O0000Oo == null || O00000oO == null || !isMpkPlugin(O0000Oo))) {
                    this.mCurrentRelations = O00000oO.O000O0Oo();
                }
                Class pluginBridgeServiceClass = getPluginBridgeServiceClass(RunningProcess.PLUGIN1);
                Intent intent = new Intent(this.mAppContext, pluginBridgeServiceClass);
                if (pluginBridgeServiceClass != null) {
                    this.mAppContext.bindService(intent, new ServiceConnection() {
                        /* class com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager.AnonymousClass2 */
                        RunningProcess currentProcess = RunningProcess.PLUGIN1;

                        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                            PluginRuntimeManager.this.setBridgeApiProxy("", this.currentProcess, IBridgeServiceApi.Stub.asInterface(iBinder));
                        }

                        public void onServiceDisconnected(ComponentName componentName) {
                            PluginRuntimeManager.this.setBridgeApiProxy("", this.currentProcess, null);
                            try {
                                PluginRuntimeManager.this.mAppContext.unbindService(this);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            PluginRuntimeManager.this.processDiedProcess(this.currentProcess);
                        }
                    }, 1);
                }
                this.mNextProcess = RunningProcess.PLUGIN1;
                return this.mCurrentProcess;
            } else if (this.mNextProcess == null) {
                return RunningProcess.PLUGIN0;
            } else {
                boolean isMpkPlugin = O0000Oo != null ? isMpkPlugin(O0000Oo) : false;
                if (isMpkPlugin) {
                    setRNProcessReuseDisable(5);
                }
                RunningProcess runningProcess = this.mCurrentProcess;
                if (runningProcess != null && this.mCurrentPackageId == j && isMpkPlugin) {
                    return runningProcess;
                }
                if (!z && isRNPlugin(O0000Oo)) {
                    if (fcx.f16092O000000o.O0000OOo()) {
                        if (this.mCurrentProcess != null && isRNPlugin(O0000Oo)) {
                            LogType logType = LogType.PLUGIN;
                            gsy.O00000o0(logType, "rn-plugin-framework", "miot-rn-plugin", "multiRNRuntimeReuseEnable,mRnProcessReuseEnable=" + this.mRnProcessReuseEnable + ",mMultiRNRuntimeProcessReuseDisable=" + this.mMultiRNRuntimeProcessReuseDisable);
                            if (!this.mRnProcessReuseEnable || this.mMultiRNRuntimeProcessReuseDisable) {
                                this.mMultiRNRuntimeProcessReuseDisable = false;
                            } else {
                                this.mCurrentPackageId = j;
                                return this.mCurrentProcess;
                            }
                        }
                    } else if (this.mCurrentProcess != null && this.mCurrentPackageId == j && isRNPlugin(O0000Oo) && fcx.f16092O000000o.O00000o0(str) && this.mRnProcessReuseEnable) {
                        return this.mCurrentProcess;
                    }
                }
                if (this.mCurrentRelations != null && isMpkPlugin) {
                    if (O00000oO != null) {
                        list = O00000oO.O000O0Oo();
                    }
                    if (list != null) {
                        for (String next : this.mCurrentRelations) {
                            Iterator<String> it = list.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (it.next().equals(next)) {
                                        return this.mCurrentProcess;
                                    }
                                }
                            }
                        }
                    }
                }
                RunningProcess runningProcess2 = this.mCurrentProcess;
                if (runningProcess2 != null) {
                    exitProcess(runningProcess2);
                }
                this.mCurrentProcess = this.mNextProcess;
                this.mCurrentPackageId = j;
                if (O00000oO != null) {
                    this.mCurrentRelations = O00000oO.O000O0Oo();
                }
                this.mNextProcess = getMainSelectProcess(this.mNextProcess);
                if (getBridgeApiProxy(this.mNextProcess) == null) {
                    Class pluginBridgeServiceClass2 = getPluginBridgeServiceClass(this.mNextProcess);
                    Intent intent2 = new Intent(this.mAppContext, pluginBridgeServiceClass2);
                    if (pluginBridgeServiceClass2 != null) {
                        this.mAppContext.bindService(intent2, new ServiceConnection() {
                            /* class com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager.AnonymousClass3 */
                            RunningProcess currentProcess = PluginRuntimeManager.this.mNextProcess;

                            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                                PluginRuntimeManager.this.setBridgeApiProxy("", this.currentProcess, IBridgeServiceApi.Stub.asInterface(iBinder));
                            }

                            public void onServiceDisconnected(ComponentName componentName) {
                                PluginRuntimeManager.this.setBridgeApiProxy("", this.currentProcess, null);
                                try {
                                    PluginRuntimeManager.this.mAppContext.unbindService(this);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                PluginRuntimeManager.this.processDiedProcess(this.currentProcess);
                            }
                        }, 1);
                    }
                }
                return this.mCurrentProcess;
            }
        } else if (processType != ProcessType.CAMERA_FRAME) {
            PluginPackageInfo O0000Oo2 = CoreApi.O000000o().O0000Oo(str);
            if (O0000Oo2 != null && O0000Oo2.O0000o0O()) {
                return RunningProcess.PLUGIN3;
            }
            RunningProcess runningProcess3 = this.mCurrentProcess;
            if (runningProcess3 == null || this.mCurrentPackageId != j) {
                return RunningProcess.PLUGIN3;
            }
            return runningProcess3;
        } else if (!ftm.O000000o(XmPluginHostApi.instance().context())) {
            gsy.O000000o(6, "PluginManagerFrame", "getPluginProcess is not in main process:" + ftm.f17102O000000o);
            return null;
        } else {
            PluginPackageInfo O0000Oo3 = CoreApi.O000000o().O0000Oo(str);
            if (O0000Oo3 == null) {
                gsy.O000000o(6, "PluginManagerFrame", "getPluginRecord return null:".concat(String.valueOf(str)));
                return null;
            }
            long O00000Oo = O0000Oo3.O00000Oo();
            if (this.mStartedCameraProcess.containsKey(Long.valueOf(O00000Oo))) {
                return this.mStartedCameraProcess.get(Long.valueOf(O00000Oo));
            }
            return chooseOneCameraProcess(O00000Oo);
        }
    }

    public void setRNProcessReuseDisable(int i) {
        gsy.O00000o0(LogType.PLUGIN, "rn-plugin-framework", "miot-rn-plugin", "setRNProcessReuseDisable true,".concat(String.valueOf(i)));
        this.mProcessReuseEnterType = i;
        this.mMultiRNRuntimeProcessReuseDisable = true;
    }

    private boolean isMpkPlugin(PluginPackageInfo pluginPackageInfo) {
        if (pluginPackageInfo == null) {
            return true;
        }
        return pluginPackageInfo.O0000o0();
    }

    private RunningProcess getPluginProcessInner(int i, String str) {
        if (str.equalsIgnoreCase("onemore.soundbox.sm001") || str.equalsIgnoreCase("desay.bleshoes.s311")) {
            return RunningProcess.PLUGIN3;
        }
        if (str.contains("xiaomi.tv") || "chuangmi.wifi.v1".equals(str)) {
            return RunningProcess.MAIN;
        }
        if (TextUtils.isEmpty(str)) {
            return RunningProcess.PLUGIN0;
        }
        if (!str.contains("camera")) {
            return RunningProcess.PLUGIN0;
        }
        if (!ftm.O000000o(XmPluginHostApi.instance().context())) {
            gsy.O000000o(6, "PluginManagerFrame", "getPluginProcess is not in main process:" + ftm.f17102O000000o);
            return null;
        }
        PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(str);
        if (O0000Oo == null) {
            gsy.O000000o(6, "PluginManagerFrame", "getPluginRecord return null:".concat(String.valueOf(str)));
            return null;
        }
        long O00000Oo = O0000Oo.O00000Oo();
        if (this.mStartedCameraProcess.containsKey(Long.valueOf(O00000Oo))) {
            return this.mStartedCameraProcess.get(Long.valueOf(O00000Oo));
        }
        return chooseOneCameraProcess(O00000Oo);
    }

    public Class getPluginActivityClass(RunningProcess runningProcess) {
        if (runningProcess == RunningProcess.PLUGIN0) {
            return PluginHostActivity.class;
        }
        if (runningProcess == RunningProcess.PLUGIN2) {
            return PluginHostActivityPlugin2.class;
        }
        if (runningProcess == RunningProcess.MAIN) {
            return PluginHostActivityMain.class;
        }
        if (runningProcess == RunningProcess.PLUGIN3) {
            return PluginHostActivityPlugin3.class;
        }
        if (runningProcess == RunningProcess.PLUGIN1) {
            return PluginHostActivityPlugin1.class;
        }
        return PluginHostActivity.class;
    }

    public String getPluginRNActivityClass(RunningProcess runningProcess) {
        if (runningProcess == RunningProcess.PLUGIN0) {
            return "com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity";
        }
        if (runningProcess == RunningProcess.PLUGIN2) {
            return "com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivityPlugin2";
        }
        if (runningProcess == RunningProcess.MAIN) {
            return "com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivityMain";
        }
        if (runningProcess == RunningProcess.PLUGIN3) {
            return "com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivityPlugin3";
        }
        if (runningProcess == RunningProcess.PLUGIN1) {
            return "com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivityPlugin1";
        }
        if (runningProcess == RunningProcess.PLUGIN4) {
            return "com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivityPlugin4";
        }
        if (runningProcess == RunningProcess.CAMERA) {
            return "com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivityCamera";
        }
        return "com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity";
    }

    public Class getPluginHostServiceClass(RunningProcess runningProcess, String str) {
        if (runningProcess == null || TextUtils.isEmpty(str) || runningProcess != RunningProcess.PLUGIN3 || !str.equalsIgnoreCase("onemore.soundbox.sm001")) {
            return null;
        }
        return PluginHostServiceOneMore.class;
    }

    public Class getPluginHostServiceClass(HostService hostService) {
        if (hostService == null) {
            return null;
        }
        if (hostService == HostService.OneMore) {
            return PluginHostServiceOneMore.class;
        }
        if (hostService == HostService.DesaiShoe) {
            return PluginHostServiceDesaiShoe.class;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public RunningProcess getProcess(int i, String str, DeviceStat deviceStat, RunningProcess runningProcess, boolean z) {
        ProcessType processType;
        if (i == 18 || i == 19 || i == 20 || i == 23 || i == 24 || i == 21) {
            processType = ProcessType.CAMERA_FRAME;
        } else if (i == 1 || i == 2) {
            processType = ProcessType.MAIN;
        } else if (!hsi.O000000o() || !gfr.O0000OoO) {
            processType = ProcessType.OTHER;
        } else {
            processType = ProcessType.MAIN;
        }
        RunningProcess pluginProcess = getInstance().getPluginProcess(processType, deviceStat != null ? deviceStat.pid : 0, str, z);
        if (pluginProcess == null) {
            pluginProcess = runningProcess;
        }
        return pluginProcess == null ? RunningProcess.PLUGIN0 : pluginProcess;
    }

    /* access modifiers changed from: package-private */
    public void killOtherCameraProcess(RunningProcess runningProcess) {
        Iterator it = new ArrayList(this.mStartedCameraProcess.keySet()).iterator();
        while (it.hasNext()) {
            if (this.mStartedCameraProcess.get((Long) it.next()) != runningProcess) {
                exitProcess(runningProcess);
            }
        }
    }

    public void exitAllFrameProcess() {
        for (RunningProcess exitProcess : RunningProcess.getFrameProcesses()) {
            exitProcess(exitProcess);
        }
    }

    private boolean isRNPlugin(PluginPackageInfo pluginPackageInfo) {
        if (pluginPackageInfo == null) {
            return false;
        }
        return pluginPackageInfo.O0000o0O();
    }

    /* access modifiers changed from: package-private */
    public void sendMessage(Context context, String str, int i, Intent intent, DeviceStat deviceStat, RunningProcess runningProcess, boolean z, SendMessageCallback sendMessageCallback) {
        if (isInnerCamera(str, CoreApi.O000000o().O0000Oo(str))) {
            fkl O000000o2 = fkl.O000000o();
            $$Lambda$PluginRuntimeManager$pjaR5R04S3oddGlNS4QQ_XhyMkg r0 = new fkd(context, str, i, intent, deviceStat, runningProcess, z, sendMessageCallback) {
                /* class com.xiaomi.smarthome.frame.plugin.$$Lambda$PluginRuntimeManager$pjaR5R04S3oddGlNS4QQ_XhyMkg */
                private final /* synthetic */ Context f$1;
                private final /* synthetic */ String f$2;
                private final /* synthetic */ int f$3;
                private final /* synthetic */ Intent f$4;
                private final /* synthetic */ DeviceStat f$5;
                private final /* synthetic */ RunningProcess f$6;
                private final /* synthetic */ boolean f$7;
                private final /* synthetic */ SendMessageCallback f$8;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                    this.f$5 = r6;
                    this.f$6 = r7;
                    this.f$7 = r8;
                    this.f$8 = r9;
                }

                public final void onPackageReady() {
                    PluginRuntimeManager.this.lambda$sendMessage$0$PluginRuntimeManager(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8);
                }
            };
            if (r0 == null) {
                return;
            }
            if (O000000o2.O00000Oo == null) {
                r0.onPackageReady();
            } else {
                O000000o2.O00000Oo.add(r0);
            }
        } else {
            lambda$sendMessage$0$PluginRuntimeManager(context, str, i, intent, deviceStat, runningProcess, z, sendMessageCallback);
        }
    }

    private boolean isInnerCamera(String str, PluginPackageInfo pluginPackageInfo) {
        return (pluginPackageInfo == null || !"rn".equalsIgnoreCase(pluginPackageInfo.O0000O0o())) && Arrays.binarySearch(DeviceConstant.supportNativePlugin(), str) >= 0;
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
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01e9  */
    /* renamed from: sendMessageInner */
    public void lambda$sendMessage$0$PluginRuntimeManager(Context context, String str, int i, Intent intent, DeviceStat deviceStat, RunningProcess runningProcess, boolean z, SendMessageCallback sendMessageCallback) {
        String str2;
        int i2;
        final RunningProcess runningProcess2;
        int i3;
        String string;
        RunningProcess runningProcess3;
        Context context2 = context;
        final String str3 = str;
        int i4 = i;
        final DeviceStat deviceStat2 = deviceStat;
        final SendMessageCallback sendMessageCallback2 = sendMessageCallback;
        Intent intent2 = intent == null ? new Intent() : intent;
        if (i4 == 1) {
            intent2.putExtra("plugin_init_time", System.currentTimeMillis());
        }
        PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(str3);
        if (isInnerCamera(str3, O0000Oo)) {
            gsy.O00000o0(LogType.CAMERA, "PluginManagerFrame", "msgType:" + i4 + " model:" + str3);
            Intent intent3 = new Intent();
            if (i4 == 1) {
                intent3.setAction("com.xiaomi.smarthome.camera.LANUCH");
            } else if (i4 == 2) {
                intent3.setAction("com.xiaomi.smarthome.camera.PUSH_MSG");
            } else if (i4 == 18) {
                intent3.setAction("com.xiaomi.smarthome.camera.INIT_CAMERA_FRAME_SENDER");
            } else if (i4 == 19) {
                intent3.setAction("com.xiaomi.smarthome.camera.STAR_REQUEST_CAMERA_FRAME");
            } else if (i4 == 20) {
                intent3.setAction("com.xiaomi.smarthome.camera.STOP_REQUEST_CAMERA_FRAME");
            } else if (i4 == 21) {
                intent3.setAction("com.xiaomi.smarthome.camera.DESTROY_REQUEST_CAMERA_FRAME");
            } else if (i4 == 3) {
                intent3.setAction("com.xiaomi.smarthome.camera.MSG_GET_SCENE_VALUE");
            } else if (i4 == 23) {
                intent3.setAction("com.xiaomi.smarthome.camera.MSG_START_AUDIO_CALL");
            } else if (i4 == 24) {
                intent3.setAction("com.xiaomi.smarthome.camera.MSG_STOP_AUDIO_CALL");
            }
            intent3.setPackage(context.getPackageName());
            if (deviceStat2 != null) {
                intent3.putExtra("extra_device_did", deviceStat2.did);
            }
            intent3.putExtra("extra_device_model", str3);
            intent3.putExtras(intent2);
            if (z) {
                ft.O000000o(this.mAppContext).O000000o(new BroadcastReceiver() {
                    /* class com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager.AnonymousClass4 */

                    public void onReceive(Context context, Intent intent) {
                        Bundle extras = intent.getExtras();
                        if (extras != null) {
                            String string = extras.getString("extra_device_did", null);
                            String string2 = extras.getString("extra_device_model", null);
                            DeviceStat deviceStat = deviceStat2;
                            if (TextUtils.equals(deviceStat == null ? "" : deviceStat.did, string) && TextUtils.equals(str3, string2)) {
                                if (sendMessageCallback2 != null) {
                                    try {
                                        gsy.O00000Oo("PluginManagerFrame", "camera-native-plugin 退出自动化场景...");
                                        if (extras.getBoolean("isSaveEntrance", false)) {
                                            sendMessageCallback2.onMessageSuccess(intent);
                                        } else {
                                            sendMessageCallback2.onMessageFailure(-1, "native plugin entrance cancel");
                                        }
                                    } catch (Exception e) {
                                        gsy.O00000Oo("PluginManagerFrame", e.toString());
                                    }
                                }
                                ft.O000000o(PluginRuntimeManager.this.mAppContext).O000000o(this);
                            }
                        }
                    }
                }, new IntentFilter("scene_action_plugin"));
            }
            context2.sendBroadcast(intent3);
            if (sendMessageCallback2 != null) {
                sendMessageCallback2.onSendSuccess(null);
                return;
            }
            return;
        }
        RunningProcess runningProcess4 = null;
        if (!"miuiP0".equals(getFromWhereByIntent(intent2)) && i4 == 2 && O0000Oo != null && !"/device/setting_update".equals(intent2.getStringExtra("inner_jump")) && O0000Oo.O00000Oo() == this.mCurrentPackageId && this.mCurrentProcess != null && isRNPlugin(O0000Oo)) {
            try {
                IBridgeServiceApi bridgeApiProxy = getBridgeApiProxy(this.mCurrentProcess);
                if (bridgeApiProxy != null && bridgeApiProxy.isRnActivityReuseAvailable()) {
                    runningProcess3 = this.mCurrentProcess;
                    try {
                        intent2.putExtra("extra_start_rnplugin_activity", false);
                        HashMap hashMap = new HashMap();
                        hashMap.put("activity_enter_type", 1);
                        hxi.O0000Ooo.O000000o("rn_plugin_framework", "rn_plugin_activity_reuse", hashMap);
                        gsy.O00000Oo("PluginManagerFrame", "sendMessage: RN push message, plugin is running foreground, reuse mCurrentProcess");
                    } catch (RemoteException e) {
                        e = e;
                    }
                    runningProcess4 = runningProcess3;
                }
            } catch (RemoteException e2) {
                e = e2;
                runningProcess3 = null;
                gsy.O00000Oo("PluginManagerFrame", "sendMessage:".concat(String.valueOf(e)));
                runningProcess4 = runningProcess3;
                string = intent.getExtras().getString("source_tag");
                if (!TextUtils.equals("short_cut", string)) {
                }
                if (runningProcess4 != null) {
                }
                if (i4 != i2) {
                }
                if (checkPluginProcess(runningProcess2)) {
                }
            }
        }
        if (!(runningProcess4 != null || intent == null || intent.getExtras() == null)) {
            string = intent.getExtras().getString("source_tag");
            if (!TextUtils.equals("short_cut", string)) {
                this.mProcessReuseEnterType = 6;
            } else if (TextUtils.equals("send_print", string)) {
                this.mProcessReuseEnterType = 7;
            }
        }
        if (runningProcess4 != null) {
            this.mRnProcessReuseEnable = intent2.getBooleanExtra("optReuseProcessEnable", true);
            i2 = 18;
            str2 = "PluginManagerFrame";
            runningProcess4 = getProcess(i, str, deviceStat, runningProcess, false);
        } else {
            str2 = "PluginManagerFrame";
            i2 = 18;
        }
        runningProcess2 = ((i4 != i2 || i4 == 19 || i4 == 20 || i4 == 21 || i4 == 24 || i4 == 23) && intent2.getBooleanExtra("run_on_main", true)) ? RunningProcess.MAIN : runningProcess4;
        if (checkPluginProcess(runningProcess2)) {
            if (sendMessageCallback2 != null) {
                sendMessageCallback2.onSendFailure(new fso(-1, context2.getString(R.string.service_error)));
            }
            gsy.O00000o0(LogType.PLUGIN, "rn-plugin-framework", "miot-rn-plugin", "PluginRuntimeManager.sendMessage checkPluginProcess false");
            return;
        }
        if (isRNPlugin(O0000Oo)) {
            if (!this.mRnProcessReuseEnable) {
                i3 = 3;
                this.mProcessReuseEnterType = 3;
            } else {
                i3 = 3;
            }
            intent2.putExtra("process_reuse_enter_type", this.mProcessReuseEnterType);
            this.mProcessReuseEnterType = 0;
        } else {
            i3 = 3;
        }
        String str4 = str2;
        gsy.O000000o(i3, str4, str3 + " sendMessage RunningProcess:" + runningProcess2.getValue());
        IBridgeServiceApi bridgeApiProxy2 = getBridgeApiProxy(runningProcess2);
        if (bridgeApiProxy2 == null) {
            Class pluginBridgeServiceClass = getPluginBridgeServiceClass(runningProcess2);
            if (pluginBridgeServiceClass == null) {
                if (sendMessageCallback2 != null) {
                    sendMessageCallback2.onSendFailure(new fso(-1, context2.getString(R.string.code_streammuch_error)));
                }
                gsy.O00000Oo(LogType.PLUGIN, "click_device_list", "PluginRuntimeManager.sendMessage clazz is null");
                return;
            }
            gsy.O000000o(i3, str4, "BridgeServiceClass:" + pluginBridgeServiceClass.getName());
            gsy.O00000o0(LogType.PLUGIN, "rn-plugin-framework", "miot-rn-plugin", "mIot-rn-plugin-framework --> sendMessage will start service " + pluginBridgeServiceClass.getName());
            final String str5 = str;
            final int i5 = i;
            final Intent intent4 = intent2;
            final DeviceStat deviceStat3 = deviceStat;
            final boolean z2 = z;
            this.mAppContext.bindService(new Intent(this.mAppContext, pluginBridgeServiceClass), new BridgeServiceConnection(sendMessageCallback) {
                /* class com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager.AnonymousClass5 */

                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    gsy.O000000o(3, "PluginManagerFrame", "onServiceConnected:".concat(String.valueOf(componentName)));
                    gsy.O00000o0(LogType.PLUGIN, "rn-plugin-framework", "miot-rn-plugin", "mIot-rn-plugin-framework --> sendMessage onServiceConnected ".concat(String.valueOf(componentName)));
                    IBridgeServiceApi asInterface = IBridgeServiceApi.Stub.asInterface(iBinder);
                    PluginRuntimeManager.this.setBridgeApiProxy(str5, runningProcess2, asInterface);
                    SendMessageCallback sendMessageCallback = this.mSendCallback;
                    this.mSendCallback = null;
                    PluginRuntimeManager.this.sendMessageWithProx(asInterface, str5, i5, intent4, deviceStat3, z2, sendMessageCallback);
                }

                public void onServiceDisconnected(ComponentName componentName) {
                    gsy.O000000o(3, "PluginManagerFrame", "onServiceDisconnected:".concat(String.valueOf(componentName)));
                    gsy.O00000o0(LogType.PLUGIN, "rn-plugin-framework", "miot-rn-plugin", "mIot-rn-plugin-framework --> sendMessage onServiceDisconnected ".concat(String.valueOf(componentName)));
                    PluginRuntimeManager.this.setBridgeApiProxy(str5, runningProcess2, null);
                    try {
                        PluginRuntimeManager.this.mAppContext.unbindService(this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    gsy.O00000Oo(LogType.PLUGIN, "click_device_list", "PluginRuntimeManager.sendMessage-bindService-onServiceDisconnected");
                }
            }, 1);
            return;
        }
        sendMessageWithProx(bridgeApiProxy2, str, i, intent2, deviceStat, z, sendMessageCallback);
    }

    static class SendMessageCallbackWrapper {
        SendMessageCallback mCallback;

        SendMessageCallbackWrapper(SendMessageCallback sendMessageCallback) {
            this.mCallback = sendMessageCallback;
        }
    }

    private String getFromWhereByIntent(Intent intent) {
        return intent == null ? "" : intent.getStringExtra("from_where");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b  */
    public void sendMessageWithProx(IBridgeServiceApi iBridgeServiceApi, String str, int i, Intent intent, DeviceStat deviceStat, boolean z, SendMessageCallback sendMessageCallback) {
        SendMessageCallback sendMessageCallback2 = sendMessageCallback;
        try {
            gsy.O00000o0(LogType.PLUGIN, "rn-plugin-framework", "miot-rn-plugin", "mIot-rn-plugin-framework --> sendMessage sendMessageWithProx ");
            final SendMessageCallbackWrapper sendMessageCallbackWrapper = new SendMessageCallbackWrapper(sendMessageCallback2);
            try {
                iBridgeServiceApi.sendMessage(str, deviceStat, i, intent, z, new IBridgeCallback.Stub() {
                    /* class com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager.AnonymousClass6 */

                    public void onSendSuccess(Bundle bundle) throws RemoteException {
                        SendMessageCallback sendMessageCallback = sendMessageCallbackWrapper.mCallback;
                        if (sendMessageCallback != null) {
                            if (bundle != null) {
                                bundle.setClassLoader(PluginRuntimeManager.class.getClassLoader());
                            }
                            sendMessageCallback.onSendSuccess(bundle);
                        }
                    }

                    public void onHandle(boolean z) throws RemoteException {
                        SendMessageCallback sendMessageCallback = sendMessageCallbackWrapper.mCallback;
                        if (sendMessageCallback != null) {
                            sendMessageCallback.onMessageHandle(z);
                        }
                    }

                    public void onMessageSuccess(Bundle bundle) throws RemoteException {
                        SendMessageCallback sendMessageCallback = sendMessageCallbackWrapper.mCallback;
                        if (sendMessageCallback != null) {
                            Intent intent = new Intent();
                            if (bundle != null) {
                                bundle.setClassLoader(PluginRuntimeManager.class.getClassLoader());
                                intent.putExtras(bundle);
                            }
                            sendMessageCallback.onMessageSuccess(intent);
                        }
                    }

                    public void onMessageFailure(BridgeError bridgeError) throws RemoteException {
                        SendMessageCallback sendMessageCallback = sendMessageCallbackWrapper.mCallback;
                        if (sendMessageCallback != null) {
                            sendMessageCallback.onMessageFailure(bridgeError.getCode(), bridgeError.getDetail());
                        }
                        if (bridgeError != null) {
                            LogType logType = LogType.PLUGIN;
                            gsy.O00000o0(logType, "rn-plugin-framework", "miot-rn-plugin", "mIot-rn-plugin-framework --> sendMessage sendMessageWithProx onMessageFailure " + bridgeError.getDetail());
                            return;
                        }
                        gsy.O00000o0(LogType.PLUGIN, "rn-plugin-framework", "miot-rn-plugin", "mIot-rn-plugin-framework --> sendMessage sendMessageWithProx onMessageFailure ");
                    }

                    public void onFailure(BridgeError bridgeError) throws RemoteException {
                        SendMessageCallback sendMessageCallback = sendMessageCallbackWrapper.mCallback;
                        if (sendMessageCallback != null) {
                            sendMessageCallback.onSendFailure(new fso(bridgeError.getCode(), bridgeError.getDetail()));
                        }
                        if (bridgeError != null) {
                            LogType logType = LogType.PLUGIN;
                            gsy.O00000o0(logType, "rn-plugin-framework", "miot-rn-plugin", "mIot-rn-plugin-framework --> sendMessage sendMessageWithProx onFailure " + bridgeError.getDetail());
                            return;
                        }
                        gsy.O00000o0(LogType.PLUGIN, "rn-plugin-framework", "miot-rn-plugin", "mIot-rn-plugin-framework --> sendMessage sendMessageWithProx onFailure ");
                    }
                });
            } catch (Throwable th) {
                th = th;
                if (sendMessageCallback2 != null) {
                    sendMessageCallback2.onSendFailure(new fso(-1, CommonApplication.getAppContext().getString(R.string.code_unknown_error)));
                }
                LogType logType = LogType.PLUGIN;
                gsy.O00000o0(logType, "rn-plugin-framework", "miot-rn-plugin", "mIot-rn-plugin-framework --> sendMessage sendMessageWithProx catch " + Log.getStackTraceString(th));
            }
        } catch (Throwable th2) {
            th = th2;
            if (sendMessageCallback2 != null) {
            }
            LogType logType2 = LogType.PLUGIN;
            gsy.O00000o0(logType2, "rn-plugin-framework", "miot-rn-plugin", "mIot-rn-plugin-framework --> sendMessage sendMessageWithProx catch " + Log.getStackTraceString(th));
        }
    }

    public void initCameraProcess() {
        if (getBridgeApiProxy(RunningProcess.getCameraProcesses()) == null && getBridgeApiProxy(RunningProcess.getCameraProcesses()) == null) {
            Class pluginBridgeServiceClass = getPluginBridgeServiceClass(RunningProcess.CAMERA);
            Intent intent = new Intent(this.mAppContext, pluginBridgeServiceClass);
            if (pluginBridgeServiceClass != null) {
                this.mAppContext.bindService(intent, new ServiceConnection() {
                    /* class com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager.AnonymousClass7 */

                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        PluginRuntimeManager.this.setBridgeApiProxy("", RunningProcess.CAMERA, IBridgeServiceApi.Stub.asInterface(iBinder));
                    }

                    public void onServiceDisconnected(ComponentName componentName) {
                        PluginRuntimeManager.this.setBridgeApiProxy("", RunningProcess.CAMERA, null);
                        try {
                            PluginRuntimeManager.this.mAppContext.unbindService(this);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        PluginRuntimeManager.this.processDiedProcess(RunningProcess.PLUGIN0);
                    }
                }, 1);
            }
        }
    }

    public void initOneProgress() {
        RunningProcess runningProcess = this.mCurrentProcess;
        if (!(runningProcess == null || this.mNextProcess == null)) {
            if (getBridgeApiProxy(runningProcess) == null) {
                this.mNextProcess = null;
                this.mCurrentProcess = null;
            } else {
                return;
            }
        }
        if (getBridgeApiProxy(RunningProcess.PLUGIN0) == null) {
            Class pluginBridgeServiceClass = getPluginBridgeServiceClass(RunningProcess.PLUGIN0);
            Intent intent = new Intent(this.mAppContext, pluginBridgeServiceClass);
            if (pluginBridgeServiceClass != null) {
                this.mAppContext.bindService(intent, new ServiceConnection() {
                    /* class com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager.AnonymousClass8 */

                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        PluginRuntimeManager.this.setBridgeApiProxy("", RunningProcess.PLUGIN0, IBridgeServiceApi.Stub.asInterface(iBinder));
                    }

                    public void onServiceDisconnected(ComponentName componentName) {
                        PluginRuntimeManager.this.setBridgeApiProxy("", RunningProcess.PLUGIN0, null);
                        try {
                            PluginRuntimeManager.this.mAppContext.unbindService(this);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        PluginRuntimeManager.this.processDiedProcess(RunningProcess.PLUGIN0);
                    }
                }, 1);
            }
        }
    }

    public void initPluginPadProcess() {
        if (hyy.O000000o() && getBridgeApiProxy(RunningProcess.PLUGIN4) == null && getBridgeApiProxy(RunningProcess.PLUGIN4) == null) {
            Class pluginBridgeServiceClass = getPluginBridgeServiceClass(RunningProcess.PLUGIN4);
            Intent intent = new Intent(this.mAppContext, pluginBridgeServiceClass);
            if (pluginBridgeServiceClass != null) {
                this.mAppContext.bindService(intent, new ServiceConnection() {
                    /* class com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager.AnonymousClass9 */

                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        PluginRuntimeManager.this.setBridgeApiProxy("", RunningProcess.PLUGIN4, IBridgeServiceApi.Stub.asInterface(iBinder));
                    }

                    public void onServiceDisconnected(ComponentName componentName) {
                        PluginRuntimeManager.this.setBridgeApiProxy("", RunningProcess.PLUGIN4, null);
                        try {
                            PluginRuntimeManager.this.mAppContext.unbindService(this);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, 1);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void startService(RunningProcess runningProcess, String str, long j, long j2, Intent intent, String str2, PluginApi.StartServiceCallback startServiceCallback) {
        PluginApi.StartServiceCallback startServiceCallback2 = startServiceCallback;
        if (checkPluginProcess(runningProcess)) {
            IBridgeServiceApi bridgeApiProxy = getBridgeApiProxy(runningProcess);
            if (bridgeApiProxy == null) {
                Class pluginBridgeServiceClass = getPluginBridgeServiceClass(runningProcess);
                if (pluginBridgeServiceClass != null) {
                    final RunningProcess runningProcess2 = runningProcess;
                    final String str3 = str;
                    final long j3 = j;
                    final long j4 = j2;
                    final Intent intent2 = intent;
                    final String str4 = str2;
                    final PluginApi.StartServiceCallback startServiceCallback3 = startServiceCallback;
                    this.mAppContext.bindService(new Intent(this.mAppContext, pluginBridgeServiceClass), new ServiceConnection() {
                        /* class com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager.AnonymousClass10 */

                        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                            boolean z;
                            IBridgeServiceApi asInterface = IBridgeServiceApi.Stub.asInterface(iBinder);
                            PluginRuntimeManager.this.setBridgeApiProxy("", runningProcess2, asInterface);
                            try {
                                asInterface.startService(str3, j3, j4, intent2, str4);
                                z = false;
                            } catch (RemoteException unused) {
                                z = true;
                            }
                            if (z) {
                                PluginApi.StartServiceCallback startServiceCallback = startServiceCallback3;
                                if (startServiceCallback != null) {
                                    startServiceCallback.onFailure(new fso(-1, ""));
                                    return;
                                }
                                return;
                            }
                            PluginApi.StartServiceCallback startServiceCallback2 = startServiceCallback3;
                            if (startServiceCallback2 != null) {
                                startServiceCallback2.onSuccess();
                            }
                        }

                        public void onServiceDisconnected(ComponentName componentName) {
                            PluginRuntimeManager.this.setBridgeApiProxy("", runningProcess2, null);
                            try {
                                PluginRuntimeManager.this.mAppContext.unbindService(this);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            PluginApi.StartServiceCallback startServiceCallback = startServiceCallback3;
                            if (startServiceCallback != null) {
                                startServiceCallback.onFailure(new fso(-1, ""));
                            }
                        }
                    }, 1);
                } else if (startServiceCallback2 != null) {
                    startServiceCallback2.onFailure(new fso(-1, ""));
                }
            } else {
                boolean z = false;
                try {
                    bridgeApiProxy.startService(str, j, j2, intent, str2);
                } catch (RemoteException unused) {
                    z = true;
                }
                if (z) {
                    if (startServiceCallback2 != null) {
                        startServiceCallback2.onFailure(new fso(-1, ""));
                    }
                } else if (startServiceCallback2 != null) {
                    startServiceCallback.onSuccess();
                }
            }
        } else if (startServiceCallback2 != null) {
            startServiceCallback2.onFailure(new fso(-1, ""));
        }
    }

    /* access modifiers changed from: package-private */
    public void bindService(RunningProcess runningProcess, String str, long j, long j2, String str2, ServiceConnection serviceConnection, int i, PluginApi.BindServiceCallback bindServiceCallback) {
        final String str3 = str;
        final ServiceConnection serviceConnection2 = serviceConnection;
        final int i2 = i;
        final PluginApi.BindServiceCallback bindServiceCallback2 = bindServiceCallback;
        startService(runningProcess, str3, j, j2, null, str2, new PluginApi.StartServiceCallback() {
            /* class com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager.AnonymousClass11 */

            public void onSuccess() {
                Intent intent = new Intent();
                intent.setClassName(PluginRuntimeManager.this.mAppContext.getPackageName(), str3);
                if (PluginRuntimeManager.this.mAppContext.bindService(intent, serviceConnection2, i2)) {
                    PluginApi.BindServiceCallback bindServiceCallback = bindServiceCallback2;
                    if (bindServiceCallback != null) {
                        bindServiceCallback.onSuccess();
                        return;
                    }
                    return;
                }
                PluginApi.BindServiceCallback bindServiceCallback2 = bindServiceCallback2;
                if (bindServiceCallback2 != null) {
                    bindServiceCallback2.onFailure(new fso(-1, ""));
                }
            }

            public void onFailure(fso fso) {
                PluginApi.BindServiceCallback bindServiceCallback = bindServiceCallback2;
                if (bindServiceCallback != null) {
                    bindServiceCallback.onFailure(fso);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void unbindService(RunningProcess runningProcess, String str, long j, long j2, String str2, ServiceConnection serviceConnection, PluginApi.UnBindServiceCallback unBindServiceCallback) {
        if (serviceConnection != null) {
            try {
                this.mAppContext.unbindService(serviceConnection);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (unBindServiceCallback != null) {
                unBindServiceCallback.onSuccess();
            }
        } else if (unBindServiceCallback != null) {
            unBindServiceCallback.onFailure(new fso(-1, "ServiceConnection is null"));
        }
    }

    public void exitALLProcess() {
        RunningProcess[] runningProcessArr = {RunningProcess.PLUGIN0, RunningProcess.PLUGIN1, RunningProcess.CAMERA, RunningProcess.PLUGIN2, RunningProcess.PLUGIN3, RunningProcess.PLUGIN4, RunningProcess.FRAME1, RunningProcess.FRAME2};
        for (int i = 0; i < 8; i++) {
            exitProcess(runningProcessArr[i]);
        }
    }

    /* access modifiers changed from: package-private */
    public void exitProcess(RunningProcess runningProcess) {
        if (runningProcess != null) {
            IBridgeServiceApi bridgeApiProxy = getBridgeApiProxy(runningProcess);
            if (bridgeApiProxy != null) {
                try {
                    bridgeApiProxy.exitProcess();
                } catch (RemoteException unused) {
                }
            }
            for (Long next : this.mStartedCameraProcess.keySet()) {
                if (this.mStartedCameraProcess.get(next) == runningProcess) {
                    this.mStartedCameraProcess.remove(next);
                    return;
                }
            }
        }
    }

    abstract class BridgeServiceConnection implements ServiceConnection {
        SendMessageCallback mSendCallback;

        BridgeServiceConnection(SendMessageCallback sendMessageCallback) {
            this.mSendCallback = sendMessageCallback;
        }
    }
}
