package _m_j;

import androidx.recyclerview.widget.RecyclerView;

public final class gl implements gx {

    /* renamed from: O000000o  reason: collision with root package name */
    private final RecyclerView.O000000o f17953O000000o;

    public gl(RecyclerView.O000000o o000000o) {
        this.f17953O000000o = o000000o;
    }

    public final void O000000o(int i, int i2) {
        this.f17953O000000o.notifyItemRangeInserted(i, i2);
    }

    public final void O00000Oo(int i, int i2) {
        this.f17953O000000o.notifyItemRangeRemoved(i, i2);
    }

    public final void O00000o0(int i, int i2) {
        this.f17953O000000o.notifyItemMoved(i, i2);
    }

    public final void O000000o(int i, int i2, Object obj) {
        this.f17953O000000o.notifyItemRangeChanged(i, i2, obj);
    }
}
