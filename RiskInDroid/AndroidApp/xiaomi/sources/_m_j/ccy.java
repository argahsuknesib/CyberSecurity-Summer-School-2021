package _m_j;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayList;
import java.util.Iterator;

public final class ccy {
    private static ccy O00000o;
    private static ccy O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public volatile Handler f13644O000000o;
    public ArrayList<O000000o> O00000Oo = new ArrayList<>();

    public interface O000000o {
        void O000000o();
    }

    public static synchronized ccy O000000o() {
        ccy ccy;
        synchronized (ccy.class) {
            if (O00000o0 == null) {
                O00000o0 = new ccy("local_job_dispatcher");
            }
            ccy = O00000o0;
        }
        return ccy;
    }

    private ccy(String str) {
        new O00000Oo(str).start();
    }

    public final void O000000o(final O000000o o000000o) {
        synchronized (this.O00000Oo) {
            if (this.f13644O000000o == null) {
                cdc.O000000o("AsyncJobDispatcher.mHander is null, add job to pending queue");
                this.O00000Oo.add(o000000o);
            } else {
                this.f13644O000000o.post(new Runnable() {
                    /* class _m_j.ccy.AnonymousClass1 */

                    public final void run() {
                        try {
                            o000000o.O000000o();
                        } catch (Exception e) {
                            cdc.O000000o("error while executing job.", e);
                        }
                    }
                });
            }
        }
    }

    public final void O000000o(final O000000o o000000o, final long j) {
        if (this.f13644O000000o != null) {
            this.f13644O000000o.postDelayed(new Runnable() {
                /* class _m_j.ccy.AnonymousClass2 */

                public final void run() {
                    try {
                        cdc.O000000o("AsyncJobDispatcher run a job with delay " + String.valueOf(j));
                        o000000o.O000000o();
                    } catch (Exception e) {
                        cdc.O000000o("error while executing job.", e);
                    }
                }
            }, j);
        } else {
            cdc.O000000o("drop the job as handler is not ready.", (Throwable) null);
        }
    }

    class O00000Oo extends HandlerThread {
        public O00000Oo(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        public final void onLooperPrepared() {
            ArrayList arrayList;
            ccy.this.f13644O000000o = new Handler();
            synchronized (ccy.this.O00000Oo) {
                if (!ccy.this.O00000Oo.isEmpty()) {
                    arrayList = (ArrayList) ccy.this.O00000Oo.clone();
                    String valueOf = String.valueOf(ccy.this.O00000Oo.size());
                    ccy.this.O00000Oo.clear();
                    cdc.O000000o("mPendingJob(cnt=" + valueOf + ") not empty, clone a job list and clear original list");
                } else {
                    arrayList = null;
                }
            }
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    O000000o o000000o = (O000000o) it.next();
                    try {
                        cdc.O000000o("execute a pending job");
                        o000000o.O000000o();
                    } catch (Exception e) {
                        cdc.O000000o("error while executing job.", e);
                    }
                }
            }
            super.onLooperPrepared();
        }
    }
}
