package _m_j;

import android.content.Context;
import android.text.TextUtils;

public final class duw {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f14961O000000o;
    public boolean O00000Oo;
    public long O00000o;
    public boolean O00000o0;
    public long O00000oO;
    public long O00000oo;
    private String O0000O0o;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f14962O000000o = -1;
        public int O00000Oo = -1;
        public String O00000o = null;
        public int O00000o0 = -1;
        public long O00000oO = -1;
        public long O00000oo = -1;
        public long O0000O0o = -1;

        public final O000000o O000000o(boolean z) {
            this.f14962O000000o = z ? 1 : 0;
            return this;
        }

        public final duw O000000o(Context context) {
            return new duw(context, this, (byte) 0);
        }

        public final O000000o O00000Oo(boolean z) {
            this.O00000Oo = z ? 1 : 0;
            return this;
        }

        public final O000000o O00000o0(boolean z) {
            this.O00000o0 = z ? 1 : 0;
            return this;
        }
    }

    private duw() {
        this.f14961O000000o = true;
        this.O00000Oo = false;
        this.O00000o0 = false;
        this.O00000o = 1048576;
        this.O00000oO = 86400;
        this.O00000oo = 86400;
    }

    private duw(Context context, O000000o o000000o) {
        this.f14961O000000o = true;
        this.O00000Oo = false;
        this.O00000o0 = false;
        long j = 1048576;
        this.O00000o = 1048576;
        this.O00000oO = 86400;
        this.O00000oo = 86400;
        if (o000000o.f14962O000000o == 0) {
            this.f14961O000000o = false;
        } else {
            this.f14961O000000o = true;
        }
        this.O0000O0o = !TextUtils.isEmpty(o000000o.O00000o) ? o000000o.O00000o : emn.O000000o(context);
        this.O00000o = o000000o.O00000oO > -1 ? o000000o.O00000oO : j;
        if (o000000o.O00000oo > -1) {
            this.O00000oO = o000000o.O00000oo;
        } else {
            this.O00000oO = 86400;
        }
        if (o000000o.O0000O0o > -1) {
            this.O00000oo = o000000o.O0000O0o;
        } else {
            this.O00000oo = 86400;
        }
        if (o000000o.O00000Oo == 0 || o000000o.O00000Oo != 1) {
            this.O00000Oo = false;
        } else {
            this.O00000Oo = true;
        }
        if (o000000o.O00000o0 == 0 || o000000o.O00000o0 != 1) {
            this.O00000o0 = false;
        } else {
            this.O00000o0 = true;
        }
    }

    /* synthetic */ duw(Context context, O000000o o000000o, byte b) {
        this(context, o000000o);
    }

    public final String toString() {
        return "Config{mEventEncrypted=" + this.f14961O000000o + ", mAESKey='" + this.O0000O0o + '\'' + ", mMaxFileLength=" + this.O00000o + ", mEventUploadSwitchOpen=" + this.O00000Oo + ", mPerfUploadSwitchOpen=" + this.O00000o0 + ", mEventUploadFrequency=" + this.O00000oO + ", mPerfUploadFrequency=" + this.O00000oo + '}';
    }
}
