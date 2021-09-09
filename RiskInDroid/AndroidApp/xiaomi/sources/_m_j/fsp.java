package _m_j;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.client.IClientApi;
import com.xiaomi.smarthome.core.server.CoreApiStub;
import com.xiaomi.smarthome.core.server.CoreService;
import com.xiaomi.smarthome.core.server.ICoreApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.host.BasePluginHostApi;
import com.xiaomi.smarthome.frame.plugin.host.PluginActivityHostApi;
import com.xiaomi.smarthome.library.log.LogType;

public final class fsp {

    /* renamed from: O000000o  reason: collision with root package name */
    public static volatile fsp f17064O000000o;
    private static Object O0000o = new Object();
    public static Application O0000o0o = null;
    public Context O00000Oo;
    public IClientApi.Stub O00000o;
    public Handler O00000o0 = new Handler(Looper.getMainLooper());
    public CoreApiStub O00000oO;
    public gtz O00000oo;
    public fsz O0000O0o;
    public BasePluginHostApi O0000OOo;
    public PluginActivityHostApi O0000Oo;
    public ftb O0000Oo0;
    public fej O0000OoO;
    public hmh O0000Ooo;
    public gjm O0000o0;
    public fek O0000o00;
    ServiceConnection O0000o0O = new ServiceConnection() {
        /* class _m_j.fsp.AnonymousClass1 */

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            gsy.O000000o(3, "FrameManager", "onServiceConnected");
            if (gfr.O0000Ooo) {
                gsy.O000000o(3, "login", "FrameManager onServiceConnected");
            }
            ICoreApi O000000o2 = CoreApi.O000000o(iBinder);
            if (gfr.O0000Ooo) {
                gsy.O000000o(3, "login", "FrameManager CoreApi.generateICoreApi generated");
            }
            CoreApi.O000000o().O000000o(O000000o2);
            if (gfr.O0000Ooo) {
                gsy.O000000o(3, "login", "FrameManager setCoreApiProxy end");
            }
            try {
                O000000o2.registerClientApi(fsp.this.O00000o);
                if (gfr.O0000Ooo) {
                    gsy.O000000o(3, "login", "FrameManager registerClientApi end sIsMainProcess=" + gfr.O00oOooO + ",myPid()" + Process.myPid());
                }
            } catch (Exception e) {
                e.printStackTrace();
                gsy.O000000o(3, "login", "FrameManager registerClientApi exception " + e.getMessage());
            }
            if (gfr.O0000Ooo) {
                gsy.O000000o(3, "login", "FrameManager registerClientApi end");
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            String O00000o0 = ftm.O00000o0(ServiceApplication.getAppContext());
            gsy.O000000o(3, "FrameManager", "onServiceDisconnected: component: " + componentName.toString() + " ; process: " + O00000o0);
            fsp fsp = fsp.this;
            try {
                fsp.O00000Oo.unbindService(fsp.O0000o0O);
            } catch (Exception unused) {
            }
            CoreApi O000000o2 = CoreApi.O000000o();
            if (gfr.O0000Ooo) {
                LogType logType = LogType.GENERAL;
                gsy.O00000Oo(logType, "CoreApi", "reset isMain=" + gfr.O00oOooO);
            }
            synchronized (CoreApi.f7432O000000o) {
                O000000o2.O0000Oo0 = null;
                O000000o2.O0000Oo = false;
                O000000o2.O0000OoO = false;
                O000000o2.O0000Ooo = false;
                O000000o2.O0000o00 = false;
                CoreApi.O0000o0 = false;
                O000000o2.O0000oOO = null;
                O000000o2.O0000o0O = false;
                O000000o2.O0000oo0.clear();
            }
            if (gfr.O0000Ooo) {
                LogType logType2 = LogType.GENERAL;
                gsy.O00000Oo(logType2, "CoreApi", "reset:" + Log.getStackTraceString(new Exception()));
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                /* class _m_j.fsp.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    fsp.this.O00000o0();
                }
            }, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
        }
    };
    private volatile Handler O0000oO = null;
    private gpq O0000oO0 = null;

    private fsp() {
    }

    public static fsp O000000o() {
        if (f17064O000000o == null) {
            synchronized (O0000o) {
                if (f17064O000000o == null) {
                    f17064O000000o = new fsp();
                }
            }
        }
        return f17064O000000o;
    }

    public static synchronized void O000000o(Application application) {
        synchronized (fsp.class) {
            if (f17064O000000o == null) {
                O0000o0o = application;
            }
        }
    }

    public static Context O00000Oo() {
        Context context;
        if (f17064O000000o == null) {
            return O0000o0o;
        }
        synchronized (f17064O000000o) {
            context = f17064O000000o.O00000Oo == null ? O0000o0o : f17064O000000o.O00000Oo;
        }
        return context;
    }

    public final void O00000o0() {
        gsy.O00000Oo("FrameManager", "bindCoreService");
        try {
            this.O00000Oo.bindService(new Intent(this.O00000Oo, CoreService.class), this.O0000o0O, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
