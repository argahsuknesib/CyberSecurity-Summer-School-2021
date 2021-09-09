package _m_j;

import android.util.SparseIntArray;
import java.util.List;

public abstract class vy<T> {
    public SparseIntArray O00000Oo;
    public boolean O00000o;
    public boolean O00000o0;

    /* access modifiers changed from: protected */
    public abstract int O000000o(T t);

    public final int O000000o(List<T> list, int i) {
        T t = list.get(i);
        if (t != null) {
            return O000000o(t);
        }
        return -255;
    }
}
