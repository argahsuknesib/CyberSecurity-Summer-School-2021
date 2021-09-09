package _m_j;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.loc.ct;
import com.loc.eb;
import com.loc.ee;
import com.loc.ef;
import com.loc.t;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;

@SuppressLint({"NewApi"})
public final class bud {
    public static boolean O000O0oo = true;
    private static int O000OOo = -1;
    private static boolean O000OOo0 = false;
    static int O00oOoOo = -1;

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f13281O000000o = null;
    ConnectivityManager O00000Oo = null;
    public ee O00000o = null;
    public bvn O00000o0 = null;
    public bvp O00000oO = null;
    public ct O00000oo = null;
    bvw O0000O0o = null;
    public ArrayList<ScanResult> O0000OOo = new ArrayList<>();
    AMapLocationClientOption O0000Oo = new AMapLocationClientOption();
    O000000o O0000Oo0 = null;
    AMapLocationServer O0000OoO = null;
    long O0000Ooo = 0;
    boolean O0000o = true;
    public boolean O0000o0 = false;
    bvx O0000o00 = null;
    bvu O0000o0O = null;
    StringBuilder O0000o0o = new StringBuilder();
    AMapLocationClientOption.GeoLanguage O0000oO = AMapLocationClientOption.GeoLanguage.DEFAULT;
    boolean O0000oO0 = true;
    public boolean O0000oOO = true;
    boolean O0000oOo = false;
    boolean O0000oo = true;
    WifiInfo O0000oo0 = null;
    String O0000ooO = null;
    StringBuilder O0000ooo = null;
    int O000O00o = 12;
    public eb O000O0OO = null;
    boolean O000O0Oo = false;
    String O000O0o = null;
    public bue O000O0o0 = null;
    public ef O000O0oO = null;
    private int O000OO = 0;
    IntentFilter O000OO00 = null;
    LocationManager O000OO0o = null;
    private String O000OOOo = null;
    private boolean O000OOoO = true;
    boolean O00oOooO = false;
    public boolean O00oOooo = false;

    /* renamed from: _m_j.bud$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f13282O000000o = new int[AMapLocationClientOption.GeoLanguage.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            f13282O000000o[AMapLocationClientOption.GeoLanguage.DEFAULT.ordinal()] = 1;
            f13282O000000o[AMapLocationClientOption.GeoLanguage.ZH.ordinal()] = 2;
            try {
                f13282O000000o[AMapLocationClientOption.GeoLanguage.EN.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    static AMapLocationServer O000000o(int i, String str) {
        AMapLocationServer aMapLocationServer = new AMapLocationServer("");
        aMapLocationServer.setErrorCode(i);
        aMapLocationServer.setLocationDetail(str);
        if (i == 15) {
            bwf.O000000o((String) null, 2151);
        }
        return aMapLocationServer;
    }

    private AMapLocationServer O000000o(AMapLocationServer aMapLocationServer, bta bta) {
        if (bta != null) {
            try {
                if (bta.f13259O000000o != null) {
                    if (bta.f13259O000000o.length != 0) {
                        bvw bvw = new bvw();
                        String str = new String(bta.f13259O000000o, "UTF-8");
                        if (str.contains("\"status\":\"0\"")) {
                            AMapLocationServer O000000o2 = bvw.O000000o(str, this.f13281O000000o, bta);
                            O000000o2.h(this.O0000ooo.toString());
                            return O000000o2;
                        } else if (!str.contains("</body></html>")) {
                            return null;
                        } else {
                            aMapLocationServer.setErrorCode(5);
                            if (this.O00000o0 == null || !this.O00000o0.O000000o(this.O00000Oo)) {
                                this.O0000o0o.append("请求可能被劫持了#0502");
                                bwf.O000000o((String) null, 2052);
                            } else {
                                this.O0000o0o.append("您连接的是一个需要登录的网络，请确认已经登入网络#0501");
                                bwf.O000000o((String) null, 2051);
                            }
                            aMapLocationServer.setLocationDetail(this.O0000o0o.toString());
                            return aMapLocationServer;
                        }
                    }
                }
            } catch (Throwable th) {
                aMapLocationServer.setErrorCode(4);
                bvz.O000000o(th, "Aps", "checkResponseEntity");
                StringBuilder sb = this.O0000o0o;
                sb.append("check response exception ex is" + th.getMessage() + "#0403");
                aMapLocationServer.setLocationDetail(this.O0000o0o.toString());
                return aMapLocationServer;
            }
        }
        aMapLocationServer.setErrorCode(4);
        this.O0000o0o.append("网络异常,请求异常#0403");
        aMapLocationServer.h(this.O0000ooo.toString());
        aMapLocationServer.setLocationDetail(this.O0000o0o.toString());
        if (bta != null) {
            bwf.O000000o(bta.O00000o, 2041);
        }
        return aMapLocationServer;
    }

    private StringBuilder O000000o(StringBuilder sb) {
        if (sb == null) {
            sb = new StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        sb.append(this.O00000o.O00000o0());
        sb.append(this.O00000o0.O00000oO());
        return sb;
    }

    public static void O00000Oo(Context context) {
        try {
            if (O000OOo == -1 || bvy.O0000O0o(context)) {
                O000OOo = 1;
                bvy.O000000o(context);
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "Aps", "initAuth");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0049 A[Catch:{ Throwable -> 0x004e }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004a A[Catch:{ Throwable -> 0x004e }] */
    private void O0000Oo0() {
        int i;
        if (this.O0000o0O != null) {
            try {
                if (this.O0000Oo == null) {
                    this.O0000Oo = new AMapLocationClientOption();
                }
                int i2 = 2;
                boolean z = true;
                if (!(this.O0000Oo.getGeoLanguage() == null || (i = AnonymousClass1.f13282O000000o[this.O0000Oo.getGeoLanguage().ordinal()]) == 1)) {
                    if (i == 2) {
                        i2 = 1;
                    } else if (i != 3) {
                    }
                    bvu bvu = this.O0000o0O;
                    long httpTimeOut = this.O0000Oo.getHttpTimeOut();
                    if (this.O0000Oo.getLocationProtocol().equals(AMapLocationClientOption.AMapLocationProtocol.HTTPS)) {
                        z = false;
                    }
                    bvu.O000000o(httpTimeOut, z, i2);
                }
                i2 = 0;
                bvu bvu2 = this.O0000o0O;
                long httpTimeOut2 = this.O0000Oo.getHttpTimeOut();
                if (this.O0000Oo.getLocationProtocol().equals(AMapLocationClientOption.AMapLocationProtocol.HTTPS)) {
                }
                bvu2.O000000o(httpTimeOut2, z, i2);
            } catch (Throwable unused) {
            }
        }
    }

