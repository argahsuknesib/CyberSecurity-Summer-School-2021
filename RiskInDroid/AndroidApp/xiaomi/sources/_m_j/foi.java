package _m_j;

import _m_j.foa;
import _m_j.foh;
import android.os.Bundle;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboWifiConfig;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public final class foi implements fom {

    /* renamed from: O000000o  reason: collision with root package name */
    foh.O000000o f16761O000000o;
    public Bundle O00000Oo;
    private String O00000o;
    private String O00000o0;
    private String O00000oO;
    private String O00000oo;
    private String O0000O0o;
    private String O0000OOo;
    private String O0000Oo;
    private long O0000Oo0;
    private final Response.BleConnectResponse O0000OoO = new Response.BleConnectResponse() {
        /* class _m_j.foi.AnonymousClass1 */

        public final /* synthetic */ void onResponse(int i, Object obj) {
            fte.O00000Oo(String.format("BleStandardAuthFastConnecter onResponse, code = %d", Integer.valueOf(i)));
            foi foi = foi.this;
            foi.O00000Oo = (Bundle) obj;
            if (i == 0) {
                if (foi.f16761O000000o != null) {
                    foi.f16761O000000o.onResponse(0, foi.O00000Oo);
                }
            } else if (foi.f16761O000000o != null) {
                foi.f16761O000000o.onResponse(i, foi.O00000Oo);
            }
        }
    };

    public final void O000000o(foa.O000000o o000000o) {
    }

    public foi(String str, String str2, String str3, String str4, long j, String str5, String str6, String str7) {
        str2 = str2 == null ? "" : str2;
        str3 = str3 == null ? "" : str3;
        str4 = str4 == null ? "" : str4;
        str6 = str6 == null ? "" : str6;
        str7 = str7 == null ? "" : str7;
        this.O00000o0 = str;
        this.O00000o = str2;
        this.O00000oO = str3;
        this.O00000oo = str4;
        this.O0000O0o = str6;
        this.O0000OOo = str7;
        this.O0000Oo0 = j;
        this.O0000Oo = str5;
    }

    public static int O000000o() {
        int convert = (int) TimeUnit.SECONDS.convert((long) new GregorianCalendar().getTimeZone().getRawOffset(), TimeUnit.MILLISECONDS);
        gnk.O00000o0(String.format("sendTimeZone %ds", Integer.valueOf(convert)));
        return convert;
    }

    public static String O00000Oo() {
        String countryDomain = SmartConfigRouterFactory.getCoreApiManager().getCountryDomain();
        if (countryDomain == null) {
            countryDomain = "";
        }
        gnk.O00000o0(String.format("getCountryDomain %s", countryDomain));
        return countryDomain;
    }

    public static String O00000o0() {
        String str = (String) htr.O000000o().O000000o("gmt_tz", "");
        gnk.O00000o0(String.format("timeArea %s", str));
        return str;
    }

    public static String O00000o() {
        String countryCode = SmartConfigRouterFactory.getCoreApiManager().getCountryCode();
        if (countryCode == null) {
            countryCode = "";
        }
        if (eyr.O00000Oo().O00oOooO && "IL".equalsIgnoreCase(countryCode)) {
            countryCode = "CN";
        }
        gnk.O00000o0(String.format("getCountryDomain %s", countryCode));
        return countryCode;
    }

    public final void O000000o(BleConnectOptions bleConnectOptions, foh.O000000o o000000o) {
        BleComboWifiConfig bleComboWifiConfig = new BleComboWifiConfig();
        bleComboWifiConfig.f6885O000000o = SmartConfigRouterFactory.getCoreApiManager().getMiId();
        bleComboWifiConfig.O00000Oo = this.O00000o;
        bleComboWifiConfig.O00000o0 = this.O00000oO;
        bleComboWifiConfig.O00000o = O000000o();
        bleComboWifiConfig.O00000oO = O00000Oo();
        bleComboWifiConfig.O00000oo = O00000o0();
        bleComboWifiConfig.O0000O0o = this.O0000O0o;
        bleComboWifiConfig.O0000OOo = this.O00000oo;
        bleComboWifiConfig.O0000Oo0 = O00000o();
        bleComboWifiConfig.O0000Oo = this.O0000OOo;
        bleComboWifiConfig.O0000o00 = this.O0000Oo0;
        bleComboWifiConfig.O0000Ooo = this.O0000Oo;
        this.f16761O000000o = o000000o;
        fpo.O000000o(this.O00000o0, bleComboWifiConfig, bleConnectOptions, this.O0000OoO);
    }

    public final void O00000Oo(foa.O000000o o000000o) {
        o000000o.onResponse(0, null);
    }
}
