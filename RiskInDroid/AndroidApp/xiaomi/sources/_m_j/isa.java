package _m_j;

import io.realm.internal.NativeObjectReference;
import io.realm.log.RealmLog;
import java.lang.ref.ReferenceQueue;

final class isa implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    private final ReferenceQueue<isc> f1597O000000o;

    isa(ReferenceQueue<isc> referenceQueue) {
        this.f1597O000000o = referenceQueue;
    }

    public final void run() {
        while (true) {
            try {
                ((NativeObjectReference) this.f1597O000000o.remove()).O000000o();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                RealmLog.O00000Oo("The FinalizerRunnable thread has been interrupted. Native resources cannot be freed anymore", new Object[0]);
                return;
            }
        }
    }
}
