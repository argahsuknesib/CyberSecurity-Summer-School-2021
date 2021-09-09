package _m_j;

import io.realm.internal.NativeObjectReference;
import java.lang.ref.ReferenceQueue;

public final class isb {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final isb f1598O000000o = new isb();
    private static final ReferenceQueue<isc> O00000Oo = new ReferenceQueue<>();
    private static final Thread O00000o0 = new Thread(new isa(O00000Oo));

    static {
        O00000o0.setName("RealmFinalizingDaemon");
        O00000o0.start();
    }

    public final void O000000o(isc isc) {
        new NativeObjectReference(this, isc, O00000Oo);
    }
}
