package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.Iterator;

final class jnz extends Handler {

    /* renamed from: O000000o  reason: collision with root package name */
    private final WeakReference<jnw> f1990O000000o;

    jnz(jnw jnw) {
        super(Looper.getMainLooper());
        this.f1990O000000o = new WeakReference<>(jnw);
    }

    public final void handleMessage(Message message) {
        jnw jnw = this.f1990O000000o.get();
        if (jnw != null) {
            if (message.what == -1) {
                jnw.invalidateSelf();
                return;
            }
            Iterator<Object> it = jnw.O0000O0o.iterator();
            while (it.hasNext()) {
                it.next();
                int i = message.what;
            }
        }
    }
}
