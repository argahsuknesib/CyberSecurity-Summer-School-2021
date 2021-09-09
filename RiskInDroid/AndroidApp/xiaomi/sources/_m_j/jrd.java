package _m_j;

import android.support.v4.app.NotificationCompat;

public final class jrd {

    /* renamed from: O000000o  reason: collision with root package name */
    int f2087O000000o;
    int O00000Oo;
    final int[] O00000o = new int[10];
    int O00000o0;

    private boolean O00000o(int i) {
        return ((1 << i) & this.O00000o0) != 0;
    }

    private boolean O00000o0(int i) {
        return ((1 << i) & this.O00000Oo) != 0;
    }

    /* access modifiers changed from: package-private */
    public final int O000000o() {
        if ((this.f2087O000000o & 2) != 0) {
            return this.O00000o[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final jrd O000000o(int i, int i2, int i3) {
        if (i >= this.O00000o.length) {
            return this;
        }
        int i4 = 1 << i;
        this.f2087O000000o |= i4;
        this.O00000Oo = (i2 & 1) != 0 ? this.O00000Oo | i4 : this.O00000Oo & (i4 ^ -1);
        this.O00000o0 = (i2 & 2) != 0 ? this.O00000o0 | i4 : this.O00000o0 & (i4 ^ -1);
        this.O00000o[i] = i3;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(int i) {
        return ((1 << i) & this.f2087O000000o) != 0;
    }

    public final int O00000Oo() {
        if ((this.f2087O000000o & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
            return this.O00000o[7];
        }
        return 65536;
    }

    /* access modifiers changed from: package-private */
    public final int O00000Oo(int i) {
        int i2 = O00000o(i) ? 2 : 0;
        return O00000o0(i) ? i2 | 1 : i2;
    }
}
