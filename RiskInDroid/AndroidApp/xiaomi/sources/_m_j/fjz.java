package _m_j;

import _m_j.fjz;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.ArrayList;
import java.util.List;

public final class fjz {
    private static fjz O00000o;
    private static Object O00000oO = new Object();

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f16507O000000o;
    List<O00000Oo> O00000Oo = new ArrayList();
    private O000000o O00000o0;

    public interface O00000Oo {
        void O00000oO();
    }

    public static fjz O000000o() {
        synchronized (O00000oO) {
            if (O00000o == null) {
                O00000o = new fjz(CommonApplication.getAppContext());
            }
        }
        return O00000o;
    }

    private fjz(Context context) {
        this.f16507O000000o = context;
        this.O00000o0 = new O000000o(this.f16507O000000o);
        this.f16507O000000o.registerReceiver(this.O00000o0, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    class O000000o extends BroadcastReceiver {
        private int O00000Oo = -100;
        private String O00000o;
        private int O00000o0 = -100;

        public O000000o(Context context) {
            String str;
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                this.O00000Oo = -100;
                return;
            }
            this.O00000Oo = activeNetworkInfo.getType();
            if (activeNetworkInfo.getType() == 1) {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo == null) {
                    str = null;
                } else {
                    str = connectionInfo.getSSID();
                }
                this.O00000o = str;
            }
        }

        public final void onReceive(Context context, Intent intent) {
            goq.O00000oO(new Runnable(context) {
                /* class _m_j.$$Lambda$fjz$O000000o$LJwzGFqxdV_bSsUcerZ74_35caA */
                private final /* synthetic */ Context f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    fjz.O000000o.this.O000000o(this.f$1);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(Context context) {
            int i;
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    this.O00000o0 = activeNetworkInfo.getType();
                    String str = null;
                    if (this.O00000o0 != this.O00000Oo) {
                        if (activeNetworkInfo.getType() == 1) {
                            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                            WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
                            if (connectionInfo != null) {
                                str = connectionInfo.getSSID();
                            }
                            this.O00000o = str;
                        } else {
                            this.O00000o = null;
                        }
                        if (this.O00000o0 == 1 || (i = this.O00000Oo) == 1 || i == -100) {
                            fjz.this.O00000Oo();
                        }
                    } else if (activeNetworkInfo.getType() == 1) {
                        WifiManager wifiManager2 = (WifiManager) context.getSystemService("wifi");
                        WifiInfo connectionInfo2 = wifiManager2 != null ? wifiManager2.getConnectionInfo() : null;
                        if (connectionInfo2 != null) {
                            str = connectionInfo2.getSSID();
                        }
                        String str2 = this.O00000o;
                        if (str2 == null || str == null || !str.equals(str2)) {
                            fjz.this.O00000Oo();
                        }
                        this.O00000o = str;
                    } else {
                        this.O00000o = null;
                    }
                    this.O00000Oo = this.O00000o0;
                    return;
                }
                this.O00000o0 = -100;
                if (this.O00000Oo != -100) {
                    fjz.this.O00000Oo();
                }
                this.O00000Oo = -100;
            } catch (Exception unused) {
            }
        }
    }

    public final void O00000Oo() {
        int i = 0;
        while (i < this.O00000Oo.size()) {
            try {
                this.O00000Oo.get(i).O00000oO();
            } catch (Exception unused) {
                this.O00000Oo.remove(i);
                i--;
            }
            i++;
        }
    }

    public final void O000000o(O00000Oo o00000Oo) {
        if (o00000Oo != null) {
            for (O00000Oo next : this.O00000Oo) {
                if (next != null && next.equals(o00000Oo)) {
                    return;
                }
            }
            this.O00000Oo.add(o00000Oo);
        }
    }

    public final void O00000Oo(O00000Oo o00000Oo) {
        if (o00000Oo != null) {
            this.O00000Oo.remove(o00000Oo);
        }
    }

    public final boolean O00000o0() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f16507O000000o.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
