package com.xiaomi.smarthome.newui.widget;

import _m_j.gpc;
import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class MainCollapseBarLayout extends CollapsingToolbarLayout {
    public MainCollapseBarLayout(Context context) {
        super(context);
    }

    public MainCollapseBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public MainCollapseBarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        setMinimumHeight(gpc.O000000o(5.0f));
    }
}
