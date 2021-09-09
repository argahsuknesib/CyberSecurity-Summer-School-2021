package com.amap.api.services.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

@cq(a = "a")
public class by {
    @cr(a = "a1", b = 6)

    /* renamed from: a  reason: collision with root package name */
    private String f3357a;
    @cr(a = "a2", b = 6)
    private String b;
    @cr(a = "a6", b = 2)
    private int c;
    @cr(a = "a3", b = 6)
    private String d;
    @cr(a = "a4", b = 6)
    private String e;
    @cr(a = "a5", b = 6)
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String[] l;

    public static String g() {
        return "a6=1";
    }

    private by() {
        this.c = 1;
        this.l = null;
    }

    private by(a aVar) {
        this.c = 1;
        this.l = null;
        this.g = aVar.f3358a;
        this.h = aVar.b;
        this.j = aVar.c;
        this.i = aVar.d;
        this.c = aVar.e ? 1 : 0;
        this.k = aVar.f;
        this.l = aVar.g;
        this.b = bz.b(this.h);
        this.f3357a = bz.b(this.j);
        this.d = bz.b(this.i);
        this.e = bz.b(a(this.l));
        this.f = bz.b(this.k);
    }

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f3358a;
        /* access modifiers changed from: private */
        public String b;
        /* access modifiers changed from: private */
        public String c;
        /* access modifiers changed from: private */
        public String d;
        /* access modifiers changed from: private */
        public boolean e = true;
        /* access modifiers changed from: private */
        public String f = "standard";
        /* access modifiers changed from: private */
        public String[] g = null;

        public a(String str, String str2, String str3) {
            this.f3358a = str2;
            this.b = str2;
            this.d = str3;
            this.c = str;
        }

        public a a(boolean z) {
            this.e = z;
            return this;
        }

        public a a(String[] strArr) {
            if (strArr != null) {
                this.g = (String[]) strArr.clone();
            }
            return this;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public by a() throws bo {
            if (this.g != null) {
                return new by(this);
            }
            throw new bo("sdk packages is null");
        }
    }

    public void a(boolean z) {
        this.c = z ? 1 : 0;
    }

    public String a() {
        if (TextUtils.isEmpty(this.j) && !TextUtils.isEmpty(this.f3357a)) {
            this.j = bz.c(this.f3357a);
        }
        return this.j;
    }

    public String b() {
        return this.g;
    }

    public String c() {
        if (TextUtils.isEmpty(this.h) && !TextUtils.isEmpty(this.b)) {
            this.h = bz.c(this.b);
        }
        return this.h;
    }

    public String d() {
        if (TextUtils.isEmpty(this.k) && !TextUtils.isEmpty(this.f)) {
            this.k = bz.c(this.f);
        }
        if (TextUtils.isEmpty(this.k)) {
            this.k = "standard";
        }
        return this.k;
    }

    public boolean e() {
        return this.c == 1;
    }

    public String[] f() {
        String[] strArr = this.l;
        if ((strArr == null || strArr.length == 0) && !TextUtils.isEmpty(this.e)) {
            this.l = b(bz.c(this.e));
        }
        return (String[]) this.l.clone();
    }

    private String[] b(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private String a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (String append : strArr) {
                sb.append(append);
                sb.append(";");
            }
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("a1", bz.b(str));
        return cp.a((Map<String, String>) hashMap);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return getClass() == obj.getClass() && hashCode() == ((by) obj).hashCode();
    }

    public int hashCode() {
        ch chVar = new ch();
        chVar.a(this.j).a(this.g).a(this.h).a((Object[]) this.l);
        return chVar.a();
    }
}
