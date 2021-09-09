package _m_j;

import android.content.Context;
import android.text.TextUtils;

public final class btv extends btw {
    private int O00000Oo;
    private String O00000o;
    private long O00000o0;
    private Context O00000oO;

    public btv(Context context, int i, String str, btw btw) {
        super(btw);
        this.O00000Oo = i;
        this.O00000o = str;
        this.O00000oO = context;
    }

    public final void O000000o(boolean z) {
        super.O000000o(z);
        if (z) {
            String str = this.O00000o;
            long currentTimeMillis = System.currentTimeMillis();
            this.O00000o0 = currentTimeMillis;
            bsd.O000000o(this.O00000oO, str, String.valueOf(currentTimeMillis));
        }
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o() {
        long j = 0;
        if (this.O00000o0 == 0) {
            String O000000o2 = bsd.O000000o(this.O00000oO, this.O00000o);
            if (!TextUtils.isEmpty(O000000o2)) {
                j = Long.parseLong(O000000o2);
            }
            this.O00000o0 = j;
        }
        return System.currentTimeMillis() - this.O00000o0 >= ((long) this.O00000Oo);
    }
}
