package com.google.android.material.tabs;

import _m_j.Oo;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

public class TabItem extends View {
    public final int customLayout;
    public final Drawable icon;
    public final CharSequence text;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Oo O000000o2 = Oo.O000000o(context, attributeSet, new int[]{16842754, 16842994, 16843087});
        this.text = O000000o2.O00000o0(2);
        this.icon = O000000o2.O000000o(0);
        this.customLayout = O000000o2.O0000O0o(1, 0);
        O000000o2.f12340O000000o.recycle();
    }
}
