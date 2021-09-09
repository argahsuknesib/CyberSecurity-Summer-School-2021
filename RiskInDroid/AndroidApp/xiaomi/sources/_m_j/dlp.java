package _m_j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class dlp {

    /* renamed from: O000000o  reason: collision with root package name */
    ExecutorService f14773O000000o;

    public dlp() {
        this.f14773O000000o = null;
        this.f14773O000000o = Executors.newSingleThreadExecutor();
    }

    public final void O000000o(Runnable runnable) {
        this.f14773O000000o.execute(runnable);
    }
}
