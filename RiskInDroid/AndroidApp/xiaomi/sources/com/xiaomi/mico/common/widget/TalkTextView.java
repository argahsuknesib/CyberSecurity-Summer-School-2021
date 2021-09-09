package com.xiaomi.mico.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class TalkTextView extends AppCompatTextView {
    private void setTextStyle() {
    }

    public TalkTextView(Context context) {
        super(context);
        setTextStyle();
    }

    public TalkTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setTextStyle();
    }

    public TalkTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setTextStyle();
    }
}
