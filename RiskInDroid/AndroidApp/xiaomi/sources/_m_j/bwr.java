package _m_j;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class bwr {
    static AMapLocation O0000OoO;
    static long O0000Ooo;
    static Object O0000o00 = new Object();
    static long O0000oO0 = 0;
    static boolean O0000oOo = false;
    static boolean O0000oo0 = false;

    /* renamed from: O000000o  reason: collision with root package name */
    Handler f13348O000000o;
    /* access modifiers changed from: package-private */
    public Context O00000Oo;
    AMapLocationClientOption O00000o;
    LocationManager O00000o0;
    long O00000oO = 0;
    boolean O00000oo = false;
    bue O0000O0o = null;
    int O0000OOo = 240;
    AMapLocation O0000Oo = null;
    int O0000Oo0 = 80;
    Object O0000o = new Object();
    long O0000o0 = 0;
    float O0000o0O = 0.0f;
    Object O0000o0o = new Object();
    AMapLocationClientOption.GeoLanguage O0000oO = AMapLocationClientOption.GeoLanguage.DEFAULT;
    boolean O0000oOO = true;
    long O0000oo = 0;
    int O0000ooO = 0;
    LocationListener O0000ooo = new LocationListener() {
        /* class _m_j.bwr.AnonymousClass1 */

        public final void onLocationChanged(Location location) {
            Handler handler;
            if (bwr.this.f13348O000000o != null) {
                bwr.this.f13348O000000o.removeMessages(8);
            }
            if (location != null) {
                try {
                    AMapLocation aMapLocation = new AMapLocation(location);
                    if (bwi.O000000o(aMapLocation)) {
                        aMapLocation.setProvider("gps");
                        aMapLocation.setLocationType(1);
                        if (!bwr.this.O00000oo && bwi.O000000o(aMapLocation)) {
                            bwf.O000000o(bwr.this.O00000Oo, bwi.O00000o0() - bwr.this.O000O00o, bvz.O000000o(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                            bwr.this.O00000oo = true;
                        }
                        if (bwi.O000000o(location, bwr.this.O00oOooO)) {
                            aMapLocation.setMock(true);
                            aMapLocation.setTrustedLevel(4);
                            if (!bwr.this.O00000o.isMockEnable()) {
                                if (bwr.this.O0000ooO > 3) {
                                    bwf.O000000o((String) null, 2152);
                                    aMapLocation.setErrorCode(15);
                                    aMapLocation.setLocationDetail("GpsLocation has been mocked!#1501");
                                    aMapLocation.setLatitude(0.0d);
                                    aMapLocation.setLongitude(0.0d);
                                    aMapLocation.setAltitude(0.0d);
                                    aMapLocation.setSpeed(0.0f);
                                    aMapLocation.setAccuracy(0.0f);
                                    aMapLocation.setBearing(0.0f);
                                    aMapLocation.setExtras(null);
                                    bwr.this.O00000Oo(aMapLocation);
                                    return;
                                }
                                bwr.this.O0000ooO++;
                                return;
                            }
                        } else {
                            bwr.this.O0000ooO = 0;
                        }
                        aMapLocation.setSatellites(bwr.this.O00oOooO);
                        bwr.O00000Oo(bwr.this, aMapLocation);
                        bwr.O00000o0(bwr.this, aMapLocation);
                        bwr.O000000o(aMapLocation);
                        AMapLocation O00000o = bwr.O00000o(bwr.this, aMapLocation);
                        bwr.O00000oO(bwr.this, O00000o);
                        bwr bwr = bwr.this;
                        if (bwi.O000000o(O00000o) && bwr.f13348O000000o != null && bwr.O00000o.isNeedAddress()) {
                            long O00000o0 = bwi.O00000o0();
                            if (bwr.O00000o.getInterval() <= 8000 || O00000o0 - bwr.O0000oo > bwr.O00000o.getInterval() - 8000) {
                                Bundle bundle = new Bundle();
                                bundle.putDouble("lat", O00000o.getLatitude());
                                bundle.putDouble("lon", O00000o.getLongitude());
                                Message obtain = Message.obtain();
                                obtain.setData(bundle);
                                obtain.what = 5;
                                synchronized (bwr.O0000o0o) {
                                    if (bwr.O00oOooo == null) {
                                        handler = bwr.f13348O000000o;
                                    } else if (bwi.O000000o(O00000o, bwr.O00oOooo) > ((float) bwr.O0000Oo0)) {
                                        handler = bwr.f13348O000000o;
                                    }
                                    handler.sendMessage(obtain);
                                }
                            }
                        }
                        synchronized (bwr.this.O0000o0o) {
                            bwr.O000000o(bwr.this, O00000o, bwr.this.O00oOooo);
                        }
                        try {
                            if (bwi.O000000o(O00000o)) {
                                if (bwr.this.O0000Oo != null) {
                                    bwr.this.O0000o0 = location.getTime() - bwr.this.O0000Oo.getTime();
                                    bwr.this.O0000o0O = bwi.O000000o(bwr.this.O0000Oo, O00000o);
                                }
                                synchronized (bwr.this.O0000o) {
                                    bwr.this.O0000Oo = O00000o.clone();
                                }
                                String unused = bwr.this.O000O0o0 = null;
                                boolean unused2 = bwr.this.O000O0o = false;
                                int unused3 = bwr.this.O000O0oO = 0;
                            }
                        } catch (Throwable th) {
                            bvz.O000000o(th, "GpsLocation", "onLocationChangedLast");
                        }
                        bwr.this.O00000Oo(O00000o);
                    }
                } catch (Throwable th2) {
                    bvz.O000000o(th2, "GpsLocation", "onLocationChanged");
                }
            }
        }

        public final void onProviderDisabled(String str) {
            try {
                if ("gps".equalsIgnoreCase(str)) {
                    bwr.this.O00000oO = 0;
                    int unused = bwr.this.O00oOooO = 0;
                }
            } catch (Throwable unused2) {
            }
        }

        public final void onProviderEnabled(String str) {
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
            if (i == 0) {
                try {
                    bwr.this.O00000oO = 0;
                    int unused = bwr.this.O00oOooO = 0;
                } catch (Throwable unused2) {
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public long O000O00o = 0;
    private int O000O0OO = 0;
    /* access modifiers changed from: private */
    public GpsStatus O000O0Oo = null;
    /* access modifiers changed from: private */
    public boolean O000O0o = false;
    /* access modifiers changed from: private */
    public String O000O0o0 = null;
    /* access modifiers changed from: private */
    public int O000O0oO = 0;
    private boolean O000O0oo = false;
    private GpsStatus.Listener O00oOoOo = new GpsStatus.Listener() {
        /* class _m_j.bwr.AnonymousClass2 */

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        public final void onGpsStatusChanged(int i) {
            Iterable<GpsSatellite> satellites;
            try {
                if (bwr.this.O00000o0 != null) {
                    GpsStatus unused = bwr.this.O000O0Oo = bwr.this.O00000o0.getGpsStatus(bwr.this.O000O0Oo);
                    if (i != 1) {
                        int i2 = 0;
                        if (i == 2) {
                            int unused2 = bwr.this.O00oOooO = 0;
                        } else if (i != 3 && i == 4) {
                            if (!(bwr.this.O000O0Oo == null || (satellites = bwr.this.O000O0Oo.getSatellites()) == null)) {
                                Iterator<GpsSatellite> it = satellites.iterator();
                                int maxSatellites = bwr.this.O000O0Oo.getMaxSatellites();
                                while (it.hasNext() && i2 < maxSatellites) {
                                    if (it.next().usedInFix()) {
                                        i2++;
                                    }
                                }
                            }
                            int unused3 = bwr.this.O00oOooO = i2;
                        }
                    }
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "GpsLocation", "onGpsStatusChanged");
            }
        }
    };
    /* access modifiers changed from: package-private */
    public int O00oOooO = 0;
    public AMapLocation O00oOooo = null;

    public bwr(Context context, Handler handler) {
        this.O00000Oo = context;
        this.f13348O000000o = handler;
        try {
            this.O00000o0 = (LocationManager) this.O00000Oo.getSystemService("location");
        } catch (Throwable th) {
            bvz.O000000o(th, "GpsLocation", "<init>");
        }
        this.O0000O0o = new bue();
    }

    private void O000000o(int i, int i2, String str, long j) {
        try {
            if (this.f13348O000000o != null && this.O00000o.getLocationMode() == AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
                Message obtain = Message.obtain();
                AMapLocation aMapLocation = new AMapLocation("");
                aMapLocation.setProvider("gps");
                aMapLocation.setErrorCode(i2);
                aMapLocation.setLocationDetail(str);
                aMapLocation.setLocationType(1);
                obtain.obj = aMapLocation;
                obtain.what = i;
                this.f13348O000000o.sendMessageDelayed(obtain, j);
            }
        } catch (Throwable unused) {
        }
    }

    static /* synthetic */ void O000000o(bwr bwr, AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 != null && bwr.O00000o.isNeedAddress() && bwi.O000000o(aMapLocation, aMapLocation2) < ((float) bwr.O0000OOo)) {
            bvz.O000000o(aMapLocation, aMapLocation2);
        }
    }

    static /* synthetic */ void O000000o(AMapLocation aMapLocation) {
        if (bwi.O000000o(aMapLocation) && bvy.O000O0OO()) {
            long time = aMapLocation.getTime();
            long currentTimeMillis = System.currentTimeMillis();
            long O000000o2 = bwa.O000000o(time, currentTimeMillis, bvy.O000O0Oo());
            if (O000000o2 != time) {
                aMapLocation.setTime(O000000o2);
                bwf.O000000o(time, currentTimeMillis);
            }
        }
    }

    static boolean O000000o(LocationManager locationManager) {
        try {
            if (O0000oOo) {
                return O0000oo0;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders == null || allProviders.size() <= 0) {
                O0000oo0 = false;
            } else {
                O0000oo0 = allProviders.contains("gps");
            }
            O0000oOo = true;
            return O0000oo0;
        } catch (Throwable unused) {
            return O0000oo0;
        }
    }

    private boolean O000000o(String str) {
        try {
            ArrayList<String> O00000o2 = bwi.O00000o(str);
            ArrayList<String> O00000o3 = bwi.O00000o(this.O000O0o0);
            if (O00000o2.size() < 8 || O00000o3.size() < 8) {
                return false;
            }
            return bwi.O000000o(this.O000O0o0, str);
        } catch (Throwable unused) {
            return false;
        }
    }

    static /* synthetic */ void O00000Oo(bwr bwr, AMapLocation aMapLocation) {
        try {
            if (!bvz.O000000o(aMapLocation.getLatitude(), aMapLocation.getLongitude()) || !bwr.O00000o.isOffset()) {
                aMapLocation.setOffset(false);
                aMapLocation.setCoordType("WGS84");
                return;
            }
            DPoint O000000o2 = bwb.O000000o(bwr.O00000Oo, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
            aMapLocation.setLatitude(O000000o2.getLatitude());
            aMapLocation.setLongitude(O000000o2.getLongitude());
            aMapLocation.setOffset(bwr.O00000o.isOffset());
            aMapLocation.setCoordType("GCJ02");
        } catch (Throwable unused) {
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType("WGS84");
        }
    }

    /* access modifiers changed from: private */
    public void O00000Oo(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() == 15 && !AMapLocationClientOption.AMapLocationMode.Device_Sensors.equals(this.O00000o.getLocationMode())) {
            return;
        }
        if (this.O00000o.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.O00000o.getDeviceModeDistanceFilter() > 0.0f) {
            O00000o0(aMapLocation);
        } else if (bwi.O00000o0() - this.O0000oo >= this.O00000o.getInterval() - 200) {
            this.O0000oo = bwi.O00000o0();
            O00000o0(aMapLocation);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(16:15|16|(2:17|18)|21|22|23|24|25|26|29|30|31|32|33|34|(3:36|c5|41)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0091 */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c3 A[Catch:{ Throwable -> 0x00f0 }] */
    private AMapLocation O00000o() {
        float f;
        float f2;
        try {
            if (bwi.O000000o(this.O0000Oo) && bvy.O0000oO() && O00000o0()) {
                JSONObject jSONObject = new JSONObject((String) bwd.O000000o(brs.O00000o0("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), brs.O00000o0("UZ2V0TmF2aUxvY2F0aW9u"), (Object[]) null, (Class<?>[]) null));
                long optLong = jSONObject.optLong("time");
                if (!this.O000O0oo) {
                    this.O000O0oo = true;
                    bwf.O000000o("useNaviLoc", "use NaviLoc");
                }
                if (bwi.O00000Oo() - optLong <= 5500) {
                    double optDouble = jSONObject.optDouble("lat", 0.0d);
                    double optDouble2 = jSONObject.optDouble("lng", 0.0d);
                    float f3 = 0.0f;
                    try {
                        f = Float.parseFloat(jSONObject.optString("accuracy", "0"));
                    } catch (NumberFormatException unused) {
                        f = 0.0f;
                    }
                    double optDouble3 = jSONObject.optDouble("altitude", 0.0d);
                    try {
                        f2 = Float.parseFloat(jSONObject.optString("bearing", "0"));
                    } catch (NumberFormatException unused2) {
                        f2 = 0.0f;
                    }
                    f3 = (Float.parseFloat(jSONObject.optString("speed", "0")) * 10.0f) / 36.0f;
                    AMapLocation aMapLocation = new AMapLocation("lbs");
                    aMapLocation.setLocationType(9);
                    aMapLocation.setLatitude(optDouble);
                    aMapLocation.setLongitude(optDouble2);
                    aMapLocation.setAccuracy(f);
                    aMapLocation.setAltitude(optDouble3);
                    aMapLocation.setBearing(f2);
                    aMapLocation.setSpeed(f3);
                    aMapLocation.setTime(optLong);
                    aMapLocation.setCoordType("GCJ02");
                    if (bwi.O000000o(aMapLocation, this.O0000Oo) <= 300.0f) {
                        synchronized (this.O0000o) {
                            this.O0000Oo.setLongitude(optDouble2);
                            this.O0000Oo.setLatitude(optDouble);
                            this.O0000Oo.setAccuracy(f);
                            this.O0000Oo.setBearing(f2);
                            this.O0000Oo.setSpeed(f3);
                            this.O0000Oo.setTime(optLong);
                            this.O0000Oo.setCoordType("GCJ02");
                        }
                        return aMapLocation;
                    }
                }
            }
        } catch (Throwable unused3) {
        }
        return null;
    }

    static /* synthetic */ void O00000o0(bwr bwr, AMapLocation aMapLocation) {
        try {
            if (bwr.O00oOooO >= 4) {
                aMapLocation.setGpsAccuracyStatus(1);
            } else if (bwr.O00oOooO == 0) {
                aMapLocation.setGpsAccuracyStatus(-1);
            } else {
                aMapLocation.setGpsAccuracyStatus(0);
            }
        } catch (Throwable unused) {
        }
    }

    private void O00000o0(AMapLocation aMapLocation) {
        if (this.f13348O000000o != null) {
            Message obtain = Message.obtain();
            obtain.obj = aMapLocation;
            obtain.what = 2;
            this.f13348O000000o.sendMessage(obtain);
        }
    }

    private static boolean O00000o0() {
        try {
            return ((Boolean) bwd.O000000o(brs.O00000o0("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), brs.O00000o0("UaXNOYXZpU3RhcnRlZA=="), (Object[]) null, (Class<?>[]) null)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    static /* synthetic */ void O00000oO(bwr bwr, AMapLocation aMapLocation) {
        if (bwi.O000000o(aMapLocation)) {
            bwr.O00000oO = bwi.O00000o0();
            synchronized (O0000o00) {
                O0000Ooo = bwi.O00000o0();
                O0000OoO = aMapLocation.clone();
            }
            bwr.O000O0OO++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a7  */
    public final AMapLocation O000000o(AMapLocation aMapLocation, String str) {
        long j;
        long O00000o02;
        String str2 = str;
        if (this.O0000Oo == null) {
            return aMapLocation;
        }
        if ((!this.O00000o.isMockEnable() && this.O0000Oo.isMock()) || !bwi.O000000o(this.O0000Oo)) {
            return aMapLocation;
        }
        AMapLocation O00000o2 = O00000o();
        if (O00000o2 == null || !bwi.O000000o(O00000o2)) {
            float speed = this.O0000Oo.getSpeed();
            if (speed == 0.0f) {
                long j2 = this.O0000o0;
                if (j2 > 0 && j2 < 8) {
                    float f = this.O0000o0O;
                    if (f > 0.0f) {
                        speed = f / ((float) j2);
                    }
                }
            }
            if (aMapLocation != null && bwi.O000000o(aMapLocation)) {
                if (aMapLocation.getAccuracy() < 200.0f) {
                    this.O000O0oO++;
                    if (this.O000O0o0 == null && this.O000O0oO >= 2) {
                        this.O000O0o = true;
                    }
                    j = speed > 5.0f ? 10000 : 15000;
                } else {
                    if (!TextUtils.isEmpty(this.O000O0o0)) {
                        this.O000O0o = false;
                        this.O000O0oO = 0;
                    }
                    if (speed > 5.0f) {
                        j = 20000;
                    }
                }
                O00000o02 = bwi.O00000o0() - this.O00000oO;
                if (O00000o02 <= DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
                    return aMapLocation;
                }
                if (O00000o02 < j) {
                    if (this.O000O0o0 == null && this.O000O0oO >= 2) {
                        this.O000O0o0 = str2;
                    }
                    AMapLocation clone = this.O0000Oo.clone();
                    clone.setTrustedLevel(2);
                    return clone;
                } else if (!this.O000O0o || !O000000o(str2)) {
                    this.O000O0o0 = null;
                    this.O000O0oO = 0;
                    synchronized (this.O0000o) {
                        this.O0000Oo = null;
                    }
                    this.O0000o0 = 0;
                    this.O0000o0O = 0.0f;
                    return aMapLocation;
                } else {
                    AMapLocation clone2 = this.O0000Oo.clone();
                    clone2.setTrustedLevel(3);
                    return clone2;
                }
            }
            j = 30000;
            O00000o02 = bwi.O00000o0() - this.O00000oO;
            if (O00000o02 <= DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
            }
        } else {
            O00000o2.setTrustedLevel(2);
            return O00000o2;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:3|4|(1:6)|7|8|(1:10)|11|12|(1:14)|15|17) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0019 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000e */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0012 A[Catch:{ Throwable -> 0x0019 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x001d A[Catch:{ Throwable -> 0x0024 }] */
    public final void O000000o() {
        LocationManager locationManager = this.O00000o0;
        if (locationManager != null) {
            if (this.O0000ooo != null) {
                locationManager.removeUpdates(this.O0000ooo);
            }
            if (this.O00oOoOo != null) {
                this.O00000o0.removeGpsStatusListener(this.O00oOoOo);
            }
            if (this.f13348O000000o != null) {
                this.f13348O000000o.removeMessages(8);
            }
            this.O00oOooO = 0;
            this.O000O00o = 0;
            this.O0000oo = 0;
            this.O00000oO = 0;
            this.O000O0OO = 0;
            this.O0000ooO = 0;
            this.O0000O0o.O000000o();
            this.O0000Oo = null;
            this.O0000o0 = 0;
            this.O0000o0O = 0.0f;
            this.O000O0o0 = null;
            this.O000O0oo = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00fa, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00fb, code lost:
        r8.O0000oOO = false;
        _m_j.bwf.O000000o((java.lang.String) null, 2121);
        O000000o(2, 12, r0.getMessage() + "#1201", 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0121, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0093 */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00fa A[ExcHandler: SecurityException (r0v1 'e' java.lang.SecurityException A[CUSTOM_DECLARE]), Splitter:B:10:0x0021] */
    public final void O000000o(AMapLocationClientOption aMapLocationClientOption) {
        LocationManager locationManager;
        String str;
        long j;
        float f;
        LocationListener locationListener;
        this.O00000o = aMapLocationClientOption;
        if (this.O00000o == null) {
            this.O00000o = new AMapLocationClientOption();
        }
        try {
            O0000oO0 = bwg.O00000Oo(this.O00000Oo, "pref", "lagt", O0000oO0);
        } catch (Throwable unused) {
        }
        if (this.O00000o0 != null) {
            try {
                if (bwi.O00000o0() - O0000Ooo <= 5000 && bwi.O000000o(O0000OoO) && (this.O00000o.isMockEnable() || !O0000OoO.isMock())) {
                    this.O00000oO = bwi.O00000o0();
                    O00000Oo(O0000OoO);
                }
                this.O0000oOO = true;
                Looper myLooper = Looper.myLooper();
                if (myLooper == null) {
                    myLooper = this.O00000Oo.getMainLooper();
                }
                Looper looper = myLooper;
                this.O000O00o = bwi.O00000o0();
                if (O000000o(this.O00000o0)) {
                    if (bwi.O00000Oo() - O0000oO0 >= 259200000) {
                        this.O00000o0.sendExtraCommand("gps", "force_xtra_injection", null);
                        O0000oO0 = bwi.O00000Oo();
                        bwg.O000000o(this.O00000Oo, "pref", "lagt", O0000oO0);
                    }
                    if (this.O00000o.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) || this.O00000o.getDeviceModeDistanceFilter() <= 0.0f) {
                        locationManager = this.O00000o0;
                        str = "gps";
                        j = 900;
                        f = 0.0f;
                        locationListener = this.O0000ooo;
                    } else {
                        locationManager = this.O00000o0;
                        str = "gps";
                        j = this.O00000o.getInterval();
                        f = this.O00000o.getDeviceModeDistanceFilter();
                        locationListener = this.O0000ooo;
                    }
                    locationManager.requestLocationUpdates(str, j, f, locationListener, looper);
                    this.O00000o0.addGpsStatusListener(this.O00oOoOo);
                    O000000o(8, 14, "no enough satellites#1401", this.O00000o.getHttpTimeOut());
                    return;
                }
                O000000o(8, 14, "no gps provider#1402", 0);
            } catch (SecurityException e) {
            } catch (Throwable th) {
                bvz.O000000o(th, "GpsLocation", "requestLocationUpdates part2");
            }
        }
    }

    public final boolean O00000Oo() {
        return bwi.O00000o0() - this.O00000oO <= 2800;
    }

    static /* synthetic */ AMapLocation O00000o(bwr bwr, AMapLocation aMapLocation) {
        if (!bwi.O000000o(aMapLocation) || bwr.O000O0OO < 3) {
            return aMapLocation;
        }
        if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
            aMapLocation.setAccuracy(0.0f);
        }
        if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
            aMapLocation.setSpeed(0.0f);
        }
        bue bue = bwr.O0000O0o;
        if (!bwi.O000000o(aMapLocation)) {
            return aMapLocation;
        }
        long O00000o02 = bwi.O00000o0() - bue.O0000OOo;
        bue.O0000OOo = bwi.O00000o0();
        if (O00000o02 > 5000) {
            return aMapLocation;
        }
        if (bue.O0000O0o != null && ((1 == bue.O0000O0o.getLocationType() || "gps".equalsIgnoreCase(bue.O0000O0o.getProvider())) && !(bue.O0000O0o.getAltitude() == aMapLocation.getAltitude() && bue.O0000O0o.getLongitude() == aMapLocation.getLongitude()))) {
            long abs = Math.abs(aMapLocation.getTime() - bue.O0000O0o.getTime());
            if (DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS >= abs && bwi.O000000o(aMapLocation, bue.O0000O0o) > (((bue.O0000O0o.getSpeed() + aMapLocation.getSpeed()) * ((float) abs)) / 2000.0f) + ((bue.O0000O0o.getAccuracy() + aMapLocation.getAccuracy()) * 2.0f) + 3000.0f) {
                return bue.O0000O0o;
            }
        }
        bue.O0000O0o = aMapLocation;
        return aMapLocation;
    }
}
