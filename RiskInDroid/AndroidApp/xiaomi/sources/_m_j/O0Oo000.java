package _m_j;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.util.Property;

@TargetApi(14)
public abstract class O0Oo000<T> extends Property<T, Integer> {
    public abstract void O000000o(T t, int i);

    @SuppressLint({"NewApi"})
    public /* synthetic */ void set(Object obj, Object obj2) {
        O000000o(obj, ((Integer) obj2).intValue());
    }

    public O0Oo000(String str) {
        super(Integer.class, null);
    }
}
