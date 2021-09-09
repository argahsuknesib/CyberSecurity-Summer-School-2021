package com.xiaomi.smarthome.frame.plugin.runtime.bridge;

import _m_j.exz;
import _m_j.fcx;
import _m_j.fky;
import _m_j.fsp;
import _m_j.fsr;
import _m_j.ft;
import _m_j.ftc;
import _m_j.gfr;
import _m_j.gpq;
import _m_j.gsy;
import _m_j.hxh;
import _m_j.hyd;
import _m_j.hyy;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.plugin.core.XmPluginPackage;
import com.xiaomi.smarthome.ExternalLoadManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.core.server.internal.plugin.DynamicFeatureManager;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.MessageCallback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.IBridgeCallback;
import com.xiaomi.smarthome.frame.plugin.IBridgeServiceApi;
import com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager;
import com.xiaomi.smarthome.frame.plugin.RunningProcess;
import com.xiaomi.smarthome.frame.plugin.debug.PluginErrorInfoActivity;
import com.xiaomi.smarthome.frame.plugin.host.PluginHostApi;
import com.xiaomi.smarthome.frame.plugin.rn.debugmock.MockRnDevicePluginManager;
import com.xiaomi.smarthome.frame.plugin.runtime.activity.IPluginRnActivity;
import com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivity;
import com.xiaomi.smarthome.frame.plugin.runtime.service.StartServiceRecord;
import com.xiaomi.smarthome.library.log.LogType;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class PluginBridgeService extends Service {
    public static AtomicInteger activityCount = null;
    static Map<String, DeviceStat> mCacheDeviceMap = new ConcurrentHashMap();
    public static volatile long mLoadTime = 0;
    static Map<String, StartServiceRecord> mStartServiceRecordMap = new ConcurrentHashMap();
    public static int msgType;
    public static RunningProcess process;
    Context mAppContext;
    public volatile long mLauncherTime = 0;
    public volatile long mOpenTime = 0;
    public Stack<WeakReference<Activity>> mPluginActivityStack = new Stack<>();
    public volatile boolean mProcessForeground;
    public volatile boolean mSendBroadcastToFinishLoadingRnActivity = false;
    IBridgeServiceApi.Stub mStub = new IBridgeServiceApi.Stub() {
        /* class com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService.AnonymousClass1 */

        public void sendMessage(String str, DeviceStat deviceStat, int i, Intent intent, boolean z, IBridgeCallback iBridgeCallback) throws RemoteException {
            final int i2 = i;
            PluginBridgeService.this.resetData();
            PluginBridgeService.msgType = i2;
            StringBuilder sb = new StringBuilder("sendMessage in  isCoreReady=");
            sb.append(CoreApi.O000000o().O0000O0o());
            sb.append(",isPluginCacheReady=");
            sb.append(CoreApi.O000000o().O0000OOo());
            sb.append(" msgType:");
            sb.append(i);
            sb.append(" model:");
            final String str2 = str;
            sb.append(str);
            gsy.O00000Oo("PluginBridgeService", sb.toString());
            final Intent intent2 = intent;
            final DeviceStat deviceStat2 = deviceStat;
            final IBridgeCallback iBridgeCallback2 = iBridgeCallback;
            final boolean z2 = z;
            CoreApi.O000000o().O000000o(PluginBridgeService.this.mAppContext, new CoreApi.O0000o0() {
                /* class com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService.AnonymousClass1.AnonymousClass1 */

                public void onCoreReady() {
                    gsy.O00000Oo("PluginStartTime", "PluginBridgeService  " + System.currentTimeMillis());
                    CoreApi.O000000o().O000000o(PluginBridgeService.this.mAppContext, new CoreApi.O0000o() {
                        /* class com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                        public void onPluginCacheReady() {
                            PluginBridgeService.this.mWorkerHandler.post(new Runnable() {
                                /* class com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService.AnonymousClass1.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                public void run() {
                                    gsy.O000000o(6, "Device_Renderer", str2 + ", 2 - " + System.currentTimeMillis());
                                    final PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str2);
                                    PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(str2);
                                    if (O0000Oo == null && ((gfr.O0000OOo || gfr.O0000Oo) && intent2.getBooleanExtra("rn_native_debug_model", false))) {
                                        MockRnDevicePluginManager.getInstance().addMockInfo(deviceStat2);
                                        O0000Oo = CoreApi.O000000o().O0000Oo(str2);
                                    }
                                    final PluginPackageInfo pluginPackageInfo = O0000Oo;
                                    if (O00000oO == null) {
                                        if (iBridgeCallback2 != null) {
                                            try {
                                                iBridgeCallback2.onFailure(new BridgeError(-1, PluginBridgeService.this.mAppContext.getString(R.string.downerror_infoerror)));
                                            } catch (RemoteException unused) {
                                            }
                                        }
                                        gsy.O00000Oo(LogType.PLUGIN, "click_device_list", "PluginBridgerService.onPluginCacheReady record is null");
                                    } else if (DynamicFeatureManager.instance.isDynamicFeature(O00000oO.O00000Oo())) {
                                        DynamicFeatureManager.instance.installPlugin(O00000oO.O00000Oo(), new DynamicFeatureManager.O000000o(O00000oO.O00000Oo()) {
                                            /* class com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService.AnonymousClass1.AnonymousClass1.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                            public void onSuccess(String str, PluginPackageInfo pluginPackageInfo) {
                                                AnonymousClass1.this.loadApk(pluginPackageInfo, O00000oO, str2, i2, deviceStat2, intent2, z2, iBridgeCallback2);
                                            }

                                            public void onFailure(String str, int i) {
                                                try {
                                                    iBridgeCallback2.onFailure(new BridgeError(-1, "not installed"));
                                                } catch (RemoteException unused) {
                                                }
                                            }
                                        });
                                    } else if (pluginPackageInfo == null) {
                                        if (iBridgeCallback2 != null) {
                                            try {
                                                iBridgeCallback2.onFailure(new BridgeError(-1, PluginBridgeService.this.mAppContext.getString(R.string.error_open_noplugin)));
                                            } catch (RemoteException unused2) {
                                            }
                                        }
                                        gsy.O00000Oo(LogType.PLUGIN, "click_device_list", "PluginBridgerService.onPluginCacheReady record not installed");
                                    } else {
                                        if (i2 == 1) {
                                            PluginBridgeService.this.mUiHandler.post(new Runnable() {
                                                /* class com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService.AnonymousClass1.AnonymousClass1.AnonymousClass1.AnonymousClass1.AnonymousClass2 */

                                                public void run() {
                                                    if (intent2 != null) {
                                                        intent2.setExtrasClassLoader(PluginBridgeService.this.getClassLoader());
                                                        PluginBridgeService.this.mOpenTime = intent2.getLongExtra("plugin_init_time", 0);
                                                    }
                                                }
                                            });
                                        }
                                        PluginBridgeService.mLoadTime = 0;
                                        gsy.O00000Oo("install_package_path", pluginPackageInfo.O00000o());
                                        if (pluginPackageInfo.O0000o0O() || fcx.f16092O000000o.O000000o(str2)) {
                                            ((PluginHostApi) PluginHostApi.instance()).ensureService(new Callback() {
                                                /* class com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService.AnonymousClass1.AnonymousClass1.AnonymousClass1.AnonymousClass1.AnonymousClass3 */

                                                public void onFailure(int i, String str) {
                                                }

                                                public void onSuccess(Object obj) {
                                                    PluginBridgeService.this.mUiHandler.post(new Runnable() {
                                                        /* class com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService.AnonymousClass1.AnonymousClass1.AnonymousClass1.AnonymousClass1.AnonymousClass3.AnonymousClass1 */

                                                        public void run() {
                                                            if (deviceStat2 != null && !TextUtils.isEmpty(deviceStat2.did)) {
                                                                PluginBridgeService.this.loadRN(pluginPackageInfo, O00000oO, i2, deviceStat2, intent2, z2, iBridgeCallback2);
                                                            }
                                                        }
                                                    });
                                                }
                                            });
                                        } else if (pluginPackageInfo.O0000o0()) {
                                            AnonymousClass1.this.loadApk(pluginPackageInfo, O00000oO, str2, i2, deviceStat2, intent2, z2, iBridgeCallback2);
                                        }
                                    }
                                }
                            });
                        }
                    });
                }
            });
        }

        public void loadApk(PluginPackageInfo pluginPackageInfo, PluginDeviceInfo pluginDeviceInfo, String str, int i, DeviceStat deviceStat, Intent intent, boolean z, IBridgeCallback iBridgeCallback) {
            Intent intent2 = intent;
            IBridgeCallback iBridgeCallback2 = iBridgeCallback;
            final XmPluginPackage xmPluginPackage = PluginRuntimeManager.getInstance().getXmPluginPackage(pluginPackageInfo);
            if (xmPluginPackage == null || xmPluginPackage.xmPluginMessageReceiver == null) {
                if (iBridgeCallback2 != null) {
                    try {
                        iBridgeCallback2.onFailure(new BridgeError(-1, PluginBridgeService.this.mAppContext.getString(R.string.error_no_receiver)));
                    } catch (RemoteException unused) {
                    }
                }
                gsy.O00000Oo(LogType.PLUGIN, "click_device_list", "PluginBridgerService.onPluginCacheReady xmPluginMessageReceiver is null");
                return;
            }
            try {
                PluginRuntimeManager.clearViewBuffer();
                if (intent2 != null) {
                    intent2.setExtrasClassLoader(xmPluginPackage.getClassLoader());
                }
                final int i2 = i;
                final Intent intent3 = intent;
                final DeviceStat deviceStat2 = deviceStat;
                final IBridgeCallback iBridgeCallback3 = iBridgeCallback;
                final String str2 = str;
                final boolean z2 = z;
                ((PluginHostApi) PluginHostApi.instance()).ensureService(new Callback() {
                    /* class com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService.AnonymousClass1.AnonymousClass2 */

                    public void onFailure(int i, String str) {
                    }

                    public void onSuccess(Object obj) {
                        PluginBridgeService.this.mUiHandler.post(new Runnable() {
                            /* class com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService.AnonymousClass1.AnonymousClass2.AnonymousClass1 */

                            /* JADX WARNING: Can't wrap try/catch for region: R(13:10|11|12|(1:14)|15|16|(2:18|19)(1:20)|21|(2:23|24)|25|26|(2:28|29)|(3:32|33|49)(1:50)) */
                            /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0102 */
                            /* JADX WARNING: Removed duplicated region for block: B:28:0x0108 A[SYNTHETIC, Splitter:B:28:0x0108] */
                            /* JADX WARNING: Removed duplicated region for block: B:32:0x0113 A[SYNTHETIC, Splitter:B:32:0x0113] */
                            /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
                            public void run() {
                                int i;
                                boolean z;
                                boolean z2;
                                int i2 = i2;
                                if (2 != i2 || intent3 == null || !"/device/setting_update".equals(intent3.getStringExtra("inner_jump"))) {
                                    z = false;
                                    i = i2;
                                } else {
                                    z = true;
                                    i = 1;
                                }
                                if (deviceStat2 != null) {
                                    ((PluginHostApi) PluginHostApi.instance()).setCurrentDid(deviceStat2.did);
                                    PluginBridgeService.mCacheDeviceMap.put(deviceStat2.did, deviceStat2);
                                    try {
                                        gsy.O000000o(6, "Device_Renderer", str2 + ", 3 - " + System.currentTimeMillis());
                                        if (i == 1) {
                                            PluginBridgeService.this.mLauncherTime = System.currentTimeMillis();
                                        }
                                        if (z2) {
                                            z2 = xmPluginPackage.xmPluginMessageReceiver.handleMessage(PluginBridgeService.this.mAppContext, xmPluginPackage, i, intent3, deviceStat2, new MessageCallback() {
                                                /* class com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService.AnonymousClass1.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                                public void onSuccess(Intent intent) {
                                                    if (iBridgeCallback3 != null) {
                                                        try {
                                                            iBridgeCallback3.onMessageSuccess(intent.getExtras());
                                                        } catch (RemoteException unused) {
                                                        }
                                                    }
                                                }

                                                public void onFailure(int i, String str) {
                                                    if (iBridgeCallback3 != null) {
                                                        try {
                                                            iBridgeCallback3.onMessageFailure(new BridgeError(i, str));
                                                        } catch (RemoteException unused) {
                                                        }
                                                    }
                                                }
                                            });
                                            gsy.O00000Oo("PluginStartTime", "PluginMessageReceiverWitchCallback  " + System.currentTimeMillis());
                                        } else {
                                            z2 = xmPluginPackage.xmPluginMessageReceiver.handleMessage(PluginBridgeService.this.mAppContext, xmPluginPackage, i, intent3, deviceStat2);
                                        }
                                        gsy.O00000Oo("PluginStartTime", "PluginMessageReceiver  " + System.currentTimeMillis());
                                        if (iBridgeCallback3 != null) {
                                            iBridgeCallback3.onSendSuccess(new Bundle());
                                        }
                                        if (iBridgeCallback3 != null) {
                                            try {
                                                iBridgeCallback3.onHandle(z2);
                                            } catch (RemoteException unused) {
                                            }
                                        }
                                        if (!z) {
                                            Intent intent = new Intent();
                                            intent.setClassName(PluginBridgeService.this.mAppContext, "com.xiaomi.smarthome.framework.update.ui.MiioUpgradeActivity");
                                            intent.putExtra("miio_upgrade_did", deviceStat2.did);
                                            intent.putExtra("miio_upgrade_pid", deviceStat2.pid);
                                            intent.putExtra("miio_upgrade_name", deviceStat2.name);
                                            intent.addFlags(536870912);
                                            intent.addFlags(4194304);
                                            intent.addFlags(268435456);
                                            exz exz = exz.f15941O000000o;
                                            exz.O000000o(intent, str2);
                                            intent.putExtras(intent3);
                                            PluginBridgeService.this.startActivity(intent);
                                        }
                                    } catch (Throwable th) {
                                        try {
                                            if (iBridgeCallback3 != null) {
                                                iBridgeCallback3.onFailure(new BridgeError(-1, PluginBridgeService.this.mAppContext.getString(R.string.error_open_exception)));
                                            }
                                        } catch (RemoteException unused2) {
                                        }
                                        PluginErrorInfoActivity.showErrorInfo(PluginBridgeService.this.mAppContext, xmPluginPackage, th);
                                        LogType logType = LogType.PLUGIN;
                                        gsy.O00000Oo(logType, "click_device_list", "PluginBridgerService.onPluginCacheReady try-catch 222 " + th.getMessage());
                                    }
                                } else {
                                    if (iBridgeCallback3 != null) {
                                        try {
                                            iBridgeCallback3.onFailure(new BridgeError(-1, PluginBridgeService.this.mAppContext.getString(R.string.code_did_not_exist)));
                                        } catch (RemoteException unused3) {
                                        }
                                    }
                                    gsy.O00000Oo(LogType.PLUGIN, "click_device_list", "PluginBridgerService.onPluginCacheReady deviceStat is null");
                                }
                            }
                        });
                    }
                });
            } catch (Throwable th) {
                if (iBridgeCallback2 != null) {
                    try {
                        iBridgeCallback2.onFailure(new BridgeError(-1, PluginBridgeService.this.mAppContext.getString(R.string.error_open_exception)));
                    } catch (RemoteException unused2) {
                    }
                }
                LogType logType = LogType.PLUGIN;
                gsy.O00000Oo(logType, "click_device_list", "PluginBridgerService.onPluginCacheReady try-catch 111 " + th.getMessage());
            }
        }

        public void startService(String str, long j, long j2, Intent intent, String str2) throws RemoteException {
            final long j3 = j2;
            final String str3 = str;
            final Intent intent2 = intent;
            final String str4 = str2;
            CoreApi.O000000o().O000000o(PluginBridgeService.this.mAppContext, new CoreApi.O0000o0() {
                /* class com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService.AnonymousClass1.AnonymousClass3 */

                public void onCoreReady() {
                    if (CoreApi.O000000o().O00000o0(j3) != null) {
                        Intent intent = new Intent();
                        intent.setClassName(PluginBridgeService.this.mAppContext.getPackageName(), str3);
                        Intent intent2 = intent2;
                        if (intent2 != null) {
                            intent.putExtra("plugin_extra_start_intent", intent2);
                            intent.addFlags(intent2.getFlags());
                        }
                        intent.putExtra("plugin_extra_packageId", j3);
                        intent.putExtra("plugin_extra_class", str4);
                        boolean z = false;
                        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) PluginBridgeService.this.mAppContext.getSystemService("activity")).getRunningServices(200).iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (it.next().service.getClassName().equalsIgnoreCase(str3)) {
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (!z && !PluginBridgeService.mStartServiceRecordMap.containsKey(str3)) {
                            StartServiceRecord startServiceRecord = new StartServiceRecord();
                            startServiceRecord.intent = intent;
                            PluginBridgeService.mStartServiceRecordMap.put(str3, startServiceRecord);
                            fsp.O000000o().O00000o0.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService.AnonymousClass1.AnonymousClass3.AnonymousClass1 */

                                public void run() {
                                    PluginBridgeService.mStartServiceRecordMap.remove(str3);
                                }
                            }, 60000);
                        }
                        PluginBridgeService.this.mAppContext.startService(intent);
                    }
                }
            });
        }

        public void exitProcess() throws RemoteException {
            PluginBridgeService.this.doCameraDisConnection(PluginBridgeService.process);
            PluginBridgeService.this.mUiHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService.AnonymousClass1.AnonymousClass4 */

                public void run() {
                    fcx.f16092O000000o.O00000oo();
                    while (!PluginBridgeService.this.mPluginActivityStack.isEmpty()) {
                        Activity activity = (Activity) PluginBridgeService.this.mPluginActivityStack.pop().get();
                        if (activity != null) {
                            try {
                                activity.finish();
                            } catch (Exception e) {
                                gsy.O00000o0(LogType.PLUGIN, "PluginBridgeService", Log.getStackTraceString(e));
                            }
                        }
                    }
                    System.exit(0);
                }
            });
        }

        public boolean isProcessForeground() {
            return PluginBridgeService.this.mProcessForeground;
        }

        public boolean isRnActivityReuseAvailable() {
            return PluginBridgeService.this.mProcessForeground && hyy.O000000o(PluginBridgeService.this.mAppContext, PluginRuntimeManager.getInstance().getPluginRNActivityClass(PluginBridgeService.process));
        }
    };
    Handler mUiHandler;
    Handler mWorkerHandler;
    HandlerThread mWorkerThread;

    public void loadRN(PluginPackageInfo pluginPackageInfo, PluginDeviceInfo pluginDeviceInfo, int i, DeviceStat deviceStat, Intent intent, boolean z, IBridgeCallback iBridgeCallback) {
        if (i == 1 || i == 3) {
            openRnPluginActivity(pluginPackageInfo, pluginDeviceInfo, i, deviceStat, intent, z, iBridgeCallback);
        } else if (i == 2) {
            if (intent != null) {
                boolean booleanExtra = intent.getBooleanExtra("extra_start_rnplugin_activity", true);
                String stringExtra = intent.getStringExtra("type");
                gsy.O00000Oo("PluginBridgeService", "loadRn-->msgType=PUSH_MESSAGE,  type" + stringExtra + ", startRnPluginActivity:" + booleanExtra);
                if ("ScenePush".equalsIgnoreCase(stringExtra) && booleanExtra) {
                    openRnPluginActivity(pluginPackageInfo, pluginDeviceInfo, i, deviceStat, intent, z, iBridgeCallback);
                    emitBridgeCallback(iBridgeCallback, deviceStat);
                    return;
                } else if ("ScenePush".equalsIgnoreCase(stringExtra) && !booleanExtra) {
                    Intent intent2 = new Intent();
                    intent2.setClassName(this, PluginRuntimeManager.getInstance().getPluginRNActivityClass(process));
                    intent2.addFlags(536870912);
                    intent2.addFlags(4194304);
                    intent2.addFlags(268435456);
                    exz exz = exz.f15941O000000o;
                    exz.O000000o(intent2, pluginDeviceInfo == null ? "" : pluginDeviceInfo.O00000Oo());
                    intent2.putExtras(intent);
                    startActivity(intent2);
                    emitBridgeCallback(iBridgeCallback, deviceStat);
                    return;
                } else if (!TextUtils.isEmpty(intent.getStringExtra("inner_jump"))) {
                    openRnPluginActivity(pluginPackageInfo, pluginDeviceInfo, i, deviceStat, intent, z, iBridgeCallback);
                }
            }
            ft.O000000o(this.mAppContext).O000000o(new Intent().setAction("push_action_plugin").putExtras(intent));
        } else if (i == 18) {
            fcx.f16092O000000o.O000000o(deviceStat);
        } else if (i == 19) {
            if (intent != null) {
                fcx.f16092O000000o.O000000o(deviceStat, intent);
            }
        } else if (i == 20) {
            fcx.f16092O000000o.O00000Oo(deviceStat);
        } else if (i == 21) {
            fcx.f16092O000000o.O00000o0(deviceStat);
        } else if (i == 23) {
            fcx.f16092O000000o.O00000o(deviceStat);
        } else if (i == 24) {
            fcx.f16092O000000o.O00000oO(deviceStat);
        }
        emitBridgeCallback(iBridgeCallback, deviceStat);
    }

    private void emitBridgeCallback(IBridgeCallback iBridgeCallback, DeviceStat deviceStat) {
        if (iBridgeCallback == null) {
            return;
        }
        if (deviceStat == null || TextUtils.isEmpty(deviceStat.did)) {
            try {
                iBridgeCallback.onFailure(new BridgeError(-1, this.mAppContext.getString(R.string.code_did_not_exist)));
            } catch (RemoteException unused) {
            }
        } else {
            ((PluginHostApi) PluginHostApi.instance()).setCurrentDid(deviceStat.did);
            try {
                iBridgeCallback.onSendSuccess(new Bundle());
            } catch (RemoteException unused2) {
            }
            try {
                iBridgeCallback.onHandle(true);
            } catch (RemoteException unused3) {
            }
            mCacheDeviceMap.put(deviceStat.did, deviceStat);
        }
    }

    private void openRnPluginActivity(PluginPackageInfo pluginPackageInfo, PluginDeviceInfo pluginDeviceInfo, int i, DeviceStat deviceStat, Intent intent, boolean z, final IBridgeCallback iBridgeCallback) {
        this.mSendBroadcastToFinishLoadingRnActivity = true;
        byte O00000Oo = fcx.f16092O000000o.O00000Oo();
        if (pluginPackageInfo == null || deviceStat == null) {
            XmPluginHostApi instance = XmPluginHostApi.instance();
            instance.log("PluginBridgeService.loadRN", System.currentTimeMillis() + " msgType:" + i + " initStatus:" + ((int) O00000Oo) + " PluginRecord or DeviceStat is null");
        } else {
            XmPluginHostApi instance2 = XmPluginHostApi.instance();
            instance2.log("PluginBridgeService.loadRN", System.currentTimeMillis() + " msgType:" + i + " stat:" + deviceStat + " record:" + pluginPackageInfo + " initStatus:" + ((int) O00000Oo));
        }
        if (O00000Oo < 0) {
            if (iBridgeCallback != null) {
                try {
                    iBridgeCallback.onFailure(new BridgeError(-1, this.mAppContext.getString(R.string.code_env_error)));
                } catch (RemoteException unused) {
                }
            }
        } else if (pluginPackageInfo == null || pluginDeviceInfo == null || deviceStat == null) {
            if (iBridgeCallback != null) {
                try {
                    iBridgeCallback.onFailure(new BridgeError(-1, this.mAppContext.getString(R.string.code_did_not_exist)));
                } catch (RemoteException unused2) {
                }
            }
        } else if (!checkRnPluginPackageExist(deviceStat, pluginPackageInfo, intent)) {
            if (iBridgeCallback != null) {
                try {
                    iBridgeCallback.onFailure(new BridgeError(-1, this.mAppContext.getString(R.string.code_unknown_error)));
                } catch (RemoteException unused3) {
                    return;
                }
            }
            gsy.O00000o0(LogType.PLUGIN, "PluginBridgeService", "openRnPluginActivity plugin not found plugin:".concat(String.valueOf(pluginPackageInfo)));
            sendPluginBundleNotExitsCrash(pluginPackageInfo, deviceStat);
        } else {
            if (this.mLauncherTime < 10000) {
                this.mLauncherTime = System.currentTimeMillis();
            }
            Intent intent2 = new Intent();
            intent2.putExtra("extra_click_device_time", System.currentTimeMillis());
            intent2.setClassName(this, PluginRuntimeManager.getInstance().getPluginRNActivityClass(process));
            intent2.putExtra("model", pluginDeviceInfo.O00000Oo());
            intent2.putExtra("did", deviceStat.did);
            intent2.putExtra("openTime", System.currentTimeMillis());
            intent2.addFlags(536870912);
            intent2.addFlags(4194304);
            intent2.addFlags(268435456);
            intent2.putExtras(intent);
            intent2.putExtra("package_msgType", i);
            fcx.f16092O000000o.O000000o(deviceStat, pluginPackageInfo, pluginDeviceInfo, intent2.getExtras());
            fcx.f16092O000000o.O000000o(iBridgeCallback);
            exz exz = exz.f15941O000000o;
            exz.O000000o(intent2, pluginDeviceInfo == null ? "" : pluginDeviceInfo.O00000Oo());
            try {
                startActivity(intent2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            gsy.O00000Oo("PluginStartTime", "startActivityReactNative  " + System.currentTimeMillis());
            if (z) {
                ft.O000000o(this.mAppContext).O000000o(new BroadcastReceiver() {
                    /* class com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService.AnonymousClass2 */

                    public void onReceive(Context context, Intent intent) {
                        if (iBridgeCallback != null) {
                            try {
                                gsy.O00000Oo("miot-rn-plugin", "退出自动化场景...");
                                Bundle extras = intent.getExtras();
                                boolean z = false;
                                if (extras != null) {
                                    z = extras.getBoolean("isSaveEntrance", false);
                                }
                                if (z) {
                                    iBridgeCallback.onMessageSuccess(intent.getExtras());
                                } else {
                                    iBridgeCallback.onMessageFailure(new BridgeError(-1, "rn plugin entrance cancel"));
                                }
                            } catch (RemoteException unused) {
                            }
                        }
                        ft.O000000o(PluginBridgeService.this.mAppContext).O000000o(this);
                    }
                }, new IntentFilter("scene_action_plugin"));
            }
        }
    }

    private boolean checkRnPluginPackageExist(DeviceStat deviceStat, PluginPackageInfo pluginPackageInfo, Intent intent) {
        if (gfr.O0000OOo || gfr.O0000Oo) {
            boolean booleanExtra = intent.getBooleanExtra("rn_native_debug_model", false);
            boolean modelIsMockModel = MockRnDevicePluginManager.getInstance().modelIsMockModel(deviceStat.model);
            if (booleanExtra || modelIsMockModel || XmPluginHostApi.instance().getQrDebugModePackageName() != null) {
                return true;
            }
        }
        return fky.O00000o(pluginPackageInfo.O00000o());
    }

    private void sendPluginBundleNotExitsCrash(PluginPackageInfo pluginPackageInfo, DeviceStat deviceStat) {
        String str;
        String str2;
        String str3;
        PluginPackageInfo pluginPackageInfo2 = pluginPackageInfo;
        DeviceStat deviceStat2 = deviceStat;
        if (deviceStat2 != null) {
            str2 = deviceStat2.model;
            str = deviceStat2.did;
        } else {
            str2 = "";
            str = str2;
        }
        if (pluginPackageInfo2 != null) {
            str3 = pluginPackageInfo.O00000oo();
        } else {
            str3 = "";
        }
        ftc.O000000o().O000000o(getApplicationContext(), "@ExceptionFromReactNative", "@ExceptionFromReactNative", fky.O000000o(pluginPackageInfo2, str2, ""), "plugin_crash", fsr.O0000Oo, str, 103, 0, str2, str3, "10058");
    }

    public static StartServiceRecord getStartServiceRecord(String str) {
        StartServiceRecord startServiceRecord = mStartServiceRecordMap.get(str);
        if (startServiceRecord != null) {
            mStartServiceRecordMap.remove(str);
        }
        return startServiceRecord;
    }

    public static DeviceStat getCachedDeviceStat(String str) {
        return mCacheDeviceMap.get(str);
    }

    public void onCreate() {
        gsy.O000000o(LogType.PLUGIN, "rn-plugin-framework", 3, "miot-rn-plugin", "PluginBridgeService onCreate");
        ExternalLoadManager.instance.loadExternal("amap2d", null);
        this.mAppContext = getApplicationContext();
        this.mWorkerThread = new gpq("PluginBridgeServiceWorker");
        this.mWorkerThread.start();
        this.mWorkerHandler = new Handler(this.mWorkerThread.getLooper());
        this.mUiHandler = new Handler(Looper.getMainLooper());
        process = PluginRuntimeManager.getProcessByName(getClass().getName());
        bindActivityListener();
        fcx.f16092O000000o.O000000o();
        fcx.f16092O000000o.O00000o();
    }

    private void bindActivityListener() {
        if (activityCount == null) {
            doCameraPreConnection(process);
            activityCount = new AtomicInteger(0);
            getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                /* class com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService.AnonymousClass3 */
                private long lastTime = 0;
                private String plugin = null;

                public void onActivityPaused(Activity activity) {
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public void onActivityCreated(Activity activity, Bundle bundle) {
                    PluginBridgeService pluginBridgeService = PluginBridgeService.this;
                    pluginBridgeService.mProcessForeground = true;
                    pluginBridgeService.mPluginActivityStack.push(new WeakReference(activity));
                    PluginBridgeService.this.disableCameraAutoDisConnection(activity);
                }

                private String getPluginString(Activity activity) {
                    PluginPackageInfo pluginRecord;
                    XmPluginPackage xmPluginPackage;
                    if (!(activity instanceof PluginHostActivity) || (xmPluginPackage = ((PluginHostActivity) activity).getXmPluginPackage()) == null) {
                        return (!(activity instanceof IPluginRnActivity) || (pluginRecord = ((IPluginRnActivity) activity).getPluginRecord()) == null) ? "" : hxh.O000000o(pluginRecord.O000000o(), pluginRecord.O00000Oo());
                    }
                    return hxh.O000000o(xmPluginPackage.getPluginId(), xmPluginPackage.getPackageId());
                }

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.hyd.O000000o(java.lang.String, java.lang.String, boolean):long
                 arg types: [java.lang.String, java.lang.String, int]
                 candidates:
                  _m_j.hyd.O000000o(android.app.Activity, java.lang.String, com.xiaomi.plugin.core.XmPluginPackage):long
                  _m_j.hyd.O000000o(java.lang.String, java.lang.String, boolean):long */
                public void onActivityStarted(Activity activity) {
                    long j;
                    int i;
                    long j2;
                    Activity activity2 = activity;
                    if (PluginBridgeService.activityCount.getAndIncrement() == 0) {
                        if (PluginBridgeService.this.mLauncherTime > 0) {
                            String str = null;
                            int i2 = -1;
                            long j3 = -1;
                            if (activity2 instanceof PluginHostActivity) {
                                XmPluginPackage xmPluginPackage = ((PluginHostActivity) activity2).getXmPluginPackage();
                                if (xmPluginPackage != null) {
                                    str = xmPluginPackage.packageName;
                                    int i3 = xmPluginPackage.packageVersion;
                                    i = i3;
                                    j2 = xmPluginPackage.getPluginId();
                                    j3 = xmPluginPackage.getPackageId();
                                } else {
                                    j2 = -1;
                                    i = -1;
                                }
                                long j4 = j2;
                                i2 = i;
                                j = j3;
                                j3 = j4;
                            } else {
                                if (activity2 instanceof IPluginRnActivity) {
                                    IPluginRnActivity iPluginRnActivity = (IPluginRnActivity) activity2;
                                    String deviceModel = iPluginRnActivity.getDeviceModel();
                                    PluginPackageInfo pluginRecord = iPluginRnActivity.getPluginRecord();
                                    if (pluginRecord != null) {
                                        i2 = pluginRecord.O00000oO();
                                        j3 = pluginRecord.O000000o();
                                        j = pluginRecord.O00000Oo();
                                        str = deviceModel;
                                    } else {
                                        str = deviceModel;
                                    }
                                }
                                j = -1;
                            }
                            String O000000o2 = hxh.O000000o(j3, j);
                            if (!TextUtils.isEmpty(O000000o2)) {
                                long currentTimeMillis = System.currentTimeMillis() - PluginBridgeService.this.mLauncherTime;
                                long currentTimeMillis2 = System.currentTimeMillis() - PluginBridgeService.this.mOpenTime;
                                if (currentTimeMillis > 0 && currentTimeMillis < 10000) {
                                    hxh.O000000o(O000000o2, currentTimeMillis, str, i2);
                                }
                                if (currentTimeMillis2 > 0 && currentTimeMillis2 < 10000) {
                                    hxh.O00000Oo(O000000o2, currentTimeMillis2, str, i2);
                                    if (PluginBridgeService.mLoadTime > 0 && PluginBridgeService.mLoadTime < 10000) {
                                        hxh.O000000o(O000000o2, currentTimeMillis2, PluginBridgeService.mLoadTime, currentTimeMillis, str, i2);
                                    }
                                }
                            }
                        }
                        this.plugin = getPluginString(activity);
                        hyd.O00000Oo().O000000o("switch_to_app", this.plugin, false);
                        String str2 = this.plugin;
                        if (str2 != null) {
                            this.lastTime = hxh.O000000o(str2);
                        } else {
                            return;
                        }
                    }
                    PluginBridgeService pluginBridgeService = PluginBridgeService.this;
                    pluginBridgeService.mLauncherTime = 0;
                    pluginBridgeService.mOpenTime = 0;
                    PluginBridgeService.mLoadTime = 0;
                }

                public void onActivityResumed(Activity activity) {
                    PluginBridgeService.this.sendBroadcastToFinishLoadingRnActivity();
                }

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.hyd.O000000o(java.lang.String, java.lang.String, boolean):long
                 arg types: [java.lang.String, java.lang.String, int]
                 candidates:
                  _m_j.hyd.O000000o(android.app.Activity, java.lang.String, com.xiaomi.plugin.core.XmPluginPackage):long
                  _m_j.hyd.O000000o(java.lang.String, java.lang.String, boolean):long */
                public void onActivityStopped(Activity activity) {
                    if (PluginBridgeService.activityCount.decrementAndGet() == 0) {
                        if (this.plugin == null) {
                            this.plugin = getPluginString(activity);
                        }
                        String str = this.plugin;
                        if (str != null) {
                            hxh.O000000o(str, this.lastTime);
                        }
                        this.lastTime = 0;
                        PluginBridgeService pluginBridgeService = PluginBridgeService.this;
                        pluginBridgeService.mLauncherTime = 0;
                        pluginBridgeService.mOpenTime = 0;
                        hyd.O00000Oo().O000000o("switch_to_backstage", this.plugin, false);
                    }
                }

                public void onActivityDestroyed(Activity activity) {
                    PluginBridgeService pluginBridgeService = PluginBridgeService.this;
                    pluginBridgeService.mProcessForeground = false;
                    pluginBridgeService.enableCameraAutoDisConnection(activity);
                }
            });
        }
    }

    public void enableCameraAutoDisConnection(Activity activity) {
        DeviceStat deviceStat;
        if (process == RunningProcess.CAMERA && (activity instanceof IPluginRnActivity) && (deviceStat = ((IPluginRnActivity) activity).getDeviceStat()) != null) {
            fsp.O000000o().O0000OOo.enableCameraAutoDisconnect(deviceStat);
        }
    }

    public void disableCameraAutoDisConnection(Activity activity) {
        DeviceStat deviceStat;
        if (process == RunningProcess.CAMERA && (activity instanceof IPluginRnActivity) && (deviceStat = ((IPluginRnActivity) activity).getDeviceStat()) != null) {
            fsp.O000000o().O0000OOo.disableCameraAutoDisconnect(deviceStat);
        }
    }

    private void doCameraPreConnection(RunningProcess runningProcess) {
        if (runningProcess == RunningProcess.CAMERA) {
            fsp.O000000o().O0000OOo.preConnectCamera();
        }
    }

    public void doCameraDisConnection(RunningProcess runningProcess) {
        if (runningProcess == RunningProcess.CAMERA) {
            fsp.O000000o().O0000OOo.disConnectCamera();
        }
    }

    public void sendBroadcastToFinishLoadingRnActivity() {
        Handler handler;
        if (!this.mSendBroadcastToFinishLoadingRnActivity && (handler = this.mWorkerHandler) != null) {
            handler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService.AnonymousClass4 */

                public void run() {
                    PluginBridgeService pluginBridgeService = PluginBridgeService.this;
                    pluginBridgeService.mSendBroadcastToFinishLoadingRnActivity = true;
                    pluginBridgeService.sendBroadcast(new Intent("action_launch_plugin_finish"));
                }
            }, 600);
        }
    }

    public void resetData() {
        this.mSendBroadcastToFinishLoadingRnActivity = false;
    }

    public IBinder onBind(Intent intent) {
        return this.mStub;
    }
}
