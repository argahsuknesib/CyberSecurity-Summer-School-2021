package _m_j;

import java.lang.ref.WeakReference;

public final class fjc {

    /* renamed from: O000000o  reason: collision with root package name */
    private final WeakReference<fdi> f16442O000000o;

    public fjc(fdi fdi) {
        this.f16442O000000o = new WeakReference<>(fdi);
    }

    public final void O000000o() {
        fdi fdi = this.f16442O000000o.get();
        if (fdi != null) {
            fdi.O000000o();
        }
    }
}
