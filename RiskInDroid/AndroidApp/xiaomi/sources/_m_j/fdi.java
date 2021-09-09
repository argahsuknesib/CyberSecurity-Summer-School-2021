package _m_j;

import java.lang.ref.WeakReference;
import okhttp3.Call;

public class fdi {

    /* renamed from: O000000o  reason: collision with root package name */
    private final WeakReference<Call> f16101O000000o;

    public fdi(Call call) {
        this.f16101O000000o = new WeakReference<>(call);
    }

    public void O000000o() {
        Call call = this.f16101O000000o.get();
        if (call != null) {
            call.cancel();
        }
    }

    public static class O000000o extends fdi {

        /* renamed from: O000000o  reason: collision with root package name */
        public fdi f16102O000000o;
        public boolean O00000Oo;

        public O000000o() {
            super(null);
        }

        public void O000000o() {
            this.O00000Oo = true;
            fdi fdi = this.f16102O000000o;
            if (fdi != null) {
                fdi.O000000o();
            }
        }
    }
}
