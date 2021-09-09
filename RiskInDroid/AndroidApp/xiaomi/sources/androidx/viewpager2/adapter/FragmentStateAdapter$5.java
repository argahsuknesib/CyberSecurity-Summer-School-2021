package androidx.viewpager2.adapter;

import _m_j.ey;
import _m_j.fa;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;

public class FragmentStateAdapter$5 implements ey {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ Handler f3040O000000o;
    final /* synthetic */ Runnable O00000Oo;

    public final void O000000o(fa faVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f3040O000000o.removeCallbacks(this.O00000Oo);
            faVar.getLifecycle().O00000Oo(this);
        }
    }
}
