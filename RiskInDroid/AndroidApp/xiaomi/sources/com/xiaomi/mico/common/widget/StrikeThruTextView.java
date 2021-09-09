package com.xiaomi.mico.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class StrikeThruTextView extends AppCompatTextView {
    public StrikeThruTextView(Context context) {
        super(context);
        getPaint().setFlags(16);
    }

    public StrikeThruTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        getPaint().setFlags(16);
    }

    public StrikeThruTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        getPaint().setFlags(16);
    }
}
