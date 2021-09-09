package _m_j;

import android.util.Log;
import android.view.View;
import java.util.HashSet;
import java.util.List;

public abstract class iqd<T> {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<T> f1552O000000o;
    public O000000o O00000Oo;
    @Deprecated
    public HashSet<Integer> O00000o0;

    public interface O000000o {
    }

    public abstract View O000000o();

    public final T O000000o(int i) {
        return this.f1552O000000o.get(i);
    }

    public static void O00000Oo(int i) {
        Log.d("zhy", "onSelected ".concat(String.valueOf(i)));
    }
}
