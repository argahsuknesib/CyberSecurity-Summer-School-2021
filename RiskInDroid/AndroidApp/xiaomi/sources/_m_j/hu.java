package _m_j;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.Recreator;

public final class hu {

    /* renamed from: O000000o  reason: collision with root package name */
    public final ht f690O000000o = new ht();
    private final hv O00000Oo;

    private hu(hv hvVar) {
        this.O00000Oo = hvVar;
    }

    public final void O000000o(Bundle bundle) {
        Lifecycle lifecycle = this.O00000Oo.getLifecycle();
        if (lifecycle.O000000o() == Lifecycle.State.INITIALIZED) {
            lifecycle.O000000o(new Recreator(this.O00000Oo));
            this.f690O000000o.O000000o(lifecycle, bundle);
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public final void O00000Oo(Bundle bundle) {
        this.f690O000000o.O000000o(bundle);
    }

    public static hu O000000o(hv hvVar) {
        return new hu(hvVar);
    }
}
