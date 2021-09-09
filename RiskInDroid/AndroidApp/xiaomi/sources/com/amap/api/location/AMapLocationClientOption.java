package com.amap.api.location;

import _m_j.bvz;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.source.dash.DashMediaSource;

public class AMapLocationClientOption implements Parcelable, Cloneable {
    public static final Parcelable.Creator<AMapLocationClientOption> CREATOR = new Parcelable.Creator<AMapLocationClientOption>() {
        /* class com.amap.api.location.AMapLocationClientOption.AnonymousClass1 */

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AMapLocationClientOption(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AMapLocationClientOption[i];
        }
    };
    public static boolean OPEN_ALWAYS_SCAN_WIFI = true;
    public static long SCAN_WIFI_INTERVAL = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;

    /* renamed from: a  reason: collision with root package name */
    static String f3253a = "";
    private static AMapLocationProtocol j = AMapLocationProtocol.HTTP;
    private static boolean u = true;
    private long b;
    private long c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private AMapLocationMode i;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private long r;
    private long s;
    private GeoLanguage t;
    private float v;
    private AMapLocationPurpose w;

    /* renamed from: com.amap.api.location.AMapLocationClientOption$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3254a = new int[AMapLocationPurpose.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            f3254a[AMapLocationPurpose.SignIn.ordinal()] = 1;
            f3254a[AMapLocationPurpose.Transport.ordinal()] = 2;
            try {
                f3254a[AMapLocationPurpose.Sport.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public enum AMapLocationMode {
        Battery_Saving,
        Device_Sensors,
        Hight_Accuracy
    }

    public enum AMapLocationProtocol {
        HTTP(0),
        HTTPS(1);
        

        /* renamed from: a  reason: collision with root package name */
        private int f3256a;

        private AMapLocationProtocol(int i) {
            this.f3256a = i;
        }

