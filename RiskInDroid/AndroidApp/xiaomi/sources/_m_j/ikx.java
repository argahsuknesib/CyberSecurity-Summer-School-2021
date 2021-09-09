package _m_j;

import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.util.Log;

public final class ikx<T extends IInterface> extends RemoteCallbackList<T> {
    public final void onCallbackDied(T t, Object obj) {
        super.onCallbackDied(t, obj);
        unregister(t);
        if (obj != null && (obj instanceof O000000o)) {
            Log.e("XmPlayerService", "Process " + ((O000000o) obj).f1426O000000o + " died");
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f1426O000000o;
        private int O00000Oo;

        public O000000o(int i, int i2) {
            this.f1426O000000o = i;
            this.O00000Oo = i2;
        }
    }
}
