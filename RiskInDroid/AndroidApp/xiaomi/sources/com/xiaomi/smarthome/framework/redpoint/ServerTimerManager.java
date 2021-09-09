package com.xiaomi.smarthome.framework.redpoint;

import _m_j.dxx;
import _m_j.ftn;
import _m_j.gfr;
import _m_j.goq;
import _m_j.gsg;
import _m_j.gsj;
import _m_j.gsp;
import _m_j.gsy;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.log.LogType;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Future;
import okhttp3.Response;
import org.json.JSONObject;

public class ServerTimerManager {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f8637O000000o = "ServerTimerManager";
    public static volatile ServerTimerManager O00000Oo;
    private static Pair<Long, Boolean> O0000O0o;
    private static long O0000OOo;
    public long O00000o = -1;
    public long O00000o0 = -1;
    public WeakReference<Context> O00000oO;
    public O000000o O00000oo;

    private ServerTimerManager(Context context) {
        this.O00000oO = new WeakReference<>(context.getApplicationContext());
        this.O00000oo = new O000000o();
    }

    public static ServerTimerManager O000000o(Context context) {
        if (O00000Oo == null) {
            synchronized (ServerTimerManager.class) {
                if (O00000Oo == null) {
                    O00000Oo = new ServerTimerManager(context);
                }
            }
        }
        return O00000Oo;
    }

    public final boolean O000000o() {
        long j = this.O00000o0;
        if (j == -1) {
            return false;
        }
        long j2 = this.O00000o;
        return (j2 == -1 || j == 0 || j2 == 0) ? false : true;
    }

    public final long O00000Oo() {
        LogType logType = LogType.GENERAL;
        gsy.O000000o(logType, "ProfileRedPointManager", "isServerTimeValid" + O000000o());
        if (O000000o()) {
            return this.O00000o0 - this.O00000o;
        }
        return 0;
    }

    private static void O000000o(long j) {
        String str;
        ServerBean O000000o2 = ftn.O000000o(CommonApplication.getAppContext());
        if (O000000o2 == null) {
            str = "cn";
        } else {
            str = O000000o2.f7546O000000o;
        }
        SharedPreferences.Editor edit = CommonApplication.getAppContext().getSharedPreferences("sh_timediff_sp", 0).edit();
        edit.putLong(str + "_timediff", j).apply();
    }

    private static long O00000o() {
        String str;
        ServerBean O000000o2 = ftn.O000000o(CommonApplication.getAppContext());
        if (O000000o2 == null) {
            str = "cn";
        } else {
            str = O000000o2.f7546O000000o;
        }
        SharedPreferences sharedPreferences = CommonApplication.getAppContext().getSharedPreferences("sh_timediff_sp", 0);
        long j = sharedPreferences.getLong(str + "_timediff", 0);
        gsy.O00000o0(LogType.NETWORK, f8637O000000o, "get timeDiff from SP:".concat(String.valueOf(j)));
        return j;
    }

