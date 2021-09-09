package _m_j;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
public final class cx {

    /* renamed from: O000000o  reason: collision with root package name */
    public OverScroller f14386O000000o;

    @Deprecated
    public static cx O000000o(Context context, Interpolator interpolator) {
        return new cx(context, interpolator);
    }

    private cx(Context context, Interpolator interpolator) {
        this.f14386O000000o = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    @Deprecated
    public final void O000000o(int i, int i2, int i3, int i4, int i5) {
        this.f14386O000000o.startScroll(i, i2, i3, i4, i5);
    }

    @Deprecated
    public final void O000000o(int i, int i2, int i3) {
        this.f14386O000000o.fling(0, i, 0, i2, 0, 0, 0, i3, 0, 0);
    }
}
