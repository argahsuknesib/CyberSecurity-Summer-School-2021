package _m_j;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;

public final class bwy {

    /* renamed from: O000000o  reason: collision with root package name */
    volatile O00000Oo f13369O000000o = new O00000Oo((byte) 0);
    bsr O00000Oo = new bsr("HttpsDecisionUtil");

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static bwy f13370O000000o = new bwy();
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        protected boolean f13371O000000o;
        boolean O00000Oo;
        private final boolean O00000o;
        private int O00000o0;

        private O00000Oo() {
            this.O00000o0 = 0;
            this.f13371O000000o = true;
            this.O00000o = true;
            this.O00000Oo = false;
        }

        /* synthetic */ O00000Oo(byte b) {
            this();
        }

        public final void O000000o(Context context) {
            if (context != null && this.O00000o0 <= 0 && Build.VERSION.SDK_INT >= 4) {
                this.O00000o0 = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        }

        public final void O000000o(boolean z) {
            this.f13371O000000o = z;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x002e A[RETURN] */
        public final boolean O000000o() {
            boolean z;
            if (!this.O00000Oo) {
                boolean z2 = Build.VERSION.SDK_INT >= 28;
                if (this.f13371O000000o) {
                    int i = this.O00000o0;
                    if (i <= 0) {
                        i = 28;
                    }
                    if (!(i >= 28)) {
                        z = false;
                        return !(!z2 && z);
                    }
                }
                z = true;
                if (!(!z2 && z)) {
                }
            }
        }
    }

    public static String O000000o(String str) {
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

    public static boolean O000000o() {
        return Build.VERSION.SDK_INT == 19;
    }

    public final void O000000o(Context context) {
        if (this.f13369O000000o == null) {
            this.f13369O000000o = new O00000Oo((byte) 0);
        }
        this.f13369O000000o.O000000o(this.O00000Oo.O000000o(context, "isTargetRequired"));
        this.f13369O000000o.O000000o(context);
    }

    public final void O000000o(boolean z) {
        if (this.f13369O000000o == null) {
            this.f13369O000000o = new O00000Oo((byte) 0);
        }
        this.f13369O000000o.O00000Oo = z;
    }
}
