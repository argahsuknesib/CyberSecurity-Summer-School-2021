package _m_j;

import android.content.Context;
import android.widget.Scroller;

public final class ll extends Scroller {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f2168O000000o = 1000;

    public ll(Context context, int i) {
        super(context);
        this.f2168O000000o = i;
    }

    public final void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.f2168O000000o);
    }

    public final void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.f2168O000000o);
    }
}
