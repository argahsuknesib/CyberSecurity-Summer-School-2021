package _m_j;

import androidx.recyclerview.widget.RecyclerView;

public final class awt extends awv {

    /* renamed from: O000000o  reason: collision with root package name */
    public RecyclerView.O000OOo0 f12672O000000o;
    public RecyclerView.O000OOo0 O00000Oo;
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    public int O00000oo;

    public awt(RecyclerView.O000OOo0 o000OOo0, RecyclerView.O000OOo0 o000OOo02, int i, int i2, int i3, int i4) {
        this.O00000Oo = o000OOo0;
        this.f12672O000000o = o000OOo02;
        this.O00000o0 = i;
        this.O00000o = i2;
        this.O00000oO = i3;
        this.O00000oo = i4;
    }

    public final RecyclerView.O000OOo0 O000000o() {
        RecyclerView.O000OOo0 o000OOo0 = this.O00000Oo;
        return o000OOo0 != null ? o000OOo0 : this.f12672O000000o;
    }

    public final void O000000o(RecyclerView.O000OOo0 o000OOo0) {
        if (this.O00000Oo == o000OOo0) {
            this.O00000Oo = null;
        }
        if (this.f12672O000000o == o000OOo0) {
            this.f12672O000000o = null;
        }
        if (this.O00000Oo == null && this.f12672O000000o == null) {
            this.O00000o0 = 0;
            this.O00000o = 0;
            this.O00000oO = 0;
            this.O00000oo = 0;
        }
    }

    public final String toString() {
        return "ChangeInfo{, oldHolder=" + this.O00000Oo + ", newHolder=" + this.f12672O000000o + ", fromX=" + this.O00000o0 + ", fromY=" + this.O00000o + ", toX=" + this.O00000oO + ", toY=" + this.O00000oo + '}';
    }
}
