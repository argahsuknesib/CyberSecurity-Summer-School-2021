package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Parcelable;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.ArrayList;
import java.util.List;

public final class fvi extends fab {
    private static fvi O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    Context f17274O000000o = CommonApplication.getAppContext();
    List<O00000Oo> O00000Oo = new ArrayList();
    private O000000o O00000o = new O000000o();

    public interface O00000Oo {
        void O000000o();

        void O00000Oo();
    }

    private fvi() {
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.f17274O000000o.registerReceiver(this.O00000o, new IntentFilter(intentFilter));
        this.f17274O000000o.registerReceiver(this.O00000o, new IntentFilter("android.net.wifi.STATE_CHANGE"));
    }

    public static fvi O000000o() {
        if (O00000o0 == null) {
            O00000o0 = new fvi();
        }
        return O00000o0;
    }

    public final void O00000o0() {
        fue.O000000o().O00000oo = null;
        int i = 0;
        while (i < this.O00000Oo.size()) {
            try {
                this.O00000Oo.get(i).O000000o();
            } catch (Exception unused) {
                this.O00000Oo.remove(i);
                i--;
            }
            i++;
        }
    }

    public final void O000000o(O00000Oo o00000Oo) {
        if (o00000Oo != null) {
            this.O00000Oo.add(o00000Oo);
        }
    }

    public final void O00000Oo(O00000Oo o00000Oo) {
        if (o00000Oo != null) {
            this.O00000Oo.remove(o00000Oo);
        }
    }

    public final boolean O00000o() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f17274O000000o.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    class O000000o extends BroadcastReceiver {

        /* renamed from: O000000o  reason: collision with root package name */
        public volatile int f17275O000000o = -100;
        public volatile int O00000Oo = -100;
        public volatile String O00000o0;

        public O000000o() {
            CommonApplication.getGlobalWorkerHandler().post(new Runnable(fvi.this) {
                /* class _m_j.fvi.O000000o.AnonymousClass1 */

                public final void run() {
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) CommonApplication.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        O000000o o000000o = O000000o.this;
                        o000000o.f17275O000000o = -100;
                        o000000o.O00000Oo = -100;
                        return;
                    }
                    O000000o o000000o2 = O000000o.this;
                    int type = activeNetworkInfo.getType();
                    o000000o2.f17275O000000o = type;
                    o000000o2.O00000Oo = type;
                    if (activeNetworkInfo.getType() == 1) {
                        try {
                            O000000o.this.O00000o0 = ((WifiManager) CommonApplication.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getSSID();
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0025 */
        public final void onReceive(final Context context, final Intent intent) {
            try {
                if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                    int i = 0;
                    while (i < fvi.this.O00000Oo.size()) {
                        fvi.this.O00000Oo.get(i).O00000Oo();
                        fvi.this.O00000Oo.remove(i);
                        i--;
                        i++;
                    }
                    return;
                }
                CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
                    /* class _m_j.fvi.O000000o.AnonymousClass2 */

                    public final void run() {
                        NetworkInfo networkInfo;
                        NetworkInfo.DetailedState detailedState;
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                        Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                        if (!(parcelableExtra == null || (detailedState = (networkInfo = (NetworkInfo) parcelableExtra).getDetailedState()) == null)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(detailedState.toString());
                            sb.append(", ");
                            String str = "";
                            sb.append(networkInfo.getReason() != null ? networkInfo.getReason() : str);
                            sb.append(", ");
                            sb.append(networkInfo.getExtraInfo() != null ? networkInfo.getExtraInfo() : str);
                            sb.append(", ");
                            if (networkInfo.getReason() != null) {
                                str = networkInfo.getReason();
                            }
                            sb.append(str);
                            gsy.O000000o(6, "WifiState", sb.toString());
                        }
                        if (activeNetworkInfo != null) {
                            O000000o.this.O00000Oo = activeNetworkInfo.getType();
                            String str2 = null;
                            if (O000000o.this.O00000Oo != O000000o.this.f17275O000000o) {
                                if (activeNetworkInfo.getType() == 1) {
                                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                                    WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
                                    if (connectionInfo != null) {
                                        str2 = connectionInfo.getSSID();
                                    }
                                    O000000o.this.O00000o0 = str2;
                                } else {
                                    O000000o.this.O00000o0 = null;
                                }
                                if (O000000o.this.O00000Oo == 1 || O000000o.this.f17275O000000o == 1 || O000000o.this.f17275O000000o == -100) {
                                    fvi.this.O00000o0();
                                }
                            } else if (activeNetworkInfo.getType() == 1) {
                                WifiManager wifiManager2 = (WifiManager) context.getSystemService("wifi");
                                WifiInfo connectionInfo2 = wifiManager2 != null ? wifiManager2.getConnectionInfo() : null;
                                if (connectionInfo2 != null) {
                                    str2 = connectionInfo2.getSSID();
                                }
                                if (O000000o.this.O00000o0 == null || str2 == null || !str2.equals(O000000o.this.O00000o0)) {
                                    fvi.this.O00000o0();
                                }
                                O000000o.this.O00000o0 = str2;
                            } else {
                                O000000o.this.O00000o0 = null;
                            }
                            O000000o o000000o = O000000o.this;
                            o000000o.f17275O000000o = o000000o.O00000Oo;
                            return;
                        }
                        O000000o o000000o2 = O000000o.this;
                        o000000o2.O00000Oo = -100;
                        if (o000000o2.f17275O000000o != -100) {
                            fvi.this.O00000o0();
                        }
                        O000000o.this.f17275O000000o = -100;
                    }
                });
            } catch (Exception unused) {
            }
        }
    }
}
