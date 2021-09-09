package com.transitionseverywhere;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.xiaomi.smarthome.R;

public class ArcMotion extends PathMotion {
    private static final float O00000Oo = ((float) Math.tan(Math.toRadians(35.0d)));
    private float O00000o = 0.0f;
    private float O00000o0 = 0.0f;
    private float O00000oO = 70.0f;
    private float O00000oo = 0.0f;
    private float O0000O0o = 0.0f;
    private float O0000OOo = O00000Oo;

    public ArcMotion() {
    }

    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.maximumAngle, R.attr.minimumHorizontalAngle, R.attr.minimumVerticalAngle});
        float f = obtainStyledAttributes.getFloat(2, 0.0f);
        this.O00000o = f;
        this.O0000O0o = O000000o(f);
        float f2 = obtainStyledAttributes.getFloat(1, 0.0f);
        this.O00000o0 = f2;
        this.O00000oo = O000000o(f2);
        float f3 = obtainStyledAttributes.getFloat(0, 70.0f);
        this.O00000oO = f3;
        this.O0000OOo = O000000o(f3);
        obtainStyledAttributes.recycle();
    }

    private static float O000000o(float f) {
        if (f >= 0.0f && f <= 90.0f) {
            return (float) Math.tan(Math.toRadians((double) (f / 2.0f)));
        }
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }
}
