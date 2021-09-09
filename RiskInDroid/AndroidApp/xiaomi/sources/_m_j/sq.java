package _m_j;

import android.content.Context;
import android.os.SystemClock;
import com.amap.openapi.dj;
import java.lang.reflect.Method;

public class sq {
    private static volatile sq O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    ss f2478O000000o;
    private sr O00000Oo;
    private long O00000o;

    public interface O000000o {
        void O000000o();
    }

    public static sq O000000o(Context context) {
        if (O00000o0 == null) {
            synchronized (sq.class) {
                if (O00000o0 == null) {
                    O00000o0 = new sq(context.getApplicationContext());
                }
            }
        }
        return O00000o0;
    }

    private sq(Context context) {
        this.f2478O000000o = new dj(context.getApplicationContext());
        this.O00000Oo = new sr(context, this.f2478O000000o);
    }

    public final boolean O000000o() {
        boolean z = false;
        if (sd.f2451O000000o > 0 && SystemClock.elapsedRealtime() - this.O00000o < sd.f2451O000000o) {
            return false;
        }
        try {
            ss ssVar = this.f2478O000000o;
            Object[] objArr = new Object[0];
            Method declaredMethod = ssVar.getClass().getDeclaredMethod("startScanActive", new Class[0]);
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            z = "true".equals(String.valueOf(declaredMethod.invoke(ssVar, objArr)));
        } catch (Exception unused) {
        }
        if (!z) {
            z = this.f2478O000000o.O00000Oo();
        }
        this.O00000o = SystemClock.elapsedRealtime();
        return z;
    }
}
