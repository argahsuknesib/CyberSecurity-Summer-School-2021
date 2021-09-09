package com.xiaomi.smarthome.core.server;

import _m_j.fcy;
import _m_j.fdk;
import _m_j.fec;
import _m_j.fix;
import _m_j.fiy;
import _m_j.fju;
import _m_j.fld;
import _m_j.flq;
import _m_j.flt;
import _m_j.fsp;
import _m_j.fsr;
import _m_j.ft;
import _m_j.gfr;
import _m_j.gjn;
import _m_j.gsy;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.LongSparseArray;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.log.LogType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class CoreService extends Service {
    private static Context O00000Oo;
    private static volatile boolean O00000o = false;
    private static boolean O00000o0 = false;
    private static Handler O00000oO;
    public static AtomicBoolean sCoreIsIniting = new AtomicBoolean(false);
    public static List<O000000o> sInitialCallbacks = new ArrayList();
    public static final Object sLock = new Object();

    /* renamed from: O000000o  reason: collision with root package name */
    SceneExecutor f6777O000000o = new SceneExecutor();
    public boolean mIsWifiScanServiceOnCreated = false;
    public flt mWifiScanService = new flt();

    public interface O000000o {
        void O000000o();

        void O000000o(boolean z);

        void O00000Oo();

        void O00000o();

        void O00000o0();
    }

    public interface O00000Oo {
        void O000000o();
    }

    public interface O00000o0 {
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    public static Context getAppContext() {
        Context appContext;
        synchronized (sLock) {
            appContext = CommonApplication.getAppContext();
        }
        return appContext;
    }

    public static boolean isCoreCreate() {
        boolean z;
        synchronized (sLock) {
            z = O00000o0;
        }
        return z;
    }

    public static boolean isCoreReady() {
        boolean z;
        synchronized (sLock) {
            z = O00000o;
        }
        return z;
    }

    public static void isCoreReady(final Context context, final O00000o0 o00000o0) {
        if (context != null && o00000o0 != null) {
            isCoreCreate(context, new O00000Oo() {
                /* class com.xiaomi.smarthome.core.server.CoreService.AnonymousClass1 */

                public final void O000000o() {
                    if (!CoreService.isCoreReady()) {
                        IntentFilter intentFilter = new IntentFilter("CoreService.onCoreReadyInternal");
                        ft.O000000o(context).O000000o(new BroadcastReceiver() {
                            /* class com.xiaomi.smarthome.core.server.CoreService.AnonymousClass1.AnonymousClass2 */

                            public final void onReceive(Context context, Intent intent) {
                                ft.O000000o(context).O000000o(this);
                            }
                        }, intentFilter);
                    } else if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                        CommonApplication.getGlobalHandler().post(new Runnable() {
                            /* class com.xiaomi.smarthome.core.server.CoreService.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                            }
                        });
                    }
                }
            });
        }
    }

    public static void isCoreCreate(final Context context, final O00000Oo o00000Oo) {
        if (context != null && o00000Oo != null) {
            if (!isCoreCreate()) {
                IntentFilter intentFilter = new IntentFilter("CoreService.onCoreCreateInternal");
                ft.O000000o(context).O000000o(new BroadcastReceiver() {
                    /* class com.xiaomi.smarthome.core.server.CoreService.AnonymousClass3 */

                    public final void onReceive(Context context, Intent intent) {
                        ft.O000000o(context).O000000o(this);
                        O00000Oo o00000Oo = o00000Oo;
                        if (o00000Oo != null) {
                            o00000Oo.O000000o();
                        }
                    }
                }, intentFilter);
                context.startService(new Intent(context, CoreService.class));
            } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                o00000Oo.O000000o();
            } else {
                CommonApplication.getGlobalHandler().post(new Runnable() {
                    /* class com.xiaomi.smarthome.core.server.CoreService.AnonymousClass2 */

                    public final void run() {
                        o00000Oo.O000000o();
                    }
                });
            }
        }
    }

    public static void setCoreReady() {
        synchronized (sLock) {
            if (!O00000o) {
                O00000o = true;
                ft.O000000o(getAppContext()).O000000o(new Intent("CoreService.onCoreReadyInternal"));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        return;
     */
    public static void initCore(final O000000o o000000o) {
        if (gfr.O0000Ooo) {
            gsy.O000000o(3, "login", "CoreService initCore in callback=" + o000000o + ",sIsMainProcess=" + gfr.O00oOooO);
        }
        synchronized (sLock) {
            if (O00000o) {
                if (o000000o != null) {
                    onAllReady(o000000o);
                }
            } else if (sCoreIsIniting.getAndSet(true)) {
                sInitialCallbacks.add(o000000o);
            } else {
                fcy.O000000o();
                fcy.O00000Oo().post(new Runnable() {
                    /* class com.xiaomi.smarthome.core.server.CoreService.AnonymousClass4 */

                    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
                        if (_m_j.gfr.O0000Ooo == false) goto L_0x0111;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0108, code lost:
                        _m_j.gsy.O00000Oo(com.xiaomi.smarthome.library.log.LogType.STARTUP, "login", "CoreService CoreService.setCoreReady end");
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0111, code lost:
                        r2 = _m_j.fju.O000000o().O00000o();
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0119, code lost:
                        if (r2 == null) goto L_0x011e;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011b, code lost:
                        _m_j.ftn.O00000o0(r2);
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:51:0x011e, code lost:
                        r2 = com.xiaomi.smarthome.library.log.LogType.STARTUP;
                        _m_j.gsy.O00000Oo(r2, "CoreService", "onCoreReady will be called " + (java.lang.System.currentTimeMillis() - r0) + " process：" + _m_j.ftm.O00000o0(com.xiaomi.smarthome.application.CommonApplication.getAppContext()));
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0148, code lost:
                        return;
                     */
                    public final void run() {
                        long currentTimeMillis = System.currentTimeMillis();
                        flq.O000000o();
                        if (gfr.O0000Ooo) {
                            gsy.O00000Oo(LogType.STARTUP, "login", "CoreService AccountManager.getInstance start");
                        }
                        fdk.O000000o().O00000Oo();
                        O000000o o000000o = o000000o;
                        if (o000000o != null) {
                            boolean O0000Oo0 = fdk.O000000o().O0000Oo0();
                            fdk.O000000o().O0000Oo();
                            o000000o.O000000o(O0000Oo0);
                        }
                        if (gfr.O0000Ooo) {
                            gsy.O00000Oo(LogType.STARTUP, "login", "CoreService GlobalDynamicSettingManager.getInstance start");
                        }
                        fju.O000000o();
                        O000000o o000000o2 = o000000o;
                        if (o000000o2 != null) {
                            o000000o2.O000000o();
                        }
                        fec.O000000o(CoreService.getAppContext()).O000000o(fsr.O0000OOo);
                        fec.O000000o(CoreService.getAppContext()).O000000o(fsp.O000000o().O0000OoO);
                        fec.O000000o(CoreService.getAppContext()).O000000o(fsp.O000000o().O0000Ooo);
                        fec.O000000o(CoreService.getAppContext()).O000000o(fsp.O000000o().O0000o00);
                        gjn.O000000o(fsp.O000000o().O0000o0);
                        if (gfr.O0000Ooo) {
                            gsy.O00000Oo(LogType.STARTUP, "login", "CoreService DeviceManager.getInstance start");
                        }
                        if (gfr.O0000Ooo) {
                            gsy.O00000Oo(LogType.STARTUP, "login", "CoreService StatManager.getInstance start");
                        }
                        fld.O00000o0();
                        O000000o o000000o3 = o000000o;
                        if (o000000o3 != null) {
                            o000000o3.O00000Oo();
                        }
                        if (gfr.O0000Ooo) {
                            gsy.O00000Oo(LogType.STARTUP, "login", "CoreService PluginManager.getInstance start");
                        }
                        O000000o o000000o4 = o000000o;
                        if (o000000o4 != null) {
                            o000000o4.O00000o0();
                        }
                        if (gfr.O0000Ooo) {
                            gsy.O00000Oo(LogType.STARTUP, "login", "CoreService CoreService.setCoreReady start");
                        }
                        O000000o o000000o5 = o000000o;
                        if (o000000o5 != null) {
                            o000000o5.O00000o();
                        }
                        synchronized (CoreService.sLock) {
                            CoreService.setCoreReady();
                            int i = 0;
                            CoreService.sCoreIsIniting.set(false);
                            while (i < CoreService.sInitialCallbacks.size()) {
                                O000000o o000000o6 = CoreService.sInitialCallbacks.get(i);
                                if (o000000o6 != null) {
                                    CoreService.onAllReady(o000000o6);
                                    i++;
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public static void onAllReady(O000000o o000000o) {
        if (o000000o != null) {
            boolean O0000Oo0 = fdk.O000000o().O0000Oo0();
            fdk.O000000o().O0000Oo();
            o000000o.O000000o(O0000Oo0);
            o000000o.O000000o();
            o000000o.O00000Oo();
            o000000o.O00000o0();
            o000000o.O00000o();
        }
    }

    public void onCreate() {
        super.onCreate();
        gsy.O00000Oo("CoreService", "onCreate " + getApplicationContext());
        Context applicationContext = getApplicationContext();
        synchronized (sLock) {
            O00000Oo = applicationContext;
        }
        if (O00000oO == null) {
            O00000oO = new Handler();
        }
        fsp.O000000o().O00000oO.setPromoteStatus(O000000o());
        if (Build.VERSION.SDK_INT == 21 || Build.VERSION.SDK_INT == 22 || Build.VERSION.SDK_INT == 23) {
            O00000Oo();
        }
        fiy.O000000o().O000000o(new fiy.O000000o() {
            /* class com.xiaomi.smarthome.core.server.CoreService.AnonymousClass5 */

            public final void O000000o() {
                CommonApplication.getGlobalWorkerHandler().postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.core.server.CoreService.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        flt flt = CoreService.this.mWifiScanService;
                        flt.O0000O0o = flt;
                        flt.O00000o0 = (PowerManager) flt.O00000o().getSystemService("power");
                        flt.O00000Oo = (WifiManager) flt.O00000o().getSystemService("wifi");
                        try {
                            flt.O00000o = flt.O00000Oo.isWifiEnabled();
                        } catch (Exception unused) {
                            flt.O00000o = false;
                        }
                        flt.O00000o().registerReceiver(flt.O0000Oo0, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
                        flt.O00000o().registerReceiver(flt.O0000Oo0, new IntentFilter("android.net.wifi.STATE_CHANGE"));
                        flt.O00000o().registerReceiver(flt.O0000Oo0, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
                        flt.O00000o().registerReceiver(flt.O0000Oo0, new IntentFilter("android.intent.action.USER_PRESENT"));
                        flt.O00000o().registerReceiver(flt.O0000Oo0, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                        try {
                            int i = Settings.System.getInt(flt.O00000o().getContentResolver(), "wifi_sleep_policy", 0);
                            Settings.System.putInt(flt.O00000o().getContentResolver(), "wifi_sleep_policy", 2);
                            fix.O000000o().O000000o("wifi_sleelp_policy", (long) i);
                            if (flt.O00000oo) {
                                flt.O00000o0();
                            }
                        } catch (Exception unused2) {
                        }
                        CoreService coreService = CoreService.this;
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("com.xiaomi.metoknlp.geofencing.state_change");
                        try {
                            coreService.registerReceiver(coreService.f6777O000000o, intentFilter);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        CoreService.this.mIsWifiScanServiceOnCreated = true;
                    }
                }, 2000);
            }
        });
        fec.O000000o(getAppContext()).O000000o(fsr.O0000OOo);
        fec.O000000o(getAppContext()).O000000o(fsp.O000000o().O0000OoO);
        fec.O000000o(getAppContext()).O000000o(fsp.O000000o().O0000Ooo);
        fec.O000000o(getAppContext()).O000000o(fsp.O000000o().O0000o00);
    }

    public IBinder onBind(Intent intent) {
        return fsp.O000000o().O00000oO;
    }

    public void onDestroy() {
        super.onDestroy();
        gsy.O000000o(6, "SceneExector", "onDestory");
        fiy.O000000o().O000000o(new fiy.O000000o() {
            /* class com.xiaomi.smarthome.core.server.CoreService.AnonymousClass6 */

            public final void O000000o() {
                CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.core.server.CoreService.AnonymousClass6.AnonymousClass1 */

                    public final void run() {
                        if (CoreService.this.mIsWifiScanServiceOnCreated) {
                            flt flt = CoreService.this.mWifiScanService;
                            flt.O00000o().unregisterReceiver(flt.O0000Oo0);
                            flt.O0000OOo.removeMessages(1);
                            flt.O0000O0o = null;
                        }
                    }
                }, 1000);
            }
        });
        try {
            gsy.O000000o(6, "SceneExector", "start unregistor");
            unregisterReceiver(this.f6777O000000o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean O000000o() {
        try {
            Method declaredMethod = Class.forName("com.miui.whetstone.WhetstoneActivityManager").getDeclaredMethod("promoteApplicationLevel", Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, 2);
            return true;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Handler getGlobalHandler() {
        return O00000oO;
    }

    private static void O00000Oo() {
        LongSparseArray longSparseArray;
        Method declaredMethod;
        try {
            Field declaredField = Class.forName("android.content.res.ResourcesImpl").getDeclaredField("sPreloadedDrawables");
            declaredField.setAccessible(true);
            if (declaredField.isAccessible()) {
                LongSparseArray[] longSparseArrayArr = (LongSparseArray[]) declaredField.get(null);
                if (longSparseArrayArr != null) {
                    for (LongSparseArray longSparseArray2 : longSparseArrayArr) {
                        Method declaredMethod2 = LongSparseArray.class.getDeclaredMethod("clear", new Class[0]);
                        if (declaredMethod2 != null) {
                            declaredMethod2.setAccessible(true);
                            declaredMethod2.invoke(longSparseArray2, new Object[0]);
                        }
                    }
                }
            }
            Field declaredField2 = Resources.class.getDeclaredField("sPreloadedColorDrawables");
            declaredField2.setAccessible(true);
            if (declaredField2.isAccessible() && (longSparseArray = (LongSparseArray) declaredField2.get(null)) != null && (declaredMethod = LongSparseArray.class.getDeclaredMethod("clear", new Class[0])) != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(longSparseArray, new Object[0]);
            }
        } catch (Exception unused) {
        }
    }
}
