package _m_j;

import _m_j.bwy;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.loc.t;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public final class bwu {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f13357O000000o = -1;
    public static String O00000Oo = "";

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f13358O000000o;
        public int O00000Oo = -1;
        @Deprecated
        public JSONObject O00000o;
        @Deprecated
        public JSONObject O00000o0;
        @Deprecated
        public JSONObject O00000oO;
        @Deprecated
        public JSONObject O00000oo;
        @Deprecated
        public JSONObject O0000O0o;
        @Deprecated
        public JSONObject O0000OOo;
        @Deprecated
        public JSONObject O0000Oo;
        @Deprecated
        public JSONObject O0000Oo0;
        @Deprecated
        public JSONObject O0000OoO;
        @Deprecated
        public JSONObject O0000Ooo;
        @Deprecated
        public JSONObject O0000o;
        @Deprecated
        public JSONObject O0000o0;
        @Deprecated
        public JSONObject O0000o00;
        @Deprecated
        public JSONObject O0000o0O;
        @Deprecated
        public JSONObject O0000o0o;
        @Deprecated
        public JSONObject O0000oO;
        @Deprecated
        public JSONObject O0000oO0;
        @Deprecated
        public JSONObject O0000oOO;
        @Deprecated
        public JSONObject O0000oOo;
        public JSONObject O0000oo;
        @Deprecated
        public JSONObject O0000oo0;
        public C0097O000000o O0000ooO;
        public O00000o O0000ooo;
        public O00000o0 O000O00o;
        public O00000Oo O000O0OO;
        public O00000Oo O000O0Oo;
        public O0000O0o O000O0o;
        public O00000Oo O000O0o0;
        boolean O000O0oO;
        public O00000Oo O00oOoOo;
        public O0000OOo O00oOooO;
        @Deprecated
        public O00000o0 O00oOooo;

        /* renamed from: _m_j.bwu$O000000o$O000000o  reason: collision with other inner class name */
        public static class C0097O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            public boolean f13359O000000o;
            public boolean O00000Oo;
            public JSONObject O00000o0;
        }

        public static class O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            public boolean f13360O000000o;
            public String O00000Oo;
            public String O00000o;
            public String O00000o0;
            public boolean O00000oO;
        }

        public static class O00000o {

            /* renamed from: O000000o  reason: collision with root package name */
            public String f13361O000000o;
            public String O00000Oo;
            public String O00000o0;
        }

        public static class O00000o0 {

            /* renamed from: O000000o  reason: collision with root package name */
            public String f13362O000000o;
            public String O00000Oo;
        }

        public static class O0000O0o {

            /* renamed from: O000000o  reason: collision with root package name */
            public boolean f13363O000000o;
            public boolean O00000Oo;
            public String O00000o;
            public boolean O00000o0;
            public String O00000oO;
            public String O00000oo;
        }

        public static class O0000OOo {

            /* renamed from: O000000o  reason: collision with root package name */
            public boolean f13364O000000o;
        }
    }

    private static String O000000o(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject != null && jSONObject.has(str) && !jSONObject.getString(str).equals("[]")) ? jSONObject.optString(str) : "";
    }

    private static void O000000o(O000000o o000000o, JSONObject jSONObject) {
        O000000o o000000o2 = o000000o;
        JSONObject jSONObject2 = jSONObject;
        String str = "121";
        try {
            if (brs.O000000o(jSONObject2, "11B")) {
                o000000o2.O0000OOo = jSONObject2.getJSONObject("11B");
            }
            if (brs.O000000o(jSONObject2, "11C")) {
                o000000o2.O0000OoO = jSONObject2.getJSONObject("11C");
            }
            if (brs.O000000o(jSONObject2, "11I")) {
                o000000o2.O0000Ooo = jSONObject2.getJSONObject("11I");
            }
            if (brs.O000000o(jSONObject2, "11H")) {
                o000000o2.O0000o00 = jSONObject2.getJSONObject("11H");
            }
            if (brs.O000000o(jSONObject2, "11E")) {
                o000000o2.O0000o0 = jSONObject2.getJSONObject("11E");
            }
            if (brs.O000000o(jSONObject2, "11F")) {
                o000000o2.O0000o0O = jSONObject2.getJSONObject("11F");
            }
            if (brs.O000000o(jSONObject2, "13A")) {
                o000000o2.O0000o = jSONObject2.getJSONObject("13A");
            }
            if (brs.O000000o(jSONObject2, "13J")) {
                o000000o2.O0000Oo0 = jSONObject2.getJSONObject("13J");
            }
            if (brs.O000000o(jSONObject2, "11G")) {
                o000000o2.O0000o0o = jSONObject2.getJSONObject("11G");
            }
            if (brs.O000000o(jSONObject2, "006")) {
                o000000o2.O0000oO0 = jSONObject2.getJSONObject("006");
            }
            if (brs.O000000o(jSONObject2, "010")) {
                o000000o2.O0000oO = jSONObject2.getJSONObject("010");
            }
            if (brs.O000000o(jSONObject2, "11Z")) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("11Z");
                O000000o.O00000Oo o00000Oo = new O000000o.O00000Oo();
                O000000o(jSONObject3, o00000Oo);
                o000000o2.O000O0OO = o00000Oo;
            }
            if (brs.O000000o(jSONObject2, "135")) {
                o000000o2.O0000Oo = jSONObject2.getJSONObject("135");
            }
            if (brs.O000000o(jSONObject2, "13S")) {
                o000000o2.O0000O0o = jSONObject2.getJSONObject("13S");
            }
            String str2 = str;
            if (brs.O000000o(jSONObject2, str2)) {
                JSONObject jSONObject4 = jSONObject2.getJSONObject(str2);
                O000000o.O00000Oo o00000Oo2 = new O000000o.O00000Oo();
                O000000o(jSONObject4, o00000Oo2);
                o000000o2.O000O0Oo = o00000Oo2;
            }
            if (brs.O000000o(jSONObject2, "122")) {
                JSONObject jSONObject5 = jSONObject2.getJSONObject("122");
                O000000o.O00000Oo o00000Oo3 = new O000000o.O00000Oo();
                O000000o(jSONObject5, o00000Oo3);
                o000000o2.O00oOoOo = o00000Oo3;
            }
            if (brs.O000000o(jSONObject2, "123")) {
                JSONObject jSONObject6 = jSONObject2.getJSONObject("123");
                O000000o.O00000Oo o00000Oo4 = new O000000o.O00000Oo();
                O000000o(jSONObject6, o00000Oo4);
                o000000o2.O000O0o0 = o00000Oo4;
            }
            if (brs.O000000o(jSONObject2, "011")) {
                o000000o2.O00000o0 = jSONObject2.getJSONObject("011");
            }
            if (brs.O000000o(jSONObject2, "012")) {
                o000000o2.O00000o = jSONObject2.getJSONObject("012");
            }
            if (brs.O000000o(jSONObject2, "013")) {
                o000000o2.O00000oO = jSONObject2.getJSONObject("013");
            }
            if (brs.O000000o(jSONObject2, "014")) {
                o000000o2.O00000oo = jSONObject2.getJSONObject("014");
            }
            if (brs.O000000o(jSONObject2, "145")) {
                o000000o2.O0000oOO = jSONObject2.getJSONObject("145");
            }
            if (brs.O000000o(jSONObject2, "14B")) {
                o000000o2.O0000oOo = jSONObject2.getJSONObject("14B");
            }
            if (brs.O000000o(jSONObject2, "14D")) {
                o000000o2.O0000oo0 = jSONObject2.getJSONObject("14D");
            }
        } catch (Throwable th) {
            bsf.O00000Oo(th, "at", "pe");
        }
    }

    public static void O000000o(Context context, String str) {
        bwt.O000000o(context, str);
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
    private static void O000000o(JSONObject jSONObject, O000000o.O00000Oo o00000Oo) {
        try {
            String O000000o2 = O000000o(jSONObject, "m");
            String O000000o3 = O000000o(jSONObject, "u");
            String O000000o4 = O000000o(jSONObject, "v");
            String O000000o5 = O000000o(jSONObject, "able");
            String O000000o6 = O000000o(jSONObject, "on");
            o00000Oo.O00000o0 = O000000o2;
            o00000Oo.O00000Oo = O000000o3;
            o00000Oo.O00000o = O000000o4;
            o00000Oo.f13360O000000o = O000000o(O000000o5, false);
            o00000Oo.O00000oO = O000000o(O000000o6, true);
        } catch (Throwable th) {
            bsc.O000000o(th, "at", "pe");
        }
    }

    private static void O000000o(JSONObject jSONObject, O000000o.O00000o0 o00000o0) {
        if (jSONObject != null) {
            try {
                String O000000o2 = O000000o(jSONObject, "md5");
                String O000000o3 = O000000o(jSONObject, "url");
                o00000o0.O00000Oo = O000000o2;
                o00000o0.f13362O000000o = O000000o3;
            } catch (Throwable th) {
                bsc.O000000o(th, "at", "psc");
            }
        }
    }

    public static boolean O000000o(String str, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return z;
            }
            String[] split = URLDecoder.decode(str).split("/");
            return split[split.length - 1].charAt(4) % 2 == 1;
        } catch (Throwable unused) {
            return z;
        }
    }

    static class O00000Oo extends bsx {
        boolean O00000oo;
        private String O0000O0o;
        private Map<String, String> O0000OOo = null;

        O00000Oo(Context context, brr brr, String str) {
            super(context, brr);
            this.O0000O0o = str;
            this.O00000oo = Build.VERSION.SDK_INT != 19;
        }

        public final Map<String, String> O000000o() {
            return null;
        }

        public final String O00000o0() {
            return this.O00000oo ? "https://restapi.amap.com/v3/iasdkauth" : "http://restapi.amap.com/v3/iasdkauth";
        }

        /* access modifiers changed from: protected */
        public final String O0000O0o() {
            return "3.0";
        }

        public final byte[] O0000OOo() {
            return null;
        }

        public final byte[] O0000Oo0() {
            String O0000oOo = bww.O0000oOo(this.f13255O000000o);
            if (TextUtils.isEmpty(O0000oOo)) {
                O0000oOo = bww.O0000OOo(this.f13255O000000o);
            }
            if (!TextUtils.isEmpty(O0000oOo)) {
                O0000oOo = brp.O000000o(new StringBuilder(O0000oOo).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", this.O0000O0o);
            hashMap.put("plattype", "android");
            hashMap.put("product", this.O00000Oo.O000000o());
            hashMap.put("version", this.O00000Oo.O00000Oo);
            hashMap.put("output", "json");
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb.toString());
            hashMap.put("deviceId", O0000oOo);
            hashMap.put("manufacture", Build.MANUFACTURER);
            Map<String, String> map = this.O0000OOo;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.O0000OOo);
            }
            hashMap.put("abitype", brs.O000000o(this.f13255O000000o));
            hashMap.put("ext", this.O00000Oo.O00000o0());
            return brs.O000000o(brs.O000000o(hashMap));
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
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x012e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x012f, code lost:
        r14 = r23;
        r18 = "11K";
        r19 = "16H";
        r20 = "result";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x013d, code lost:
        r14 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0149, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x014a, code lost:
        r14 = r23;
        r18 = "11K";
        r19 = "16H";
        r20 = "result";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[ExcHandler: IllegalBlockSizeException (unused javax.crypto.IllegalBlockSizeException), SYNTHETIC, Splitter:B:1:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0161 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0162  */
    public static O000000o O000000o(Context context, brr brr, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        bta bta;
        String str6;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        String str7;
        byte[] bArr4;
        byte[] bArr5;
        byte[] bArr6;
        Context context2 = context;
        brr brr2 = brr;
        O000000o o000000o = new O000000o();
        o000000o.O0000oo = new JSONObject();
        bwy.O000000o.f13370O000000o.O000000o(context2);
        try {
            new bsw();
            StringBuilder sb = new StringBuilder();
            str6 = str;
            try {
                sb.append(str6);
                sb.append(";14N;15K;16H");
                str6 = sb.toString();
            } catch (t e) {
                e = e;
                Object obj = "11K";
                Object obj2 = "16H";
                Object obj3 = "result";
                throw e;
            } catch (IllegalBlockSizeException unused) {
                str4 = "11K";
                str3 = "16H";
                str2 = "result";
                bArr3 = null;
                bta = null;
                bArr = bArr3;
                str5 = null;
                if (bArr != null) {
                }
            } catch (Throwable unused2) {
                str4 = "11K";
                str3 = "16H";
                str2 = "result";
                try {
                    throw new t("未知的错误");
                } catch (t e2) {
                    e = e2;
                    bArr2 = null;
                    bta = null;
                    o000000o.f13358O000000o = e.a();
                    bsf.O000000o(brr2, "/v3/iasdkauth", e);
                    str5 = null;
                    if (bArr != null) {
                    }
                } catch (IllegalBlockSizeException unused3) {
                    bArr3 = null;
                    bta = null;
                    bArr = bArr3;
                    str5 = null;
                    if (bArr != null) {
                    }
                } catch (Throwable th) {
                    th = th;
                    bArr = null;
                    bta = null;
                    bsf.O00000Oo(th, "at", "lc");
                    str5 = null;
                    if (bArr != null) {
                    }
                }
            }
            try {
                O00000Oo o00000Oo = new O00000Oo(context2, brr2, str6);
                bta = bsw.O000000o(o00000Oo, o00000Oo.O00000oo);
                if (bta != null) {
                    try {
                        str7 = str6;
                        bArr4 = bta.f13259O000000o;
                    } catch (t e3) {
                        e = e3;
                        str4 = "11K";
                        str3 = "16H";
                        str2 = "result";
                        bArr2 = null;
                        o000000o.f13358O000000o = e.a();
                        bsf.O000000o(brr2, "/v3/iasdkauth", e);
                        str5 = null;
                        if (bArr != null) {
                        }
                    } catch (IllegalBlockSizeException unused4) {
                        str4 = "11K";
                        str3 = "16H";
                        str2 = "result";
                        bArr3 = null;
                        bArr = bArr3;
                        str5 = null;
                        if (bArr != null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        str4 = "11K";
                        str3 = "16H";
                        str2 = "result";
                        bArr = null;
                        bsf.O00000Oo(th, "at", "lc");
                        str5 = null;
                        if (bArr != null) {
                        }
                    }
                } else {
                    str7 = str6;
                    bArr4 = null;
                }
                bta bta2 = bta;
                try {
                    bArr5 = new byte[16];
                    str4 = "11K";
                    try {
                        bArr6 = new byte[(bArr4.length - 16)];
                        str3 = "16H";
                    } catch (t e4) {
                        e = e4;
                        str3 = "16H";
                        str2 = "result";
                        bArr2 = bArr4;
                        bta = bta2;
                        str6 = str7;
                        o000000o.f13358O000000o = e.a();
                        bsf.O000000o(brr2, "/v3/iasdkauth", e);
                        str5 = null;
                        if (bArr != null) {
                        }
                    } catch (IllegalBlockSizeException unused5) {
                        str3 = "16H";
                        str2 = "result";
                        bArr3 = bArr4;
                        bta = bta2;
                        str6 = str7;
                        bArr = bArr3;
                        str5 = null;
                        if (bArr != null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str3 = "16H";
                        str2 = "result";
                        bArr = bArr4;
                        bta = bta2;
                        str6 = str7;
                        bsf.O00000Oo(th, "at", "lc");
                        str5 = null;
                        if (bArr != null) {
                        }
                    }
                } catch (t e5) {
                    e = e5;
                    str4 = "11K";
                    str3 = "16H";
                    str2 = "result";
                    bArr2 = bArr4;
                    bta = bta2;
                    str6 = str7;
                    o000000o.f13358O000000o = e.a();
                    bsf.O000000o(brr2, "/v3/iasdkauth", e);
                    str5 = null;
                    if (bArr != null) {
                    }
                } catch (IllegalBlockSizeException unused6) {
                    str4 = "11K";
                    str3 = "16H";
                    str2 = "result";
                    bArr3 = bArr4;
                    bta = bta2;
                    str6 = str7;
                    bArr = bArr3;
                    str5 = null;
                    if (bArr != null) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    str4 = "11K";
                    str3 = "16H";
                    str2 = "result";
                    bArr = bArr4;
                    bta = bta2;
                    str6 = str7;
                    bsf.O00000Oo(th, "at", "lc");
                    str5 = null;
                    if (bArr != null) {
                    }
                }
                try {
                    System.arraycopy(bArr4, 0, bArr5, 0, 16);
                    str2 = "result";
                    try {
                        System.arraycopy(bArr4, 16, bArr6, 0, bArr4.length - 16);
                        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr5, "AES");
                        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                        instance.init(2, secretKeySpec, new IvParameterSpec(brs.O00000o0()));
                        str5 = brs.O000000o(instance.doFinal(bArr6));
                        bArr = bArr4;
                        bta = bta2;
                        str6 = str7;
                    } catch (t e6) {
                        e = e6;
                        bArr2 = bArr4;
                        bta = bta2;
                        str6 = str7;
                        o000000o.f13358O000000o = e.a();
                        bsf.O000000o(brr2, "/v3/iasdkauth", e);
                        str5 = null;
                        if (bArr != null) {
                        }
                    } catch (IllegalBlockSizeException unused7) {
                        bArr3 = bArr4;
                        bta = bta2;
                        str6 = str7;
                        bArr = bArr3;
                        str5 = null;
                        if (bArr != null) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        bArr = bArr4;
                        bta = bta2;
                        str6 = str7;
                        bsf.O00000Oo(th, "at", "lc");
                        str5 = null;
                        if (bArr != null) {
                        }
                    }
                } catch (t e7) {
                    e = e7;
                    str2 = "result";
                    bArr2 = bArr4;
                    bta = bta2;
                    str6 = str7;
                    o000000o.f13358O000000o = e.a();
                    bsf.O000000o(brr2, "/v3/iasdkauth", e);
                    str5 = null;
                    if (bArr != null) {
                    }
                } catch (IllegalBlockSizeException unused8) {
                    str2 = "result";
                    bArr3 = bArr4;
                    bta = bta2;
                    str6 = str7;
                    bArr = bArr3;
                    str5 = null;
                    if (bArr != null) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                    str2 = "result";
                    bArr = bArr4;
                    bta = bta2;
                    str6 = str7;
                    bsf.O00000Oo(th, "at", "lc");
                    str5 = null;
                    if (bArr != null) {
                    }
                }
            } catch (t e8) {
                e = e8;
                throw e;
            } catch (IllegalBlockSizeException unused9) {
                str4 = "11K";
                str3 = "16H";
                str2 = "result";
                str6 = str6;
                bArr3 = null;
                bta = null;
                bArr = bArr3;
                str5 = null;
                if (bArr != null) {
                }
            } catch (Throwable unused10) {
                str4 = "11K";
                str3 = "16H";
                str2 = "result";
                str6 = str6;
                throw new t("未知的错误");
            }
        } catch (t e9) {
            e = e9;
            String str8 = str;
            Object obj4 = "11K";
            Object obj22 = "16H";
            Object obj32 = "result";
            throw e;
        } catch (IllegalBlockSizeException unused11) {
        } catch (Throwable unused12) {
            str6 = str;
            str4 = "11K";
            str3 = "16H";
            str2 = "result";
            throw new t("未知的错误");
        }
        if (bArr != null) {
            return o000000o;
        }
        if (TextUtils.isEmpty(str5)) {
            str5 = brs.O000000o(bArr);
        }
        try {
            JSONObject jSONObject = new JSONObject(str5);
            if (jSONObject.has("status")) {
                int i = jSONObject.getInt("status");
                if (i == 1) {
                    f13357O000000o = 1;
                } else if (i == 0) {
                    String str9 = "authcsid";
                    String str10 = "authgsid";
                    if (bta != null) {
                        str9 = bta.O00000o0;
                        str10 = bta.O00000o;
                    }
                    brs.O000000o(context2, str9, str10, jSONObject);
                    f13357O000000o = 0;
                    if (jSONObject.has("info")) {
                        O00000Oo = jSONObject.getString("info");
                    }
                    String str11 = "";
                    if (jSONObject.has("infocode")) {
                        str11 = jSONObject.getString("infocode");
                    }
                    bsf.O000000o(brr2, "/v3/iasdkauth", O00000Oo, str10, str11);
                    if (f13357O000000o == 0) {
                        o000000o.f13358O000000o = O00000Oo;
                        return o000000o;
                    }
                }
                if (jSONObject.has("ver")) {
                    o000000o.O00000Oo = jSONObject.getInt("ver");
                }
                String str12 = str2;
                if (brs.O000000o(jSONObject, str12)) {
                    O000000o.C0097O000000o o000000o2 = new O000000o.C0097O000000o();
                    o000000o2.f13359O000000o = false;
                    o000000o2.O00000Oo = false;
                    o000000o.O0000ooO = o000000o2;
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str12);
                    try {
                        String[] split = str6.split(";");
                        if (split != null && split.length > 0) {
                            for (String str13 : split) {
                                if (jSONObject2.has(str13)) {
                                    o000000o.O0000oo.putOpt(str13, jSONObject2.get(str13));
                                }
                            }
                        }
                    } catch (Throwable th7) {
                        bsc.O000000o(th7, "at", "co");
                    }
                    String str14 = str3;
                    if (brs.O000000o(jSONObject2, str14)) {
                        o000000o.O000O0oO = O000000o(jSONObject2.getJSONObject(str14).optString("able"), false);
                    }
                    String str15 = str4;
                    if (brs.O000000o(jSONObject2, str15)) {
                        try {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject(str15);
                            o000000o2.f13359O000000o = O000000o(jSONObject3.getString("able"), false);
                            if (jSONObject3.has("off")) {
                                o000000o2.O00000o0 = jSONObject3.getJSONObject("off");
                            }
                        } catch (Throwable th8) {
                            bsc.O000000o(th8, "AuthConfigManager", "loadException");
                        }
                    }
                    if (brs.O000000o(jSONObject2, "001")) {
                        JSONObject jSONObject4 = jSONObject2.getJSONObject("001");
                        O000000o.O00000o o00000o = new O000000o.O00000o();
                        if (jSONObject4 != null) {
                            try {
                                String O000000o2 = O000000o(jSONObject4, "md5");
                                String O000000o3 = O000000o(jSONObject4, "url");
                                String O000000o4 = O000000o(jSONObject4, "sdkversion");
                                if (!TextUtils.isEmpty(O000000o2) && !TextUtils.isEmpty(O000000o3)) {
                                    if (!TextUtils.isEmpty(O000000o4)) {
                                        o00000o.f13361O000000o = O000000o3;
                                        o00000o.O00000Oo = O000000o2;
                                        o00000o.O00000o0 = O000000o4;
                                    }
                                }
                            } catch (Throwable th9) {
                                bsc.O000000o(th9, "at", "psu");
                            }
                        }
                        o000000o.O0000ooo = o00000o;
                    }
                    if (brs.O000000o(jSONObject2, "002")) {
                        JSONObject jSONObject5 = jSONObject2.getJSONObject("002");
                        O000000o.O00000o0 o00000o0 = new O000000o.O00000o0();
                        O000000o(jSONObject5, o00000o0);
                        o000000o.O00oOooo = o00000o0;
                    }
                    if (brs.O000000o(jSONObject2, "14S")) {
                        JSONObject jSONObject6 = jSONObject2.getJSONObject("14S");
                        O000000o.O00000o0 o00000o02 = new O000000o.O00000o0();
                        O000000o(jSONObject6, o00000o02);
                        o000000o.O000O00o = o00000o02;
                    }
                    O000000o(o000000o, jSONObject2);
                    if (brs.O000000o(jSONObject2, "14Z")) {
                        JSONObject jSONObject7 = jSONObject2.getJSONObject("14Z");
                        O000000o.O0000O0o o0000O0o = new O000000o.O0000O0o();
                        try {
                            String O000000o5 = O000000o(jSONObject7, "md5");
                            String O000000o6 = O000000o(jSONObject7, "md5info");
                            String O000000o7 = O000000o(jSONObject7, "url");
                            String O000000o8 = O000000o(jSONObject7, "able");
                            String O000000o9 = O000000o(jSONObject7, "on");
                            String O000000o10 = O000000o(jSONObject7, "mobileable");
                            o0000O0o.O00000oO = O000000o5;
                            o0000O0o.O00000oo = O000000o6;
                            o0000O0o.O00000o = O000000o7;
                            o0000O0o.f13363O000000o = O000000o(O000000o8, false);
                            o0000O0o.O00000Oo = O000000o(O000000o9, false);
                            o0000O0o.O00000o0 = O000000o(O000000o10, false);
                        } catch (Throwable th10) {
                            bsc.O000000o(th10, "at", "pes");
                        }
                        o000000o.O000O0o = o0000O0o;
                    }
                    if (brs.O000000o(jSONObject2, "151")) {
                        JSONObject jSONObject8 = jSONObject2.getJSONObject("151");
                        O000000o.O0000OOo o0000OOo = new O000000o.O0000OOo();
                        if (jSONObject8 != null) {
                            o0000OOo.f13364O000000o = O000000o(jSONObject8.optString("able"), false);
                        }
                        o000000o.O00oOooO = o0000OOo;
                    }
                    O000000o(o000000o, jSONObject2);
                    try {
                        JSONObject jSONObject9 = jSONObject2.getJSONObject("15K");
                        boolean O000000o11 = O000000o(jSONObject9.optString("isTargetAble"), false);
                        if (!O000000o(jSONObject9.optString("able"), false)) {
                            bwy.O000000o.f13370O000000o.O00000Oo.O000000o(context2, "isTargetRequired", true);
                        } else {
                            bwy bwy = bwy.O000000o.f13370O000000o;
                            if (bwy.f13369O000000o == null) {
                                bwy.f13369O000000o = new bwy.O00000Oo((byte) 0);
                            }
                            bwy.O00000Oo.O000000o(context2, "isTargetRequired", O000000o11);
                            bwy.f13369O000000o.O000000o(O000000o11);
                        }
                    } catch (Throwable th11) {
                        th11.printStackTrace();
                    }
                }
            }
        } catch (Throwable th12) {
            bsc.O000000o(th12, "at", "lc");
        }
        return o000000o;
    }
}
