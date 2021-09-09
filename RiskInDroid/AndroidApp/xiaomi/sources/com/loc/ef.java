package com.loc;

import _m_j.bua;
import _m_j.bvm;
import _m_j.bvy;
import _m_j.bvz;
import _m_j.bwg;
import _m_j.bwi;
import _m_j.bwt;
import _m_j.bww;
import android.content.Context;
import android.net.wifi.ScanResult;
import com.amap.opensdk.co.CoManager;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class ef {

    /* renamed from: O000000o  reason: collision with root package name */
    CoManager f4534O000000o = null;
    boolean O00000Oo = false;
    private Context O00000o;
    boolean O00000o0 = false;
    private int O00000oO = -1;

    public ef(Context context) {
        this.O00000o = context;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    private static String O000000o(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sv", "4.7.1");
            jSONObject.put("als", "S128DF1572465B890OE3F7A13167KLEI");
            jSONObject.put("pn", bwt.O00000o0(context));
            jSONObject.put("ak", bwt.O00000oo(context));
            jSONObject.put("ud", bww.O0000O0o(context));
            jSONObject.put("au", bww.O000000o(context));
            jSONObject.put("isimei", true);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static ScanResult[] O000000o(List<ScanResult> list) {
        if (list == null) {
            return null;
        }
        try {
            if (list.size() <= 0) {
                return null;
            }
            ScanResult[] scanResultArr = new ScanResult[list.size()];
            for (int i = 0; i < list.size(); i++) {
                scanResultArr[i] = list.get(i);
            }
            return scanResultArr;
        } catch (Throwable th) {
            bvz.O000000o(th, "APSCoManager", "buildScanResults");
            return null;
        }
    }

    private boolean O00000o() {
        if (!bvy.O0000oo()) {
            O00000Oo();
            return false;
        } else if (bvy.O0000ooO()) {
            return true;
        } else {
            if (this.O00000o0) {
                try {
                    if (this.f4534O000000o != null) {
                        this.f4534O000000o.O00000oO();
                    }
                } catch (Throwable th) {
                    bvz.O000000o(th, "APSCoManager", "destroyOffline");
                }
                this.O00000o0 = false;
            }
            return false;
        }
    }

    public final AMapLocationServer O000000o(ee eeVar, List<ScanResult> list, AMapLocationServer aMapLocationServer) {
        String e;
        try {
            if (!O00000o()) {
                return aMapLocationServer;
            }
            if (aMapLocationServer != null && aMapLocationServer.getErrorCode() == 7) {
                return aMapLocationServer;
            }
            O00000o0();
            if (this.f4534O000000o != null) {
                this.O00000o0 = true;
                String O000000o2 = this.f4534O000000o.O000000o(O000000o(eeVar), O000000o(list));
                if (O000000o2 != null) {
                    JSONObject jSONObject = new JSONObject(O000000o2);
                    AMapLocationServer aMapLocationServer2 = new AMapLocationServer("lbs");
                    aMapLocationServer2.b(jSONObject);
                    if (bwi.O000000o(aMapLocationServer2)) {
                        StringBuffer stringBuffer = new StringBuffer();
                        if (aMapLocationServer2.e().equals("file")) {
                            e = "基站离线定位";
                        } else if (aMapLocationServer2.e().equals("wifioff")) {
                            e = "WIFI离线定位";
                        } else {
                            stringBuffer.append("离线定位，");
                            e = aMapLocationServer2.e();
                        }
                        stringBuffer.append(e);
                        if (aMapLocationServer != null) {
                            stringBuffer.append("，在线定位失败原因:" + aMapLocationServer.getErrorInfo());
                        }
                        aMapLocationServer2.setTrustedLevel(2);
                        aMapLocationServer2.setLocationDetail(stringBuffer.toString());
                        aMapLocationServer2.setLocationType(8);
                    }
                    return aMapLocationServer2;
                }
            }
            return aMapLocationServer;
        } catch (Throwable th) {
            bvz.O000000o(th, "APSCoManager", "getOffLoc");
        }
    }

    public final String O000000o() {
        try {
            if (!bvy.O0000oo()) {
                O00000Oo();
                return null;
            } else if (this.f4534O000000o != null) {
                return CoManager.O00000o0();
            } else {
                return null;
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "APSCoManager", "getCollectionVersion");
            return null;
        }
    }

    public final void O00000Oo() {
        try {
            if (this.f4534O000000o != null) {
                this.f4534O000000o.O00000oo();
            }
            this.O00000Oo = false;
            this.O00000o0 = false;
            this.f4534O000000o = null;
        } catch (Throwable th) {
            bvz.O000000o(th, "APSCoManager", "destroy");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, long):long
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, long):long */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, int):void
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void */
    /* access modifiers changed from: package-private */
    public final void O00000o0() {
        new Object[1][0] = "CoManager ==> init ";
        bwi.O000000o();
        try {
            if (this.f4534O000000o == null) {
                int O00000Oo2 = bwg.O00000Oo(this.O00000o, "pref", "ok5", 0);
                long O00000Oo3 = bwg.O00000Oo(this.O00000o, "pref", "ok7", 0L);
                if (O00000Oo2 == 0 || O00000Oo3 == 0 || System.currentTimeMillis() - O00000Oo3 >= 259200000) {
                    bwg.O000000o(this.O00000o, "pref", "ok5", O00000Oo2 + 1);
                    bwg.O000000o(this.O00000o, "pref", "ok7", System.currentTimeMillis());
                    new Object[1][0] = "CoManager ==> initForJar ";
                    bwi.O000000o();
                    try {
                        this.f4534O000000o = new CoManager(this.O00000o);
                        if (this.O00000o != null) {
                            String O000000o2 = O000000o(this.O00000o);
                            if (this.f4534O000000o != null) {
                                this.f4534O000000o.O000000o(O000000o2);
                            }
                        }
                    } catch (Throwable th) {
                        bvz.O000000o(th, "APSCoManager", "initForJar");
                    }
                    this.f4534O000000o.O00000Oo();
                    bwg.O000000o(this.O00000o, "pref", "ok5", 0);
                    bwg.O000000o(this.O00000o, "pref", "ok7", 0L);
                } else {
                    return;
                }
            }
            int O00oOooO = bvy.O00oOooO();
            if (this.O00000oO != O00oOooO) {
                this.O00000oO = O00oOooO;
                if (this.f4534O000000o != null) {
                    this.f4534O000000o.O000000o(O00oOooO);
                }
            }
        } catch (Throwable th2) {
            bvz.O000000o(th2, "APSCoManager", "init");
        }
    }

    public final void O000000o(ee eeVar, List<ScanResult> list, AMapLocationServer aMapLocationServer, int i) {
        try {
            if (O00000o() && bwi.O000000o(aMapLocationServer)) {
                O00000o0();
                if (this.f4534O000000o != null) {
                    String O000000o2 = O000000o(eeVar);
                    ScanResult[] O000000o3 = O000000o(list);
                    if (i == 1) {
                        CoManager coManager = this.f4534O000000o;
                        if (coManager.O00000Oo) {
                            if (!coManager.O00000oO) {
                                coManager.O000000o();
                                coManager.O0000O0o();
                                cp.O000000o(O000000o2, O000000o3);
                            }
                        }
                    } else if (i == 2) {
                        CoManager coManager2 = this.f4534O000000o;
                        double latitude = aMapLocationServer.getLatitude();
                        double longitude = aMapLocationServer.getLongitude();
                        try {
                            if (coManager2.O00000Oo) {
                                if (!coManager2.O00000oO) {
                                    coManager2.O000000o();
                                    coManager2.O0000O0o();
                                    cp.O000000o(O000000o2, O000000o3, latitude, longitude);
                                }
                            }
                        } catch (Throwable th) {
                            new String[]{"correctOfflineLocation error!!!!"};
                            bua.O000000o(th, "CoManager", "correctOfflineLocation");
                        }
                    } else {
                        return;
                    }
                    this.O00000o0 = true;
                }
            }
        } catch (Throwable th2) {
            StringBuilder sb = new StringBuilder("action-");
            sb.append(1 == i ? "training" : "correct");
            bvz.O000000o(th2, "APSCoManager", sb.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0023 A[Catch:{ Throwable -> 0x003c }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e A[Catch:{ Throwable -> 0x003c }] */
    private static String O000000o(ee eeVar) {
        bvm bvm;
        try {
            JSONObject jSONObject = new JSONObject();
            if (eeVar == null) {
                return null;
            }
            bvm O000000o2 = eeVar.O000000o();
            if (!eeVar.O0000o0O) {
                ArrayList<bvm> arrayList = eeVar.O00000o;
                if (arrayList.size() > 0) {
                    bvm = arrayList.get(0);
                    if (O000000o2 != null) {
                        jSONObject.put("mainCgi", O000000o2.O000000o());
                    }
                    if (bvm != null) {
                        jSONObject.put("mainCgi2", bvm.O000000o());
                    }
                    return jSONObject.toString();
                }
            }
            bvm = null;
            if (O000000o2 != null) {
            }
            if (bvm != null) {
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            bvz.O000000o(th, "APSCoManager", "buildCgiJsonStr");
            return null;
        }
    }
}
