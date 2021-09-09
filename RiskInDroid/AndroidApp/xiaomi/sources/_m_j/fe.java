package _m_j;

import androidx.lifecycle.LiveData;
import java.util.Iterator;
import java.util.Map;

public final class fe<T> extends fg<T> {

    /* renamed from: O000000o  reason: collision with root package name */
    private o0OoO00O<LiveData<?>, O000000o<?>> f16145O000000o = new o0OoO00O<>();

    public final <S> void O000000o(LiveData<S> liveData, fh<? super S> fhVar) {
        O000000o o000000o = new O000000o(liveData, fhVar);
        O000000o O000000o2 = this.f16145O000000o.O000000o(liveData, o000000o);
        if (O000000o2 != null && O000000o2.O00000Oo != fhVar) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        } else if (O000000o2 == null && hasActiveObservers()) {
            o000000o.O000000o();
        }
    }

    public final void onActive() {
        Iterator<Map.Entry<LiveData<?>, O000000o<?>>> it = this.f16145O000000o.iterator();
        while (it.hasNext()) {
            ((O000000o) it.next().getValue()).O000000o();
        }
    }

    public final void onInactive() {
        Iterator<Map.Entry<LiveData<?>, O000000o<?>>> it = this.f16145O000000o.iterator();
        while (it.hasNext()) {
            O000000o o000000o = (O000000o) it.next().getValue();
            o000000o.f16146O000000o.removeObserver(o000000o);
        }
    }

    static class O000000o<V> implements fh<V> {

        /* renamed from: O000000o  reason: collision with root package name */
        final LiveData<V> f16146O000000o;
        final fh<? super V> O00000Oo;
        int O00000o0 = -1;

        O000000o(LiveData<V> liveData, fh<? super V> fhVar) {
            this.f16146O000000o = liveData;
            this.O00000Oo = fhVar;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            this.f16146O000000o.observeForever(this);
        }

        public final void onChanged(V v) {
            if (this.O00000o0 != this.f16146O000000o.getVersion()) {
                this.O00000o0 = this.f16146O000000o.getVersion();
                this.O00000Oo.onChanged(v);
            }
        }
    }
}
