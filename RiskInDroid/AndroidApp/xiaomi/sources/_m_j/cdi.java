package _m_j;

import _m_j.ccy;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public final class cdi {
    private static cdi O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public int f13662O000000o;
    public long O00000Oo;
    private boolean O00000o = false;
    private long O00000oO;
    private Handler O00000oo = new Handler(Looper.getMainLooper()) {
        /* class _m_j.cdi.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                ccy.O000000o().O000000o(new ccy.O000000o() {
                    /* class _m_j.cdi.AnonymousClass1.AnonymousClass1 */

                    public final void O000000o() {
                        if (cdi.this.O00000o0()) {
                            new cdf().O000000o(true);
                        }
                    }
                });
            }
        }
    };

    public static synchronized cdi O000000o() {
        cdi cdi;
        synchronized (cdi.class) {
            if (O00000o0 == null) {
                O00000o0 = new cdi();
            }
            cdi = O00000o0;
        }
        return cdi;
    }

    private cdi() {
    }

    public final void O00000Oo() {
        try {
            if (this.f13662O000000o == 4) {
                if (!this.O00000oo.hasMessages(1)) {
                    this.O00000oo.sendEmptyMessageDelayed(1, this.O00000Oo);
                }
            } else if (!this.O00000oo.hasMessages(1)) {
                if (this.f13662O000000o != 0) {
                    if (this.f13662O000000o != 1) {
                        this.O00000oo.sendEmptyMessage(1);
                        return;
                    }
                }
                this.O00000oo.sendEmptyMessageDelayed(1, cdf.O00000Oo());
            }
        } catch (Exception e) {
            cdc.O000000o("onEventRecorded exception: ", e);
        }
    }

    public final boolean O00000o0() {
        if (cdf.O000000o()) {
            cdc.O000000o("RemoteDataUploadManager isUploading, should NOT upload now");
            return false;
        }
        int i = this.f13662O000000o;
        if (i == 0) {
            return true;
        }
        if (i != 1) {
            if (i == 4) {
                cdh.O000000o();
                long O00000Oo2 = cdh.O00000Oo();
                if (!this.O00000o && O00000Oo2 - this.O00000oO <= this.O00000Oo) {
                    return false;
                }
                this.O00000o = false;
                this.O00000oO = O00000Oo2;
                return true;
            }
        } else if (cdd.O000000o(ccx.O000000o())) {
            return true;
        }
        return false;
    }
}
