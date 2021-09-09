package _m_j;

import android.os.Build;
import android.os.CancellationSignal;

public final class al {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f12429O000000o;
    public Object O00000Oo;
    public boolean O00000o0;

    public final boolean O000000o() {
        boolean z;
        synchronized (this) {
            z = this.f12429O000000o;
        }
        return z;
    }

    public final Object O00000Oo() {
        Object obj;
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        synchronized (this) {
            if (this.O00000Oo == null) {
                this.O00000Oo = new CancellationSignal();
                if (this.f12429O000000o) {
                    ((CancellationSignal) this.O00000Oo).cancel();
                }
            }
            obj = this.O00000Oo;
        }
        return obj;
    }
}
