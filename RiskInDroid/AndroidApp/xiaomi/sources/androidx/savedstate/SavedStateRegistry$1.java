package androidx.savedstate;

import _m_j.ew;
import _m_j.fa;
import _m_j.ht;
import androidx.lifecycle.Lifecycle;

public class SavedStateRegistry$1 implements ew {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ ht f2973O000000o;

    public SavedStateRegistry$1(ht htVar) {
        this.f2973O000000o = htVar;
    }

    public final void O000000o(fa faVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_START) {
            this.f2973O000000o.O00000o0 = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            this.f2973O000000o.O00000o0 = false;
        }
    }
}
