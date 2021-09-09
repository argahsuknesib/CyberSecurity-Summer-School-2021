package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.idm.tap.dispatcher.impl.AbstractActionExecutor;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.nfctag.ui.NFCConnectWifiActivity;
import java.util.List;

public final class hiy extends AbstractActionExecutor {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f18968O000000o;
    public Context O00000Oo;
    private String O00000o;
    public WifiManager O00000o0;

    public hiy(Context context, String str, String str2) {
        this.O00000Oo = context;
        this.f18968O000000o = str;
        this.O00000o = str2;
        this.O00000o0 = (WifiManager) context.getSystemService("wifi");
    }

    public final boolean execute() {
        boolean z;
        if (this.O00000Oo == null) {
            return false;
        }
        try {
            z = this.O00000o0.isWifiEnabled();
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            return O000000o();
        }
        Context context = this.O00000Oo;
        context.startActivity(new Intent(context, NFCConnectWifiActivity.class));
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fux.O000000o(android.app.Activity, boolean, int):boolean
     arg types: [android.app.Activity, int, ?]
     candidates:
      _m_j.fux.O000000o(android.app.Activity, int, _m_j.fux$O000000o):boolean
      _m_j.fux.O000000o(android.app.Activity, boolean, int):boolean */
    private boolean O000000o() {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        iag.O000000o(wifiConfiguration, this.f18968O000000o, this.O00000o, "[WPA-PSK-CCMP+TKIP][WPA2-PSK-CCMP+TKIP][RSN-PSK-CCMP+TKIP][ESS][WPS]");
        int addNetwork = this.O00000o0.addNetwork(wifiConfiguration);
        if (addNetwork == -1) {
            gsy.O00000Oo("NFCHelper", "netId == -1 first time");
            if (oOOO00o0.O000000o(this.O00000Oo, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                List<WifiConfiguration> configuredNetworks = this.O00000o0.getConfiguredNetworks();
                int i = 0;
                while (true) {
                    if (i < configuredNetworks.size()) {
                        if (configuredNetworks.get(i).SSID != null && TextUtils.equals(configuredNetworks.get(i).SSID, jdn.f1779O000000o.concat(this.f18968O000000o).concat(jdn.f1779O000000o)) && configuredNetworks.get(i).networkId != -1) {
                            addNetwork = configuredNetworks.get(i).networkId;
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
            } else {
                Context context = this.O00000Oo;
                if (context instanceof Activity) {
                    fux.O000000o((Activity) context, true, (int) R.string.nfc_permission_location_rational_desc);
                } else {
                    hte.O000000o(ServiceApplication.getAppContext(), (int) R.string.nfc_permission_location_rational_desc);
                }
                return false;
            }
        }
        if (addNetwork == -1) {
            return false;
        }
        gsy.O00000Oo("NFCHelper", "enable to netid ".concat(String.valueOf(addNetwork)));
        this.O00000o0.enableNetwork(addNetwork, true);
        this.O00000o0.reconnect();
        if (Build.VERSION.SDK_INT >= 21) {
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(1);
            NetworkRequest build = builder.build();
            final ConnectivityManager connectivityManager = (ConnectivityManager) this.O00000Oo.getSystemService("connectivity");
            AnonymousClass1 r2 = new ConnectivityManager.NetworkCallback() {
                /* class _m_j.hiy.AnonymousClass1 */

                public final void onAvailable(Network network) {
                    super.onAvailable(network);
                    String ssid = hiy.this.O00000o0.getConnectionInfo().getSSID();
                    gsy.O00000Oo("NFCHelper", "current ssid ".concat(String.valueOf(ssid)));
                    if (TextUtils.equals(jdn.f1779O000000o.concat(hiy.this.f18968O000000o).concat(jdn.f1779O000000o), ssid)) {
                        connectivityManager.unregisterNetworkCallback(this);
                        gps.O000000o(hiy.this.O00000Oo, hiy.this.O00000Oo.getString(R.string.nfc_wifi_push_title), hiy.this.O00000Oo.getString(R.string.nfc_connect_wifi_success));
                    }
                }

                public final void onUnavailable() {
                    super.onUnavailable();
                    connectivityManager.unregisterNetworkCallback(this);
                }
            };
            if (Build.VERSION.SDK_INT >= 26) {
                connectivityManager.requestNetwork(build, r2, 5000);
            } else {
                connectivityManager.requestNetwork(build, r2);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable(connectivityManager, r2) {
                    /* class _m_j.$$Lambda$hiy$4TOORS98Frhm_Q8tO6YOTpdBCo */
                    private final /* synthetic */ ConnectivityManager f$0;
                    private final /* synthetic */ ConnectivityManager.NetworkCallback f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final void run() {
                        this.f$0.unregisterNetworkCallback(this.f$1);
                    }
                }, 5000);
            }
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(addNetwork) {
                /* class _m_j.$$Lambda$hiy$htAVGS1sz6ENKMy_iYvofWHxJY8 */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    hiy.this.O000000o(this.f$1);
                }
            }, 3000);
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004e, code lost:
        if (r0.getState() != android.net.NetworkInfo.State.DISCONNECTED) goto L_0x0052;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    public /* synthetic */ void O000000o(int i) {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.O00000Oo.getSystemService("connectivity");
        boolean z = true;
        if (connectivityManager == null) {
            gsy.O00000Oo("NFCHelper", "当前网络已断开");
        } else {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (!(activeNetworkInfo == null || activeNetworkInfo.getType() != 1 || this.O00000o0.getConnectionInfo() == null)) {
                if (TextUtils.equals(jdn.f1779O000000o.concat(this.f18968O000000o).concat(jdn.f1779O000000o), this.O00000o0.getConnectionInfo().getSSID())) {
                    if (i == -1) {
                    }
                    if (!z) {
                        Context context = this.O00000Oo;
                        gps.O000000o(context, context.getString(R.string.nfc_wifi_push_title), this.O00000Oo.getString(R.string.nfc_connect_wifi_success));
                        return;
                    }
                    return;
                }
            }
        }
        z = false;
        if (!z) {
        }
    }
}
