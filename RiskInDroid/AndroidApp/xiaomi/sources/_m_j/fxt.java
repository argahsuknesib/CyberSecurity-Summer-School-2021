package _m_j;

import com.facebook.react.bridge.ReactApplicationContext;
import java.lang.ref.Reference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class fxt {
    private static final fxt O00000Oo = new fxt();

    /* renamed from: O000000o  reason: collision with root package name */
    public List<O000000o> f17382O000000o = new CopyOnWriteArrayList();

    public static final fxt O000000o() {
        return O00000Oo;
    }

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Reference<ReactApplicationContext> f17386O000000o;
        public fxr O00000Oo;

        private O000000o() {
        }

        /* synthetic */ O000000o(fxt fxt, byte b) {
            this();
        }

        public final void O000000o() {
            fxr fxr = this.O00000Oo;
            this.O00000Oo = null;
            if (fxr != null) {
                try {
                    fxr.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.f17386O000000o = null;
        }
    }

    private fxt() {
    }

    public final O000000o O000000o(String str) {
        for (final O000000o next : this.f17382O000000o) {
            if (next.O00000Oo != null && next.O00000Oo.O000000o().equals(str)) {
                if ((next.f17386O000000o == null ? null : next.f17386O000000o.get()) != null) {
                    return next;
                }
                new Thread(new Runnable() {
                    /* class _m_j.fxt.AnonymousClass2 */

                    public final void run() {
                        next.O000000o();
                        fxt.this.f17382O000000o.remove(next);
                    }
                }).start();
                return null;
            }
        }
        return null;
    }
}
