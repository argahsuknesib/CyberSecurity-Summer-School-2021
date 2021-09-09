package androidx.lifecycle;

import _m_j.es;
import _m_j.ey;
import _m_j.fa;
import androidx.lifecycle.Lifecycle;

public class ReflectiveGenericLifecycleObserver implements ey {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Object f2884O000000o;
    private final es.O000000o O00000Oo = es.f15761O000000o.O00000Oo(this.f2884O000000o.getClass());

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f2884O000000o = obj;
    }

    public final void O000000o(fa faVar, Lifecycle.Event event) {
        es.O000000o o000000o = this.O00000Oo;
        Object obj = this.f2884O000000o;
        es.O000000o.O000000o(o000000o.f15762O000000o.get(event), faVar, event, obj);
        es.O000000o.O000000o(o000000o.f15762O000000o.get(Lifecycle.Event.ON_ANY), faVar, event, obj);
    }
}
