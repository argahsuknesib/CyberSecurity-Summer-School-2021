package _m_j;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class blv {

    /* renamed from: O000000o  reason: collision with root package name */
    private SharedPreferences f13079O000000o;
    private List<String> O00000Oo;

    public static class O000000o {
        /* access modifiers changed from: private */

        /* renamed from: O000000o  reason: collision with root package name */
        public static final blv f13080O000000o = new blv((byte) 0);
    }

    private blv() {
        this.O00000Oo = null;
        try {
            if (blw.f13081O000000o != null) {
                this.f13079O000000o = blw.f13081O000000o.getSharedPreferences("fc_times", 0);
            }
        } catch (Throwable unused) {
        }
    }

    /* synthetic */ blv(byte b) {
        this();
    }

    private void O00000o0() {
        try {
            this.O00000Oo = new ArrayList(this.f13079O000000o.getStringSet("t", new HashSet()));
            bnc.O000000o(this.f13079O000000o, "l", System.currentTimeMillis());
            bnc.O000000o(this.f13079O000000o, "t", new HashSet());
        } catch (Exception unused) {
        }
    }

    public final synchronized List<String> O00000Oo() {
        ArrayList arrayList = new ArrayList();
        if (this.O00000Oo == null) {
            return arrayList;
        }
        arrayList.addAll(this.O00000Oo);
        this.O00000Oo = null;
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        O00000o0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0094, code lost:
        return true;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0090 */
    public final synchronized boolean O000000o() {
        if (this.f13079O000000o == null) {
            return true;
        }
        int i = this.f13079O000000o.getInt("n", 0);
        if (i == 0) {
            O00000o0();
            return true;
        }
        long j = this.f13079O000000o.getLong("l", 0);
        int abs = Math.abs(1048575 & i);
        if (abs > 2880) {
            abs = 2880;
        }
        if (((long) abs) * 60000 < Math.abs(System.currentTimeMillis() - j)) {
            O00000o0();
            return true;
        }
        int size = this.f13079O000000o.getStringSet("t", new HashSet()).size();
        int i2 = i >> 20;
        if (i2 > 100) {
            i2 = 100;
        }
        if (size >= i2) {
            O00000o0();
            return true;
        }
        HashSet hashSet = new HashSet(this.f13079O000000o.getStringSet("t", new HashSet()));
        hashSet.add(String.valueOf(System.currentTimeMillis()));
        bnc.O000000o(this.f13079O000000o, "t", hashSet);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0026, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public final synchronized void O000000o(int i, int i2) {
        if (this.f13079O000000o != null) {
            if (i <= 0 || i2 <= 0) {
                bnc.O000000o(this.f13079O000000o, "n", 0);
            } else {
                bnc.O000000o(this.f13079O000000o, "n", (i2 << 20) + i);
            }
        }
    }
}
