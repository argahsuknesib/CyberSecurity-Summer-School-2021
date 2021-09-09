package com.xiaomi.smarthome.library.common.widget;

import _m_j.gri;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AdjustImageView extends ImageView {
    public AdjustImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int O000000o2 = gri.O000000o((Activity) getContext()).x - (gri.O000000o(17.0f) * 2);
        setMeasuredDimension(O000000o2, (int) (((float) O000000o2) * 0.409f));
    }
}
