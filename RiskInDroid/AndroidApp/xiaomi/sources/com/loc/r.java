package com.loc;

import _m_j.bsj;
import _m_j.bsk;
import _m_j.bvo;
import _m_j.bvq;
import _m_j.bvr;
import _m_j.bvz;
import _m_j.bwi;
import _m_j.bww;
import _m_j.bwx;
import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import java.util.List;
import org.json.JSONObject;

public final class r {
    public static bvq O00000Oo;
    static bsk O00000oO;
    static long O0000O0o;

    /* renamed from: O000000o  reason: collision with root package name */
    String f4545O000000o = null;
    bvq O00000o = null;
    bvq O00000o0 = null;
    long O00000oo = 0;
    boolean O0000OOo = false;
    private Context O0000Oo0;

    public r(Context context) {
        this.O0000Oo0 = context.getApplicationContext();
    }

    public final void O000000o() {
        if (!this.O0000OOo) {
            try {
                if (this.f4545O000000o == null) {
                    this.f4545O000000o = bvo.O000000o("MD5", bww.O0000oOo(this.O0000Oo0));
                }
                if (O00000oO == null) {
                    O00000oO = new bsk(this.O0000Oo0, bsk.O000000o((Class<? extends bsj>) bvr.class));
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "LastLocationManager", "<init>:DBOperation");
            }
            this.O0000OOo = true;
        }
    }

    public final void O00000o0() {
        try {
            O00000o();
            this.O00000oo = 0;
            this.O0000OOo = false;
            this.O00000o0 = null;
            this.O00000o = null;
        } catch (Throwable th) {
            bvz.O000000o(th, "LastLocationManager", "destroy");
        }
    }

    public final boolean O000000o(AMapLocation aMapLocation, String str) {
        if (this.O0000Oo0 != null && aMapLocation != null && bwi.O000000o(aMapLocation) && aMapLocation.getLocationType() != 2 && !aMapLocation.isMock() && !aMapLocation.isFixLastLocation()) {
            bvq bvq = new bvq();
            bvq.O00000o = aMapLocation;
            if (aMapLocation.getLocationType() == 1) {
                bvq.O00000o0 = null;
            } else {
                bvq.O00000o0 = str;
            }
            try {
                O00000Oo = bvq;
                O0000O0o = bwi.O00000o0();
                this.O00000o0 = bvq;
                if ((this.O00000o == null || bwi.O000000o(this.O00000o.O00000o, bvq.O00000o) > 500.0f) && bwi.O00000o0() - this.O00000oo > DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
                    return true;
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "LastLocationManager", "setLastFix");
            }
        }
        return false;
    }

    public final AMapLocation O00000Oo() {
        O00000oO();
        bvq bvq = O00000Oo;
        if (bvq != null && bwi.O000000o(bvq.O00000o)) {
            return O00000Oo.O00000o;
        }
        return null;
    }

    public final AMapLocation O000000o(AMapLocation aMapLocation, String str, long j) {
        if (aMapLocation == null || aMapLocation.getErrorCode() == 0 || aMapLocation.getLocationType() == 1 || aMapLocation.getErrorCode() == 7) {
            return aMapLocation;
        }
        try {
            O00000oO();
            if (O00000Oo != null) {
                if (O00000Oo.O00000o != null) {
                    boolean z = false;
                    if (TextUtils.isEmpty(str)) {
                        long O00000o02 = bwi.O00000o0() - O00000Oo.O00000Oo;
                        if (O00000o02 >= 0 && O00000o02 <= j) {
                            z = true;
                        }
                        aMapLocation.setTrustedLevel(3);
                    } else {
                        z = bwi.O000000o(O00000Oo.O00000o0, str);
                        aMapLocation.setTrustedLevel(2);
                    }
                    if (!z) {
                        return aMapLocation;
                    }
                    AMapLocation aMapLocation2 = O00000Oo.O00000o;
                    try {
                        aMapLocation2.setLocationType(9);
                        aMapLocation2.setFixLastLocation(true);
                        aMapLocation2.setLocationDetail(aMapLocation.getLocationDetail());
                        return aMapLocation2;
                    } catch (Throwable th) {
                        AMapLocation aMapLocation3 = aMapLocation2;
                        th = th;
                        aMapLocation = aMapLocation3;
                        bvz.O000000o(th, "LastLocationManager", "fixLastLocation");
                        return aMapLocation;
                    }
                }
            }
            return aMapLocation;
        } catch (Throwable th2) {
            th = th2;
            bvz.O000000o(th, "LastLocationManager", "fixLastLocation");
            return aMapLocation;
        }
    }

