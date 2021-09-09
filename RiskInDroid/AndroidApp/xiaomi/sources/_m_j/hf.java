package _m_j;

import android.view.View;

public final class hf {

    /* renamed from: O000000o  reason: collision with root package name */
    final O00000Oo f18857O000000o;
    O000000o O00000Oo = new O000000o();

    public interface O00000Oo {
        int O000000o();

        int O000000o(View view);

        View O000000o(int i);

        int O00000Oo();

        int O00000Oo(View view);
    }

    public hf(O00000Oo o00000Oo) {
        this.f18857O000000o = o00000Oo;
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f18858O000000o = 0;
        int O00000Oo;
        int O00000o;
        int O00000o0;
        int O00000oO;

        private static int O000000o(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        O000000o() {
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(int i, int i2, int i3, int i4) {
            this.O00000Oo = i;
            this.O00000o0 = i2;
            this.O00000o = i3;
            this.O00000oO = i4;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(int i) {
            this.f18858O000000o = i | this.f18858O000000o;
        }

        /* access modifiers changed from: package-private */
        public final boolean O000000o() {
            int i = this.f18858O000000o;
            if ((i & 7) != 0 && (i & (O000000o(this.O00000o, this.O00000Oo) << 0)) == 0) {
                return false;
            }
            int i2 = this.f18858O000000o;
            if ((i2 & 112) != 0 && (i2 & (O000000o(this.O00000o, this.O00000o0) << 4)) == 0) {
                return false;
            }
            int i3 = this.f18858O000000o;
            if ((i3 & 1792) != 0 && (i3 & (O000000o(this.O00000oO, this.O00000Oo) << 8)) == 0) {
                return false;
            }
            int i4 = this.f18858O000000o;
            if ((i4 & 28672) == 0 || (i4 & (O000000o(this.O00000oO, this.O00000o0) << 12)) != 0) {
                return true;
            }
            return false;
        }
    }

    public final View O000000o(int i, int i2, int i3, int i4) {
        int O000000o2 = this.f18857O000000o.O000000o();
        int O00000Oo2 = this.f18857O000000o.O00000Oo();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View O000000o3 = this.f18857O000000o.O000000o(i);
            this.O00000Oo.O000000o(O000000o2, O00000Oo2, this.f18857O000000o.O000000o(O000000o3), this.f18857O000000o.O00000Oo(O000000o3));
            if (i3 != 0) {
                O000000o o000000o = this.O00000Oo;
                o000000o.f18858O000000o = 0;
                o000000o.O000000o(i3);
                if (this.O00000Oo.O000000o()) {
                    return O000000o3;
                }
            }
            if (i4 != 0) {
                O000000o o000000o2 = this.O00000Oo;
                o000000o2.f18858O000000o = 0;
                o000000o2.O000000o(i4);
                if (this.O00000Oo.O000000o()) {
                    view = O000000o3;
                }
            }
            i += i5;
        }
        return view;
    }

    public final boolean O000000o(View view) {
        this.O00000Oo.O000000o(this.f18857O000000o.O000000o(), this.f18857O000000o.O00000Oo(), this.f18857O000000o.O000000o(view), this.f18857O000000o.O00000Oo(view));
        O000000o o000000o = this.O00000Oo;
        o000000o.f18858O000000o = 0;
        o000000o.O000000o(24579);
        return this.O00000Oo.O000000o();
    }
}
