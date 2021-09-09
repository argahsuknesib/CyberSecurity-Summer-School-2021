package _m_j;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class hd extends RecyclerView.O0000OOo {
    public boolean O0000o00 = true;

    public abstract boolean O000000o(RecyclerView.O000OOo0 o000OOo0);

    public abstract boolean O000000o(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3, int i4);

    public abstract boolean O000000o(RecyclerView.O000OOo0 o000OOo0, RecyclerView.O000OOo0 o000OOo02, int i, int i2, int i3, int i4);

    public abstract boolean O00000Oo(RecyclerView.O000OOo0 o000OOo0);

    public final boolean O0000O0o(RecyclerView.O000OOo0 o000OOo0) {
        return !this.O0000o00 || o000OOo0.isInvalid();
    }

    public final boolean O000000o(RecyclerView.O000OOo0 o000OOo0, RecyclerView.O0000OOo.O00000Oo o00000Oo, RecyclerView.O0000OOo.O00000Oo o00000Oo2) {
        int i = o00000Oo.f2944O000000o;
        int i2 = o00000Oo.O00000Oo;
        View view = o000OOo0.itemView;
        int left = o00000Oo2 == null ? view.getLeft() : o00000Oo2.f2944O000000o;
        int top = o00000Oo2 == null ? view.getTop() : o00000Oo2.O00000Oo;
        if (o000OOo0.isRemoved() || (i == left && i2 == top)) {
            return O000000o(o000OOo0);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return O000000o(o000OOo0, i, i2, left, top);
    }

    public final boolean O00000Oo(RecyclerView.O000OOo0 o000OOo0, RecyclerView.O0000OOo.O00000Oo o00000Oo, RecyclerView.O0000OOo.O00000Oo o00000Oo2) {
        if (o00000Oo == null || (o00000Oo.f2944O000000o == o00000Oo2.f2944O000000o && o00000Oo.O00000Oo == o00000Oo2.O00000Oo)) {
            return O00000Oo(o000OOo0);
        }
        return O000000o(o000OOo0, o00000Oo.f2944O000000o, o00000Oo.O00000Oo, o00000Oo2.f2944O000000o, o00000Oo2.O00000Oo);
    }

    public final boolean O00000o0(RecyclerView.O000OOo0 o000OOo0, RecyclerView.O0000OOo.O00000Oo o00000Oo, RecyclerView.O0000OOo.O00000Oo o00000Oo2) {
        if (o00000Oo.f2944O000000o == o00000Oo2.f2944O000000o && o00000Oo.O00000Oo == o00000Oo2.O00000Oo) {
            O00000oo(o000OOo0);
            return false;
        }
        return O000000o(o000OOo0, o00000Oo.f2944O000000o, o00000Oo.O00000Oo, o00000Oo2.f2944O000000o, o00000Oo2.O00000Oo);
    }

    public final boolean O000000o(RecyclerView.O000OOo0 o000OOo0, RecyclerView.O000OOo0 o000OOo02, RecyclerView.O0000OOo.O00000Oo o00000Oo, RecyclerView.O0000OOo.O00000Oo o00000Oo2) {
        int i;
        int i2;
        int i3 = o00000Oo.f2944O000000o;
        int i4 = o00000Oo.O00000Oo;
        if (o000OOo02.shouldIgnore()) {
            int i5 = o00000Oo.f2944O000000o;
            i = o00000Oo.O00000Oo;
            i2 = i5;
        } else {
            i2 = o00000Oo2.f2944O000000o;
            i = o00000Oo2.O00000Oo;
        }
        return O000000o(o000OOo0, o000OOo02, i3, i4, i2, i);
    }
}
