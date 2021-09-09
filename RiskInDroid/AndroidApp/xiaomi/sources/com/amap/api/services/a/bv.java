package com.amap.api.services.a;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;

public class bv {

    /* renamed from: a  reason: collision with root package name */
    private volatile b f3354a = new b();
    private cv b = new cv("HttpsDecisionUtil");

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static bv f3355a = new bv();
    }

    public static bv a() {
        return a.f3355a;
    }

    public void a(Context context) {
        if (this.f3354a == null) {
            this.f3354a = new b();
        }
        this.f3354a.a(c(context));
        this.f3354a.a(context);
    }

    public void b(Context context) {
        d(context);
    }

    public void a(boolean z) {
        if (this.f3354a == null) {
            this.f3354a = new b();
        }
        this.f3354a.b(z);
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, boolean z) {
        if (this.f3354a == null) {
            this.f3354a = new b();
        }
        b(context, z);
        this.f3354a.a(z);
    }

    public boolean b() {
        if (this.f3354a == null) {
            this.f3354a = new b();
        }
        return this.f3354a.a();
    }

    private void b(Context context, boolean z) {
        this.b.a(context, "isTargetRequired", z);
    }

    private boolean c(Context context) {
        return this.b.b(context, "isTargetRequired", true);
    }

    private void d(Context context) {
        this.b.a(context, "isTargetRequired", true);
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        protected boolean f3356a;
        private int b;
        private final boolean c;
        private boolean d;

        private b() {
            this.b = 0;
            this.f3356a = true;
            this.c = true;
            this.d = false;
        }

        public void a(Context context) {
            if (context != null && this.b <= 0 && Build.VERSION.SDK_INT >= 4) {
                this.b = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        }

        public void a(boolean z) {
            this.f3356a = z;
        }

        public void b(boolean z) {
            this.d = z;
        }

        private int b() {
            int i = this.b;
            if (i <= 0) {
                return 28;
            }
            return i;
        }

        private boolean c() {
            return b() >= 28;
        }

        private boolean d() {
            return Build.VERSION.SDK_INT >= 28;
        }

        private boolean e() {
            return d() && (!this.f3356a || c());
        }

        public boolean a() {
            return this.d || e();
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("https")) {
            return str;
        }
        try {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.scheme("https");
            return buildUpon.build().toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT == 19;
    }

    public boolean b(boolean z) {
        if (c()) {
            return false;
        }
        if (z || b()) {
            return true;
        }
        return false;
    }
}