    public static Pair<Long, Boolean> O00000o0() {
        String str;
        ServerBean O000000o2 = ftn.O000000o(CommonApplication.getAppContext());
        if (O000000o2 == null || ftn.O00000o0(O000000o2)) {
            str = "https://api.io.mi.com/app/v2/public/get_timestamp";
        } else {
            str = "https://" + O000000o2.f7546O000000o + ".api.io.mi.com/app/v2/public/get_timestamp";
        }
        try {
            if (gfr.O0000Ooo) {
                gsy.O00000Oo(LogType.NETWORK, f8637O000000o, "getServerTimeSync start");
            }
            gsj.O000000o O00000Oo2 = new gsj.O000000o().O00000Oo(str);
            O00000Oo2.f18212O000000o = "GET";
            try {
                O0000O0o = (Pair) gsg.O000000o(O00000Oo2.O000000o(), new gsp<Pair<Long, Boolean>>() {
                    /* class com.xiaomi.smarthome.framework.redpoint.ServerTimerManager.AnonymousClass1 */

                    public final /* synthetic */ Object O000000o(Response response) throws Exception {
                        long optLong = new JSONObject(response.body().string()).optJSONObject("result").optLong("timestamp");
                        gsy.O00000o0(LogType.NETWORK, ServerTimerManager.f8637O000000o, "public/get_timestamp ts=".concat(String.valueOf(optLong)));
                        return new Pair(Long.valueOf((optLong * 1000) - System.currentTimeMillis()), Boolean.TRUE);
                    }
                });
                O0000OOo = System.currentTimeMillis();
                O000000o(((Long) O0000O0o.first).longValue());
                return O0000O0o;
            } catch (Exception e) {
                gsy.O00000o0(LogType.NETWORK, f8637O000000o, "public/get_timestamp exception " + e.getMessage());
                URL url = new URL(str);
                dxx.O000000o();
                URLConnection O000000o3 = dxx.O000000o(url);
                O000000o3.setConnectTimeout(C.MSG_CUSTOM_BASE);
                try {
                    O000000o3.connect();
                    long date = O000000o3.getDate();
                    if (Math.abs(date) < 10) {
                        return new Pair<>(Long.valueOf(O00000o()), Boolean.TRUE);
                    }
                    if (gfr.O0000Ooo) {
                        gsy.O00000Oo(LogType.NETWORK, f8637O000000o, "getServerTimeSync success");
                    }
                    O0000O0o = new Pair<>(Long.valueOf(date - System.currentTimeMillis()), Boolean.TRUE);
                    O0000OOo = System.currentTimeMillis();
                    O000000o(((Long) O0000O0o.first).longValue());
                    return O0000O0o;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return O00000oO();
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            return O00000oO();
        }
    }

    private static Pair<Long, Boolean> O00000oO() {
        try {
            if (gfr.O0000Ooo) {
                gsy.O00000Oo(LogType.NETWORK, f8637O000000o, "getServerTimeSync start");
            }
            URL url = new URL("https://account.xiaomi.com/pass/serviceLogin");
            dxx.O000000o();
            URLConnection O000000o2 = dxx.O000000o(url);
            O000000o2.setConnectTimeout(C.MSG_CUSTOM_BASE);
            try {
                O000000o2.connect();
                long date = O000000o2.getDate();
                if (gfr.O0000Ooo) {
                    gsy.O00000Oo(LogType.NETWORK, f8637O000000o, "getServerTimeSync success");
                }
                O0000O0o = new Pair<>(Long.valueOf(date - System.currentTimeMillis()), Boolean.TRUE);
                O0000OOo = System.currentTimeMillis();
                O000000o(((Long) O0000O0o.first).longValue());
                return O0000O0o;
            } catch (Exception e) {
                e.printStackTrace();
                LogType logType = LogType.NETWORK;
                gsy.O00000Oo(logType, f8637O000000o, "getServerTimeSync fail1:" + e.getMessage() + ":" + "https://account.xiaomi.com/pass/serviceLogin");
                return new Pair<>(Long.valueOf(O00000o()), Boolean.TRUE);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogType logType2 = LogType.NETWORK;
            gsy.O00000Oo(logType2, f8637O000000o, "getServerTimeSync fail2:" + e2.getMessage() + ":" + "https://account.xiaomi.com/pass/serviceLogin");
            return new Pair<>(Long.valueOf(O00000o()), Boolean.TRUE);
        }
    }

    public static class InternationalServerTimerException extends Exception {
        public InternationalServerTimerException(String str) {
            super(str);
        }
    }

    public static class ServerTimerException extends Exception {
        public ServerTimerException(String str) {
            super(str);
        }
    }

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public BroadcastReceiver f8638O000000o = new BroadcastReceiver() {
            /* class com.xiaomi.smarthome.framework.redpoint.ServerTimerManager.O000000o.AnonymousClass1 */

            public final void onReceive(Context context, Intent intent) {
                ServerTimerManager.this.O00000o0 = -1;
                ServerTimerManager.this.O00000o = -1;
                O000000o.this.O000000o();
            }
        };
        private IntentFilter O00000o = new IntentFilter();
        private Future<?> O00000o0;

        public O000000o() {
            this.O00000o.addAction("android.intent.action.TIME_SET");
            this.O00000o.addAction("android.intent.action.DATE_CHANGED");
            ServerTimerManager.this.O00000oO.get().registerReceiver(this.f8638O000000o, this.O00000o);
        }

        public final void O000000o() {
            Future<?> future = this.O00000o0;
            if (future != null) {
                future.cancel(true);
            }
            this.O00000o0 = goq.O00000Oo(new Runnable() {
                /* class com.xiaomi.smarthome.framework.redpoint.ServerTimerManager.O000000o.AnonymousClass2 */

                public final void run() {
                    ServerTimerManager.this.O00000o0 = ((Long) ServerTimerManager.O00000o0().first).longValue();
                    if (ServerTimerManager.this.O00000o0 == 0) {
                        ServerTimerManager.this.O00000o0 = -1;
                        ServerTimerManager.this.O00000o = System.currentTimeMillis();
                        return;
                    }
                    ServerTimerManager.this.O00000o = System.currentTimeMillis();
                    ServerTimerManager.this.O00000o0 += ServerTimerManager.this.O00000o;
                }
            });
        }
    }
}
