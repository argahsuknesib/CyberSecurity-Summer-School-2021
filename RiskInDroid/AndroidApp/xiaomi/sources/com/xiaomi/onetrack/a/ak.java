package com.xiaomi.onetrack.a;

import org.json.JSONException;
import org.json.JSONObject;

public class ak {
    /* access modifiers changed from: private */
    public String j;
    /* access modifiers changed from: private */
    public String k;
    /* access modifiers changed from: private */
    public String l;
    /* access modifiers changed from: private */
    public String m;
    /* access modifiers changed from: private */
    public String n;
    /* access modifiers changed from: private */
    public String o;
    /* access modifiers changed from: private */
    public String p;
    /* access modifiers changed from: private */
    public String q;
    /* access modifiers changed from: private */
    public String r;

    private ak() {
    }

    public String a() {
        return this.j;
    }

    public String b() {
        return this.k;
    }

    public String c() {
        return this.l;
    }

    public String d() {
        return this.m;
    }

    public String e() {
        return this.n;
    }

    public String f() {
        return this.o;
    }

    public String g() {
        return this.p;
    }

    public String h() {
        return this.q;
    }

    public String i() {
        return this.r;
    }

    public JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.j);
            jSONObject.put("gender", this.k);
            jSONObject.put("birthday", this.l);
            jSONObject.put("phone", this.m);
            jSONObject.put("job", this.n);
            jSONObject.put("hobby", this.o);
            jSONObject.put("region", this.p);
            jSONObject.put("province", this.q);
            jSONObject.put("city", this.r);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return j().toString();
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f6098a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;

        public final a a(String str) {
            this.f6098a = str;
            return this;
        }

        public final a b(String str) {
            this.b = str;
            return this;
        }

        public final a c(String str) {
            this.c = str;
            return this;
        }

        public final a d(String str) {
            this.d = str;
            return this;
        }

        public final a e(String str) {
            this.e = str;
            return this;
        }

        public final a f(String str) {
            this.f = str;
            return this;
        }

        public final a g(String str) {
            this.g = str;
            return this;
        }

        public final a h(String str) {
            this.h = str;
            return this;
        }

        public final a i(String str) {
            this.i = str;
            return this;
        }

        public final ak a() {
            ak akVar = new ak();
            String unused = akVar.o = this.f;
            String unused2 = akVar.n = this.e;
            String unused3 = akVar.r = this.i;
            String unused4 = akVar.m = this.d;
            String unused5 = akVar.q = this.h;
            String unused6 = akVar.l = this.c;
            String unused7 = akVar.j = this.f6098a;
            String unused8 = akVar.p = this.g;
            String unused9 = akVar.k = this.b;
            return akVar;
        }
    }
}
