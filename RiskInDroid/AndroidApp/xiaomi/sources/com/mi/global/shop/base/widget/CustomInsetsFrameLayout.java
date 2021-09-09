package com.mi.global.shop.base.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public final class CustomInsetsFrameLayout extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private int[] f4838O000000o = new int[4];

    public CustomInsetsFrameLayout(Context context) {
        super(context);
    }

    public CustomInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int[] getInsets() {
        return this.f4838O000000o;
    }

    /* access modifiers changed from: protected */
    public final boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f4838O000000o[0] = rect.left;
            this.f4838O000000o[1] = rect.top;
            this.f4838O000000o[2] = rect.right;
            rect.left = 0;
            rect.top = 0;
            rect.right = 0;
        }
        return super.fitSystemWindows(rect);
    }
}
