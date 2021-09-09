package com.amap.api.services.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public class bq {

    /* renamed from: a  reason: collision with root package name */
    public static int f3341a = -1;
    public static String b = "";

    public static class a {
        @Deprecated
        public c A;
        public c B;
        public b C;
        public b D;
        public b E;
        public b F;
        public f G;
        /* access modifiers changed from: private */
        public boolean H;

        /* renamed from: a  reason: collision with root package name */
        public String f3342a;
        public int b = -1;
        @Deprecated
        public JSONObject c;
        @Deprecated
        public JSONObject d;
        @Deprecated
        public JSONObject e;
        @Deprecated
        public JSONObject f;
        @Deprecated
        public JSONObject g;
        @Deprecated
        public JSONObject h;
        @Deprecated
        public JSONObject i;
        @Deprecated
        public JSONObject j;
        @Deprecated
        public JSONObject k;
        @Deprecated
        public JSONObject l;
        @Deprecated
        public JSONObject m;
        @Deprecated
        public JSONObject n;
        @Deprecated
        public JSONObject o;
        @Deprecated
        public JSONObject p;
        @Deprecated
        public JSONObject q;
        @Deprecated
        public JSONObject r;
        @Deprecated
        public JSONObject s;
        @Deprecated
        public JSONObject t;
        @Deprecated
        public JSONObject u;
        @Deprecated
        public JSONObject v;
        public JSONObject w;
        public C0022a x;
        public d y;
        public e z;

        /* renamed from: com.amap.api.services.a.bq$a$a  reason: collision with other inner class name */
        public static class C0022a {

            /* renamed from: a  reason: collision with root package name */
            public boolean f3343a;
            public boolean b;
            public JSONObject c;
        }

        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public boolean f3344a;
            public String b;
            public String c;
            public String d;
            public boolean e;
        }

        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public String f3345a;
            public String b;
        }

        public static class d {

            /* renamed from: a  reason: collision with root package name */
            public String f3346a;
            public String b;
            public String c;
        }

        public static class e {

            /* renamed from: a  reason: collision with root package name */
            public boolean f3347a;
        }

        public static class f {

            /* renamed from: a  reason: collision with root package name */
            public boolean f3348a;
            public boolean b;
            public boolean c;
            public String d;
            public String e;
            public String f;
        }
    }

    public static boolean a(String str, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return z;
            }
            String[] split = URLDecoder.decode(str).split("/");
            if (split[split.length - 1].charAt(4) % 2 == 1) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return z;
        }
    }

    public static a a(Context context, by byVar, String str, Map<String, String> map) {
        return a(context, byVar, str, map, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.bq.a(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      com.amap.api.services.a.bq.a(org.json.JSONObject, java.lang.String):java.lang.String
      com.amap.api.services.a.bq.a(android.content.Context, org.json.JSONObject):void
      com.amap.api.services.a.bq.a(com.amap.api.services.a.bq$a, org.json.JSONObject):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$b):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$c):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$d):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$e):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$f):void
      com.amap.api.services.a.bq.a(java.lang.String, boolean):boolean */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0139, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x013a, code lost:
        r16 = "11K";
        r18 = "16H";
        r19 = "result";
        r14 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0148, code lost:
        r16 = "11K";
        r18 = "16H";
        r19 = "result";
        r14 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0153, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0154, code lost:
        r16 = "11K";
        r18 = "16H";
        r19 = "result";
        r14 = r22;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x016b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[ExcHandler: IllegalBlockSizeException (unused javax.crypto.IllegalBlockSizeException), SYNTHETIC, Splitter:B:1:0x002b] */
    public static a a(Context context, by byVar, String str, Map<String, String> map, boolean z) {
        String str2;
        String str3;
        String str4;
        byte[] bArr;
        String str5;
        String str6;
        dh dhVar;
        String str7;
        dh dhVar2;
        String str8;
        byte[] bArr2;
        Context context2 = context;
        by byVar2 = byVar;
        a aVar = new a();
        aVar.w = new JSONObject();
        bv.a().a(context2);
        try {
            db dbVar = new db();
            String str9 = str + ";14N;15K;16H";
            try {
                str4 = "11K";
                try {
                    b bVar = new b(context2, byVar2, str9, map);
                    dhVar = dbVar.a(bVar, bVar.a());
                    if (dhVar != null) {
                        try {
                            bArr = dhVar.f3399a;
                        } catch (bo e) {
                            e = e;
                            str3 = "16H";
                            str2 = "result";
                            bArr = null;
                            aVar.f3342a = e.a();
                            cl.a(byVar2, "/v3/iasdkauth", e);
                            str6 = str9;
                            str5 = null;
                            if (bArr != null) {
                            }
                        } catch (IllegalBlockSizeException unused) {
                            str3 = "16H";
                            str2 = "result";
                            bArr = null;
                            str6 = str9;
                            str5 = null;
                            if (bArr != null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            str3 = "16H";
                            str2 = "result";
                            bArr = null;
                            cl.c(th, "at", "lc");
                            str6 = str9;
                            str5 = null;
                            if (bArr != null) {
                            }
                        }
                    } else {
                        bArr = null;
                    }
                    dhVar2 = dhVar;
                } catch (bo e2) {
                    e = e2;
                    throw e;
                } catch (IllegalBlockSizeException unused2) {
                    str3 = "16H";
                    str2 = "result";
                    str7 = str9;
                    String str10 = str7;
                    dhVar = null;
                    bArr = null;
                    str6 = str9;
                    str5 = null;
                    if (bArr != null) {
                    }
                } catch (Throwable unused3) {
                    str3 = "16H";
                    str2 = "result";
                    str7 = str9;
                    try {
                        throw new bo("未知的错误");
                    } catch (bo e3) {
                        e = e3;
                        String str11 = str7;
                        dhVar = null;
                        bArr = null;
                        aVar.f3342a = e.a();
                        cl.a(byVar2, "/v3/iasdkauth", e);
                        str6 = str9;
                        str5 = null;
                        if (bArr != null) {
                        }
                    } catch (IllegalBlockSizeException unused4) {
                        String str102 = str7;
                        dhVar = null;
                        bArr = null;
                        str6 = str9;
                        str5 = null;
                        if (bArr != null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        str9 = str7;
                        dhVar = null;
                        bArr = null;
                        cl.c(th, "at", "lc");
                        str6 = str9;
                        str5 = null;
                        if (bArr != null) {
                        }
                    }
                }
                try {
                    byte[] bArr3 = new byte[16];
                    str8 = str9;
                    try {
                        bArr2 = new byte[(bArr.length - 16)];
                        str3 = "16H";
                        try {
                            System.arraycopy(bArr, 0, bArr3, 0, 16);
                            str2 = "result";
                        } catch (bo e4) {
                            e = e4;
                            str2 = "result";
                            dhVar = dhVar2;
                            str9 = str8;
                            aVar.f3342a = e.a();
                            cl.a(byVar2, "/v3/iasdkauth", e);
                            str6 = str9;
                            str5 = null;
                            if (bArr != null) {
                            }
                        } catch (IllegalBlockSizeException unused5) {
                            str2 = "result";
                            dhVar = dhVar2;
                            str9 = str8;
                            str6 = str9;
                            str5 = null;
                            if (bArr != null) {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            str2 = "result";
                            dhVar = dhVar2;
                            str9 = str8;
                            cl.c(th, "at", "lc");
                            str6 = str9;
                            str5 = null;
                            if (bArr != null) {
                            }
                        }
                    } catch (bo e5) {
                        e = e5;
                        str3 = "16H";
                        str2 = "result";
                        dhVar = dhVar2;
                        str9 = str8;
                        aVar.f3342a = e.a();
                        cl.a(byVar2, "/v3/iasdkauth", e);
                        str6 = str9;
                        str5 = null;
                        if (bArr != null) {
                        }
                    } catch (IllegalBlockSizeException unused6) {
                        str3 = "16H";
                        str2 = "result";
                        dhVar = dhVar2;
                        str9 = str8;
                        str6 = str9;
                        str5 = null;
                        if (bArr != null) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        str3 = "16H";
                        str2 = "result";
                        dhVar = dhVar2;
                        str9 = str8;
                        cl.c(th, "at", "lc");
                        str6 = str9;
                        str5 = null;
                        if (bArr != null) {
                        }
                    }
                    try {
                        System.arraycopy(bArr, 16, bArr2, 0, bArr.length - 16);
                        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr3, "AES");
                        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                        instance.init(2, secretKeySpec, new IvParameterSpec(bz.c()));
                        str5 = bz.a(instance.doFinal(bArr2));
                        dhVar = dhVar2;
                        str6 = str8;
                    } catch (bo e6) {
                        e = e6;
                        dhVar = dhVar2;
                        str9 = str8;
                        aVar.f3342a = e.a();
                        cl.a(byVar2, "/v3/iasdkauth", e);
                        str6 = str9;
                        str5 = null;
                        if (bArr != null) {
                        }
                    } catch (IllegalBlockSizeException unused7) {
                        dhVar = dhVar2;
                        str9 = str8;
                        str6 = str9;
                        str5 = null;
                        if (bArr != null) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        dhVar = dhVar2;
                        str9 = str8;
                        cl.c(th, "at", "lc");
                        str6 = str9;
                        str5 = null;
                        if (bArr != null) {
                        }
                    }
                } catch (bo e7) {
                    e = e7;
                    str3 = "16H";
                    str2 = "result";
                    dhVar = dhVar2;
                    aVar.f3342a = e.a();
                    cl.a(byVar2, "/v3/iasdkauth", e);
                    str6 = str9;
                    str5 = null;
                    if (bArr != null) {
                    }
                } catch (IllegalBlockSizeException unused8) {
                    str3 = "16H";
                    str2 = "result";
                    str8 = str9;
                    dhVar = dhVar2;
                    str9 = str8;
                    str6 = str9;
                    str5 = null;
                    if (bArr != null) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                    str3 = "16H";
                    str2 = "result";
                    dhVar = dhVar2;
                    cl.c(th, "at", "lc");
                    str6 = str9;
                    str5 = null;
                    if (bArr != null) {
                    }
                }
            } catch (bo e8) {
                e = e8;
                throw e;
            } catch (IllegalBlockSizeException unused9) {
                str4 = "11K";
                str3 = "16H";
                str2 = "result";
                str7 = str9;
                String str1022 = str7;
                dhVar = null;
                bArr = null;
                str6 = str9;
                str5 = null;
                if (bArr != null) {
                }
            } catch (Throwable unused10) {
                str4 = "11K";
                str3 = "16H";
                str2 = "result";
                str7 = str9;
                throw new bo("未知的错误");
            }
        } catch (bo e9) {
            e = e9;
            Object obj = "11K";
            Object obj2 = "16H";
            Object obj3 = "result";
            String str12 = str;
            throw e;
        } catch (IllegalBlockSizeException unused11) {
        } catch (Throwable unused12) {
            str4 = "11K";
            str3 = "16H";
            str2 = "result";
            str7 = str;
            throw new bo("未知的错误");
        }
        if (bArr != null) {
            return aVar;
        }
        if (TextUtils.isEmpty(str5)) {
            str5 = bz.a(bArr);
        }
        try {
            JSONObject jSONObject = new JSONObject(str5);
            if (jSONObject.has("status")) {
                int i = jSONObject.getInt("status");
                if (i == 1) {
                    f3341a = 1;
                } else if (i == 0) {
                    String str13 = "authcsid";
                    String str14 = "authgsid";
                    if (dhVar != null) {
                        str13 = dhVar.c;
                        str14 = dhVar.d;
                    }
                    bz.a(context2, str13, str14, jSONObject);
                    f3341a = 0;
                    if (jSONObject.has("info")) {
                        b = jSONObject.getString("info");
                    }
                    String str15 = "";
                    if (jSONObject.has("infocode")) {
                        str15 = jSONObject.getString("infocode");
                    }
                    cl.a(byVar2, "/v3/iasdkauth", b, str14, str15);
                    if (f3341a == 0) {
                        aVar.f3342a = b;
                        return aVar;
                    }
                }
                if (jSONObject.has("ver")) {
                    aVar.b = jSONObject.getInt("ver");
                }
                String str16 = str2;
                if (bz.a(jSONObject, str16)) {
                    a.C0022a aVar2 = new a.C0022a();
                    aVar2.f3343a = false;
                    aVar2.b = false;
                    aVar.x = aVar2;
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str16);
                    try {
                        String[] split = str6.split(";");
                        if (split != null && split.length > 0) {
                            for (String str17 : split) {
                                if (jSONObject2.has(str17)) {
                                    aVar.w.putOpt(str17, jSONObject2.get(str17));
                                }
                            }
                        }
                    } catch (Throwable th7) {
                        ci.a(th7, "at", "co");
                    }
                    String str18 = str3;
                    if (bz.a(jSONObject2, str18)) {
                        boolean unused13 = aVar.H = a(jSONObject2.getJSONObject(str18).optString("able"), false);
                    }
                    String str19 = str4;
                    if (bz.a(jSONObject2, str19)) {
                        try {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject(str19);
                            aVar2.f3343a = a(jSONObject3.getString("able"), false);
                            if (jSONObject3.has("off")) {
                                aVar2.c = jSONObject3.getJSONObject("off");
                            }
                        } catch (Throwable th8) {
                            ci.a(th8, "AuthConfigManager", "loadException");
                        }
                    }
                    if (bz.a(jSONObject2, "001")) {
                        JSONObject jSONObject4 = jSONObject2.getJSONObject("001");
                        a.d dVar = new a.d();
                        a(jSONObject4, dVar);
                        aVar.y = dVar;
                    }
                    if (bz.a(jSONObject2, "002")) {
                        JSONObject jSONObject5 = jSONObject2.getJSONObject("002");
                        a.c cVar = new a.c();
                        a(jSONObject5, cVar);
                        aVar.A = cVar;
                    }
                    if (bz.a(jSONObject2, "14S")) {
                        JSONObject jSONObject6 = jSONObject2.getJSONObject("14S");
                        a.c cVar2 = new a.c();
                        a(jSONObject6, cVar2);
                        aVar.B = cVar2;
                    }
                    a(aVar, jSONObject2);
                    if (bz.a(jSONObject2, "14Z")) {
                        JSONObject jSONObject7 = jSONObject2.getJSONObject("14Z");
                        a.f fVar = new a.f();
                        a(jSONObject7, fVar);
                        aVar.G = fVar;
                    }
                    if (bz.a(jSONObject2, "151")) {
                        JSONObject jSONObject8 = jSONObject2.getJSONObject("151");
                        a.e eVar = new a.e();
                        a(jSONObject8, eVar);
                        aVar.z = eVar;
                    }
                    a(aVar, jSONObject2);
                    a(context2, jSONObject2);
                }
            }
        } catch (Throwable th9) {
            ci.a(th9, "at", "lc");
        }
        return aVar;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.bq.a(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      com.amap.api.services.a.bq.a(org.json.JSONObject, java.lang.String):java.lang.String
      com.amap.api.services.a.bq.a(android.content.Context, org.json.JSONObject):void
      com.amap.api.services.a.bq.a(com.amap.api.services.a.bq$a, org.json.JSONObject):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$b):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$c):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$d):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$e):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$f):void
      com.amap.api.services.a.bq.a(java.lang.String, boolean):boolean */
    private static void a(Context context, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("15K");
            boolean a2 = a(jSONObject2.optString("isTargetAble"), false);
            if (!a(jSONObject2.optString("able"), false)) {
                bv.a().b(context);
            } else {
                bv.a().a(context, a2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str) && !jSONObject.getString(str).equals("[]")) {
            return jSONObject.optString(str);
        }
        return "";
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.bq.a(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      com.amap.api.services.a.bq.a(org.json.JSONObject, java.lang.String):java.lang.String
      com.amap.api.services.a.bq.a(android.content.Context, org.json.JSONObject):void
      com.amap.api.services.a.bq.a(com.amap.api.services.a.bq$a, org.json.JSONObject):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$b):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$c):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$d):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$e):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$f):void
      com.amap.api.services.a.bq.a(java.lang.String, boolean):boolean */
    private static void a(JSONObject jSONObject, a.b bVar) {
        if (bVar != null) {
            try {
                String a2 = a(jSONObject, "m");
                String a3 = a(jSONObject, "u");
                String a4 = a(jSONObject, "v");
                String a5 = a(jSONObject, "able");
                String a6 = a(jSONObject, "on");
                bVar.c = a2;
                bVar.b = a3;
                bVar.d = a4;
                bVar.f3344a = a(a5, false);
                bVar.e = a(a6, true);
            } catch (Throwable th) {
                ci.a(th, "at", "pe");
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.bq.a(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      com.amap.api.services.a.bq.a(org.json.JSONObject, java.lang.String):java.lang.String
      com.amap.api.services.a.bq.a(android.content.Context, org.json.JSONObject):void
      com.amap.api.services.a.bq.a(com.amap.api.services.a.bq$a, org.json.JSONObject):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$b):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$c):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$d):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$e):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$f):void
      com.amap.api.services.a.bq.a(java.lang.String, boolean):boolean */
    private static void a(JSONObject jSONObject, a.f fVar) {
        if (fVar != null) {
            try {
                String a2 = a(jSONObject, "md5");
                String a3 = a(jSONObject, "md5info");
                String a4 = a(jSONObject, "url");
                String a5 = a(jSONObject, "able");
                String a6 = a(jSONObject, "on");
                String a7 = a(jSONObject, "mobileable");
                fVar.e = a2;
                fVar.f = a3;
                fVar.d = a4;
                fVar.f3348a = a(a5, false);
                fVar.b = a(a6, false);
                fVar.c = a(a7, false);
            } catch (Throwable th) {
                ci.a(th, "at", "pes");
            }
        }
    }

    private static void a(JSONObject jSONObject, a.c cVar) {
        if (jSONObject != null) {
            try {
                String a2 = a(jSONObject, "md5");
                String a3 = a(jSONObject, "url");
                cVar.b = a2;
                cVar.f3345a = a3;
            } catch (Throwable th) {
                ci.a(th, "at", "psc");
            }
        }
    }

    private static void a(JSONObject jSONObject, a.d dVar) {
        if (jSONObject != null) {
            try {
                String a2 = a(jSONObject, "md5");
                String a3 = a(jSONObject, "url");
                String a4 = a(jSONObject, "sdkversion");
                if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(a3)) {
                    if (!TextUtils.isEmpty(a4)) {
                        dVar.f3346a = a3;
                        dVar.b = a2;
                        dVar.c = a4;
                    }
                }
            } catch (Throwable th) {
                ci.a(th, "at", "psu");
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.bq.a(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      com.amap.api.services.a.bq.a(org.json.JSONObject, java.lang.String):java.lang.String
      com.amap.api.services.a.bq.a(android.content.Context, org.json.JSONObject):void
      com.amap.api.services.a.bq.a(com.amap.api.services.a.bq$a, org.json.JSONObject):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$b):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$c):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$d):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$e):void
      com.amap.api.services.a.bq.a(org.json.JSONObject, com.amap.api.services.a.bq$a$f):void
      com.amap.api.services.a.bq.a(java.lang.String, boolean):boolean */
    private static void a(JSONObject jSONObject, a.e eVar) {
        if (eVar != null && jSONObject != null) {
            eVar.f3347a = a(jSONObject.optString("able"), false);
        }
    }

    static class b extends dc {
        private String c;
        private Map<String, String> d;
        private boolean e;

        public byte[] b() {
            return null;
        }

        public Map<String, String> e() {
            return null;
        }

        /* access modifiers changed from: protected */
        public String f() {
            return "3.0";
        }

        b(Context context, by byVar, String str, Map<String, String> map) {
            super(context, byVar);
            this.c = str;
            this.d = map;
            this.e = Build.VERSION.SDK_INT != 19;
        }

        public boolean a() {
            return this.e;
        }

        public String i() {
            return this.e ? "https://restapi.amap.com/v3/iasdkauth" : "http://restapi.amap.com/v3/iasdkauth";
        }

        public byte[] c() {
            return bz.a(bz.a(r()));
        }

        private Map<String, String> r() {
            String u = bt.u(this.f3394a);
            if (TextUtils.isEmpty(u)) {
                u = bt.i(this.f3394a);
            }
            if (!TextUtils.isEmpty(u)) {
                u = bw.a(new StringBuilder(u).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", this.c);
            hashMap.put("plattype", "android");
            hashMap.put("product", this.b.a());
            hashMap.put("version", this.b.b());
            hashMap.put("output", "json");
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb.toString());
            hashMap.put("deviceId", u);
            hashMap.put("manufacture", Build.MANUFACTURER);
            Map<String, String> map = this.d;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.d);
            }
            hashMap.put("abitype", bz.a(this.f3394a));
            hashMap.put("ext", this.b.d());
            return hashMap;
        }
    }

    private static void a(a aVar, JSONObject jSONObject) {
        a aVar2 = aVar;
        JSONObject jSONObject2 = jSONObject;
        String str = "121";
        try {
            if (bz.a(jSONObject2, "11B")) {
                aVar2.h = jSONObject2.getJSONObject("11B");
            }
            if (bz.a(jSONObject2, "11C")) {
                aVar2.k = jSONObject2.getJSONObject("11C");
            }
            if (bz.a(jSONObject2, "11I")) {
                aVar2.l = jSONObject2.getJSONObject("11I");
            }
            if (bz.a(jSONObject2, "11H")) {
                aVar2.m = jSONObject2.getJSONObject("11H");
            }
            if (bz.a(jSONObject2, "11E")) {
                aVar2.n = jSONObject2.getJSONObject("11E");
            }
            if (bz.a(jSONObject2, "11F")) {
                aVar2.o = jSONObject2.getJSONObject("11F");
            }
            if (bz.a(jSONObject2, "13A")) {
                aVar2.q = jSONObject2.getJSONObject("13A");
            }
            if (bz.a(jSONObject2, "13J")) {
                aVar2.i = jSONObject2.getJSONObject("13J");
            }
            if (bz.a(jSONObject2, "11G")) {
                aVar2.p = jSONObject2.getJSONObject("11G");
            }
            if (bz.a(jSONObject2, "006")) {
                aVar2.r = jSONObject2.getJSONObject("006");
            }
            if (bz.a(jSONObject2, "010")) {
                aVar2.s = jSONObject2.getJSONObject("010");
            }
            if (bz.a(jSONObject2, "11Z")) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("11Z");
                a.b bVar = new a.b();
                a(jSONObject3, bVar);
                aVar2.C = bVar;
            }
            if (bz.a(jSONObject2, "135")) {
                aVar2.j = jSONObject2.getJSONObject("135");
            }
            if (bz.a(jSONObject2, "13S")) {
                aVar2.g = jSONObject2.getJSONObject("13S");
            }
            String str2 = str;
            if (bz.a(jSONObject2, str2)) {
                JSONObject jSONObject4 = jSONObject2.getJSONObject(str2);
                a.b bVar2 = new a.b();
                a(jSONObject4, bVar2);
                aVar2.D = bVar2;
            }
            if (bz.a(jSONObject2, "122")) {
                JSONObject jSONObject5 = jSONObject2.getJSONObject("122");
                a.b bVar3 = new a.b();
                a(jSONObject5, bVar3);
                aVar2.E = bVar3;
            }
            if (bz.a(jSONObject2, "123")) {
                JSONObject jSONObject6 = jSONObject2.getJSONObject("123");
                a.b bVar4 = new a.b();
                a(jSONObject6, bVar4);
                aVar2.F = bVar4;
            }
            if (bz.a(jSONObject2, "011")) {
                aVar2.c = jSONObject2.getJSONObject("011");
            }
            if (bz.a(jSONObject2, "012")) {
                aVar2.d = jSONObject2.getJSONObject("012");
            }
            if (bz.a(jSONObject2, "013")) {
                aVar2.e = jSONObject2.getJSONObject("013");
            }
            if (bz.a(jSONObject2, "014")) {
                aVar2.f = jSONObject2.getJSONObject("014");
            }
            if (bz.a(jSONObject2, "145")) {
                aVar2.t = jSONObject2.getJSONObject("145");
            }
            if (bz.a(jSONObject2, "14B")) {
                aVar2.u = jSONObject2.getJSONObject("14B");
            }
            if (bz.a(jSONObject2, "14D")) {
                aVar2.v = jSONObject2.getJSONObject("14D");
            }
        } catch (Throwable th) {
            cl.c(th, "at", "pe");
        }
    }
}
