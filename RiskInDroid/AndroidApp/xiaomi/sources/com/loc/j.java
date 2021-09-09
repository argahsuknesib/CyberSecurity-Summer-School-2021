package com.loc;

import _m_j.bvz;
import _m_j.bwf;
import _m_j.bwi;
import _m_j.bwp;
import _m_j.bwt;
import _m_j.gsy;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.GeoFenceListener;
import com.amap.api.fence.GeoFenceManagerBase;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.DPoint;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

@SuppressLint({"NewApi"})
public final class j implements GeoFenceManagerBase {

    /* renamed from: O000000o  reason: collision with root package name */
    bwf f4535O000000o = null;
    Context O00000Oo = null;
    String O00000o = null;
    PendingIntent O00000o0 = null;
    GeoFenceListener O00000oO = null;
    volatile int O00000oo = 1;
    ArrayList<GeoFence> O0000O0o = new ArrayList<>();
    O00000o0 O0000OOo = null;
    Object O0000Oo = new Object();
    Object O0000Oo0 = new Object();
    O000000o O0000OoO = null;
    O00000Oo O0000Ooo = null;
    bwp O0000o = null;
    volatile boolean O0000o0 = false;
    volatile boolean O0000o00 = false;
    volatile boolean O0000o0O = false;
    k O0000o0o = null;
    volatile AMapLocation O0000oO = null;
    AMapLocationClient O0000oO0 = null;
    long O0000oOO = 0;
    AMapLocationClientOption O0000oOo = null;
    AMapLocationListener O0000oo = new AMapLocationListener() {
        /* class com.loc.j.AnonymousClass1 */

        public final void onLocationChanged(AMapLocation aMapLocation) {
            boolean z;
            int i;
            try {
                if (!j.this.O0000ooo && j.this.O0000o0O) {
                    j.this.O0000oO = aMapLocation;
                    if (aMapLocation != null) {
                        i = aMapLocation.getErrorCode();
                        if (aMapLocation.getErrorCode() == 0) {
                            j.this.O0000oOO = bwi.O00000o0();
                            j.this.O000000o(5, null, 0);
                            z = true;
                        } else {
                            j.O000000o("定位失败", aMapLocation.getErrorCode(), aMapLocation.getErrorInfo(), "locationDetail:" + aMapLocation.getLocationDetail());
                            z = false;
                        }
                    } else {
                        z = false;
                        i = 8;
                    }
                    if (z) {
                        j.this.O0000oo0 = 0;
                        j.this.O000000o(6, null, 0);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    if (!j.this.O0000o00) {
                        j.this.O000000o(7);
                        bundle.putLong("interval", 2000);
                        j.this.O000000o(8, bundle, 2000);
                    }
                    j.this.O0000oo0++;
                    if (j.this.O0000oo0 >= 3) {
                        bundle.putInt("location_errorcode", i);
                        j.this.O00000Oo(1002, bundle);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    };
    int O0000oo0 = 0;
    final int O0000ooO = 3;
    volatile boolean O0000ooo = false;
    private Object O00oOooO = new Object();

    static class O00000Oo extends HandlerThread {
        public O00000Oo(String str) {
            super(str);
        }

        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    class O00000o0 extends Handler {
        public O00000o0() {
        }

        public O00000o0(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            try {
                Bundle data = message.getData();
                switch (message.what) {
                    case 1000:
                        j jVar = j.this;
                        if (data != null) {
                            try {
                                if (!data.isEmpty()) {
                                    int i = data.getInt("errorCode");
                                    ArrayList parcelableArrayList = data.getParcelableArrayList("resultList");
                                    if (parcelableArrayList == null) {
                                        parcelableArrayList = new ArrayList();
                                    }
                                    String string = data.getString("customId");
                                    if (string == null) {
                                        string = "";
                                    }
                                    if (jVar.O00000oO != null) {
                                        jVar.O00000oO.onGeoFenceCreateFinished((ArrayList) parcelableArrayList.clone(), i, string);
                                    }
                                    if (i == 0) {
                                        jVar.O00000Oo();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                bvz.O000000o(th, "GeoFenceManager", "resultAddGeoFenceFinished");
                                return;
                            }
                        } else {
                            return;
                        }
                    case 1001:
                        try {
                            j.this.O00000Oo((GeoFence) data.getParcelable("geoFence"));
                            return;
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            return;
                        }
                    case 1002:
                        j.this.O00000Oo(data.getInt("location_errorcode"));
                        return;
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public j(Context context) {
        try {
            this.O00000Oo = context.getApplicationContext();
            O00000oo();
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceManger", "<init>");
        }
    }

    public static float O000000o(DPoint dPoint, List<DPoint> list) {
        float f = Float.MAX_VALUE;
        if (!(dPoint == null || list == null || list.isEmpty())) {
            for (DPoint O000000o2 : list) {
                f = Math.min(f, bwi.O000000o(dPoint, O000000o2));
            }
        }
        return f;
    }

    private int O000000o(List<GeoFence> list) {
        try {
            if (this.O0000O0o == null) {
                this.O0000O0o = new ArrayList<>();
            }
            for (GeoFence O000000o2 : list) {
                O000000o(O000000o2);
            }
            return 0;
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceManager", "addGeoFenceList");
            O000000o("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    private static Bundle O000000o(GeoFence geoFence, String str, String str2, int i, int i2) {
        Bundle bundle = new Bundle();
        if (str == null) {
            str = "";
        }
        bundle.putString("fenceid", str);
        bundle.putString("customId", str2);
        bundle.putInt("event", i);
        bundle.putInt("location_errorcode", i2);
        bundle.putParcelable("fence", geoFence);
        return bundle;
    }

    static void O000000o(String str, int i, String str2, String... strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("===========================================\n");
        stringBuffer.append("              " + str + "                ");
        stringBuffer.append("\n");
        stringBuffer.append("-------------------------------------------\n");
        stringBuffer.append("errorCode:".concat(String.valueOf(i)));
        stringBuffer.append("\n");
        stringBuffer.append("错误信息:".concat(String.valueOf(str2)));
        stringBuffer.append("\n");
        if (strArr.length > 0) {
            for (String append : strArr) {
                stringBuffer.append(append);
                stringBuffer.append("\n");
            }
        }
        stringBuffer.append("===========================================\n");
        gsy.O000000o(4, "fenceErrLog", stringBuffer.toString());
    }

    private static boolean O000000o(GeoFence geoFence, int i) {
        boolean z = false;
        if ((i & 1) == 1) {
            try {
                if (geoFence.getStatus() == 1) {
                    z = true;
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "Utils", "remindStatus");
                return false;
            }
        }
        if ((i & 2) == 2 && geoFence.getStatus() == 2) {
            z = true;
        }
        if ((i & 4) == 4 && geoFence.getStatus() == 3) {
            return true;
        }
        return z;
    }

    private static boolean O000000o(AMapLocation aMapLocation, GeoFence geoFence) {
        boolean z;
        try {
            if (bwi.O000000o(aMapLocation) && geoFence != null && geoFence.getPointList() != null && !geoFence.getPointList().isEmpty()) {
                int type = geoFence.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type != 2) {
                            if (type != 3) {
                            }
                        }
                    }
                    boolean z2 = false;
                    for (List next : geoFence.getPointList()) {
                        try {
                            if (next.size() < 3 ? false : bvz.O000000o(new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()), next)) {
                                z2 = true;
                            }
                        } catch (Throwable th) {
                            th = th;
                            z = z2;
                            bvz.O000000o(th, "Utils", "isInGeoFence");
                            return z;
                        }
                    }
                    return z2;
                }
                DPoint center = geoFence.getCenter();
                if (bwi.O000000o(new double[]{center.getLatitude(), center.getLongitude(), aMapLocation.getLatitude(), aMapLocation.getLongitude()}) <= geoFence.getRadius()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            z = false;
            bvz.O000000o(th, "Utils", "isInGeoFence");
            return z;
        }
    }

    public static float O00000Oo(DPoint dPoint, List<DPoint> list) {
        float f = Float.MIN_VALUE;
        if (!(dPoint == null || list == null || list.isEmpty())) {
            for (DPoint O000000o2 : list) {
                f = Math.max(f, bwi.O000000o(dPoint, O000000o2));
            }
        }
        return f;
    }

    private static DPoint O00000Oo(List<DPoint> list) {
        DPoint dPoint = new DPoint();
        if (list == null) {
            return dPoint;
        }
        try {
            double d = 0.0d;
            double d2 = 0.0d;
            for (DPoint next : list) {
                d += next.getLatitude();
                d2 += next.getLongitude();
            }
            double size = (double) list.size();
            Double.isNaN(size);
            double O00000o02 = bwi.O00000o0(d / size);
            double size2 = (double) list.size();
            Double.isNaN(size2);
            return new DPoint(O00000o02, bwi.O00000o0(d2 / size2));
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceUtil", "getPolygonCenter");
            return dPoint;
        }
    }

    private static boolean O00000Oo(AMapLocation aMapLocation, GeoFence geoFence) {
        boolean z = true;
        try {
            if (O000000o(aMapLocation, geoFence)) {
                if (geoFence.getEnterTime() == -1) {
                    if (geoFence.getStatus() != 1) {
                        geoFence.setEnterTime(bwi.O00000o0());
                        geoFence.setStatus(1);
                        return true;
                    }
                } else if (geoFence.getStatus() != 3 && bwi.O00000o0() - geoFence.getEnterTime() > 600000) {
                    geoFence.setStatus(3);
                    return true;
                }
            } else if (geoFence.getStatus() != 2) {
                try {
                    geoFence.setStatus(2);
                    geoFence.setEnterTime(-1);
                    return true;
                } catch (Throwable th) {
                    th = th;
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            z = false;
            bvz.O000000o(th, "Utils", "isFenceStatusChanged");
            return z;
        }
    }

    private void O00000oo() {
        if (!this.O0000o0O) {
            this.O0000o0O = true;
        }
        if (!this.O0000o0) {
            try {
                this.O0000OOo = Looper.myLooper() == null ? new O00000o0(this.O00000Oo.getMainLooper()) : new O00000o0();
            } catch (Throwable th) {
                bvz.O000000o(th, "GeoFenceManger", "init 1");
            }
            try {
                this.O0000Ooo = new O00000Oo("fenceActionThread");
                this.O0000Ooo.setPriority(5);
                this.O0000Ooo.start();
                this.O0000OoO = new O000000o(this.O0000Ooo.getLooper());
            } catch (Throwable th2) {
                bvz.O000000o(th2, "GeoFenceManger", "init 2");
            }
            try {
                this.O0000o0o = new k(this.O00000Oo);
                this.O0000o = new bwp();
                this.O0000oOo = new AMapLocationClientOption();
                this.O0000oO0 = new AMapLocationClient(this.O00000Oo);
                this.O0000oOo.setLocationCacheEnable(true);
                this.O0000oOo.setNeedAddress(false);
                this.O0000oO0.setLocationListener(this.O0000oo);
                if (this.f4535O000000o == null) {
                    this.f4535O000000o = new bwf();
                }
            } catch (Throwable th3) {
                bvz.O000000o(th3, "GeoFenceManger", "initBase");
            }
            this.O0000o0 = true;
            try {
                if (this.O00000o != null && this.O00000o0 == null) {
                    createPendingIntent(this.O00000o);
                }
            } catch (Throwable th4) {
                bvz.O000000o(th4, "GeoFenceManger", "init 4");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int O000000o(GeoFence geoFence) {
        try {
            if (this.O0000O0o == null) {
                this.O0000O0o = new ArrayList<>();
            }
            if (this.O0000O0o.contains(geoFence)) {
                return 17;
            }
            this.O0000O0o.add(geoFence);
            return 0;
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceManager", "addGeoFence2List");
            O000000o("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    /* JADX WARN: Type inference failed for: r7v6, types: [android.os.Parcelable] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    public final GeoFence O000000o(Bundle bundle, boolean z) {
        GeoFence geoFence = new GeoFence();
        ArrayList arrayList = new ArrayList();
        DPoint dPoint = new DPoint();
        if (z) {
            geoFence.setType(1);
            arrayList = bundle.getParcelableArrayList("pointList");
            if (arrayList != null) {
                dPoint = O00000Oo(arrayList);
            }
            geoFence.setMaxDis2Center(O00000Oo(dPoint, arrayList));
            geoFence.setMinDis2Center(O000000o(dPoint, arrayList));
        } else {
            geoFence.setType(0);
            dPoint = bundle.getParcelable("centerPoint");
            if (dPoint != null) {
                arrayList.add(dPoint);
            }
            float f = 1000.0f;
            float f2 = bundle.getFloat("fenceRadius", 1000.0f);
            if (f2 > 0.0f) {
                f = f2;
            }
            geoFence.setRadius(f);
            geoFence.setMinDis2Center(f);
            geoFence.setMaxDis2Center(f);
        }
        geoFence.setActivatesAction(this.O00000oo);
        geoFence.setCustomId(bundle.getString("customId"));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(arrayList);
        geoFence.setPointList(arrayList2);
        geoFence.setCenter(dPoint);
        geoFence.setPendingIntentAction(this.O00000o);
        geoFence.setExpiration(-1);
        geoFence.setPendingIntent(this.O00000o0);
        StringBuilder sb = new StringBuilder();
        sb.append(bwp.O000000o());
        geoFence.setFenceId(sb.toString());
        bwf bwf = this.f4535O000000o;
        if (bwf != null) {
            bwf.O000000o(this.O00000Oo, 2);
        }
        return geoFence;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        try {
            if (this.O0000o0) {
                if (this.O0000O0o != null) {
                    this.O0000O0o.clear();
                    this.O0000O0o = null;
                }
                if (!this.O0000o0O) {
                    try {
                        synchronized (this.O0000Oo0) {
                            if (this.O0000OoO != null) {
                                this.O0000OoO.removeCallbacksAndMessages(null);
                            }
                            this.O0000OoO = null;
                        }
                    } catch (Throwable th) {
                        bvz.O000000o(th, "GeoFenceManager", "destroyActionHandler");
                    }
                    if (this.O0000oO0 != null) {
                        this.O0000oO0.stopLocation();
                        this.O0000oO0.onDestroy();
                    }
                    this.O0000oO0 = null;
                    if (this.O0000Ooo != null) {
                        if (Build.VERSION.SDK_INT >= 18) {
                            this.O0000Ooo.quitSafely();
                        } else {
                            this.O0000Ooo.quit();
                        }
                    }
                    this.O0000Ooo = null;
                    this.O0000o0o = null;
                    synchronized (this.O00oOooO) {
                        if (this.O00000o0 != null) {
                            this.O00000o0.cancel();
                        }
                        this.O00000o0 = null;
                    }
                    try {
                        synchronized (this.O0000Oo) {
                            if (this.O0000OOo != null) {
                                this.O0000OOo.removeCallbacksAndMessages(null);
                            }
                            this.O0000OOo = null;
                        }
                    } catch (Throwable th2) {
                        bvz.O000000o(th2, "GeoFenceManager", "destroyResultHandler");
                    }
                    if (this.f4535O000000o != null) {
                        this.f4535O000000o.O00000Oo(this.O00000Oo);
                    }
                    this.O0000o00 = false;
                    this.O0000o0 = false;
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i) {
        try {
            synchronized (this.O0000Oo0) {
                if (this.O0000OoO != null) {
                    this.O0000OoO.removeMessages(i);
                }
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceManager", "removeActionHandlerMessage");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d6 A[Catch:{ Throwable -> 0x01f8, all -> 0x01f4 }] */
    public final void O000000o(int i, Bundle bundle) {
        int i2;
        int i3;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        String str5;
        String str6;
        String str7;
        int i4 = i;
        Bundle bundle2 = bundle;
        Bundle bundle3 = new Bundle();
        try {
            ArrayList arrayList = new ArrayList();
            if (bundle2 != null) {
                try {
                    if (!bundle.isEmpty()) {
                        ArrayList arrayList2 = new ArrayList();
                        String string = bundle2.getString("customId");
                        String string2 = bundle2.getString("keyWords");
                        String string3 = bundle2.getString("city");
                        String string4 = bundle2.getString("poiType");
                        DPoint dPoint = (DPoint) bundle2.getParcelable("centerPoint");
                        int i5 = bundle2.getInt("searchSize", 10);
                        float f = bundle2.getFloat("aroundRadius", 3000.0f);
                        if (!TextUtils.isEmpty(string2)) {
                            if (i4 != 1) {
                                if (i4 == 2) {
                                    if (dPoint != null) {
                                        try {
                                            if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d || dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
                                                str4 = "添加围栏失败";
                                                O000000o(str4, 0, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                                                z = false;
                                                if (!z) {
                                                    Bundle bundle4 = new Bundle();
                                                    bundle4.putString("customId", string);
                                                    bundle4.putString("pendingIntentAction", this.O00000o);
                                                    str6 = "customId";
                                                    str5 = "errorCode";
                                                    try {
                                                        bundle4.putLong("expiration", -1);
                                                        bundle4.putInt("activatesAction", this.O00000oo);
                                                        if (i4 == 1) {
                                                            bundle4.putFloat("fenceRadius", 1000.0f);
                                                            str7 = k.O000000o(this.O00000Oo, "http://restapi.amap.com/v3/place/text?", string2, string4, string3, String.valueOf(i5));
                                                        } else if (i4 == 2) {
                                                            double O00000o02 = bwi.O00000o0(dPoint.getLatitude());
                                                            double O00000o03 = bwi.O00000o0(dPoint.getLongitude());
                                                            int intValue = Float.valueOf(f).intValue();
                                                            bundle4.putFloat("fenceRadius", 200.0f);
                                                            str7 = k.O000000o(this.O00000Oo, "http://restapi.amap.com/v3/place/around?", string2, string4, String.valueOf(i5), String.valueOf(O00000o02), String.valueOf(O00000o03), String.valueOf(intValue));
                                                        } else if (i4 != 3) {
                                                            str7 = null;
                                                        } else {
                                                            try {
                                                                str7 = k.O000000o(this.O00000Oo, "http://restapi.amap.com/v3/config/district?", string2);
                                                            } catch (Throwable th) {
                                                                th = th;
                                                                str = str5;
                                                                i3 = 1000;
                                                                i2 = 0;
                                                                bundle3.putInt(str, i2);
                                                                O00000Oo(i3, bundle3);
                                                                throw th;
                                                            }
                                                        }
                                                        int i6 = 4;
                                                        if (str7 != null) {
                                                            int O000000o2 = 1 == i4 ? bwp.O000000o(str7, arrayList2, bundle4) : 0;
                                                            if (2 == i4) {
                                                                O000000o2 = bwp.O000000o(str7, arrayList2, bundle4);
                                                            }
                                                            int O00000Oo2 = 3 == i4 ? this.O0000o.O00000Oo(str7, arrayList2, bundle4) : O000000o2;
                                                            if (O00000Oo2 != 10000) {
                                                                if (!(O00000Oo2 == 1 || O00000Oo2 == 7 || O00000Oo2 == 4 || O00000Oo2 == 5 || O00000Oo2 == 16 || O00000Oo2 == 17)) {
                                                                    switch (O00000Oo2) {
                                                                        case C.MSG_CUSTOM_BASE:
                                                                            O00000Oo2 = 0;
                                                                            break;
                                                                        case 10001:
                                                                        case 10002:
                                                                        case 10007:
                                                                        case 10008:
                                                                        case 10009:
                                                                        case 10012:
                                                                        case 10013:
                                                                            O00000Oo2 = 7;
                                                                            break;
                                                                        case 10003:
                                                                        case 10004:
                                                                        case 10005:
                                                                        case 10006:
                                                                        case 10010:
                                                                        case 10011:
                                                                        case 10014:
                                                                        case 10015:
                                                                        case 10016:
                                                                        case 10017:
                                                                            O00000Oo2 = 4;
                                                                            break;
                                                                        default:
                                                                            switch (O00000Oo2) {
                                                                                case 20000:
                                                                                case 20001:
                                                                                case 20002:
                                                                                    O00000Oo2 = 1;
                                                                                    break;
                                                                                case 20003:
                                                                                default:
                                                                                    O00000Oo2 = 8;
                                                                                    break;
                                                                            }
                                                                    }
                                                                }
                                                                if (O00000Oo2 != 0) {
                                                                    O000000o(str4, O00000Oo2, "searchErrCode is ".concat(String.valueOf(O00000Oo2)), new String[0]);
                                                                }
                                                                i2 = O00000Oo2;
                                                            } else if (arrayList2.isEmpty()) {
                                                                i2 = 16;
                                                            } else {
                                                                i2 = O000000o(arrayList2);
                                                                if (i2 == 0) {
                                                                    try {
                                                                        arrayList.addAll(arrayList2);
                                                                    } catch (Throwable th2) {
                                                                        th = th2;
                                                                        str2 = str5;
                                                                        i3 = 1000;
                                                                        bundle3.putInt(str, i2);
                                                                        O00000Oo(i3, bundle3);
                                                                        throw th;
                                                                    }
                                                                } else {
                                                                    i6 = i2;
                                                                }
                                                            }
                                                        }
                                                        i2 = i6;
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        str = str5;
                                                        i3 = 1000;
                                                        i2 = 0;
                                                        bundle3.putInt(str, i2);
                                                        O00000Oo(i3, bundle3);
                                                        throw th;
                                                    }
                                                } else {
                                                    str6 = "customId";
                                                    str5 = "errorCode";
                                                    i2 = 1;
                                                }
                                                bundle3.putString(str6, string);
                                                bundle3.putParcelableArrayList("resultList", arrayList);
                                                str3 = str5;
                                                bundle3.putInt(str3, i2);
                                                O00000Oo(1000, bundle3);
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            str = "errorCode";
                                            i3 = 1000;
                                            i2 = 0;
                                            bundle3.putInt(str, i2);
                                            O00000Oo(i3, bundle3);
                                            throw th;
                                        }
                                    }
                                }
                                str4 = "添加围栏失败";
                            } else {
                                str4 = "添加围栏失败";
                                if (TextUtils.isEmpty(string4)) {
                                    z = false;
                                    if (!z) {
                                    }
                                    bundle3.putString(str6, string);
                                    bundle3.putParcelableArrayList("resultList", arrayList);
                                    str3 = str5;
                                    bundle3.putInt(str3, i2);
                                    O00000Oo(1000, bundle3);
                                }
                            }
                            z = true;
                            if (!z) {
                            }
                            bundle3.putString(str6, string);
                            bundle3.putParcelableArrayList("resultList", arrayList);
                            str3 = str5;
                            bundle3.putInt(str3, i2);
                            O00000Oo(1000, bundle3);
                        }
                        str4 = "添加围栏失败";
                        z = false;
                        if (!z) {
                        }
                        bundle3.putString(str6, string);
                        bundle3.putParcelableArrayList("resultList", arrayList);
                        str3 = str5;
                        bundle3.putInt(str3, i2);
                        O00000Oo(1000, bundle3);
                    }
                } catch (Throwable th5) {
                    th = th5;
                    str = "errorCode";
                    i3 = 1000;
                    i2 = 0;
                    bundle3.putInt(str, i2);
                    O00000Oo(i3, bundle3);
                    throw th;
                }
            }
            str3 = "errorCode";
            i2 = 1;
            bundle3.putInt(str3, i2);
            O00000Oo(1000, bundle3);
        } catch (Throwable th6) {
            th = th6;
            str = "errorCode";
            i3 = 1000;
            i2 = 0;
            bundle3.putInt(str, i2);
            O00000Oo(i3, bundle3);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, Bundle bundle, long j) {
        try {
            synchronized (this.O0000Oo0) {
                if (this.O0000OoO != null) {
                    Message obtainMessage = this.O0000OoO.obtainMessage();
                    obtainMessage.what = i;
                    obtainMessage.setData(bundle);
                    this.O0000OoO.sendMessageDelayed(obtainMessage, j);
                }
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceManager", "sendActionHandlerMessage");
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(Bundle bundle) {
        int i = 1;
        if (bundle != null) {
            try {
                i = bundle.getInt("activatesAction", 1);
            } catch (Throwable th) {
                bvz.O000000o(th, "GeoFenceManager", "doSetActivatesAction");
                return;
            }
        }
        if (this.O00000oo != i) {
            if (this.O0000O0o != null && !this.O0000O0o.isEmpty()) {
                Iterator<GeoFence> it = this.O0000O0o.iterator();
                while (it.hasNext()) {
                    GeoFence next = it.next();
                    next.setStatus(0);
                    next.setEnterTime(-1);
                }
            }
            O00000Oo();
        }
        this.O00000oo = i;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(AMapLocation aMapLocation) {
        try {
            if (this.O0000ooo || this.O0000O0o == null) {
                return;
            }
            if (!this.O0000O0o.isEmpty()) {
                if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
                    Iterator<GeoFence> it = this.O0000O0o.iterator();
                    while (it.hasNext()) {
                        GeoFence next = it.next();
                        if (next.isAble() && O00000Oo(aMapLocation, next) && O000000o(next, this.O00000oo)) {
                            next.setCurrentLocation(aMapLocation);
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("geoFence", next);
                            O00000Oo(1001, bundle);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceManager", "doCheckFence");
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        if (!this.O0000ooo && this.O0000OoO != null) {
            boolean z = false;
            if (this.O0000oO != null && bwi.O000000o(this.O0000oO) && bwi.O00000o0() - this.O0000oOO < 10000) {
                z = true;
            }
            if (z) {
                O000000o(6, null, 0);
                O000000o(5, null, 0);
                return;
            }
            O000000o(7);
            O000000o(7, null, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(int i) {
        try {
            if (this.O00000Oo != null) {
                synchronized (this.O00oOooO) {
                    if (this.O00000o0 != null) {
                        Intent intent = new Intent();
                        intent.putExtras(O000000o(null, null, null, 4, i));
                        this.O00000o0.send(this.O00000Oo, 0, intent);
                    }
                }
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceManager", "resultRemindLocationError");
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(int i, Bundle bundle) {
        try {
            synchronized (this.O0000Oo) {
                if (this.O0000OOo != null) {
                    Message obtainMessage = this.O0000OOo.obtainMessage();
                    obtainMessage.what = i;
                    obtainMessage.setData(bundle);
                    this.O0000OOo.sendMessage(obtainMessage);
                }
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceManager", "sendResultHandlerMessage");
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(Bundle bundle) {
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    String string = bundle.getString("fid");
                    if (!TextUtils.isEmpty(string)) {
                        boolean z = true;
                        boolean z2 = bundle.getBoolean("ab", true);
                        if (this.O0000O0o != null && !this.O0000O0o.isEmpty()) {
                            Iterator<GeoFence> it = this.O0000O0o.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                GeoFence next = it.next();
                                if (next.getFenceId().equals(string)) {
                                    next.setAble(z2);
                                    break;
                                }
                            }
                        }
                        if (!z2) {
                            if (this.O0000O0o != null) {
                                if (!this.O0000O0o.isEmpty()) {
                                    Iterator<GeoFence> it2 = this.O0000O0o.iterator();
                                    while (true) {
                                        if (it2.hasNext()) {
                                            if (it2.next().isAble()) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                }
                            }
                            if (z) {
                                O00000oO();
                                return;
                            }
                            return;
                        }
                        O00000Oo();
                    }
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "GeoFenceManager", "doSetGeoFenceAble");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
        return;
     */
    public final void O00000Oo(GeoFence geoFence) {
        PendingIntent pendingIntent;
        Context context;
        try {
            synchronized (this.O00oOooO) {
                if (this.O00000Oo != null) {
                    if (this.O00000o0 != null || geoFence.getPendingIntent() != null) {
                        Intent intent = new Intent();
                        intent.putExtras(O000000o(geoFence, geoFence.getFenceId(), geoFence.getCustomId(), geoFence.getStatus(), 0));
                        if (this.O00000o != null) {
                            intent.setAction(this.O00000o);
                        }
                        intent.setPackage(bwt.O00000o0(this.O00000Oo));
                        if (geoFence.getPendingIntent() != null) {
                            pendingIntent = geoFence.getPendingIntent();
                            context = this.O00000Oo;
                        } else {
                            pendingIntent = this.O00000o0;
                            context = this.O00000Oo;
                        }
                        pendingIntent.send(context, 0, intent);
                    }
                }
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceManager", "resultTriggerGeoFence");
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000o() {
        float f;
        try {
            if (!this.O0000ooo && bwi.O000000o(this.O0000oO)) {
                AMapLocation aMapLocation = this.O0000oO;
                ArrayList<GeoFence> arrayList = this.O0000O0o;
                if (aMapLocation != null && aMapLocation.getErrorCode() == 0 && arrayList != null && !arrayList.isEmpty()) {
                    DPoint dPoint = new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude());
                    Iterator<GeoFence> it = arrayList.iterator();
                    float f2 = Float.MAX_VALUE;
                    while (true) {
                        if (!it.hasNext()) {
                            f = f2;
                            break;
                        }
                        GeoFence next = it.next();
                        if (next.isAble()) {
                            float O000000o2 = bwi.O000000o(dPoint, next.getCenter());
                            if (O000000o2 > next.getMinDis2Center() && O000000o2 < next.getMaxDis2Center()) {
                                f = 0.0f;
                                break;
                            }
                            if (O000000o2 > next.getMaxDis2Center()) {
                                f2 = Math.min(f2, O000000o2 - next.getMaxDis2Center());
                            }
                            if (O000000o2 < next.getMinDis2Center()) {
                                f2 = Math.min(f2, next.getMinDis2Center() - O000000o2);
                            }
                        }
                    }
                } else {
                    f = Float.MAX_VALUE;
                }
                if (f != Float.MAX_VALUE) {
                    if (f < 1000.0f) {
                        O000000o(7);
                        Bundle bundle = new Bundle();
                        bundle.putLong("interval", 2000);
                        O000000o(8, bundle, 500);
                    } else if (f < 5000.0f) {
                        O00000o0();
                        O000000o(7);
                        O000000o(7, null, 10000);
                    } else {
                        O00000o0();
                        O000000o(7);
                        O000000o(7, null, (long) (((f - 4000.0f) / 100.0f) * 1000.0f));
                    }
                }
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceManager", "doCheckLocationPolicy");
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0() {
        try {
            if (this.O0000o00) {
                O000000o(8);
            }
            if (this.O0000oO0 != null) {
                this.O0000oO0.stopLocation();
            }
            this.O0000o00 = false;
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000oO() {
        try {
            O000000o(7);
            O000000o(8);
            if (this.O0000oO0 != null) {
                this.O0000oO0.stopLocation();
            }
            this.O0000o00 = false;
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceManager", "doPauseGeoFence");
        }
    }

    public final void addDistrictGeoFence(String str, String str2) {
        try {
            O00000oo();
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("customId", str2);
            O000000o(4, bundle, 0);
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceManager", "addDistricetGeoFence");
        }
    }

    public final void addKeywordGeoFence(String str, String str2, String str3, int i, String str4) {
        try {
            O00000oo();
            if (i <= 0) {
                i = 10;
            }
            if (i > 25) {
                i = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putString("city", str3);
            bundle.putInt("searchSize", i);
            bundle.putString("customId", str4);
            O000000o(2, bundle, 0);
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceManager", "addKeywordGeoFence");
        }
    }

    public final void addNearbyGeoFence(String str, String str2, DPoint dPoint, float f, int i, String str3) {
        try {
            O00000oo();
            if (f <= 0.0f || f > 50000.0f) {
                f = 3000.0f;
            }
            if (i <= 0) {
                i = 10;
            }
            if (i > 25) {
                i = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("aroundRadius", f);
            bundle.putInt("searchSize", i);
            bundle.putString("customId", str3);
            O000000o(3, bundle, 0);
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceManager", "addNearbyGeoFence");
        }
    }

    public final void addPolygonGeoFence(List<DPoint> list, String str) {
        try {
            O00000oo();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("pointList", new ArrayList(list));
            bundle.putString("customId", str);
            O000000o(1, bundle, 0);
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceManager", "addPolygonGeoFence");
        }
    }

    public final void addRoundGeoFence(DPoint dPoint, float f, String str) {
        try {
            O00000oo();
            Bundle bundle = new Bundle();
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("fenceRadius", f);
            bundle.putString("customId", str);
            O000000o(0, bundle, 0);
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceManager", "addRoundGeoFence");
        }
    }

    public final PendingIntent createPendingIntent(String str) {
        synchronized (this.O00oOooO) {
            try {
                Intent intent = new Intent(str);
                intent.setPackage(bwt.O00000o0(this.O00000Oo));
                this.O00000o0 = PendingIntent.getBroadcast(this.O00000Oo, 0, intent, 0);
                this.O00000o = str;
                if (this.O0000O0o != null && !this.O0000O0o.isEmpty()) {
                    Iterator<GeoFence> it = this.O0000O0o.iterator();
                    while (it.hasNext()) {
                        GeoFence next = it.next();
                        next.setPendingIntent(this.O00000o0);
                        next.setPendingIntentAction(this.O00000o);
                    }
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "GeoFenceManager", "createPendingIntent");
            }
        }
        return this.O00000o0;
    }

    public final List<GeoFence> getAllGeoFence() {
        try {
            if (this.O0000O0o == null) {
                this.O0000O0o = new ArrayList<>();
            }
            return (ArrayList) this.O0000O0o.clone();
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    public final boolean isPause() {
        return this.O0000ooo;
    }

    public final void pauseGeoFence() {
        try {
            O00000oo();
            this.O0000ooo = true;
            O000000o(13, null, 0);
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceManager", "pauseGeoFence");
        }
    }

    public final void removeGeoFence() {
        try {
            this.O0000o0O = false;
            O000000o(10, null, 0);
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceManager", "removeGeoFence");
        }
    }

    public final boolean removeGeoFence(GeoFence geoFence) {
        try {
            if (this.O0000O0o != null) {
                if (!this.O0000O0o.isEmpty()) {
                    if (!this.O0000O0o.contains(geoFence)) {
                        return false;
                    }
                    if (this.O0000O0o.size() == 1) {
                        this.O0000o0O = false;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("fc", geoFence);
                    O000000o(11, bundle, 0);
                    return true;
                }
            }
            this.O0000o0O = false;
            O000000o(10, null, 0);
            return true;
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceManager", "removeGeoFence(GeoFence)");
            return false;
        }
    }

    public final void resumeGeoFence() {
        try {
            O00000oo();
            if (this.O0000ooo) {
                this.O0000ooo = false;
                O00000Oo();
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceManager", "resumeGeoFence");
        }
    }

    public final void setActivateAction(int i) {
        try {
            O00000oo();
            if (i > 7 || i <= 0) {
                i = 1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("activatesAction", i);
            O000000o(9, bundle, 0);
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceManager", "setActivateAction");
        }
    }

    public final void setGeoFenceAble(String str, boolean z) {
        try {
            O00000oo();
            Bundle bundle = new Bundle();
            bundle.putString("fid", str);
            bundle.putBoolean("ab", z);
            O000000o(12, bundle, 0);
        } catch (Throwable th) {
            bvz.O000000o(th, "GeoFenceManager", "setGeoFenceAble");
        }
    }

    public final void setGeoFenceListener(GeoFenceListener geoFenceListener) {
        try {
            this.O00000oO = geoFenceListener;
        } catch (Throwable unused) {
        }
    }

    class O000000o extends Handler {
        public O000000o(Looper looper) {
            super(looper);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.loc.j.O000000o(android.os.Bundle, boolean):com.amap.api.fence.GeoFence
         arg types: [android.os.Bundle, int]
         candidates:
          com.loc.j.O000000o(com.amap.api.location.DPoint, java.util.List<com.amap.api.location.DPoint>):float
          com.loc.j.O000000o(com.amap.api.fence.GeoFence, int):boolean
          com.loc.j.O000000o(com.amap.api.location.AMapLocation, com.amap.api.fence.GeoFence):boolean
          com.loc.j.O000000o(int, android.os.Bundle):void
          com.loc.j.O000000o(android.os.Bundle, boolean):com.amap.api.fence.GeoFence */
        public final void handleMessage(Message message) {
            String str;
            String str2;
            try {
                int i = 1;
                switch (message.what) {
                    case 0:
                        j jVar = j.this;
                        Bundle data = message.getData();
                        try {
                            ArrayList arrayList = new ArrayList();
                            if (data == null || data.isEmpty()) {
                                str = "";
                            } else {
                                DPoint dPoint = (DPoint) data.getParcelable("centerPoint");
                                str = data.getString("customId");
                                if (dPoint != null) {
                                    if (dPoint.getLatitude() <= 90.0d && dPoint.getLatitude() >= -90.0d && dPoint.getLongitude() <= 180.0d) {
                                        if (dPoint.getLongitude() >= -180.0d) {
                                            GeoFence O000000o2 = jVar.O000000o(data, false);
                                            i = jVar.O000000o(O000000o2);
                                            if (i == 0) {
                                                arrayList.add(O000000o2);
                                            }
                                        }
                                    }
                                    j.O000000o("添加围栏失败", 1, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                                }
                            }
                            Bundle bundle = new Bundle();
                            bundle.putInt("errorCode", i);
                            bundle.putParcelableArrayList("resultList", arrayList);
                            bundle.putString("customId", str);
                            jVar.O00000Oo(1000, bundle);
                            return;
                        } catch (Throwable th) {
                            bvz.O000000o(th, "GeoFenceManager", "doAddGeoFenceRound");
                            return;
                        }
                    case 1:
                        j jVar2 = j.this;
                        Bundle data2 = message.getData();
                        try {
                            ArrayList arrayList2 = new ArrayList();
                            if (data2 == null || data2.isEmpty()) {
                                str2 = "";
                            } else {
                                ArrayList parcelableArrayList = data2.getParcelableArrayList("pointList");
                                str2 = data2.getString("customId");
                                if (parcelableArrayList != null) {
                                    if (parcelableArrayList.size() > 2) {
                                        GeoFence O000000o3 = jVar2.O000000o(data2, true);
                                        i = jVar2.O000000o(O000000o3);
                                        if (i == 0) {
                                            arrayList2.add(O000000o3);
                                        }
                                    }
                                }
                            }
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("customId", str2);
                            bundle2.putInt("errorCode", i);
                            bundle2.putParcelableArrayList("resultList", arrayList2);
                            jVar2.O00000Oo(1000, bundle2);
                            return;
                        } catch (Throwable th2) {
                            bvz.O000000o(th2, "GeoFenceManager", "doAddGeoFencePolygon");
                            return;
                        }
                    case 2:
                        j.this.O000000o(1, message.getData());
                        return;
                    case 3:
                        j.this.O000000o(2, message.getData());
                        return;
                    case 4:
                        j.this.O000000o(3, message.getData());
                        return;
                    case 5:
                        j.this.O00000o();
                        return;
                    case 6:
                        j.this.O000000o(j.this.O0000oO);
                        return;
                    case 7:
                        j jVar3 = j.this;
                        try {
                            if (jVar3.O0000oO0 != null) {
                                jVar3.O00000o0();
                                jVar3.O0000oOo.setOnceLocation(true);
                                jVar3.O0000oO0.setLocationOption(jVar3.O0000oOo);
                                jVar3.O0000oO0.startLocation();
                                return;
                            }
                            return;
                        } catch (Throwable th3) {
                            bvz.O000000o(th3, "GeoFenceManager", "doStartOnceLocation");
                            return;
                        }
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        j jVar4 = j.this;
                        Bundle data3 = message.getData();
                        if (jVar4.O0000oO0 != null) {
                            long j = 2000;
                            if (data3 != null && !data3.isEmpty()) {
                                j = data3.getLong("interval", 2000);
                            }
                            jVar4.O0000oOo.setOnceLocation(false);
                            jVar4.O0000oOo.setInterval(j);
                            jVar4.O0000oO0.setLocationOption(jVar4.O0000oOo);
                            if (!jVar4.O0000o00) {
                                jVar4.O0000oO0.stopLocation();
                                jVar4.O0000oO0.startLocation();
                                jVar4.O0000o00 = true;
                                return;
                            }
                            return;
                        }
                        return;
                    case 9:
                        j.this.O000000o(message.getData());
                        return;
                    case 10:
                        j.this.O000000o();
                        return;
                    case 11:
                        j jVar5 = j.this;
                        Bundle data4 = message.getData();
                        try {
                            if (jVar5.O0000O0o != null) {
                                GeoFence geoFence = (GeoFence) data4.getParcelable("fc");
                                if (jVar5.O0000O0o.contains(geoFence)) {
                                    jVar5.O0000O0o.remove(geoFence);
                                }
                                if (jVar5.O0000O0o.size() <= 0) {
                                    jVar5.O000000o();
                                    return;
                                } else {
                                    jVar5.O00000Oo();
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable unused) {
                            return;
                        }
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        j.this.O00000Oo(message.getData());
                        return;
                    case 13:
                        j.this.O00000oO();
                        return;
                    default:
                        return;
                }
            } catch (Throwable unused2) {
            }
        }
    }
}
