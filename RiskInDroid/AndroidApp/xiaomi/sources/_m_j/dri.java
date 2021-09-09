package _m_j;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.util.Property;

@TargetApi(14)
public abstract class dri<T> extends Property<T, Integer> {
    /* renamed from: O000000o */
    public Integer get(T t) {
        return null;
    }

    public abstract void O000000o(T t, int i);

    public /* synthetic */ void set(Object obj, Object obj2) {
        O000000o(obj, ((Integer) obj2).intValue());
    }

    public dri() {
        super(Integer.class, null);
    }

    @SuppressLint({"NewApi"})
    public final Property<T, Integer> O000000o() {
        return Build.VERSION.SDK_INT > 18 ? new O0Oo000<T>() {
            /* class _m_j.dri.AnonymousClass1 */

            public final void O000000o(T t, int i) {
                dri.this.O000000o(t, i);
            }

            public final /* synthetic */ Object get(Object obj) {
                return dri.this.get(obj);
            }
        } : this;
    }
}
