package _m_j;

import _m_j.dxr;
import _m_j.dxz;
import _m_j.dyq;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.miot.support.monitor.broadcastreceiver.MonitorConfigBroadCastReceiver;
import java.util.ArrayList;
import java.util.Iterator;

public final class dxq {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile boolean f15036O000000o = false;

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0071, code lost:
        return;
     */
    public static synchronized void O000000o(Context context, boolean z, dxy dxy) {
        synchronized (dxq.class) {
            if (context != null) {
                if (z) {
                    if (dxy != null) {
                        if (!f15036O000000o) {
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction("com.xiaomi.miot.support.monitor");
                            context.registerReceiver(new MonitorConfigBroadCastReceiver(), intentFilter);
                            f15036O000000o = true;
                            dxr dxr = dxr.O000000o.f15041O000000o;
                            if (context != null) {
                                dxr.O00000Oo = context;
                                dxr.O00000o = new Handler(Looper.getMainLooper());
                            }
                            dxr dxr2 = dxr.O000000o.f15041O000000o;
                            try {
                                if (dxr2.O00000Oo != null) {
                                    dxr2.O00000oO = dxy;
                                    if (dxr2.O00000oO != null) {
                                        String O000000o2 = dzi.O000000o(dxr2.O00000Oo.getApplicationContext()).O000000o("key_monitor_config");
                                        if (!TextUtils.isEmpty(O000000o2)) {
                                            dxz.O000000o.f15051O000000o.O000000o(O000000o2);
                                        }
                                        dyt.O000000o().f15080O000000o = dxr2.O00000oO.O0000Oo0.http_dns_priority;
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    public static synchronized void O000000o() {
        synchronized (dxq.class) {
            O0000Oo();
            O0000Ooo();
        }
    }

    public static synchronized void O00000Oo() {
        synchronized (dxq.class) {
            if (f15036O000000o) {
                dxr.O000000o.f15041O000000o.O00000Oo();
                O0000OoO();
            }
        }
    }

    public static synchronized void O00000o0() {
        synchronized (dxq.class) {
            f15036O000000o = false;
            dxr.O000000o.f15041O000000o.O00000o0();
            dyq dyq = dyq.O000000o.f15075O000000o;
            if (dyq.f15074O000000o != null) {
                dyq.f15074O000000o.clear();
            }
            if (dyy.f15089O000000o != null) {
                dyu dyu = dyy.f15089O000000o;
                if (dyu.O00000Oo != null) {
                    dyu.O00000Oo.unregisterActivityLifecycleCallbacks(dyu.O00000oO);
                    dyu.f15081O000000o = false;
                }
                if (dyu.O00000o != null) {
                    dyu.O00000o.O00000Oo();
                    dyu.O00000o = null;
                }
                dyy.f15089O000000o = null;
            }
        }
    }

    public static synchronized void O00000o() {
        synchronized (dxq.class) {
            O000000o("enter_app");
        }
    }

    public static synchronized void O00000oO() {
        synchronized (dxq.class) {
            O000000o("exit_app");
        }
    }

    public static synchronized void O00000oo() {
        synchronized (dxq.class) {
            O000000o("update_config");
        }
    }

    public static synchronized void O0000O0o() {
        synchronized (dxq.class) {
            O000000o("stop_monitor");
        }
    }

    public static synchronized void O0000Oo0() {
        synchronized (dxq.class) {
            O000000o("report_net");
        }
    }

    private static synchronized void O0000Oo() {
        synchronized (dxq.class) {
            dxr.O000000o.f15041O000000o.O00000o0();
        }
    }

    private static synchronized void O0000OoO() {
        synchronized (dxq.class) {
            dxr dxr = dxr.O000000o.f15041O000000o;
            dxr.O000000o(dxr.O00000Oo, true);
            Iterator it = new ArrayList().iterator();
            while (it.hasNext()) {
                Bitmap bitmap = (Bitmap) it.next();
                if (bitmap != null) {
                    gsy.O000000o(3, "MiotMonitorClient", bitmap.toString() + " has leak");
                }
            }
        }
    }

    private static synchronized void O0000Ooo() {
        synchronized (dxq.class) {
            dxr dxr = dxr.O000000o.f15041O000000o;
            if (dyy.f15089O000000o != null) {
                dyu dyu = dyy.f15089O000000o;
                if (dyu.O00000Oo != null) {
                    dyu.O00000Oo.unregisterActivityLifecycleCallbacks(dyu.O00000oO);
                    dyu.f15081O000000o = false;
                }
                if (dyu.O00000o != null) {
                    dyu.O00000o.O00000Oo();
                }
            }
        }
    }

    public static synchronized void O0000OOo() {
        synchronized (dxq.class) {
            if (!dxr.O000000o.f15041O000000o.O00000o0) {
                O000000o("start_monitor");
            }
        }
    }

    private static synchronized void O000000o(String str) {
        synchronized (dxq.class) {
            if (dxr.O000000o.f15041O000000o.O00000Oo != null) {
                Intent intent = new Intent("com.xiaomi.miot.support.monitor");
                String packageName = dxr.O000000o.f15041O000000o.O00000Oo.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    intent.setPackage(packageName);
                }
                intent.putExtra("type", str);
                dxr.O000000o.f15041O000000o.O00000Oo.sendBroadcast(intent);
            }
        }
    }
}
