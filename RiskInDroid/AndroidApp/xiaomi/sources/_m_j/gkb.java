package _m_j;

import _m_j.gjt;
import _m_j.gka;
import android.os.Bundle;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.BleSecureConnectManager;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboWifiConfig;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleConnectResponse;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

final class gkb implements gkc {

    /* renamed from: O000000o  reason: collision with root package name */
    gka.O000000o f17939O000000o;
    public Bundle O00000Oo;
    private String O00000o;
    public final BleConnectResponse O00000o0 = new BleConnectResponse() {
        /* class _m_j.gkb.AnonymousClass2 */

        public final /* synthetic */ void onResponse(int i, Object obj) {
            fte.O00000Oo(String.format("BleStandardAuthFastConnecter onResponse, code = %d", Integer.valueOf(i)));
            gkb gkb = gkb.this;
            gkb.O00000Oo = (Bundle) obj;
            if (i == 0) {
                if (gkb.f17939O000000o != null) {
                    gkb.f17939O000000o.onResponse(0, gkb.O00000Oo);
                }
            } else if (gkb.f17939O000000o != null) {
                gkb.f17939O000000o.onResponse(i, gkb.O00000Oo);
            }
        }
    };
    private String O00000oO;
    private String O00000oo;
    private String O0000O0o;
    private String O0000OOo;
    private long O0000Oo;
    private String O0000Oo0;
    private String O0000OoO;
    private gju O0000Ooo;

    public final void O000000o(gjt.O000000o o000000o) {
    }

    public gkb(String str, gju gju) {
        this.O0000Ooo = gju;
        this.O00000o = str;
        this.O00000oO = gju.O00000Oo();
        this.O00000oo = gju.O00000o0();
        this.O0000O0o = gju.O000000o();
        this.O0000OOo = gju.O00000o();
        this.O0000Oo0 = gju.O0000OOo;
        this.O0000Oo = gju.O00000oO;
        this.O0000OoO = gju.O00000oo;
    }

    public final void O000000o(BleConnectOptions bleConnectOptions, gka.O000000o o000000o) {
        BleComboWifiConfig bleComboWifiConfig = new BleComboWifiConfig();
        bleComboWifiConfig.f6885O000000o = this.O0000Ooo.f17913O000000o;
        bleComboWifiConfig.O00000Oo = this.O00000oO;
        bleComboWifiConfig.O00000o0 = this.O00000oo;
        int convert = (int) TimeUnit.SECONDS.convert((long) new GregorianCalendar().getTimeZone().getRawOffset(), TimeUnit.MILLISECONDS);
        gnk.O00000o0(String.format("sendTimeZone %ds", Integer.valueOf(convert)));
        bleComboWifiConfig.O00000o = convert;
        String str = this.O0000Ooo.O0000Oo0;
        if (str == null) {
            str = "";
        }
        gnk.O00000o0(String.format("getCountryDomain %s", str));
        bleComboWifiConfig.O00000oO = str;
        String str2 = this.O0000Ooo.O0000Oo;
        gnk.O00000o0(String.format("timeArea %s", str2));
        bleComboWifiConfig.O00000oo = str2;
        bleComboWifiConfig.O0000O0o = this.O0000OOo;
        bleComboWifiConfig.O0000OOo = this.O0000O0o;
        String str3 = this.O0000Ooo.O0000OoO;
        if (str3 == null) {
            str3 = "";
        }
        if ("IL".equalsIgnoreCase(str3)) {
            str3 = "CN";
        }
        gnk.O00000o0(String.format("getCountryDomain %s", str3));
        bleComboWifiConfig.O0000Oo0 = str3;
        bleComboWifiConfig.O0000Oo = this.O0000Oo0;
        bleComboWifiConfig.O0000o00 = this.O0000Oo;
        bleComboWifiConfig.O0000Ooo = this.O0000OoO;
        this.f17939O000000o = o000000o;
        SecureConnectOptions.O000000o o000000o2 = new SecureConnectOptions.O000000o();
        o000000o2.f6884O000000o = bleConnectOptions;
        BleSecureConnectManager.O000000o(this.O00000o, bleComboWifiConfig, o000000o2.O000000o(), new gle() {
            /* class _m_j.gkb.AnonymousClass1 */

            public final void O000000o(int i, Bundle bundle) {
            }

            public final void O00000Oo(int i, Bundle bundle) {
            }

            public final void O00000o0(int i, Bundle bundle) {
            }

            public final void O00000o(int i, Bundle bundle) {
                if (gkb.this.O00000o0 != null) {
                    gkb.this.O00000o0.onResponse(i, bundle);
                }
            }
        });
    }

    public final void O00000Oo(gjt.O000000o o000000o) {
        o000000o.onResponse(0, null);
    }
}
