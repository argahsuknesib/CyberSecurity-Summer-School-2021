package com.alipay.sdk.data;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.h;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static a ai;
    private static final char[] aj = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '+', '/'};
    private int P = C.MSG_CUSTOM_BASE;
    private boolean Q = false;
    private String R = "https://h5.m.taobao.com/mlapp/olist.html";
    private int S = 10;
    private boolean T = true;
    private boolean U = true;
    private boolean V = false;
    private boolean W = true;
    private boolean X = true;
    private String Y = "";
    private boolean Z = false;

    /* renamed from: a  reason: collision with root package name */
    public boolean f3186a = false;
    private boolean aa = false;
    private boolean ab = false;
    private boolean ac = true;
    private String ad = "";
    private String ae = "";
    private boolean af = false;
    private List<C0017a> ag = null;
    private int ah = -1;

    public final int a() {
        int i = this.P;
        if (i < 1000 || i > 20000) {
            c.a("DynCon", "time(def) = 10000");
            return C.MSG_CUSTOM_BASE;
        }
        c.a("DynCon", "time = " + this.P);
        return this.P;
    }

    public final boolean b() {
        return this.Q;
    }

    public final boolean c() {
        return this.T;
    }

    public final boolean d() {
        return this.U;
    }

    public final String e() {
        return this.R;
    }

    public final int f() {
        return this.S;
    }

    public final boolean g() {
        return this.V;
    }

    public final boolean h() {
        return this.W;
    }

    public final boolean i() {
        return this.X;
    }

    public final String j() {
        return this.Y;
    }

    public final boolean k() {
        return this.Z;
    }

    public final boolean l() {
        return this.aa;
    }

    public final boolean m() {
        return this.ab;
    }

    public final boolean n() {
        return this.ac;
    }

    public final boolean o() {
        return this.af;
    }

    public final String p() {
        return this.ad;
    }

    public final String q() {
        return this.ae;
    }

    public final List<C0017a> r() {
        return this.ag;
    }

    public final void a(boolean z) {
        this.f3186a = z;
    }

    public static a s() {
        if (ai == null) {
            a aVar = new a();
            ai = aVar;
            aVar.t();
        }
        return ai;
    }

    public final void t() {
        Context b = b.a().b();
        String b2 = h.b(com.alipay.sdk.sys.a.a(), b, "alipay_cashier_dynamic_config", null);
        try {
            this.ah = Integer.parseInt(h.b(com.alipay.sdk.sys.a.a(), b, "utdid_factor", "-1"));
        } catch (Exception unused) {
        }
        b(b2);
    }

    private void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                a(new JSONObject(str));
            } catch (Throwable th) {
                c.a(th);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(com.alipay.sdk.sys.a aVar) {
        try {
            h.a(aVar, b.a().b(), "alipay_cashier_dynamic_config", u().toString());
        } catch (Exception e) {
            c.a(e);
        }
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("st_sdk_config");
                if (optJSONObject != null) {
                    a(optJSONObject);
                } else {
                    c.c("DynCon", "empty config");
                }
            } catch (Throwable th) {
                c.a(th);
            }
        }
    }

    private JSONObject u() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timeout", a());
        jSONObject.put("h5_port_degrade", b());
        jSONObject.put("tbreturl", e());
        jSONObject.put("configQueryInterval", f());
        jSONObject.put("launchAppSwitch", C0017a.a(r()));
        jSONObject.put("scheme_pay_2", c());
        jSONObject.put("intercept_batch", d());
        jSONObject.put("deg_log_mcgw", g());
        jSONObject.put("deg_start_srv_first", h());
        jSONObject.put("prev_jump_dual", i());
        jSONObject.put("use_sc_only", j());
        jSONObject.put("bind_use_imp", k());
        jSONObject.put("retry_bnd_once", l());
        jSONObject.put("skip_trans", m());
        jSONObject.put("up_before_pay", n());
        jSONObject.put("use_sc_lck_a", o());
        jSONObject.put("lck_k", p());
        jSONObject.put("bind_with_startActivity", q());
        return jSONObject;
    }

    private void a(JSONObject jSONObject) {
        this.P = jSONObject.optInt("timeout", C.MSG_CUSTOM_BASE);
        this.Q = jSONObject.optBoolean("h5_port_degrade", false);
        this.R = jSONObject.optString("tbreturl", "https://h5.m.taobao.com/mlapp/olist.html").trim();
        this.S = jSONObject.optInt("configQueryInterval", 10);
        this.ag = C0017a.a(jSONObject.optJSONArray("launchAppSwitch"));
        this.T = jSONObject.optBoolean("scheme_pay_2", true);
        this.U = jSONObject.optBoolean("intercept_batch", true);
        this.V = jSONObject.optBoolean("deg_log_mcgw", false);
        this.W = jSONObject.optBoolean("deg_start_srv_first", true);
        this.X = jSONObject.optBoolean("prev_jump_dual", true);
        this.Y = jSONObject.optString("use_sc_only", "");
        this.Z = jSONObject.optBoolean("bind_use_imp", false);
        this.aa = jSONObject.optBoolean("retry_bnd_once", false);
        this.ab = jSONObject.optBoolean("skip_trans", false);
        this.ac = jSONObject.optBoolean("up_before_pay", true);
        this.ad = jSONObject.optString("lck_k", "");
        this.af = jSONObject.optBoolean("use_sc_lck_a", false);
        this.ae = jSONObject.optString("bind_with_startActivity", "");
    }

    public final void a(final com.alipay.sdk.sys.a aVar, final Context context) {
        new Thread(new Runnable() {
            /* class com.alipay.sdk.data.a.AnonymousClass1 */

            public void run() {
                try {
                    com.alipay.sdk.packet.b a2 = new com.alipay.sdk.packet.impl.b().a(aVar, context);
                    if (a2 != null) {
                        a.this.c(a2.b());
                        a.this.a(com.alipay.sdk.sys.a.a());
                    }
                } catch (Throwable th) {
                    c.a(th);
                }
            }
        }).start();
    }

    public final boolean a(Context context, int i) {
        if (this.ah == -1) {
            this.ah = v();
            h.a(com.alipay.sdk.sys.a.a(), context, "utdid_factor", String.valueOf(this.ah));
        }
        return this.ah < i;
    }

    private int v() {
        String e = b.a().e();
        if (TextUtils.isEmpty(e)) {
            return -1;
        }
        String replaceAll = e.replaceAll("=", "");
        if (replaceAll.length() >= 5) {
            replaceAll = replaceAll.substring(0, 5);
        }
        int d = (int) (d(replaceAll) % 10000);
        return d < 0 ? d * -1 : d;
    }

    private static long d(String str) {
        return a(str, 6);
    }

    private static long a(String str, int i) {
        int pow = (int) Math.pow(2.0d, (double) i);
        int length = str.length();
        long j = 0;
        int i2 = 0;
        int i3 = length;
        while (i2 < length) {
            int i4 = i2 + 1;
            j += ((long) Integer.parseInt(String.valueOf(a(str.substring(i2, i4))))) * ((long) Math.pow((double) pow, (double) (i3 - 1)));
            i3--;
            i2 = i4;
        }
        return j;
    }

    public static int a(String str) {
        for (int i = 0; i < 64; i++) {
            if (str.equals(String.valueOf(aj[i]))) {
                return i;
            }
        }
        return 0;
    }

    /* renamed from: com.alipay.sdk.data.a$a  reason: collision with other inner class name */
    public static final class C0017a {

        /* renamed from: a  reason: collision with root package name */
        public final String f3188a;
        public final int b;
        public final String c;

        public C0017a(String str, int i, String str2) {
            this.f3188a = str;
            this.b = i;
            this.c = str2;
        }

        public static C0017a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new C0017a(jSONObject.optString("pn"), jSONObject.optInt("v", 0), jSONObject.optString("pk"));
        }

        public static List<C0017a> a(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                C0017a a2 = a(jSONArray.optJSONObject(i));
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        }

        public static JSONObject a(C0017a aVar) {
            if (aVar == null) {
                return null;
            }
            try {
                return new JSONObject().put("pn", aVar.f3188a).put("v", aVar.b).put("pk", aVar.c);
            } catch (JSONException e) {
                c.a(e);
                return null;
            }
        }

        public static JSONArray a(List<C0017a> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (C0017a a2 : list) {
                jSONArray.put(a(a2));
            }
            return jSONArray;
        }

        public final String toString() {
            return String.valueOf(a(this));
        }
    }
}
