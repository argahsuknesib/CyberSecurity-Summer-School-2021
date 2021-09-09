package com.youth.banner;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class BannerScroller extends Scroller {
    private int mDuration = 800;

    public BannerScroller(Context context) {
        super(context);
    }

    public BannerScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    public BannerScroller(Context context, Interpolator interpolator, boolean z) {
        super(context, interpolator, z);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.mDuration);
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.mDuration);
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }
}
