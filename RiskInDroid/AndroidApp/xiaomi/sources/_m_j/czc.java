package _m_j;

import android.os.SystemClock;

public abstract class czc {

    /* renamed from: O000000o  reason: collision with root package name */
    private final String f14395O000000o;
    private boolean O00000Oo = false;

    /* access modifiers changed from: protected */
    public abstract void O000000o();

    public czc(String str) {
        this.f14395O000000o = str;
    }

    public final void O00000Oo() {
        O00000o0();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:6|(1:8)|9|10|11|12|13|(1:15)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x001c */
    private void O00000o0() {
        if (!this.O00000Oo) {
            synchronized (this) {
                if (!this.O00000Oo) {
                    long j = 0;
                    boolean O00000o0 = cvb.O00000o0();
                    if (O00000o0) {
                        j = SystemClock.uptimeMillis();
                    }
                    O000000o();
                    this.O00000Oo = true;
                    cvb.O0000OOo();
                    if (O00000o0) {
                        Object[] objArr = {this.f14395O000000o, Long.valueOf(SystemClock.uptimeMillis() - j)};
                        cvb.O00000o();
                    }
                }
            }
        }
    }
}
