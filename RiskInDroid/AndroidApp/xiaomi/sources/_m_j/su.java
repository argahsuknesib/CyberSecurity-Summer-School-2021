package _m_j;

import android.content.Context;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class su {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f2482O000000o = false;
    private static tc O00000Oo;
    private static final ReentrantReadWriteLock O00000o0 = new ReentrantReadWriteLock();

    public static void O000000o(Context context, st stVar) {
        try {
            O00000o0.writeLock().lock();
            if (O00000Oo == null) {
                O00000Oo = new tc(context.getApplicationContext(), stVar);
            }
        } finally {
            O00000o0.writeLock().unlock();
        }
    }

    public static void O000000o(int i) {
        try {
            O00000o0.readLock().lock();
            if (O00000Oo != null) {
                O00000Oo.O000000o(10, 1, i, null);
            }
        } finally {
            O00000o0.readLock().unlock();
        }
    }

    public static void O000000o(int i, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && bArr.length < 400000) {
            try {
                O00000o0.readLock().lock();
                if (O00000Oo != null) {
                    O00000Oo.O000000o(10, 2, i, bArr);
                }
            } finally {
                O00000o0.readLock().unlock();
            }
        }
    }

    public static void O000000o() {
        try {
            O00000o0.writeLock().lock();
            if (O00000Oo != null) {
                O00000Oo.O000000o(13, 0, 0, null);
                O00000Oo = null;
            }
        } finally {
            O00000o0.writeLock().unlock();
        }
    }
}
