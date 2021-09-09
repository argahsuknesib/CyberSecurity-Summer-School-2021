package com.xiaomi.smarthome.application;

import _m_j.O0o0000;
import _m_j.cub;
import _m_j.cvb;
import _m_j.dgk;
import _m_j.dgm;
import _m_j.dgq;
import _m_j.dha;
import _m_j.dic;
import _m_j.did;
import _m_j.dxq;
import _m_j.dxw;
import _m_j.dzj;
import _m_j.exo;
import _m_j.exx;
import _m_j.eyr;
import _m_j.ezn;
import _m_j.ezo;
import _m_j.ezt;
import _m_j.faa;
import _m_j.fac;
import _m_j.faw;
import _m_j.fbs;
import _m_j.fcn;
import _m_j.fcq;
import _m_j.fcr;
import _m_j.fct;
import _m_j.fcu;
import _m_j.fcv;
import _m_j.fda;
import _m_j.fdc;
import _m_j.fdj;
import _m_j.fjy;
import _m_j.fkl;
import _m_j.flc;
import _m_j.flu;
import _m_j.fnl;
import _m_j.foj;
import _m_j.fph;
import _m_j.fpx;
import _m_j.fpy;
import _m_j.fpz;
import _m_j.fqa;
import _m_j.fqc;
import _m_j.fqe;
import _m_j.fsl;
import _m_j.fsp;
import _m_j.fsq;
import _m_j.fsr;
import _m_j.fsw;
import _m_j.ft;
import _m_j.ftm;
import _m_j.ftn;
import _m_j.ftp;
import _m_j.ftr;
import _m_j.fuq;
import _m_j.fur;
import _m_j.fuu;
import _m_j.fvp;
import _m_j.gdp;
import _m_j.gfr;
import _m_j.gft;
import _m_j.gfu;
import _m_j.ggb;
import _m_j.gji;
import _m_j.gkn;
import _m_j.gkv;
import _m_j.glc;
import _m_j.gns;
import _m_j.gnt;
import _m_j.goq;
import _m_j.gpy;
import _m_j.grr;
import _m_j.gsy;
import _m_j.gty;
import _m_j.gue;
import _m_j.gwc;
import _m_j.gzf;
import _m_j.gzg;
import _m_j.gzj;
import _m_j.gzk;
import _m_j.hmf;
import _m_j.hsl;
import _m_j.hvm;
import _m_j.hxd;
import _m_j.hxg;
import _m_j.hxi;
import _m_j.hxj;
import _m_j.hxt;
import _m_j.hxx;
import _m_j.hyo;
import _m_j.hza;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.mibi.sdk.channel.wxpay.WxResultHelper;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastRecevier;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.mmkv.MMKV;
import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.smarthome.acp.ACPService;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import com.xiaomi.smarthome.component.MijiaRootUriHandler;
import com.xiaomi.smarthome.core.client.IClientApi;
import com.xiaomi.smarthome.core.server.CoreApiStub;
import com.xiaomi.smarthome.core.server.CoreService;
import com.xiaomi.smarthome.core.server.ICoreApi;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.frame.core.ClientApiStub;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.crash.FrameCrashHandler;
import com.xiaomi.smarthome.frame.plugin.pluginhook.DNSHook;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.crash.MainCrashHandler;
import com.xiaomi.smarthome.framework.crash.PluginCrashHandler;
import com.xiaomi.smarthome.framework.log.HookHelper;
import com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl;
import com.xiaomi.smarthome.framework.plugin.mpk.PluginCommonHostApiImpl;
import com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl;
import com.xiaomi.smarthome.library.common.floatingview.EnFloatingView;
import com.xiaomi.smarthome.library.common.floatingview.FloatingView$2;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.lifecycle.BootPageLifeCycleDispatcher;
import com.xiaomi.smarthome.module.IPreModuleAware;
import com.xiaomi.smarthome.sdk.SyncConfigCallback;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public class SHApplication extends ServiceApplication {
    public static boolean isMainProcess = true;
    private static volatile boolean sEnableLogPerf = true;
    private static boolean sIsFacebookSdkInited = false;
    private static long sLastPrintTs = 0;
    public static volatile boolean sShopInitiled = false;
    private Locale locale;

    public static void printTimestamp(String str) {
    }

    public SHApplication() {
        this.mResetRepeatedCrashRunnable = new Runnable() {
            /* class com.xiaomi.smarthome.application.SHApplication.AnonymousClass1 */

            public final void run() {
                Context appContext = SHApplication.getAppContext();
                Intent intent = new Intent(appContext, ACPService.class);
                intent.setAction("acp_action");
                intent.putExtra("acp_repeated_crash", 3);
                try {
                    appContext.startService(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        fsp.O000000o(this);
    }

    static {
        O0o0000.O0000o0();
    }

    public static boolean isEnableLogPerf() {
        return sEnableLogPerf;
    }

    public static void setEnableLogPerf(boolean z) {
        sEnableLogPerf = z;
    }

    public void attachBaseContext(Context context) {
        dxw.O00000Oo().O000000o();
        super.attachBaseContext(context);
        this.locale = getResources().getConfiguration().locale;
        exportAppBuildConfig();
        initCommonApi();
        MMKV.O000000o(this);
        if (gfr.O0000oO0) {
            SplitCompat.install(this);
        }
    }

    private void initCommonApi() {
        fcr.f16088O000000o = new gkn();
        fdc.f16097O000000o = new gji();
        fcn.f16085O000000o = new fdj();
        flc.f16590O000000o = new flc();
        hvm.f704O000000o = new fjy();
        fqc.f16894O000000o = new fpy();
        fqa.f16893O000000o = new fpx();
        fqe.f16895O000000o = new fpz();
    }

    private static void ignoreThemeCheck() {
        try {
            if (!gfr.O0000OOo) {
                Field declaredField = ThemeEnforcement.class.getDeclaredField("APPCOMPAT_CHECK_ATTRS");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    declaredField.set(null, new int[0]);
                }
                Field declaredField2 = ThemeEnforcement.class.getDeclaredField("MATERIAL_CHECK_ATTRS");
                if (declaredField2 != null) {
                    declaredField2.setAccessible(true);
                    declaredField2.set(null, new int[0]);
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void tryInitBugly() {
        if (shouldEnableBugly() && !dgk.O00000Oo()) {
            goq.O000000o(new Runnable() {
                /* class com.xiaomi.smarthome.application.SHApplication.AnonymousClass5 */

                public final void run() {
                    try {
                        CrashReport.UserStrategy userStrategy = new CrashReport.UserStrategy(SHApplication.getAppContext());
                        userStrategy.O000000o(new CrashReport.O000000o() {
                            /* class com.xiaomi.smarthome.application.SHApplication.AnonymousClass5.AnonymousClass1 */

                            public final Map<String, String> O000000o() {
                                StringBuilder sb = new StringBuilder();
                                MainCrashHandler.O000000o(sb);
                                return Collections.singletonMap("ActivityTaskInfo", sb.toString());
                            }
                        });
                        Context appContext = SHApplication.getAppContext();
                        if (appContext != null) {
                            CrashReport.f5809O000000o = appContext;
                            dgm.O000000o(dgk.O000000o());
                            dgm.O000000o(appContext, "b1d4bd688c", true, userStrategy);
                        }
                        CrashReport.O000000o(SHApplication.getAppContext(), "miui-version", grr.O00000o0());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    private static void onAllStart() {
        Log.e("hzd1", "application onAllStart");
        System.setProperty("rx2.purge-enabled", "true");
        System.setProperty("rx2.purge-period-seconds", "120");
        ignoreThemeCheck();
        if (ggb.O0000o00()) {
            goq.O000000o($$Lambda$SHApplication$TmNW3a0ttn7kZr6FG2QNYom38Iw.INSTANCE);
        }
        initAccount();
        initOneTrack();
        initFirebaseAnalytices();
        goq.O000000o($$Lambda$SHApplication$clLX5wI4pySfXy_EmzmuyuMP6Zs.INSTANCE);
        getGlobalHandler().postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.application.SHApplication.AnonymousClass7 */

            public final void run() {
                ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("action_on_application_start"));
            }
        }, 7200000);
        registerActivityLifecycleCallbacks();
        fuq.O000000o().O00000o0();
        getGlobalWorkerHandler().postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.application.SHApplication.AnonymousClass8 */

            public final void run() {
                faw.O00000o().initMiControlsProviderService(ServiceApplication.getAppContext());
                SHApplication.initSmartConfigData();
            }
        }, 500);
        getGlobalWorkerHandler().postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.application.SHApplication.AnonymousClass9 */

            public final void run() {
                if (!CommonApplication.getAppContext().getSharedPreferences("SP_THREADPOOL_AB_CONFIG", 0).getBoolean("SP_KEY_USE_MIUI_MEMORY_OPT", false) && !fkl.O000000o().O00000o0()) {
                    PluginDeviceManager.instance.updateConfig(false, null);
                    fkl.O000000o().O00000Oo();
                }
            }
        }, 1000);
        if (!grr.O00000oO() && ((hmf) fbs.O000000o(hmf.class, "com.xiaomi.smarthome.push.IPushHmsApi")) != null) {
            getAppContext();
        }
    }

    static /* synthetic */ void lambda$onAllStart$0() {
        gfu O000000o2 = gft.O000000o();
        Log.e("hzd1", "api=".concat(String.valueOf(O000000o2)));
        if (O000000o2 != null && O000000o2.isShowGlobalShop(getApplication())) {
            Log.e("hzd1", "initMiShopGlobalSDK start");
            O000000o2.initMiShopGlobalSDK(false);
        }
    }

    public static void initSmartConfigData() {
        eyr.O00000Oo().O000000o(new SyncConfigCallback.Stub() {
            /* class com.xiaomi.smarthome.application.SHApplication.AnonymousClass6 */

            public final void onResponse(int i, String str) throws RemoteException {
            }
        });
    }

    private static void doSomethingOnCoreReady() {
        if (CoreApi.O000000o().O0000O0o()) {
            printAppInfo();
            if (CoreApi.O000000o().O0000Ooo()) {
                fsp.O000000o().O00000oo.O000000o(1);
                new gdp().O00000Oo();
                return;
            }
            return;
        }
        IntentFilter intentFilter = new IntentFilter("ClientApiStub.onCoreReady");
        ft.O000000o(getAppContext()).O000000o(new BroadcastReceiver() {
            /* class com.xiaomi.smarthome.application.SHApplication.AnonymousClass10 */

            public final void onReceive(Context context, Intent intent) {
                SHApplication.printAppInfo();
                ft.O000000o(ServiceApplication.getAppContext()).O000000o(this);
                SHApplication.getGlobalHandler().postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.application.SHApplication.AnonymousClass10.AnonymousClass1 */

                    public final void run() {
                        if (CoreApi.O000000o().O0000Ooo()) {
                            new gdp().O00000Oo();
                        }
                    }
                }, 1000);
            }
        }, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter("ClientApiStub.onAccountReady");
        ft.O000000o(getAppContext()).O000000o(new BroadcastReceiver() {
            /* class com.xiaomi.smarthome.application.SHApplication.AnonymousClass11 */

            public final void onReceive(Context context, Intent intent) {
                if (gfr.O0000Ooo) {
                    Log.d("login", "Receiver ACTION_ON_ACCOUNT_READY");
                }
                gsy.O00000o0(LogType.STARTUP, "login", "application Receiver ACTION_ON_ACCOUNT_READY");
                ft.O000000o(ServiceApplication.getAppContext()).O000000o(this);
                if (CoreApi.O000000o().O0000Ooo()) {
                    SHApplication.getStateNotifier().O00000o0();
                    fsp.O000000o().O00000oo.O000000o(1);
                }
            }
        }, intentFilter2);
        getAppContext().registerReceiver(new BroadcastReceiver() {
            /* class com.xiaomi.smarthome.application.SHApplication.AnonymousClass12 */

            public final void onReceive(Context context, Intent intent) {
                gsy.O00000o0(LogType.STARTUP, "locale", "application Receiver ACTION_LOCALE_CHANGED");
                gwc.O000000o();
                hsl.O00000Oo().syncServer(true);
            }
        }, new IntentFilter("android.intent.action.LOCALE_CHANGED"));
    }

    public static void printAppInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("versionName = ");
        sb.append(gfr.O00000oo);
        sb.append(", versionCode = ");
        sb.append(gfr.O00000oO);
        ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
        String O000000o2 = O0000ooO != null ? O0000ooO.O000000o() : "";
        sb.append(", server = ");
        sb.append(O000000o2);
        String O00oOooO = CoreApi.O000000o().O00oOooO();
        sb.append(", serverEnv = ");
        sb.append(O00oOooO);
        gsy.O00000o0(LogType.GENERAL, "AppInfo", sb.toString());
    }

    private static void registerActivityLifecycleCallbacks() {
        getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            /* class com.xiaomi.smarthome.application.SHApplication.AnonymousClass2 */

            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public final void onActivityCreated(final Activity activity, Bundle bundle) {
                SHApplication.tryInitBugly();
                faa.O000000o(ServiceApplication.getAppContext(), SHApplication.isMainProcess);
                LogType logType = LogType.PAGE_SWITCH;
                gsy.O00000o0(logType, "ActivityManager", activity.getClass().getSimpleName() + " " + (activity.hashCode() & 255) + " created ");
                hyo O000000o2 = hyo.O000000o();
                gsy.O00000Oo("GlobalNavButtonManager", "needShowNavButton");
                if (!TextUtils.isEmpty(O000000o2.f994O000000o)) {
                    hyo O000000o3 = hyo.O000000o();
                    StringBuilder sb = new StringBuilder();
                    sb.append(activity.hashCode());
                    String sb2 = sb.toString();
                    gsy.O00000Oo("GlobalNavButtonManager", "createViewIfNeed ".concat(String.valueOf(sb2)));
                    final View view = null;
                    if (!TextUtils.isEmpty(O000000o3.f994O000000o) && TextUtils.equals(O000000o3.f994O000000o, "identity_xiaoai")) {
                        view = hyo.O000000o(activity);
                        O000000o3.O00000o0.post(new Runnable(sb2, new WeakReference(view)) {
                            /* class _m_j.hyo.AnonymousClass2 */

                            /* renamed from: O000000o */
                            final /* synthetic */ String f996O000000o;
                            final /* synthetic */ WeakReference O00000Oo;

                            {
                                this.f996O000000o = r2;
                                this.O00000Oo = r3;
                            }

                            public final void run() {
                                hyo.this.O00000Oo.put(this.f996O000000o, this.O00000Oo);
                            }
                        });
                    }
                    if (view != null) {
                        SHApplication.getGlobalHandler().postDelayed(new Runnable() {
                            /* class com.xiaomi.smarthome.application.SHApplication.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                hyo.O000000o(activity, view);
                            }
                        }, 10);
                    } else {
                        return;
                    }
                }
                MainCrashHandler.O000000o(activity.getClass().getSimpleName() + (activity.hashCode() & 255) + " created " + (System.currentTimeMillis() / 1000));
            }

            public final void onActivityStarted(Activity activity) {
                if (CommonApplication.getForegroundActivityCount() == 0) {
                    hxj hxj = hxi.f950O000000o;
                    flu.O00000oO().O000000o(activity);
                }
            }

            public final void onActivityResumed(Activity activity) {
                MainCrashHandler.O000000o(activity.getClass().getSimpleName() + (activity.hashCode() & 255) + " resumed " + (System.currentTimeMillis() / 1000));
            }

            public final void onActivityPaused(Activity activity) {
                MainCrashHandler.O000000o(activity.getClass().getSimpleName() + (activity.hashCode() & 255) + " paused " + (System.currentTimeMillis() / 1000));
            }

            public final void onActivityStopped(Activity activity) {
                if (CommonApplication.getForegroundActivityCount() == 0) {
                    hxt hxt = hxi.O0000Oo;
                    long currentTimeMillis = System.currentTimeMillis() - CommonApplication.mAppEnterTime;
                    hxt.f960O000000o.O000000o("app_stat_time", "time", Long.valueOf(currentTimeMillis));
                    hxj hxj = hxi.f950O000000o;
                    flu.O00000oO().O00000Oo(activity);
                    gue.O000000o().reportOfflineStatAndClean();
                }
            }

            public final void onActivityDestroyed(Activity activity) {
                LogType logType = LogType.PAGE_SWITCH;
                gsy.O00000o0(logType, "ActivityManager", activity.getClass().getSimpleName() + " " + (activity.hashCode() & 255) + " destroyed ");
                if (CommonApplication.getActivityStack().isEmpty()) {
                    SHApplication.getGlobalHandler().postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.application.SHApplication.AnonymousClass2.AnonymousClass2 */

                        public final void run() {
                            if (CommonApplication.getActivityStack().isEmpty()) {
                                try {
                                    if (!dgm.f14605O000000o) {
                                        Log.w(did.f14660O000000o, "Can not close bugly because bugly is disable.");
                                    } else if (!dgk.O00000Oo()) {
                                        Log.w(did.f14660O000000o, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
                                    } else if (CrashReport.f5809O000000o != null) {
                                        BuglyBroadcastRecevier O000000o2 = BuglyBroadcastRecevier.O000000o();
                                        if (O000000o2 != null) {
                                            O000000o2.O00000Oo(CrashReport.f5809O000000o);
                                        }
                                        if (!dgm.f14605O000000o) {
                                            Log.w(did.f14660O000000o, "Can not close crash report because bugly is disable.");
                                        } else if (!dgk.O00000Oo()) {
                                            Log.w(did.f14660O000000o, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
                                        } else {
                                            dha.O000000o().O00000Oo();
                                        }
                                        dgq.O000000o(CrashReport.f5809O000000o);
                                        dic O000000o3 = dic.O000000o();
                                        if (O000000o3 != null) {
                                            O000000o3.O00000Oo();
                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                hyo.O000000o().O00000Oo();
                            }
                        }
                    }, 10);
                }
                MainCrashHandler.O000000o(activity.getClass().getSimpleName() + (activity.hashCode() & 255) + " destroyed " + (System.currentTimeMillis() / 1000));
            }
        });
        fuq.O000000o().O00000o0();
    }

    public void onApplicationLifeCycleStart() {
        if (getAppContext() != null && isMainProcess && !sApplicationStart) {
            sApplicationStart = true;
            int size = fac.O000000o().f15994O000000o.size();
            for (int i = 0; i < size; i++) {
                try {
                    fac.O000000o().f15994O000000o.get(i).O00000Oo();
                } catch (Exception unused) {
                }
            }
            try {
                onAllStart();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static SHApplication getApplication() {
        return (SHApplication) sInstance.f4211O000000o;
    }

    public static ezn getPushManager() {
        return ezo.O000000o();
    }

    public String getPushId() {
        return getPushManager().getPushId();
    }

    public static fur getCommonApiV2() {
        return fur.O000000o();
    }

    public Dialog showAppLoginDialog(Activity activity, boolean z) {
        return gty.O000000o().showLoginDialog(activity, z);
    }

    public static CommonApplication.O000000o<IWXAPI> getIWXAPIGetterCallback() {
        return new CommonApplication.O000000o<IWXAPI>() {
            /* class com.xiaomi.smarthome.application.SHApplication.AnonymousClass3 */

            public final /* synthetic */ Object O000000o() {
                return SHApplication.getIWXAPI();
            }
        };
    }

    public static IWXAPI getIWXAPI() {
        return getSHIWXAPI();
    }

    public static com.tencent.mm.sdk.openapi.IWXAPI getIWXAPI2() {
        return WXAPIFactory.createWXAPI(getAppContext(), "wx54b959a68fb6f580", true);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Locale locale2 = this.locale;
        if (locale2 != null && !locale2.equals(configuration.locale)) {
            this.locale = configuration.locale;
            gwc.O000000o();
        }
    }

    public static void initAccount() {
        gty.O000000o().initAccount();
    }

    private static void initFirebaseAnalytices() {
        if (gfr.O0000oO0 && ezt.O000000o().isReadyOnApplicationCreate() && fsl.O000000o(getAppContext())) {
            hxd hxd = hxd.O000000o.f946O000000o;
            Context appContext = getAppContext();
            hxd.O00000Oo = appContext;
            hxd.O00000o0 = (hxx) fbs.O000000o(hxx.class, "com.xiaomi.smarthome.push-fcm-external.IStatReporter");
            if (hxd.O00000o0 != null) {
                hxd.O00000o0.init(appContext);
                hxd.O000000o();
            }
        }
    }

    private static void initOneTrack() {
        hxg.O000000o(getAppContext());
        if (ftn.O0000O0o(getAppContext()) || !ezt.O000000o().isReadyOnApplicationCreate() || !fsl.O000000o(getAppContext())) {
            OneTrack.setDisable(true);
        }
        if (gfr.O0000Ooo) {
            gsy.O00000Oo("OneTrack", "initOneTrack and disable == " + OneTrack.isDisable());
        }
    }

    private void exportAppBuildConfig() {
        gfr.f17662O000000o = false;
        gfr.O00000Oo = "release";
        gfr.O00000o0 = 2945;
        gfr.O00000o = "GooglePlay";
        gfr.O00000oO = 64656;
        gfr.O00000oo = "6.10.702";
        gfr.O0000O0o = "com.xiaomi.smarthome";
        gfr.O0000OOo = false;
        gfr.O0000Oo0 = true;
        gfr.O0000Oo = false;
        gfr.O0000o0O = "GooglePlay";
        gfr.O0000o0o = false;
        gfr.O0000oO = false;
        gfr.O0000Ooo = false;
        gfr.O0000o00 = false;
        gfr.O0000o0 = 2;
        gfr.O0000oO0 = true;
        gfr.O00oOooO = ftm.O00000o(this);
        gfr.O00oOooo = Process.myPid();
        gfr.O000O00o = Process.myUid();
    }

    public void onCreate() {
        long currentTimeMillis = System.currentTimeMillis();
        sOnCreateTime = currentTimeMillis;
        sLastPrintTs = currentTimeMillis;
        ftm.O00000o0(this);
        boolean O000000o2 = ftm.O000000o(this);
        isMainProcess = O000000o2;
        setStrictModeAndLeakCanary();
        super.onCreate();
        DNSHook.install(ftm.O00000oo(this));
        MijiaRootUriHandler mijiaRootUriHandler = new MijiaRootUriHandler(this);
        if (!cvb.O000000o()) {
            Log.w("WMRouter", "!!当前未设置Logger,建议通过 Debugger.setLogger()方法设置Logger");
            Log.w("WMRouter", "!!并在测试环境通过 Debugger.EnableLog(true)方法开启日志");
            Log.w("WMRouter", "!!通过Debugger.setEnableDebug(true)方法在测试环境及时抛出严重类型异常");
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            cvb.O0000O0o();
        }
        if (cub.f14361O000000o == null) {
            cub.f14361O000000o = mijiaRootUriHandler;
        } else {
            cvb.O0000O0o();
        }
        gzg O000000o3 = gzg.O000000o();
        O000000o3.f18614O000000o = new ArrayList(gzf.O000000o());
        if (O000000o3.f18614O000000o.size() > 0) {
            for (IPreModuleAware next : O000000o3.f18614O000000o) {
                if (!TextUtils.isEmpty(next.getModuleKey())) {
                    O000000o3.O00000Oo.put(next.getModuleKey(), next);
                }
            }
        }
        setMiJiaEnvironment();
        CameraRouterFactory.getCameraManagerApi().setEnvironment(this);
        setHookForMiUI12();
        registerActivityLifecycleForFloatView();
        initMonitorConfig();
        setCrashHandler(O000000o2);
        initSmartHomeSdk();
        gwc.O000000o(isAppForeground());
        ftp.f16092O000000o = new ftp();
        initOnlyInMainProcess(O000000o2);
        setMissUUID();
    }

    private void registerActivityLifecycleForFloatView() {
        if (gns.O000000o()) {
            registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                /* class com.xiaomi.smarthome.application.SHApplication.AnonymousClass4 */

                public final void onActivityCreated(Activity activity, Bundle bundle) {
                }

                public final void onActivityDestroyed(Activity activity) {
                }

                public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public final void onActivityStarted(Activity activity) {
                }

                public final void onActivityStopped(Activity activity) {
                }

                public final void onActivityResumed(Activity activity) {
                    gnt O000000o2 = gnt.O000000o();
                    synchronized (O000000o2) {
                        if (gnt.f18057O000000o == null) {
                            EnFloatingView enFloatingView = new EnFloatingView(CommonApplication.getAppContext(), O000000o2.O00000Oo);
                            gnt.f18057O000000o = enFloatingView;
                            enFloatingView.setLayoutParams(O000000o2.O00000o0);
                            gnt.f18057O000000o.setVisibility(4);
                            ft.O000000o(CommonApplication.getAppContext()).O000000o(new FloatingView$2(O000000o2), new IntentFilter("action_float_view_status_change"));
                        }
                    }
                    if (!gns.O000000o(activity.getClass().getSimpleName())) {
                        gnt.O000000o().O000000o(activity);
                    }
                }

                public final void onActivityPaused(Activity activity) {
                    gnt.O000000o().O00000Oo(activity);
                }
            });
        }
    }

    private void setStrictModeAndLeakCanary() {
        if (Build.VERSION.SDK_INT >= 24) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
        }
    }

    private void setMiJiaEnvironment() {
        gkv.O000000o o000000o = new gkv.O000000o();
        o000000o.f17950O000000o = getApplicationContext();
        o000000o.O00000Oo = gfr.O0000OOo;
        o000000o.O00000o0 = gfr.O0000Oo0;
        o000000o.O00000o = gfr.O0000Oo;
        o000000o.O00000oO = gfr.O0000Ooo;
        o000000o.O00000oo = gfr.O0000o0o;
        gkv.f17949O000000o = o000000o.f17950O000000o.getApplicationContext();
        gkv.O00000Oo = o000000o.O00000Oo;
        gkv.O00000o0 = o000000o.O00000o0;
        gkv.O00000o = o000000o.O00000o;
        gkv.O00000oO = o000000o.O00000oO;
        gkv.O00000oo = o000000o.O00000oo;
    }

    private void setHookForMiUI12() {
        try {
            if (!grr.O00000o() || !ftn.O00000oo(getAppContext())) {
                gsy.O00000o0(LogType.LOG_ANALYSIS, "hook_location", "::not hook");
            } else {
                HookHelper.hookLocationManager();
                HookHelper.hookPackageManager(getApplicationContext());
            }
            if (Build.VERSION.SDK_INT >= 29) {
                HookHelper.hookTelephonyManager();
            }
            setHookInDebugMode();
        } catch (Exception unused) {
        }
    }

    private void setHookInDebugMode() {
        try {
            if (grr.O00000o() && ftn.O00000oo(getAppContext()) && gfr.O0000OOo) {
                HookHelper.hookActivityManager();
                HookHelper.hookPackageManager(getApplicationContext());
                HookHelper.hookSubscriptionManager();
                HookHelper.hookClipboardManager();
            }
        } catch (Exception unused) {
        }
    }

    private void setCrashHandler(boolean z) {
        if (!z && ftm.O00000Oo(this)) {
            Thread.setDefaultUncaughtExceptionHandler(new PluginCrashHandler(getAppContext()));
        } else if (z) {
            Thread.setDefaultUncaughtExceptionHandler(new MainCrashHandler(getAppContext()));
            getGlobalHandler().postDelayed(this.mResetRepeatedCrashRunnable, 10000);
            Intent intent = new Intent(this, ACPService.class);
            intent.setAction("acp_action");
            intent.putExtra("acp_repeated_crash", 5);
            intent.putExtra("acp_data", System.currentTimeMillis());
            try {
                startService(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Thread.setDefaultUncaughtExceptionHandler(new FrameCrashHandler(getAppContext()));
        }
    }

    private void initSmartHomeSdk() {
        fsw.O000000o o000000o = new fsw.O000000o();
        o000000o.f17079O000000o = false;
        o000000o.O00000Oo = true;
        if (o000000o.O00000Oo) {
            new fsw(o000000o, (byte) 0);
            fsr.O000000o o000000o2 = new fsr.O000000o();
            o000000o2.f17071O000000o = gfr.f17662O000000o;
            o000000o2.O0000oO0 = true;
            o000000o2.O00000Oo = gfr.O00000Oo;
            o000000o2.O0000oO = true;
            o000000o2.O00000o0 = gfr.O00000o0;
            o000000o2.O0000oOO = true;
            o000000o2.O00000o = gfr.O00000o;
            o000000o2.O0000oOo = true;
            o000000o2.O00000oO = gfr.O00000oO;
            o000000o2.O0000oo0 = true;
            o000000o2.O00000oo = gfr.O00000oo;
            o000000o2.O0000oo = true;
            o000000o2.O0000O0o = gfr.O0000OOo;
            o000000o2.O0000ooO = true;
            o000000o2.O0000OOo = gfr.O0000Oo0;
            o000000o2.O0000ooo = true;
            o000000o2.O0000Oo0 = gfr.O0000Oo;
            o000000o2.O00oOooO = true;
            o000000o2.O0000Oo = gfr.O0000o0O;
            o000000o2.O00oOooo = true;
            o000000o2.O0000OoO = gfr.O0000o0o;
            o000000o2.O000O00o = true;
            o000000o2.O0000Ooo = gfr.O0000o;
            o000000o2.O000O0OO = true;
            o000000o2.O0000o00 = gfr.O0000oO;
            o000000o2.O000O0Oo = true;
            o000000o2.O0000o0 = "2882303761517233197";
            o000000o2.O00oOoOo = true;
            o000000o2.O0000o0O = "5541723310197";
            o000000o2.O000O0o0 = true;
            o000000o2.O0000o0o = "http://api.io.mi.com/app/oauth/callback";
            o000000o2.O000O0o = true;
            o000000o2.O0000o = "wx54b959a68fb6f580";
            o000000o2.O000O0oO = true;
            if (!o000000o2.O0000oO0) {
                throw new RuntimeException("debug not set");
            } else if (!o000000o2.O0000oO) {
                throw new RuntimeException("buildType not set");
            } else if (!o000000o2.O0000oOO) {
                throw new RuntimeException("buildId not set");
            } else if (!o000000o2.O0000oOo) {
                throw new RuntimeException("flavor not set");
            } else if (!o000000o2.O0000oo0) {
                throw new RuntimeException("versionCode not set");
            } else if (!o000000o2.O0000oo) {
                throw new RuntimeException("versionName not set");
            } else if (!o000000o2.O0000ooO) {
                throw new RuntimeException("isDebugBuildType not set");
            } else if (!o000000o2.O0000ooo) {
                throw new RuntimeException("isReleaseBuildType not set");
            } else if (!o000000o2.O00oOooO) {
                throw new RuntimeException("isSdkBuildType not set");
            } else if (!o000000o2.O00oOooo) {
                throw new RuntimeException("channel not set");
            } else if (!o000000o2.O000O00o) {
                throw new RuntimeException("isDevChannel not set");
            } else if (!o000000o2.O000O0OO) {
                throw new RuntimeException("isMiuiChannel not set");
            } else if (!o000000o2.O000O0Oo) {
                throw new RuntimeException("isMiAppStoreChannel not set");
            } else if (!o000000o2.O00oOoOo) {
                throw new RuntimeException("miAppID not set");
            } else if (!o000000o2.O000O0o0) {
                throw new RuntimeException("miAppKey not set");
            } else if (!o000000o2.O000O0o) {
                throw new RuntimeException("miRedirectUrl not set");
            } else if (o000000o2.O000O0oO) {
                new fsr(o000000o2, (byte) 0);
                fsq.O000000o o000000o3 = new fsq.O000000o();
                o000000o3.f17069O000000o = fuu.O0000OOo();
                o000000o3.O00000Oo = fvp.O00000o0();
                o000000o3.O00000o0 = new ftr();
                o000000o3.O00000o = new PluginHostApiImpl(getAppContext());
                o000000o3.O00000oO = new PluginActivityHostApiImpl();
                o000000o3.O00000oo = new PluginCommonHostApiImpl();
                o000000o3.O0000O0o = new fnl();
                o000000o3.O0000OOo = new fph();
                o000000o3.O0000Oo0 = new foj();
                o000000o3.O0000Oo = new fct();
                o000000o3.O0000OoO = new fcv();
                o000000o3.O0000Ooo = new fcu();
                o000000o3.O0000o00 = new fda();
                if (o000000o3.f17069O000000o == null) {
                    throw new RuntimeException("CoreHostApi is null");
                } else if (o000000o3.O00000Oo == null) {
                    throw new RuntimeException("PageHostApi is null");
                } else if (o000000o3.O00000o0 == null) {
                    throw new RuntimeException("LoginHostApi is null");
                } else if (o000000o3.O00000o == null) {
                    throw new RuntimeException("PluginHostApi is null");
                } else if (o000000o3.O00000oO == null) {
                    throw new RuntimeException("PluginActivityHostApi is null");
                } else if (o000000o3.O00000oo == null) {
                    throw new RuntimeException("PluginCommonHostApi is null");
                } else if (o000000o3.O0000O0o == null) {
                    throw new RuntimeException("PluginUPnPHostApi is null");
                } else if (o000000o3.O0000OOo == null) {
                    throw new RuntimeException("PluginBluetoothSearchManagerHostApi is null");
                } else if (o000000o3.O0000Oo0 == null) {
                    throw new RuntimeException("PluginBluetoothManagerHostApi is null");
                } else if (o000000o3.O0000Oo == null) {
                    throw new RuntimeException("BleCoreProvider is null");
                } else if (o000000o3.O0000OoO == null) {
                    throw new RuntimeException("ReportProvider is null");
                } else if (o000000o3.O0000Ooo == null) {
                    throw new RuntimeException("BleGreyProvider is null");
                } else if (o000000o3.O0000o00 != null) {
                    fsq fsq = new fsq(o000000o3, (byte) 0);
                    fsp O000000o2 = fsp.O000000o();
                    gsy.O00000Oo("FrameManager", "start");
                    synchronized (fsp.f17064O000000o) {
                        O000000o2.O00000Oo = this;
                        fsp.O0000o0o = null;
                    }
                    if (ftm.O00000o(O000000o2.O00000Oo)) {
                        try {
                            XMPassportSettings.setApplicationContext(this);
                        } catch (Throwable unused) {
                        }
                    }
                    if (!ftm.O00000oO(O000000o2.O00000Oo)) {
                        O000000o2.O0000Oo0 = fsq.f17068O000000o;
                        O000000o2.O00000oo = fsq.O00000o0;
                        O000000o2.O0000O0o = fsq.O00000Oo;
                        O000000o2.O0000OOo = fsq.O00000o;
                        O000000o2.O0000Oo = fsq.O00000oO;
                        O000000o2.O0000OoO = fsq.O00000oo;
                        O000000o2.O0000o0 = fsq.O0000Oo0;
                        O000000o2.O0000o00 = fsq.O0000OOo;
                        O000000o2.O0000Ooo = fsq.O0000O0o;
                        if (ftm.O00000o(O000000o2.O00000Oo)) {
                            O000000o2.O00000oO = new CoreApiStub();
                            CoreApi.O000000o().O000000o((ICoreApi) O000000o2.O00000oO);
                            O000000o2.O00000oO.registerClientApi(new ClientApiStub(fsp.O000000o().O00000Oo, fsp.O000000o().O0000Oo0));
                            CoreService.initCore(new CoreService.O000000o() {
                                /* class _m_j.fsp.AnonymousClass2 */

                                public final void O000000o(boolean z) {
                                    try {
                                        if (gfr.O0000Ooo) {
                                            gsy.O000000o(3, "login", "CoreApiStub onAccountReady isMiLoggedIn=" + z + ",start ipc callback");
                                        }
                                        for (IClientApi onAccountReady : fcy.O000000o().O00000o0()) {
                                            onAccountReady.onAccountReady(fcn.O000000o().O0000OOo(), fcn.O000000o().O00000Oo());
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        if (gfr.O0000Ooo) {
                                            gsy.O000000o(3, "login", "CoreApiStub onAccountReady isMiLoggedIn=" + z + ",ipc exception " + e.getMessage());
                                        }
                                    }
                                }

                                public final void O000000o() {
                                    try {
                                        for (IClientApi onGlobalDynamicSettingReady : fcy.O000000o().O00000o0()) {
                                            onGlobalDynamicSettingReady.onGlobalDynamicSettingReady();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }

                                public final void O00000Oo() {
                                    try {
                                        for (IClientApi onStatisticReady : fcy.O000000o().O00000o0()) {
                                            onStatisticReady.onStatisticReady();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }

                                public final void O00000o0() {
                                    try {
                                        for (IClientApi onPluginReady : fcy.O000000o().O00000o0()) {
                                            onPluginReady.onPluginReady();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }

                                public final void O00000o() {
                                    try {
                                        for (IClientApi onCoreReady : fcy.O000000o().O00000o0()) {
                                            onCoreReady.onCoreReady();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            if (gfr.O0000Ooo) {
                                gsy.O000000o(3, "login", "ClientApiStub registerClientApi CoreAsyncTask end");
                            }
                        } else {
                            O000000o2.O00000o = new ClientApiStub(O000000o2.O00000Oo, O000000o2.O0000Oo0);
                            O000000o2.O00000o0();
                        }
                    }
                    glc.O000000o(this, fsr.O0000OOo);
                } else {
                    throw new RuntimeException("quickConnectProvider is null");
                }
            } else {
                throw new RuntimeException("wxAppID not set");
            }
        } else {
            throw new RuntimeException("CoreServiceWhiteList not set");
        }
    }

    private void initOnlyInMainProcess(boolean z) {
        if (z) {
            doCheckMIUIRebootBugs();
            sNotifier = new exo();
            doSomethingOnCoreReady();
            ezo.O000000o().getPushManagerInstance();
            gzk gzk = gzk.O000000o.f18619O000000o;
            if (ezt.O000000o().isReadyOnApplicationCreate()) {
                getApplication().onApplicationLifeCycleStart();
            }
            if (hza.O000000o((Context) ServiceApplication.getApplication())) {
                gsy.O00000o0(LogType.MIJIA_WIDGET, "zhudong_widget_isFirstLaunchApp", "update_widget");
                hza.O00000Oo((Context) ServiceApplication.getApplication());
                hza.O000000o((Application) ServiceApplication.getApplication());
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [com.xiaomi.smarthome.application.SHApplication, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
     arg types: [com.xiaomi.smarthome.application.SHApplication, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, float):float
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void */
    private void doCheckMIUIRebootBugs() {
        try {
            if (Build.VERSION.SDK_INT >= 29 && grr.O00000oO() && !gpy.O00000o0((Context) this, "miui_reboot_bug", "has_remove_suggestions", false)) {
                ((WifiManager) getSystemService("wifi")).removeNetworkSuggestions(new ArrayList());
                gpy.O000000o((Context) this, "miui_reboot_bug", "has_remove_suggestions", true);
            }
        } catch (Exception e) {
            LogType logType = LogType.GENERAL;
            gsy.O00000o0(logType, "CheckMIUIRebootBugs", "failed! " + e.getMessage());
        }
    }

    public void onTerminate() {
        WxResultHelper.removeInterceptor();
        super.onTerminate();
        if (isMainProcess) {
            BootPageLifeCycleDispatcher bootPageLifeCycleDispatcher = BootPageLifeCycleDispatcher.f9341O000000o;
            BootPageLifeCycleDispatcher.O000000o(this);
        }
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (ftm.O00000o(this)) {
            if (i == 5 || i == 10 || i == 15) {
                exx.O00000Oo.O000000o(MemoryTrimType.OnCloseToDalvikHeapLimit);
                if (exx.f15936O000000o) {
                    ImagePipelineFactory.getInstance().getImagePipeline().clearMemoryCaches();
                }
            } else if (i == 20) {
                ft.O000000o(this).O000000o(new Intent("action.youpin.go.background"));
                exx.O00000Oo.O000000o(MemoryTrimType.OnAppBackgrounded);
            } else if (i == 40 || i == 60 || i == 80) {
                exx.O00000Oo.O000000o(MemoryTrimType.OnSystemLowMemoryWhileAppInForeground);
            }
        }
    }

    public Resources getResources() {
        if (getAppContext() == null) {
            return super.getResources();
        }
        return gwc.O000000o(super.getResources(), ftn.O00000o0(this));
    }

    public void initMonitorConfig() {
        dxq.O000000o(getApplicationContext(), isMainProcess ? true : isMonitorProcess(), new gzj(isMainProcess).f18616O000000o);
    }

    private boolean isMonitorProcess() {
        String O000000o2 = dzj.O000000o();
        return TextUtils.equals(O000000o2, "com.xiaomi.smarthome") || TextUtils.equals(O000000o2, "com.xiaomi.smarthome:core") || TextUtils.equals(O000000o2, "com.xiaomi.smarthome:plugin") || TextUtils.equals(O000000o2, "com.xiaomi.smarthome:plugin0") || TextUtils.equals(O000000o2, "com.xiaomi.smarthome:plugin1") || TextUtils.equals(O000000o2, "com.xiaomi.smarthome:plugin2");
    }

    public ClassLoader createLoader(long j, long j2, String str) {
        return fcq.O000000o(this, j, j2, str);
    }

    private void setMissUUID() {
        goq.O000000o(new Runnable() {
            /* class com.xiaomi.smarthome.application.$$Lambda$SHApplication$YFuD3PLsKdZ14jwWib5B_qnX7oc */

            public final void run() {
                SHApplication.this.lambda$setMissUUID$2$SHApplication();
            }
        });
    }

    public /* synthetic */ void lambda$setMissUUID$2$SHApplication() {
        SharedPreferences sharedPreferences = getSharedPreferences("miss_uuid_s", 4);
        if (TextUtils.isEmpty(sharedPreferences.getString("miss_uuid", null))) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("miss_uuid", UUID.randomUUID().toString());
            edit.commit();
        }
    }
}
