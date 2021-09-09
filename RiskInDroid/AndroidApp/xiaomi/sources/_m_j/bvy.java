package _m_j;

import _m_j.bwu;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bvy {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f13325O000000o = true;
    static boolean O00000Oo = false;
    static int O00000o = 3600000;
    static boolean O00000o0 = false;
    static long O00000oO = 0;
    static long O00000oo = 0;
    static boolean O0000O0o = false;
    static boolean O0000OOo = true;
    private static boolean O0000Oo = false;
    private static boolean O0000Oo0 = false;
    private static long O0000OoO = 0;
    private static long O0000Ooo = 0;
    private static int O0000o = 0;
    private static boolean O0000o0 = false;
    private static long O0000o00 = 5000;
    private static int O0000o0O = 0;
    private static boolean O0000o0o = false;
    private static boolean O0000oO = true;
    private static boolean O0000oO0 = false;
    private static int O0000oOO = 1000;
    private static int O0000oOo = 200;
    private static int O0000oo = 20;
    private static boolean O0000oo0 = false;
    private static boolean O0000ooO = true;
    private static boolean O0000ooo = true;
    private static ArrayList<String> O000O00o = new ArrayList<>();
    private static boolean O000O0OO = false;
    private static int O000O0Oo = -1;
    private static boolean O000O0o = false;
    private static ArrayList<String> O000O0o0 = new ArrayList<>();
    private static int O000O0oO = 3000;
    private static int O000O0oo = 3000;
    private static List<bwc> O000OO = new ArrayList();
    private static boolean O000OO00 = true;
    private static long O000OO0o = 300000;
    private static boolean O000OOOo = false;
    private static int O000OOo = 0;
    private static long O000OOo0 = 0;
    private static int O000OOoO = 0;
    private static List<String> O000OOoo = new ArrayList();
    private static int O000Oo0 = 80;
    private static boolean O000Oo00 = true;
    private static boolean O000Oo0O = false;
    private static boolean O000Oo0o = true;
    private static boolean O000OoO = true;
    private static boolean O000OoO0 = false;
    private static boolean O000OoOO = false;
    private static int O000OoOo = -1;
    private static long O000Ooo = -1;
    private static boolean O000Ooo0 = true;
    private static boolean O000OooO = true;
    private static int O000Oooo = 1;
    private static long O000o000 = 0;
    private static boolean O00O0Oo = false;
    private static long O00oOoOo = 0;
    private static int O00oOooO = -1;
    private static long O00oOooo;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f13326O000000o = false;
        String O00000Oo = "0";
        int O00000o = 5;
        boolean O00000o0 = false;

        O000000o() {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bwu.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.bwu.O000000o(org.json.JSONObject, java.lang.String):java.lang.String
      _m_j.bwu.O000000o(_m_j.bwu$O000000o, org.json.JSONObject):void
      _m_j.bwu.O000000o(android.content.Context, java.lang.String):void
      _m_j.bwu.O000000o(org.json.JSONObject, _m_j.bwu$O000000o$O00000Oo):void
      _m_j.bwu.O000000o(org.json.JSONObject, _m_j.bwu$O000000o$O00000o0):void
      _m_j.bwu.O000000o(java.lang.String, boolean):boolean */
    private static O000000o O000000o(JSONObject jSONObject, String str) {
        O000000o o000000o;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                if (jSONObject2 != null) {
                    o000000o = new O000000o();
                    try {
                        o000000o.f13326O000000o = bwu.O000000o(jSONObject2.optString("b"), false);
                        o000000o.O00000Oo = jSONObject2.optString("t");
                        o000000o.O00000o0 = bwu.O000000o(jSONObject2.optString("st"), false);
                        o000000o.O00000o = jSONObject2.optInt("i", 0);
                        return o000000o;
                    } catch (Throwable th) {
                        th = th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                o000000o = null;
                bvz.O000000o(th, "AuthUtil", "getLocateObj");
                return o000000o;
            }
        }
        return null;
    }

    public static boolean O000000o() {
        return O0000o0;
    }

    public static boolean O000000o(long j) {
        long O00000o02 = bwi.O00000o0();
        return O0000Oo && O00000o02 - O0000Ooo <= O0000OoO && O00000o02 - j >= O0000o00;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, long):long
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    public static boolean O000000o(Context context) {
        O0000ooO = true;
        boolean z = false;
        try {
            O0000Oo0 = bwg.O00000Oo(context, "pref", "oda", false);
            z = O000000o(context, bwu.O000000o(context, bvz.O00000Oo(), bvz.O00000o0()));
        } catch (Throwable th) {
            bvz.O000000o(th, "AuthUtil", "getConfig");
        }
        O00000oo = bwi.O00000o0();
        O00000oO = bwi.O00000o0();
        return z;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, long):long
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, long):long */
    public static boolean O000000o(Context context, long j) {
        if (!O000O0o) {
            return false;
        }
        long O00000Oo2 = bwi.O00000Oo();
        if (O00000Oo2 - j < ((long) O000O0oO)) {
            return false;
        }
        if (O000O0oo == -1) {
            return true;
        }
        if (!bwi.O00000o0(O00000Oo2, bwg.O00000Oo(context, "pref", "ngpsTime", 0L))) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("pref", 0).edit();
                edit.putLong("ngpsTime", O00000Oo2);
                edit.putInt("ngpsCount", 0);
                bwg.O000000o(edit);
            } catch (Throwable th) {
                bvz.O000000o(th, "AuthUtil", "resetPrefsNGPS");
            }
            bwg.O000000o(context, "pref", "ngpsCount", 1);
            return true;
        }
        int O00000Oo3 = bwg.O00000Oo(context, "pref", "ngpsCount", 0);
        if (O00000Oo3 >= O000O0oo) {
            return false;
        }
        bwg.O000000o(context, "pref", "ngpsCount", O00000Oo3 + 1);
        return true;
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
     method: _m_j.bwu.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.bwu.O000000o(org.json.JSONObject, java.lang.String):java.lang.String
      _m_j.bwu.O000000o(_m_j.bwu$O000000o, org.json.JSONObject):void
      _m_j.bwu.O000000o(android.content.Context, java.lang.String):void
      _m_j.bwu.O000000o(org.json.JSONObject, _m_j.bwu$O000000o$O00000Oo):void
      _m_j.bwu.O000000o(org.json.JSONObject, _m_j.bwu$O000000o$O00000o0):void
      _m_j.bwu.O000000o(java.lang.String, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, int):void
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.bwg.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void */
    /* JADX WARNING: Can't wrap try/catch for region: R(15:4|5|6|11|(2:12|13)|(3:20|21|22)|27|28|29|30|31|32|(2:34|35)|36|(3:38|39|(3:43|(3:46|(1:48)(1:328)|44)|329)(0))) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0074 */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01ba A[Catch:{ Throwable -> 0x0227 }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0243 A[Catch:{ Throwable -> 0x0250, Throwable -> 0x02aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x025e A[Catch:{ Throwable -> 0x0250, Throwable -> 0x02aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0284 A[Catch:{ Throwable -> 0x0250, Throwable -> 0x02aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x02b4 A[Catch:{ Throwable -> 0x02dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x02e6 A[Catch:{ Throwable -> 0x030e }] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0318 A[Catch:{ Throwable -> 0x0436 }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0361 A[SYNTHETIC, Splitter:B:212:0x0361] */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0412 A[Catch:{ Throwable -> 0x0431 }] */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x0442 A[Catch:{ Throwable -> 0x0459 }] */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x0463  */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x04d4 A[Catch:{ Throwable -> 0x0513 }] */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x0521 A[Catch:{ Throwable -> 0x054f }] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x0552 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:341:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00af A[Catch:{ Throwable -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x014d A[Catch:{ Throwable -> 0x01ae, Throwable -> 0x058a }] */
    private static boolean O000000o(Context context, bwu.O000000o o000000o) {
        String str;
        String str2;
        JSONObject jSONObject;
        Context context2;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONArray optJSONArray;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        boolean z;
        JSONArray optJSONArray2;
        int i;
        JSONArray optJSONArray3;
        String str3;
        String str4;
        JSONArray jSONArray;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONObject jSONObject6;
        O000000o O000000o2;
        O000000o O000000o3;
        O000000o O000000o4;
        bwu.O000000o.C0097O000000o o000000o2;
        JSONObject jSONObject7;
        Context context3 = context;
        bwu.O000000o o000000o3 = o000000o;
        String str5 = "";
        String str6 = "sysTime";
        boolean z2 = false;
        try {
            JSONObject jSONObject8 = o000000o3.O0000O0o;
            if (jSONObject8 != null) {
                O00000o = jSONObject8.optInt("at", 123) * 60 * 1000;
                try {
                    O000Oo0O = bwu.O000000o(jSONObject8.optString("ila"), O000Oo0O);
                } catch (Throwable th) {
                    bvz.O000000o(th, "AuthUtil", "loadConfigData_indoor");
                }
                if (!(context3 == null || jSONObject8 == null)) {
                    try {
                        O0000OOo = bwu.O000000o(jSONObject8.optString("re"), O0000OOo);
                        bwg.O000000o(context3, "pref", "fr", O0000OOo);
                    } catch (Throwable th2) {
                        bvz.O000000o(th2, "AuthUtil", "checkReLocationAble");
                    }
                }
                O000Oo0o = bwu.O000000o(jSONObject8.optString("nla"), O000Oo0o);
                O0000Oo0 = bwu.O000000o(jSONObject8.optString("oda"), O0000Oo0);
                bwg.O000000o(context3, "pref", "oda", O0000Oo0);
                try {
                    O000Ooo0 = bwu.O000000o(jSONObject8.optString("asw"), O000Ooo0);
                    bwg.O000000o(context3, "pref", "asw", O000Ooo0);
                } catch (Throwable unused) {
                }
                try {
                    JSONArray optJSONArray4 = jSONObject8.optJSONArray("mlpl");
                    if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                        for (int i2 = 0; i2 < optJSONArray4.length(); i2++) {
                            boolean O00000o02 = bwi.O00000o0(context3, optJSONArray4.getString(i2));
                            O000OoO0 = O00000o02;
                            if (O00000o02) {
                                break;
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable th3) {
            try {
                bvz.O000000o(th3, "AuthUtil", "loadConfigAbleStatus");
            } catch (Throwable unused3) {
                return false;
            }
        }
        try {
            JSONObject jSONObject9 = o000000o3.O0000OOo;
            if (jSONObject9 != null) {
                O0000ooo = bwu.O000000o(jSONObject9.optString("callamapflag"), O0000ooo);
                O00000Oo = bwu.O000000o(jSONObject9.optString("co"), false) && O0000ooo;
                if (O0000ooo) {
                    O00oOooO = jSONObject9.optInt("count", O00oOooO);
                    O00oOooo = jSONObject9.optLong(str6, O00oOooo);
                    JSONArray optJSONArray5 = jSONObject9.optJSONArray("sn");
                    if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                        for (int i3 = 0; i3 < optJSONArray5.length(); i3++) {
                            O000O00o.add(optJSONArray5.getString(i3));
                        }
                    }
                    if (O00oOooO != -1) {
                        str = "count";
                        if (O00oOooo != 0) {
                            try {
                                if (!bwi.O00000Oo(O00oOooo, bwg.O00000Oo(context3, "pref", "nowtime", 0L))) {
                                    O0000OOo(context);
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                bvz.O000000o(th, "AuthUtil", "loadConfigDataCallAMapSer");
                                jSONObject7 = o000000o3.O0000OoO;
                                if (jSONObject7 != null) {
                                }
                                o000000o2 = o000000o3.O0000ooO;
                                if (o000000o2 != null) {
                                }
                                jSONObject6 = o000000o3.O0000o00;
                                O000000o2 = O000000o(jSONObject6, "fs");
                                if (O000000o2 != null) {
                                }
                                O000000o3 = O000000o(jSONObject6, "us");
                                if (O000000o3 != null) {
                                }
                                O000000o4 = O000000o(jSONObject6, "rs");
                                if (O000000o4 != null) {
                                }
                                jSONObject5 = o000000o3.O0000o0O;
                                if (jSONObject5 != null) {
                                }
                                jSONObject4 = o000000o3.O0000o0o;
                                if (jSONObject4 != null) {
                                }
                                jSONObject3 = o000000o3.O0000Oo;
                                if (jSONObject3 != null) {
                                }
                                str2 = str6;
                                jSONObject2 = o000000o3.O0000Oo0;
                                if (jSONObject2 != null) {
                                }
                                jSONObject = o000000o3.O0000oo;
                                if (jSONObject != null) {
                                }
                                context2 = context;
                                optJSONObject2 = jSONObject.optJSONObject("15O");
                                if (optJSONObject2 != null) {
                                }
                                optJSONObject = jSONObject.optJSONObject("15U");
                                if (optJSONObject != null) {
                                }
                                if (context2 == null) {
                                }
                            }
                        }
                        jSONObject7 = o000000o3.O0000OoO;
                        if (jSONObject7 != null) {
                            boolean O000000o5 = bwu.O000000o(jSONObject7.optString("amappushflag"), O000O0OO);
                            O000O0OO = O000000o5;
                            if (O000000o5) {
                                O000O0Oo = jSONObject7.optInt(str, O000O0Oo);
                                O00oOoOo = jSONObject7.optLong(str6, O00oOoOo);
                                JSONArray optJSONArray6 = jSONObject7.optJSONArray("sn");
                                if (optJSONArray6 != null && optJSONArray6.length() > 0) {
                                    for (int i4 = 0; i4 < optJSONArray6.length(); i4++) {
                                        O000O0o0.add(optJSONArray6.getString(i4));
                                    }
                                }
                                if (!(O000O0Oo == -1 || O00oOoOo == 0)) {
                                    if (!bwi.O00000Oo(O00oOoOo, bwg.O00000Oo(context3, "pref", "pushSerTime", 0L))) {
                                        O0000Oo0(context);
                                    }
                                }
                            }
                        }
                        o000000o2 = o000000o3.O0000ooO;
                        if (o000000o2 != null) {
                            O0000oO = o000000o2.f13359O000000o;
                            bwg.O000000o(context3, "pref", "exception", O0000oO);
                            JSONObject jSONObject10 = o000000o2.O00000o0;
                            O0000oOO = jSONObject10.optInt("fn", O0000oOO);
                            int optInt = jSONObject10.optInt("mpn", O0000oOo);
                            O0000oOo = optInt;
                            if (optInt > 500) {
                                O0000oOo = 500;
                            }
                            if (O0000oOo < 30) {
                                O0000oOo = 30;
                            }
                            O0000oo0 = bwu.O000000o(jSONObject10.optString("igu"), O0000oo0);
                            O0000oo = jSONObject10.optInt("ms", O0000oo);
                            btf.O000000o(O0000oOO, O0000oo0, O0000oo);
                            bwg.O000000o(context3, "pref", "fn", O0000oOO);
                            bwg.O000000o(context3, "pref", "mpn", O0000oOo);
                            bwg.O000000o(context3, "pref", "igu", O0000oo0);
                            bwg.O000000o(context3, "pref", "ms", O0000oo);
                        }
                        jSONObject6 = o000000o3.O0000o00;
                        if (jSONObject6 != null && bwu.O000000o(jSONObject6.optString("able"), false)) {
                            O000000o2 = O000000o(jSONObject6, "fs");
                            if (O000000o2 != null) {
                                O0000o0 = O000000o2.O00000o0;
                                O0000o0O = Integer.parseInt(O000000o2.O00000Oo);
                            }
                            O000000o3 = O000000o(jSONObject6, "us");
                            if (O000000o3 != null) {
                                O0000o0o = O000000o3.O00000o0;
                                O0000oO0 = O000000o3.f13326O000000o;
                                try {
                                    O0000o = Integer.parseInt(O000000o3.O00000Oo);
                                } catch (Throwable th5) {
                                    bvz.O000000o(th5, "AuthUtil", "loadconfig part1");
                                }
                                if (O0000o < 2) {
                                    O0000o0o = false;
                                }
                            }
                            O000000o4 = O000000o(jSONObject6, "rs");
                            if (O000000o4 != null) {
                                boolean z3 = O000000o4.O00000o0;
                                O0000Oo = z3;
                                if (z3) {
                                    O0000Ooo = bwi.O00000o0();
                                    O0000o00 = (long) (O000000o4.O00000o * 1000);
                                }
                                try {
                                    O0000OoO = (long) (Integer.parseInt(O000000o4.O00000Oo) * 1000);
                                } catch (Throwable th6) {
                                    bvz.O000000o(th6, "AuthUtil", "loadconfig part");
                                }
                            }
                        }
                        jSONObject5 = o000000o3.O0000o0O;
                        if (jSONObject5 != null) {
                            boolean O000000o6 = bwu.O000000o(jSONObject5.optString("able"), O000O0o);
                            O000O0o = O000000o6;
                            if (O000000o6) {
                                int optInt2 = jSONObject5.optInt("c", 0);
                                if (optInt2 == 0) {
                                    O000O0oO = 3000;
                                } else {
                                    O000O0oO = optInt2 * 1000;
                                }
                                O000O0oo = jSONObject5.getInt("t") / 2;
                            }
                        }
                        jSONObject4 = o000000o3.O0000o0o;
                        if (jSONObject4 != null) {
                            boolean O000000o7 = bwu.O000000o(jSONObject4.optString("able"), O000OO00);
                            O000OO00 = O000000o7;
                            if (O000000o7) {
                                O000OO0o = (long) (jSONObject4.optInt("c", 300) * 1000);
                            }
                            bwg.O000000o(context3, "pref", "ca", O000OO00);
                            bwg.O000000o(context3, "pref", "ct", O000OO0o);
                        }
                        jSONObject3 = o000000o3.O0000Oo;
                        if (jSONObject3 != null) {
                            O000OOOo = bwu.O000000o(jSONObject3.optString("able"), O000OOOo);
                            O000OOo0 = jSONObject3.optLong(str6, bwi.O00000Oo());
                            O000OOo = jSONObject3.optInt("n", 1);
                            O000OOoO = jSONObject3.optInt("nh", 1);
                            if (O000OOo != -1) {
                                if (O000OOo < O000OOoO) {
                                    z = false;
                                    if (O000OOOo && z) {
                                        optJSONArray2 = jSONObject3.optJSONArray("l");
                                        i = 0;
                                        while (i < optJSONArray2.length()) {
                                            try {
                                                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i);
                                                bwc bwc = new bwc();
                                                boolean O000000o8 = bwu.O000000o(optJSONObject3.optString("able", "false"), z2);
                                                bwc.f13329O000000o = O000000o8;
                                                if (O000000o8) {
                                                    bwc.O00000Oo = optJSONObject3.optString("pn", str5);
                                                    bwc.O00000o0 = optJSONObject3.optString("cn", str5);
                                                    bwc.O00000oO = optJSONObject3.optString("a", str5);
                                                    JSONArray optJSONArray7 = optJSONObject3.optJSONArray("b");
                                                    if (optJSONArray7 != null) {
                                                        ArrayList arrayList = new ArrayList();
                                                        jSONArray = optJSONArray2;
                                                        str4 = str5;
                                                        int i5 = 0;
                                                        while (i5 < optJSONArray7.length()) {
                                                            try {
                                                                JSONObject optJSONObject4 = optJSONArray7.optJSONObject(i5);
                                                                JSONArray jSONArray2 = optJSONArray7;
                                                                str3 = str6;
                                                                try {
                                                                    HashMap hashMap = new HashMap(16);
                                                                    try {
                                                                        hashMap.put(optJSONObject4.optString("k"), optJSONObject4.optString("v"));
                                                                        arrayList.add(hashMap);
                                                                    } catch (Throwable unused4) {
                                                                    }
                                                                    i5++;
                                                                    optJSONArray7 = jSONArray2;
                                                                    str6 = str3;
                                                                } catch (Throwable unused5) {
                                                                }
                                                            } catch (Throwable unused6) {
                                                            }
                                                        }
                                                        str3 = str6;
                                                        bwc.O00000o = arrayList;
                                                    } else {
                                                        jSONArray = optJSONArray2;
                                                        str4 = str5;
                                                        str3 = str6;
                                                    }
                                                    bwc.O00000oo = bwu.O000000o(optJSONObject3.optString("is", "false"), false);
                                                    O000OO.add(bwc);
                                                    i++;
                                                    optJSONArray2 = jSONArray;
                                                    str5 = str4;
                                                    str6 = str3;
                                                    z2 = false;
                                                }
                                            } catch (Throwable unused7) {
                                            }
                                            jSONArray = optJSONArray2;
                                            str4 = str5;
                                            str3 = str6;
                                            i++;
                                            optJSONArray2 = jSONArray;
                                            str5 = str4;
                                            str6 = str3;
                                            z2 = false;
                                        }
                                        str2 = str6;
                                        optJSONArray3 = jSONObject3.optJSONArray("sl");
                                        if (optJSONArray3 != null) {
                                            for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                                                String optString = optJSONArray3.optJSONObject(i6).optString("pan");
                                                if (!TextUtils.isEmpty(optString)) {
                                                    O000OOoo.add(optString);
                                                }
                                            }
                                        }
                                        jSONObject2 = o000000o3.O0000Oo0;
                                        if (jSONObject2 != null) {
                                            boolean O000000o9 = bwu.O000000o(jSONObject2.optString("able"), O000Oo00);
                                            O000Oo00 = O000000o9;
                                            if (O000000o9) {
                                                O000Oo0 = jSONObject2.optInt("c", O000Oo0);
                                            }
                                        }
                                        jSONObject = o000000o3.O0000oo;
                                        if (jSONObject != null) {
                                            try {
                                                JSONObject optJSONObject5 = jSONObject.optJSONObject("157");
                                                if (optJSONObject5 != null) {
                                                    boolean O000000o10 = bwu.O000000o(optJSONObject5.optString("able"), O00O0Oo);
                                                    O00O0Oo = O000000o10;
                                                    if (O000000o10) {
                                                        O000OoOo = optJSONObject5.optInt("cv", -1);
                                                        O000OoO = bwu.O000000o(optJSONObject5.optString("co"), O000OoO);
                                                        O000OoOO = bwu.O000000o(optJSONObject5.optString("oo"), O000OoOO);
                                                    } else {
                                                        O000OoO = false;
                                                        O000OoOO = false;
                                                    }
                                                    context2 = context;
                                                    try {
                                                        bwg.O000000o(context2, "pref", "ok0", O00O0Oo);
                                                        bwg.O000000o(context2, "pref", "ok2", O000OoO);
                                                        bwg.O000000o(context2, "pref", "ok3", O000OoOO);
                                                    } catch (Throwable th7) {
                                                        th = th7;
                                                    }
                                                    if (!(context2 == null || jSONObject == null)) {
                                                        optJSONObject2 = jSONObject.optJSONObject("15O");
                                                        if (optJSONObject2 != null) {
                                                            if (!bwu.O000000o(optJSONObject2.optString("able"), false) || ((optJSONArray = optJSONObject2.optJSONArray("fl")) != null && optJSONArray.length() > 0 && !optJSONArray.toString().contains(Build.MANUFACTURER))) {
                                                                O000Ooo = -1;
                                                            } else {
                                                                O000Ooo = (long) (optJSONObject2.optInt("iv", 30) * 1000);
                                                            }
                                                            bwg.O000000o(context2, "pref", "awsi", O000Ooo);
                                                        }
                                                    }
                                                    if (!(context2 == null || jSONObject == null)) {
                                                        optJSONObject = jSONObject.optJSONObject("15U");
                                                        if (optJSONObject != null) {
                                                            boolean O000000o11 = bwu.O000000o(optJSONObject.optString("able"), O000OooO);
                                                            int optInt3 = optJSONObject.optInt("yn", O000Oooo);
                                                            O000o000 = optJSONObject.optLong(str2, O000o000);
                                                            bwg.O000000o(context2, "pref", "15ua", O000000o11);
                                                            bwg.O000000o(context2, "pref", "15un", optInt3);
                                                            bwg.O000000o(context2, "pref", "15ust", O000o000);
                                                        }
                                                    }
                                                    if (context2 == null && jSONObject != null) {
                                                        try {
                                                            JSONObject optJSONObject6 = jSONObject.optJSONObject("16P");
                                                            if (optJSONObject6 == null) {
                                                                bwg.O000000o(context2, "pref", "dnab", false);
                                                                return true;
                                                            }
                                                            boolean O000000o12 = bwu.O000000o(optJSONObject6.optString("able"), false);
                                                            int optInt4 = optJSONObject6.optInt("mi");
                                                            int optInt5 = optJSONObject6.optInt("ma");
                                                            bwg.O000000o(context2, "pref", "dnab", O000000o12);
                                                            bwg.O000000o(context2, "pref", "dnmi", optInt4);
                                                            bwg.O000000o(context2, "pref", "dnma", optInt5);
                                                            return true;
                                                        } catch (Throwable unused8) {
                                                            return true;
                                                        }
                                                    }
                                                }
                                            } catch (Throwable th8) {
                                                th = th8;
                                                context2 = context;
                                                bvz.O000000o(th, "AuthUtil", "loadConfigDataNewCollectionOffline");
                                                optJSONObject2 = jSONObject.optJSONObject("15O");
                                                if (optJSONObject2 != null) {
                                                }
                                                optJSONObject = jSONObject.optJSONObject("15U");
                                                if (optJSONObject != null) {
                                                }
                                                if (context2 == null) {
                                                }
                                            }
                                        }
                                        context2 = context;
                                        optJSONObject2 = jSONObject.optJSONObject("15O");
                                        if (optJSONObject2 != null) {
                                        }
                                        optJSONObject = jSONObject.optJSONObject("15U");
                                        if (optJSONObject != null) {
                                        }
                                        return context2 == null ? true : true;
                                    }
                                }
                            }
                            z = true;
                            optJSONArray2 = jSONObject3.optJSONArray("l");
                            i = 0;
                            while (i < optJSONArray2.length()) {
                            }
                            str2 = str6;
                            try {
                                optJSONArray3 = jSONObject3.optJSONArray("sl");
                                if (optJSONArray3 != null) {
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                bvz.O000000o(th, "AuthUtil", "loadConfigData_otherServiceList");
                                jSONObject2 = o000000o3.O0000Oo0;
                                if (jSONObject2 != null) {
                                }
                                jSONObject = o000000o3.O0000oo;
                                if (jSONObject != null) {
                                }
                                context2 = context;
                                optJSONObject2 = jSONObject.optJSONObject("15O");
                                if (optJSONObject2 != null) {
                                }
                                optJSONObject = jSONObject.optJSONObject("15U");
                                if (optJSONObject != null) {
                                }
                                if (context2 == null) {
                                }
                            }
                            jSONObject2 = o000000o3.O0000Oo0;
                            if (jSONObject2 != null) {
                            }
                            jSONObject = o000000o3.O0000oo;
                            if (jSONObject != null) {
                            }
                            context2 = context;
                            optJSONObject2 = jSONObject.optJSONObject("15O");
                            if (optJSONObject2 != null) {
                            }
                            optJSONObject = jSONObject.optJSONObject("15U");
                            if (optJSONObject != null) {
                            }
                            if (context2 == null) {
                            }
                        }
                        str2 = str6;
                        jSONObject2 = o000000o3.O0000Oo0;
                        if (jSONObject2 != null) {
                        }
                        jSONObject = o000000o3.O0000oo;
                        if (jSONObject != null) {
                        }
                        context2 = context;
                        optJSONObject2 = jSONObject.optJSONObject("15O");
                        if (optJSONObject2 != null) {
                        }
                        optJSONObject = jSONObject.optJSONObject("15U");
                        if (optJSONObject != null) {
                        }
                        if (context2 == null) {
                        }
                    }
                }
            }
            str = "count";
        } catch (Throwable th10) {
            th = th10;
            str = "count";
            bvz.O000000o(th, "AuthUtil", "loadConfigDataCallAMapSer");
            jSONObject7 = o000000o3.O0000OoO;
            if (jSONObject7 != null) {
            }
            o000000o2 = o000000o3.O0000ooO;
            if (o000000o2 != null) {
            }
            jSONObject6 = o000000o3.O0000o00;
            O000000o2 = O000000o(jSONObject6, "fs");
            if (O000000o2 != null) {
            }
            O000000o3 = O000000o(jSONObject6, "us");
            if (O000000o3 != null) {
            }
            O000000o4 = O000000o(jSONObject6, "rs");
            if (O000000o4 != null) {
            }
            jSONObject5 = o000000o3.O0000o0O;
            if (jSONObject5 != null) {
            }
            jSONObject4 = o000000o3.O0000o0o;
            if (jSONObject4 != null) {
            }
            jSONObject3 = o000000o3.O0000Oo;
            if (jSONObject3 != null) {
            }
            str2 = str6;
            jSONObject2 = o000000o3.O0000Oo0;
            if (jSONObject2 != null) {
            }
            jSONObject = o000000o3.O0000oo;
            if (jSONObject != null) {
            }
            context2 = context;
            optJSONObject2 = jSONObject.optJSONObject("15O");
            if (optJSONObject2 != null) {
            }
            optJSONObject = jSONObject.optJSONObject("15U");
            if (optJSONObject != null) {
            }
            if (context2 == null) {
            }
        }
        jSONObject7 = o000000o3.O0000OoO;
        if (jSONObject7 != null) {
        }
        try {
            o000000o2 = o000000o3.O0000ooO;
            if (o000000o2 != null) {
            }
        } catch (Throwable th11) {
            bvz.O000000o(th11, "AuthUtil", "loadConfigDataUploadException");
        }
        try {
            jSONObject6 = o000000o3.O0000o00;
            O000000o2 = O000000o(jSONObject6, "fs");
            if (O000000o2 != null) {
            }
        } catch (Throwable th12) {
            bvz.O000000o(th12, "AuthUtil", "loadConfigDataLocate");
        }
        O000000o3 = O000000o(jSONObject6, "us");
        if (O000000o3 != null) {
        }
        O000000o4 = O000000o(jSONObject6, "rs");
        if (O000000o4 != null) {
        }
        try {
            jSONObject5 = o000000o3.O0000o0O;
            if (jSONObject5 != null) {
            }
        } catch (Throwable th13) {
            bvz.O000000o(th13, "AuthUtil", "loadConfigDataNgps");
        }
        try {
            jSONObject4 = o000000o3.O0000o0o;
            if (jSONObject4 != null) {
            }
        } catch (Throwable th14) {
            bvz.O000000o(th14, "AuthUtil", "loadConfigDataCacheAble");
        }
        try {
            jSONObject3 = o000000o3.O0000Oo;
            if (jSONObject3 != null) {
            }
            str2 = str6;
        } catch (Throwable th15) {
            th = th15;
            str2 = str6;
            bvz.O000000o(th, "AuthUtil", "loadConfigData_otherServiceList");
            jSONObject2 = o000000o3.O0000Oo0;
            if (jSONObject2 != null) {
            }
            jSONObject = o000000o3.O0000oo;
            if (jSONObject != null) {
            }
            context2 = context;
            optJSONObject2 = jSONObject.optJSONObject("15O");
            if (optJSONObject2 != null) {
            }
            optJSONObject = jSONObject.optJSONObject("15U");
            if (optJSONObject != null) {
            }
            if (context2 == null) {
            }
        }
        try {
            jSONObject2 = o000000o3.O0000Oo0;
            if (jSONObject2 != null) {
            }
        } catch (Throwable th16) {
            bvz.O000000o(th16, "AuthUtil", "loadConfigDataGpsGeoAble");
        }
        jSONObject = o000000o3.O0000oo;
        if (jSONObject != null) {
        }
        context2 = context;
        try {
            optJSONObject2 = jSONObject.optJSONObject("15O");
            if (optJSONObject2 != null) {
            }
        } catch (Throwable unused9) {
        }
        try {
            optJSONObject = jSONObject.optJSONObject("15U");
            if (optJSONObject != null) {
            }
        } catch (Throwable unused10) {
        }
        if (context2 == null) {
        }
    }

    public static int O00000Oo() {
        return O0000o0O;
    }

    public static boolean O00000Oo(long j) {
        if (!O000OO00) {
            return false;
        }
        long O00000Oo2 = bwi.O00000Oo() - j;
        long j2 = O000OO0o;
        return j2 < 0 || O00000Oo2 < j2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, long):long
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, long):long */
    public static boolean O00000Oo(Context context) {
        if (!O0000ooo) {
            return false;
        }
        if (O00oOooO == -1 || O00oOooo == 0) {
            return true;
        }
        if (!bwi.O00000Oo(O00oOooo, bwg.O00000Oo(context, "pref", "nowtime", 0L))) {
            O0000OOo(context);
            bwg.O000000o(context, "pref", "count", 1);
            return true;
        }
        int O00000Oo2 = bwg.O00000Oo(context, "pref", "count", 0);
        if (O00000Oo2 >= O00oOooO) {
            return false;
        }
        bwg.O000000o(context, "pref", "count", O00000Oo2 + 1);
        return true;
    }

    public static int O00000o() {
        return O0000o;
    }

    public static void O00000o(Context context) {
        try {
            O0000oO = bwg.O00000Oo(context, "pref", "exception", O0000oO);
            O00000oO(context);
        } catch (Throwable th) {
            bvz.O000000o(th, "AuthUtil", "loadLastAbleState p1");
        }
        try {
            O0000oOO = bwg.O00000Oo(context, "pref", "fn", O0000oOO);
            O0000oOo = bwg.O00000Oo(context, "pref", "mpn", O0000oOo);
            O0000oo0 = bwg.O00000Oo(context, "pref", "igu", O0000oo0);
            O0000oo = bwg.O00000Oo(context, "pref", "ms", O0000oo);
            btf.O000000o(O0000oOO, O0000oo0, O0000oo);
        } catch (Throwable unused) {
        }
        try {
            O000OO00 = bwg.O00000Oo(context, "pref", "ca", O000OO00);
            O000OO0o = bwg.O00000Oo(context, "pref", "ct", O000OO0o);
        } catch (Throwable unused2) {
        }
        try {
            O0000OOo = bwg.O00000Oo(context, "pref", "fr", O0000OOo);
        } catch (Throwable unused3) {
        }
        try {
            O00O0Oo = bwg.O00000Oo(context, "pref", "ok0", O00O0Oo);
            O000OoO = bwg.O00000Oo(context, "pref", "ok2", O000OoO);
            O000OoOO = bwg.O00000Oo(context, "pref", "ok3", O000OoOO);
        } catch (Throwable unused4) {
        }
        try {
            O000Ooo0 = bwg.O00000Oo(context, "pref", "asw", O000Ooo0);
        } catch (Throwable unused5) {
        }
        try {
            O000Ooo = bwg.O00000Oo(context, "pref", "awsi", O000Ooo);
        } catch (Throwable unused6) {
        }
        try {
            O000OooO = bwg.O00000Oo(context, "pref", "15ua", O000OooO);
            O000Oooo = bwg.O00000Oo(context, "pref", "15un", O000Oooo);
            O000o000 = bwg.O00000Oo(context, "pref", "15ust", O000o000);
        } catch (Throwable unused7) {
        }
    }

    public static boolean O00000o0() {
        return O0000o0o;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, long):long
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, long):long */
    public static boolean O00000o0(Context context) {
        if (!O000O0OO) {
            return false;
        }
        if (O000O0Oo == -1 || O00oOoOo == 0) {
            return true;
        }
        if (!bwi.O00000Oo(O00oOoOo, bwg.O00000Oo(context, "pref", "pushSerTime", 0L))) {
            O0000Oo0(context);
            bwg.O000000o(context, "pref", "pushCount", 1);
            return true;
        }
        int O00000Oo2 = bwg.O00000Oo(context, "pref", "pushCount", 0);
        if (O00000Oo2 >= O000O0Oo) {
            return false;
        }
        bwg.O000000o(context, "pref", "pushCount", O00000Oo2 + 1);
        return true;
    }

    public static void O00000oO(Context context) {
        try {
            brr O00000Oo2 = bvz.O00000Oo();
            O00000Oo2.O000000o(O0000oO);
            bsf.O000000o(context, O00000Oo2);
        } catch (Throwable unused) {
        }
    }

    public static boolean O00000oO() {
        return O0000oO0;
    }

    public static boolean O00000oo() {
        return O00000Oo;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, long):long
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
      _m_j.bwg.O00000Oo(android.content.Context, java.lang.String, java.lang.String, long):long */
    public static boolean O00000oo(Context context) {
        Context context2 = context;
        int i = O000OOo;
        boolean z = i != -1 && i < O000OOoO;
        if (!O000OOOo || O000OOo == 0 || O000OOoO == 0 || O000OOo0 == 0 || z) {
            return false;
        }
        List<String> list = O000OOoo;
        if (list != null && list.size() > 0) {
            for (String O00000Oo2 : O000OOoo) {
                if (bwi.O00000Oo(context2, O00000Oo2)) {
                    return false;
                }
            }
        }
        if (O000OOo == -1 && O000OOoO == -1) {
            return true;
        }
        long O00000Oo3 = bwg.O00000Oo(context2, "pref", "ots", 0L);
        long O00000Oo4 = bwg.O00000Oo(context2, "pref", "otsh", 0L);
        int O00000Oo5 = bwg.O00000Oo(context2, "pref", "otn", 0);
        int O00000Oo6 = bwg.O00000Oo(context2, "pref", "otnh", 0);
        if (O000OOo != -1) {
            if (!bwi.O00000Oo(O000OOo0, O00000Oo3)) {
                try {
                    SharedPreferences.Editor edit = context2.getSharedPreferences("pref", 0).edit();
                    edit.putLong("ots", O000OOo0);
                    edit.putLong("otsh", O000OOo0);
                    edit.putInt("otn", 0);
                    edit.putInt("otnh", 0);
                    bwg.O000000o(edit);
                } catch (Throwable th) {
                    bvz.O000000o(th, "AuthUtil", "resetPrefsBind");
                }
                bwg.O000000o(context2, "pref", "otn", 1);
                bwg.O000000o(context2, "pref", "otnh", 1);
                return true;
            } else if (O00000Oo5 < O000OOo) {
                if (O000OOoO == -1) {
                    bwg.O000000o(context2, "pref", "otn", O00000Oo5 + 1);
                    bwg.O000000o(context2, "pref", "otnh", 0);
                    return true;
                } else if (!bwi.O000000o(O000OOo0, O00000Oo4)) {
                    bwg.O000000o(context2, "pref", "otsh", O000OOo0);
                    bwg.O000000o(context2, "pref", "otn", O00000Oo5 + 1);
                    bwg.O000000o(context2, "pref", "otnh", 1);
                    return true;
                } else if (O00000Oo6 < O000OOoO) {
                    bwg.O000000o(context2, "pref", "otn", O00000Oo5 + 1);
                    bwg.O000000o(context2, "pref", "otnh", O00000Oo6 + 1);
                    return true;
                }
            }
        }
        if (O000OOo != -1) {
            return false;
        }
        bwg.O000000o(context2, "pref", "otn", 0);
        if (O000OOoO == -1) {
            bwg.O000000o(context2, "pref", "otnh", 0);
            return true;
        } else if (!bwi.O000000o(O000OOo0, O00000Oo4)) {
            bwg.O000000o(context2, "pref", "otsh", O000OOo0);
            bwg.O000000o(context2, "pref", "otnh", 1);
            return true;
        } else if (O00000Oo6 >= O000OOoO) {
            return false;
        } else {
            bwg.O000000o(context2, "pref", "otnh", O00000Oo6 + 1);
            return true;
        }
    }

    public static ArrayList<String> O0000O0o() {
        return O000O00o;
    }

    public static boolean O0000O0o(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (bwi.O00000o0() - O00000oo >= ((long) O00000o)) {
                O0000O0o = true;
                return true;
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "Aps", "isConfigNeedUpdate");
        }
        return false;
    }

    public static ArrayList<String> O0000OOo() {
        return O000O0o0;
    }

    private static void O0000OOo(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pref", 0).edit();
            edit.putLong("nowtime", O00oOooo);
            edit.putInt("count", 0);
            bwg.O000000o(edit);
        } catch (Throwable th) {
            bvz.O000000o(th, "AuthUtil", "resetPrefsBind");
        }
    }

    public static int O0000Oo() {
        return O0000oOo;
    }

    private static void O0000Oo0(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pref", 0).edit();
            edit.putLong("pushSerTime", O00oOoOo);
            edit.putInt("pushCount", 0);
            bwg.O000000o(edit);
        } catch (Throwable th) {
            bvz.O000000o(th, "AuthUtil", "resetPrefsBind");
        }
    }

    public static boolean O0000Oo0() {
        return O0000oO;
    }

    public static boolean O0000OoO() {
        return O0000ooO;
    }

    public static void O0000Ooo() {
        O0000ooO = false;
    }

    public static boolean O0000o() {
        return O000Oo00;
    }

    public static long O0000o0() {
        return O000OO0o;
    }

    public static boolean O0000o00() {
        return O000O0o;
    }

    public static boolean O0000o0O() {
        return O000OO00;
    }

    public static List<bwc> O0000o0o() {
        return O000OO;
    }

    public static boolean O0000oO() {
        return O000Oo0o;
    }

    public static int O0000oO0() {
        return O000Oo0;
    }

    public static boolean O0000oOO() {
        return O000OoO0;
    }

    public static boolean O0000oOo() {
        boolean z = O0000O0o;
        if (!z) {
            return z;
        }
        O0000O0o = false;
        return true;
    }

    public static boolean O0000oo() {
        return O00O0Oo;
    }

    public static boolean O0000oo0() {
        return O0000OOo;
    }

    public static boolean O0000ooO() {
        return O000OoOO;
    }

    public static boolean O0000ooo() {
        return O000OoO;
    }

    public static long O000O00o() {
        return O000Ooo;
    }

    public static boolean O000O0OO() {
        return O000OooO && O000Oooo > 0;
    }

    public static int O000O0Oo() {
        return O000Oooo;
    }

    public static long O00oOoOo() {
        return O000o000;
    }

    public static int O00oOooO() {
        return O000OoOo;
    }

    public static boolean O00oOooo() {
        return O000Ooo0;
    }
}
