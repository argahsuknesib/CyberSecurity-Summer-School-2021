package com.transitionseverywhere.extra;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.transitionseverywhere.Visibility;
import com.xiaomi.smarthome.R;

@TargetApi(14)
public class Scale extends Visibility {

    /* renamed from: O000000o  reason: collision with root package name */
    private float f5913O000000o = 0.0f;

    public Scale() {
    }

    public Scale(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.disappearedScale});
        float f = obtainStyledAttributes.getFloat(0, this.f5913O000000o);
        if (f >= 0.0f) {
            this.f5913O000000o = f;
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalArgumentException("disappearedScale cannot be negative!");
    }
}
