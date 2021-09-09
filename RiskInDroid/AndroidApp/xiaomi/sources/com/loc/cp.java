package com.loc;

import _m_j.btx;
import _m_j.bua;
import _m_j.bub;
import _m_j.bwt;
import _m_j.bww;
import _m_j.op;
import _m_j.oq;
import _m_j.or;
import _m_j.os;
import _m_j.ou;
import _m_j.ox;
import _m_j.pg;
import _m_j.ph;
import _m_j.pk;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONObject;

public final class cp {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f4522O000000o = null;
    public co O00000Oo = null;

    public cp(Context context) {
        this.f4522O000000o = context;
        try {
            this.O00000Oo = new co(this.f4522O000000o);
        } catch (Throwable unused) {
        }
    }

    public static void O000000o(String str, ScanResult[] scanResultArr) {
        try {
            ph.O000000o().O000000o(O00000Oo(str, scanResultArr));
        } catch (Throwable th) {
            bua.O000000o(th, "OfflineLocManager", "trainingFps");
        }
    }

    public static void O000000o(String str, ScanResult[] scanResultArr, double d, double d2) {
        try {
            os O00000Oo2 = O00000Oo(str, scanResultArr);
            op opVar = new op();
            opVar.O00000Oo(d);
            opVar.O000000o(d2);
            ph.O000000o().O000000o(O00000Oo2, opVar);
        } catch (Throwable th) {
            bua.O000000o(th, "OfflineLocManager", "correctLocation");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00eb A[SYNTHETIC, Splitter:B:39:0x00eb] */
    private static os O00000Oo(String str, ScanResult[] scanResultArr) {
        int i;
        ScanResult[] scanResultArr2;
        String str2;
        JSONObject optJSONObject;
        or orVar = new or();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                try {
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("mainCgi");
                    if (optJSONObject2 != null) {
                        str2 = "type";
                        try {
                            oq oqVar = new oq(optJSONObject2.optInt("type", 0), optJSONObject2.optBoolean("registered", false));
                            oqVar.O00000Oo = optJSONObject2.optInt("mcc");
                            oqVar.O00000o0 = optJSONObject2.optInt("mnc");
                            oqVar.O00000o = optJSONObject2.optInt("lac");
                            oqVar.O00000oO = optJSONObject2.optInt("cid");
                            oqVar.O00000oo = optJSONObject2.optInt("sid");
                            oqVar.O0000O0o = optJSONObject2.optInt("nid");
                            oqVar.O0000OOo = optJSONObject2.optInt("bid");
                            oqVar.O0000Oo0 = optJSONObject2.optInt("sig");
                            orVar.O00000o = oqVar;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } else {
                        str2 = "type";
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str2 = "type";
                    bua.O000000o(th, "OfflineLocManager", "buildFPS_1_1");
                    optJSONObject = jSONObject.optJSONObject("newCgi");
                    if (optJSONObject != null) {
                    }
                    i = 0;
                    ou ouVar = new ou();
                    scanResultArr2 = scanResultArr;
                    if (scanResultArr2 != null) {
                    }
                    os osVar = new os();
                    osVar.f2373O000000o = orVar;
                    osVar.O00000Oo = ouVar;
                    return osVar;
                }
                try {
                    optJSONObject = jSONObject.optJSONObject("newCgi");
                    if (optJSONObject != null) {
                        i = 0;
                        try {
                            oq oqVar2 = new oq(optJSONObject.optInt(str2, 0), optJSONObject.optBoolean("registered", false));
                            oqVar2.O00000Oo = optJSONObject.optInt("mcc");
                            oqVar2.O00000o0 = optJSONObject.optInt("mnc");
                            oqVar2.O00000o = optJSONObject.optInt("lac");
                            oqVar2.O00000oO = optJSONObject.optInt("cid");
                            oqVar2.O00000oo = optJSONObject.optInt("sid");
                            oqVar2.O0000O0o = optJSONObject.optInt("nid");
                            oqVar2.O0000OOo = optJSONObject.optInt("bid");
                            oqVar2.O0000Oo0 = optJSONObject.optInt("sig");
                            orVar.O00000oo = oqVar2;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        ou ouVar2 = new ou();
                        scanResultArr2 = scanResultArr;
                        if (scanResultArr2 != null) {
                            try {
                                ArrayList arrayList = new ArrayList();
                                int length = scanResultArr2.length;
                                while (i < length) {
                                    arrayList.add(scanResultArr2[i]);
                                    i++;
                                }
                                ouVar2.O000000o(ou.O00000Oo(arrayList));
                            } catch (Throwable th4) {
                                bua.O000000o(th4, "OfflineLocManager", "buildFPS_2");
                            }
                        }
                        os osVar2 = new os();
                        osVar2.f2373O000000o = orVar;
                        osVar2.O00000Oo = ouVar2;
                        return osVar2;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    i = 0;
                    try {
                        bua.O000000o(th, "OfflineLocManager", "buildFPS_1_2");
                    } catch (Throwable th6) {
                        th = th6;
                    }
                    ou ouVar22 = new ou();
                    scanResultArr2 = scanResultArr;
                    if (scanResultArr2 != null) {
                    }
                    os osVar22 = new os();
                    osVar22.f2373O000000o = orVar;
                    osVar22.O00000Oo = ouVar22;
                    return osVar22;
                }
            } catch (Throwable th7) {
                th = th7;
                i = 0;
                bua.O000000o(th, "OfflineLocManager", "buildFPS_1");
                ou ouVar222 = new ou();
                scanResultArr2 = scanResultArr;
                if (scanResultArr2 != null) {
                }
                os osVar222 = new os();
                osVar222.f2373O000000o = orVar;
                osVar222.O00000Oo = ouVar222;
                return osVar222;
            }
        }
        i = 0;
        ou ouVar2222 = new ou();
        scanResultArr2 = scanResultArr;
        if (scanResultArr2 != null) {
        }
        os osVar2222 = new os();
        osVar2222.f2373O000000o = orVar;
        osVar2222.O00000Oo = ouVar2222;
        return osVar2222;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ph.O000000o(_m_j.os, boolean):_m_j.op
     arg types: [_m_j.os, int]
     candidates:
      _m_j.ph.O000000o(_m_j.os, _m_j.op):void
      _m_j.ph.O000000o(_m_j.os, boolean):_m_j.op */
    public final String O000000o(String str, ScanResult[] scanResultArr, boolean z) {
        try {
            op O000000o2 = ph.O000000o().O000000o(O00000Oo(str, scanResultArr), false);
            if (O000000o2 == null) {
                return null;
            }
            if (this.O00000Oo != null) {
                double[] O000000o3 = this.O00000Oo.O000000o(new double[]{O000000o2.O00000Oo(), O000000o2.O000000o()});
                O000000o2.O00000Oo(O000000o3[0]);
                O000000o2.O000000o(O000000o3[1]);
            }
            return O000000o2.O00000oO();
        } catch (Throwable th) {
            bua.O000000o(th, "OfflineLocManager", "getOfflineLocation");
            return null;
        }
    }

    public final void O000000o(btx btx, ox oxVar) {
        try {
            bub bub = new bub();
            ph.O000000o().O000000o(this.f4522O000000o, O00000Oo(btx, oxVar), bub);
        } catch (Throwable th) {
            bua.O000000o(th, "OfflineLocManager", "init");
        }
    }

    private pg O00000Oo(btx btx, ox oxVar) {
        pg pgVar = new pg();
        pgVar.O00000Oo = 4;
        if (btx != null) {
            try {
                pgVar.O00000o0 = btx.O00000o;
                pgVar.O0000Oo = btx.O00000o0;
                pgVar.O00000o = btx.f13278O000000o;
                pgVar.O0000Oo0 = btx.O00000Oo;
                pgVar.O00000oO = btx.O00000oO;
                pgVar.O0000OOo = btx.O00000oo;
            } catch (Throwable th) {
                bua.O000000o(th, "OfflineLocManager", "generateOfflineConfig");
            }
        } else {
            pgVar.O0000Oo = bwt.O00000oo(this.f4522O000000o);
            pgVar.O00000o0 = bwt.O00000o0(this.f4522O000000o);
            pgVar.O00000o = "";
            pgVar.O0000Oo0 = "S128DF1572465B890OE3F7A13167KLEI";
            pgVar.O00000oO = bww.O000000o(this.f4522O000000o);
            pgVar.O0000OOo = btx.O00000oo;
        }
        pk pkVar = new pk();
        pkVar.f2385O000000o = 100;
        pkVar.O00000Oo = 100000;
        pkVar.O00000o0 = 864000000;
        pkVar.O00000o = 60000;
        pkVar.O00000oO = 60000;
        pkVar.O00000oo = 1000;
        pkVar.O0000O0o = 500000;
        pkVar.O0000OOo = false;
        pgVar.O0000o0O = pkVar;
        if (this.O00000Oo == null) {
            try {
                this.O00000Oo = new co(this.f4522O000000o);
            } catch (Throwable unused) {
            }
        }
        pgVar.O0000o0o = this.O00000Oo;
        pgVar.O0000o0 = oxVar;
        return pgVar;
    }
}
