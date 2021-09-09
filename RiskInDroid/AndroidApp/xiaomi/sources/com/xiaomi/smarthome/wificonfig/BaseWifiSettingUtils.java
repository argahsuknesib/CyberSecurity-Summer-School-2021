package com.xiaomi.smarthome.wificonfig;

import _m_j.gjm;
import _m_j.gjn;
import _m_j.gpn;
import _m_j.iad;
import _m_j.jdn;
import _m_j.oOOO00o0;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkSpecifier;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.Iterator;
import java.util.List;

public class BaseWifiSettingUtils {

    public enum PskType {
        UNKNOWN,
        WPA,
        WPA2,
        WPA_WPA2
    }

    public enum TKIPType {
        TKIP_CCMP,
        TKIP,
        CCMP,
        NONE
    }

    public static int O000000o(WifiConfiguration wifiConfiguration) {
        return wifiConfiguration.allowedKeyManagement.get(1) ? 2 : 0;
    }

    public static String O000000o(String str) {
        return jdn.f1779O000000o + str + jdn.f1779O000000o;
    }

    public static TKIPType O000000o(ScanResult scanResult) {
        boolean contains = scanResult.capabilities.contains("TKIP");
        boolean contains2 = scanResult.capabilities.contains("CCMP");
        if (contains && contains2) {
            return TKIPType.TKIP_CCMP;
        }
        if (contains) {
            return TKIPType.TKIP;
        }
        if (contains2) {
            return TKIPType.CCMP;
        }
        return TKIPType.NONE;
    }

    private static TKIPType O00000o0(String str) {
        if (str.equalsIgnoreCase("psk2")) {
            return TKIPType.CCMP;
        }
        return TKIPType.TKIP_CCMP;
    }

