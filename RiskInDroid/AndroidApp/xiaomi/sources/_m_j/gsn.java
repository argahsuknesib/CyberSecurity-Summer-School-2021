package _m_j;

import java.lang.ref.WeakReference;
import okhttp3.Call;

public class gsn {

    /* renamed from: O000000o  reason: collision with root package name */
    private final WeakReference<Call> f18219O000000o;

    public gsn(Call call) {
        this.f18219O000000o = new WeakReference<>(call);
    }

    public void O000000o() {
        Call call = this.f18219O000000o.get();
        if (call != null) {
            call.cancel();
        }
    }
}
