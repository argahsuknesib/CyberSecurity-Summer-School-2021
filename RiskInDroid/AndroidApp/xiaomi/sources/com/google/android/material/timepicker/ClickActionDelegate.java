package com.google.android.material.timepicker;

import _m_j.bh;
import _m_j.cl;
import android.content.Context;
import android.view.View;

class ClickActionDelegate extends bh {
    private final cl.O000000o clickAction;

    public ClickActionDelegate(Context context, int i) {
        this.clickAction = new cl.O000000o(16, context.getString(i));
    }

    public void onInitializeAccessibilityNodeInfo(View view, cl clVar) {
        super.onInitializeAccessibilityNodeInfo(view, clVar);
        clVar.O000000o(this.clickAction);
    }
}
