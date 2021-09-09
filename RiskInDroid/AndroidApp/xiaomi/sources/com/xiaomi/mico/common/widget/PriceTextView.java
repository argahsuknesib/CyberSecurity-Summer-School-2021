package com.xiaomi.mico.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class PriceTextView extends AppCompatTextView {
    private void setTextStyle(Context context) {
    }

    public PriceTextView(Context context) {
        super(context);
        setTextStyle(context);
    }

    public PriceTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setTextStyle(context);
    }

    public PriceTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setTextStyle(context);
    }
}
