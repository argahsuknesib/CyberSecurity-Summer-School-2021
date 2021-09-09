package com.xiaomi.smarthome.uwb.lib.mitv.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.uwb.lib.mitv.widget.LPImageView;

public class TvPadView extends RelativeLayout {
    LPImageView.PadLayoutListener mPadLayoutListener;

    public TvPadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundResource(R.drawable.pad_normal);
    }

    public void setPadViewClickListener(LPImageView.PadLayoutListener padLayoutListener) {
        this.mPadLayoutListener = padLayoutListener;
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof LPImageView) {
                ((LPImageView) getChildAt(i)).setListener(this.mPadLayoutListener);
            }
        }
    }
}
