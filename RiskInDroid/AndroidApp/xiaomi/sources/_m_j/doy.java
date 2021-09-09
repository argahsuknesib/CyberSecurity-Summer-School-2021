package _m_j;

import android.view.View;
import com.tmall.wireless.vaf.framework.VafContext;

public abstract class doy {

    /* renamed from: O000000o  reason: collision with root package name */
    protected VafContext f14822O000000o;
    protected boolean O00000Oo = true;
    protected don O00000o;
    protected int O00000o0 = 0;

    public abstract int O000000o();

    public abstract void O000000o(O000000o o000000o, int i);

    public abstract void O000000o(Object obj);

    public int O00000Oo(int i) {
        return 0;
    }

    public abstract O000000o O00000o0(int i);

    public doy(VafContext vafContext) {
        this.O00000o = vafContext.O0000OoO();
        this.f14822O000000o = vafContext;
    }

    public final void O000000o(int i) {
        this.O00000o0 = i;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public View f14823O000000o;
        public int O00000Oo;
        public int O00000o0;

        public O000000o(View view) {
            this.f14823O000000o = view;
            this.f14823O000000o.setTag(this);
        }
    }
}
