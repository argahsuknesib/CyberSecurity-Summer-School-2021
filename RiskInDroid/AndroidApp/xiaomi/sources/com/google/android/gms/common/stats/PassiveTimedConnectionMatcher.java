package com.google.android.gms.common.stats;

import _m_j.o0OO00OO;
import android.os.SystemClock;
import android.util.Log;

public class PassiveTimedConnectionMatcher {
    private final long zzym;
    private final int zzyn;
    private final o0OO00OO<String, Long> zzyo;

    public PassiveTimedConnectionMatcher() {
        this.zzym = 60000;
        this.zzyn = 10;
        this.zzyo = new o0OO00OO<>(10);
    }

    public PassiveTimedConnectionMatcher(int i, long j) {
        this.zzym = j;
        this.zzyn = i;
        this.zzyo = new o0OO00OO<>();
    }

    public Long get(String str) {
        Long l;
        synchronized (this) {
            l = this.zzyo.get(str);
        }
        return l;
    }

    public Long put(String str) {
        Long put;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.zzym;
        synchronized (this) {
            while (this.zzyo.size() >= this.zzyn) {
                for (int size = this.zzyo.size() - 1; size >= 0; size--) {
                    if (elapsedRealtime - this.zzyo.O00000o0(size).longValue() > j) {
                        this.zzyo.O00000o(size);
                    }
                }
                j /= 2;
                int i = this.zzyn;
                StringBuilder sb = new StringBuilder(94);
                sb.append("The max capacity ");
                sb.append(i);
                sb.append(" is not enough. Current durationThreshold is: ");
                sb.append(j);
                Log.w("ConnectionTracker", sb.toString());
            }
            put = this.zzyo.put(str, Long.valueOf(elapsedRealtime));
        }
        return put;
    }

    public boolean remove(String str) {
        boolean z;
        synchronized (this) {
            z = this.zzyo.remove(str) != null;
        }
        return z;
    }

    public boolean removeByPrefix(String str) {
        boolean z;
        synchronized (this) {
            z = false;
            for (int i = 0; i < size(); i++) {
                String O00000Oo = this.zzyo.O00000Oo(i);
                if (O00000Oo != null && O00000Oo.startsWith(str)) {
                    this.zzyo.remove(O00000Oo);
                    z = true;
                }
            }
        }
        return z;
    }

    public int size() {
        int size;
        synchronized (this) {
            size = this.zzyo.size();
        }
        return size;
    }
}