    public final void O00000o() {
        String str;
        try {
            O000000o();
            if (this.O00000o0 != null && bwi.O000000o(this.O00000o0.O00000o) && O00000oO != null && this.O00000o0 != this.O00000o) {
                if (this.O00000o0.O00000Oo == 0) {
                    String str2 = this.O00000o0.O00000o.toStr();
                    String str3 = this.O00000o0.O00000o0;
                    this.O00000o = this.O00000o0;
                    String str4 = null;
                    if (!TextUtils.isEmpty(str2)) {
                        str = bwx.O00000Oo(bvo.O00000o0(str2.getBytes("UTF-8"), this.f4545O000000o));
                        if (!TextUtils.isEmpty(str3)) {
                            str4 = bwx.O00000Oo(bvo.O00000o0(str3.getBytes("UTF-8"), this.f4545O000000o));
                        }
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        bvq bvq = new bvq();
                        bvq.f13318O000000o = str;
                        bvq.O00000Oo = bwi.O00000o0();
                        bvq.O00000o0 = str4;
                        O00000oO.O000000o(bvq, "_id=1");
                        this.O00000oo = bwi.O00000o0();
                        if (O00000Oo != null) {
                            O00000Oo.O00000Oo = bwi.O00000o0();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "LastLocationManager", "saveLastFix");
        }
    }

    private void O00000oO() {
        if (O00000Oo == null || bwi.O00000o0() - O0000O0o > 180000) {
            bvq O00000oo2 = O00000oo();
            O0000O0o = bwi.O00000o0();
            if (O00000oo2 != null && bwi.O000000o(O00000oo2.O00000o)) {
                O00000Oo = O00000oo2;
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bsk.O000000o(java.lang.String, java.lang.Class, boolean):java.util.List<T>
     arg types: [java.lang.String, java.lang.Class, int]
     candidates:
      _m_j.bsk.O000000o(android.database.Cursor, java.lang.Class, _m_j.bsl):T
      _m_j.bsk.O000000o(java.lang.String, java.lang.Class, boolean):java.util.List<T> */
    private bvq O00000oo() {
        bvq bvq;
        Throwable th;
        String str;
        byte[] O00000o2;
        byte[] O00000o3;
        String str2 = null;
        if (this.O0000Oo0 == null) {
            return null;
        }
        O000000o();
        try {
            if (O00000oO == null) {
                return null;
            }
            List O000000o2 = O00000oO.O000000o("_id=1", bvq.class, false);
            if (O000000o2.size() > 0) {
                bvq = (bvq) O000000o2.get(0);
                try {
                    byte[] O00000Oo2 = bwx.O00000Oo(bvq.f13318O000000o);
                    if (O00000Oo2 != null) {
                        if (O00000Oo2.length > 0 && (O00000o3 = bvo.O00000o(O00000Oo2, this.f4545O000000o)) != null && O00000o3.length > 0) {
                            str = new String(O00000o3, "UTF-8");
                            byte[] O00000Oo3 = bwx.O00000Oo(bvq.O00000o0);
                            if (O00000Oo3 != null && O00000Oo3.length > 0 && (O00000o2 = bvo.O00000o(O00000Oo3, this.f4545O000000o)) != null && O00000o2.length > 0) {
                                str2 = new String(O00000o2, "UTF-8");
                            }
                            bvq.O00000o0 = str2;
                            str2 = str;
                        }
                    }
                    str = null;
                    byte[] O00000Oo32 = bwx.O00000Oo(bvq.O00000o0);
                    str2 = new String(O00000o2, "UTF-8");
                    bvq.O00000o0 = str2;
                    str2 = str;
                } catch (Throwable th2) {
                    th = th2;
                    bvz.O000000o(th, "LastLocationManager", "readLastFix");
                    return bvq;
                }
            } else {
                bvq = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                AMapLocation aMapLocation = new AMapLocation("");
                bvz.O000000o(aMapLocation, new JSONObject(str2));
                if (bwi.O00000Oo(aMapLocation)) {
                    bvq.O00000o = aMapLocation;
                }
            }
            return bvq;
        } catch (Throwable th3) {
            th = th3;
            bvq = null;
            bvz.O000000o(th, "LastLocationManager", "readLastFix");
            return bvq;
        }
    }
}
