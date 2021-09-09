package _m_j;

import android.content.Context;
import android.os.Handler;

public class qm {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile qm f2401O000000o;
    private rm O00000Oo = new rm();
    private volatile boolean O00000o0 = false;

    private qm() {
    }

    public static qm O000000o() {
        if (f2401O000000o == null) {
            synchronized (qm.class) {
                if (f2401O000000o == null) {
                    f2401O000000o = new qm();
                }
            }
        }
        return f2401O000000o;
    }

    public final synchronized void O000000o(Context context, sm smVar) {
        if (!this.O00000o0) {
            this.O00000Oo.O000000o(context, smVar);
            this.O00000o0 = true;
        }
    }

    public final synchronized void O00000Oo() {
        if (this.O00000o0) {
            this.O00000Oo.O000000o();
            this.O00000o0 = false;
        }
    }

    /* JADX INFO: finally extract failed */
    public final void O000000o(to toVar) {
        rm rmVar = this.O00000Oo;
        if (toVar != null) {
            synchronized (rmVar.O00000oO) {
                if (!rmVar.O00000oO.contains(toVar)) {
                    rmVar.O00000o.readLock().lock();
                    try {
                        Handler handler = rmVar.O00000Oo;
                        if (handler != null) {
                            handler.post(new Runnable(toVar) {
                                /* class _m_j.rm.AnonymousClass1 */

                                /* renamed from: O000000o  reason: collision with root package name */
                                final /* synthetic */ to f2431O000000o;

                                {
                                    this.f2431O000000o = r2;
                                }

                                public final void run() {
                                    if (rm.this.O00000o0 != null) {
                                        pm pmVar = new pm();
                                        pmVar.O00000oO = rm.this.O00000o0.O00000oO;
                                        pmVar.O00000Oo = rm.this.O00000o0.O00000Oo;
                                        this.f2431O000000o.O000000o(pmVar);
                                    }
                                }
                            });
                        }
                        rmVar.O00000o.readLock().unlock();
                        rmVar.O00000oO.add(toVar);
                    } catch (Throwable th) {
                        rmVar.O00000o.readLock().unlock();
                        throw th;
                    }
                }
            }
        }
    }

    public final void O00000Oo(to toVar) {
        rm rmVar = this.O00000Oo;
        if (toVar != null) {
            synchronized (rmVar.O00000oO) {
                if (rmVar.O00000oO.contains(toVar)) {
                    rmVar.O00000oO.remove(toVar);
                }
            }
        }
    }
}
