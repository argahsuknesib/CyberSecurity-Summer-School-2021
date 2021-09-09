package _m_j;

import _m_j.erm;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.xiaomi.push.fg;
import com.xiaomi.push.fh;
import com.xiaomi.push.service.XMPushService;

public final class erl implements eqe {

    /* renamed from: O000000o  reason: collision with root package name */
    XMPushService f15747O000000o;
    eqb O00000Oo;
    private int O00000o;
    Exception O00000o0;
    private String O00000oO;
    private long O00000oo = 0;
    private long O0000O0o = 0;
    private long O0000OOo = 0;
    private long O0000Oo = 0;
    private long O0000Oo0 = 0;
    private long O0000OoO = 0;

    erl(XMPushService xMPushService) {
        this.f15747O000000o = xMPushService;
        this.O00000oO = "";
        O00000Oo();
        int myUid = Process.myUid();
        try {
            this.O0000OoO = TrafficStats.getUidRxBytes(myUid);
            this.O0000Oo = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            duv.O000000o("Failed to obtain traffic data during initialization: ".concat(String.valueOf(e)));
            this.O0000OoO = -1;
            this.O0000Oo = -1;
        }
    }

    private void O00000Oo() {
        this.O0000O0o = 0;
        this.O0000Oo0 = 0;
        this.O00000oo = 0;
        this.O0000OOo = 0;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (emf.O000000o(this.f15747O000000o)) {
            this.O00000oo = elapsedRealtime;
        }
        if (this.f15747O000000o.m127c()) {
            this.O0000OOo = elapsedRealtime;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006e, code lost:
        return;
     */
    public final synchronized void O000000o() {
        if (this.f15747O000000o != null) {
            String O0000Oo02 = emf.O0000Oo0(this.f15747O000000o);
            boolean O00000Oo2 = emf.O00000Oo(this.f15747O000000o);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.O00000oo > 0) {
                this.O0000O0o += elapsedRealtime - this.O00000oo;
                this.O00000oo = 0;
            }
            if (this.O0000OOo != 0) {
                this.O0000Oo0 += elapsedRealtime - this.O0000OOo;
                this.O0000OOo = 0;
            }
            if (O00000Oo2) {
                if ((!TextUtils.equals(this.O00000oO, O0000Oo02) && this.O0000O0o > DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) || this.O0000O0o > 5400000) {
                    O00000o0();
                }
                this.O00000oO = O0000Oo02;
                if (this.O00000oo == 0) {
                    this.O00000oo = elapsedRealtime;
                }
                if (this.f15747O000000o.m127c()) {
                    this.O0000OOo = elapsedRealtime;
                }
            }
        }
    }

    public final void a(eqb eqb) {
        this.O00000o = 0;
        this.O00000o0 = null;
        this.O00000Oo = eqb;
        this.O00000oO = emf.O0000Oo0(this.f15747O000000o);
        ero.O000000o(fg.v.a());
    }

    public final void a(eqb eqb, int i, Exception exc) {
        long j;
        if (this.O00000o == 0 && this.O00000o0 == null) {
            this.O00000o = i;
            this.O00000o0 = exc;
            ero.O00000Oo(eqb.O00000oO(), exc);
        }
        if (i == 22 && this.O0000OOo != 0) {
            long O0000O0o2 = eqb.O0000O0o() - this.O0000OOo;
            if (O0000O0o2 < 0) {
                O0000O0o2 = 0;
            }
            this.O0000Oo0 += O0000O0o2 + ((long) (eqh.O00000o0() / 2));
            this.O0000OOo = 0;
        }
        O000000o();
        int myUid = Process.myUid();
        long j2 = -1;
        try {
            j2 = TrafficStats.getUidRxBytes(myUid);
            j = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            duv.O000000o("Failed to obtain traffic data: ".concat(String.valueOf(e)));
            j = -1;
        }
        duv.O00000o0("Stats rx=" + (j2 - this.O0000OoO) + ", tx=" + (j - this.O0000Oo));
        this.O0000OoO = j2;
        this.O0000Oo = j;
    }

    public final void a(eqb eqb, Exception exc) {
        ero.O000000o(fg.d.a(), 1, eqb.O00000oO(), emf.O00000Oo(this.f15747O000000o) ? 1 : 0);
        O000000o();
    }

    public final void b(eqb eqb) {
        O000000o();
        this.O0000OOo = SystemClock.elapsedRealtime();
        ero.O000000o(fg.v.a(), eqb.O00000oO(), eqb.O0000OoO());
    }

    private synchronized void O00000o0() {
        duv.O00000o0("stat connpt = " + this.O00000oO + " netDuration = " + this.O0000O0o + " ChannelDuration = " + this.O0000Oo0 + " channelConnectedTime = " + this.O0000OOo);
        fh fhVar = new fh();
        fhVar.f6380a = 0;
        fhVar.O000000o(fg.h.a());
        fhVar.f34a = this.O00000oO;
        fhVar.O00000o((int) (System.currentTimeMillis() / 1000));
        fhVar.O00000Oo((int) (this.O0000O0o / 1000));
        fhVar.O00000o0((int) (this.O0000Oo0 / 1000));
        erm.O000000o.f15749O000000o.O000000o(fhVar);
        O00000Oo();
    }
}
