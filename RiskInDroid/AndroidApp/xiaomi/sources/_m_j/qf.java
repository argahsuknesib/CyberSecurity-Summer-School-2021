package _m_j;

import _m_j.qz;
import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class qf {

    /* renamed from: O000000o  reason: collision with root package name */
    private static qz f2392O000000o = new qz();

    public static class O000000o implements qy {

        /* renamed from: O000000o  reason: collision with root package name */
        private int f2393O000000o;
        private int O00000Oo;
        private int O00000o0;

        O000000o(int i, int i2, int i3) {
            this.f2393O000000o = i;
            this.O00000Oo = i2;
            this.O00000o0 = i3;
        }

        public final long O000000o() {
            return qf.O000000o(this.f2393O000000o, this.O00000Oo);
        }

        public final int O00000Oo() {
            return this.O00000o0;
        }
    }

    public static class O00000Oo implements qy {

        /* renamed from: O000000o  reason: collision with root package name */
        private long f2394O000000o;
        private int O00000Oo;

        O00000Oo(long j, int i) {
            this.f2394O000000o = j;
            this.O00000Oo = i;
        }

        public final long O000000o() {
            return this.f2394O000000o;
        }

        public final int O00000Oo() {
            return this.O00000Oo;
        }
    }

    public static long O000000o(int i, int i2) {
        return (((long) i2) & 4294967295L) | ((((long) i) & 4294967295L) << 32);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a8, code lost:
        return;
     */
    public static synchronized void O000000o(List<ua> list) {
        O000000o o000000o;
        synchronized (qf.class) {
            if (list != null) {
                if (!list.isEmpty()) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (ua next : list) {
                        if (next.f2523O000000o == 1) {
                            ue ueVar = (ue) next.O00000oo;
                            o000000o = new O000000o(ueVar.O00000o0, ueVar.O00000o, ueVar.O00000oO);
                        } else if (next.f2523O000000o == 3) {
                            uf ufVar = (uf) next.O00000oo;
                            o000000o = new O000000o(ufVar.O00000o0, ufVar.O00000o, ufVar.O00000oo);
                        } else if (next.f2523O000000o == 4) {
                            uh uhVar = (uh) next.O00000oo;
                            o000000o = new O000000o(uhVar.O00000o0, uhVar.O00000o, uhVar.O00000oo);
                        } else if (next.f2523O000000o == 2) {
                            ty tyVar = (ty) next.O00000oo;
                            o000000o = new O000000o(tyVar.O00000Oo, tyVar.O00000o0, tyVar.O00000oo);
                        }
                        arrayList.add(o000000o);
                    }
                    qz qzVar = f2392O000000o;
                    if (!arrayList.isEmpty()) {
                        synchronized (qzVar.O00000oO) {
                            qz.O000000o(arrayList, qzVar.f2416O000000o, qzVar.O00000Oo);
                            Map<Long, qz.O000000o> map = qzVar.f2416O000000o;
                            qzVar.f2416O000000o = qzVar.O00000Oo;
                            qzVar.O00000Oo = map;
                            qzVar.O00000Oo.clear();
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0061, code lost:
        return;
     */
    public static synchronized void O00000Oo(List<ScanResult> list) {
        synchronized (qf.class) {
            if (list != null) {
                if (!list.isEmpty()) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (ScanResult next : list) {
                        arrayList.add(new O00000Oo(pe.O000000o(next.BSSID), next.level));
                    }
                    qz qzVar = f2392O000000o;
                    if (!arrayList.isEmpty()) {
                        synchronized (qzVar.O00000oo) {
                            qz.O000000o(arrayList, qzVar.O00000o0, qzVar.O00000o);
                            Map<Long, qz.O000000o> map = qzVar.O00000o0;
                            qzVar.O00000o0 = qzVar.O00000o;
                            qzVar.O00000o = map;
                            qzVar.O00000o.clear();
                        }
                    }
                }
            }
        }
    }

    public static synchronized short O000000o(long j) {
        short O000000o2;
        synchronized (qf.class) {
            O000000o2 = qz.O000000o(f2392O000000o.f2416O000000o, j);
        }
        return O000000o2;
    }

    public static synchronized short O00000Oo(long j) {
        short O000000o2;
        synchronized (qf.class) {
            O000000o2 = qz.O000000o(f2392O000000o.O00000o0, j);
        }
        return O000000o2;
    }

    public static synchronized void O000000o() {
        synchronized (qf.class) {
            qz qzVar = f2392O000000o;
            synchronized (qzVar.O00000oO) {
                qzVar.f2416O000000o.clear();
            }
            synchronized (qzVar.O00000oo) {
                qzVar.O00000o0.clear();
            }
        }
    }
}
