package com.xiaomi.smarthome.uwb.lib.mitv.widget;

import _m_j.gsy;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class LPImageView extends IRLongPressImageViewWidget {
    private PadLayoutListener mPadLayoutListener;

    public interface PadLayoutListener {
        void onActionDown(View view);

        void onActionExecute(View view, boolean z);

        void onActionUp(View view);
    }

    public LPImageView(Context context) {
        super(context);
    }

    public LPImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setListener(PadLayoutListener padLayoutListener) {
        this.mPadLayoutListener = padLayoutListener;
    }

    /* access modifiers changed from: protected */
    public void onActionExecute(boolean z) {
        gsy.O000000o(6, "LPImageView", "onActionExecute, longPress: ".concat(String.valueOf(z)));
        PadLayoutListener padLayoutListener = this.mPadLayoutListener;
        if (padLayoutListener != null) {
            padLayoutListener.onActionExecute(this, z);
        }
    }

    /* access modifiers changed from: protected */
    public void onActionDown() {
        PadLayoutListener padLayoutListener = this.mPadLayoutListener;
        if (padLayoutListener != null) {
            padLayoutListener.onActionDown(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onActionUp() {
        PadLayoutListener padLayoutListener = this.mPadLayoutListener;
        if (padLayoutListener != null) {
            padLayoutListener.onActionUp(this);
        }
    }
}
