package _m_j;

import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public final class cny {

    /* renamed from: O000000o  reason: collision with root package name */
    public final ImageLoaderConfiguration f14159O000000o;
    public Executor O00000Oo;
    Executor O00000o;
    public Executor O00000o0;
    final Map<Integer, String> O00000oO = Collections.synchronizedMap(new HashMap());
    final Map<String, ReentrantLock> O00000oo = new WeakHashMap();
    public final AtomicBoolean O0000O0o = new AtomicBoolean(false);
    public final AtomicBoolean O0000OOo = new AtomicBoolean(false);
    public final Object O0000Oo = new Object();
    public final AtomicBoolean O0000Oo0 = new AtomicBoolean(false);

    cny(ImageLoaderConfiguration imageLoaderConfiguration) {
        this.f14159O000000o = imageLoaderConfiguration;
        this.O00000Oo = imageLoaderConfiguration.O0000O0o;
        this.O00000o0 = imageLoaderConfiguration.O0000OOo;
        this.O00000o = Executors.newCachedThreadPool(DefaultConfigurationFactory.O000000o(5, "uil-pool-d-"));
    }

    public final void O000000o() {
        if (!this.f14159O000000o.O0000Oo0 && ((ExecutorService) this.O00000Oo).isShutdown()) {
            this.O00000Oo = O00000Oo();
        }
        if (!this.f14159O000000o.O0000Oo && ((ExecutorService) this.O00000o0).isShutdown()) {
            this.O00000o0 = O00000Oo();
        }
    }

    private Executor O00000Oo() {
        return DefaultConfigurationFactory.O000000o(this.f14159O000000o.O0000OoO, this.f14159O000000o.O0000Ooo, this.f14159O000000o.O0000o00);
    }

    public final String O000000o(cok cok) {
        return this.O00000oO.get(Integer.valueOf(cok.O00000oo()));
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(cok cok) {
        this.O00000oO.remove(Integer.valueOf(cok.O00000oo()));
    }

    public final void O000000o(Runnable runnable) {
        this.O00000o.execute(runnable);
    }

    /* access modifiers changed from: package-private */
    public final ReentrantLock O000000o(String str) {
        ReentrantLock reentrantLock = this.O00000oo.get(str);
        if (reentrantLock != null) {
            return reentrantLock;
        }
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.O00000oo.put(str, reentrantLock2);
        return reentrantLock2;
    }
}
