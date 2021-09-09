package _m_j;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.core.server.IServerHandle;
import com.xiaomi.smarthome.network.SmartHomeRequestManager$5;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class gzp {
    private static volatile gzp O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public List<O000000o> f18633O000000o = new CopyOnWriteArrayList();
    private Handler O00000o;
    private gpq O00000o0 = new gpq("SmartHomeRequestWorker");
    private Random O00000oO = new Random();

    private gzp() {
        this.O00000o0.start();
        this.O00000o = new Handler(this.O00000o0.getLooper());
    }

    public static gzp O000000o() {
        if (O00000Oo == null) {
            synchronized (gzp.class) {
                if (O00000Oo == null) {
                    O00000Oo = new gzp();
                }
            }
        }
        return O00000Oo;
    }

    public final <R> fsn O000000o(Context context, NetRequest netRequest, fss<R> fss, Crypto crypto, fsm<R, fso> fsm) {
        return O00000Oo(context, netRequest, fss, crypto, fsm);
    }

    private <R> fsn O00000Oo(Context context, NetRequest netRequest, fss<R> fss, Crypto crypto, fsm<R, fso> fsm) {
        int i;
        IServerHandle iServerHandle;
        NetRequest netRequest2 = netRequest;
        Crypto crypto2 = crypto;
        fsm<R, fso> fsm2 = fsm;
        if (context != null) {
            i = context.hashCode();
        } else {
            i = 0;
        }
        long nextLong = this.O00000oO.nextLong();
        AnonymousClass1 r1 = new fdh<NetResult, NetError>(fss, fsm, false, nextLong) {
            /* class _m_j.gzp.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ fss f18634O000000o;
            final /* synthetic */ fsm O00000Oo;
            final /* synthetic */ long O00000o;
            final /* synthetic */ boolean O00000o0 = false;

            {
                this.f18634O000000o = r2;
                this.O00000Oo = r3;
                this.O00000o = r5;
            }

            public final /* synthetic */ void onFailure(Error error) {
                fso fso;
                NetError netError = (NetError) error;
                if (!TextUtils.isEmpty(netError.O00000o0)) {
                    fso = new fso(netError.f6718O000000o, netError.O00000Oo, netError.O00000o0);
                } else {
                    fso = new fso(netError.f6718O000000o, netError.O00000Oo);
                }
                fsm fsm = this.O00000Oo;
                if (fsm != null) {
                    fsm.sendFailureMessage(fso);
                }
                if (!(this.O00000Oo instanceof fsy)) {
                    gzp.this.O000000o(this.O00000o);
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                NetResult netResult = (NetResult) obj;
                fsx.O000000o().O000000o(netResult, this.f18634O000000o, this.O00000Oo, this.O00000o0);
                if (!netResult.O00000Oo && !(this.O00000Oo instanceof fsy)) {
                    gzp.this.O000000o(this.O00000o);
                }
            }
        };
        boolean z = fsm2 instanceof fsy;
        if (z) {
            try {
                ((fsy) fsm2).setUseSyncLockMode();
                Object syncLock = ((fsy) fsm2).getSyncLock();
                synchronized (syncLock) {
                    iServerHandle = O000000o(netRequest2, crypto2, r1);
                    syncLock.wait();
                }
                fsy fsy = (fsy) fsm2;
                if (fsy.isSuccess()) {
                    fsm2.onSuccess(fsy.getResult());
                } else {
                    fsm2.onFailure(fsy.getError());
                }
            } catch (Throwable th) {
                if (fsm2 != null) {
                    fsm2.sendFailureMessage(new fso(-9999, th.getMessage()));
                }
                return new fsn(null);
            }
        } else {
            try {
                iServerHandle = O000000o(netRequest2, crypto2, r1);
            } catch (Throwable th2) {
                Throwable th3 = th2;
                if (fsm2 != null) {
                    fsm2.sendFailureMessage(new fso(-9999, th3.getMessage()));
                }
                return new fsn(null);
            }
        }
        fsn fsn = new fsn(iServerHandle);
        if (!z) {
            final long j = nextLong;
            final fsn fsn2 = fsn;
            final int i2 = i;
            this.O00000o.post(new Runnable() {
                /* class _m_j.gzp.AnonymousClass2 */

                public final void run() {
                    O000000o o000000o = new O000000o((byte) 0);
                    o000000o.f18637O000000o = j;
                    o000000o.O00000o0 = new WeakReference<>(fsn2);
                    o000000o.O00000Oo = i2;
                    gzp.this.f18633O000000o.add(o000000o);
                }
            });
        }
        return fsn;
    }

    public final void O000000o(final long j) {
        this.O00000o.post(new Runnable() {
            /* class _m_j.gzp.AnonymousClass3 */

            public final void run() {
                int i = 0;
                while (i < gzp.this.f18633O000000o.size()) {
                    if (gzp.this.f18633O000000o.get(i).f18637O000000o == j) {
                        gzp.this.f18633O000000o.remove(i);
                        i--;
                    }
                    i++;
                }
            }
        });
    }

    private IServerHandle O000000o(NetRequest netRequest, Crypto crypto, fdh<NetResult, NetError> fdh) {
        SmartHomeRequestManager$5 smartHomeRequestManager$5 = new SmartHomeRequestManager$5(this, crypto, netRequest, fdh);
        smartHomeRequestManager$5.execute();
        return smartHomeRequestManager$5;
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        long f18637O000000o;
        int O00000Oo;
        WeakReference<fsn> O00000o0;

        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }
    }
}
