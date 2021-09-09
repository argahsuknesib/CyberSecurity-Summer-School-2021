package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.elh;
import _m_j.elk;
import _m_j.elz;
import _m_j.emd;
import _m_j.emf;
import _m_j.eml;
import _m_j.eqc;
import _m_j.erv;
import _m_j.esl;
import _m_j.est;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.push.r;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

public class o {

    /* renamed from: a  reason: collision with root package name */
    private static n f6570a;

    /* renamed from: a  reason: collision with other field name */
    private static a f342a;

    public interface a {
        void a();
    }

    private static int a(Context context) {
        return context.getSharedPreferences("mipush_account", 0).getInt("enc_req_fail_count", 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a5, code lost:
        return null;
     */
    /* renamed from: a  reason: collision with other method in class */
    public static synchronized n m222a(Context context) {
        synchronized (o.class) {
            if (f6570a != null) {
                n nVar = f6570a;
                return nVar;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
            String string = sharedPreferences.getString("uuid", null);
            String string2 = sharedPreferences.getString("token", null);
            String string3 = sharedPreferences.getString("security", null);
            String string4 = sharedPreferences.getString("app_id", null);
            String string5 = sharedPreferences.getString("app_token", null);
            String string6 = sharedPreferences.getString("package_name", null);
            String string7 = sharedPreferences.getString("device_id", null);
            int i = sharedPreferences.getInt("env_type", 1);
            if (!TextUtils.isEmpty(string7) && erv.O000000o(string7)) {
                string7 = erv.O0000OOo(context);
                sharedPreferences.edit().putString("device_id", string7).commit();
            }
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                String O0000OOo = erv.O0000OOo(context);
                if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(O0000OOo) && !TextUtils.isEmpty(string7) && !string7.equals(O0000OOo)) {
                    duv.O000000o("read_phone_state permission changes.");
                }
                n nVar2 = new n(string, string2, string3, string4, string5, string6, i);
                f6570a = nVar2;
                return nVar2;
            }
        }
    }

    private static String a(Context context, boolean z) {
        if (elk.f15608O000000o && esl.O00000Oo(context)) {
            String O000000o2 = est.O000000o("log.tag.debug.xmsf.dr", "");
            if (!TextUtils.isEmpty(O000000o2)) {
                duv.O000000o("[debug] device register url：".concat(String.valueOf(O000000o2)));
                return O000000o2;
            }
        }
        String a2 = a.a(context).a();
        String str = z ? "/pass/v2/register/encrypt" : "/pass/v2/register";
        if (elh.O00000Oo()) {
            return "http://" + eqc.b + ":9085" + str;
        } else if (r.f6460a.name().equals(a2)) {
            return "https://cn.register.xmpush.xiaomi.com".concat(str);
        } else {
            if (r.b.name().equals(a2)) {
                return "https://register.xmpush.global.xiaomi.com".concat(str);
            }
            if (r.c.name().equals(a2)) {
                return "https://fr.register.xmpush.global.xiaomi.com".concat(str);
            }
            if (r.d.name().equals(a2)) {
                return "https://ru.register.xmpush.global.xiaomi.com".concat(str);
            }
            if (r.e.name().equals(a2)) {
                return "https://idmb.register.xmpush.global.xiaomi.com".concat(str);
            }
            StringBuilder sb = new StringBuilder("https://");
            sb.append(elh.O000000o() ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com");
            sb.append(str);
            return sb.toString();
        }
    }

    public static void a() {
        a aVar = f342a;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m223a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        f6570a = null;
        a();
    }

    private static void a(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putInt("enc_req_fail_count", i);
        edit.commit();
    }

    public static void a(Context context, n nVar) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", nVar.f341a);
        edit.putString("security", nVar.c);
        edit.putString("token", nVar.b);
        edit.putString("app_id", nVar.d);
        edit.putString("package_name", nVar.f);
        edit.putString("app_token", nVar.e);
        edit.putString("device_id", erv.O0000OOo(context));
        edit.putInt("env_type", nVar.f6569a);
        edit.commit();
        a();
    }

    public static void a(a aVar) {
        f342a = aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m224a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.erv.O000000o(android.content.Context, boolean):java.lang.String
     arg types: [android.content.Context, int]
     candidates:
      _m_j.erv.O000000o(android.content.Context, java.lang.String):void
      _m_j.erv.O000000o(android.content.Context, java.util.Map<java.lang.String, java.lang.String>):void
      _m_j.erv.O000000o(android.content.Context, boolean):java.lang.String */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0056 A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0065 A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0070 A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0074 A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007c A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0080 A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0088 A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008c A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ac A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b3 A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00dd A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x014e A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x018f A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01f3 A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0236 A[SYNTHETIC, Splitter:B:85:0x0236] */
    public static synchronized n a(Context context, String str, String str2, String str3) {
        String str4;
        String O00000Oo;
        String O000000o2;
        PackageInfo packageInfo;
        int O000000o3;
        boolean z;
        emd emd;
        boolean z2;
        String str5;
        String concat;
        n nVar;
        Context context2 = context;
        synchronized (o.class) {
            TreeMap treeMap = new TreeMap();
            treeMap.put("devid", erv.O000000o(context2, false));
            if (f6570a != null && !TextUtils.isEmpty(f6570a.f341a)) {
                treeMap.put("uuid", f6570a.f341a);
                int lastIndexOf = f6570a.f341a.lastIndexOf("/");
                if (lastIndexOf != -1) {
                    str4 = f6570a.f341a.substring(lastIndexOf + 1);
                    elz.O000000o(context).O000000o(treeMap);
                    O00000Oo = erv.O00000Oo(context);
                    if (!TextUtils.isEmpty(O00000Oo)) {
                        treeMap.put("vdevid", O00000Oo);
                    }
                    O000000o2 = erv.O000000o(context);
                    if (!TextUtils.isEmpty(O000000o2)) {
                        treeMap.put("gaid", O000000o2);
                    }
                    String str6 = !m224a(context) ? "1000271" : str2;
                    String str7 = !m224a(context) ? "420100086271" : str3;
                    String str8 = !m224a(context) ? "com.xiaomi.xmsf" : str;
                    treeMap.put("appid", str6);
                    treeMap.put("apptoken", str7);
                    packageInfo = context.getPackageManager().getPackageInfo(str8, 16384);
                    treeMap.put("appversion", packageInfo == null ? String.valueOf(packageInfo.versionCode) : "0");
                    treeMap.put("sdkversion", Integer.toString(40020));
                    treeMap.put("packagename", str8);
                    treeMap.put("model", Build.MODEL);
                    treeMap.put("board", Build.BOARD);
                    if (!esl.O00000oo()) {
                        String str9 = "";
                        String O00000o = erv.O00000o(context);
                        if (!TextUtils.isEmpty(O00000o)) {
                            str9 = str9 + eml.O000000o(O00000o);
                        }
                        String O00000oo = erv.O00000oo(context);
                        if (!TextUtils.isEmpty(str9) && !TextUtils.isEmpty(O00000oo)) {
                            str9 = str9 + "," + O00000oo;
                        }
                        if (!TextUtils.isEmpty(str9)) {
                            treeMap.put("imei_md5", str9);
                        }
                    }
                    treeMap.put("os", Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
                    O000000o3 = erv.O000000o();
                    if (O000000o3 >= 0) {
                        treeMap.put("space_id", Integer.toString(O000000o3));
                    }
                    treeMap.put("brand", Build.BRAND);
                    treeMap.put("ram", erv.O00000Oo());
                    treeMap.put("rom", erv.O00000o0());
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry entry : treeMap.entrySet()) {
                        try {
                            jSONObject.put((String) entry.getKey(), entry.getValue());
                        } catch (JSONException e) {
                            duv.O00000o("failed to add data in json format: k=" + ((String) entry.getKey()) + ",v=" + ((String) entry.getValue()) + ". " + e);
                        }
                    }
                    String a2 = bl.a(jSONObject.toString());
                    TreeMap treeMap2 = new TreeMap();
                    treeMap2.put("requestData", a2);
                    treeMap2.put("keyPairVer", "1");
                    if (a(context) < 2) {
                        if (!TextUtils.isEmpty(a2)) {
                            duv.O000000o("r.data = ".concat(String.valueOf(a2)));
                            z = true;
                            String a3 = a(context2, z);
                            if (z) {
                                treeMap = treeMap2;
                            }
                            emd = emf.O000000o(context2, a3, treeMap);
                            if (emd != null && emd.f15623O000000o == 200) {
                                str5 = emd.O00000o0;
                                if (!TextUtils.isEmpty(str5)) {
                                    try {
                                        JSONObject jSONObject2 = new JSONObject(str5);
                                        if (jSONObject2.getInt("code") == 0) {
                                            JSONObject jSONObject3 = jSONObject2.getJSONObject("data");
                                            String string = jSONObject3.getString("ssecurity");
                                            String string2 = jSONObject3.getString("token");
                                            String string3 = jSONObject3.getString("userId");
                                            if (TextUtils.isEmpty(str4)) {
                                                str4 = "an" + eml.O000000o(6);
                                            }
                                            n nVar2 = nVar;
                                            z2 = z;
                                            try {
                                                nVar = new n(string3 + "@xiaomi.com/" + str4, string2, string, str6, str7, str8, elh.O00000o0());
                                                a(context2, nVar2);
                                                erv.O000000o(context2, jSONObject3.optString("vdevid"));
                                                f6570a = nVar2;
                                                a(context2, 0);
                                                duv.O000000o("device registration is successful. ".concat(String.valueOf(string3)));
                                                return nVar2;
                                            } catch (JSONException e2) {
                                                e = e2;
                                            } catch (Throwable th) {
                                                th = th;
                                                concat = "unknow throwable. ".concat(String.valueOf(th));
                                                duv.O00000o(concat);
                                                a(context2, a(context) + 1);
                                                duv.O000000o("fail to register push account. meet error.");
                                                return null;
                                            }
                                        } else {
                                            z2 = z;
                                            r.a(context2, jSONObject2.getInt("code"), jSONObject2.optString("description"));
                                            duv.O000000o("device registration resp: ".concat(String.valueOf(str5)));
                                            if (z2 && emf.O00000Oo(context)) {
                                                a(context2, a(context) + 1);
                                            }
                                            duv.O000000o("fail to register push account. meet error.");
                                            return null;
                                        }
                                    } catch (JSONException e3) {
                                        e = e3;
                                        z2 = z;
                                        concat = "failed to parse respone json data. ".concat(String.valueOf(e));
                                        duv.O00000o(concat);
                                        a(context2, a(context) + 1);
                                        duv.O000000o("fail to register push account. meet error.");
                                        return null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z2 = z;
                                        concat = "unknow throwable. ".concat(String.valueOf(th));
                                        duv.O00000o(concat);
                                        a(context2, a(context) + 1);
                                        duv.O000000o("fail to register push account. meet error.");
                                        return null;
                                    }
                                }
                            }
                            z2 = z;
                            a(context2, a(context) + 1);
                            duv.O000000o("fail to register push account. meet error.");
                            return null;
                        }
                    }
                    z = false;
                    String a32 = a(context2, z);
                    if (z) {
                    }
                    emd = emf.O000000o(context2, a32, treeMap);
                    str5 = emd.O00000o0;
                    if (!TextUtils.isEmpty(str5)) {
                    }
                    z2 = z;
                    a(context2, a(context) + 1);
                    duv.O000000o("fail to register push account. meet error.");
                    return null;
                }
            }
            str4 = null;
            elz.O000000o(context).O000000o(treeMap);
            O00000Oo = erv.O00000Oo(context);
            if (!TextUtils.isEmpty(O00000Oo)) {
            }
            O000000o2 = erv.O000000o(context);
            if (!TextUtils.isEmpty(O000000o2)) {
            }
            if (!m224a(context)) {
            }
            if (!m224a(context)) {
            }
            if (!m224a(context)) {
            }
            treeMap.put("appid", str6);
            treeMap.put("apptoken", str7);
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str8, 16384);
            } catch (Exception e4) {
                duv.O000000o(e4);
                packageInfo = null;
            }
            treeMap.put("appversion", packageInfo == null ? String.valueOf(packageInfo.versionCode) : "0");
            treeMap.put("sdkversion", Integer.toString(40020));
            treeMap.put("packagename", str8);
            treeMap.put("model", Build.MODEL);
            treeMap.put("board", Build.BOARD);
            if (!esl.O00000oo()) {
            }
            treeMap.put("os", Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
            O000000o3 = erv.O000000o();
            if (O000000o3 >= 0) {
            }
            treeMap.put("brand", Build.BRAND);
            treeMap.put("ram", erv.O00000Oo());
            treeMap.put("rom", erv.O00000o0());
            JSONObject jSONObject4 = new JSONObject();
            while (r9.hasNext()) {
            }
            String a22 = bl.a(jSONObject4.toString());
            TreeMap treeMap22 = new TreeMap();
            treeMap22.put("requestData", a22);
            treeMap22.put("keyPairVer", "1");
            if (a(context) < 2) {
            }
            z = false;
            String a322 = a(context2, z);
            if (z) {
            }
            try {
                emd = emf.O000000o(context2, a322, treeMap);
            } catch (IOException e5) {
                duv.O00000o("device registration request failed. ".concat(String.valueOf(e5)));
                emd = null;
            }
            str5 = emd.O00000o0;
            if (!TextUtils.isEmpty(str5)) {
            }
            z2 = z;
            a(context2, a(context) + 1);
            duv.O000000o("fail to register push account. meet error.");
            return null;
        }
    }
}
