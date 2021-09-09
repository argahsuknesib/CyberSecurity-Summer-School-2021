package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class gmv implements gmu, Handler.Callback, InvocationHandler {

    /* renamed from: O000000o  reason: collision with root package name */
    private Object f18021O000000o;
    private gmu O00000Oo;
    private boolean O00000o;
    private boolean O00000o0;
    private Handler O00000oO;

    public gmv(Object obj, gmu gmu, boolean z, boolean z2) {
        this.O00000o0 = z;
        this.O00000Oo = gmu;
        this.O00000o = z2;
        this.f18021O000000o = this.O00000o0 ? new WeakReference(obj) : obj;
        this.O00000oO = new Handler(Looper.getMainLooper(), this);
    }

    public final boolean O000000o(Object obj, Method method, Object[] objArr) {
        gmu gmu = this.O00000Oo;
        if (gmu == null) {
            return false;
        }
        try {
            return gmu.O000000o(obj, method, objArr);
        } catch (Exception e) {
            gnk.O00000Oo(gnk.O00000Oo(e));
            return false;
        }
    }

    private static Object O000000o(gmt gmt) {
        try {
            return gmt.O000000o();
        } catch (Throwable unused) {
            return null;
        }
    }

    public final boolean handleMessage(Message message) {
        ((gmt) message.obj).O000000o();
        return true;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Object obj2;
        if (this.O00000o0) {
            obj2 = ((WeakReference) this.f18021O000000o).get();
        } else {
            obj2 = this.f18021O000000o;
        }
        if (O000000o(obj2, method, objArr)) {
            return null;
        }
        gmt gmt = new gmt(obj2, method, objArr);
        if (!this.O00000o) {
            return O000000o(gmt);
        }
        this.O00000oO.obtainMessage(0, gmt).sendToTarget();
        return null;
    }
}
