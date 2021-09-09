package _m_j;

import _m_j.dje;

public abstract class dja {

    /* renamed from: O000000o  reason: collision with root package name */
    djh f14711O000000o;
    private volatile int O00000Oo;
    private volatile boolean O00000o0;

    /* access modifiers changed from: protected */
    public abstract void O00000Oo(int i, Thread thread, long j, String str, String str2, Throwable th);

    public dja() {
        this(djd.f14713O000000o, true, djh.f14716O000000o);
    }

    public dja(int i, boolean z, djh djh) {
        this.O00000Oo = djd.f14713O000000o;
        this.O00000o0 = true;
        this.f14711O000000o = djh.f14716O000000o;
        this.O00000Oo = i;
        this.O00000o0 = true;
        this.f14711O000000o = djh;
    }

    public final void O000000o(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (this.O00000o0 && dje.O000000o.O000000o(this.O00000Oo, i)) {
            O00000Oo(i, thread, j, str, str2, th);
        }
    }
}
