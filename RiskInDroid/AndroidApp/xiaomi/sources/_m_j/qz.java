package _m_j;

import android.os.Build;
import android.os.SystemClock;
import android.util.ArrayMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class qz {

    /* renamed from: O000000o  reason: collision with root package name */
    Map<Long, O000000o> f2416O000000o;
    Map<Long, O000000o> O00000Oo;
    Map<Long, O000000o> O00000o;
    Map<Long, O000000o> O00000o0;
    Object O00000oO = new Object();
    Object O00000oo = new Object();

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f2417O000000o;
        long O00000Oo;
        boolean O00000o0;

        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    public qz() {
        Map<Long, O000000o> hashMap;
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2416O000000o = new ArrayMap();
            this.O00000Oo = new ArrayMap();
            this.O00000o0 = new ArrayMap();
            hashMap = new ArrayMap<>();
        } else {
            this.f2416O000000o = new HashMap();
            this.O00000Oo = new HashMap();
            this.O00000o0 = new HashMap();
            hashMap = new HashMap<>();
        }
        this.O00000o = hashMap;
    }

    static void O000000o(List<qy> list, Map<Long, O000000o> map, Map<Long, O000000o> map2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (map.isEmpty()) {
            for (qy next : list) {
                O000000o o000000o = new O000000o((byte) 0);
                o000000o.f2417O000000o = next.O00000Oo();
                o000000o.O00000Oo = elapsedRealtime;
                o000000o.O00000o0 = false;
                map2.put(Long.valueOf(next.O000000o()), o000000o);
            }
            return;
        }
        for (qy next2 : list) {
            long O000000o2 = next2.O000000o();
            O000000o o000000o2 = map.get(Long.valueOf(O000000o2));
            if (o000000o2 == null) {
                o000000o2 = new O000000o((byte) 0);
            } else if (o000000o2.f2417O000000o == next2.O00000Oo()) {
                map2.put(Long.valueOf(O000000o2), o000000o2);
            }
            o000000o2.f2417O000000o = next2.O00000Oo();
            o000000o2.O00000Oo = elapsedRealtime;
            o000000o2.O00000o0 = true;
            map2.put(Long.valueOf(O000000o2), o000000o2);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(float, float):float}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(long, long):long} */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        return r10;
     */
    static short O000000o(Map<Long, O000000o> map, long j) {
        synchronized (map) {
            O000000o o000000o = map.get(Long.valueOf(j));
            if (o000000o == null) {
                return 0;
            }
            short max = (short) ((int) Math.max(1L, Math.min(32767L, (SystemClock.elapsedRealtime() - o000000o.O00000Oo) / 1000)));
            if (!o000000o.O00000o0) {
                max = (short) (-max);
            }
        }
    }
}