    public final AMapLocationServer O000000o(double d, double d2) {
        try {
            String O000000o2 = this.O0000o0O.O000000o(this.f13281O000000o, d, d2);
            if (!O000000o2.contains("\"status\":\"1\"")) {
                return null;
            }
            AMapLocationServer O000000o3 = this.O0000O0o.O000000o(O000000o2);
            O000000o3.setLatitude(d);
            O000000o3.setLongitude(d2);
            return O000000o3;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void O000000o() {
        this.O0000o0O = bvu.O000000o(this.f13281O000000o);
        O0000Oo0();
        if (this.O00000Oo == null) {
            this.O00000Oo = (ConnectivityManager) bwi.O000000o(this.f13281O000000o, "connectivity");
        }
        if (this.O0000o00 == null) {
            this.O0000o00 = new bvx();
        }
    }

    public final void O000000o(Context context) {
        try {
            if (this.f13281O000000o == null) {
                this.O000O0o0 = new bue();
                this.f13281O000000o = context.getApplicationContext();
                bvy.O00000o(this.f13281O000000o);
                bwi.O00000Oo(this.f13281O000000o);
                if (this.O00000o0 == null) {
                    this.O00000o0 = new bvn(this.f13281O000000o, (WifiManager) bwi.O000000o(this.f13281O000000o, "wifi"));
                }
                if (this.O00000o == null) {
                    this.O00000o = new ee(this.f13281O000000o);
                }
                if (this.O00000oO == null) {
                    this.O00000oO = new bvp();
                }
                if (this.O0000O0o == null) {
                    this.O0000O0o = new bvw();
                }
                if (this.O000O0oO == null) {
                    this.O000O0oO = new ef(this.f13281O000000o);
                }
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "Aps", "initBase");
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer != null) {
            this.O0000OoO = aMapLocationServer;
        }
    }

    public final void O00000Oo() {
        if (this.O0000o0o.length() > 0) {
            StringBuilder sb = this.O0000o0o;
            sb.delete(0, sb.length());
        }
    }

    public final void O00000Oo(AMapLocationServer aMapLocationServer) {
        if (bwi.O000000o(aMapLocationServer)) {
            this.O00000oO.O000000o(this.O0000ooO, this.O0000ooo, aMapLocationServer, this.f13281O000000o, true);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bud.O000000o(boolean, boolean):com.autonavi.aps.amapapi.model.AMapLocationServer
     arg types: [int, int]
     candidates:
      _m_j.bud.O000000o(int, java.lang.String):com.autonavi.aps.amapapi.model.AMapLocationServer
      _m_j.bud.O000000o(com.autonavi.aps.amapapi.model.AMapLocationServer, _m_j.bta):com.autonavi.aps.amapapi.model.AMapLocationServer
      _m_j.bud.O000000o(double, double):com.autonavi.aps.amapapi.model.AMapLocationServer
      _m_j.bud.O000000o(boolean, boolean):com.autonavi.aps.amapapi.model.AMapLocationServer */
    public final void O00000o() {
        try {
            O000000o(this.f13281O000000o);
            O000000o(this.O0000Oo);
            O0000O0o();
            O00000Oo(O000000o(true, true));
        } catch (Throwable th) {
            bvz.O000000o(th, "Aps", "doFusionLocation");
        }
    }

    public void O00000oo() {
        try {
            if (this.O0000Oo0 == null) {
                this.O0000Oo0 = new O000000o();
            }
            if (this.O000OO00 == null) {
                this.O000OO00 = new IntentFilter();
                this.O000OO00.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                this.O000OO00.addAction("android.net.wifi.SCAN_RESULTS");
            }
            this.f13281O000000o.registerReceiver(this.O0000Oo0, this.O000OO00);
        } catch (Throwable th) {
            bvz.O000000o(th, "Aps", "initBroadcastListener");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.loc.ee.O000000o(boolean, boolean):void
     arg types: [int, boolean]
     candidates:
      com.loc.ee.O000000o(com.loc.ee, long):long
      com.loc.ee.O000000o(android.telephony.CellInfoCdma, boolean):_m_j.bvm
      com.loc.ee.O000000o(android.telephony.CellInfoGsm, boolean):_m_j.bvm
      com.loc.ee.O000000o(android.telephony.CellInfoLte, boolean):_m_j.bvm
      com.loc.ee.O000000o(android.telephony.CellInfoWcdma, boolean):_m_j.bvm
      com.loc.ee.O000000o(android.telephony.NeighboringCellInfo, java.lang.String[]):_m_j.bvm
      com.loc.ee.O000000o(com.loc.ee, int):void
      com.loc.ee.O000000o(int, int):boolean
      com.loc.ee.O000000o(boolean, boolean):void */
    public final void O0000O0o() {
        try {
            if (!this.O00oOooO) {
                if (this.O0000ooO != null) {
                    this.O0000ooO = null;
                }
                if (this.O0000ooo != null) {
                    this.O0000ooo.delete(0, this.O0000ooo.length());
                }
                if (this.O0000oOo) {
                    O00000oo();
                }
                this.O00000o0.O000000o(this.O0000oOo);
                this.O0000OOo = this.O00000o0.O00000Oo();
                this.O00000o.O000000o(true, O0000OOo());
                this.O0000ooO = O0000Oo();
                if (!TextUtils.isEmpty(this.O0000ooO)) {
                    this.O0000ooo = O000000o(this.O0000ooo);
                }
                this.O00oOooO = true;
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "Aps", "initFirstLocateParam");
        }
    }

    public boolean O0000OOo() {
        this.O0000OOo = this.O00000o0.O00000Oo();
        ArrayList<ScanResult> arrayList = this.O0000OOo;
        return arrayList == null || arrayList.size() <= 0;
    }

    class O000000o extends BroadcastReceiver {
        O000000o() {
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x006a A[Catch:{ Throwable -> 0x005f, Throwable -> 0x007c }] */
        public final void onReceive(Context context, Intent intent) {
            int i;
            if (context != null && intent != null) {
                try {
                    String action = intent.getAction();
                    if (!TextUtils.isEmpty(action)) {
                        if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                            if (bud.this.O00000o0 != null && bud.this.O00000o0.f13314O000000o != null && bwi.O00000o0() - bvn.O00000oo > 4900) {
                                bvn.O00000oo = bwi.O00000o0();
                            }
                        } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED") && bud.this.O00000o0 != null) {
                            bvn bvn = bud.this.O00000o0;
                            if (bvn.f13314O000000o != null) {
                                if (bvn.f13314O000000o != null) {
                                    i = bvn.f13314O000000o.getWifiState();
                                    if (bvn.O00000Oo == null) {
                                        bvn.O00000Oo = new ArrayList<>();
                                    }
                                    if (i != 0 || i == 1 || i == 4) {
                                        bvn.O0000oo0 = true;
                                    }
                                    return;
                                }
                                i = 4;
                                if (bvn.O00000Oo == null) {
                                }
                                if (i != 0) {
                                }
                                bvn.O0000oo0 = true;
                            }
                        }
                    }
                } catch (Throwable th) {
                    bvz.O000000o(th, "Aps", "onReceive");
                }
            }
        }
    }

    public final void O000000o(AMapLocationClientOption aMapLocationClientOption) {
        boolean z;
        boolean z2;
        this.O0000Oo = aMapLocationClientOption;
        if (this.O0000Oo == null) {
            this.O0000Oo = new AMapLocationClientOption();
        }
        bvn bvn = this.O00000o0;
        if (bvn != null) {
            this.O0000Oo.isWifiActiveScan();
            boolean isWifiScan = this.O0000Oo.isWifiScan();
            boolean isMockEnable = this.O0000Oo.isMockEnable();
            boolean isOpenAlwaysScanWifi = AMapLocationClientOption.isOpenAlwaysScanWifi();
            long scanWifiInterval = aMapLocationClientOption.getScanWifiInterval();
            bvn.O0000OoO = isWifiScan;
            bvn.O0000Ooo = isMockEnable;
            bvn.O0000o00 = isOpenAlwaysScanWifi;
            if (scanWifiInterval < 10000) {
                bvn.O0000oOo = 10000;
            } else {
                bvn.O0000oOo = scanWifiInterval;
            }
        }
        O0000Oo0();
        bvp bvp = this.O00000oO;
        if (bvp != null) {
            AMapLocationClientOption aMapLocationClientOption2 = this.O0000Oo;
            bvp.O0000Oo = aMapLocationClientOption2.isNeedAddress();
            bvp.O0000Oo0 = aMapLocationClientOption2.isOffset();
            bvp.O00000o = aMapLocationClientOption2.isLocationCacheEnable();
            bvp.O0000OoO = String.valueOf(aMapLocationClientOption2.getGeoLanguage());
        }
        bvw bvw = this.O0000O0o;
        if (bvw != null) {
            AMapLocationClientOption aMapLocationClientOption3 = this.O0000Oo;
            if (aMapLocationClientOption3 == null) {
                aMapLocationClientOption3 = new AMapLocationClientOption();
            }
            bvw.f13323O000000o = aMapLocationClientOption3;
        }
        AMapLocationClientOption.GeoLanguage geoLanguage = AMapLocationClientOption.GeoLanguage.DEFAULT;
        boolean z3 = true;
        try {
            geoLanguage = this.O0000Oo.getGeoLanguage();
            z2 = this.O0000Oo.isNeedAddress();
            try {
                z = this.O0000Oo.isOffset();
                try {
                    z3 = this.O0000Oo.isLocationCacheEnable();
                    this.O0000oOo = this.O0000Oo.isOnceLocationLatest();
                    this.O000O0Oo = this.O0000Oo.isSensorEnable();
                    if (!(z == this.O0000oO0 && z2 == this.O0000o && z3 == this.O0000oOO && geoLanguage == this.O0000oO)) {
                        if (this.O00000oO != null) {
                            bvp bvp2 = this.O00000oO;
                            bvp2.O00000oO = 0;
                            bvp2.O00000oo = null;
                        }
                        O000000o((AMapLocationServer) null);
                        this.O000OOoO = false;
                        if (this.O000O0o0 != null) {
                            this.O000O0o0.O000000o();
                        }
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                z = true;
                this.O0000oO0 = z;
                this.O0000o = z2;
                this.O0000oOO = z3;
                this.O0000oO = geoLanguage;
            }
        } catch (Throwable unused3) {
            z2 = true;
            z = true;
            this.O0000oO0 = z;
            this.O0000o = z2;
            this.O0000oOO = z3;
            this.O0000oO = geoLanguage;
        }
        this.O0000oO0 = z;
        this.O0000o = z2;
        this.O0000oOO = z3;
        this.O0000oO = geoLanguage;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.loc.ee.O000000o(boolean, boolean):void
     arg types: [int, boolean]
     candidates:
      com.loc.ee.O000000o(com.loc.ee, long):long
      com.loc.ee.O000000o(android.telephony.CellInfoCdma, boolean):_m_j.bvm
      com.loc.ee.O000000o(android.telephony.CellInfoGsm, boolean):_m_j.bvm
      com.loc.ee.O000000o(android.telephony.CellInfoLte, boolean):_m_j.bvm
      com.loc.ee.O000000o(android.telephony.CellInfoWcdma, boolean):_m_j.bvm
      com.loc.ee.O000000o(android.telephony.NeighboringCellInfo, java.lang.String[]):_m_j.bvm
      com.loc.ee.O000000o(com.loc.ee, int):void
      com.loc.ee.O000000o(int, int):boolean
      com.loc.ee.O000000o(boolean, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bud.O000000o(boolean, boolean):com.autonavi.aps.amapapi.model.AMapLocationServer
     arg types: [int, int]
     candidates:
      _m_j.bud.O000000o(int, java.lang.String):com.autonavi.aps.amapapi.model.AMapLocationServer
      _m_j.bud.O000000o(com.autonavi.aps.amapapi.model.AMapLocationServer, _m_j.bta):com.autonavi.aps.amapapi.model.AMapLocationServer
      _m_j.bud.O000000o(double, double):com.autonavi.aps.amapapi.model.AMapLocationServer
      _m_j.bud.O000000o(boolean, boolean):com.autonavi.aps.amapapi.model.AMapLocationServer */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01ac, code lost:
        if (r0 != null) goto L_0x01b0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x014b A[Catch:{ Throwable -> 0x0165 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x018a  */
    public final AMapLocationServer O00000o0() throws Throwable {
        boolean z;
        eb ebVar;
        float f;
        AMapLocationServer aMapLocationServer;
        eb ebVar2;
        ef efVar;
        AMapLocationServer aMapLocationServer2;
        boolean z2;
        bvn bvn;
        O00000Oo();
        if (this.f13281O000000o == null) {
            this.O0000o0o.append("context is null#0101");
            return O000000o(1, this.O0000o0o.toString());
        }
        this.O000OO++;
        if (this.O000OO == 1 && (bvn = this.O00000o0) != null) {
            boolean z3 = this.O0000o0;
            Context context = bvn.O0000OOo;
            if (bvy.O00oOooo() && bvn.O0000o00 && bvn.f13314O000000o != null && context != null && z3 && bwi.O00000o() > 17) {
                ContentResolver contentResolver = context.getContentResolver();
                try {
                    if (((Integer) bwd.O000000o("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                        bwd.O000000o("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, new Class[]{ContentResolver.class, String.class, Integer.TYPE});
                    }
                } catch (Throwable th) {
                    bvz.O000000o(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
                }
            }
        }
        long j = this.O0000Ooo;
        if (!this.O000OOoO) {
            this.O000OOoO = true;
        } else if (bwi.O00000o0() - j < 800) {
            if ((bwi.O000000o(this.O0000OoO) ? bwi.O00000Oo() - this.O0000OoO.getTime() : 0) <= 10000) {
                z = true;
                if (z || !bwi.O000000o(this.O0000OoO)) {
                    ebVar = this.O000O0OO;
                    if (ebVar != null) {
                        if (!this.O000O0Oo) {
                            ebVar.O000000o();
                        } else if (ebVar.f4529O000000o != null && !ebVar.O00000oO) {
                            ebVar.O00000oO = true;
                            try {
                                if (ebVar.O00000Oo != null) {
                                    ebVar.f4529O000000o.registerListener(ebVar, ebVar.O00000Oo, 3, ebVar.O0000Oo0);
                                }
                            } catch (Throwable th2) {
                                bvz.O000000o(th2, "AMapSensorManager", "registerListener mPressure");
                            }
                            try {
                                if (ebVar.O00000o0 != null) {
                                    ebVar.f4529O000000o.registerListener(ebVar, ebVar.O00000o0, 3, ebVar.O0000Oo0);
                                }
                            } catch (Throwable th3) {
                                bvz.O000000o(th3, "AMapSensorManager", "registerListener mRotationVector");
                            }
                            try {
                                if (ebVar.O00000o != null) {
                                    ebVar.f4529O000000o.registerListener(ebVar, ebVar.O00000o, 3, ebVar.O0000Oo0);
                                }
                            } catch (Throwable th4) {
                                bvz.O000000o(th4, "AMapSensorManager", "registerListener mAcceleroMeterVector");
                            }
                        }
                    }
                    if (!this.O0000Oo.isOnceLocationLatest()) {
                        if (this.O0000Oo.isOnceLocation()) {
                            z2 = false;
                            this.O00000o0.O000000o(z2);
                            this.O0000OOo = this.O00000o0.O00000Oo();
                            this.O00000o.O000000o(false, O0000OOo());
                            this.O0000ooO = O0000Oo();
                            if (TextUtils.isEmpty(this.O0000ooO)) {
                                ct ctVar = this.O00000oo;
                                if (bvy.O00000oo()) {
                                    ctVar.O000000o();
                                    for (int i = 4; i > 0 && !ctVar.O00000o0; i--) {
                                        SystemClock.sleep(500);
                                    }
                                    if (ctVar.O00000o0) {
                                        aMapLocationServer2 = ctVar.O00000o0();
                                    }
                                }
                                aMapLocationServer2 = null;
                                this.O0000OoO = aMapLocationServer2;
                                AMapLocationServer aMapLocationServer3 = this.O0000OoO;
                                if (aMapLocationServer3 == null) {
                                    return O000000o(this.O000O00o, this.O0000o0o.toString());
                                }
                                aMapLocationServer3.setLocationDetail(this.O0000o0o.toString());
                                this.O0000OoO.setTrustedLevel(4);
                                return this.O0000OoO;
                            }
                            this.O0000ooo = O000000o(this.O0000ooo);
                            if (this.O00000o0.O0000Oo0) {
                                AMapLocationServer O000000o2 = O000000o(15, "networkLocation has been mocked!#1502");
                                O000000o2.setMock(true);
                                O000000o2.setTrustedLevel(4);
                                return O000000o2;
                            }
                            AMapLocationServer O000000o3 = this.O00000oO.O000000o(this.O00000o, this.O0000Ooo == 0 || bwi.O00000o0() - this.O0000Ooo > 20000, this.O0000OoO, this.O00000o0, this.O0000ooo, this.O0000ooO, this.f13281O000000o);
                            if (bwi.O000000o(O000000o3)) {
                                O000000o3.setTrustedLevel(2);
                                O000000o(O000000o3);
                            } else {
                                this.O0000OoO = O000000o(false, true);
                                if (bwi.O000000o(this.O0000OoO)) {
                                    this.O0000OoO.e("new");
                                    this.O00000oO.O00000oo = this.O0000ooo.toString();
                                    this.O00000oO.O0000O0o = this.O00000o.O000000o();
                                    O000000o(this.O0000OoO);
                                    ef efVar2 = this.O000O0oO;
                                    if (efVar2 != null) {
                                        try {
                                            efVar2.O000000o(this.O00000o, this.O0000OOo, this.O0000OoO, 2);
                                        } catch (Throwable th5) {
                                            bvz.O000000o(th5, "APSCoManager", "correctOffLoc");
                                        }
                                    }
                                }
                            }
                            try {
                                if (!(this.O00000o0 == null || this.O0000OoO == null)) {
                                    long O000000o4 = bvn.O000000o();
                                    if (O000000o4 <= 15) {
                                        this.O0000OoO.setTrustedLevel(1);
                                    } else if (O000000o4 <= 120) {
                                        this.O0000OoO.setTrustedLevel(2);
                                    } else if (O000000o4 <= 600) {
                                        this.O0000OoO.setTrustedLevel(3);
                                    } else {
                                        this.O0000OoO.setTrustedLevel(4);
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                            ef efVar3 = this.O000O0oO;
                            if (efVar3 != null) {
                                try {
                                    efVar3.O000000o(this.O00000o, this.O0000OOo, this.O0000OoO, 1);
                                } catch (Throwable th6) {
                                    bvz.O000000o(th6, "APSCoManager", "trainingFps");
                                }
                            }
                            this.O00000oO.O000000o(this.O0000ooO, this.O0000ooo, this.O0000OoO, this.f13281O000000o, true);
                            if (!bwi.O000000o(this.O0000OoO) && (efVar = this.O000O0oO) != null) {
                                this.O0000OoO = efVar.O000000o(this.O00000o, this.O0000OOo, this.O0000OoO);
                            }
                            StringBuilder sb = this.O0000ooo;
                            sb.delete(0, sb.length());
                            if (!this.O000O0Oo || (ebVar2 = this.O000O0OO) == null) {
                                this.O0000OoO.setAltitude(0.0d);
                                f = 0.0f;
                                this.O0000OoO.setBearing(0.0f);
                                aMapLocationServer = this.O0000OoO;
                            } else {
                                this.O0000OoO.setAltitude(ebVar2.O00000oo);
                                this.O0000OoO.setBearing(this.O000O0OO.O0000OOo);
                                aMapLocationServer = this.O0000OoO;
                                f = (float) this.O000O0OO.O0000o00;
                            }
                            aMapLocationServer.setSpeed(f);
                            return this.O0000OoO;
                        }
                    }
                    z2 = true;
                    this.O00000o0.O000000o(z2);
                    this.O0000OOo = this.O00000o0.O00000Oo();
                    this.O00000o.O000000o(false, O0000OOo());
                    this.O0000ooO = O0000Oo();
                    if (TextUtils.isEmpty(this.O0000ooO)) {
                    }
                } else {
                    if (this.O0000oOO && bvy.O00000Oo(this.O0000OoO.getTime())) {
                        this.O0000OoO.setLocationType(2);
                    }
                    return this.O0000OoO;
                }
            }
        }
        z = false;
        if (z) {
        }
        ebVar = this.O000O0OO;
        if (ebVar != null) {
        }
        try {
            if (!this.O0000Oo.isOnceLocationLatest()) {
            }
            z2 = true;
            this.O00000o0.O000000o(z2);
            this.O0000OOo = this.O00000o0.O00000Oo();
        } catch (Throwable th7) {
            bvz.O000000o(th7, "Aps", "getLocation getScanResultsParam");
        }
        try {
            this.O00000o.O000000o(false, O0000OOo());
        } catch (Throwable th8) {
            bvz.O000000o(th8, "Aps", "getLocation getCgiListParam");
        }
        this.O0000ooO = O0000Oo();
        if (TextUtils.isEmpty(this.O0000ooO)) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0110, code lost:
        if (r6.isOpen() != false) goto L_0x0112;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01d4 A[SYNTHETIC, Splitter:B:141:0x01d4] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0126 A[SYNTHETIC, Splitter:B:78:0x0126] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0154  */
    @SuppressLint({"NewApi"})
    public final void O00000oO() {
        bue bue;
        ee eeVar;
        bvn bvn;
        ArrayList<ScanResult> arrayList;
        eb ebVar;
        SQLiteDatabase sQLiteDatabase;
        this.O000O0o = null;
        this.O00oOooO = false;
        this.O00oOooo = false;
        ef efVar = this.O000O0oO;
        if (efVar != null) {
            efVar.O00000Oo();
        }
        ct ctVar = this.O00000oo;
        if (ctVar != null) {
            try {
                if (ctVar.O00000oO != null && ctVar.O0000OoO) {
                    ctVar.f4524O000000o.unbindService(ctVar.O00000oO);
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "ConnectionServiceManager", "unbindService connService");
            }
            try {
                if (ctVar.O00000oo != null && ctVar.O0000Ooo) {
                    ctVar.f4524O000000o.unbindService(ctVar.O00000oo);
                }
            } catch (Throwable th2) {
                bvz.O000000o(th2, "ConnectionServiceManager", "unbindService pushService");
            }
            try {
                if (ctVar.O0000O0o != null && ctVar.O0000o00) {
                    ctVar.f4524O000000o.unbindService(ctVar.O0000O0o);
                }
            } catch (Throwable th3) {
                bvz.O000000o(th3, "ConnectionServiceManager", "unbindService otherService");
            }
            if (ctVar.O0000o0 != null && ctVar.O0000o0.size() > 0) {
                for (Intent stopService : ctVar.O0000o0) {
                    ctVar.f4524O000000o.stopService(stopService);
                }
            }
            ctVar.O00000o = null;
            ctVar.f4524O000000o = null;
            ctVar.O00000o = null;
            ctVar.O00000oO = null;
            ctVar.O00000oo = null;
            ctVar.O0000O0o = null;
            ctVar.O00000Oo = true;
            ctVar.O00000o0 = false;
            ctVar.O0000OOo = false;
            ctVar.O0000Oo0 = false;
            ctVar.O0000Oo = false;
            ctVar.O0000o0O = false;
            ctVar.O0000OoO = false;
            ctVar.O0000Ooo = false;
            ctVar.O0000o00 = false;
            ctVar.O0000o0.clear();
            ctVar.O0000o0 = null;
        }
        bvp bvp = this.O00000oO;
        if (bvp != null) {
            Context context = this.f13281O000000o;
            try {
                bvp.O000000o();
                if (context != null) {
                    try {
                        sQLiteDatabase = context.openOrCreateDatabase("hmdb", 0, null);
                        try {
                            if (bwi.O000000o(sQLiteDatabase, "hist")) {
                                sQLiteDatabase.delete("hist" + bvp.O00000o0, "time<?", new String[]{String.valueOf(bwi.O00000Oo() - 86400000)});
                                if (sQLiteDatabase != null) {
                                }
                            } else if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.close();
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            bvz.O000000o(th, "DB", "clearHist p2");
                            if (sQLiteDatabase != null) {
                            }
                            bvp.O00000Oo = false;
                            bvp.O00000oo = null;
                            bvp.O0000OOo = 0;
                            bue = this.O000O0o0;
                            if (bue != null) {
                            }
                            if (this.O0000O0o != null) {
                            }
                            bwi.O0000OOo();
                            this.f13281O000000o.unregisterReceiver(this.O0000Oo0);
                            this.O0000Oo0 = null;
                            eeVar = this.O00000o;
                            if (eeVar != null) {
                            }
                            bvn = this.O00000o0;
                            if (bvn != null) {
                            }
                            arrayList = this.O0000OOo;
                            if (arrayList != null) {
                            }
                            ebVar = this.O000O0OO;
                            if (ebVar != null) {
                            }
                            bvs.O00000Oo();
                            this.O0000OoO = null;
                            this.f13281O000000o = null;
                            this.O0000ooo = null;
                            this.O000OO0o = null;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        sQLiteDatabase = null;
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                }
                bvp.O00000Oo = false;
                bvp.O00000oo = null;
                bvp.O0000OOo = 0;
            } catch (Throwable th6) {
                bvz.O000000o(th6, "Cache", "destroy part");
            }
        }
        bue = this.O000O0o0;
        if (bue != null) {
            bue.O000000o();
        }
        if (this.O0000O0o != null) {
            this.O0000O0o = null;
        }
        bwi.O0000OOo();
        try {
            if (!(this.f13281O000000o == null || this.O0000Oo0 == null)) {
                this.f13281O000000o.unregisterReceiver(this.O0000Oo0);
            }
        } catch (Throwable th7) {
            this.O0000Oo0 = null;
            throw th7;
        }
        this.O0000Oo0 = null;
        eeVar = this.O00000o;
        if (eeVar != null) {
            bvl bvl = eeVar.O0000O0o;
            bvl.f13312O000000o.clear();
            bvl.O00000Oo = 0;
            eeVar.O0000OoO = 0;
            synchronized (eeVar.O0000oO) {
                eeVar.O0000oO0 = true;
            }
            if (!(eeVar.O00000oo == null || eeVar.O0000o00 == null)) {
                try {
                    eeVar.O00000oo.listen(eeVar.O0000o00, 0);
                } catch (Throwable th8) {
                    bvz.O000000o(th8, "CgiManager", "destroy");
                }
            }
            eeVar.O0000o00 = null;
            if (eeVar.O0000o != null) {
                eeVar.O0000o.quit();
                eeVar.O0000o = null;
            }
            eeVar.O00000oO = -113;
            eeVar.O00000oo = null;
            eeVar.O0000OOo = null;
        }
        bvn = this.O00000o0;
        if (bvn != null) {
            bvn.O00000o0();
            bvn.O00000Oo.clear();
        }
        arrayList = this.O0000OOo;
        if (arrayList != null) {
            arrayList.clear();
        }
        ebVar = this.O000O0OO;
        if (ebVar != null) {
            try {
                ebVar.O000000o();
                ebVar.O00000Oo = null;
                ebVar.O00000o0 = null;
                ebVar.f4529O000000o = null;
                ebVar.O00000o = null;
                ebVar.O00000oO = false;
            } catch (Throwable th9) {
                bvz.O000000o(th9, "AMapSensorManager", "destroy");
            }
        }
        bvs.O00000Oo();
        this.O0000OoO = null;
        this.f13281O000000o = null;
        this.O0000ooo = null;
        this.O000OO0o = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01c8, code lost:
        if (r13.O0000oo == false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0202, code lost:
        if (r13.O0000oo == false) goto L_0x0205;
     */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02b1  */
    /* JADX WARNING: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    private String O0000Oo() {
        String str;
        StringBuilder sb;
        StringBuilder sb2;
        String str2;
        StringBuilder sb3;
        String str3;
        StringBuilder sb4;
        int i = this.O00000o.f4531O000000o & 3;
        bvm O000000o2 = this.O00000o.O000000o();
        ArrayList<ScanResult> arrayList = this.O0000OOo;
        boolean z = arrayList == null || arrayList.isEmpty();
        String str4 = "";
        if (O000000o2 != null || !z) {
            this.O0000oo0 = this.O00000o0.O00000o();
            this.O0000oo = bvn.O000000o(this.O0000oo0);
            if (i != 0) {
                String str5 = "cgi";
                if (i != 1) {
                    if (i != 2) {
                        this.O000O00o = 11;
                        bwf.O000000o((String) null, 2111);
                        this.O0000o0o.append("get cgi failure#1101");
                    } else if (O000000o2 != null) {
                        sb2 = new StringBuilder();
                        sb2.append(O000000o2.f13313O000000o);
                        sb2.append("#");
                        sb2.append(O000000o2.O00000Oo);
                        sb2.append("#");
                        sb2.append(O000000o2.O0000O0o);
                        sb2.append("#");
                        sb2.append(O000000o2.O0000OOo);
                        sb2.append("#");
                        sb2.append(O000000o2.O0000Oo0);
                        sb2.append("#");
                        sb2.append("network");
                        sb2.append("#");
                        if (this.O0000OOo.isEmpty()) {
                        }
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        return str4;
                    }
                    if (!str4.startsWith("#")) {
                        str4 = "#" + str4;
                    }
                    return bwi.O0000Oo0() + str4;
                }
                if (O000000o2 != null) {
                    sb2 = new StringBuilder();
                    sb2.append(O000000o2.f13313O000000o);
                    sb2.append("#");
                    sb2.append(O000000o2.O00000Oo);
                    sb2.append("#");
                    sb2.append(O000000o2.O00000o0);
                    sb2.append("#");
                    sb2.append(O000000o2.O00000o);
                    sb2.append("#");
                    sb2.append("network");
                    sb2.append("#");
                    if (this.O0000OOo.isEmpty()) {
                    }
                }
                if (!TextUtils.isEmpty(str4)) {
                }
                str5 = "cgiwifi";
                sb2.append(str5);
            } else {
                boolean z2 = !this.O0000OOo.isEmpty() || this.O0000oo;
                if (!this.O0000oo || !this.O0000OOo.isEmpty()) {
                    if (this.O0000OOo.size() == 1) {
                        this.O000O00o = 2;
                        if (!this.O0000oo) {
                            this.O0000o0o.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                            bwf.O000000o((String) null, 2022);
                            return str4;
                        }
                        if (this.O00000o0.O00000o().getBSSID().equals(this.O0000OOo.get(0).BSSID)) {
                            this.O0000o0o.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                            bwf.O000000o((String) null, 2021);
                            return str4;
                        }
                    }
                    String format = String.format(Locale.US, "#%s#", "network");
                    if (z2) {
                        sb2 = new StringBuilder();
                        sb2.append(format);
                        sb2.append("wifi");
                    } else {
                        this.O000O00o = 2;
                        if (!this.O00000o0.O0000o0o) {
                            sb = this.O0000o0o;
                            str = "当前基站为伪基站,并且关闭了WIFI开关，请在设置中打开WIFI开关#0203";
                        } else {
                            sb = this.O0000o0o;
                            str = "当前基站为伪基站,并且没有搜索到WIFI，请移动到WIFI比较丰富的区域#0204";
                        }
                        sb.append(str);
                        bwf.O000000o((String) null, 2022);
                        if (!TextUtils.isEmpty(str4)) {
                        }
                    }
                } else {
                    this.O000O00o = 2;
                    this.O0000o0o.append("当前基站为伪基站，并且WIFI权限被禁用，请在安全软件中打开应用的定位权限#0201");
                    bwf.O000000o((String) null, 2021);
                    return str4;
                }
            }
            str4 = sb2.toString();
            if (!TextUtils.isEmpty(str4)) {
            }
        } else {
            if (this.O00000Oo == null) {
                this.O00000Oo = (ConnectivityManager) bwi.O000000o(this.f13281O000000o, "connectivity");
            }
            if (!bwi.O000000o(this.f13281O000000o) || this.O00000o0.O0000o0o) {
                if (bwi.O00000o() >= 28) {
                    if (this.O000OO0o == null) {
                        this.O000OO0o = (LocationManager) this.f13281O000000o.getApplicationContext().getSystemService("location");
                    }
                    if (!((Boolean) bwd.O000000o(this.O000OO0o, "isLocationEnabled", new Object[0])).booleanValue()) {
                        this.O000O00o = 12;
                        this.O0000o0o.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                        bwf.O000000o((String) null, 2121);
                        return str4;
                    }
                }
                if (!bwi.O00000oo(this.f13281O000000o)) {
                    this.O000O00o = 12;
                    this.O0000o0o.append("定位权限被禁用,请授予应用定位权限#1201");
                    bwf.O000000o((String) null, 2121);
                    return str4;
                } else if (bwi.O00000o() < 24 || bwi.O00000o() >= 28 || Settings.Secure.getInt(this.f13281O000000o.getContentResolver(), "location_mode", 0) != 0) {
                    String str6 = this.O00000o.O0000o0;
                    String str7 = this.O00000o0.O0000o0;
                    if (this.O00000o0.O000000o(this.O00000Oo) && str7 != null) {
                        this.O000O00o = 12;
                        this.O0000o0o.append("获取基站与获取WIFI的权限都被禁用，请在安全软件中打开应用的定位权限#1202");
                        bwf.O000000o((String) null, 2121);
                        return str4;
                    } else if (str6 != null) {
                        this.O000O00o = 12;
                        if (!this.O00000o0.O0000o0o) {
                            sb4 = this.O0000o0o;
                            str3 = "WIFI开关关闭，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限或者打开WIFI开关#1204";
                        } else {
                            sb4 = this.O0000o0o;
                            str3 = "获取的WIFI列表为空，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限#1205";
                        }
                        sb4.append(str3);
                        bwf.O000000o((String) null, 2121);
                        return str4;
                    } else if (!this.O00000o0.O0000o0o && !this.O00000o.O00000o()) {
                        this.O000O00o = 19;
                        this.O0000o0o.append("没有检查到SIM卡，并且WIFI开关关闭，请打开WIFI开关或者插入SIM卡#1901");
                        bwf.O000000o((String) null, 2133);
                        return str4;
                    } else if (!bwi.O0000O0o(this.f13281O000000o)) {
                        this.O000O00o = 12;
                        this.O0000o0o.append("后台定位服务没有开启，请在设置中打开后台定位服务开关#1207");
                        bwf.O000000o((String) null, 2121);
                        return str4;
                    } else {
                        if (!this.O00000o0.O0000o0o) {
                            sb3 = this.O0000o0o;
                            str2 = "获取到的基站为空，并且关闭了WIFI开关，请您打开WIFI开关再发起定位#1301";
                        } else {
                            sb3 = this.O0000o0o;
                            str2 = "获取到的基站和WIFI信息均为空，请移动到有WIFI的区域，若确定当前区域有WIFI，请检查是否授予APP定位权限#1302";
                        }
                        sb3.append(str2);
                        this.O000O00o = 13;
                        bwf.O000000o((String) null, 2131);
                        return str4;
                    }
                } else {
                    this.O000O00o = 12;
                    this.O0000o0o.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                    bwf.O000000o((String) null, 2121);
                    return str4;
                }
            } else {
                this.O000O00o = 18;
                this.O0000o0o.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1801");
                bwf.O000000o((String) null, 2132);
                return str4;
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, int):void
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void */
    /* JADX WARNING: Can't wrap try/catch for region: R(15:14|15|16|17|18|(1:20)(1:(2:22|(2:24|(1:26)(6:27|(1:29)(1:30)|31|(2:35|(1:37))|38|(3:40|(1:42)(1:43)|44)))))|45|46|(1:50)|51|(1:57)|(5:59|(1:61)|62|(1:64)|65)(1:66)|(2:68|(1:70)(2:71|(2:73|74)(2:75|(6:77|(1:79)(1:80)|81|(1:83)|84|85)(3:86|(2:90|(1:103)(1:102))|104))))|105|106) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:124:0x02d9 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00ea */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02e5 A[Catch:{ Throwable -> 0x029a, Throwable -> 0x0300, Throwable -> 0x02d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x02f3 A[Catch:{ Throwable -> 0x029a, Throwable -> 0x0300, Throwable -> 0x02d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0186  */
    @SuppressLint({"NewApi"})
    private AMapLocationServer O000000o(boolean z, boolean z2) {
        bvs O000000o2;
        StringBuilder sb;
        String str;
        String[] strArr;
        String str2;
        String str3 = "";
        AMapLocationServer aMapLocationServer = new AMapLocationServer(str3);
        try {
            if (this.O0000o00 == null) {
                this.O0000o00 = new bvx();
            }
            if (this.O0000Oo == null) {
                this.O0000Oo = new AMapLocationClientOption();
            }
            this.O0000o00.O000000o(this.f13281O000000o, this.O0000Oo.isNeedAddress(), this.O0000Oo.isOffset(), this.O00000o, this.O00000o0, this.O00000Oo, this.O000O0oO != null ? this.O000O0oO.O000000o() : null, this.O000O0o);
            byte[] O000000o3 = this.O0000o00.O000000o();
            this.O0000Ooo = bwi.O00000o0();
            try {
                bvz.O00000o0(this.f13281O000000o);
                bvv O000000o4 = this.O0000o0O.O000000o(this.f13281O000000o, O000000o3, bvz.O000000o(), z2);
                bvs O000000o5 = bvs.O000000o(this.f13281O000000o);
                boolean z3 = false;
                O000000o5.O00000o0 = false;
                if (O000000o5.O000000o()) {
                    if (O000000o4 != null) {
                        O000000o5.O00000oO = O000000o4;
                        String str4 = O000000o4.O0000OOo;
                        String host = new URL(str4).getHost();
                        if (!"http://abroad.apilocate.amap.com/mobile/binary".equals(str4)) {
                            if (!"abroad.apilocate.amap.com".equals(host)) {
                                String str5 = "apilocate.amap.com".equalsIgnoreCase(host) ? "httpdns.apilocate.amap.com" : host;
                                String O000000o6 = O000000o5.O000000o(str5);
                                if (O000000o5.O00000o && TextUtils.isEmpty(O000000o6)) {
                                    O000000o5.O00000o = false;
                                    O000000o6 = bwg.O00000Oo(O000000o5.f13319O000000o, "ip", "last_ip", str3);
                                    if (!TextUtils.isEmpty(O000000o6)) {
                                        O000000o5.O00000oo = O000000o6;
                                    }
                                }
                                if (!TextUtils.isEmpty(O000000o6)) {
                                    O000000o5.O0000O0o = O000000o6;
                                    O000000o4.O0000OOo = str4.replace(host, O000000o6);
                                    O000000o4.O00000oo.put("host", str5);
                                    if (!TextUtils.isEmpty(str5)) {
                                        O000000o4.O0000O0o = str5;
                                    } else {
                                        O000000o4.O0000O0o = str3;
                                    }
                                    O000000o5.O00000o0 = true;
                                }
                            }
                        }
                    }
                }
                bvu bvu = this.O0000o0O;
                long O00000o02 = bwi.O00000o0();
                if (bvu.O00000o || bwi.O0000OoO(bvu.O00000Oo)) {
                    z3 = true;
                }
                bta O000000o7 = bsw.O000000o(O000000o4, z3);
                bvu.O00000o0 = Long.valueOf(bwi.O00000o0() - O00000o02).intValue();
                bvs O000000o8 = bvs.O000000o(this.f13281O000000o);
                if (!TextUtils.isEmpty(O000000o8.O0000O0o) && (TextUtils.isEmpty(O000000o8.O00000oo) || !O000000o8.O0000O0o.equals(O000000o8.O00000oo))) {
                    O000000o8.O00000oo = O000000o8.O0000O0o;
                    bwg.O000000o(O000000o8.f13319O000000o, "ip", "last_ip", O000000o8.O0000O0o);
                }
                if (O000000o7 == null) {
                    bvs O000000o9 = bvs.O000000o(this.f13281O000000o);
                    if (O000000o9.O00000o0) {
                        bwg.O000000o(O000000o9.f13319O000000o, "pref", "dns_faile_count_total", 0L);
                    }
                    aMapLocationServer.a((long) this.O0000o0O.O00000o0);
                    if (!TextUtils.isEmpty(O000000o7.O00000o0)) {
                        StringBuilder sb2 = this.O0000o0o;
                        sb2.append("#csid:" + O000000o7.O00000o0);
                    }
                    str2 = O000000o7.O00000o;
                    aMapLocationServer.h(this.O0000ooo.toString());
                } else {
                    str2 = str3;
                }
                if (!z) {
                    AMapLocationServer O000000o10 = O000000o(aMapLocationServer, O000000o7);
                    if (O000000o10 != null) {
                        return O000000o10;
                    }
                    byte[] O000000o11 = bvo.O000000o(O000000o7.f13259O000000o);
                    if (O000000o11 == null) {
                        aMapLocationServer.setErrorCode(5);
                        this.O0000o0o.append("解密数据失败#0503");
                        aMapLocationServer.setLocationDetail(this.O0000o0o.toString());
                        bwf.O000000o(str2, 2053);
                        return aMapLocationServer;
                    }
                    aMapLocationServer = this.O0000O0o.O000000o(aMapLocationServer, O000000o11);
                    if (!bwi.O000000o(aMapLocationServer)) {
                        this.O000OOOo = aMapLocationServer.b();
                        bwf.O000000o(str2, !TextUtils.isEmpty(this.O000OOOo) ? 2062 : 2061);
                        aMapLocationServer.setErrorCode(6);
                        StringBuilder sb3 = this.O0000o0o;
                        StringBuilder sb4 = new StringBuilder("location faile retype:");
                        sb4.append(aMapLocationServer.d());
                        sb4.append(" rdesc:");
                        if (!TextUtils.isEmpty(this.O000OOOo)) {
                            str3 = this.O000OOOo;
                        }
                        sb4.append(str3);
                        sb4.append("#0601");
                        sb3.append(sb4.toString());
                        aMapLocationServer.h(this.O0000ooo.toString());
                        aMapLocationServer.setLocationDetail(this.O0000o0o.toString());
                        return aMapLocationServer;
                    }
                    if (aMapLocationServer.getErrorCode() == 0 && aMapLocationServer.getLocationType() == 0) {
                        if ("-5".equals(aMapLocationServer.d()) || "1".equals(aMapLocationServer.d()) || "2".equals(aMapLocationServer.d()) || "14".equals(aMapLocationServer.d()) || "24".equals(aMapLocationServer.d()) || "-1".equals(aMapLocationServer.d())) {
                            aMapLocationServer.setLocationType(5);
                        } else {
                            aMapLocationServer.setLocationType(6);
                        }
                    }
                    aMapLocationServer.setOffset(this.O0000oO0);
                    aMapLocationServer.a(this.O0000o);
                    aMapLocationServer.f(String.valueOf(this.O0000oO));
                }
                aMapLocationServer.e("new");
                aMapLocationServer.setLocationDetail(this.O0000o0o.toString());
                this.O000O0o = aMapLocationServer.a();
                return aMapLocationServer;
            } catch (Throwable ) {
                if (O000000o2.O00000Oo == null) {
                }
                if (!O000000o2.O00000Oo.isShutdown()) {
                }
            }
            bvz.O000000o(th, "Aps", "getApsLoc req");
            bwf.O000000o("/mobile/binary", th);
            if (!bwi.O00000o(this.f13281O000000o)) {
                sb = this.O0000o0o;
                str = "网络异常，未连接到网络，请连接网络#0401";
            } else {
                if (th instanceof t) {
                    t tVar = (t) th;
                    if (tVar.a().contains("网络异常状态码")) {
                        StringBuilder sb5 = this.O0000o0o;
                        sb5.append("网络异常，状态码错误#0404");
                        sb5.append(tVar.e());
                        AMapLocationServer O000000o12 = O000000o(4, this.O0000o0o.toString());
                        O000000o12.h(this.O0000ooo.toString());
                        return O000000o12;
                    } else if (tVar.e() == 23 || Math.abs((bwi.O00000o0() - this.O0000Ooo) - this.O0000Oo.getHttpTimeOut()) < 500) {
                        sb = this.O0000o0o;
                        str = "网络异常，连接超时#0402";
                    }
                }
                this.O0000o0o.append("网络异常,请求异常#0403");
                AMapLocationServer O000000o122 = O000000o(4, this.O0000o0o.toString());
                O000000o122.h(this.O0000ooo.toString());
                return O000000o122;
            }
            sb.append(str);
            AMapLocationServer O000000o1222 = O000000o(4, this.O0000o0o.toString());
            O000000o1222.h(this.O0000ooo.toString());
            return O000000o1222;
        } catch (Throwable th) {
            StringBuilder sb6 = this.O0000o0o;
            sb6.append("get parames error:" + th.getMessage() + "#0301");
            bwf.O000000o((String) null, 2031);
            AMapLocationServer O000000o13 = O000000o(3, this.O0000o0o.toString());
            O000000o13.h(this.O0000ooo.toString());
            return O000000o13;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bud.O000000o(boolean, boolean):com.autonavi.aps.amapapi.model.AMapLocationServer
     arg types: [int, boolean]
     candidates:
      _m_j.bud.O000000o(int, java.lang.String):com.autonavi.aps.amapapi.model.AMapLocationServer
      _m_j.bud.O000000o(com.autonavi.aps.amapapi.model.AMapLocationServer, _m_j.bta):com.autonavi.aps.amapapi.model.AMapLocationServer
      _m_j.bud.O000000o(double, double):com.autonavi.aps.amapapi.model.AMapLocationServer
      _m_j.bud.O000000o(boolean, boolean):com.autonavi.aps.amapapi.model.AMapLocationServer */
    public final AMapLocationServer O000000o(boolean z) {
        if (this.f13281O000000o == null) {
            this.O0000o0o.append("context is null#0101");
            bwf.O000000o((String) null, 2011);
            return O000000o(1, this.O0000o0o.toString());
        } else if (this.O00000o0.O0000Oo0) {
            return O000000o(15, "networkLocation has been mocked!#1502");
        } else {
            O000000o();
            if (TextUtils.isEmpty(this.O0000ooO)) {
                return O000000o(this.O000O00o, this.O0000o0o.toString());
            }
            AMapLocationServer O000000o2 = O000000o(false, z);
            if (bwi.O000000o(O000000o2)) {
                this.O00000oO.O00000oo = this.O0000ooo.toString();
                this.O00000oO.O0000O0o = this.O00000o.O000000o();
                O000000o(O000000o2);
            }
            return O000000o2;
        }
    }
}
