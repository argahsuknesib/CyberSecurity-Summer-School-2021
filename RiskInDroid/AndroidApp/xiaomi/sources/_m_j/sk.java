package _m_j;

import android.location.GpsStatus;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class sk {

    /* renamed from: O000000o  reason: collision with root package name */
    final List<O000000o> f2459O000000o = new CopyOnWriteArrayList();
    sl O00000Oo;
    GpsStatus.NmeaListener O00000o;
    OnNmeaMessageListener O00000o0;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Handler f2462O000000o;
        sf O00000Oo;

        /* renamed from: _m_j.sk$O000000o$O000000o  reason: collision with other inner class name */
        static class C0010O000000o extends Handler {

            /* renamed from: O000000o  reason: collision with root package name */
            private sf f2463O000000o;

            C0010O000000o(sf sfVar, Looper looper) {
                super(looper);
                this.f2463O000000o = sfVar;
            }

            public final void handleMessage(Message message) {
                Bundle data = message.getData();
                sf sfVar = this.f2463O000000o;
                long j = data.getLong("timestamp");
                data.getString("nmea");
                sfVar.O000000o(j);
            }
        }

        O000000o(sf sfVar, Looper looper) {
            this.O00000Oo = sfVar;
            this.f2462O000000o = new C0010O000000o(this.O00000Oo, looper == null ? Looper.getMainLooper() : looper);
        }
    }

    public sk(sl slVar) {
        this.O00000Oo = slVar;
        if (Build.VERSION.SDK_INT >= 24) {
            this.O00000o0 = new OnNmeaMessageListener() {
                /* class _m_j.sk.AnonymousClass1 */

                public final void onNmeaMessage(String str, long j) {
                    sk.this.O000000o(j, str);
                }
            };
        } else {
            this.O00000o = new GpsStatus.NmeaListener() {
                /* class _m_j.sk.AnonymousClass2 */

                public final void onNmeaReceived(long j, String str) {
                    sk.this.O000000o(j, str);
                }
            };
        }
    }

    /* access modifiers changed from: package-private */
    public final O000000o O000000o(sf sfVar) {
        for (O000000o next : this.f2459O000000o) {
            if (next.O00000Oo == sfVar) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005c, code lost:
        return r0;
     */
    public final boolean O000000o(sf sfVar, Looper looper) {
        boolean z = false;
        if (sfVar == null) {
            return false;
        }
        synchronized (this.f2459O000000o) {
            O000000o O000000o2 = O000000o(sfVar);
            if (O000000o2 != null) {
                if (looper == null) {
                    looper = Looper.getMainLooper();
                }
                if (O000000o2.O00000Oo == sfVar && O000000o2.f2462O000000o.getLooper() == looper) {
                    z = true;
                }
            } else {
                O000000o o000000o = new O000000o(sfVar, looper);
                this.f2459O000000o.add(o000000o);
                if (this.f2459O000000o.size() != 1) {
                    return true;
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    if (this.O00000o0 != null) {
                        z = this.O00000Oo.O000000o(this.O00000o0);
                    }
                } else if (this.O00000o != null) {
                    z = this.O00000Oo.O000000o(this.O00000o);
                }
                if (!z) {
                    this.f2459O000000o.remove(o000000o);
                }
            }
        }
    }

    public final void O000000o(long j, String str) {
        synchronized (this.f2459O000000o) {
            for (O000000o o000000o : this.f2459O000000o) {
                Message obtainMessage = o000000o.f2462O000000o.obtainMessage();
                obtainMessage.getData().putLong("timestamp", j);
                obtainMessage.getData().putString("nmea", str);
                obtainMessage.sendToTarget();
            }
        }
    }
}
