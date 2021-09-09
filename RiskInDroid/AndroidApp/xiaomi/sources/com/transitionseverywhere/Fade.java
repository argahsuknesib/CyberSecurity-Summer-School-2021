package com.transitionseverywhere;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.xiaomi.smarthome.R;

@TargetApi(14)
public class Fade extends Visibility {
    public Fade() {
    }

    public Fade(int i) {
        O000000o(i);
    }

    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.fadingMode});
        int i = obtainStyledAttributes.getInt(0, this.O00oOoOo);
        obtainStyledAttributes.recycle();
        O000000o(i);
    }
}
