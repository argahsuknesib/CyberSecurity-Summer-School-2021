package com.xiaomi.shopviews.widget.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint({"AppCompatCustomView"})
public class EasyTextView extends TextView {
    public EasyTextView(Context context) {
        super(context);
    }

    public EasyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EasyTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (TextUtils.isEmpty(charSequence)) {
            super.setText("", bufferType);
        }
        super.setText(charSequence, bufferType);
    }
}
