package com.mibigkoo.convenientbanner;

import android.content.Context;
import android.widget.Scroller;

public class ViewPagerScroller extends Scroller {

    /* renamed from: O000000o  reason: collision with root package name */
    int f5183O000000o = 800;
    private boolean O00000Oo;

    public ViewPagerScroller(Context context) {
        super(context);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.O00000Oo ? 0 : this.f5183O000000o);
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.O00000Oo ? 0 : this.f5183O000000o);
    }
}
