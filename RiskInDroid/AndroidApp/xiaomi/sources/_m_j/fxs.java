package _m_j;

import com.facebook.react.bridge.ReactApplicationContext;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

public final class fxs {
    private static final fxs O00000o0 = new fxs();

    /* renamed from: O000000o  reason: collision with root package name */
    public List<ExecutorService> f17379O000000o = new CopyOnWriteArrayList();
    public List<O000000o> O00000Oo = new CopyOnWriteArrayList();

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Reference<ReactApplicationContext> f17381O000000o;
        fxr O00000Oo;
        final /* synthetic */ fxs O00000o;
        ExecutorService O00000o0;
    }

    public static final fxs O000000o() {
        return O00000o0;
    }

    private fxs() {
    }

    public final void O00000Oo() {
        ArrayList<O000000o> arrayList = new ArrayList<>();
        arrayList.addAll(this.O00000Oo);
        this.O00000Oo.clear();
        for (final O000000o o000000o : arrayList) {
            if (o000000o.O00000o0 != null) {
                o000000o.O00000o0.execute(new Runnable() {
                    /* class _m_j.fxs.AnonymousClass1 */

                    public final void run() {
                        O000000o o000000o = o000000o;
                        fxr fxr = o000000o.O00000Oo;
                        o000000o.O00000Oo = null;
                        if (fxr != null) {
                            try {
                                fxr.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        o000000o.f17381O000000o = null;
                        if (o000000o.O00000o0 != null) {
                            o000000o.O00000o.f17379O000000o.add(o000000o.O00000o0);
                            o000000o.O00000o0 = null;
                        }
                    }
                });
            }
        }
    }
}
