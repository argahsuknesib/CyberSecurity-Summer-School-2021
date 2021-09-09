package _m_j;

import android.content.Context;
import com.tencent.wxop.stat.StatReportStrategy;

public final class dkv {
    private static volatile long O00000oo;
    /* access modifiers changed from: private */

    /* renamed from: O000000o  reason: collision with root package name */
    public dkk f14753O000000o;
    private StatReportStrategy O00000Oo = null;
    /* access modifiers changed from: private */
    public Context O00000o = null;
    /* access modifiers changed from: private */
    public boolean O00000o0 = false;
    private long O00000oO = System.currentTimeMillis();

    public dkv(dkk dkk) {
        this.f14753O000000o = dkk;
        this.O00000Oo = dkd.O000000o();
        this.O00000o0 = dkk.O00000oO();
        this.O00000o = dkk.O00000o();
    }

    private void O000000o(dmh dmh) {
        dmi.O00000Oo(dke.O0000oOO).O000000o(this.f14753O000000o, dmh);
    }

    private boolean O00000o() {
        if (dkd.O0000OOo <= 0) {
            return false;
        }
        if (this.O00000oO > dke.O0000OOo) {
            dke.O0000O0o.clear();
            long unused = dke.O0000OOo = this.O00000oO + dkd.O0000Oo0;
            if (dkd.O00000Oo()) {
                dlm O00000oO2 = dke.O0000o;
                O00000oO2.O000000o("clear methodsCalledLimitMap, nextLimitCallClearTime=" + dke.O0000OOo);
            }
        }
        Integer valueOf = Integer.valueOf(this.f14753O000000o.O00000Oo().a());
        Integer num = (Integer) dke.O0000O0o.get(valueOf);
        if (num != null) {
            dke.O0000O0o.put(valueOf, Integer.valueOf(num.intValue() + 1));
            if (num.intValue() <= dkd.O0000OOo) {
                return false;
            }
            if (dkd.O00000Oo()) {
                dlm O00000oO3 = dke.O0000o;
                O00000oO3.O00000oO("event " + this.f14753O000000o.O00000oo() + " was discard, cause of called limit, current:" + num + ", limit:" + dkd.O0000OOo + ", period:" + dkd.O0000Oo0 + " ms");
            }
            return true;
        }
        dke.O0000O0o.put(valueOf, 1);
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dkz.O000000o(_m_j.dkk, _m_j.dmh, boolean, boolean):void
     arg types: [_m_j.dkk, ?[OBJECT, ARRAY], boolean, int]
     candidates:
      _m_j.dkz.O000000o(_m_j.dkz, java.util.List, int, boolean):void
      _m_j.dkz.O000000o(_m_j.dkk, _m_j.dmh, boolean, boolean):void */
    private void O00000o0() {
        if (dkz.O000000o().O00000Oo <= 0 || !dkd.O0000o00) {
            O000000o(new dky(this));
            return;
        }
        dkz.O000000o().O000000o(this.f14753O000000o, (dmh) null, this.O00000o0, true);
        dkz.O000000o().O000000o(-1);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dkz.O000000o(_m_j.dkk, _m_j.dmh, boolean, boolean):void
     arg types: [_m_j.dkk, ?[OBJECT, ARRAY], boolean, int]
     candidates:
      _m_j.dkz.O000000o(_m_j.dkz, java.util.List, int, boolean):void
      _m_j.dkz.O000000o(_m_j.dkk, _m_j.dmh, boolean, boolean):void */
    public final void O000000o() {
        if (!O00000o()) {
            if (dkd.O0000o0 > 0 && this.O00000oO >= O00000oo) {
                dke.O00000oO(this.O00000o);
                O00000oo = this.O00000oO + dkd.O0000o0O;
                if (dkd.O00000Oo()) {
                    dlm O00000oO2 = dke.O0000o;
                    O00000oO2.O000000o("nextFlushTime=" + O00000oo);
                }
            }
            if (dkg.O000000o(this.O00000o).O00000Oo()) {
                if (dkd.O00000Oo()) {
                    dlm O00000oO3 = dke.O0000o;
                    O00000oO3.O000000o("sendFailedCount=" + dke.f14738O000000o);
                }
                if (!dke.O000000o()) {
                    O00000Oo();
                    return;
                }
                dkz.O000000o(this.O00000o).O000000o(this.f14753O000000o, (dmh) null, this.O00000o0, false);
                if (this.O00000oO - dke.O00000Oo > 1800000) {
                    dke.O00000o0(this.O00000o);
                    return;
                }
                return;
            }
            dkz.O000000o(this.O00000o).O000000o(this.f14753O000000o, (dmh) null, this.O00000o0, false);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dkz.O000000o(_m_j.dkk, _m_j.dmh, boolean, boolean):void
     arg types: [_m_j.dkk, ?[OBJECT, ARRAY], boolean, int]
     candidates:
      _m_j.dkz.O000000o(_m_j.dkz, java.util.List, int, boolean):void
      _m_j.dkz.O000000o(_m_j.dkk, _m_j.dmh, boolean, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dkz.O000000o(_m_j.dkk, _m_j.dmh, boolean, boolean):void
     arg types: [_m_j.dkk, _m_j.dkw, boolean, int]
     candidates:
      _m_j.dkz.O000000o(_m_j.dkz, java.util.List, int, boolean):void
      _m_j.dkz.O000000o(_m_j.dkk, _m_j.dmh, boolean, boolean):void */
    private void O00000Oo() {
        if (this.f14753O000000o.O0000o00 != null && this.f14753O000000o.O0000o00.O00000o) {
            this.O00000Oo = StatReportStrategy.INSTANT;
        }
        if (dkd.O0000Oo && dkg.O000000o(dke.O0000oOO).O000000o()) {
            this.O00000Oo = StatReportStrategy.INSTANT;
        }
        if (dkd.O00000Oo()) {
            dlm O00000oO2 = dke.O0000o;
            O00000oO2.O000000o("strategy=" + this.O00000Oo.name());
        }
        switch (dkq.f14749O000000o[this.O00000Oo.ordinal()]) {
            case 1:
                O00000o0();
                return;
            case 2:
                dkz.O000000o(this.O00000o).O000000o(this.f14753O000000o, (dmh) null, this.O00000o0, false);
                if (dkd.O00000Oo()) {
                    dlm O00000oO3 = dke.O0000o;
                    O00000oO3.O000000o("PERIOD currTime=" + this.O00000oO + ",nextPeriodSendTs=" + dke.O00000o0 + ",difftime=" + (dke.O00000o0 - this.O00000oO));
                }
                if (dke.O00000o0 == 0) {
                    dke.O00000o0 = dma.O000000o(this.O00000o, "last_period_ts");
                    if (this.O00000oO > dke.O00000o0) {
                        dke.O00000oo(this.O00000o);
                    }
                    long O0000Ooo = this.O00000oO + ((long) (dkd.O0000Ooo() * 60 * 1000));
                    if (dke.O00000o0 > O0000Ooo) {
                        dke.O00000o0 = O0000Ooo;
                    }
                    dmd.O000000o(this.O00000o).O000000o();
                }
                if (dkd.O00000Oo()) {
                    dlm O00000oO4 = dke.O0000o;
                    O00000oO4.O000000o("PERIOD currTime=" + this.O00000oO + ",nextPeriodSendTs=" + dke.O00000o0 + ",difftime=" + (dke.O00000o0 - this.O00000oO));
                }
                if (this.O00000oO > dke.O00000o0) {
                    dke.O00000oo(this.O00000o);
                    return;
                }
                return;
            case 3:
            case 4:
                dkz.O000000o(this.O00000o).O000000o(this.f14753O000000o, (dmh) null, this.O00000o0, false);
                return;
            case 5:
                dkz.O000000o(this.O00000o).O000000o(this.f14753O000000o, (dmh) new dkw(this), this.O00000o0, true);
                return;
            case 6:
                if (dkg.O000000o(dke.O0000oOO).O00000Oo == 1) {
                    O00000o0();
                    return;
                } else {
                    dkz.O000000o(this.O00000o).O000000o(this.f14753O000000o, (dmh) null, this.O00000o0, false);
                    return;
                }
            case 7:
                if (dlv.O00000oO(this.O00000o)) {
                    O000000o(new dkx(this));
                    return;
                }
                return;
            default:
                dlm O00000oO5 = dke.O0000o;
                O00000oO5.O00000o("Invalid stat strategy:" + dkd.O000000o());
                return;
        }
    }
}
