package _m_j;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public final class gn {

    /* renamed from: O000000o  reason: collision with root package name */
    public final O00000Oo f18033O000000o;
    public final O000000o O00000Oo = new O000000o();
    public final List<View> O00000o0 = new ArrayList();

    public interface O00000Oo {
        int O000000o();

        int O000000o(View view);

        void O000000o(int i);

        void O000000o(View view, int i);

        void O000000o(View view, int i, ViewGroup.LayoutParams layoutParams);

        View O00000Oo(int i);

        RecyclerView.O000OOo0 O00000Oo(View view);

        void O00000Oo();

        void O00000o(View view);

        void O00000o0(int i);

        void O00000o0(View view);
    }

    public gn(O00000Oo o00000Oo) {
        this.f18033O000000o = o00000Oo;
    }

    public final void O000000o(View view) {
        this.O00000o0.add(view);
        this.f18033O000000o.O00000o0(view);
    }

    public final boolean O00000Oo(View view) {
        if (!this.O00000o0.remove(view)) {
            return false;
        }
        this.f18033O000000o.O00000o(view);
        return true;
    }

    public final void O000000o(View view, int i, boolean z) {
        int i2;
        if (i < 0) {
            i2 = this.f18033O000000o.O000000o();
        } else {
            i2 = O00000oO(i);
        }
        this.O00000Oo.O000000o(i2, z);
        if (z) {
            O000000o(view);
        }
        this.f18033O000000o.O000000o(view, i2);
    }

    private int O00000oO(int i) {
        if (i < 0) {
            return -1;
        }
        int O000000o2 = this.f18033O000000o.O000000o();
        int i2 = i;
        while (i2 < O000000o2) {
            int O00000oO = i - (i2 - this.O00000Oo.O00000oO(i2));
            if (O00000oO == 0) {
                while (this.O00000Oo.O00000o0(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += O00000oO;
        }
        return -1;
    }

    public final void O000000o(int i) {
        int O00000oO = O00000oO(i);
        View O00000Oo2 = this.f18033O000000o.O00000Oo(O00000oO);
        if (O00000Oo2 != null) {
            if (this.O00000Oo.O00000o(O00000oO)) {
                O00000Oo(O00000Oo2);
            }
            this.f18033O000000o.O000000o(O00000oO);
        }
    }

    public final View O00000Oo(int i) {
        return this.f18033O000000o.O00000Oo(O00000oO(i));
    }

    public final void O000000o(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int i2;
        if (i < 0) {
            i2 = this.f18033O000000o.O000000o();
        } else {
            i2 = O00000oO(i);
        }
        this.O00000Oo.O000000o(i2, z);
        if (z) {
            O000000o(view);
        }
        this.f18033O000000o.O000000o(view, i2, layoutParams);
    }

    public final int O000000o() {
        return this.f18033O000000o.O000000o() - this.O00000o0.size();
    }

    public final int O00000Oo() {
        return this.f18033O000000o.O000000o();
    }

    public final View O00000o0(int i) {
        return this.f18033O000000o.O00000Oo(i);
    }

    public final void O00000o(int i) {
        int O00000oO = O00000oO(i);
        this.O00000Oo.O00000o(O00000oO);
        this.f18033O000000o.O00000o0(O00000oO);
    }

    public final int O00000o0(View view) {
        int O000000o2 = this.f18033O000000o.O000000o(view);
        if (O000000o2 != -1 && !this.O00000Oo.O00000o0(O000000o2)) {
            return O000000o2 - this.O00000Oo.O00000oO(O000000o2);
        }
        return -1;
    }

    public final boolean O00000o(View view) {
        return this.O00000o0.contains(view);
    }

    public final String toString() {
        return this.O00000Oo.toString() + ", hidden list:" + this.O00000o0.size();
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public long f18034O000000o = 0;
        public O000000o O00000Oo;

        O000000o() {
        }

        public final void O000000o(int i) {
            O000000o o000000o = this;
            while (i >= 64) {
                o000000o.O000000o();
                o000000o = o000000o.O00000Oo;
                i -= 64;
            }
            o000000o.f18034O000000o |= 1 << i;
        }

        private void O000000o() {
            if (this.O00000Oo == null) {
                this.O00000Oo = new O000000o();
            }
        }

        public final void O00000Oo(int i) {
            O000000o o000000o = this;
            while (i >= 64) {
                o000000o = o000000o.O00000Oo;
                if (o000000o != null) {
                    i -= 64;
                } else {
                    return;
                }
            }
            o000000o.f18034O000000o &= (1 << i) ^ -1;
        }

        public final boolean O00000o0(int i) {
            O000000o o000000o = this;
            while (i >= 64) {
                o000000o.O000000o();
                o000000o = o000000o.O00000Oo;
                i -= 64;
            }
            return (o000000o.f18034O000000o & (1 << i)) != 0;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(int i, boolean z) {
            boolean z2 = z;
            O000000o o000000o = this;
            while (true) {
                if (i >= 64) {
                    o000000o.O000000o();
                    o000000o = o000000o.O00000Oo;
                    i -= 64;
                } else {
                    boolean z3 = (o000000o.f18034O000000o & Long.MIN_VALUE) != 0;
                    long j = (1 << i) - 1;
                    long j2 = o000000o.f18034O000000o;
                    o000000o.f18034O000000o = ((j2 & (j ^ -1)) << 1) | (j2 & j);
                    if (z2) {
                        o000000o.O000000o(i);
                    } else {
                        o000000o.O00000Oo(i);
                    }
                    if (z3 || o000000o.O00000Oo != null) {
                        o000000o.O000000o();
                        o000000o = o000000o.O00000Oo;
                        z2 = z3;
                        i = 0;
                    } else {
                        return;
                    }
                }
            }
        }

        public final boolean O00000o(int i) {
            O000000o o000000o = this;
            while (i >= 64) {
                o000000o.O000000o();
                o000000o = o000000o.O00000Oo;
                i -= 64;
            }
            long j = 1 << i;
            boolean z = (o000000o.f18034O000000o & j) != 0;
            o000000o.f18034O000000o &= j ^ -1;
            long j2 = j - 1;
            long j3 = o000000o.f18034O000000o;
            o000000o.f18034O000000o = Long.rotateRight(j3 & (j2 ^ -1), 1) | (j3 & j2);
            O000000o o000000o2 = o000000o.O00000Oo;
            if (o000000o2 != null) {
                if (o000000o2.O00000o0(0)) {
                    o000000o.O000000o(63);
                }
                o000000o.O00000Oo.O00000o(0);
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        public final int O00000oO(int i) {
            O000000o o000000o = this.O00000Oo;
            if (o000000o == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f18034O000000o);
                }
                return Long.bitCount(this.f18034O000000o & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.f18034O000000o & ((1 << i) - 1));
            } else {
                return o000000o.O00000oO(i - 64) + Long.bitCount(this.f18034O000000o);
            }
        }

        public final String toString() {
            if (this.O00000Oo == null) {
                return Long.toBinaryString(this.f18034O000000o);
            }
            return this.O00000Oo.toString() + "xx" + Long.toBinaryString(this.f18034O000000o);
        }
    }
}
