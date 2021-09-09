package _m_j;

import android.os.Build;

public final class iok {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final O000000o f1518O000000o;
    private static final O00000Oo O00000Oo;
    private ipz O00000o0;

    public interface O000000o {
    }

    public interface O00000Oo {
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            f1518O000000o = new ipm();
        } else {
            f1518O000000o = new ipl();
        }
        if (Build.VERSION.SDK_INT >= 23) {
            O00000Oo = new ipo();
        } else {
            O00000Oo = new ipn();
        }
    }

    iok(ipz ipz) {
        this.O00000o0 = ipz;
    }

    public final ipw O000000o() {
        return new ipw(this.O00000o0);
    }
}
