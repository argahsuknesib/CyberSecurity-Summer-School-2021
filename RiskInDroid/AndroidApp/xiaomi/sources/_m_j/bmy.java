package _m_j;

public final class bmy {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f13124O000000o;
    private long O00000Oo;
    private volatile boolean O00000o0;

    public static class O000000o {
        /* access modifiers changed from: private */

        /* renamed from: O000000o  reason: collision with root package name */
        public static final bmy f13125O000000o = new bmy((byte) 0);
    }

    private bmy() {
        this.O00000o0 = false;
    }

    /* synthetic */ bmy(byte b) {
        this();
    }

    public final void O000000o() {
        if (this.O00000Oo == 0) {
            this.O00000Oo = System.currentTimeMillis();
        }
    }

    public final long O00000Oo() {
        if (this.O00000o0) {
            return -1;
        }
        this.O00000o0 = true;
        return this.O00000Oo - this.f13124O000000o;
    }
}