    public static int O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.equalsIgnoreCase("psk2") || str.equalsIgnoreCase("mixed-psk")) {
            return 2;
        }
        if (str.contains("WEP")) {
            return 1;
        }
        if (str.contains("PSK")) {
            return 2;
        }
        if (str.contains("EAP")) {
            return 3;
        }
        if (str.contains("WAPI")) {
            return 4;
        }
        return 0;
    }

    public static int O00000Oo(ScanResult scanResult) {
        if (scanResult != null && !TextUtils.isEmpty(scanResult.capabilities)) {
            if (scanResult.capabilities.contains("WEP")) {
                return 1;
            }
            if (scanResult.capabilities.contains("PSK")) {
                return 2;
            }
            if (scanResult.capabilities.contains("EAP")) {
                return 3;
            }
            if (scanResult.capabilities.contains("WAPI")) {
                return 4;
            }
        }
        return 0;
    }

    public static boolean O000000o(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str.startsWith(jdn.f1779O000000o) && str.length() > 2) {
            str = str.substring(1, str.length() - 1);
        }
        if (str2.startsWith(jdn.f1779O000000o) && str2.length() > 2) {
            str2 = str2.substring(1, str2.length() - 1);
        }
        return str.equalsIgnoreCase(str2);
    }

    public static void O000000o(WifiConfiguration wifiConfiguration, String str, String str2, String str3) {
        int O00000Oo = O00000Oo(str3);
        wifiConfiguration.allowedAuthAlgorithms.clear();
        wifiConfiguration.allowedGroupCiphers.clear();
        wifiConfiguration.allowedKeyManagement.clear();
        wifiConfiguration.allowedPairwiseCiphers.clear();
        wifiConfiguration.allowedProtocols.clear();
        wifiConfiguration.SSID = O000000o(str);
        if (O00000Oo != 0) {
            if (O00000Oo == 1) {
                wifiConfiguration.hiddenSSID = true;
                String[] strArr = wifiConfiguration.wepKeys;
                strArr[0] = jdn.f1779O000000o + str2 + jdn.f1779O000000o;
                wifiConfiguration.allowedAuthAlgorithms.set(1);
                wifiConfiguration.allowedGroupCiphers.set(3);
                wifiConfiguration.allowedGroupCiphers.set(2);
                wifiConfiguration.allowedGroupCiphers.set(0);
                wifiConfiguration.allowedGroupCiphers.set(1);
                wifiConfiguration.allowedKeyManagement.set(0);
                wifiConfiguration.wepTxKeyIndex = 0;
            } else if (O00000Oo != 2) {
                return;
            }
            wifiConfiguration.preSharedKey = jdn.f1779O000000o + str2 + jdn.f1779O000000o;
            wifiConfiguration.allowedKeyManagement.set(1);
            TKIPType O00000o0 = O00000o0(str3);
            if (O00000o0 == TKIPType.TKIP_CCMP) {
                wifiConfiguration.allowedGroupCiphers.set(3);
                wifiConfiguration.allowedGroupCiphers.set(2);
                wifiConfiguration.allowedPairwiseCiphers.set(2);
                wifiConfiguration.allowedPairwiseCiphers.set(1);
            } else if (O00000o0 == TKIPType.TKIP) {
                wifiConfiguration.allowedGroupCiphers.set(2);
                wifiConfiguration.allowedPairwiseCiphers.set(1);
            } else if (O00000o0 == TKIPType.CCMP) {
                wifiConfiguration.allowedGroupCiphers.set(3);
                wifiConfiguration.allowedPairwiseCiphers.set(2);
            }
            wifiConfiguration.status = 0;
            return;
        }
        wifiConfiguration.allowedKeyManagement.set(0);
    }

    public static void O000000o(final ConnectivityManager connectivityManager, final WifiManager wifiManager, final String str, final iad iad) {
        gjn.O000000o().O000000o("WifiState", "disconnectAp ".concat(String.valueOf(str)));
        CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSettingUtils.AnonymousClass1 */

            public final void run() {
                WifiConfiguration wifiConfiguration;
                try {
                    List<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
                    if (configuredNetworks != null) {
                        Iterator<WifiConfiguration> it = configuredNetworks.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                wifiConfiguration = null;
                                break;
                            }
                            wifiConfiguration = it.next();
                            if (wifiConfiguration.SSID != null && wifiConfiguration.SSID.equals(BaseWifiSettingUtils.O000000o(str))) {
                                break;
                            }
                        }
                        if (wifiConfiguration != null) {
                            wifiManager.disableNetwork(wifiConfiguration.networkId);
                            wifiManager.disconnect();
                            wifiManager.removeNetwork(wifiConfiguration.networkId);
                        }
                        iad iad = iad;
                        if (iad != null && iad.O00000o0 != null) {
                            connectivityManager.unregisterNetworkCallback(iad.O00000o0);
                            iad.O00000o0 = null;
                        }
                    }
                } catch (SecurityException unused) {
                }
            }
        });
    }

    public static void O000000o(ConnectivityManager connectivityManager, WifiManager wifiManager, String str, String str2, String str3, String str4, iad iad, boolean z, boolean z2) {
        gjm O000000o2 = gjn.O000000o();
        StringBuilder sb = new StringBuilder("connectToAP ");
        sb.append(str);
        sb.append(" bssid:");
        final String str5 = str3;
        sb.append(str5);
        sb.append(" security:");
        final String str6 = str4;
        sb.append(str6);
        O000000o2.O000000o("WifiState", sb.toString());
        final ConnectivityManager connectivityManager2 = connectivityManager;
        final WifiManager wifiManager2 = wifiManager;
        final String str7 = str;
        final String str8 = str2;
        final iad iad2 = iad;
        final boolean z3 = z;
        final boolean z4 = z2;
        CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.wificonfig.BaseWifiSettingUtils.AnonymousClass2 */

            /* JADX WARNING: Removed duplicated region for block: B:53:0x00fc A[ADDED_TO_REGION] */
            public final void run() {
                boolean z;
                boolean z2;
                boolean z3;
                boolean z4 = false;
                try {
                    if (BaseWifiSettingUtils.O00000Oo(CommonApplication.getAppContext()) && !Settings.canDrawOverlays(CommonApplication.getAppContext())) {
                        BaseWifiSettingUtils.O000000o(connectivityManager2, str7, str8, iad2, z3, z4);
                    } else if (wifiManager2.isWifiEnabled()) {
                        List<WifiConfiguration> configuredNetworks = wifiManager2.getConfiguredNetworks();
                        WifiConfiguration wifiConfiguration = null;
                        if (!gpn.O000000o(configuredNetworks)) {
                            Iterator<WifiConfiguration> it = configuredNetworks.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                WifiConfiguration next = it.next();
                                if (next.SSID != null && next.SSID.equals(BaseWifiSettingUtils.O000000o(str7)) && BaseWifiSettingUtils.O000000o(next) == BaseWifiSettingUtils.O00000Oo(str6)) {
                                    wifiConfiguration = next;
                                    break;
                                }
                            }
                        }
                        Iterator<ScanResult> it2 = wifiManager2.getScanResults().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (it2.next().SSID.equalsIgnoreCase(str7)) {
                                    z3 = true;
                                    break;
                                }
                            } else {
                                z3 = false;
                                break;
                            }
                        }
                        gjm O000000o2 = gjn.O000000o();
                        O000000o2.O000000o("WifiState", "isContain " + str7 + " - " + z3);
                        if (wifiConfiguration != null) {
                            z2 = wifiManager2.disconnect();
                            try {
                                z = wifiManager2.enableNetwork(wifiConfiguration.networkId, true);
                                try {
                                    z4 = wifiManager2.reconnect();
                                } catch (SecurityException unused) {
                                }
                            } catch (SecurityException unused2) {
                                z = false;
                                if (z2) {
                                }
                                BaseWifiSettingUtils.O000000o(connectivityManager2, str7, str8, iad2, z3, z4);
                            }
                            if ((z2 || !z || !z4) && BaseWifiSettingUtils.O00000Oo(CommonApplication.getAppContext())) {
                                BaseWifiSettingUtils.O000000o(connectivityManager2, str7, str8, iad2, z3, z4);
                            }
                            return;
                        }
                        WifiConfiguration wifiConfiguration2 = new WifiConfiguration();
                        BaseWifiSettingUtils.O000000o(wifiConfiguration2, str7, str8, str6);
                        wifiConfiguration2.BSSID = str5;
                        int addNetwork = wifiManager2.addNetwork(wifiConfiguration2);
                        boolean disconnect = wifiManager2.disconnect();
                        try {
                            boolean enableNetwork = wifiManager2.enableNetwork(addNetwork, true);
                            try {
                                z4 = wifiManager2.reconnect();
                            } catch (SecurityException unused3) {
                            }
                            boolean z5 = disconnect;
                            z = enableNetwork;
                            z2 = z5;
                        } catch (SecurityException unused4) {
                            z2 = disconnect;
                            z = false;
                            if (z2) {
                            }
                            BaseWifiSettingUtils.O000000o(connectivityManager2, str7, str8, iad2, z3, z4);
                        }
                        if (z2) {
                        }
                        BaseWifiSettingUtils.O000000o(connectivityManager2, str7, str8, iad2, z3, z4);
                    }
                } catch (SecurityException unused5) {
                    z2 = false;
                    z = false;
                    if (z2) {
                    }
                    BaseWifiSettingUtils.O000000o(connectivityManager2, str7, str8, iad2, z3, z4);
                }
            }
        });
    }

    public static boolean O000000o(Context context) {
        if (context == null || context.getApplicationInfo() == null || context.getApplicationInfo().targetSdkVersion < 29) {
            return false;
        }
        gjm O000000o2 = gjn.O000000o();
        StringBuilder sb = new StringBuilder();
        sb.append(context.getApplicationInfo().targetSdkVersion);
        O000000o2.O000000o("targetSdkVersion", sb.toString());
        return true;
    }

    public static boolean O00000Oo(Context context) {
        return Build.VERSION.SDK_INT >= 29 && O000000o(context);
    }

    public static void O000000o(final ConnectivityManager connectivityManager, String str, String str2, final iad iad, boolean z, boolean z2) {
        WifiNetworkSpecifier wifiNetworkSpecifier;
        if (connectivityManager != null && z && iad != null) {
            if (z2) {
                wifiNetworkSpecifier = new WifiNetworkSpecifier.Builder().setSsid(str).setWpa2Passphrase(str2).build();
            } else {
                wifiNetworkSpecifier = new WifiNetworkSpecifier.Builder().setSsid(str).build();
            }
            NetworkRequest build = new NetworkRequest.Builder().addTransportType(1).removeCapability(12).setNetworkSpecifier(wifiNetworkSpecifier).build();
            iad.O00000o0 = new ConnectivityManager.NetworkCallback() {
                /* class com.xiaomi.smarthome.wificonfig.BaseWifiSettingUtils.AnonymousClass3 */

                public final void onAvailable(Network network) {
                    super.onAvailable(network);
                    connectivityManager.bindProcessToNetwork(network);
                    iad iad = iad;
                    if (iad != null) {
                        iad.O000000o(network);
                    }
                }

                public final void onUnavailable() {
                    super.onUnavailable();
                    connectivityManager.unregisterNetworkCallback(this);
                    iad iad = iad;
                    if (iad != null) {
                        iad.O00000o0 = null;
                        iad.O000000o();
                    }
                }

                public final void onLost(Network network) {
                    super.onLost(network);
                    connectivityManager.unregisterNetworkCallback(this);
                    iad iad = iad;
                    if (iad != null) {
                        iad.O00000o0 = null;
                        iad.O00000Oo(network);
                    }
                }
            };
            gjn.O000000o().O000000o("WifiState", "requestNetwork start: ".concat(String.valueOf(str)));
            connectivityManager.requestNetwork(build, iad.O00000o0);
        }
    }

    public static String O000000o(Context context, WifiManager wifiManager) {
        if (context == null || wifiManager == null) {
            return "";
        }
        int networkId = wifiManager.getConnectionInfo().getNetworkId();
        if (oOOO00o0.O000000o(context, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            return "";
        }
        for (WifiConfiguration next : wifiManager.getConfiguredNetworks()) {
            if (next != null && next.networkId == networkId) {
                return next.SSID;
            }
        }
        return "";
    }
}
