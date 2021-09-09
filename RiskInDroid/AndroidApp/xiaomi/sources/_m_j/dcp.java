package _m_j;

import _m_j.hlz;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.android.bluetooth.ble.app.IMiuiNearbyApiService;
import com.android.bluetooth.ble.app.IMiuiNearbyDialogService;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class dcp implements Handler.Callback {
    private static volatile dcp O0000OoO;

    /* renamed from: O000000o  reason: collision with root package name */
    public volatile Context f14478O000000o = null;
    public String O00000Oo = "";
    public Handler O00000o = new Handler(Looper.getMainLooper(), this);
    public boolean O00000o0 = false;
    public dcq O00000oO;
    public Application.ActivityLifecycleCallbacks O00000oo = null;
    public ConcurrentLinkedQueue<String> O0000O0o = new ConcurrentLinkedQueue<>();
    public ConcurrentHashMap<String, String> O0000OOo = new ConcurrentHashMap<>();
    public boolean O0000Oo = false;
    public String O0000Oo0 = "";
    private final int O0000Ooo = 1002;
    private boolean O0000o0 = false;
    private volatile boolean O0000o00 = false;
    private ServiceConnection O0000o0O = new ServiceConnection() {
        /* class _m_j.dcp.AnonymousClass2 */

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            dct.O00000oO("MiConnectMiuiServiceNew onServiceConnected");
            IMiuiNearbyDialogService asInterface = IMiuiNearbyDialogService.Stub.asInterface(iBinder);
            if (asInterface != null) {
                dcp.this.O00000oO = new dcr(asInterface);
                while (!dcp.this.O0000O0o.isEmpty()) {
                    dcp.this.O00000oO.O00000Oo(dcp.this.O0000O0o.poll());
                }
                Iterator<Map.Entry<String, String>> it = dcp.this.O0000OOo.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry next = it.next();
                    dcp.this.O00000oO.O000000o((String) next.getKey(), (String) next.getValue());
                    it.remove();
                }
                return;
            }
            dct.O00000o0("miuiNearbyDialogService is null! can not build MiConnectMiuiServiceNew");
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            dct.O00000oO("MiConnectMiuiServiceNew onServiceDisconnected");
            dcp.this.O00000oO = null;
        }
    };
    private ServiceConnection O0000o0o = new ServiceConnection() {
        /* class _m_j.dcp.AnonymousClass3 */

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            dct.O00000oO("MiConnectMiuiServiceOld onServiceConnected");
            IMiuiNearbyApiService asInterface = IMiuiNearbyApiService.Stub.asInterface(iBinder);
            if (asInterface != null) {
                dcp.this.O00000oO = new dcs(asInterface);
                while (!dcp.this.O0000O0o.isEmpty()) {
                    dcp.this.O00000oO.O00000Oo(dcp.this.O0000O0o.poll());
                }
                Iterator<Map.Entry<String, String>> it = dcp.this.O0000OOo.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry next = it.next();
                    dcp.this.O00000oO.O000000o((String) next.getKey(), (String) next.getValue());
                    it.remove();
                }
                return;
            }
            dct.O00000o0("mMiuiNearbyApiService is null! can not build MiConnectMiuiServiceOld");
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            dct.O00000oO("MiConnectMiuiServiceOld onServiceDisconnected");
            dcp.this.O00000oO = null;
        }
    };

    public boolean handleMessage(Message message) {
        if (message.what != 1002) {
            return false;
        }
        if (!this.O0000o00) {
            return true;
        }
        O00000o0(false);
        return true;
    }

    public class O000000o implements Application.ActivityLifecycleCallbacks {

        /* renamed from: O000000o  reason: collision with root package name */
        public List<WeakReference<Activity>> f14482O000000o;
        private AtomicInteger O00000o0;

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        private O000000o() {
            this.f14482O000000o = new ArrayList();
        }

        public /* synthetic */ O000000o(dcp dcp, byte b) {
            this();
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof dck) {
                dct.O00000oO("Lifecycle add to weakReference");
                this.f14482O000000o.add(new WeakReference(activity));
            }
        }

        public final void onActivityStarted(Activity activity) {
            AtomicInteger atomicInteger = this.O00000o0;
            if (atomicInteger == null) {
                this.O00000o0 = new AtomicInteger(1);
            } else {
                atomicInteger.incrementAndGet();
            }
        }

        public final void onActivityStopped(final Activity activity) {
            int decrementAndGet = this.O00000o0.decrementAndGet();
            dct.O00000oO("Lifecycle onStop ".concat(String.valueOf(decrementAndGet)));
            if (!dcp.this.O00000o0 && activity != null && this.O00000o0 != null && decrementAndGet == 0) {
                dct.O00000oO("Lifecycle finish");
                dcp.this.O00000o.postDelayed(new Runnable() {
                    /* class _m_j.dcp.O000000o.AnonymousClass1 */

                    public final void run() {
                        KeyguardManager keyguardManager = (KeyguardManager) activity.getSystemService("keyguard");
                        boolean isKeyguardLocked = keyguardManager != null ? keyguardManager.isKeyguardLocked() : false;
                        dct.O00000oO("Lifecycle isLock ".concat(String.valueOf(isKeyguardLocked)));
                        if (!isKeyguardLocked) {
                            dcp.O000000o().O000000o(activity);
                            for (WeakReference<Activity> weakReference : O000000o.this.f14482O000000o) {
                                Activity activity = (Activity) weakReference.get();
                                if (activity != null && !activity.isFinishing()) {
                                    dct.O00000oO("Lifecycle activity finish");
                                    activity.finish();
                                }
                            }
                        }
                    }
                }, 500);
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            dct.O00000oO("Lifecycle destroy ");
        }
    }

    private dcp() {
    }

    public static dcp O000000o() {
        if (O0000OoO == null) {
            synchronized (dcp.class) {
                if (O0000OoO == null) {
                    O0000OoO = new dcp();
                }
            }
        }
        return O0000OoO;
    }

    public final void O000000o(Context context) {
        if (this.f14478O000000o == null) {
            synchronized (this) {
                if (this.f14478O000000o == null) {
                    this.f14478O000000o = context;
                }
            }
        }
        dct.O00000oO("connectMiui init");
        O00000o();
    }

    public final boolean O00000Oo() {
        return this.O00000oO != null;
    }

    public final boolean O00000o0() {
        return this.O0000Oo || this.O0000o00 || this.O0000o0;
    }

    public final void O000000o(Activity activity) {
        this.O00000o0 = false;
        this.O0000Oo = false;
        if (this.O00000oo != null) {
            activity.getApplication().unregisterActivityLifecycleCallbacks(this.O00000oo);
            this.O00000oo = null;
        }
        dct.O00000oO("Miui finish 0");
        if (this.O00000oO != null) {
            dct.O00000oO("Miui dialog service finish 1");
            if (!TextUtils.isEmpty(this.O0000Oo0)) {
                dct.O00000oO("Miui dialog service finish 2");
                this.O00000oO.O0000O0o(this.O0000Oo0);
                O00000o(true);
                return;
            }
            return;
        }
        dct.O00000o0("miuiService is null!");
    }

    public final void O000000o(String str) {
        this.O0000Oo = false;
        dcq dcq = this.O00000oO;
        if (dcq != null) {
            dcq.O000000o(str);
        } else {
            dct.O00000o0("miuiService is null!");
        }
    }

    public final void O000000o(boolean z) {
        this.O00000o0 = z;
        O00000o(!z);
    }

    public final void O00000Oo(boolean z) {
        this.O0000o0 = z;
        O00000o(!z);
    }

    public final void O00000Oo(String str) {
        CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new CoreApi.O0000o0(str) {
            /* class _m_j.$$Lambda$dcp$ZH43WG2WFpkkp0Io3BWqvdnyTY */
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onCoreReady() {
                dcp.this.O00000o(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(String str) {
        hlz.O000000o(str, new fsm<hlz.O000000o, fso>() {
            /* class _m_j.dcp.AnonymousClass1 */

            public final void onFailure(fso fso) {
            }

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                dcp.this.O00000Oo = ((hlz.O000000o) obj).f19057O000000o;
            }
        });
    }

    public final void O00000o() {
        dct.O00000oO("connectMiui");
        if (this.O00000oO == null) {
            try {
                Intent intent = new Intent();
                intent.setPackage("com.xiaomi.bluetooth");
                intent.setAction("miui.bluetooth.mible.MiuiNearbyDialogService");
                List<ResolveInfo> queryIntentServices = this.f14478O000000o.getPackageManager().queryIntentServices(intent, 64);
                if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                    dct.O00000oO("new aidl service is null");
                    Intent intent2 = new Intent();
                    intent2.setPackage("com.xiaomi.bluetooth");
                    intent2.setAction("miui.bluetooth.mible.MiuiNearbyApiService");
                    List<ResolveInfo> queryIntentServices2 = this.f14478O000000o.getPackageManager().queryIntentServices(intent2, 64);
                    if (queryIntentServices2 == null || queryIntentServices2.isEmpty()) {
                        dct.O00000oO("old aidl service is null");
                        return;
                    }
                    this.f14478O000000o.bindService(intent2, this.O0000o0o, 1);
                    dct.O00000oO("Miui start bind old aidl service");
                    return;
                }
                this.f14478O000000o.bindService(intent, this.O0000o0O, 1);
                dct.O00000oO("Miui start bind new aidl service");
            } catch (Exception e) {
                e.printStackTrace();
                dct.O00000oo("start bind service Exception");
            }
        }
    }

    public final void O00000o0(boolean z) {
        dct.O00000oO("setMiuiPop ".concat(String.valueOf(z)));
        this.O00000o.removeMessages(1002);
        if (z) {
            this.O00000o.sendEmptyMessageDelayed(1002, 150000);
        } else {
            dct.O00000o0("miuiService is null!");
        }
        this.O0000o00 = z;
    }

    private void O00000o(boolean z) {
        dcq dcq = this.O00000oO;
        if (dcq != null) {
            dcq.O000000o(z);
        } else {
            dct.O00000o0("miuiService is null!");
        }
    }

    public final String O00000o0(String str) {
        String str2;
        String[] split;
        String[] split2;
        dct.O00000oO("getWifiInfo");
        dcq dcq = this.O00000oO;
        if (dcq != null) {
            str2 = dcq.O00000o0(str);
        } else {
            dct.O00000o0("miuiService is null!");
            str2 = "";
        }
        if (TextUtils.isEmpty(str2) || (split = str2.split(";")) == null || split.length <= 2 || (split2 = split[1].split(":")) == null || split2.length != 2) {
            return null;
        }
        return split2[1];
    }
}
