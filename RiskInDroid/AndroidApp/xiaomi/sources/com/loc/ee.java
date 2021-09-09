package com.loc;

import _m_j.bvl;
import _m_j.bvm;
import _m_j.bvz;
import _m_j.bwd;
import _m_j.bwi;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.HandlerThread;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
public final class ee {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f4531O000000o = 0;
    public ArrayList<bvm> O00000Oo = new ArrayList<>();
    public ArrayList<bvm> O00000o = new ArrayList<>();
    public String O00000o0 = null;
    public int O00000oO = -113;
    public TelephonyManager O00000oo = null;
    public bvl O0000O0o = null;
    public Object O0000OOo;
    CellLocation O0000Oo;
    long O0000Oo0 = 0;
    public long O0000OoO = 0;
    boolean O0000Ooo = false;
    public HandlerThread O0000o = null;
    public String O0000o0 = null;
    public PhoneStateListener O0000o00 = null;
    boolean O0000o0O = false;
    StringBuilder O0000o0o = null;
    public Object O0000oO = new Object();
    public boolean O0000oO0 = false;
    private Context O0000oOO;
    private int O0000oOo = 0;

    class O000000o extends HandlerThread {
        public O000000o(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:3|4|(6:6|(1:8)(1:12)|9|10|13|(2:15|16)(1:17))|18|19) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0045 */
        public final void onLooperPrepared() {
            try {
                super.onLooperPrepared();
                synchronized (ee.this.O0000oO) {
                    if (!ee.this.O0000oO0) {
                        ee eeVar = ee.this;
                        eeVar.O0000o00 = new PhoneStateListener() {
                            /* class com.loc.ee.AnonymousClass1 */

                            public final void onCellLocationChanged(CellLocation cellLocation) {
                                try {
                                    if (ee.this.O000000o(cellLocation)) {
                                        ee.this.O0000Oo = cellLocation;
                                        ee.this.O0000Ooo = true;
                                        long unused = ee.this.O0000OoO = bwi.O00000o0();
                                    }
                                } catch (Throwable unused2) {
                                }
                            }

                            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                             method: com.loc.ee.O000000o(boolean, boolean):void
                             arg types: [int, int]
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
                            public final void onServiceStateChanged(ServiceState serviceState) {
                                try {
                                    int state = serviceState.getState();
                                    if (state == 0) {
                                        ee.this.O000000o(false, false);
                                    } else if (state == 1) {
                                        ee.this.O00000Oo();
                                    }
                                } catch (Throwable unused) {
                                }
                            }

                            public final void onSignalStrengthChanged(int i) {
                                int i2 = -113;
                                try {
                                    int i3 = ee.this.f4531O000000o;
                                    if (i3 == 1 || i3 == 2) {
                                        i2 = bwi.O000000o(i);
                                    }
                                    ee.O000000o(ee.this, i2);
                                } catch (Throwable unused) {
                                }
                            }

                            public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
                                if (signalStrength != null) {
                                    int i = -113;
                                    try {
                                        int i2 = ee.this.f4531O000000o;
                                        if (i2 == 1) {
                                            i = bwi.O000000o(signalStrength.getGsmSignalStrength());
                                        } else if (i2 == 2) {
                                            i = signalStrength.getCdmaDbm();
                                        }
                                        ee.O000000o(ee.this, i);
                                    } catch (Throwable unused) {
                                    }
                                }
                            }
                        };
                        int i = 0;
                        try {
                            i = bwd.O00000Oo("android.telephony.PhoneStateListener", bwi.O00000o() < 7 ? "LISTEN_SIGNAL_STRENGTH" : "LISTEN_SIGNAL_STRENGTHS");
                        } catch (Throwable unused) {
                        }
                        if (i == 0) {
                            eeVar.O00000oo.listen(eeVar.O0000o00, 16);
                        } else {
                            eeVar.O00000oo.listen(eeVar.O0000o00, 16 | i);
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
            r3.f4533O000000o.O00000oo.listen(r3.f4533O000000o.O0000o00, 0);
            r3.f4533O000000o.O0000o00 = null;
            quit();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0004 */
        public final void run() {
            super.run();
        }
    }

    public ee(Context context) {
        this.O0000oOO = context;
        if (this.O00000oo == null) {
            this.O00000oo = (TelephonyManager) bwi.O000000o(this.O0000oOO, "phone");
        }
        TelephonyManager telephonyManager = this.O00000oo;
        if (telephonyManager != null) {
            try {
                this.f4531O000000o = O00000o0(telephonyManager.getCellLocation());
            } catch (SecurityException e) {
                this.O0000o0 = e.getMessage();
            } catch (Throwable th) {
                this.O0000o0 = null;
                bvz.O000000o(th, "CgiManager", "CgiManager");
                this.f4531O000000o = 0;
            }
            try {
                this.O0000oOo = O0000Oo0();
                int i = this.O0000oOo;
                this.O0000OOo = i != 1 ? i != 2 ? bwi.O000000o(this.O0000oOO, "phone2") : bwi.O000000o(this.O0000oOO, "phone2") : bwi.O000000o(this.O0000oOO, "phone_msim");
            } catch (Throwable unused) {
            }
            if (this.O0000o == null) {
                this.O0000o = new O000000o("listenerPhoneStateThread");
                this.O0000o.start();
            }
        }
        this.O0000O0o = new bvl();
    }

    private static bvm O000000o(int i, boolean z, int i2, int i3, int i4, int i5, int i6) {
        bvm bvm = new bvm(i, z);
        bvm.f13313O000000o = i2;
        bvm.O00000Oo = i3;
        bvm.O00000o0 = i4;
        bvm.O00000o = i5;
        bvm.O0000Oo = i6;
        return bvm;
    }

    @SuppressLint({"NewApi"})
    private bvm O000000o(CellInfoCdma cellInfoCdma, boolean z) {
        int i;
        int i2;
        int i3;
        CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
        String[] O000000o2 = bwi.O000000o(this.O00000oo);
        try {
            i3 = Integer.parseInt(O000000o2[0]);
            try {
                i = Integer.parseInt(O000000o2[1]);
                i2 = i3;
            } catch (Throwable unused) {
                i2 = i3;
                i = 0;
                bvm O000000o3 = O000000o(2, z, i2, i, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                O000000o3.O0000O0o = cellIdentity.getSystemId();
                O000000o3.O0000OOo = cellIdentity.getNetworkId();
                O000000o3.O0000Oo0 = cellIdentity.getBasestationId();
                O000000o3.O00000oO = cellIdentity.getLatitude();
                O000000o3.O00000oo = cellIdentity.getLongitude();
                return O000000o3;
            }
        } catch (Throwable unused2) {
            i3 = 0;
            i2 = i3;
            i = 0;
            bvm O000000o32 = O000000o(2, z, i2, i, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
            O000000o32.O0000O0o = cellIdentity.getSystemId();
            O000000o32.O0000OOo = cellIdentity.getNetworkId();
            O000000o32.O0000Oo0 = cellIdentity.getBasestationId();
            O000000o32.O00000oO = cellIdentity.getLatitude();
            O000000o32.O00000oo = cellIdentity.getLongitude();
            return O000000o32;
        }
        bvm O000000o322 = O000000o(2, z, i2, i, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
        O000000o322.O0000O0o = cellIdentity.getSystemId();
        O000000o322.O0000OOo = cellIdentity.getNetworkId();
        O000000o322.O0000Oo0 = cellIdentity.getBasestationId();
        O000000o322.O00000oO = cellIdentity.getLatitude();
        O000000o322.O00000oo = cellIdentity.getLongitude();
        return O000000o322;
    }

    @SuppressLint({"NewApi"})
    private static bvm O000000o(CellInfoGsm cellInfoGsm, boolean z) {
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        return O000000o(1, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
    }

    @SuppressLint({"NewApi"})
    private static bvm O000000o(CellInfoLte cellInfoLte, boolean z) {
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        bvm O000000o2 = O000000o(3, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
        O000000o2.O0000o0O = cellIdentity.getPci();
        return O000000o2;
    }

    @SuppressLint({"NewApi"})
    private static bvm O000000o(CellInfoWcdma cellInfoWcdma, boolean z) {
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        bvm O000000o2 = O000000o(4, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
        O000000o2.O0000o0O = cellIdentity.getPsc();
        return O000000o2;
    }

    private static bvm O000000o(NeighboringCellInfo neighboringCellInfo, String[] strArr) {
        try {
            bvm bvm = new bvm(1, false);
            bvm.f13313O000000o = Integer.parseInt(strArr[0]);
            bvm.O00000Oo = Integer.parseInt(strArr[1]);
            bvm.O00000o0 = bwd.O00000Oo(neighboringCellInfo, "getLac", new Object[0]);
            bvm.O00000o = neighboringCellInfo.getCid();
            bvm.O0000Oo = bwi.O000000o(neighboringCellInfo.getRssi());
            return bvm;
        } catch (Throwable th) {
            bvz.O000000o(th, "CgiManager", "getGsm");
            return null;
        }
    }

    private CellLocation O000000o(Object obj, String str, Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Object O000000o2 = bwd.O000000o(obj, str, objArr);
            CellLocation cellLocation = O000000o2 != null ? (CellLocation) O000000o2 : null;
            if (O00000Oo(cellLocation)) {
                return cellLocation;
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0079, code lost:
        r11 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ac A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ad A[RETURN] */
    @SuppressLint({"NewApi"})
    private CellLocation O000000o(List<CellInfo> list) {
        bvm bvm;
        CdmaCellLocation cdmaCellLocation;
        GsmCellLocation gsmCellLocation;
        GsmCellLocation gsmCellLocation2 = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        int i = 0;
        while (true) {
            if (i >= list.size()) {
                break;
            }
            CellInfo cellInfo = list.get(i);
            if (cellInfo != null) {
                try {
                    boolean isRegistered = cellInfo.isRegistered();
                    if (!(cellInfo instanceof CellInfoCdma)) {
                        if (!(cellInfo instanceof CellInfoGsm)) {
                            if (!(cellInfo instanceof CellInfoWcdma)) {
                                if (!(cellInfo instanceof CellInfoLte)) {
                                    break;
                                }
                                CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                                if (O000000o(cellInfoLte.getCellIdentity())) {
                                    bvm = O000000o(cellInfoLte, isRegistered);
                                    break;
                                }
                            } else {
                                CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                                if (O000000o(cellInfoWcdma.getCellIdentity())) {
                                    bvm = O000000o(cellInfoWcdma, isRegistered);
                                    break;
                                }
                            }
                        } else {
                            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                            if (O000000o(cellInfoGsm.getCellIdentity())) {
                                bvm = O000000o(cellInfoGsm, isRegistered);
                                break;
                            }
                        }
                    } else {
                        CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                        if (O000000o(cellInfoCdma.getCellIdentity())) {
                            bvm = O000000o(cellInfoCdma, isRegistered);
                            break;
                        }
                    }
                } catch (Throwable unused) {
                    continue;
                }
            }
            i++;
        }
        if (bvm != null) {
            try {
                if (bvm.O0000OoO == 2) {
                    cdmaCellLocation = new CdmaCellLocation();
                    try {
                        cdmaCellLocation.setCellLocationData(bvm.O0000Oo0, bvm.O00000oO, bvm.O00000oo, bvm.O0000O0o, bvm.O0000OOo);
                    } catch (Throwable unused2) {
                    }
                    return cdmaCellLocation != null ? gsmCellLocation2 : cdmaCellLocation;
                }
                gsmCellLocation = new GsmCellLocation();
                try {
                    gsmCellLocation.setLacAndCid(bvm.O00000o0, bvm.O00000o);
                } catch (Throwable unused3) {
                }
            } catch (Throwable unused4) {
                cdmaCellLocation = null;
            }
        } else {
            gsmCellLocation = null;
        }
        GsmCellLocation gsmCellLocation3 = gsmCellLocation;
        cdmaCellLocation = null;
        gsmCellLocation2 = gsmCellLocation3;
        if (cdmaCellLocation != null) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    private void O000000o(CellLocation cellLocation, String[] strArr, boolean z) {
        bvm O000000o2;
        if (cellLocation != null && this.O00000oo != null) {
            this.O00000Oo.clear();
            if (O00000Oo(cellLocation)) {
                this.f4531O000000o = 1;
                List<NeighboringCellInfo> list = null;
                ArrayList<bvm> arrayList = this.O00000Oo;
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                bvm bvm = new bvm(1, true);
                bvm.f13313O000000o = bwi.O0000O0o(strArr[0]);
                bvm.O00000Oo = bwi.O0000O0o(strArr[1]);
                bvm.O00000o0 = gsmCellLocation.getLac();
                bvm.O00000o = gsmCellLocation.getCid();
                bvm.O0000Oo = this.O00000oO;
                arrayList.add(bvm);
                if (!z) {
                    if (Build.VERSION.SDK_INT <= 28) {
                        list = bwd.O000000o(this.O00000oo, "getNeighboringCellInfo", new Object[0]);
                    }
                    if (list != null && !list.isEmpty()) {
                        for (NeighboringCellInfo neighboringCellInfo : list) {
                            if (neighboringCellInfo != null && O000000o(neighboringCellInfo.getLac(), neighboringCellInfo.getCid()) && (O000000o2 = O000000o(neighboringCellInfo, strArr)) != null && !this.O00000Oo.contains(O000000o2)) {
                                this.O00000Oo.add(O000000o2);
                            }
                        }
                    }
                }
            }
        }
    }

    static /* synthetic */ void O000000o(ee eeVar, int i) {
        ArrayList<bvm> arrayList;
        if (i == -113) {
            eeVar.O00000oO = -113;
            return;
        }
        eeVar.O00000oO = i;
        int i2 = eeVar.f4531O000000o;
        if ((i2 == 1 || i2 == 2) && (arrayList = eeVar.O00000Oo) != null && !arrayList.isEmpty()) {
            try {
                eeVar.O00000Oo.get(0).O0000Oo = eeVar.O00000oO;
            } catch (Throwable unused) {
            }
        }
    }

    private static boolean O000000o(int i) {
        return (i == -1 || i == 0 || i > 65535) ? false : true;
    }

    private static boolean O000000o(int i, int i2) {
        return (i == -1 || i == 0 || i > 65535 || i2 == -1 || i2 == 0 || i2 == 65535 || i2 >= 268435455) ? false : true;
    }

    @SuppressLint({"NewApi"})
    private static boolean O000000o(CellIdentityCdma cellIdentityCdma) {
        return cellIdentityCdma != null && cellIdentityCdma.getSystemId() > 0 && cellIdentityCdma.getNetworkId() >= 0 && cellIdentityCdma.getBasestationId() >= 0;
    }

    @SuppressLint({"NewApi"})
    private static boolean O000000o(CellIdentityGsm cellIdentityGsm) {
        return cellIdentityGsm != null && O000000o(cellIdentityGsm.getLac()) && O00000Oo(cellIdentityGsm.getCid());
    }

    @SuppressLint({"NewApi"})
    private static boolean O000000o(CellIdentityLte cellIdentityLte) {
        return cellIdentityLte != null && O000000o(cellIdentityLte.getTac()) && O00000Oo(cellIdentityLte.getCi());
    }

    @SuppressLint({"NewApi"})
    private static boolean O000000o(CellIdentityWcdma cellIdentityWcdma) {
        return cellIdentityWcdma != null && O000000o(cellIdentityWcdma.getLac()) && O00000Oo(cellIdentityWcdma.getCid());
    }

    private static boolean O00000Oo(int i) {
        return (i == -1 || i == 0 || i == 65535 || i >= 268435455) ? false : true;
    }

    private boolean O00000Oo(CellLocation cellLocation) {
        boolean O000000o2 = O000000o(cellLocation);
        if (!O000000o2) {
            this.f4531O000000o = 0;
        }
        return O000000o2;
    }

    private int O00000o0(CellLocation cellLocation) {
        if (this.O0000o0O || cellLocation == null) {
            return 0;
        }
        if (cellLocation instanceof GsmCellLocation) {
            return 1;
        }
        try {
            Class.forName("android.telephony.cdma.CdmaCellLocation");
            return 2;
        } catch (Throwable th) {
            bvz.O000000o(th, "Utils", "getCellLocT");
            return 0;
        }
    }

    private CellLocation O00000oO() {
        TelephonyManager telephonyManager = this.O00000oo;
        if (telephonyManager != null) {
            try {
                CellLocation cellLocation = telephonyManager.getCellLocation();
                this.O0000o0 = null;
                if (O00000Oo(cellLocation)) {
                    this.O0000Oo = cellLocation;
                    return cellLocation;
                }
            } catch (SecurityException e) {
                this.O0000o0 = e.getMessage();
            } catch (Throwable th) {
                this.O0000o0 = null;
                bvz.O000000o(th, "CgiManager", "getCellLocation");
            }
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    private CellLocation O00000oo() {
        TelephonyManager telephonyManager = this.O00000oo;
        CellLocation cellLocation = null;
        if (telephonyManager == null) {
            return null;
        }
        CellLocation O00000oO2 = O00000oO();
        if (O00000Oo(O00000oO2)) {
            return O00000oO2;
        }
        if (bwi.O00000o() >= 18) {
            try {
                cellLocation = O000000o(telephonyManager.getAllCellInfo());
            } catch (SecurityException e) {
                this.O0000o0 = e.getMessage();
            }
        }
        if (cellLocation != null) {
            return cellLocation;
        }
        CellLocation O000000o2 = O000000o(telephonyManager, "getCellLocationExt", 1);
        if (O000000o2 != null) {
            return O000000o2;
        }
        CellLocation O000000o3 = O000000o(telephonyManager, "getCellLocationGemini", 1);
        if (O000000o3 != null) {
        }
        return O000000o3;
    }

    private CellLocation O0000O0o() {
        Object obj = this.O0000OOo;
        CellLocation cellLocation = null;
        if (obj == null) {
            return null;
        }
        try {
            Class<?> O0000OOo2 = O0000OOo();
            if (O0000OOo2.isInstance(obj)) {
                Object cast = O0000OOo2.cast(obj);
                CellLocation O000000o2 = O000000o(cast, "getCellLocation", new Object[0]);
                if (O000000o2 != null) {
                    return O000000o2;
                }
                CellLocation O000000o3 = O000000o(cast, "getCellLocation", 1);
                if (O000000o3 != null) {
                    return O000000o3;
                }
                CellLocation O000000o4 = O000000o(cast, "getCellLocationGemini", 1);
                if (O000000o4 != null) {
                    return O000000o4;
                }
                cellLocation = O000000o(cast, "getAllCellInfo", 1);
                if (cellLocation != null) {
                    return cellLocation;
                }
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "CgiManager", "getSim2Cgi");
        }
        return cellLocation;
    }

    private Class<?> O0000OOo() {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        int i = this.O0000oOo;
        try {
            return systemClassLoader.loadClass(i != 0 ? i != 1 ? i != 2 ? null : "android.telephony.TelephonyManager2" : "android.telephony.MSimTelephonyManager" : "android.telephony.TelephonyManager");
        } catch (Throwable th) {
            bvz.O000000o(th, "CgiManager", "getSim2TmClass");
            return null;
        }
    }

    private int O0000Oo0() {
        try {
            Class.forName("android.telephony.MSimTelephonyManager");
            this.O0000oOo = 1;
        } catch (Throwable unused) {
        }
        if (this.O0000oOo == 0) {
            try {
                Class.forName("android.telephony.TelephonyManager2");
                this.O0000oOo = 2;
            } catch (Throwable unused2) {
            }
        }
        return this.O0000oOo;
    }

    public final bvm O000000o() {
        if (this.O0000o0O) {
            return null;
        }
        ArrayList<bvm> arrayList = this.O00000Oo;
        if (arrayList.size() > 0) {
            return arrayList.get(0);
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(float, float):float}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(long, long):long} */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x02ae, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x02af, code lost:
        r13.O0000o0 = r14.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x02b5, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00e1, code lost:
        if (r14 == false) goto L_0x00e5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:154:0x0260 */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0260 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0264 A[Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0284 A[Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0288 A[Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x02ae A[ExcHandler: SecurityException (r14v1 'e' java.lang.SecurityException A[CUSTOM_DECLARE]), Splitter:B:69:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x008a A[EDGE_INSN: B:181:0x008a->B:42:0x008a ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f A[Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0049 A[Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0052 A[Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0086 A[Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0094 A[Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a7 }] */
    public final void O000000o(boolean z, boolean z2) {
        boolean z3;
        List<CellInfo> list;
        int size;
        int i;
        bvm O000000o2;
        boolean z4;
        int i2;
        CellLocation O00000oo2;
        try {
            this.O0000o0O = bwi.O000000o(this.O0000oOO);
            if (!this.O0000o0O) {
                if (bwi.O00000o0() - this.O0000Oo0 >= 10000) {
                    z3 = true;
                    if (z3 || this.O00000Oo.isEmpty()) {
                        List<CellInfo> list2 = null;
                        if (!this.O0000o0O && this.O00000oo != null) {
                            O00000oo2 = O00000oo();
                            if (!O00000Oo(O00000oo2)) {
                                O00000oo2 = O0000O0o();
                            }
                            if (!O00000Oo(O00000oo2)) {
                                this.O0000Oo = O00000oo2;
                                this.O0000OoO = bwi.O00000o0();
                            } else if (bwi.O00000o0() - this.O0000OoO > 60000) {
                                this.O0000Oo = null;
                                this.O00000Oo.clear();
                                this.O00000o.clear();
                            }
                        }
                        if (!this.O0000Ooo && this.O0000Oo == null && z2) {
                            i2 = 0;
                            do {
                                try {
                                    Thread.sleep(10);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                i2++;
                                if (this.O0000Oo == null) {
                                    break;
                                }
                            } while (i2 < 50);
                        }
                        this.O0000Ooo = true;
                        if (O00000Oo(this.O0000Oo)) {
                            String[] O000000o3 = bwi.O000000o(this.O00000oo);
                            int O00000o02 = O00000o0(this.O0000Oo);
                            if (O00000o02 == 1) {
                                O000000o(this.O0000Oo, O000000o3, z);
                            } else if (O00000o02 == 2) {
                                CellLocation cellLocation = this.O0000Oo;
                                if (cellLocation != null) {
                                    this.O00000Oo.clear();
                                    if (bwi.O00000o() >= 5) {
                                        try {
                                            if (this.O0000OOo != null) {
                                                try {
                                                    Field declaredField = cellLocation.getClass().getDeclaredField("mGsmCellLoc");
                                                    if (!declaredField.isAccessible()) {
                                                        declaredField.setAccessible(true);
                                                    }
                                                    GsmCellLocation gsmCellLocation = (GsmCellLocation) declaredField.get(cellLocation);
                                                    if (gsmCellLocation != null && O00000Oo(gsmCellLocation)) {
                                                        O000000o(gsmCellLocation, O000000o3, z);
                                                        z4 = true;
                                                    }
                                                } catch (SecurityException e2) {
                                                } catch (Throwable unused) {
                                                }
                                                z4 = false;
                                            }
                                            try {
                                                if (O00000Oo(cellLocation)) {
                                                    this.f4531O000000o = 2;
                                                    bvm bvm = new bvm(2, true);
                                                    bvm.f13313O000000o = Integer.parseInt(O000000o3[0]);
                                                    bvm.O00000Oo = Integer.parseInt(O000000o3[1]);
                                                    bvm.O0000O0o = bwd.O00000Oo(cellLocation, "getSystemId", new Object[0]);
                                                    bvm.O0000OOo = bwd.O00000Oo(cellLocation, "getNetworkId", new Object[0]);
                                                    bvm.O0000Oo0 = bwd.O00000Oo(cellLocation, "getBaseStationId", new Object[0]);
                                                    bvm.O0000Oo = this.O00000oO;
                                                    bvm.O00000oO = bwd.O00000Oo(cellLocation, "getBaseStationLatitude", new Object[0]);
                                                    bvm.O00000oo = bwd.O00000Oo(cellLocation, "getBaseStationLongitude", new Object[0]);
                                                    boolean z5 = bvm.O00000oO == bvm.O00000oo && bvm.O00000oO > 0;
                                                    if (bvm.O00000oO < 0 || bvm.O00000oo < 0 || bvm.O00000oO == Integer.MAX_VALUE || bvm.O00000oo == Integer.MAX_VALUE || z5) {
                                                        bvm.O00000oO = 0;
                                                        bvm.O00000oo = 0;
                                                    }
                                                    if (!this.O00000Oo.contains(bvm)) {
                                                        this.O00000Oo.add(bvm);
                                                    }
                                                }
                                            } catch (SecurityException e22) {
                                            } catch (Throwable unused2) {
                                            }
                                        } catch (SecurityException e222) {
                                        } catch (Throwable th) {
                                            bvz.O000000o(th, "CgiManager", "hdlCdmaLocChange");
                                        }
                                    }
                                }
                            }
                        }
                        if (bwi.O00000o() >= 18 && this.O00000oo != null) {
                            ArrayList<bvm> arrayList = this.O00000o;
                            bvl bvl = this.O0000O0o;
                            list = this.O00000oo.getAllCellInfo();
                            this.O0000o0 = null;
                        }
                        if (this.O00000oo != null) {
                            this.O00000o0 = this.O00000oo.getNetworkOperator();
                            if (!TextUtils.isEmpty(this.O00000o0)) {
                                this.f4531O000000o |= 8;
                            }
                        }
                        this.O0000Oo0 = bwi.O00000o0();
                    }
                    if (this.O0000o0O) {
                        O00000Oo();
                        return;
                    }
                    int i3 = this.f4531O000000o & 3;
                    if (i3 != 1) {
                        if (i3 == 2) {
                            if (this.O00000Oo.isEmpty()) {
                                this.f4531O000000o = 0;
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (this.O00000Oo.isEmpty()) {
                        this.f4531O000000o = 0;
                        return;
                    } else {
                        return;
                    }
                }
            }
            z3 = false;
            List<CellInfo> list22 = null;
            O00000oo2 = O00000oo();
            if (!O00000Oo(O00000oo2)) {
            }
            if (!O00000Oo(O00000oo2)) {
            }
            i2 = 0;
            do {
                Thread.sleep(10);
                i2++;
                if (this.O0000Oo == null) {
                }
            } while (i2 < 50);
            this.O0000Ooo = true;
            if (O00000Oo(this.O0000Oo)) {
            }
            ArrayList<bvm> arrayList2 = this.O00000o;
            bvl bvl2 = this.O0000O0o;
            try {
                list = this.O00000oo.getAllCellInfo();
                try {
                    this.O0000o0 = null;
                } catch (SecurityException e3) {
                    SecurityException securityException = e3;
                    list22 = list;
                    e = securityException;
                } catch (Throwable ) {
                }
            } catch (SecurityException e4) {
                e = e4;
            } catch (Throwable ) {
            }
            if (this.O00000oo != null) {
            }
            this.O0000Oo0 = bwi.O00000o0();
            if (this.O0000o0O) {
            }
            this.O0000o0 = e.getMessage();
            list = list22;
            if (!(list == null || (size = list.size()) == 0)) {
                if (arrayList2 != null) {
                    arrayList2.clear();
                }
                for (i = 0; i < size; i++) {
                    CellInfo cellInfo = (CellInfo) list.get(i);
                    if (cellInfo != null) {
                        boolean isRegistered = cellInfo.isRegistered();
                        if (cellInfo instanceof CellInfoCdma) {
                            CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                            if (O000000o(cellInfoCdma.getCellIdentity())) {
                                O000000o2 = O000000o(cellInfoCdma, isRegistered);
                                O000000o2.O0000Ooo = (short) ((int) Math.min(65535L, bvl2.O000000o(O000000o2)));
                            }
                        } else if (cellInfo instanceof CellInfoGsm) {
                            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                            if (O000000o(cellInfoGsm.getCellIdentity())) {
                                O000000o2 = O000000o(cellInfoGsm, isRegistered);
                                O000000o2.O0000Ooo = (short) ((int) Math.min(65535L, bvl2.O000000o(O000000o2)));
                            }
                        } else if (cellInfo instanceof CellInfoWcdma) {
                            CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                            if (O000000o(cellInfoWcdma.getCellIdentity())) {
                                O000000o2 = O000000o(cellInfoWcdma, isRegistered);
                                O000000o2.O0000Ooo = (short) ((int) Math.min(65535L, bvl2.O000000o(O000000o2)));
                            }
                        } else if (cellInfo instanceof CellInfoLte) {
                            CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                            if (O000000o(cellInfoLte.getCellIdentity())) {
                                O000000o2 = O000000o(cellInfoLte, isRegistered);
                                O000000o2.O0000Ooo = (short) ((int) Math.min(65535L, bvl2.O000000o(O000000o2)));
                            }
                        }
                        arrayList2.add(O000000o2);
                    }
                }
            }
            if (arrayList2 != null) {
                if (arrayList2.size() > 0) {
                    this.f4531O000000o |= 4;
                    bvl2.O000000o(arrayList2);
                }
            }
            if (this.O00000oo != null) {
            }
            this.O0000Oo0 = bwi.O00000o0();
            if (this.O0000o0O) {
            }
        } catch (SecurityException e2222) {
        } catch (Throwable th2) {
            bvz.O000000o(th2, "CgiManager", "refresh");
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(CellLocation cellLocation) {
        String str;
        if (cellLocation == null) {
            return false;
        }
        int O00000o02 = O00000o0(cellLocation);
        if (O00000o02 == 1) {
            try {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                return O000000o(gsmCellLocation.getLac(), gsmCellLocation.getCid());
            } catch (Throwable th) {
                th = th;
                str = "cgiUseful Cgi.I_GSM_T";
                bvz.O000000o(th, "CgiManager", str);
                return true;
            }
        } else if (O00000o02 != 2) {
            return true;
        } else {
            try {
                return bwd.O00000Oo(cellLocation, "getSystemId", new Object[0]) > 0 && bwd.O00000Oo(cellLocation, "getNetworkId", new Object[0]) >= 0 && bwd.O00000Oo(cellLocation, "getBaseStationId", new Object[0]) >= 0;
            } catch (Throwable th2) {
                th = th2;
                str = "cgiUseful Cgi.I_CDMA_T";
                bvz.O000000o(th, "CgiManager", str);
                return true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        this.O0000o0 = null;
        this.O0000Oo = null;
        this.f4531O000000o = 0;
        this.O00000Oo.clear();
        this.O00000o.clear();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001f */
    public final boolean O00000o() {
        if (this.O00000oo != null && (!TextUtils.isEmpty(this.O00000oo.getSimOperator()) || !TextUtils.isEmpty(this.O00000oo.getSimCountryIso()))) {
            return true;
        }
        try {
            int O000000o2 = bwi.O000000o(bwi.O00000o0(this.O0000oOO));
            return O000000o2 != 0 || O000000o2 == 4 || O000000o2 == 2 || O000000o2 == 5 || O000000o2 == 3;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final String O00000o0() {
        if (this.O0000o0O) {
            O00000Oo();
        }
        StringBuilder sb = this.O0000o0o;
        if (sb == null) {
            this.O0000o0o = new StringBuilder();
        } else {
            sb.delete(0, sb.length());
        }
        if ((this.f4531O000000o & 3) == 1) {
            for (int i = 1; i < this.O00000Oo.size(); i++) {
                StringBuilder sb2 = this.O0000o0o;
                sb2.append("#");
                sb2.append(this.O00000Oo.get(i).O00000Oo);
                StringBuilder sb3 = this.O0000o0o;
                sb3.append("|");
                sb3.append(this.O00000Oo.get(i).O00000o0);
                StringBuilder sb4 = this.O0000o0o;
                sb4.append("|");
                sb4.append(this.O00000Oo.get(i).O00000o);
            }
        }
        if (this.O0000o0o.length() > 0) {
            this.O0000o0o.deleteCharAt(0);
        }
        return this.O0000o0o.toString();
    }
}
