package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.eqh;
import _m_j.err;
import _m_j.esl;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.push.g;
import com.xiaomi.push.ht;
import com.xiaomi.push.hu;
import com.xiaomi.push.r;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class i {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static volatile i f6560a;

    /* renamed from: a  reason: collision with other field name */
    private int f319a = -1;

    /* renamed from: a  reason: collision with other field name */
    private long f320a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f321a;

    /* renamed from: a  reason: collision with other field name */
    private final SharedPreferences f322a;

    /* renamed from: a  reason: collision with other field name */
    private String f323a = null;

    /* renamed from: a  reason: collision with other field name */
    private final AtomicInteger f324a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f325a = false;
    private String b = null;

    /* renamed from: b  reason: collision with other field name */
    private final AtomicInteger f326b = new AtomicInteger(0);

    /* renamed from: b  reason: collision with other field name */
    private final boolean f327b;
    private final AtomicInteger c = new AtomicInteger(0);

    /* renamed from: c  reason: collision with other field name */
    private final boolean f328c;

    static class a {
        public static String a() {
            return "support_wifi_digest";
        }

        public static String a(String str) {
            return String.format("HB_%s", str);
        }

        public static String b() {
            return "record_support_wifi_digest_reported";
        }

        public static String b(String str) {
            return String.format("HB_dead_time_%s", str);
        }

        public static String c() {
            return "record_hb_count_start";
        }

        public static String d() {
            return "record_short_hb_count";
        }

        public static String e() {
            return "record_long_hb_count";
        }

        public static String f() {
            return "record_hb_change";
        }

        public static String g() {
            return "record_mobile_ptc";
        }

        public static String h() {
            return "record_wifi_ptc";
        }

        public static String i() {
            return "record_ptc_start";
        }

        public static String j() {
            return "keep_short_hb_effective_time";
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.at.a(int, boolean):boolean
     arg types: [int, int]
     candidates:
      com.xiaomi.push.service.at.a(int, int):int
      com.xiaomi.push.service.at.a(com.xiaomi.push.hv, int):int
      com.xiaomi.push.service.at.a(int, long):long
      com.xiaomi.push.service.at.a(int, java.lang.String):java.lang.String
      com.xiaomi.push.service.at.a(java.util.List<android.util.Pair<com.xiaomi.push.hv, java.lang.Integer>>, java.util.List<android.util.Pair<java.lang.Integer, java.lang.Object>>):void
      com.xiaomi.push.service.at.a(int, boolean):boolean */
    private i(Context context) {
        this.f321a = context;
        this.f328c = esl.O000000o(context);
        this.f327b = at.a(this.f321a).a(hu.bg.a(), true);
        this.f322a = this.f321a.getSharedPreferences("hb_record", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f322a.getLong(a.c(), -1) == -1) {
            this.f322a.edit().putLong(a.c(), currentTimeMillis).apply();
        }
        this.f320a = this.f322a.getLong(a.i(), -1);
        if (this.f320a == -1) {
            this.f320a = currentTimeMillis;
            this.f322a.edit().putLong(a.i(), currentTimeMillis).apply();
        }
    }

    private int a() {
        if (TextUtils.isEmpty(this.f323a)) {
            return -1;
        }
        try {
            return this.f322a.getInt(a.a(this.f323a), -1);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static i a(Context context) {
        if (f6560a == null) {
            synchronized (i.class) {
                if (f6560a == null) {
                    f6560a = new i(context);
                }
            }
        }
        return f6560a;
    }

    private void a(boolean z) {
        if (m202c()) {
            int incrementAndGet = (z ? this.f326b : this.c).incrementAndGet();
            Object[] objArr = new Object[2];
            String str = "short";
            objArr[0] = z ? str : "long";
            objArr[1] = Integer.valueOf(incrementAndGet);
            duv.O00000Oo(String.format("[HB] %s ping interval count: %s", objArr));
            if (incrementAndGet >= 5) {
                String d = z ? a.d() : a.e();
                int i = this.f322a.getInt(d, 0) + incrementAndGet;
                this.f322a.edit().putInt(d, i).apply();
                Object[] objArr2 = new Object[2];
                if (!z) {
                    str = "long";
                }
                objArr2[0] = str;
                objArr2[1] = Integer.valueOf(i);
                duv.O000000o(String.format("[HB] accumulate %s hb count(%s) and write to file. ", objArr2));
                if (z) {
                    this.f326b.set(0);
                } else {
                    this.c.set(0);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m200a() {
        return this.f324a.get() >= Math.max(at.a(this.f321a).a(hu.bi.a(), 5), 3);
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("W-") || str.startsWith("M-");
    }

    private long b() {
        return this.f322a.getLong(a.j(), -1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
    private void b(String str) {
        int i;
        SharedPreferences.Editor remove;
        if ("WIFI-ID-UNKNOWN".equals(str)) {
            String str2 = this.f323a;
            if (str2 == null || !str2.startsWith("W-")) {
                str = null;
            }
            i = this.f322a.getInt(a.a(this.f323a), -1);
            long j = this.f322a.getLong(a.b(this.f323a), -1);
            long currentTimeMillis = System.currentTimeMillis();
            if (i != -1) {
                if (j == -1) {
                    remove = this.f322a.edit().putLong(a.b(this.f323a), currentTimeMillis + c());
                } else if (currentTimeMillis > j) {
                    remove = this.f322a.edit().remove(a.a(this.f323a)).remove(a.b(this.f323a));
                }
                remove.apply();
            }
            this.f324a.getAndSet(0);
            if (!TextUtils.isEmpty(this.f323a) || a() != -1) {
                this.f325a = false;
            } else {
                this.f325a = true;
            }
            duv.O000000o(String.format("[HB] network changed, netid:%s, %s", this.f323a, Boolean.valueOf(this.f325a)));
        }
        this.f323a = str;
        i = this.f322a.getInt(a.a(this.f323a), -1);
        long j2 = this.f322a.getLong(a.b(this.f323a), -1);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (i != -1) {
        }
        this.f324a.getAndSet(0);
        if (!TextUtils.isEmpty(this.f323a)) {
        }
        this.f325a = false;
        duv.O000000o(String.format("[HB] network changed, netid:%s, %s", this.f323a, Boolean.valueOf(this.f325a)));
    }

    /* renamed from: b  reason: collision with other method in class */
    private boolean m201b() {
        return !TextUtils.isEmpty(this.f323a) && this.f323a.startsWith("M-") && !at.a(this.f321a).a(hu.bj.a(), false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.at.a(int, long):long
     arg types: [int, int]
     candidates:
      com.xiaomi.push.service.at.a(int, int):int
      com.xiaomi.push.service.at.a(com.xiaomi.push.hv, int):int
      com.xiaomi.push.service.at.a(int, java.lang.String):java.lang.String
      com.xiaomi.push.service.at.a(java.util.List<android.util.Pair<com.xiaomi.push.hv, java.lang.Integer>>, java.util.List<android.util.Pair<java.lang.Integer, java.lang.Object>>):void
      com.xiaomi.push.service.at.a(int, boolean):boolean
      com.xiaomi.push.service.at.a(int, long):long */
    private long c() {
        return at.a(this.f321a).a(hu.br.a(), 777600000L);
    }

    private void c(String str) {
        if (a(str)) {
            this.f322a.edit().putInt(a.a(str), 235000).apply();
            this.f322a.edit().putLong(a.b(this.f323a), System.currentTimeMillis() + c()).apply();
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m202c() {
        return d() && at.a(this.f321a).a(hu.bh.a(), true) && r.f6460a.name().equals(a.a(this.f321a).a());
    }

    private void d(String str) {
        String str2;
        String str3;
        if (m202c() && !TextUtils.isEmpty(str)) {
            if (str.startsWith("W-")) {
                str2 = "W";
            } else if (str.startsWith("M-")) {
                str2 = "M";
            } else {
                return;
            }
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(":::");
            sb.append(str2);
            sb.append(":::");
            sb.append("235000");
            sb.append(":::");
            sb.append(valueOf);
            String string = this.f322a.getString(a.f(), null);
            if (TextUtils.isEmpty(string)) {
                str3 = sb.toString();
            } else {
                str3 = string + "###" + sb.toString();
            }
            this.f322a.edit().putString(a.f(), str3).apply();
        }
    }

    private boolean d() {
        return this.f328c && (this.f327b || ((b() > System.currentTimeMillis() ? 1 : (b() == System.currentTimeMillis() ? 0 : -1)) >= 0));
    }

    private void e() {
        if (!this.f322a.getBoolean(a.a(), false)) {
            this.f322a.edit().putBoolean(a.a(), true).apply();
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m203e() {
        long j = this.f322a.getLong(a.c(), -1);
        if (j == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        return j > currentTimeMillis || currentTimeMillis - j >= 259200000;
    }

    private void f() {
        int i = this.f319a;
        String h = i != 0 ? i != 1 ? null : a.h() : a.g();
        if (!TextUtils.isEmpty(h)) {
            if (this.f322a.getLong(a.i(), -1) == -1) {
                this.f320a = System.currentTimeMillis();
                this.f322a.edit().putLong(a.i(), this.f320a).apply();
            }
            this.f322a.edit().putInt(h, this.f322a.getInt(h, 0) + 1).apply();
        }
    }

    /* renamed from: f  reason: collision with other method in class */
    private boolean m204f() {
        if (this.f320a == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f320a;
        return j > currentTimeMillis || currentTimeMillis - j >= 259200000;
    }

    private void g() {
        int i;
        SharedPreferences.Editor editor;
        String[] split;
        String[] split2;
        if (m202c()) {
            String string = this.f322a.getString(a.f(), null);
            char c2 = 1;
            char c3 = 0;
            if (!TextUtils.isEmpty(string) && (split = string.split("###")) != null) {
                int i2 = 0;
                while (i2 < split.length) {
                    if (!TextUtils.isEmpty(split[i2]) && (split2 = split[i2].split(":::")) != null && split2.length >= 4) {
                        String str = split2[c3];
                        String str2 = split2[c2];
                        String str3 = split2[2];
                        String str4 = split2[3];
                        HashMap hashMap = new HashMap();
                        hashMap.put("event", "change");
                        hashMap.put("model", Build.MODEL);
                        hashMap.put("net_type", str2);
                        hashMap.put("net_name", str);
                        hashMap.put("interval", str3);
                        hashMap.put("timestamp", str4);
                        a("category_hb_change", null, hashMap);
                        duv.O000000o("[HB] report hb changed events.");
                    }
                    i2++;
                    c2 = 1;
                    c3 = 0;
                }
                this.f322a.edit().remove(a.f()).apply();
            }
            if (this.f322a.getBoolean(a.a(), false) && !this.f322a.getBoolean(a.b(), false)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("event", "support");
                hashMap2.put("model", Build.MODEL);
                hashMap2.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
                a("category_hb_change", null, hashMap2);
                duv.O000000o("[HB] report support wifi digest events.");
                this.f322a.edit().putBoolean(a.b(), true).apply();
            }
            if (m203e()) {
                int i3 = this.f322a.getInt(a.d(), 0);
                int i4 = this.f322a.getInt(a.e(), 0);
                if (i3 > 0 || i4 > 0) {
                    String valueOf = String.valueOf(this.f322a.getLong(a.c(), -1));
                    String valueOf2 = String.valueOf(System.currentTimeMillis());
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("interval", "235000");
                        jSONObject.put("c_short", String.valueOf(i3));
                        jSONObject.put("c_long", String.valueOf(i4));
                        jSONObject.put("count", String.valueOf(i3 + i4));
                        jSONObject.put("start_time", valueOf);
                        jSONObject.put("end_time", valueOf2);
                        String jSONObject2 = jSONObject.toString();
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("event", "long_and_short_hb_count");
                        a("category_hb_count", jSONObject2, hashMap3);
                        duv.O000000o("[HB] report short/long hb count events.");
                    } catch (Throwable unused) {
                    }
                }
                this.f322a.edit().putInt(a.d(), 0).putInt(a.e(), 0).putLong(a.c(), System.currentTimeMillis()).apply();
            }
            if (m204f()) {
                String valueOf3 = String.valueOf(this.f320a);
                String valueOf4 = String.valueOf(System.currentTimeMillis());
                int i5 = this.f322a.getInt(a.g(), 0);
                if (i5 > 0) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("net_type", "M");
                        jSONObject3.put("ptc", i5);
                        jSONObject3.put("start_time", valueOf3);
                        jSONObject3.put("end_time", valueOf4);
                        String jSONObject4 = jSONObject3.toString();
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("event", "ptc_event");
                        a("category_lc_ptc", jSONObject4, hashMap4);
                        duv.O000000o("[HB] report ping timeout count events of mobile network.");
                        this.f322a.edit().putInt(a.g(), 0).apply();
                    } catch (Throwable th) {
                        this.f322a.edit().putInt(a.g(), 0).apply();
                        throw th;
                    }
                }
                i = 0;
                int i6 = this.f322a.getInt(a.h(), i);
                if (i6 > 0) {
                    try {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("net_type", "W");
                        jSONObject5.put("ptc", i6);
                        jSONObject5.put("start_time", valueOf3);
                        jSONObject5.put("end_time", valueOf4);
                        String jSONObject6 = jSONObject5.toString();
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put("event", "ptc_event");
                        a("category_lc_ptc", jSONObject6, hashMap5);
                        duv.O000000o("[HB] report ping timeout count events of wifi network.");
                        editor = this.f322a.edit().putInt(a.h(), 0);
                    } catch (Throwable th2) {
                        this.f322a.edit().putInt(a.h(), 0).apply();
                        throw th2;
                    }
                    editor.apply();
                }
                this.f320a = System.currentTimeMillis();
                this.f322a.edit().putLong(a.i(), this.f320a).apply();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.at.a(int, boolean):boolean
     arg types: [int, int]
     candidates:
      com.xiaomi.push.service.at.a(int, int):int
      com.xiaomi.push.service.at.a(com.xiaomi.push.hv, int):int
      com.xiaomi.push.service.at.a(int, long):long
      com.xiaomi.push.service.at.a(int, java.lang.String):java.lang.String
      com.xiaomi.push.service.at.a(java.util.List<android.util.Pair<com.xiaomi.push.hv, java.lang.Integer>>, java.util.List<android.util.Pair<java.lang.Integer, java.lang.Object>>):void
      com.xiaomi.push.service.at.a(int, boolean):boolean */
    /* renamed from: a  reason: collision with other method in class */
    public long m205a() {
        int a2;
        long O00000o0 = (long) eqh.O00000o0();
        boolean z = true;
        if (this.f328c && !m201b() && ((at.a(this.f321a).a(hu.bg.a(), true) || b() >= System.currentTimeMillis()) && (a2 = a()) != -1)) {
            O00000o0 = (long) a2;
        }
        if (!TextUtils.isEmpty(this.f323a) && !"WIFI-ID-UNKNOWN".equals(this.f323a) && this.f319a == 1) {
            if (O00000o0 >= 300000) {
                z = false;
            }
            a(z);
        }
        duv.O000000o("[HB] ping interval:".concat(String.valueOf(O00000o0)));
        return O00000o0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m206a() {
    }

    public void a(int i) {
        this.f322a.edit().putLong(a.j(), System.currentTimeMillis() + ((long) (i * 1000))).apply();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005a, code lost:
        return;
     */
    public synchronized void a(NetworkInfo networkInfo) {
        if (d()) {
            String str = null;
            if (networkInfo == null) {
                b(null);
                this.f319a = -1;
            } else if (networkInfo.getType() == 0) {
                String subtypeName = networkInfo.getSubtypeName();
                if (!TextUtils.isEmpty(subtypeName) && !"UNKNOWN".equalsIgnoreCase(subtypeName)) {
                    str = "M-".concat(String.valueOf(subtypeName));
                }
                b(str);
                this.f319a = 0;
            } else {
                if (networkInfo.getType() != 1) {
                    if (networkInfo.getType() != 6) {
                        b(null);
                        this.f319a = -1;
                        return;
                    }
                }
                b("WIFI-ID-UNKNOWN");
                this.f319a = 1;
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m207a(String str) {
        if (!TextUtils.isEmpty(str)) {
            e();
        }
        if (d() && !TextUtils.isEmpty(str)) {
            b("W-".concat(String.valueOf(str)));
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m208b() {
        if (d()) {
            f();
            if (this.f325a && !TextUtils.isEmpty(this.f323a) && this.f323a.equals(this.b)) {
                this.f324a.getAndIncrement();
                duv.O000000o("[HB] ping timeout count:" + this.f324a);
                if (m200a()) {
                    duv.O000000o("[HB] change hb interval for net:" + this.f323a);
                    c(this.f323a);
                    this.f325a = false;
                    this.f324a.getAndSet(0);
                    d(this.f323a);
                }
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m209c() {
        if (d()) {
            this.b = this.f323a;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m210d() {
        if (d()) {
            g();
            if (this.f325a) {
                this.f324a.getAndSet(0);
            }
        }
    }

    private void a(String str, String str2, Map<String, String> map) {
        ht htVar = new ht();
        htVar.d = str;
        htVar.c = "hb_name";
        htVar.f52a = "hb_channel";
        htVar.O000000o(1);
        htVar.f56b = str2;
        htVar.O000000o(false);
        htVar.O00000Oo(System.currentTimeMillis());
        htVar.g = this.f321a.getPackageName();
        htVar.e = "com.xiaomi.xmsf";
        if (map == null) {
            map = new HashMap<>();
        }
        String str3 = null;
        n a2 = o.m222a(this.f321a);
        if (a2 != null && !TextUtils.isEmpty(a2.f341a)) {
            String[] split = a2.f341a.split("@");
            if (split.length > 0) {
                str3 = split[0];
            }
        }
        map.put("uuid", str3);
        map.put("model", Build.MODEL);
        Context context = this.f321a;
        map.put("avc", String.valueOf(g.O00000Oo(context, context.getPackageName())));
        map.put("pvc", "40020");
        map.put("cvc", "47");
        htVar.f54a = map;
        err O000000o2 = err.O000000o(this.f321a);
        if (O000000o2 != null) {
            O000000o2.O000000o(htVar, this.f321a.getPackageName());
        }
    }
}
