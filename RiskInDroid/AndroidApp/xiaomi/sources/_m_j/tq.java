package _m_j;

import _m_j.or;
import android.content.Context;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class tq extends tp {
    public tq() {
        super(2048);
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0266 A[EDGE_INSN: B:100:0x0266->B:67:0x0266 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01c0 A[Catch:{ Throwable -> 0x0315 }, LOOP:1: B:30:0x00a1->B:52:0x01c0, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0279 A[Catch:{ Throwable -> 0x0315 }, LOOP:3: B:72:0x0273->B:74:0x0279, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x028e A[Catch:{ Throwable -> 0x0315 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02eb A[Catch:{ Throwable -> 0x0315 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x02f2 A[Catch:{ Throwable -> 0x0315 }] */
    public final byte[] O000000o(Context context, ud udVar, tz tzVar, long j, List<pn> list) {
        int i;
        int i2;
        int i3;
        int size;
        int i4;
        int i5;
        int i6;
        int i7;
        long O000000o2;
        ud udVar2 = udVar;
        tz tzVar2 = tzVar;
        List<pn> list2 = list;
        super.O000000o();
        try {
            int O000000o3 = pw.O000000o(this.f2507O000000o, udVar2.f2527O000000o, udVar2.O00000Oo, udVar2.O00000o0, udVar2.O00000o, udVar2.O00000oO, udVar2.O00000oo, udVar2.O0000O0o, udVar2.O0000OOo, udVar2.O0000Oo0);
            byte b = 1;
            if (tzVar2 != null && tzVar2.O00000o0.size() > 0) {
                ArrayList<ua> arrayList = tzVar2.O00000o0;
                if (arrayList != null) {
                    if (arrayList.size() != 0) {
                        Iterator<ua> it = arrayList.iterator();
                        while (it.hasNext()) {
                            ua next = it.next();
                            if (next.f2523O000000o == 1) {
                                ue ueVar = (ue) next.O00000oo;
                                O000000o2 = qf.O000000o(ueVar.O00000o0, ueVar.O00000o);
                            } else if (next.f2523O000000o == 3) {
                                uf ufVar = (uf) next.O00000oo;
                                O000000o2 = qf.O000000o(ufVar.O00000o0, ufVar.O00000o);
                            } else if (next.f2523O000000o == 4) {
                                uh uhVar = (uh) next.O00000oo;
                                O000000o2 = qf.O000000o(uhVar.O00000o0, uhVar.O00000o);
                            } else if (next.f2523O000000o == 2) {
                                ty tyVar = (ty) next.O00000oo;
                                O000000o2 = qf.O000000o(tyVar.O00000Oo, tyVar.O00000o0);
                            }
                            next.O00000o = qf.O000000o(O000000o2);
                        }
                    }
                }
                int size2 = tzVar2.O00000o0.size();
                if (size2 > 0) {
                    int[] iArr = new int[size2];
                    int i8 = 0;
                    while (true) {
                        if (i8 < size2) {
                            ua uaVar = tzVar2.O00000o0.get(i8);
                            if (uaVar.f2523O000000o != b) {
                                i = O000000o3;
                                i6 = size2;
                                if (uaVar.f2523O000000o != 3) {
                                    if (uaVar.f2523O000000o != 2) {
                                        if (uaVar.f2523O000000o == 4) {
                                            uh uhVar2 = (uh) uaVar.O00000oo;
                                            i7 = qc.O000000o(this.f2507O000000o, uhVar2.f2531O000000o, uhVar2.O00000Oo, uhVar2.O00000o0, uhVar2.O00000o, uhVar2.O00000oO, uhVar2.O00000oo, uhVar2.O0000O0o, uhVar2.O0000OOo);
                                            i3 = -1;
                                        } else {
                                            i3 = -1;
                                            i7 = -1;
                                        }
                                        if (i7 != i3) {
                                            break;
                                        }
                                        iArr[i8] = pu.O000000o(this.f2507O000000o, uaVar.O00000Oo, uaVar.O00000o0, uaVar.O00000o, uaVar.f2523O000000o, i7);
                                        i8++;
                                        size2 = i6;
                                        O000000o3 = i;
                                        b = 1;
                                    } else {
                                        ty tyVar2 = (ty) uaVar.O00000oo;
                                        i7 = uaVar.O00000o0 == 0 ? pr.O000000o(this.f2507O000000o, tyVar2.f2520O000000o, tyVar2.O00000Oo, tyVar2.O00000o0, tyVar2.O00000o, tyVar2.O00000oO, tyVar2.O00000oo) : pr.O000000o(this.f2507O000000o, tyVar2.f2520O000000o, tyVar2.O00000Oo, tyVar2.O00000o0, tyVar2.O00000o, tyVar2.O00000oO, tyVar2.O00000oo, tyVar2.O0000O0o);
                                    }
                                } else {
                                    uf ufVar2 = (uf) uaVar.O00000oo;
                                    i7 = pz.O000000o(this.f2507O000000o, ufVar2.f2529O000000o, ufVar2.O00000Oo, ufVar2.O00000o0, ufVar2.O00000o, ufVar2.O00000oO, ufVar2.O00000oo, ufVar2.O0000O0o, ufVar2.O0000OOo);
                                }
                            } else {
                                ue ueVar2 = (ue) uaVar.O00000oo;
                                if (uaVar.O00000o0 == 0) {
                                    i7 = py.O000000o(this.f2507O000000o, ueVar2.O00000o0, ueVar2.O00000o, ueVar2.O00000oO, ueVar2.O0000Oo0);
                                    i = O000000o3;
                                    i6 = size2;
                                } else {
                                    i6 = size2;
                                    i = O000000o3;
                                    i7 = py.O000000o(this.f2507O000000o, ueVar2.f2528O000000o, ueVar2.O00000Oo, ueVar2.O00000o0, ueVar2.O00000o, ueVar2.O00000oO, ueVar2.O00000oo, ueVar2.O0000O0o, ueVar2.O0000OOo, ueVar2.O0000Oo0);
                                }
                            }
                            i3 = -1;
                            if (i7 != i3) {
                            }
                        } else {
                            i = O000000o3;
                            i3 = -1;
                            int O000000o4 = this.f2507O000000o.O000000o(tzVar2.O00000Oo);
                            int O000000o5 = ps.O000000o(this.f2507O000000o, iArr);
                            int size3 = tzVar2.O00000o.size();
                            int[] iArr2 = new int[size3];
                            for (int i9 = 0; i9 < size3; i9++) {
                                or.O000000o o000000o = tzVar2.O00000o.get(i9);
                                long elapsedRealtime = (SystemClock.elapsedRealtime() - o000000o.O0000OOo) / 1000;
                                if (elapsedRealtime > 32767 || elapsedRealtime < 0) {
                                    elapsedRealtime = 32767;
                                }
                                if (o000000o.f2372O000000o == 2) {
                                    i4 = qa.O000000o(this.f2507O000000o, o000000o.O00000oO, o000000o.O00000oo, o000000o.O0000O0o, (short) ((int) elapsedRealtime));
                                    i5 = 2;
                                } else {
                                    i4 = qb.O000000o(this.f2507O000000o, o000000o.O00000o0, o000000o.O00000o, (short) ((int) elapsedRealtime));
                                    i5 = 1;
                                }
                                iArr2[i9] = pt.O000000o(this.f2507O000000o, (byte) i5, i4);
                            }
                            i2 = ps.O000000o(this.f2507O000000o, O000000o4, tzVar2.f2521O000000o, O000000o5, ps.O00000Oo(this.f2507O000000o, iArr2));
                        }
                    }
                    i2 = -1;
                    if (list2 != null && list.size() > 0) {
                        for (pn next2 : list) {
                            next2.O00000o = qf.O00000Oo(next2.f2390O000000o);
                        }
                        size = list.size();
                        if (size > 0) {
                            int[] iArr3 = new int[size];
                            for (int i10 = 0; i10 < size; i10++) {
                                pn pnVar = list2.get(i10);
                                iArr3[i10] = qe.O000000o(this.f2507O000000o, pnVar.f2390O000000o == j && pnVar.f2390O000000o != -1, pnVar.f2390O000000o, pnVar.O00000Oo, this.f2507O000000o.O000000o(pnVar.O00000o0), pnVar.O00000o, pnVar.O00000oo);
                            }
                            i3 = qd.O000000o(this.f2507O000000o, qd.O000000o(this.f2507O000000o, iArr3));
                        }
                    }
                    po.O000000o(this.f2507O000000o);
                    po.O000000o(this.f2507O000000o, i);
                    if (i2 > 0) {
                        po.O00000o0(this.f2507O000000o, i2);
                    }
                    if (i3 > 0) {
                        po.O00000Oo(this.f2507O000000o, i3);
                    }
                    this.f2507O000000o.O00000o(po.O00000Oo(this.f2507O000000o));
                    return qi.O000000o(ql.O000000o(context), pc.O000000o(this.f2507O000000o.O00000o0()));
                }
            }
            i = O000000o3;
            i3 = -1;
            i2 = -1;
            while (r2.hasNext()) {
            }
            size = list.size();
            if (size > 0) {
            }
            po.O000000o(this.f2507O000000o);
            po.O000000o(this.f2507O000000o, i);
            if (i2 > 0) {
            }
            if (i3 > 0) {
            }
            this.f2507O000000o.O00000o(po.O00000Oo(this.f2507O000000o));
            return qi.O000000o(ql.O000000o(context), pc.O000000o(this.f2507O000000o.O00000o0()));
        } catch (Throwable unused) {
            return null;
        }
    }
}
