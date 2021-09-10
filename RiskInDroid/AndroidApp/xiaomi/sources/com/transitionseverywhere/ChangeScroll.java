package com.transitionseverywhere;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;

@TargetApi(14)
public class ChangeScroll extends Transition {
    public ChangeScroll() {
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
