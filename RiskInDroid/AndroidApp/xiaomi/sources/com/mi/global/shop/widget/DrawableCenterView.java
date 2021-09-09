package com.mi.global.shop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public class DrawableCenterView extends CustomTextView {
    public DrawableCenterView(Context context) {
        super(context);
    }

    public DrawableCenterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DrawableCenterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Drawable drawable;
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (!(compoundDrawables == null || (drawable = compoundDrawables[0]) == null)) {
            canvas.translate((((float) getWidth()) - ((getPaint().measureText(getText().toString()) + ((float) drawable.getIntrinsicWidth())) + ((float) getCompoundDrawablePadding()))) / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }
}
