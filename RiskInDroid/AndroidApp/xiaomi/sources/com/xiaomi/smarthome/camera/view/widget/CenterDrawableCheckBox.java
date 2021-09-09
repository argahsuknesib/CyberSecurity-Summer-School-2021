package com.xiaomi.smarthome.camera.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class CenterDrawableCheckBox extends CheckBox {
    public CenterDrawableCheckBox(Context context) {
        super(context);
    }

    public CenterDrawableCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CenterDrawableCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public CenterDrawableCheckBox(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables != null) {
            if (compoundDrawables[0] != null) {
                drawDrawableInCenter(canvas, (((float) getWidth()) - (((!TextUtils.isEmpty(getText()) ? getPaint().measureText(getText().toString()) : 0.0f) + ((float) getCompoundDrawablePadding())) + ((float) compoundDrawables[0].getIntrinsicWidth()))) / 2.0f, 0.0f);
            } else if (compoundDrawables[1] != null) {
                Rect rect = new Rect();
                if (!TextUtils.isEmpty(getText())) {
                    getPaint().getTextBounds(getText().toString(), 0, getText().toString().length(), rect);
                }
                drawDrawableInCenter(canvas, 0.0f, (((float) getHeight()) - ((float) ((rect.height() + getCompoundDrawablePadding()) + compoundDrawables[1].getIntrinsicHeight()))) / 2.0f);
            } else if (compoundDrawables[2] != null) {
                drawDrawableInCenter(canvas, (-(((float) getWidth()) - (((!TextUtils.isEmpty(getText()) ? getPaint().measureText(getText().toString()) : 0.0f) + ((float) getCompoundDrawablePadding())) + ((float) compoundDrawables[2].getIntrinsicWidth())))) / 2.0f, 0.0f);
            } else if (compoundDrawables[3] != null) {
                Rect rect2 = new Rect();
                if (!TextUtils.isEmpty(getText())) {
                    getPaint().getTextBounds(getText().toString(), 0, getText().toString().length(), rect2);
                }
                drawDrawableInCenter(canvas, 0.0f, (-(((float) getHeight()) - ((float) ((rect2.height() + getCompoundDrawablePadding()) + compoundDrawables[3].getIntrinsicHeight())))) / 2.0f);
            }
        }
        super.onDraw(canvas);
    }

    private void drawDrawableInCenter(Canvas canvas, float f, float f2) {
        if (canvas != null) {
            canvas.translate(f, f2);
        }
    }
}
