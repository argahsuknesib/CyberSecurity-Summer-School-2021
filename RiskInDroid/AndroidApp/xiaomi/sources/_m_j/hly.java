package _m_j;

import android.os.Looper;
import android.util.SparseArray;
import android.view.View;

public final class hly {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final SparseArray<View> f19055O000000o = new SparseArray<>();

    public static View O000000o(int i) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return null;
        }
        View view = f19055O000000o.get(i);
        if (view == null) {
            return view;
        }
        f19055O000000o.remove(i);
        return view;
    }
}
