package _m_j;

import android.util.SparseArray;
import java.lang.ref.WeakReference;

public final class gpd {

    /* renamed from: O000000o  reason: collision with root package name */
    private static SparseArray<WeakReference<Object>> f18115O000000o = new SparseArray<>();

    public static synchronized void O000000o() {
        synchronized (gpd.class) {
            O000000o(1);
        }
    }

    private static synchronized void O000000o(int i) {
        synchronized (gpd.class) {
            O00000Oo(1);
        }
    }

    private static synchronized void O00000Oo(int i) {
        synchronized (gpd.class) {
            try {
                WeakReference weakReference = f18115O000000o.get(i);
                if (weakReference != null) {
                    weakReference.get();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
