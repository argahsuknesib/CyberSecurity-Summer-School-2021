package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class StateLinearLayout extends LinearLayout {
    public StateLinearLayout(Context context) {
        super(context);
    }

    public StateLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StateLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setEnabled(isEnabled());
        }
    }
}
