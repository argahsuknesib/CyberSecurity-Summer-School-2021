package androidx.lifecycle;

import _m_j.eu;
import _m_j.ey;
import _m_j.fa;
import androidx.lifecycle.Lifecycle;

public class FullLifecycleObserverAdapter implements ey {

    /* renamed from: O000000o  reason: collision with root package name */
    private final eu f2876O000000o;
    private final ey O00000Oo;

    public FullLifecycleObserverAdapter(eu euVar, ey eyVar) {
        this.f2876O000000o = euVar;
        this.O00000Oo = eyVar;
    }

    public final void O000000o(fa faVar, Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
            case ON_START:
            case ON_RESUME:
            case ON_PAUSE:
            case ON_STOP:
            case ON_DESTROY:
            default:
                ey eyVar = this.O00000Oo;
                if (eyVar != null) {
                    eyVar.O000000o(faVar, event);
                    return;
                }
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
    }
}