        public final int getValue() {
            return this.f3256a;
        }
    }

    public enum AMapLocationPurpose {
        SignIn,
        Transport,
        Sport
    }

    public enum GeoLanguage {
        DEFAULT,
        ZH,
        EN
    }

    public AMapLocationClientOption() {
        this.b = 2000;
        this.c = (long) bvz.O00000oo;
        this.d = false;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = AMapLocationMode.Hight_Accuracy;
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = true;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
        this.s = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
        this.t = GeoLanguage.DEFAULT;
        this.v = 0.0f;
        this.w = null;
    }

    protected AMapLocationClientOption(Parcel parcel) {
        this.b = 2000;
        this.c = (long) bvz.O00000oo;
        boolean z = false;
        this.d = false;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = AMapLocationMode.Hight_Accuracy;
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = true;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
        this.s = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
        this.t = GeoLanguage.DEFAULT;
        this.v = 0.0f;
        AMapLocationPurpose aMapLocationPurpose = null;
        this.w = null;
        this.b = parcel.readLong();
        this.c = parcel.readLong();
        this.d = parcel.readByte() != 0;
        this.e = parcel.readByte() != 0;
        this.f = parcel.readByte() != 0;
        this.g = parcel.readByte() != 0;
        this.h = parcel.readByte() != 0;
        int readInt = parcel.readInt();
        this.i = readInt == -1 ? AMapLocationMode.Hight_Accuracy : AMapLocationMode.values()[readInt];
        this.k = parcel.readByte() != 0;
        this.l = parcel.readByte() != 0;
        this.m = parcel.readByte() != 0;
        this.n = parcel.readByte() != 0;
        this.o = parcel.readByte() != 0;
        this.p = parcel.readByte() != 0;
        this.q = parcel.readByte() != 0;
        this.r = parcel.readLong();
        int readInt2 = parcel.readInt();
        j = readInt2 == -1 ? AMapLocationProtocol.HTTP : AMapLocationProtocol.values()[readInt2];
        int readInt3 = parcel.readInt();
        this.t = readInt3 == -1 ? GeoLanguage.DEFAULT : GeoLanguage.values()[readInt3];
        u = parcel.readByte() != 0;
        this.v = parcel.readFloat();
        int readInt4 = parcel.readInt();
        this.w = readInt4 != -1 ? AMapLocationPurpose.values()[readInt4] : aMapLocationPurpose;
        OPEN_ALWAYS_SCAN_WIFI = parcel.readByte() != 0 ? true : z;
        this.s = parcel.readLong();
    }

    public static String getAPIKEY() {
        return f3253a;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return u;
    }

    public static boolean isOpenAlwaysScanWifi() {
        return OPEN_ALWAYS_SCAN_WIFI;
    }

    public static void setDownloadCoordinateConvertLibrary(boolean z) {
        u = z;
    }

    public static void setLocationProtocol(AMapLocationProtocol aMapLocationProtocol) {
        j = aMapLocationProtocol;
    }

    public static void setOpenAlwaysScanWifi(boolean z) {
        OPEN_ALWAYS_SCAN_WIFI = z;
    }

    public static void setScanWifiInterval(long j2) {
        SCAN_WIFI_INTERVAL = j2;
    }

    public AMapLocationClientOption clone() {
        try {
            super.clone();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.b = this.b;
        aMapLocationClientOption.d = this.d;
        aMapLocationClientOption.i = this.i;
        aMapLocationClientOption.e = this.e;
        aMapLocationClientOption.k = this.k;
        aMapLocationClientOption.l = this.l;
        aMapLocationClientOption.f = this.f;
        aMapLocationClientOption.g = this.g;
        aMapLocationClientOption.c = this.c;
        aMapLocationClientOption.m = this.m;
        aMapLocationClientOption.n = this.n;
        aMapLocationClientOption.o = this.o;
        aMapLocationClientOption.p = isSensorEnable();
        aMapLocationClientOption.q = isWifiScan();
        aMapLocationClientOption.r = this.r;
        setLocationProtocol(getLocationProtocol());
        aMapLocationClientOption.t = this.t;
        setDownloadCoordinateConvertLibrary(isDownloadCoordinateConvertLibrary());
        aMapLocationClientOption.v = this.v;
        aMapLocationClientOption.w = this.w;
        setOpenAlwaysScanWifi(isOpenAlwaysScanWifi());
        setScanWifiInterval(getScanWifiInterval());
        aMapLocationClientOption.s = this.s;
        return aMapLocationClientOption;
    }

    public int describeContents() {
        return 0;
    }

    public float getDeviceModeDistanceFilter() {
        return this.v;
    }

    public GeoLanguage getGeoLanguage() {
        return this.t;
    }

    public long getGpsFirstTimeout() {
        return this.s;
    }

    public long getHttpTimeOut() {
        return this.c;
    }

    public long getInterval() {
        return this.b;
    }

    public long getLastLocationLifeCycle() {
        return this.r;
    }

    public AMapLocationMode getLocationMode() {
        return this.i;
    }

    public AMapLocationProtocol getLocationProtocol() {
        return j;
    }

    public AMapLocationPurpose getLocationPurpose() {
        return this.w;
    }

    public long getScanWifiInterval() {
        return SCAN_WIFI_INTERVAL;
    }

    public boolean isGpsFirst() {
        return this.l;
    }

    public boolean isKillProcess() {
        return this.k;
    }

    public boolean isLocationCacheEnable() {
        return this.n;
    }

    public boolean isMockEnable() {
        return this.e;
    }

    public boolean isNeedAddress() {
        return this.f;
    }

    public boolean isOffset() {
        return this.m;
    }

    public boolean isOnceLocation() {
        return this.d;
    }

    public boolean isOnceLocationLatest() {
        return this.o;
    }

    public boolean isSensorEnable() {
        return this.p;
    }

    public boolean isWifiActiveScan() {
        return this.g;
    }

    public boolean isWifiScan() {
        return this.q;
    }

    public AMapLocationClientOption setDeviceModeDistanceFilter(float f2) {
        this.v = f2;
        return this;
    }

    public AMapLocationClientOption setGeoLanguage(GeoLanguage geoLanguage) {
        this.t = geoLanguage;
        return this;
    }

    public AMapLocationClientOption setGpsFirst(boolean z) {
        this.l = z;
        return this;
    }

    public AMapLocationClientOption setGpsFirstTimeout(long j2) {
        if (j2 < 5000) {
            j2 = 5000;
        }
        if (j2 > DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
            j2 = 30000;
        }
        this.s = j2;
        return this;
    }

    public AMapLocationClientOption setHttpTimeOut(long j2) {
        this.c = j2;
        return this;
    }

    public AMapLocationClientOption setInterval(long j2) {
        if (j2 <= 800) {
            j2 = 800;
        }
        this.b = j2;
        return this;
    }

    public AMapLocationClientOption setKillProcess(boolean z) {
        this.k = z;
        return this;
    }

    public AMapLocationClientOption setLastLocationLifeCycle(long j2) {
        this.r = j2;
        return this;
    }

    public AMapLocationClientOption setLocationCacheEnable(boolean z) {
        this.n = z;
        return this;
    }

    public AMapLocationClientOption setLocationMode(AMapLocationMode aMapLocationMode) {
        this.i = aMapLocationMode;
        return this;
    }

    public AMapLocationClientOption setLocationPurpose(AMapLocationPurpose aMapLocationPurpose) {
        this.w = aMapLocationPurpose;
        if (aMapLocationPurpose != null) {
            int i2 = AnonymousClass2.f3254a[aMapLocationPurpose.ordinal()];
            if (i2 == 1) {
                this.i = AMapLocationMode.Hight_Accuracy;
                this.d = true;
                this.o = true;
                this.l = false;
            } else if (i2 == 2 || i2 == 3) {
                this.i = AMapLocationMode.Hight_Accuracy;
                this.d = false;
                this.o = false;
                this.l = true;
            }
            this.e = false;
            this.q = true;
        }
        return this;
    }

    public AMapLocationClientOption setMockEnable(boolean z) {
        this.e = z;
        return this;
    }

    public AMapLocationClientOption setNeedAddress(boolean z) {
        this.f = z;
        return this;
    }

    public AMapLocationClientOption setOffset(boolean z) {
        this.m = z;
        return this;
    }

    public AMapLocationClientOption setOnceLocation(boolean z) {
        this.d = z;
        return this;
    }

    public AMapLocationClientOption setOnceLocationLatest(boolean z) {
        this.o = z;
        return this;
    }

    public AMapLocationClientOption setSensorEnable(boolean z) {
        this.p = z;
        return this;
    }

    public AMapLocationClientOption setWifiActiveScan(boolean z) {
        this.g = z;
        this.h = z;
        return this;
    }

    public AMapLocationClientOption setWifiScan(boolean z) {
        this.q = z;
        this.g = this.q ? this.h : false;
        return this;
    }

    public String toString() {
        return "interval:" + String.valueOf(this.b) + "#" + "isOnceLocation:" + String.valueOf(this.d) + "#" + "locationMode:" + String.valueOf(this.i) + "#" + "locationProtocol:" + String.valueOf(j) + "#" + "isMockEnable:" + String.valueOf(this.e) + "#" + "isKillProcess:" + String.valueOf(this.k) + "#" + "isGpsFirst:" + String.valueOf(this.l) + "#" + "isNeedAddress:" + String.valueOf(this.f) + "#" + "isWifiActiveScan:" + String.valueOf(this.g) + "#" + "wifiScan:" + String.valueOf(this.q) + "#" + "httpTimeOut:" + String.valueOf(this.c) + "#" + "isLocationCacheEnable:" + String.valueOf(this.n) + "#" + "isOnceLocationLatest:" + String.valueOf(this.o) + "#" + "sensorEnable:" + String.valueOf(this.p) + "#" + "geoLanguage:" + String.valueOf(this.t) + "#" + "locationPurpose:" + String.valueOf(this.w) + "#";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.b);
        parcel.writeLong(this.c);
        parcel.writeByte(this.d ? (byte) 1 : 0);
        parcel.writeByte(this.e ? (byte) 1 : 0);
        parcel.writeByte(this.f ? (byte) 1 : 0);
        parcel.writeByte(this.g ? (byte) 1 : 0);
        parcel.writeByte(this.h ? (byte) 1 : 0);
        AMapLocationMode aMapLocationMode = this.i;
        int i3 = -1;
        parcel.writeInt(aMapLocationMode == null ? -1 : aMapLocationMode.ordinal());
        parcel.writeByte(this.k ? (byte) 1 : 0);
        parcel.writeByte(this.l ? (byte) 1 : 0);
        parcel.writeByte(this.m ? (byte) 1 : 0);
        parcel.writeByte(this.n ? (byte) 1 : 0);
        parcel.writeByte(this.o ? (byte) 1 : 0);
        parcel.writeByte(this.p ? (byte) 1 : 0);
        parcel.writeByte(this.q ? (byte) 1 : 0);
        parcel.writeLong(this.r);
        parcel.writeInt(j == null ? -1 : getLocationProtocol().ordinal());
        GeoLanguage geoLanguage = this.t;
        parcel.writeInt(geoLanguage == null ? -1 : geoLanguage.ordinal());
        parcel.writeByte(u ? (byte) 1 : 0);
        parcel.writeFloat(this.v);
        AMapLocationPurpose aMapLocationPurpose = this.w;
        if (aMapLocationPurpose != null) {
            i3 = aMapLocationPurpose.ordinal();
        }
        parcel.writeInt(i3);
        parcel.writeInt(OPEN_ALWAYS_SCAN_WIFI ? 1 : 0);
        parcel.writeLong(this.s);
    }
}
