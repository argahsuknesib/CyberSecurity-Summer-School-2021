package _m_j;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public final class gv {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f18328O000000o = true;
    public int O00000Oo;
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    public int O00000oo = 0;
    public int O0000O0o = 0;
    public boolean O0000OOo;
    public boolean O0000Oo0;

    public final boolean O000000o(RecyclerView.O000OO0o o000OO0o) {
        int i = this.O00000o0;
        return i >= 0 && i < o000OO0o.O000000o();
    }

    public final View O000000o(RecyclerView.O000O0OO o000o0oo) {
        View O00000o02 = o000o0oo.O00000o0(this.O00000o0);
        this.O00000o0 += this.O00000o;
        return O00000o02;
    }

    public final String toString() {
        return "LayoutState{mAvailable=" + this.O00000Oo + ", mCurrentPosition=" + this.O00000o0 + ", mItemDirection=" + this.O00000o + ", mLayoutDirection=" + this.O00000oO + ", mStartLine=" + this.O00000oo + ", mEndLine=" + this.O0000O0o + '}';
    }
}
