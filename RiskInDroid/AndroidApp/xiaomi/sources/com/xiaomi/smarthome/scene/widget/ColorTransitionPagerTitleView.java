package com.xiaomi.smarthome.scene.widget;

import _m_j.hrm;
import android.content.Context;
import android.graphics.Typeface;

public class ColorTransitionPagerTitleView extends SimplePagerTitleView {
    public ColorTransitionPagerTitleView(Context context) {
        super(context);
    }

    public void onLeave(int i, int i2, float f, boolean z) {
        setTextColor(hrm.O000000o(f, this.mSelectedColor, this.mNormalColor));
    }

    public void onEnter(int i, int i2, float f, boolean z) {
        setTextColor(hrm.O000000o(f, this.mNormalColor, this.mSelectedColor));
    }

    public void onSelected(int i, int i2) {
        setTypeface(Typeface.DEFAULT_BOLD);
    }

    public void onDeselected(int i, int i2) {
        setTypeface(Typeface.DEFAULT);
    }
}
