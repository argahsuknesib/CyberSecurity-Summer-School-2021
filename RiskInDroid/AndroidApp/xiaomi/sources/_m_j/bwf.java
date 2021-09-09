package _m_j;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.loc.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bwf {
    static AMapLocation O0000O0o = null;
    static boolean O0000OOo = false;
    private static JSONArray O0000Oo = null;
    private static List<btg> O0000Oo0 = new ArrayList();

    /* renamed from: O000000o  reason: collision with root package name */
    public SparseArray<Long> f13331O000000o = new SparseArray<>();
    public int O00000Oo = -1;
    public String[] O00000o = {"ol", "cl", "gl", "ha", "bs", "ds"};
    public long O00000o0 = 0;
    public int O00000oO = -1;
    public long O00000oo = -1;

    /* renamed from: _m_j.bwf$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f13332O000000o = new int[AMapLocationClientOption.AMapLocationMode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            f13332O000000o[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            f13332O000000o[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            try {
                f13332O000000o[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static void O000000o(long j, long j2) {
        try {
            if (!O0000OOo) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("gpsTime:");
                stringBuffer.append(bwi.O000000o(j, "yyyy-MM-dd HH:mm:ss.SSS"));
                stringBuffer.append(",");
                stringBuffer.append("sysTime:");
                stringBuffer.append(bwi.O000000o(j2, "yyyy-MM-dd HH:mm:ss.SSS"));
                stringBuffer.append(",");
                long O00oOoOo = bvy.O00oOoOo();
                String str = "0";
                if (0 != O00oOoOo) {
                    str = bwi.O000000o(O00oOoOo, "yyyy-MM-dd HH:mm:ss.SSS");
                }
                stringBuffer.append("serverTime:");
                stringBuffer.append(str);
                O000000o("checkgpstime", stringBuffer.toString());
                if (0 != O00oOoOo && Math.abs(j - O00oOoOo) < 31536000000L) {
                    stringBuffer.append(", correctError");
                    O000000o("checkgpstimeerror", stringBuffer.toString());
                }
                stringBuffer.delete(0, stringBuffer.length());
                O0000OOo = true;
            }
        } catch (Throwable unused) {
        }
    }

    public static void O000000o(Context context) {
        if (context != null) {
            try {
                if (bvy.O0000Oo0()) {
                    if (O0000Oo0 != null && O0000Oo0.size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(O0000Oo0);
                        bth.O000000o(arrayList, context);
                        O0000Oo0.clear();
                    }
                    O00000oO(context);
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "ReportUtil", "destroy");
            }
        }
    }

    public static void O000000o(Context context, int i, int i2, long j, long j2) {
        if (i != -1 && i2 != -1 && context != null) {
            try {
                if (bvy.O0000Oo0()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("param_int_first", i);
                    jSONObject.put("param_int_second", i2);
                    jSONObject.put("param_long_first", j);
                    jSONObject.put("param_long_second", j2);
                    O000000o(context, "O012", jSONObject);
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "ReportUtil", "reportServiceAliveTime");
            }
        }
    }

    public static void O000000o(Context context, long j, boolean z) {
        if (context != null) {
            try {
                if (bvy.O0000Oo0()) {
                    int intValue = Long.valueOf(j).intValue();
                    String str = "domestic";
                    if (!z) {
                        str = "abroad";
                    }
                    O000000o(context, "O015", str, null, intValue, Integer.MAX_VALUE);
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "ReportUtil", "reportGPSLocUseTime");
            }
        }
    }

    public static void O000000o(Context context, AMapLocation aMapLocation) {
        int i;
        if (aMapLocation != null) {
            try {
                if ("gps".equalsIgnoreCase(aMapLocation.getProvider())) {
                    return;
                }
                if (aMapLocation.getLocationType() != 1) {
                    String str = "domestic";
                    if (O000000o(aMapLocation)) {
                        str = "abroad";
                    }
                    String str2 = str;
                    String str3 = "net";
                    if (aMapLocation.getErrorCode() != 0) {
                        int errorCode = aMapLocation.getErrorCode();
                        if (!(errorCode == 4 || errorCode == 5 || errorCode == 6 || errorCode == 11)) {
                            str3 = "cache";
                        }
                        i = 0;
                    } else {
                        int locationType = aMapLocation.getLocationType();
                        if (!(locationType == 5 || locationType == 6)) {
                            str3 = "cache";
                        }
                        i = 1;
                    }
                    O000000o(context, "O016", str3, str2, i, Integer.MAX_VALUE);
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "ReportUtil", "reportBatting");
            }
        }
    }

    public static void O000000o(Context context, String str, int i) {
        if (context != null) {
            try {
                if (bvy.O0000Oo0()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("param_string_first", str);
                    }
                    if (i != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i);
                    }
                    O000000o(context, "O010", jSONObject);
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "ReportUtil", "reportDexFunction");
            }
        }
    }

    private static void O000000o(Context context, String str, String str2, String str3, int i, int i2) {
        if (context != null) {
            try {
                if (bvy.O0000Oo0()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("param_string_second", str3);
                    }
                    if (i != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i);
                    }
                    if (i2 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_second", i2);
                    }
                    O000000o(context, str, jSONObject);
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    private static void O000000o(Context context, String str, JSONObject jSONObject) {
        if (context != null) {
            try {
                if (bvy.O0000Oo0()) {
                    btg btg = new btg(context, "loc", "4.7.1", str);
                    btg.O000000o(jSONObject.toString());
                    O0000Oo0.add(btg);
                    if (O0000Oo0.size() >= 100) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(O0000Oo0);
                        bth.O000000o(arrayList, context);
                        O0000Oo0.clear();
                    }
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "ReportUtil", "applyStatistics");
            }
        }
    }

    public static void O000000o(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        try {
            if (O0000O0o == null) {
                if (!bwi.O000000o(aMapLocation)) {
                    O0000O0o = aMapLocation2;
                    return;
                }
                O0000O0o = aMapLocation.clone();
            }
            if (bwi.O000000o(O0000O0o) && bwi.O000000o(aMapLocation2)) {
                AMapLocation clone = aMapLocation2.clone();
                if (!(O0000O0o.getLocationType() == 1 || O0000O0o.getLocationType() == 9 || "gps".equalsIgnoreCase(O0000O0o.getProvider()) || O0000O0o.getLocationType() == 7 || clone.getLocationType() == 1 || clone.getLocationType() == 9 || "gps".equalsIgnoreCase(clone.getProvider()) || clone.getLocationType() == 7)) {
                    long abs = Math.abs(clone.getTime() - O0000O0o.getTime()) / 1000;
                    if (abs <= 0) {
                        abs = 1;
                    }
                    if (abs <= 1800) {
                        float O000000o2 = bwi.O000000o(O0000O0o, clone);
                        float f = O000000o2 / ((float) abs);
                        if (O000000o2 > 30000.0f && f > 1000.0f) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(O0000O0o.getLatitude());
                            sb.append(",");
                            sb.append(O0000O0o.getLongitude());
                            sb.append(",");
                            sb.append(O0000O0o.getAccuracy());
                            sb.append(",");
                            sb.append(O0000O0o.getLocationType());
                            sb.append(",");
                            if (aMapLocation.getTime() != 0) {
                                sb.append(bwi.O000000o(O0000O0o.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(O0000O0o.getTime());
                            }
                            sb.append("#");
                            sb.append(clone.getLatitude());
                            sb.append(",");
                            sb.append(clone.getLongitude());
                            sb.append(",");
                            sb.append(clone.getAccuracy());
                            sb.append(",");
                            sb.append(clone.getLocationType());
                            sb.append(",");
                            if (clone.getTime() != 0) {
                                sb.append(bwi.O000000o(clone.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(clone.getTime());
                            }
                            O000000o("bigshiftstatistics", sb.toString());
                            sb.delete(0, sb.length());
                        }
                    }
                }
                O0000O0o = clone;
            }
        } catch (Throwable unused) {
        }
    }

    public static void O000000o(String str, int i) {
        String str2;
        String valueOf = String.valueOf(i);
        if (i == 2011) {
            str2 = "ContextIsNull";
        } else if (i == 2031) {
            str2 = "CreateApsReqException";
        } else if (i == 2041) {
            str2 = "ResponseResultIsNull";
        } else if (i == 2081) {
            str2 = "LocalLocException";
        } else if (i == 2091) {
            str2 = "InitException";
        } else if (i == 2111) {
            str2 = "ErrorCgiInfo";
        } else if (i == 2121) {
            str2 = "NotLocPermission";
        } else if (i == 2141) {
            str2 = "NoEnoughStatellites";
        } else if (i == 2021) {
            str2 = "OnlyMainWifi";
        } else if (i == 2022) {
            str2 = "OnlyOneWifiButNotMain";
        } else if (i == 2061) {
            str2 = "ServerRetypeError";
        } else if (i == 2062) {
            str2 = "ServerLocFail";
        } else if (i == 2151) {
            str2 = "MaybeMockNetLoc";
        } else if (i != 2152) {
            switch (i) {
                case 2051:
                    str2 = "NeedLoginNetWork\t";
                    break;
                case 2052:
                    str2 = "MaybeIntercepted";
                    break;
                case 2053:
                    str2 = "DecryptResponseException";
                    break;
                case 2054:
                    str2 = "ParserDataException";
                    break;
                default:
                    switch (i) {
                        case 2101:
                            str2 = "BindAPSServiceException";
                            break;
                        case 2102:
                            str2 = "AuthClientScodeFail";
                            break;
                        case 2103:
                            str2 = "NotConfigAPSService";
                            break;
                        default:
                            switch (i) {
                                case 2131:
                                    str2 = "NoCgiOAndWifiInfo";
                                    break;
                                case 2132:
                                    str2 = "AirPlaneModeAndWifiOff";
                                    break;
                                case 2133:
                                    str2 = "NoCgiAndWifiOff";
                                    break;
                                default:
                                    str2 = "";
                                    break;
                            }
                    }
            }
        } else {
            str2 = "MaybeMockGPSLoc";
        }
        O000000o(str, valueOf, str2);
    }

    public static void O000000o(String str, String str2) {
        try {
            bsf.O00000Oo(bvz.O00000Oo(), str2, str);
        } catch (Throwable th) {
            bvz.O000000o(th, "ReportUtil", "reportLog");
        }
    }

    public static void O000000o(String str, String str2, String str3) {
        try {
            bsf.O000000o(bvz.O00000Oo(), "/mobile/binary", str3, str, str2);
        } catch (Throwable unused) {
        }
    }

    public static void O000000o(String str, Throwable th) {
        try {
            if (th instanceof t) {
                bsf.O000000o(bvz.O00000Oo(), str, (t) th);
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean O000000o(AMapLocation aMapLocation) {
        return bwi.O000000o(aMapLocation) ? !bvz.O000000o(aMapLocation.getLatitude(), aMapLocation.getLongitude()) : "http://abroad.apilocate.amap.com/mobile/binary".equals(bvz.f13327O000000o);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0029 A[Catch:{ Throwable -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    public static void O00000Oo(Context context, AMapLocation aMapLocation) {
        int i;
        try {
            if (bwi.O000000o(aMapLocation)) {
                int locationType = aMapLocation.getLocationType();
                boolean z = false;
                if (locationType == 1) {
                    i = 0;
                } else if (locationType == 2 || locationType == 4) {
                    i = 1;
                } else if (locationType == 8) {
                    i = 3;
                } else if (locationType != 9) {
                    i = 0;
                    if (!z) {
                        if (O0000Oo == null) {
                            O0000Oo = new JSONArray();
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("lon", bwi.O00000o0(aMapLocation.getLongitude()));
                        jSONObject.put("lat", bwi.O00000o0(aMapLocation.getLatitude()));
                        jSONObject.put("type", i);
                        jSONObject.put("timestamp", bwi.O00000Oo());
                        if (aMapLocation.getCoordType().equalsIgnoreCase("WGS84")) {
                            jSONObject.put("coordType", 1);
                        } else {
                            jSONObject.put("coordType", 2);
                        }
                        if (i == 0) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("accuracy", bwi.O00000Oo((double) aMapLocation.getAccuracy()));
                            jSONObject2.put("altitude", bwi.O00000Oo(aMapLocation.getAltitude()));
                            jSONObject2.put("bearing", bwi.O00000Oo((double) aMapLocation.getBearing()));
                            jSONObject2.put("speed", bwi.O00000Oo((double) aMapLocation.getSpeed()));
                            jSONObject.put("extension", jSONObject2);
                        }
                        JSONArray put = O0000Oo.put(jSONObject);
                        O0000Oo = put;
                        if (put.length() >= bvy.O0000Oo()) {
                            O00000oO(context);
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    i = 2;
                }
                z = true;
                if (!z) {
                }
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "ReportUtil", "recordOfflineLocLog");
        }
    }

    private static void O00000oO(Context context) {
        try {
            if (O0000Oo != null && O0000Oo.length() > 0) {
                btf.O000000o(new bte(context, bvz.O00000Oo(), O0000Oo.toString()), context);
                O0000Oo = null;
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "ReportUtil", "writeOfflineLocLog");
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
    public final void O000000o(Context context, int i) {
        try {
            if (this.O00000Oo != i) {
                if (!(this.O00000Oo == -1 || this.O00000Oo == i)) {
                    this.f13331O000000o.append(this.O00000Oo, Long.valueOf((bwi.O00000o0() - this.O00000o0) + this.f13331O000000o.get(this.O00000Oo, 0L).longValue()));
                }
                this.O00000o0 = bwi.O00000o0() - bwg.O00000Oo(context, "pref", this.O00000o[i], 0L);
                this.O00000Oo = i;
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "ReportUtil", "setLocationType");
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
    public final void O00000Oo(Context context) {
        try {
            long O00000o02 = bwi.O00000o0() - this.O00000o0;
            if (this.O00000Oo != -1) {
                this.f13331O000000o.append(this.O00000Oo, Long.valueOf(O00000o02 + this.f13331O000000o.get(this.O00000Oo, 0L).longValue()));
            }
            long O00000o03 = bwi.O00000o0() - this.O00000oo;
            if (this.O00000oO != -1) {
                this.f13331O000000o.append(this.O00000oO, Long.valueOf(O00000o03 + this.f13331O000000o.get(this.O00000oO, 0L).longValue()));
            }
            for (int i = 0; i < this.O00000o.length; i++) {
                long longValue = this.f13331O000000o.get(i, 0L).longValue();
                if (longValue > 0 && longValue > bwg.O00000Oo(context, "pref", this.O00000o[i], 0L)) {
                    bwg.O000000o(context, "pref", this.O00000o[i], longValue);
                }
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "ReportUtil", "saveLocationTypeAndMode");
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
    public final int O00000o(Context context) {
        try {
            long O00000Oo2 = bwg.O00000Oo(context, "pref", this.O00000o[3], 0L);
            long O00000Oo3 = bwg.O00000Oo(context, "pref", this.O00000o[4], 0L);
            long O00000Oo4 = bwg.O00000Oo(context, "pref", this.O00000o[5], 0L);
            if (O00000Oo2 == 0 && O00000Oo3 == 0 && O00000Oo4 == 0) {
                return -1;
            }
            return O00000Oo2 > O00000Oo3 ? O00000Oo2 > O00000Oo4 ? 3 : 5 : O00000Oo3 > O00000Oo4 ? 4 : 5;
        } catch (Throwable unused) {
            return -1;
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
    public final int O00000o0(Context context) {
        try {
            long O00000Oo2 = bwg.O00000Oo(context, "pref", this.O00000o[2], 0L);
            long O00000Oo3 = bwg.O00000Oo(context, "pref", this.O00000o[0], 0L);
            long O00000Oo4 = bwg.O00000Oo(context, "pref", this.O00000o[1], 0L);
            if (O00000Oo2 == 0 && O00000Oo3 == 0 && O00000Oo4 == 0) {
                return -1;
            }
            long j = O00000Oo3 - O00000Oo2;
            long j2 = O00000Oo4 - O00000Oo2;
            return O00000Oo2 > j ? O00000Oo2 > j2 ? 2 : 1 : j > j2 ? 0 : 1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static void O000000o(Context context, bwe bwe) {
        String str;
        if (context != null) {
            try {
                if (bvy.O0000Oo0()) {
                    AMapLocationServer aMapLocationServer = bwe.O00000o0;
                    if (!bwi.O000000o(aMapLocationServer) || "gps".equalsIgnoreCase(aMapLocationServer.getProvider())) {
                        return;
                    }
                    if (aMapLocationServer.getLocationType() != 1) {
                        int intValue = Long.valueOf(bwe.O00000Oo - bwe.f13330O000000o).intValue();
                        boolean z = false;
                        int intValue2 = Long.valueOf(aMapLocationServer.k()).intValue();
                        int locationType = aMapLocationServer.getLocationType();
                        if (locationType == 5 || locationType == 6) {
                            str = "net";
                        } else {
                            str = "cache";
                            z = true;
                        }
                        String str2 = O000000o(aMapLocationServer) ? "abroad" : "domestic";
                        if (!z) {
                            O000000o(context, "O014", str2, null, intValue2, intValue);
                        }
                        O000000o(context, "O013", str, str2, intValue, Integer.MAX_VALUE);
                    }
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "ReportUtil", "reportLBSLocUseTime");
            }
        }
    }
}
