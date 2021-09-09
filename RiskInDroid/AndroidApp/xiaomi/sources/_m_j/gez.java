package _m_j;

import _m_j.gfm;
import _m_j.gye;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class gez {
    private static gez O00000oO;
    private static AtomicBoolean O00000oo = new AtomicBoolean(false);

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<String, O00000Oo> f17609O000000o = new HashMap();
    public List<WeakReference<O000000o>> O00000Oo = new ArrayList();
    public List<KeyValuePair> O00000o;
    public Handler O00000o0 = new Handler(Looper.getMainLooper()) {
        /* class _m_j.gez.AnonymousClass1 */

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (gez.this.O00000o != null) {
                gfa.getInstance().checkAllFirmwareUpdate(gez.this.O00000o, new gye.O000000o() {
                    /* class _m_j.gez.AnonymousClass1.AnonymousClass1 */

                    public final void O000000o(boolean z, boolean z2, boolean z3) {
                        gez.this.O00000o0.removeMessages(945);
                        gez.this.O00000Oo();
                    }

                    public final void O000000o(boolean z, boolean z2, boolean z3, List<gey> list) {
                        for (Map.Entry next : gez.this.f17609O000000o.entrySet()) {
                            Iterator<gey> it = list.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (it.next().f17608O000000o.equals(next.getKey())) {
                                        gez.this.O00000o0.sendEmptyMessageDelayed(945, 1200);
                                        return;
                                    }
                                }
                            }
                        }
                        gez.this.O00000o0.removeMessages(945);
                    }

                    public final void O000000o() {
                        gez.this.O00000o0.removeMessages(945);
                        gez.this.O00000Oo();
                    }
                });
            }
        }
    };

    public interface O000000o {
        void O000000o(String str);

        void O000000o(String str, int i);

        void O00000Oo(String str);
    }

    private gez() {
    }

    public static gez O000000o() {
        if (O00000oo.compareAndSet(false, true)) {
            O00000oO = new gez();
        }
        return O00000oO;
    }

    public final void O000000o(String str) {
        O00000Oo remove = this.f17609O000000o.remove(str);
        if (remove != null) {
            remove.f17612O000000o.O000000o();
        }
    }

    public final void O000000o(String str, boolean z, int i) {
        O00000Oo o00000Oo = this.f17609O000000o.get(str);
        if (o00000Oo == null) {
            if (i <= 100) {
                o00000Oo = new O00000Oo(str, z);
                this.f17609O000000o.put(str, o00000Oo);
            } else {
                return;
            }
        }
        o00000Oo.f17612O000000o.O000000o(i);
    }

    public final void O00000Oo() {
        if (O00000oO != null) {
            this.O00000o0.removeCallbacksAndMessages(null);
            O00000oo.set(false);
            O00000oO = null;
        }
    }

    public final void O000000o(boolean z) {
        if (this.f17609O000000o.isEmpty() || z) {
            O00000Oo();
        } else {
            this.O00000o0.sendEmptyMessageDelayed(945, 1200);
        }
    }

    class O00000Oo implements gfm.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final gfm f17612O000000o;
        private final String O00000o0;

        O00000Oo(String str, boolean z) {
            this.O00000o0 = str;
            this.f17612O000000o = new gfn(str, z);
            this.f17612O000000o.O000000o(this);
        }

        public final void O000000o(int i) {
            gez gez = gez.this;
            String str = this.O00000o0;
            for (WeakReference<O000000o> weakReference : gez.O00000Oo) {
                O000000o o000000o = (O000000o) weakReference.get();
                if (o000000o != null) {
                    if (i == 100) {
                        o000000o.O000000o(str);
                        gez.O000000o(str);
                    } else {
                        o000000o.O000000o(str, i);
                    }
                }
            }
        }
    }
}
