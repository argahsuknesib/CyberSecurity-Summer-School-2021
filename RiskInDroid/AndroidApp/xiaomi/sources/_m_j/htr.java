package _m_j;

import android.net.wifi.ScanResult;
import com.xiaomi.smarthome.smartconfig.WifiInfo;
import java.util.concurrent.ConcurrentHashMap;

public final class htr {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f689O000000o = false;
    private static htr O00000o0;
    public ConcurrentHashMap<String, Object> O00000Oo = new ConcurrentHashMap<>();

    public static htr O000000o() {
        if (O00000o0 == null) {
            O00000o0 = new htr();
        }
        return O00000o0;
    }

    private htr() {
    }

    public final Object O000000o(String str) {
        if (this.O00000Oo.containsKey(str)) {
            return this.O00000Oo.get(str);
        }
        return null;
    }

    public final Object O000000o(String str, Object obj) {
        return (str == null || !this.O00000Oo.containsKey(str)) ? obj : this.O00000Oo.get(str);
    }

    public final void O00000Oo(String str, Object obj) {
        if (str != null && obj != null) {
            this.O00000Oo.put(str, obj);
        }
    }

    public final void O00000Oo(String str) {
        this.O00000Oo.remove(str);
    }

    public final String O00000Oo() {
        if (O000000o("mi_router_info") != null) {
            return ((WifiInfo) O000000o("mi_router_info")).O00000o0;
        }
        if (O000000o("selected_ap") != null) {
            return ((ScanResult) O000000o("selected_ap")).SSID;
        }
        if (O000000o("selected_ap_ssid") != null) {
            return (String) O000000o("selected_ap_ssid");
        }
        return null;
    }

    public final String O00000o0() {
        if (O000000o("mi_router_info") != null) {
            return ((WifiInfo) O000000o("mi_router_info")).O00000oO;
        }
        return (String) O000000o("selected_ap_passwd");
    }

    public final String O00000o() {
        if (O000000o("mi_router_info") == null) {
            Object O000000o2 = O000000o("selected_ap");
            if (O000000o2 == null) {
                return "";
            }
            return ((ScanResult) O000000o2).capabilities;
        } else if (((WifiInfo) O000000o("mi_router_info")).O0000O0o.equalsIgnoreCase("psk2")) {
            return "[WPA2-PSK-CCMP]";
        } else {
            if (((WifiInfo) O000000o("mi_router_info")).O0000O0o.equalsIgnoreCase("mixed-psk")) {
                return "[WPA-PSK-CCMP+TKIP]";
            }
            return "";
        }
    }
}
