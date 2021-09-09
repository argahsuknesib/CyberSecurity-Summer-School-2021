package _m_j;

import android.content.Context;
import android.text.TextUtils;

public final class btt extends btw {
    private Context O00000Oo;
    private int O00000o;
    private boolean O00000o0;
    private int O00000oO;

    public btt(Context context, boolean z, int i, int i2) {
        this.O00000Oo = context;
        this.O00000o0 = z;
        this.O00000o = i;
        this.O00000oO = i2;
    }

    public final void O000000o(int i) {
        if (bww.O0000o(this.O00000Oo) != 1) {
            String O000000o2 = brs.O000000o(System.currentTimeMillis(), "yyyyMMdd");
            String O000000o3 = bsd.O000000o(this.O00000Oo, "iKey");
            if (!TextUtils.isEmpty(O000000o3)) {
                String[] split = O000000o3.split("\\|");
                if (split == null || split.length < 2) {
                    bsd.O00000Oo(this.O00000Oo, "iKey");
                } else if (O000000o2.equals(split[0])) {
                    i += Integer.parseInt(split[1]);
                }
            }
            Context context = this.O00000Oo;
            bsd.O000000o(context, "iKey", O000000o2 + "|" + i);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o() {
        if (bww.O0000o(this.O00000Oo) == 1) {
            return true;
        }
        if (!this.O00000o0) {
            return false;
        }
        String O000000o2 = bsd.O000000o(this.O00000Oo, "iKey");
        if (TextUtils.isEmpty(O000000o2)) {
            return true;
        }
        String[] split = O000000o2.split("\\|");
        if (split == null || split.length < 2) {
            bsd.O00000Oo(this.O00000Oo, "iKey");
            return true;
        }
        return !brs.O000000o(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.O00000oO;
    }

    public final int O00000Oo() {
        int i;
        if (bww.O0000o(this.O00000Oo) == 1 || (i = this.O00000o) <= 0) {
            i = Integer.MAX_VALUE;
        }
        return this.f13277O000000o != null ? Math.max(i, this.f13277O000000o.O00000Oo()) : i;
    }
}
